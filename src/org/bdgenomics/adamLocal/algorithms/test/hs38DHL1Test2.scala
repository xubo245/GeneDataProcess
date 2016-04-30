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
import org.bdgenomics.adamLocal.algorithms.smithwaterman.SmithWatermanConstantGapScoring
//import scala.collection.parallel.Foreach

object hs38DHL1Test2 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFaFq").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    val fileFa = "file/adam/hs38DH/hs38DHL1/hs38DHL1.fa"
    val fileFq = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.fq"
    val fileSam = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.sam"
    val fileBam = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.bam"

    val fq0 = sc.textFile(fileFa)

    //load Fasta
    val fa1 = ac.loadFasta(fileFa, 10000)
    var fa1Segquence = fa1.map(_.getFragmentSequence()).collect

    //load Fastq
    //    val fq1 = ac.loadFastq(fileFq)
    val fq1 = ac.loadAlignments(fileFq)
    var fq1Segquence = fq1.map(_.getSequence()).collect

    for (i <- 0 until fa1Segquence.length) {
      for (j <- 0 until fq1Segquence.length) {
        println("fa1Segquence " + i + ":" + fa1Segquence(i) + "\nfq1Segquence " + j + ":" + fq1Segquence(j));
        val s1 = new SmithWatermanConstantGapScoring(fa1Segquence(i), fq1Segquence(j), 4.0, -3.0, -4.0, -4)
        println("s1.maxScore:" + s1.maxScore);
        println("s1.cigarX:" + s1.cigarX);
        println("s1.cigarY:" + s1.cigarY);
        println("s1.xStart:" + s1.xStart);
        println("s1.yStart:" + s1.yStart);
        
      }
    }
    //    val sam1 = ac.loadAlignments(fileSam)
    //    val bam1 = ac.loadAlignments(fileBam)

    sc.stop

  }
}