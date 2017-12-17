
代码：
```
	
	package cs.ucla.edu.bwaspark
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import cs.ucla.edu.bwaspark.FastMap._
	import cs.ucla.edu.bwaspark.commandline.{BWAMEMCommand, UploadFASTQCommand}
	import org.apache.spark.sql.SQLContext
	import org.apache.spark.{SparkContext, SparkConf}
	
	/**
	  * Created by xubo on 2016/6/4.
	  */
	object BWAMEMSparkSuite {
	  def main(args: Array[String]) {
	
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	
	    val argArr = Array("cs-bwamem", "-bfn", "1", "-bPSW", "1", "-sbatch", "10",
	      "-bPSWJNI", "1", "-oChoice", "2",
	      "-oPath", "file/alignment/output/test64" + iString, "-localRef", "1",
	      "-isSWExtBatched", "1", "0", "file/alignment/input/GRCH38BWAindex/GRCH38chr1L3556522.fasta",
	      "hdfs://219.219.220.149:9000/xubo/data/alignment/cs-bwamem/fastq/g38L100c1Nhs20upload.fastq")
	    //    argArr.foreach(println)
	
	    val argsList = argArr.toList
	    var bwamemArgs = new BWAMEMCommand
	    bwamemArgs = BWAMEMSpark.bwamemCmdLineParser(argsList.tail)
	
	    //    val conf = new SparkConf().setAppName("Cloud-Scale BWAMEM: cs-bwamem").setMaster("local[4]")
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    println("align start")
	    memMain(sc, bwamemArgs)
	    println("CS-BWAMEM Finished!!!")
	
	    //    BWAMEMSpark.main(argArr)
	
	    println("align end")
	    //    val file = "hdfs://219.219.220.149:9000/xubo/16.adam/0"
	    //    val sc = new SparkContext(conf)
	    val sqlContext = new SQLContext(sc)
	    import sqlContext._
	    val df3 = sqlContext.read.option("mergeSchema", "true").parquet("file/alignment/output/test64" + iString + "/0")
	    //    df3.printSchema()
	    df3.show()
	    println(df3.count())
	    println("end")
	  }
	}

```

运行记录：

```
	cs.ucla.edu.bwaspark.BWAMEMSparkSuite
	Map('isPSWJNI -> 1, 'localRef -> 1, 'batchedFolderNum -> 1, 'isPSWBatched -> 1, 'subBatchSize -> 10, 'inFASTQPath -> hdfs://219.219.220.149:9000/xubo/data/alignment/cs-bwamem/fastq/g38L100c1Nhs20upload.fastq, 'inFASTAPath -> file/alignment/input/GRCH38BWAindex/GRCH38chr1L3556522.fasta, 'outputPath -> file/alignment/output/test6420160604172207095, 'isSWExtBatched -> 1, 'isPairEnd -> 0, 'outputChoice -> 2)
	CS- BWAMEM command line arguments: false file/alignment/input/GRCH38BWAindex/GRCH38chr1L3556522.fasta hdfs://219.219.220.149:9000/xubo/data/alignment/cs-bwamem/fastq/g38L100c1Nhs20upload.fastq 1 true 10 true ./target/jniNative.so 2 file/alignment/output/test6420160604172207095
	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/C:/Users/xubo/.m2/repository/org/slf4j/slf4j-log4j12/1.7.5/slf4j-log4j12-1.7.5.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	2016-06-04 17:22:09 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	2016-06-04 17:22:11 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
	align start
	2016-06-04 17:22:12 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:0:5efe:c0a8:168%19, but we couldn't find any external IP address!
	HDFS master: hdfs://219.219.220.149:9000
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
	2016-06-04 17:22:32 WARN  MemoryStore:71 - Not enough space to cache broadcast_0 in memory! (computed 415.5 MB so far)
	CS-BWAMEM Finished!!!
	align end
	2016-06-04 17:24:08 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	+--------------------+---------+---------+----+--------+--------------------+--------------------+-----+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	|              contig|    start|      end|mapq|readName|            sequence|                qual|cigar|basesTrimmedFromStart|basesTrimmedFromEnd|readPaired|properPair|readMapped|mateMapped|firstOfPair|secondOfPair|failedVendorQualityChecks|duplicateRead|readNegativeStrand|mateNegativeStrand|primaryAlignment|secondaryAlignment|supplementaryAlignment|mismatchingPositions|origQual|          attributes|recordGroupName|recordGroupSequencingCenter|recordGroupDescription|recordGroupRunDateEpoch|recordGroupFlowOrder|recordGroupKeySequence|recordGroupLibrary|recordGroupPredictedMedianInsertSize|recordGroupPlatform|recordGroupPlatformUnit|recordGroupSample|mateAlignmentStart|mateAlignmentEnd|mateContig|
	+--------------------+---------+---------+----+--------+--------------------+--------------------+-----+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	|[chr1,248956422,n...|225496693|225496793|  60|  chr1-1|CATATTTACCAATTAAA...|@C@D@FFDFHHHHIJ.J...| 100M|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|            true|             false|                 false|               61A38|    null|NM:i:1	AS:i:95	XS...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	+--------------------+---------+---------+----+--------+--------------------+--------------------+-----+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	
	2016-06-04 17:24:09 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	1
	end
	2016-06-04 17:24:10 WARN  QueuedThreadPool:145 - 7 threads could not be stopped
	
	Process finished with exit code 0

```