package org.bdgenomics.adamLocal.GRCH38

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
import org.apache.tools.ant.taskdefs.Length
//import scala.collection.parallel.Foreach

object readFileFromGRCH38All {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromGRCH38All")
    //      .setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    //    val file1 = "file/adam/hs38DH/hs38DH.fa"
    //    val file1 = "hdfs://219.219.220.149:9000/xubo/adam/hs38DH/hs38DH.fa"
    val file1 = "hdfs://219.219.220.149:9000/xubo/data/GRCH38/bwa/GCA_000001405.15_GRCh38/GCA_000001405.15_GRCh38_full_analysis_set.fna"

    //load by SparkContext textFile
    val fq0 = sc.textFile(file1)
    //    fq0.foreach(println)
    println("fq0.count:" + fq0.count);

    //load Fasta
    val fq1 = ac.loadFasta(file1, 10000)
    //    println("fq1.partitions:" + fq1.partitions);
    //    println("fq1.partitions length:" + fq1.partitions.length);
    //    println("fq1.count:" + fq1.count);
    //    fq1.foreach(println)

    var startTime = System.currentTimeMillis();
    var endTime = System.currentTimeMillis();

    //methods 3
    startTime = System.currentTimeMillis();
    var fq3Sequence = fq1.map(_.getFragmentLength()).collect
    val fq3Length = fq3Sequence.length
    var sum3 = fq3Sequence.map(a => a.toDouble).sum;

    //    for (i <- 0 until fq3Length) {
    //      sum2 = sum2 + fq3Sequence(i)
    //    }
    endTime = System.currentTimeMillis();
    println("Method 3=> Length:" + fq3Length + " sum3:" + sum3 + " time:" + (endTime - startTime) + "ms");

    //method 2
    startTime = System.currentTimeMillis();
    var fq2Sequence = fq1.map(_.getFragmentLength()).collect
    val fq2Length = fq2Sequence.length
    //    println("fq2Sequence.count:" + fq2Length);
    var sum2 = 0L;
    //    fq2Sequence.foreach(println)
    for (i <- 0 until fq2Length) {
      sum2 = sum2 + fq2Sequence(i)
      //      println(sum2 + ":" + fq2Sequence(i));
    }
    //    println(sum2);
    endTime = System.currentTimeMillis();
    println("Method 2=> Length:" + fq2Length + " sum2:" + sum2 + " time:" + (endTime - startTime) + "ms");

    //method 1
    startTime = System.currentTimeMillis();
    var fq1Sequence = fq1.map(_.getFragmentSequence()).collect
    val fq1Length = fq1Sequence.length
    //    println(fq1Count);
    var sum = 0L;
    for (i <- 0 until fq1Length) {
      val a = fq1Sequence(i).length()
      sum = sum + a
      //      println(sum + ":" + a);
    }
    endTime = System.currentTimeMillis();
    println("Method 1=> Length:" + fq1Length + " sum:" + sum + " time:" + (endTime - startTime) + "ms");
    sc.stop
  }
}