package org.bdgenomics.adamLocal.test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object testAddRDD {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test1").setMaster("local")
    val sc = new SparkContext(conf)
    val tes = new addRDD(sc)
    tes.test1
    //      tes.sc.getCheckpointDir
    //    sc.addSparkListener(listener)
  }
}