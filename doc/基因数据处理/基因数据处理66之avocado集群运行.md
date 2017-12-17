
1.最大问题：
老报错的问题：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll$ ./GcdssCallVariant2.sh 
	start:
	fqFile:hdfs://219.219.220.149:9000/xubo/avocado/NA12878_snp_A2G_chr20_225058.sam
	faFile:hdfs://219.219.220.149:9000/xubo/ref/Homo_sapiens_assembly19chr20.fasta
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai0605
	fqLoad.count:90
	faLoad.count:6303
	faLoad:
	hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai0605
	Exception in thread "main" java.lang.NullPointerException
		at java.util.Objects.requireNonNull(Objects.java:201)
		at java.nio.file.Files.copy(Files.java:2811)
		at org.gcdss.cli.Gcdss.<init>(Gcdss.scala:78)
		at org.gcdss.cli.Gcdss$.apply(Gcdss.scala:46)
		at org.gcdss.cli.GcdssCallVariant$.main(GcdssCallVariant.scala:60)
		at org.gcdss.cli.GcdssCallVariant.main(GcdssCallVariant.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)

解决办法：
将Gcdss.scala:78的注释掉，不用File.copy,后面直接读取配置文件。
每个节点的绝对路径下都有这个文件。

	  val stream = Thread.currentThread.getContextClassLoader.getResourceAsStream(args.configFile)
	  val tempPath = Files.createTempDirectory("config")
	  val tempFilePath = tempPath.resolve("temp.properties")
	  println("tempPath:" + tempPath)
	  println("tempFilePath:" + tempFilePath)
	  //  Files.copy(stream, tempFilePath)
	
	  // load config
	  //  val config: HierarchicalConfiguration = new PropertyListConfiguration(tempFilePath.toFile)
	  val config: HierarchicalConfiguration = new PropertyListConfiguration(args.configFile)


2.代码：

（1） scala：
	package org.gcdss.cli
	
	import java.nio.file.Files
	import java.text.SimpleDateFormat
	import java.util._

	import org.apache.spark.sql.SQLContext
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.rdd.ADAMContext
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	//import org.bdgenomics.avocado.AvocadoFunSuite
	
	object GcdssCallVariant {
	  //  def resourcePath(path: String) = ClassLoader.getSystemClassLoader.getResource(path).getFile
	
	  //  def tmpFile(path: String) = Files.createTempDirectory("").toAbsolutePath.toString + "/" + path
	
	  //  def apply(local: Boolean, fqFile: String, faFile: String, configFile: String, output: String) {
	  def main(args: Array[String]) {
    println("start:")
    var conf = new SparkConf().setAppName("AvocadoSuite").setMaster("spark://219.219.220.149:7077")
    //    var conf = new SparkConf().setAppName("AvocadoSuite").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val ac = new ADAMContext(sc)
    val sqlContext = new SQLContext(sc)

    //  val fqFile = "artificial.realigned.sam"
    //  val faFile = "artificial.fa"
    //  //    val fqFile = "datatest2.sam"
    //  //    val faFile = "datatest.fa"
    //  val configFile = "basic.properties"
    //  val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    //  val output = "D:\\all\\idea\\avocado-master\\avocado-cli\\src\\test\\resources\\output\\var" + iString

    val fqFile = "hdfs://219.219.220.149:9000/xubo/avocado/NA12878_snp_A2G_chr20_225058.sam"
    val faFile = "hdfs://219.219.220.149:9000/xubo/ref/Homo_sapiens_assembly19chr20.fasta"
    val output = "hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060504"
    //    //    val configFile = "/home/hadoop/xubo/data/testTools/basic.properties"
    //    val configFile = "hdfs://219.219.220.149:9000/xubo/avocado/avocado-sample-configs/basic.properties"

    //    val fqFile = "hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.realigned.sam"
    //    val faFile = "hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.fa"
    //    val output = "hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060503"
    val configFile = "/home/hadoop/xubo/data/testTools/basic.properties"
    //    val configFile = "hdfs://219.219.220.149:9000/xubo/avocado/avocado-sample-configs/basic.properties"
    //    val configFile = "file/avocado-sample-configs/basic.properties"
    val fqLoad = sc.loadAlignments(fqFile)
    val faLoad = sc.loadFasta(faFile, 10000)
    println("fqFile:" + fqFile)
    println("faFile:" + faFile)
    println("configFile:" + configFile)
    println("output:" + output)
    println("fqLoad.count:" + fqLoad.count)
    println("faLoad.count:" + faLoad.count)
    fqLoad.foreach(println)
    println("faLoad:")

    //    println(resourcePath(faFile))
    //    faLoad.foreach(println)
    println(output)
    //    Avocado(Array("READS", "REFERENCE", "REFERENCE", "CONFIG", resourcePath(fqFile), resourcePath(faFile), "var", resourcePath(configFile)))
    Gcdss(Array(fqFile, faFile, output, configFile)).run(sc)
    //    val read1 = sqlContext.read.parquet(output)
    val read1 = sc.loadAlignments(output)
    println("read parquet:")
    //    read1.printSchema()
    read1.foreach(println)
    println("*************end*************")
    sc.stop()
	
	  }
	
	}

（2）脚本：

	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.GcdssCallVariant \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar


3.文件：可以参照代码和脚本找

4.运行记录：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll$ ./GcdssCallVariant2.sh 
	start:
	fqFile:hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.realigned.sam
	faFile:hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.fa
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060503
	fqLoad.count:10
	faLoad.count:1
	faLoad:
	hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060503
	tempPath:/tmp/config3601858312734585999
	tempFilePath:/tmp/config3601858312734585999/temp.properties
	Loading reads in from hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.realigned.sam
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	read parquet:                                                                   
	*************end*************                                                   
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll$ rm backup/*
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll$ mv BWAMEMSparkAll.jar backup/
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll$ rz
	
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll$ ./GcdssCallVariant2.sh 
	start:
	fqFile:hdfs://219.219.220.149:9000/xubo/avocado/NA12878_snp_A2G_chr20_225058.sam
	faFile:hdfs://219.219.220.149:9000/xubo/ref/Homo_sapiens_assembly19chr20.fasta
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060504
	fqLoad.count:90
	faLoad.count:6303
	faLoad:
	hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060504
	tempPath:/tmp/config1711783004107565020
	tempFilePath:/tmp/config1711783004107565020/temp.properties
	Loading reads in from hdfs://219.219.220.149:9000/xubo/avocado/NA12878_snp_A2G_chr20_225058.sam
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	read parquet:                                                                   
	*************end*************                                                   
	16/06/05 22:58:25 WARN QueuedThreadPool: 2 threads could not be stopped
	16/06/05 22:58:27 WARN QueuedThreadPool: 2 threads could not be stopped

时间：

	 Completed Applications
	Application ID	Name	Cores	Memory per Node	Submitted Time	User	State	Duration
	app-20160605224041-0017 	AvocadoSuite 	6 	4.0 GB 	2016/06/05 22:40:41 	hadoop 	FINISHED 	18 min
	app-20160605223717-0016 	AvocadoSuite 	14 	4.0 GB 	2016/06/05 22:37:17 	hadoop 	FINISHED 	47 s

Artificial结果：

	org.bdgenomics.avocado.cli.parquetRead2avocadoClusterArtificial
	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/C:/Users/xubo/.m2/repository/org/slf4j/slf4j-log4j12/1.7.12/slf4j-log4j12-1.7.12.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	2016-06-05 23:12:42 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	2016-06-05 23:12:44 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
	start:
	2016-06-05 23:12:46 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%39, but we couldn't find any external IP address!
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	2016-06-05 23:12:54 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:12:55 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:12:55 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	+--------------------+-------------------------+-----------------+-----------------+---------------------+----------+--------------------+------------------+------------------+---------+------------+---------------+--------------------+-----------------------+--------------------+---------------------+--------+----------+------------+
	|             variant|variantCallingAnnotations|         sampleId|sampleDescription|processingDescription|   alleles|expectedAlleleDosage|referenceReadDepth|alternateReadDepth|readDepth|minReadDepth|genotypeQuality| genotypeLikelihoods|nonReferenceLikelihoods|strandBiasComponents|splitFromMultiAllelic|isPhased|phaseSetId|phaseQuality|
	+--------------------+-------------------------+-----------------+-----------------+---------------------+----------+--------------------+------------------+------------------+---------+------------+---------------+--------------------+-----------------------+--------------------+---------------------+--------+----------+------------+
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 0|                 5|        5|        null|             18|[-1.1486835E-6, -...|   [-1.1486835E-6, -...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	|[null,[artificial...|     [null,WrappedArra...|sequencing_center|             null|                 null|[Ref, Alt]|                null|                 2|                 3|        5|        null|     2147483647|[-32.23619, -3.46...|   [-32.23619, -3.46...|                  []|                false|   false|      null|        null|
	+--------------------+-------------------------+-----------------+-----------------+---------------------+----------+--------------------+------------------+------------------+---------+------------+---------------+--------------------+-----------------------+--------------------+---------------------+--------+----------+------------+
	
	2016-06-05 23:12:57 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:12:57 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:12:57 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	11
	end
	
	Process finished with exit code 0


NA12878_snp_A2G_chr20_225058结果：

	start:
	2016-06-05 23:13:39 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%39, but we couldn't find any external IP address!
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	2016-06-05 23:13:43 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:13:43 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:13:43 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	+--------------------+-------------------------+--------+-----------------+---------------------+----------+--------------------+------------------+------------------+---------+------------+---------------+--------------------+-----------------------+--------------------+---------------------+--------+----------+------------+
	|             variant|variantCallingAnnotations|sampleId|sampleDescription|processingDescription|   alleles|expectedAlleleDosage|referenceReadDepth|alternateReadDepth|readDepth|minReadDepth|genotypeQuality| genotypeLikelihoods|nonReferenceLikelihoods|strandBiasComponents|splitFromMultiAllelic|isPhased|phaseSetId|phaseQuality|
	+--------------------+-------------------------+--------+-----------------+---------------------+----------+--------------------+------------------+------------------+---------+------------+---------------+--------------------+-----------------------+--------------------+---------------------+--------+----------+------------+
	|[null,[20,6302552...|     [null,WrappedArra...| NA12878|             null|                 null|[Ref, Alt]|                null|                 3|                 5|        8|        null|     2147483647|[-32.696815, -5.5...|   [-32.696815, -5.5...|                  []|                false|   false|      null|        null|
	|[null,[20,6302552...|     [null,WrappedArra...| NA12878|             null|                 null|[Ref, Alt]|                null|                49|                41|       90|        null|     2147483647|[-507.5003, -62.3...|   [-507.5003, -62.3...|                  []|                false|   false|      null|        null|
	+--------------------+-------------------------+--------+-----------------+---------------------+----------+--------------------+------------------+------------------+---------+------------+---------------+--------------------+-----------------------+--------------------+---------------------+--------+----------+------------+
	
	2016-06-05 23:13:44 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:13:44 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-06-05 23:13:44 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2
	end

# 参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
	【5】http://stackoverflow.com/questions/28166667/how-to-pass-d-parameter-or-environment-variable-to-spark-job  
	【6】http://stackoverflow.com/questions/28840438/how-to-override-sparks-log4j-properties-per-driver

		
# 研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
# Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	