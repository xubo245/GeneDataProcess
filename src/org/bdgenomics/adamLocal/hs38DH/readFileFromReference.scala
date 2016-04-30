package org.bdgenomics.adamLocal.hs38DH

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.formats.avro.Feature
import org.bdgenomics.formats.avro.Contig
import org.bdgenomics.adam.models.ReferenceRegion
//import scala.collection.parallel.Foreach

//case class ReferenceRegion(referenceName: String,start: Long,end: Long,orientation: Strand = Strand.Independent)
object readFileFromReference {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ReadFile").setMaster("local")
    val sc = new SparkContext(conf)

    val ac = new ADAMContext(sc)
    val file1 = "file/adam/hs38DH/hs38DHL1.fa"
    //load by SparkContext textFile
    //    val fq0 = sc.textFile(file1)
    //     val refR= ReferenceRegion("chrUn_KN707606v1_decoy",1L 100L, Strand.Independent)
    val ref = ac.loadReferenceFile(file1, 10000)
    //        ac.loadReferenceFile(filePath, fragmentLength)
    //   val  refCollect=ref.extract(region)
    //    println(ref.extract);
    //ref.extract(ReferenceRegion)
    //    val bigRegions = sc.parallelize(Seq(
    //      Feature
    //        .newBuilder
    //        .setStart(14000).setEnd(14700)
    //        .setContig(Contig.newBuilder.setContigName("1").build)
    //        .build)).keyBy(ReferenceRegion(_))
    ////        ref.extract(ReferenceRegion(_,_,_,_))
    //        bigRegions.foreach(println)
    println("end");
    sc.stop
  }
}