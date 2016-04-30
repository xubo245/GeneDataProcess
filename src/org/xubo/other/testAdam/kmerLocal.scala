package org.xubo.other.testAdam
import org.apache.spark._
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.adam.projections.{ AlignmentRecordField, Projection }
import java.text.SimpleDateFormat
import java.util._
import scala.actors.Logger
import scala.actors.Logger
import scala.actors.Logger
import org.apache.log4j.{ Level, Logger }

//@SuppressWarnings("all")
object kmerLocal {
  def main(args: Array[String]) {
    //    Logger.getLogger("org.apache.spark").setLevel(Level.OFF)
    //    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    //    Logger.getLogger("org.apache.parquet.CorruptStatistics").setLevel(Level.OFF)
    val conf = new SparkConf().setAppName("test Adam kmer").setMaster("local")
    //  val conf=new SparkConf().setAppName("test Adam kmer").setMaster("local")
    //  val conf=new SparkConf().setAppName("test Adam kmer")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    // Load alignments from disk
    //val reads = ac.loadAlignments("/data/NA21144.chrom11.ILLUMINA.adam",
    //val reads = ac.loadAlignments("/xubo/adam/output/small.adam",
    //    val reads = ac.loadAlignments("hdfs://219.219.220.149:9000/xubo/adam/output/small.adam", projection = Some(Projection(AlignmentRecordField.sequence, AlignmentRecordField.readMapped, AlignmentRecordField.mapq)))
    val reads = ac.loadAlignments("file/adam/small/small.adam")

    // Generate, count and sort 21-mers
    val kmers = reads.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
    kmers.take(10).foreach(println)

    // Print the top 10 most common 21-mers
    //SaveAsFile
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    //    val soutput = "hdfs://219.219.220.149:9000/xubo/adam/output/kmer/" + iString + "/smallkmers21.adam";
    val soutput = "file/adam/small/output/" + iString + "/smallkmers21.adam";

    println("kmers.count(reduceByKey):" + kmers.count)
    kmers.saveAsTextFile(soutput)
    val sum0 = for ((a, b) <- kmers) yield a
    println("kmers.count(no reduce):" + sum0.sum)
    sc.stop()

  }
}