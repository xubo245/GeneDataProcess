/**
 * @author xubo
 * reference http://blog.csdn.net/escaflone/article/details/43272477
 */
package org.bdgenomics.adamLocal.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.bdgenomics.adam.rdd.ADAMContext
import org.apache.spark.sql.SQLContext._

//import sqlContext._

object parquetFileRead {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test Adam kmer").setMaster("local")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    //    val reads = ac.loadAlignments("hdfs://219.219.220.149:9000/xubo/adam/output/small.adam")
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext._
    //    val parquetFile = sqlContext.parquetFile("hdfs://219.219.220.149:9000/xubo/adam/output/artificial.adam/part-r-0000.gz.parquet")
    val parquetFile = sqlContext.parquetFile("hdfs://219.219.220.149:9000/xubo/adam/output/artificial.adam/")
    parquetFile.registerTempTable("p1")
    //     p1.foreach
    val teenagers = sqlContext.sql("SELECT * FROM p1")
    teenagers.foreach(println)
    val t1 = sqlContext.sql("SELECT fragmentSequence FROM p1")
    t1.foreach(println)

  }
}