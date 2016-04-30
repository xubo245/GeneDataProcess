package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object readFileFromFaFqSimple {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFaFqSimple").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    val fileFa = "file/adam/hs38DH/hs38DHL3.fa"
    //    val fileFq = "file/adam/hs38DH/hs38DHSE1L100F1.fq"
    val fileFq = "file/adam/hs38DH/hs38DHSE1N200L20F1.fq"

    //    val fq0 = sc.textFile(file1)
    //    println("fq0.count:" + fq0.count);

    //load Fasta
    println(fileFa + ":");
    val fa1 = ac.loadFasta(fileFa, 10000)
    var fa1Segquence = fa1.map(_.getFragmentSequence()).collect
    //        fq1Segquence.foreach(println)
    println("fa1Segquence.length:" + fa1Segquence.length);
    for (i <- 0 until fa1Segquence.length) {
      println(fa1Segquence(i));
    }
    println();
    fa1.foreach(a => println("fa1:" + a))

    //load Fastq
    println();
    println(fileFq + ":");
    val fq1 = ac.loadFastq(fileFq, None, None, ValidationStringency.STRICT)
    var fq1Segquence = fq1.map(_.getSequence()).collect
    //        fq1Segquence.foreach(println)
    println("fq1Segquence.length:" + fq1Segquence.length);
    for (i <- 0 until fq1Segquence.length) {
      println(fq1Segquence(i));
    }
    println();
    fq1.foreach(println)
    sc.stop

  }
}