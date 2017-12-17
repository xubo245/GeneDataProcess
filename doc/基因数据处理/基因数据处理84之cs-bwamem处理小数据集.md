

1.使用的是之前的数据：
	 spark-submit  --class cs.ucla.edu.bwaspark.BWAMEMSpark --master local[2]  /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar upload-fastq   0 1 fastq/g38L100c50Nhs20.fastq /xubo/data/alignment/cs-bwamem/fastq/g38L100c50Nhs20upload2.fastq


2.之后有移动，所以比对时是：
	
	hadoop@Master:~/xubo/project/alignment/CountAlignment$ spark-submit --executor-memory 2g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 2 --master local[2]  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=2 --conf spark.driver.maxResultSize=2g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath /xubo/alignment/output/g38L100c50Nhs20upload2.adam -localRef 1  -isSWExtBatched 1  0 /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta  /xubo/alignment/cs-bwamem/input/fastq/g38L100c50Nhs20upload2.fastq
	command: cs-bwamem
	Map('isPSWJNI -> 1, 'localRef -> 1, 'batchedFolderNum -> 1, 'isPSWBatched -> 1, 'subBatchSize -> 10, 'inFASTQPath -> /xubo/alignment/cs-bwamem/input/fastq/g38L100c50Nhs20upload2.fastq, 'inFASTAPath -> /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta, 'outputPath -> /xubo/alignment/output/g38L100c50Nhs20upload2.adam, 'isSWExtBatched -> 1, 'isPairEnd -> 0, 'outputChoice -> 2)
	CS- BWAMEM command line arguments: false /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta /xubo/alignment/cs-bwamem/input/fastq/g38L100c50Nhs20upload2.fastq 1 true 10 true ./target/jniNative.so 2 /xubo/alignment/output/g38L100c50Nhs20upload2.adam
	HDFS master: hdfs://Master:9000
	Input HDFS folder number: 1
	Head line: @RG	ID:foo	SM:bar
	Read Group ID: foo
	Load Index Files
	Load BWA-MEM options
	Output choice: 2
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	[WARNING] Avro: Invalid default for field comment: null not a "bytes"
	[WARNING] Avro: Invalid default for field comment: null not a "bytes"
	[WARNING] Avro: Invalid default for field comment: null not a "bytes"
	CS-BWAMEM Finished!!!
	Jun 9, 2016 4:30:59 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 1
	Jun 9, 2016 4:31:01 PM WARNING: parquet.hadoop.ParquetRecordReader: Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	Jun 9, 2016 4:31:02 PM INFO: parquet.hadoop.InternalParquetRecordReader: RecordReader initialized will read a total of 49 records.
	Jun 9, 2016 4:31:02 PM INFO: parquet.hadoop.InternalParquetRecordReader: at row 0. reading next block
	Jun 9, 2016 4:31:02 PM INFO: parquet.hadoop.InternalParquetRecordReader: block read in memory in 99 ms. row count = 49


3.merge：有问题 未解决

	hadoop@Master:~/xubo/project/alignment/CountAlignment$ spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 4 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 /xubo/alignment/output/g38L100c50Nhs20upload2.adam /xubo/alignment/output/g38L100c50Nhs20upload2.merge.adam
	command: merge
	Total number of new file partitions0
	Exception in thread "main" java.lang.IllegalArgumentException: requirement failed: Number of partitions (0) must be positive.
		at scala.Predef$.require(Predef.scala:233)
		at org.apache.spark.rdd.CoalescedRDD.<init>(CoalescedRDD.scala:81)
		at org.apache.spark.rdd.RDD$$anonfun$coalesce$1.apply(RDD.scala:409)
		at org.apache.spark.rdd.RDD$$anonfun$coalesce$1.apply(RDD.scala:391)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.RDD.coalesce(RDD.scala:390)
		at cs.ucla.edu.bwaspark.dnaseq.MergeADAMFiles$.apply(MergeADAMFiles.scala:41)
		at cs.ucla.edu.bwaspark.BWAMEMSpark$.main(BWAMEMSpark.scala:323)
		at cs.ucla.edu.bwaspark.BWAMEMSpark.main(BWAMEMSpark.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Jun 9, 2016 4:33:23 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 1
	Jun 9, 2016 4:33:40 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 1
	hadoop@Master:~/xubo/project/alignment/CountAlignment$ 


4.读取;
由于没有合并，只能读取partition下面的数据：

	package org.gcdss.cli.alignment
	
	import org.gcdss.cli.callVariant.callVariantByAvocado
	import org.scalatest.FunSuite
	
	/**
	  * Created by xubo on 2016/6/9.
	  */
	class CountAlignmentSuite extends FunSuite {
	  test("artificial fa By runLocal") {
	    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    println("start Suite:")
	    //    val file = "hdfs://219.219.220.149:9000/xubo/callVariant/avocado/artificial/artificial.realigned.sam"
	    val file = "hdfs://219.219.220.149:9000/xubo/alignment/output/g38L100c50Nhs20upload2.adam/0"
	    CountAlignment.runLocal(Array(file))
	
	    println("end Suite")
	    //      .runLocal
	  }
	}

运行结果：
	
	start Suite:
	start runLocal:
	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/D:/1win7/java/apache-maven-3.3.9-bin/Repository/org/slf4j/slf4j-log4j12/1.7.12/slf4j-log4j12-1.7.12.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	2016-06-09 16:43:30 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	2016-06-09 16:43:32 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
	2016-06-09 16:43:34 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%20, but we couldn't find any external IP address!
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	2016-06-09 16:43:38 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	+--------------------+---------+---------+----+--------+--------------------+--------------------+-----+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	|              contig|    start|      end|mapq|readName|            sequence|                qual|cigar|basesTrimmedFromStart|basesTrimmedFromEnd|readPaired|properPair|readMapped|mateMapped|firstOfPair|secondOfPair|failedVendorQualityChecks|duplicateRead|readNegativeStrand|mateNegativeStrand|primaryAlignment|secondaryAlignment|supplementaryAlignment|mismatchingPositions|origQual|          attributes|recordGroupName|recordGroupSequencingCenter|recordGroupDescription|recordGroupRunDateEpoch|recordGroupFlowOrder|recordGroupKeySequence|recordGroupLibrary|recordGroupPredictedMedianInsertSize|recordGroupPlatform|recordGroupPlatformUnit|recordGroupSample|mateAlignmentStart|mateAlignmentEnd|mateContig|
	+--------------------+---------+---------+----+--------+--------------------+--------------------+-----+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	|[chr1,248956422,n...| 93465784| 93465884|  26| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|            true|             false|                 false|                 100|    null|NM:i:0	AS:i:100	X...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|101668921|101669021|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|231780491|231780591|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 69447775| 69447875|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 71519060| 71519160|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|187344346|187344446|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|188353053|188353153|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|242097330|242097430|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|112217125|112217225|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|218009808|218009908|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|147407851|147407951|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 45962351| 45962451|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 47126825| 47126925|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|152431792|152431892|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|237080611|237080711|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 82131491| 82131591|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 69486875| 69486975|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|224551051|224551151|   0| chr1-50|TTAAAAAGTCAGGAAAC...|DCDDE<DFEC<CCD,D8...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|              80C9C9|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|154119974|154120074|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 78244128| 78244228|   0| chr1-50|TTCCACAATAGTTGAAC...|@@CDFDFDHFHGHIJH:...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|              9G9G80|    null|NM:i:2	AS:i:90	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	+--------------------+---------+---------+----+--------+--------------------+--------------------+-----+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	only showing top 20 rows
	
	2016-06-09 16:43:39 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	492
	end Suite




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
	