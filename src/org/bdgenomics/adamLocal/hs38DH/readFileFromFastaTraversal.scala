package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object readFileFromFastaTraversal {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFastaTraversal").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)

    //load by SparkContext textFile
    val fq0 = sc.textFile("file/adam/hs38DH/hs38DHL3.fa")
    //    fq0.foreach(println)
    println(fq0.count);

    //load Fasta
    val fq1 = ac.loadFasta("file/adam/hs38DH/hs38DHL3.fa", 10000)
    println(fq1.count);
    //    val kmers = fq1.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
    //    kmers.take(10).foreach(println)
    //    println(fq1.getStorageLevel)

    //    println(fq1.toDebugString)
    val fq1Segquence = fq1.map(_.getFragmentSequence())
    fq1Segquence.foreach(println)
    println(fq1Segquence.count);
    println(fq1Segquence.id);
    //      fq1Segquence.iterator(split, context)
    println(fq1Segquence.name)
    println(fq1Segquence.partitioner)

    for (i <- 0 until fq1Segquence.count.toInt) {
      //      println(i + ":" + (fq1Segquence.take(i)).takeRight(1)); 
      println("i:" + i);
      val order = fq1Segquence.take(i + 1).takeRight(1)
      for (j <- 0 until order.length) {
        println("j:" + j + ":" + order(j));
      }
      //      println(i + ":" + (fq1Segquence.takeOrdered(i)))
    }
    sc.stop
  }
}