package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object readFileFromFastq {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFastq").setMaster("local")
    val sc = new SparkContext(conf)

    //    val hs38DHtext=sc.textFile("file/adam/hs38DH/hs38DH.fa")
    //    hs38DHtext.take(100).foreach(println)

    val sqlContext = new SQLContext(sc)
    import sqlContext._
    //    val hs38DHFa=sqlContext.read.load("file/adam/hs38DH/hs38DH.adam/part-r-00000.gz.parquet")
    //    hs38DHFa.show

    val ac = new ADAMContext(sc)
    val hs38DHFile = ac.loadAlignments("file/adam/hs38DH/hs38DH.adam")
    //    hs38DHFile.take(10).foreach(println)
    //    println("***********" + hs38DHFile.count + "********");

    //    println(hs38DHFile.count);
    //    ac.loadFastq(filePath1, filePath2Opt, recordGroupOpt, stringency)

    val fq0 = sc.textFile("file/adam/hs38DH/hs38DHSE1N200L20F1.fq")
    fq0.foreach(println)

    //load Fastq
    val fq1 = ac.loadFastq("file/adam/hs38DH/hs38DHSE1N200L20F1.fq", None, None, ValidationStringency.STRICT)
    println(fq1.count);
    //    val kmers = fq1.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
    //    kmers.take(10).foreach(println)
    println(fq1.getStorageLevel)
    val fq1Segquence = fq1.map(_.getSequence())
    fq1Segquence.foreach(println)

    println(fq1Segquence.toDebugString)

    //    for (i <- fq1Segquence) {
    //      println(i.getSchema);
    //    }
    sc.stop
  }
}