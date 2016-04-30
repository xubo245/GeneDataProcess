package org.bdgenomics.adamLocal.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.adam.projections.Projection
import org.bdgenomics.adam.projections.AlignmentRecordField
import org.apache.log4j.{ Level, Logger }
import java.text.SimpleDateFormat
import java.util.Date
object dataFormat {
  def main(args: Array[String]) {
    //    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.apache.spark").setLevel(Level.OFF)

    val conf = new SparkConf().setAppName("test Adam kmer").setMaster("local")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    val reads = ac.loadAlignments("file/adam/learning/input/small.adam",
      projection = Some(Projection(AlignmentRecordField.sequence, AlignmentRecordField.readMapped, AlignmentRecordField.mapq)))
    reads.foreach(println)
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "file/adam/learning//output/AdamFromSAM/" + iString + "/AdamFromFa.adam";
    reads.saveAsTextFile(soutput)
  }
}