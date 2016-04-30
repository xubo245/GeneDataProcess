package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object readFileFromFastaThreeLines {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFastaThreeLines").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)

    //load by SparkContext textFile
    val fq0 = sc.textFile("file/adam/hs38DH/hs38DHL3.fa")
    fq0.foreach(println)

    //load Fasta
    val fq1 = ac.loadFasta("file/adam/hs38DH/hs38DHL3.fa", 10000)
    println(fq1.count);
    //    val kmers = fq1.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
    //    kmers.take(10).foreach(println)
    //    println(fq1.getStorageLevel)

    println(fq1.toDebugString)
    val fq1Segquence = fq1.map(_.getFragmentSequence())
    fq1Segquence.foreach(println)
    //    fq1.
    for (i <- fq1) {
      println(i);
      println(i.getFragmentSequence());
    }
    sc.stop
  }
}