package org.xubo.other.testAdam

//object AdamExample {
//
//}

// 	package nl.surfsara.spark

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.adam.projections.Projection
import org.bdgenomics.adam.projections.AlignmentRecordField

object AdamExample {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("AdamExample").setMaster("local")
    //	val conf = new SparkConf().setAppName("AdamExample").setMaster("spark://219.219.220.149:7077")
    //    val conf = new SparkConf().setAppName("AdamExample")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)

    // Read some reads. These come from a 1000genomes BAM file and were converted earlier
    //	val reads = ac.loadAlignments("/user/mathijsk/NA21144.chrom11.ILLUMINA.adam")
    val reads = ac.loadAlignments("hdfs://219.219.220.149:9000/xubo/adam/output/small.adam")
    reads.cache();

    val kmers = reads.flatMap { read =>
      read.getSequence.sliding(21).map(k => (k, 1L))
    }.reduceByKey((k1: Long, k2: Long) => k1 + k2)
      .map(_.swap)
      .sortByKey(ascending = false)
    // Print the top 10 most common 21-mers
    kmers.take(10).foreach(println)
    kmers.saveAsTextFile("hdfs://219.219.220.149:9000/xubo/adam/output/small.adam.kmers21")
  }
}