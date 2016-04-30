/**
 * @author xubo
 * Fasta/Fastq/SAM/BAM read
 */
package org.bdgenomics.adamLocal.algorithms.test

import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.utils.instrumentation.Metrics
import org.bdgenomics.utils.misc.HadoopUtil
//import scala.collection.parallel.Foreach

object HadoopFile {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFaFq").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    val fileFa = "file/adam/hs38DH/hs38DHL1/hs38DHL1.fa"
    val fileFq = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.fq"
    val fileSam = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.sam"
    val fileBam = "file/adam/hs38DH/hs38DHL1/hs38DHL1F1Len10.bam"

    val fq0 = sc.textFile(fileFa)
    import org.apache.hadoop.io.{ LongWritable, Text }
    import org.apache.parquet.hadoop.util.ContextUtil
    val job = HadoopUtil.newJob(sc)
    val fastaData: RDD[(LongWritable, Text)] = sc.newAPIHadoopFile(
      fileFa,
      classOf[TextInputFormat],
      classOf[LongWritable],
      classOf[Text])
    println("start:");
    fastaData.foreach(println)
    println(fastaData.count);
    println("end:");

//    if (Metrics.isRecording) fastaData.instrument() else fastaData

    val remapData = fastaData.map(kv => (kv._1.get, kv._2.toString))
    println(remapData.count);
    remapData.foreach(println)
    sc.stop

  }
}