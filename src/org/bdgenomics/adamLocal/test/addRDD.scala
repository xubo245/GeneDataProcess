package org.bdgenomics.adamLocal.test

import org.bdgenomics.adam.rdd.ADAMContext._
import org.apache.spark.SparkContext
import org.apache.spark.Logging

//class addRDD {
//
//}

class addRDD(@transient val sc: SparkContext) extends Serializable with Logging {
  def test1() {
    println("test1");
  }

}
