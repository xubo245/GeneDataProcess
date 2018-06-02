	
1.分两组

(1)kmer长度为：5 to 21

(2)kmer长度为：5 to 55 by 10
	
	
2.代码：
	
	package org.gcdss.cli
	
	import java.text.SimpleDateFormat
	import java.util._
	
	import org.apache.spark._
	import org.bdgenomics.adam.projections.{ AlignmentRecordField, Projection }
	import org.bdgenomics.adam.rdd.ADAMContext;
	
	object kmerSRR002644SaveAsFile {
	  def main(args: Array[String]) {
	    //    val conf = new SparkConf().setAppName("test Adam kmer").setMaster("local")
	    val conf = new SparkConf().setAppName("test Adam kmer")
	    val sc = new SparkContext(conf)
	    val ac = new ADAMContext(sc)
	    // Load alignments from disk
	    //val reads = ac.loadAlignments("/data/NA21144.chrom11.ILLUMINA.adam",
	    //  val reads = ac.loadAlignments("/xubo/adam/output/small.adam",
	    val reads = ac.loadAlignments("hdfs://219.219.220.149:9000/xubo/data/data/SRR002644.fastq",
	      projection = Some(Projection(AlignmentRecordField.sequence, AlignmentRecordField.readMapped, AlignmentRecordField.mapq)))
	    // Generate, count and sort 21-mers
	
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    //    for (i <- 5 to 200 by 10) {
	    for (i <- 5 to 200) {
	      println("***********************" + i)
	      println("reads.count:" + reads.count())
	      val kmers = reads.flatMap(_.getSequence.sliding(i).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
	      kmers.take(10).foreach(println)
	      val soutput = "/xubo/project/kmer/output/SRR002644/T" + iString + "/" + i.toString + "/SRR002644kmers.adam";
	      println("kmers.count(reduceByKey):" + kmers.count)
	      kmers.saveAsTextFile(soutput)
	      val sum0 = for ((a, b) <- kmers) yield a
	      println("kmers.count(no reduce):" + sum0.sum)
	    }
	    sc.stop()
	    // Print the top 10 most common 21-mers
	  }
	}

脚本：
	
	hadoop@Master:~/xubo/project/kmer$ vi kmer.sh 
	
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.kmerSRR002644SaveAsFile \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar


3.结果：

请见20160613的报告
有分析相关的结果。