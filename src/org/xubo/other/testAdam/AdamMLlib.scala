//package nl.surfsara.spark
package org.xubo.other.testAdam
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.adam.projections.Projection
import org.bdgenomics.adam.projections.AlignmentRecordField
import scala.io.Source
import org.apache.spark.rdd.RDD
import org.bdgenomics.formats.avro.Genotype
import scala.collection.JavaConverters._
import org.bdgenomics.formats.avro._
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.linalg.{ Vector => MLVector, Vectors }
import org.apache.spark.mllib.clustering.{ KMeans, KMeansModel }

object AdamMLlib {
  def main(args: Array[String]) {
    // Set up Spark and Adam
    val conf = new SparkConf().setAppName("AdamClustering").setMaster("local")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)

    // Load the prepared genotypes in an RRD, cache this RRD.
    //    val genotypes: RDD[Genotype] = ac.loadGenotypes("/user/mathijsk/ALL.chr22.phase1.projectConsensus.genotypes.vcf.adam")
    val genotypes: RDD[Genotype] = ac.loadGenotypes("/xubo/adam/output/other/smallvcf.adam")
    genotypes.cache();
    println("First id: " + genotypes.first().sampleId)

    val c = genotypes.map(g => g.getSampleId.toString().hashCode()).distinct().count()
    println("Num samples total: " + c)

    // Select an arbitrary slice of the chromosome to limit dataset size/
    val start = 10000000
    val end = 17000000
    //val start = 1
    //val end = 1000000

    val sampledGts = genotypes.filter(g => (g.getVariant.getStart >= start && g.getVariant.getEnd <= end))

    // Simple k-means will not work if we do not flatten the structure. Select only three populations and train
    // the k-means with three clusters. We are interested in demonstrating Adam and MLlib, not discovering something new in the data 
    val pops = Set("GBR", "ASW", "CHB")
    val panel = Source.fromFile("/xubo/adam/examples/interim_phase1.20101123.ALL.panel").getLines().map(line => {
      val toks = line.split("\t").toList
      toks(0) -> toks(1)
    }).toMap

    val selectedSamples = panel.filter(tup => pops.contains(tup._2))

    // Broadcast the panel to all executors
    val bPanel = sc.broadcast(selectedSamples)

    // Filter the genotypes for the selected populations (sampleIds)
    val finalGts = sampledGts.filter(g => bPanel.value.contains(g.getSampleId))

    val sampleCount = finalGts.map(_.getSampleId.toString.hashCode).distinct.count
    println("Num samples in filtered set: " + sampleCount)

    // We still have to deal with missing variants. Exclude those variants that do not have data for all samples
    val variantsById = finalGts.keyBy(g => variantId(g).hashCode).groupByKey.cache
    val missingVariantsRDD = variantsById.filter { case (k, it) => it.size != sampleCount }.keys

    val missingVariants = missingVariantsRDD.collect().toSet

    val completeGts = finalGts.filter { g => !(missingVariants contains variantId(g).hashCode) }

    // Feature extraction: Before running the clustering algorithm (K-Means), we need to transform the data from a flat representation (RDD of genotypes) to
    // a more structured one, matching the input requirements of MLLib training methods. Each sample must be represented by a vector of features in a space 
    // with a defined metric. MLLib relies on the breeze library for linear algebra and the euclidian metric is the one provided. Usually a Mahanatan distance is used in genetics,
    // with genotypes encoded as 0, 1 or 2 (1 being the heterozygote). The asDouble(Genotype) function does the genotype encoding. The rdd tranformations to obtain encoded 
    // genotypes, grouped by sampleId are:
    val sampleToData: RDD[(String, (Double, Int))] =
      completeGts.map { g => (g.getSampleId.toString, (asDouble(g), variantId(g).hashCode)) }

    val groupedSampleToData = sampleToData.groupByKey

    val dataPerSampleId: RDD[(String, MLVector)] =
      groupedSampleToData.mapValues { it =>
        makeSortedVector(it)
      }

    // Construct a dataframe from the vectors
    val dataFrame: RDD[MLVector] = dataPerSampleId.values

    // Next train the k-means model with k=3 for 10 iterations
    val model: KMeansModel = KMeans.train(dataFrame, 3, 10)

    // Get the predictions for our data. In order to check whether the samples clusters match the samples populations, we used the model to predict the cluster 
    // of each sample and compared these with the population label of the sample. There is one prediction for each sample (the key of the predictions RDD), as value
    // we keep the predicted class (the cluster number as Int) and the population label:
    val predictions: RDD[(String, (Int, String))] = dataPerSampleId.map(elt => {
      (elt._1, (model.predict(elt._2), bPanel.value.getOrElse(elt._1, "")))
    })

    // Now construct and print the confusion matrix. Count of cluster assignments per population. 
    val confMat = predictions.collect.toMap.values
      .groupBy(_._2).mapValues(_.map(_._1))
      .mapValues(xs => (1 to 3).map(i => xs.count(_ == i - 1)).toList)

    for ((k, v) <- confMat) {
      print("k : " + k + " -> [")
      v.foreach { x => print(x + ", ") }
      print("]\n")
    }
  }

  def makeSortedVector(gts: Iterable[(Double, Int)]): MLVector = Vectors.dense(gts.toArray.sortBy(_._2).map(_._1))

  def asDouble(g: Genotype): Double = g.getAlleles.asScala.count(_ != GenotypeAllele.Ref)

  def variantId(g: Genotype): String = {
    val name = g.getVariant.getContig.getContigName
    val start = g.getVariant.getStart
    val end = g.getVariant.getEnd
    s"$name:$start:$end"
  }

}