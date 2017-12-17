
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

	D:\1win7\java\jdk\bin\java -Didea.launcher.port=7533 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\1win7\java\jdk\jre\lib\charsets.jar;D:\1win7\java\jdk\jre\lib\deploy.jar;D:\1win7\java\jdk\jre\lib\ext\access-bridge-64.jar;D:\1win7\java\jdk\jre\lib\ext\dnsns.jar;D:\1win7\java\jdk\jre\lib\ext\jaccess.jar;D:\1win7\java\jdk\jre\lib\ext\localedata.jar;D:\1win7\java\jdk\jre\lib\ext\sunec.jar;D:\1win7\java\jdk\jre\lib\ext\sunjce_provider.jar;D:\1win7\java\jdk\jre\lib\ext\sunmscapi.jar;D:\1win7\java\jdk\jre\lib\ext\zipfs.jar;D:\1win7\java\jdk\jre\lib\javaws.jar;D:\1win7\java\jdk\jre\lib\jce.jar;D:\1win7\java\jdk\jre\lib\jfr.jar;D:\1win7\java\jdk\jre\lib\jfxrt.jar;D:\1win7\java\jdk\jre\lib\jsse.jar;D:\1win7\java\jdk\jre\lib\management-agent.jar;D:\1win7\java\jdk\jre\lib\plugin.jar;D:\1win7\java\jdk\jre\lib\resources.jar;D:\1win7\java\jdk\jre\lib\rt.jar;D:\1win7\scala;D:\1win7\scala\lib;D:\all\idea\cloud-scale-bwamem-0.2.1\target\classes;C:\Users\xubo\.m2\repository\org\scala-lang\scala-library\2.10.4\scala-library-2.10.4.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-client\2.6.0\hadoop-client-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-common\2.6.0\hadoop-common-2.6.0.jar;C:\Users\xubo\.m2\repository\com\google\guava\guava\11.0.2\guava-11.0.2.jar;C:\Users\xubo\.m2\repository\commons-cli\commons-cli\1.2\commons-cli-1.2.jar;C:\Users\xubo\.m2\repository\org\apache\commons\commons-math3\3.1.1\commons-math3-3.1.1.jar;C:\Users\xubo\.m2\repository\xmlenc\xmlenc\0.52\xmlenc-0.52.jar;C:\Users\xubo\.m2\repository\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar;C:\Users\xubo\.m2\repository\commons-codec\commons-codec\1.4\commons-codec-1.4.jar;C:\Users\xubo\.m2\repository\commons-net\commons-net\3.1\commons-net-3.1.jar;C:\Users\xubo\.m2\repository\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar;C:\Users\xubo\.m2\repository\log4j\log4j\1.2.17\log4j-1.2.17.jar;C:\Users\xubo\.m2\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;C:\Users\xubo\.m2\repository\commons-configuration\commons-configuration\1.6\commons-configuration-1.6.jar;C:\Users\xubo\.m2\repository\commons-digester\commons-digester\1.8\commons-digester-1.8.jar;C:\Users\xubo\.m2\repository\commons-beanutils\commons-beanutils\1.7.0\commons-beanutils-1.7.0.jar;C:\Users\xubo\.m2\repository\commons-beanutils\commons-beanutils-core\1.8.0\commons-beanutils-core-1.8.0.jar;C:\Users\xubo\.m2\repository\com\google\protobuf\protobuf-java\2.5.0\protobuf-java-2.5.0.jar;C:\Users\xubo\.m2\repository\com\google\code\gson\gson\2.2.4\gson-2.2.4.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-auth\2.6.0\hadoop-auth-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\directory\server\apacheds-kerberos-codec\2.0.0-M15\apacheds-kerberos-codec-2.0.0-M15.jar;C:\Users\xubo\.m2\repository\org\apache\directory\server\apacheds-i18n\2.0.0-M15\apacheds-i18n-2.0.0-M15.jar;C:\Users\xubo\.m2\repository\org\apache\directory\api\api-asn1-api\1.0.0-M20\api-asn1-api-1.0.0-M20.jar;C:\Users\xubo\.m2\repository\org\apache\directory\api\api-util\1.0.0-M20\api-util-1.0.0-M20.jar;C:\Users\xubo\.m2\repository\org\apache\curator\curator-framework\2.6.0\curator-framework-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\curator\curator-client\2.6.0\curator-client-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\curator\curator-recipes\2.6.0\curator-recipes-2.6.0.jar;C:\Users\xubo\.m2\repository\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar;C:\Users\xubo\.m2\repository\org\htrace\htrace-core\3.0.4\htrace-core-3.0.4.jar;C:\Users\xubo\.m2\repository\org\apache\zookeeper\zookeeper\3.4.6\zookeeper-3.4.6.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-hdfs\2.6.0\hadoop-hdfs-2.6.0.jar;C:\Users\xubo\.m2\repository\org\mortbay\jetty\jetty-util\6.1.26\jetty-util-6.1.26.jar;C:\Users\xubo\.m2\repository\io\netty\netty\3.6.2.Final\netty-3.6.2.Final.jar;C:\Users\xubo\.m2\repository\xerces\xercesImpl\2.9.1\xercesImpl-2.9.1.jar;C:\Users\xubo\.m2\repository\xml-apis\xml-apis\1.3.04\xml-apis-1.3.04.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-mapreduce-client-app\2.6.0\hadoop-mapreduce-client-app-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-mapreduce-client-common\2.6.0\hadoop-mapreduce-client-common-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-yarn-client\2.6.0\hadoop-yarn-client-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-yarn-server-common\2.6.0\hadoop-yarn-server-common-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-mapreduce-client-shuffle\2.6.0\hadoop-mapreduce-client-shuffle-2.6.0.jar;C:\Users\xubo\.m2\repository\org\fusesource\leveldbjni\leveldbjni-all\1.8\leveldbjni-all-1.8.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-yarn-api\2.6.0\hadoop-yarn-api-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-mapreduce-client-core\2.6.0\hadoop-mapreduce-client-core-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-yarn-common\2.6.0\hadoop-yarn-common-2.6.0.jar;C:\Users\xubo\.m2\repository\javax\xml\bind\jaxb-api\2.2.2\jaxb-api-2.2.2.jar;C:\Users\xubo\.m2\repository\javax\xml\stream\stax-api\1.0-2\stax-api-1.0-2.jar;C:\Users\xubo\.m2\repository\javax\activation\activation\1.1\activation-1.1.jar;C:\Users\xubo\.m2\repository\com\sun\jersey\jersey-core\1.9\jersey-core-1.9.jar;C:\Users\xubo\.m2\repository\com\sun\jersey\jersey-client\1.9\jersey-client-1.9.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-mapreduce-client-jobclient\2.6.0\hadoop-mapreduce-client-jobclient-2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\hadoop\hadoop-annotations\2.6.0\hadoop-annotations-2.6.0.jar;D:\1win7\java\otherJar\spark-assembly-1.5.2-hadoop2.6.0.jar;C:\Users\xubo\.m2\repository\org\apache\avro\avro\1.7.6\avro-1.7.6.jar;C:\Users\xubo\.m2\repository\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar;C:\Users\xubo\.m2\repository\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar;C:\Users\xubo\.m2\repository\com\thoughtworks\paranamer\paranamer\2.3\paranamer-2.3.jar;C:\Users\xubo\.m2\repository\org\xerial\snappy\snappy-java\1.0.5\snappy-java-1.0.5.jar;C:\Users\xubo\.m2\repository\org\apache\commons\commons-compress\1.4.1\commons-compress-1.4.1.jar;C:\Users\xubo\.m2\repository\org\tukaani\xz\1.0\xz-1.0.jar;C:\Users\xubo\.m2\repository\org\slf4j\slf4j-api\1.6.4\slf4j-api-1.6.4.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-avro\1.4.3\parquet-avro-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-column\1.4.3\parquet-column-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-common\1.4.3\parquet-common-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-encoding\1.4.3\parquet-encoding-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-generator\1.4.3\parquet-generator-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-hadoop\1.4.3\parquet-hadoop-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-jackson\1.4.3\parquet-jackson-1.4.3.jar;C:\Users\xubo\.m2\repository\com\twitter\parquet-format\2.0.0\parquet-format-2.0.0.jar;C:\Users\xubo\.m2\repository\org\bdgenomics\bdg-formats\bdg-formats\0.2.0\bdg-formats-0.2.0.jar;C:\Users\xubo\.m2\repository\org\bdgenomics\adam\adam-core\0.14.0\adam-core-0.14.0.jar;C:\Users\xubo\.m2\repository\com\esotericsoftware\kryo\kryo\2.21\kryo-2.21.jar;C:\Users\xubo\.m2\repository\com\esotericsoftware\reflectasm\reflectasm\1.07\reflectasm-1.07-shaded.jar;C:\Users\xubo\.m2\repository\org\ow2\asm\asm\4.0\asm-4.0.jar;C:\Users\xubo\.m2\repository\com\esotericsoftware\minlog\minlog\1.2\minlog-1.2.jar;C:\Users\xubo\.m2\repository\org\objenesis\objenesis\1.2\objenesis-1.2.jar;C:\Users\xubo\.m2\repository\org\scoverage\scalac-scoverage-plugin_2.10\0.99.2\scalac-scoverage-plugin_2.10-0.99.2.jar;C:\Users\xubo\.m2\repository\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar;C:\Users\xubo\.m2\repository\it\unimi\dsi\fastutil\6.4.4\fastutil-6.4.4.jar;C:\Users\xubo\.m2\repository\org\slf4j\slf4j-log4j12\1.7.5\slf4j-log4j12-1.7.5.jar;C:\Users\xubo\.m2\repository\org\seqdoop\hadoop-bam\7.0.0\hadoop-bam-7.0.0.jar;C:\Users\xubo\.m2\repository\org\seqdoop\cofoja\1.1-r150\cofoja-1.1-r150.jar;C:\Users\xubo\.m2\repository\org\apache\httpcomponents\httpclient\4.3.2\httpclient-4.3.2.jar;C:\Users\xubo\.m2\repository\org\apache\httpcomponents\httpcore\4.3.1\httpcore-4.3.1.jar;C:\Users\xubo\.m2\repository\com\netflix\servo\servo-core\0.5.5\servo-core-0.5.5.jar;C:\Users\xubo\.m2\repository\com\google\code\findbugs\annotations\2.0.0\annotations-2.0.0.jar;C:\Users\xubo\.m2\repository\org\seqdoop\htsjdk\1.118\htsjdk-1.118.jar;C:\Users\xubo\.m2\repository\org\apache\ant\ant\1.8.2\ant-1.8.2.jar;C:\Users\xubo\.m2\repository\org\apache\ant\ant-launcher\1.8.2\ant-launcher-1.8.2.jar;C:\Users\xubo\.m2\repository\org\apache\bcel\bcel\5.2\bcel-5.2.jar;C:\Users\xubo\.m2\repository\jakarta-regexp\jakarta-regexp\1.4\jakarta-regexp-1.4.jar;C:\Users\xubo\.m2\repository\org\apache\commons\commons-jexl\2.1.1\commons-jexl-2.1.1.jar;C:\Users\xubo\.m2\repository\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;C:\Users\xubo\.m2\repository\org\testng\testng\6.8.8\testng-6.8.8.jar;C:\Users\xubo\.m2\repository\org\beanshell\bsh\2.0b4\bsh-2.0b4.jar;C:\Users\xubo\.m2\repository\com\beust\jcommander\1.27\jcommander-1.27.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain cs.ucla.edu.bwaspark.BWAMEMSparkSuite
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