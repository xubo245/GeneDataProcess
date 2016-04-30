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
    val conf = new SparkConf().setAppName("dataFormatFastaToAdam").setMaster("local")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    val reads = ac.loadAlignments("file/adam/learning/input/artificial.adam")
    println("****************************************");
    reads.foreach(println)
    println("count:" + reads.count + " end");
    reads.foreach(println)
    val out = reads.map(_.getSequence())
    println("****************************************");
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "file/adam/learning/output/AdamFromFasta/" + iString + "/AdamFromFa.adam";
    val soutput2 = "file/adam/learning/output/fa/" + iString + "/AdamFromFa.adam";
    reads.saveAsTextFile(soutput)
    out.saveAsTextFile(soutput2)

  }
}