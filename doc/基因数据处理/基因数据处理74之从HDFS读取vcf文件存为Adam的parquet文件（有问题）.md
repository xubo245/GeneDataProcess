
1.small.vcf:
没记录

2.读取：
	
	5
	load time:3287 ms
	{"variant": {"variantErrorProbability": 139, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 14396, "end": 14400, "referenceAllele": "CTGT", "alternateAllele": "C", "svAllele": null, "isSomatic": false}, "dbSnpId": null, "geneSymbol": null, "omimId": null, "cosmicId": null, "clinvarId": null, "clinicalSignificance": null, "gerpNr": null, "gerpRs": null, "phylop": null, "ancestralAllele": null, "thousandGenomesAlleleCount": null, "thousandGenomesAlleleFrequency": null, "siftScore": null, "siftScoreConverted": null, "siftPred": null, "mutationTasterScore": null, "mutationTasterScoreConverted": null, "mutationTasterPred": null}
	{"variant": {"variantErrorProbability": 195, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 14521, "end": 14522, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "dbSnpId": null, "geneSymbol": null, "omimId": null, "cosmicId": null, "clinvarId": null, "clinicalSignificance": null, "gerpNr": null, "gerpRs": null, "phylop": null, "ancestralAllele": null, "thousandGenomesAlleleCount": null, "thousandGenomesAlleleFrequency": null, "siftScore": null, "siftScoreConverted": null, "siftPred": null, "mutationTasterScore": null, "mutationTasterScoreConverted": null, "mutationTasterPred": null}
	{"variant": {"variantErrorProbability": 1186, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 19189, "end": 19191, "referenceAllele": "GC", "alternateAllele": "G", "svAllele": null, "isSomatic": false}, "dbSnpId": null, "geneSymbol": null, "omimId": null, "cosmicId": null, "clinvarId": null, "clinicalSignificance": null, "gerpNr": null, "gerpRs": null, "phylop": null, "ancestralAllele": null, "thousandGenomesAlleleCount": null, "thousandGenomesAlleleFrequency": null, "siftScore": null, "siftScoreConverted": null, "siftPred": null, "mutationTasterScore": null, "mutationTasterScoreConverted": null, "mutationTasterPred": null}
	{"variant": {"variantErrorProbability": 2994, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 63734, "end": 63738, "referenceAllele": "CCTA", "alternateAllele": "C", "svAllele": null, "isSomatic": false}, "dbSnpId": null, "geneSymbol": null, "omimId": null, "cosmicId": null, "clinvarId": null, "clinicalSignificance": null, "gerpNr": null, "gerpRs": null, "phylop": null, "ancestralAllele": null, "thousandGenomesAlleleCount": null, "thousandGenomesAlleleFrequency": null, "siftScore": null, "siftScoreConverted": null, "siftPred": null, "mutationTasterScore": null, "mutationTasterScoreConverted": null, "mutationTasterPred": null}
	{"variant": {"variantErrorProbability": 2486, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 752720, "end": 752721, "referenceAllele": "A", "alternateAllele": "G", "svAllele": null, "isSomatic": false}, "dbSnpId": null, "geneSymbol": null, "omimId": null, "cosmicId": null, "clinvarId": null, "clinicalSignificance": null, "gerpNr": null, "gerpRs": null, "phylop": null, "ancestralAllele": null, "thousandGenomesAlleleCount": null, "thousandGenomesAlleleFrequency": null, "siftScore": null, "siftScoreConverted": null, "siftPred": null, "mutationTasterScore": null, "mutationTasterScoreConverted": null, "mutationTasterPred": null}
	run time:3454 ms
	*************end*************
	2016-6-7 22:44:54 INFO: org.apache.parquet.hadoop.ParquetInputFormat: Total input paths to process : 1
	2016-6-7 22:44:54 WARNING: org.apache.parquet.hadoop.ParquetRecordReader: Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-6-7 22:44:54 INFO: org.apache.parquet.hadoop.InternalParquetRecordReader: RecordReader initialized will read a total of 5 records.
	2016-6-7 22:44:54 INFO: org.apache.parquet.hadoop.InternalParquetRecordReader: at row 0. reading next block
	2016-6-7 22:44:55 INFO: org.apache.parquet.hadoop.InternalParquetRecordReader: block read in memory in 69 ms. row count = 5
	2016-6-7 22:44:55 WARNING: org.apache.parquet.hadoop.ParquetRecordReader: Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-6-7 22:44:55 INFO: org.apache.parquet.hadoop.InternalParquetRecordReader: RecordReader initialized will read a total of 5 records.
	2016-6-7 22:44:55 INFO: org.apache.parquet.hadoop.InternalParquetRecordReader: at row 0. reading next block
	2016-6-7 22:44:55 INFO: org.apache.parquet.hadoop.InternalParquetRecordReader: block read in memory in 7 ms. row count = 5
	
	Process finished with exit code 0

#  #
3.All_20160407.vcf
有问题：

	hadoop@Master:~/xubo/project/load/vcf$ ./load.sh 
	start:
	[Stage 0:>                                                       (0 + 14) / 203]16/06/07 22:53:43 ERROR TaskSetManager: Task 0 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 0.0 failed 4 times, most recent failure: Lost task 0.3 in stage 0.0 (TID 22, 219.219.220.180): java.lang.IllegalArgumentException: Multi-allelic site [VC Unknown @ 1:10493 Q. of type=SNP alleles=[C*, A, G] attr={ASP=true, GENEINFO=DDX11L1:100287102, R5=true, RS=199606420, RSPOS=10493, SAO=0, SSR=0, VC=SNV, VP=0x050000020005000002000100, WGT=1, dbSNPBuildID=137} GT=[]
		at org.bdgenomics.adam.converters.VariantContextConverter.convertToAnnotation(VariantContextConverter.scala:206)
		at org.bdgenomics.adam.rdd.ADAMContext$$anonfun$loadVcfAnnotations$1.apply(ADAMContext.scala:566)
		at org.bdgenomics.adam.rdd.ADAMContext$$anonfun$loadVcfAnnotations$1.apply(ADAMContext.scala:566)
		at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1555)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at org.gcdss.cli.load.loadDatabaseVariantAnnotationFromVcf$.main(loadDatabaseVariantAnnotationFromVcf.scala:27)
		at org.gcdss.cli.load.loadDatabaseVariantAnnotationFromVcf.main(loadDatabaseVariantAnnotationFromVcf.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.lang.IllegalArgumentException: Multi-allelic site [VC Unknown @ 1:10493 Q. of type=SNP alleles=[C*, A, G] attr={ASP=true, GENEINFO=DDX11L1:100287102, R5=true, RS=199606420, RSPOS=10493, SAO=0, SSR=0, VC=SNV, VP=0x050000020005000002000100, WGT=1, dbSNPBuildID=137} GT=[]
		at org.bdgenomics.adam.converters.VariantContextConverter.convertToAnnotation(VariantContextConverter.scala:206)
		at org.bdgenomics.adam.rdd.ADAMContext$$anonfun$loadVcfAnnotations$1.apply(ADAMContext.scala:566)
		at org.bdgenomics.adam.rdd.ADAMContext$$anonfun$loadVcfAnnotations$1.apply(ADAMContext.scala:566)
		at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1555)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)


代码：

	package org.gcdss.cli.load
	
	import org.apache.spark.sql.SQLContext
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.rdd.ADAMContext
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	//import org.bdgenomics.avocado.AvocadoFunSuite
	
	object loadDatabaseVariantAnnotationFromVcf {
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
	    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/vcf/All_20160407.vcf"
	    //    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/vcf/small.vcf"
	    val rdd = sc.loadVcfAnnotations(path)
	    println(rdd.count())
	    val loadTime = System.currentTimeMillis()
	    println("load time:" + (loadTime - startTime) + " ms")
	    //    rdd.take(10).foreach(println)
	    //    rdd.foreach(println)
	    rdd.adamParquetSave("/xubo/callVariant/vcf/All_20160407.adam")
	    //    rdd.adamParquetSave("file/callVariant/small.adam")
	    val saveTime = System.currentTimeMillis()
	    println("save time:" + (saveTime - loadTime) + " ms")
	    println("run time:" + (saveTime - startTime) + " ms")
	    println("*************end*************")
	    sc.stop()
	
	  }
	
	}
#参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
	【5】http://stackoverflow.com/questions/28166667/how-to-pass-d-parameter-or-environment-variable-to-spark-job  
	【6】http://stackoverflow.com/questions/28840438/how-to-override-sparks-log4j-properties-per-driver

		
#研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
#Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	