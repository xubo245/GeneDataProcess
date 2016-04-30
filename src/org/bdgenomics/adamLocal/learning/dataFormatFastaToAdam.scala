package org.bdgenomics.adamLocal.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.adam.projections.Projection
import org.bdgenomics.adam.projections.AlignmentRecordField
import java.text.SimpleDateFormat
import java.util.Date

object dataFormatFastaToAdam {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test Adam kmer").setMaster("local")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    val reads = ac.loadAlignments("hdfs://219.219.220.149:9000/xubo/adam/output/artificial.adam")
    println("****************************************");
    reads.foreach(println)
    println("count:" + reads.count + " end");
    reads.foreach(println)
    val out = reads.map(_.getSequence())
    println("****************************************");
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "hdfs://219.219.220.149:9000/xubo/adam/output/AdamFromFasta/" + iString + "/AdamFromFa.adam";
    val soutput2 = "hdfs://219.219.220.149:9000/xubo/adam/output/fa/" + iString + "/AdamFromFa.adam";
    reads.saveAsTextFile(soutput)
    out.saveAsTextFile(soutput2)

  }
}