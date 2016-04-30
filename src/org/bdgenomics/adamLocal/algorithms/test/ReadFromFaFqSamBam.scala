/**
 * @author xubo
 * Fasta/Fastq/SAM/BAM read 
 */
package org.bdgenomics.adamLocal.algorithms.test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object ReadFromFaFqSamBam {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFaFqSamBam").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    val fileFa = "file/adam/hs38DH/hs38DHL1/hs38DHL1.fa"
    //    val fileFq = "file/adam/hs38DH/hs38DHSE1L100F1.fq"
    val fileFq = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.fq"
    val fileSam = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.sam"
    val fileBam = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.bam"

    val fq0 = sc.textFile(fileFa)
    println("fq0.count:" + fq0.count);

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
    fa1.foreach(println)

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

    println("SAM:");
    val sam1 = ac.loadAlignments(fileSam)
    sam1.foreach(println)

    println("BAM:");
    println("methods 1:");
    val bam1 = ac.loadAlignments(fileBam)
    bam1.foreach(println)
    println("methods 2:");
    val bam2 = ac.loadBam(fileBam)
    bam2.foreach(println)
    sc.stop

  }
}