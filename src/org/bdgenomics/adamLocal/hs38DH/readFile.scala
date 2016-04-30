package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object readFile {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ReadFile").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    val file1 = "file/adam/hs38DH/hs38DHL3.fa"
    //load by SparkContext textFile
    val fq0 = sc.textFile(file1)
    //    fq0.foreach(println)
    println("fq0.count:" + fq0.count);

    //load Fasta
    val fq1 = ac.loadFasta(file1, 10000)
    println("fq1.partitions:" + fq1.partitions);
    println("fq1.partitions length:" + fq1.partitions.length);
    println("fq1.count:" + fq1.count);
    fq1.foreach(println)
    //    val kmers = fq1.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
    //    kmers.take(10).foreach(println)
    //    println(fq1.getStorageLevel)

    //    println(fq1.toDebugString)
    var fq1Segquence = fq1.map(_.getFragmentSequence())
    //        fq1Segquence.foreach(println)
    println("fq1Segquence.count:" + fq1Segquence.count);
    println("fq1Segquence.id:" + fq1Segquence.id);
    println("fq1Segquence.name:" + fq1Segquence.name)
    println("fq1Segquence.partitioner:" + fq1Segquence.partitioner)

    fq1Segquence = fq1Segquence.filter(_ != " ")
    println("fq1Segquence.count:" + fq1Segquence.count);
    //fq1.
    //    val fq1collect=fq1.collect

    val lengthN = 10;
    var printLength = lengthN
    if (fq1Segquence.count.toInt > lengthN) { printLength = lengthN } else { printLength = fq1Segquence.count.toInt }
    for (i <- 0 until printLength) {
      //      println(i + ":" + (fq1Segquence.take(i)).takeRight(1)); 
      //      println("i:" + i);
      val order = fq1Segquence.take(i + 1).takeRight(1)
      for (j <- order) {
        println("i:" + i + "; length:" + j.length() + "; sequence:" + j);
        //        println(fq1collect.take(i+1).takeRight(1));
      }
      //      println(i + ":" + (fq1Segquence.takeOrdered(i)))
    }
    sc.stop
  }
}