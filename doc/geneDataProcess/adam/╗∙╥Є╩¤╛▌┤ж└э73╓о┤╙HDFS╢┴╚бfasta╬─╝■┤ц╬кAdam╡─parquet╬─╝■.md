

1.GRCH38chr14：

	hadoop@Master:~/xubo/project/load$ ./load.sh 
	start:
	1
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	load time:16550 ms
	save time:72518 ms
	run time:89068 ms
	*************end*************


2.全基因组

	hadoop@Master:~/xubo/project/load$ ./load.sh 
	start:
	456                                                                             
	load time:314296 ms
	[Stage 4:=============================>                          (13 + 11) / 25]16/06/07 22:35:00 ERROR TaskSchedulerImpl: Lost executor 0 on 219.219.220.215: remote Rpc client disassociated
	[Stage 4:>                                                          (0 + 6) / 6]16/06/07 22:36:53 ERROR TaskSchedulerImpl: Lost executor 1 on 219.219.220.180: remote Rpc client disassociated
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	save time:853468 ms
	run time:1167764 ms
	*************end*************
	16/06/07 22:46:39 WARN QueuedThreadPool: 3 threads could not be stopped



代码：

	package org.gcdss.cli.load
	
	import org.apache.spark.sql.SQLContext
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.rdd.ADAMContext
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	//import org.bdgenomics.avocado.AvocadoFunSuite
	
	object loadFastaFromfna {
	  //  def resourcePath(path: String) = ClassLoader.getSystemClassLoader.getResource(path).getFile
	
	  //  def tmpFile(path: String) = Files.createTempDirectory("").toAbsolutePath.toString + "/" + path
	
	  //  def apply(local: Boolean, fqFile: String, faFile: String, configFile: String, output: String) {
	  def main(args: Array[String]) {
	    println("start:")
	    var conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("spark://219.219.220.149:7077")
	    //    var conf = new SparkConf().setAppName("AvocadoSuite").setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val ac = new ADAMContext(sc)
	    val sqlContext = new SQLContext(sc)
	    val startTime = System.currentTimeMillis()
	//    val path = "hdfs://219.219.220.149:9000/xubo/ref/GRCH38chr14/GRCH38chr14.fasta"
	    val path = "hdfs://219.219.220.149:9000/xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna"
	    val rdd = sc.loadFasta(path, 1000000000L)
	    println(rdd.count())
	    //    rdd.take(1).foreach(println)
	    //    rdd.foreach(println)
	    val loadTime = System.currentTimeMillis()
	    println("load time:" + (loadTime - startTime) + " ms")
	    rdd.adamParquetSave("/xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.adam")
	    val saveTime = System.currentTimeMillis()
	    println("save time:" + (saveTime - loadTime) + " ms")
	    println("run time:" + (saveTime - startTime) + " ms")
	    println("*************end*************")
	    sc.stop()
	
	  }
	
	}


脚本：
	
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.load.loadFastaFromfna \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar
