package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.bdgenomics.adam.rdd.ADAMContext
import htsjdk.samtools.ValidationStringency
//import scala.collection.parallel.Foreach

object readFileFromFastaSimple2 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("readFileFromFastaSimple").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)

    //load by SparkContext textFile
    val fq0 = sc.textFile("file/adam/hs38DH/hs38DHL2.fa")
    fq0.foreach(println)

    //load Fasta
    println();
    val fq1 = ac.loadFasta("file/adam/hs38DH/hs38DHL2.fa", 1000)
    //3+4
    println(fq1.count);
    fq1.foreach(println)
    for (i <- fq1) {
      i.getSchema()
    }

    sc.stop
  }
}