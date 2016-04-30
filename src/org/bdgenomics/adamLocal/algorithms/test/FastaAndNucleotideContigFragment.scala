/**
 * @author xubo
 * Fasta/Fastq/SAM/BAM read
 */
package org.bdgenomics.adamLocal.algorithms.test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.bdgenomics.adam.rdd.ADAMContext
import org.bdgenomics.formats.avro.NucleotideContigFragment
import org.bdgenomics.formats.avro.Contig
//import scala.collection.parallel.Foreach

object FastaAndNucleotideContigFragment {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("FastaAndNucleotideContigFragment").setMaster("local")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    val builder = NucleotideContigFragment.newBuilder()
    val contig = Contig.newBuilder
    builder.setContig(contig.build)
    val build1 = builder.build()
    println(build1);
    sc.stop

  }
}