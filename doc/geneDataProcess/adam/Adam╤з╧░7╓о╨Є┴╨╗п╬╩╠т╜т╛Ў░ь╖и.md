
#1.问题：
## 1.1 描述
当读入fastq文件后，需要进行转换，比如collect或者读取属性，会出现没有序列化的问题

## 1.2 问题代码：
	
	package org.dsw.core
	
	import org.apache.spark.{SparkContext, SparkConf}
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	/**
	  * Created by xubo on 2016/12/16.
	  */
	class DSAAdamTest {
	
	
	}
	
	object DSAAdamTest {
	  def main(args: Array[String]) {
	
	    val conf = new SparkConf().setMaster("local[8]").setAppName("adam")
	    val sc = new SparkContext(conf)
	    val input = "file/input/fastq/fix1.fastq"
	    val rdd = sc.loadAlignments(input)
	    //    println(rdd)
	    rdd.foreach(println)
	    println(rdd.collect().length)
	    sc.stop()
	
	  }
	}


## 1.3 记录：

	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/C:/all/java/jar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/C:/all/java/jar/adam-cli_2.10-0.18.3-SNAPSHOT.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/C:/Users/xubo/.m2/repository/org/slf4j/slf4j-log4j12/1.7.12/slf4j-log4j12-1.7.12.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/C:/Users/xubo/.m2/repository/org/bdgenomics/adam/adam-cli_2.10/0.18.2/adam-cli_2.10-0.18.2.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	2016-12-16 17:20:50 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	2016-12-16 17:20:51 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
	2016-12-16 17:20:53 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:200:5efe:ca26:541f%20, but we couldn't find any external IP address!
	{"readNum": null, "contig": null, "start": null, "oldPosition": null, "end": null, "mapq": null, "readName": "chr1-1\tRG\tID:foo\tSM:bar", "sequence": "CATATTTACCAATTAAAGTCACAAAATATTTCTCATTATTTATTCATGCAGGTAACTGAGACAAAGATAGTGCAGAAATCAACTTTAAATAAAAAATTAT", "qual": "@C@D@FFDFHHHHIJ.JBIJJGJGIJ:G47JHJ@IJJ91BJJIGHHHEIJDGD=IJJJBJJ'DG=3D)<D?HCHBFAE?GEDC5D5ECD<CD<DBADDBE", "cigar": null, "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": false, "properPair": null, "readMapped": false, "mateMapped": false, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": null, "mateNegativeStrand": null, "primaryAlignment": null, "secondaryAlignment": null, "supplementaryAlignment": null, "mismatchingPositions": null, "origQual": null, "attributes": null, "recordGroupName": null, "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": null, "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": null, "recordGroupPlatformUnit": null, "recordGroupSample": null, "mateAlignmentStart": null, "mateAlignmentEnd": null, "mateContig": null, "inferredInsertSize": null}
	2016-12-16 17:20:54 ERROR Executor:96 - Exception in task 0.0 in stage 1.0 (TID 1)
	java.io.NotSerializableException: org.bdgenomics.formats.avro.AlignmentRecord
	Serialization stack:
		- object not serializable (class: org.bdgenomics.formats.avro.AlignmentRecord, value: {"readNum": null, "contig": null, "start": null, "oldPosition": null, "end": null, "mapq": null, "readName": "chr1-1\tRG\tID:foo\tSM:bar", "sequence": "CATATTTACCAATTAAAGTCACAAAATATTTCTCATTATTTATTCATGCAGGTAACTGAGACAAAGATAGTGCAGAAATCAACTTTAAATAAAAAATTAT", "qual": "@C@D@FFDFHHHHIJ.JBIJJGJGIJ:G47JHJ@IJJ91BJJIGHHHEIJDGD=IJJJBJJ'DG=3D)<D?HCHBFAE?GEDC5D5ECD<CD<DBADDBE", "cigar": null, "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": false, "properPair": null, "readMapped": false, "mateMapped": false, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": null, "mateNegativeStrand": null, "primaryAlignment": null, "secondaryAlignment": null, "supplementaryAlignment": null, "mismatchingPositions": null, "origQual": null, "attributes": null, "recordGroupName": null, "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": null, "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": null, "recordGroupPlatformUnit": null, "recordGroupSample": null, "mateAlignmentStart": null, "mateAlignmentEnd": null, "mateContig": null, "inferredInsertSize": null})
		- element of array (index: 0)
		- array (class [Lorg.bdgenomics.formats.avro.AlignmentRecord;, size 1)
		at org.apache.spark.serializer.SerializationDebugger$.improveException(SerializationDebugger.scala:40)
		at org.apache.spark.serializer.JavaSerializationStream.writeObject(JavaSerializer.scala:47)
		at org.apache.spark.serializer.JavaSerializerInstance.serialize(JavaSerializer.scala:84)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:240)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	2016-12-16 17:20:54 ERROR TaskSetManager:75 - Task 0.0 in stage 1.0 (TID 1) had a not serializable result: org.bdgenomics.formats.avro.AlignmentRecord
	Serialization stack:
		- object not serializable (class: org.bdgenomics.formats.avro.AlignmentRecord, value: {"readNum": null, "contig": null, "start": null, "oldPosition": null, "end": null, "mapq": null, "readName": "chr1-1\tRG\tID:foo\tSM:bar", "sequence": "CATATTTACCAATTAAAGTCACAAAATATTTCTCATTATTTATTCATGCAGGTAACTGAGACAAAGATAGTGCAGAAATCAACTTTAAATAAAAAATTAT", "qual": "@C@D@FFDFHHHHIJ.JBIJJGJGIJ:G47JHJ@IJJ91BJJIGHHHEIJDGD=IJJJBJJ'DG=3D)<D?HCHBFAE?GEDC5D5ECD<CD<DBADDBE", "cigar": null, "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": false, "properPair": null, "readMapped": false, "mateMapped": false, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": null, "mateNegativeStrand": null, "primaryAlignment": null, "secondaryAlignment": null, "supplementaryAlignment": null, "mismatchingPositions": null, "origQual": null, "attributes": null, "recordGroupName": null, "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": null, "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": null, "recordGroupPlatformUnit": null, "recordGroupSample": null, "mateAlignmentStart": null, "mateAlignmentEnd": null, "mateContig": null, "inferredInsertSize": null})
		- element of array (index: 0)
		- array (class [Lorg.bdgenomics.formats.avro.AlignmentRecord;, size 1); not retrying
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0.0 in stage 1.0 (TID 1) had a not serializable result: org.bdgenomics.formats.avro.AlignmentRecord
	Serialization stack:
		- object not serializable (class: org.bdgenomics.formats.avro.AlignmentRecord, value: {"readNum": null, "contig": null, "start": null, "oldPosition": null, "end": null, "mapq": null, "readName": "chr1-1\tRG\tID:foo\tSM:bar", "sequence": "CATATTTACCAATTAAAGTCACAAAATATTTCTCATTATTTATTCATGCAGGTAACTGAGACAAAGATAGTGCAGAAATCAACTTTAAATAAAAAATTAT", "qual": "@C@D@FFDFHHHHIJ.JBIJJGJGIJ:G47JHJ@IJJ91BJJIGHHHEIJDGD=IJJJBJJ'DG=3D)<D?HCHBFAE?GEDC5D5ECD<CD<DBADDBE", "cigar": null, "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": false, "properPair": null, "readMapped": false, "mateMapped": false, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": null, "mateNegativeStrand": null, "primaryAlignment": null, "secondaryAlignment": null, "supplementaryAlignment": null, "mismatchingPositions": null, "origQual": null, "attributes": null, "recordGroupName": null, "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": null, "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": null, "recordGroupPlatformUnit": null, "recordGroupSample": null, "mateAlignmentStart": null, "mateAlignmentEnd": null, "mateContig": null, "inferredInsertSize": null})
		- element of array (index: 0)
		- array (class [Lorg.bdgenomics.formats.avro.AlignmentRecord;, size 1)
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
		at org.apache.spark.rdd.RDD$$anonfun$collect$1.apply(RDD.scala:909)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.RDD.collect(RDD.scala:908)
		at org.dsw.core.DSAAdamTest$.main(DSAAdamTest.scala:24)
		at org.dsw.core.DSAAdamTest.main(DSAAdamTest.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
	

## 1.4 原因分析

主要是由于类没有序列化：、

	java.io.NotSerializableException: org.bdgenomics.formats.avro.AlignmentRecord

但是该类在引用的jar包里面，不方便直接修改，所以需要换思路解决

# 2 解决办法

## 2.1 解决思路

查看adam源码，看相关的操作，比如所有.collect,看是否有相关的操作

发现adam测试类的特质中使用的序列化

org.bdgenomics.adam.util.ADAMFunSuite：
	
	  override val appName: String = "adam"
	  override val properties: Map[String, String] = Map(
	    ("spark.serializer", "org.apache.spark.serializer.KryoSerializer"),
	    ("spark.kryo.registrator", "org.bdgenomics.adam.serialization.ADAMKryoRegistrator"),
	    ("spark.kryo.referenceTracking", "true"))

所以想应该可以尝试对SparkContext进行属性设置

## 2.2 解决办法尝试

在SparkContext定义中加入序列化配置

	.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")

发现问题解决了

详细的代码请见：

	package org.dsw.core
	
	import org.apache.spark.{SparkContext, SparkConf}
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	/**
	  * Created by xubo on 2016/12/16.
	  */
	class DSAAdamTest {
	
	
	}
	
	object DSAAdamTest {
	  def main(args: Array[String]) {
	
	    val conf = new SparkConf().setMaster("local[8]").setAppName("adam")
	      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
	    val sc = new SparkContext(conf)
	    val input = "file/input/fastq/fix1.fastq"
	    val rdd = sc.loadAlignments(input)
	    //    println(rdd)
	    rdd.foreach(println)
	    println(rdd.collect().length)
	    sc.stop()
	
	  }
	}
	
## 2.3 问题解决运行成功记录

	{"readNum": null, "contig": null, "start": null, "oldPosition": null, "end": null, "mapq": null, "readName": "chr1-1\tRG\tID:foo\tSM:bar", "sequence": "CATATTTACCAATTAAAGTCACAAAATATTTCTCATTATTTATTCATGCAGGTAACTGAGACAAAGATAGTGCAGAAATCAACTTTAAATAAAAAATTAT", "qual": "@C@D@FFDFHHHHIJ.JBIJJGJGIJ:G47JHJ@IJJ91BJJIGHHHEIJDGD=IJJJBJJ'DG=3D)<D?HCHBFAE?GEDC5D5ECD<CD<DBADDBE", "cigar": null, "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": false, "properPair": null, "readMapped": false, "mateMapped": false, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": null, "mateNegativeStrand": null, "primaryAlignment": null, "secondaryAlignment": null, "supplementaryAlignment": null, "mismatchingPositions": null, "origQual": null, "attributes": null, "recordGroupName": null, "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": null, "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": null, "recordGroupPlatformUnit": null, "recordGroupSample": null, "mateAlignmentStart": null, "mateAlignmentEnd": null, "mateContig": null, "inferredInsertSize": null}
	1

换一个大点的文件也没问题，49行的

# 3 数据

fix1.fastq

	@chr1-1	RG	ID:foo	SM:bar
	CATATTTACCAATTAAAGTCACAAAATATTTCTCATTATTTATTCATGCAGGTAACTGAGACAAAGATAGTGCAGAAATCAACTTTAAATAAAAAATTAT
	+
	@C@D@FFDFHHHHIJ.JBIJJGJGIJ:G47JHJ@IJJ91BJJIGHHHEIJDGD=IJJJBJJ'DG=3D)<D?HCHBFAE?GEDC5D5ECD<CD<DBADDBE
