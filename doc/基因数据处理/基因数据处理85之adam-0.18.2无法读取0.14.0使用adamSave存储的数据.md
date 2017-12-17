	
	
1.介绍：
	cs-bwamem依赖的是adam-0.14.0里面的adamSave存储之后无法用adam-0.18.2的结果读取：
	
2.
	adam-0.18.2 adamsave可以用loadParquetAlignments读取。但无法用loadParquetAlignments读取adam-0.14.2
	
3.代码：
		
		package org.gcdss.cli.test
		
		import java.nio.file.Files
		import java.text.SimpleDateFormat
		import java.util._
		
		import org.apache.parquet.hadoop.metadata.CompressionCodecName
		import org.apache.spark.rdd.RDD
		import org.apache.spark.sql.SQLContext
		import org.apache.spark.{SparkConf, SparkContext}
		import org.bdgenomics.adam.rdd.{ADAMSaveAnyArgs, ADAMContext}
		import org.bdgenomics.adam.rdd.ADAMContext._
		import org.bdgenomics.adam.rdd.ADAMContext
		import org.bdgenomics.formats.avro.AlignmentRecord
		
		//import org.bdgenomics.avocado.AvocadoFunSuite
		
		
		object adamSaveTest {
		
		  def resourcePath(path: String) = ClassLoader.getSystemClassLoader.getResource(path).getFile
		
		  def tmpFile(path: String) = Files.createTempDirectory("").toAbsolutePath.toString + "/" + path
		
		  def main(args: Array[String]) {
		    println("start:")
		    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
		    val sc = new SparkContext(conf)
		    val ac = new ADAMContext(sc)
		    val sqlContext = new SQLContext(sc)
		
		    val samFile = "artificial.realigned.sam"
		
		    val rdd = sc.loadAlignments(resourcePath(samFile))
		    println(rdd.count())
		    rdd.foreach(println)
		    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
		    val output = "D:/all/idea/gcdss-master/file/learning/test/output/adamSaveTest" + iString
		    val save = new TestSaveArgs(output)
		    rdd.adamSave(save)
		
		    val rdd2 = sc.loadParquetAlignments(output)
		    println("rdd2:" + rdd2.count)
		
		    //    val samFile2 = "hdfs://219.219.220.149:9000/xubo/alignment/output/g38L100c50Nhs20upload2.adam/0"
		    //    val rdd3 = sc.loadParquetAlignments(samFile2)
		    //    println("rdd3:" + rdd3.count)
		    println("end")
		    sc.stop()
		  }
		
		  case class TestSaveArgs(var outputPath: String) extends ADAMSaveAnyArgs {
		    var sortFastqOutput = false
		    var asSingleFile = false
		    var blockSize = 128 * 1024 * 1024
		    var pageSize = 1 * 1024 * 1024
		    var compressionCodec = CompressionCodecName.GZIP
		    //    var logLevel = "SEVERE"
		    var disableDictionaryEncoding = false
		  }
		
		  //  def adamSave(filePath: String, blockSize: Int = 128 * 1024 * 1024,
		  //               pageSize: Int = 1 * 1024 * 1024, compressCodec: CompressionCodecName = CompressionCodecName.GZIP,
		  //               disableDictionaryEncoding: Boolean = false) {}
		
		}
	
	
4.记录：
	
	10
	{"readNum": 0, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 0, "oldPosition": 10, "end": 70, "mapq": 100, "readName": "read2", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGGGGGGGGGGAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "34M10D26M", "oldCigar": "44M10D16M", "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": null, "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tOP:i:11\tNM:i:10\tRG:Z:read_group_id\tOC:Z:44M10D16M", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 110, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": 111}
	{"readNum": 0, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 5, "oldPosition": null, "end": 75, "mapq": 90, "readName": "read1", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "29M10D31M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "29^GGGGGGGGGG10G0G0G0G0G0G0G0G0G0G11", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tNM:i:20\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 105, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": 101}
	{"readNum": 0, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 10, "oldPosition": 20, "end": 80, "mapq": 100, "readName": "read4", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGGGGGGGGGGAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "24M10D36M", "oldCigar": "34M10D26M", "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": null, "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tOP:i:21\tNM:i:10\tRG:Z:read_group_id\tOC:Z:34M10D26M", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 120, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": 111}
	{"readNum": 0, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 15, "oldPosition": null, "end": 85, "mapq": 90, "readName": "read3", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "19M10D41M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "19^GGGGGGGGGG10G0G0G0G0G0G0G0G0G0G21", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tNM:i:20\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 115, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": 101}
	{"readNum": 0, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 25, "oldPosition": null, "end": 95, "mapq": 90, "readName": "read5", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "9M10D51M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "9^GGGGGGGGGG10G0G0G0G0G0G0G0G0G0G31", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tNM:i:20\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 125, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": 101}
	{"readNum": 1, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 105, "oldPosition": null, "end": 165, "mapq": 90, "readName": "read1", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "60M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "60", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tNM:i:0\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 5, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": -101}
	{"readNum": 1, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 110, "oldPosition": null, "end": 170, "mapq": 90, "readName": "read2", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "60M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "60", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:100\tNM:i:0\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 0, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": -111}
	{"readNum": 1, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 115, "oldPosition": null, "end": 175, "mapq": 90, "readName": "read3", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "60M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "60", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tNM:i:0\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 15, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": -101}
	{"readNum": 1, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 120, "oldPosition": null, "end": 180, "mapq": 90, "readName": "read4", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "60M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "60", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:100\tNM:i:0\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 10, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": -111}
	{"readNum": 1, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "start": 125, "oldPosition": null, "end": 185, "mapq": 90, "readName": "read5", "sequence": "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "qual": "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII", "cigar": "60M", "oldCigar": null, "basesTrimmedFromStart": 0, "basesTrimmedFromEnd": 0, "readPaired": true, "properPair": true, "readMapped": true, "mateMapped": true, "failedVendorQualityChecks": false, "duplicateRead": false, "readNegativeStrand": false, "mateNegativeStrand": false, "primaryAlignment": true, "secondaryAlignment": false, "supplementaryAlignment": false, "mismatchingPositions": "60", "origQual": null, "attributes": "XS:i:70\tAS:i:70\tMQ:i:90\tNM:i:0\tRG:Z:read_group_id", "recordGroupName": "read_group_id", "recordGroupSequencingCenter": null, "recordGroupDescription": null, "recordGroupRunDateEpoch": null, "recordGroupFlowOrder": null, "recordGroupKeySequence": null, "recordGroupLibrary": "library", "recordGroupPredictedMedianInsertSize": null, "recordGroupPlatform": "illumina", "recordGroupPlatformUnit": "platform_unit", "recordGroupSample": "sequencing_center", "mateAlignmentStart": 25, "mateAlignmentEnd": null, "mateContig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": 0}, "inferredInsertSize": -101}
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	rdd2:10
	2016-06-09 19:25:36 ERROR Executor:96 Exception in task 0.0 in stage 4.0 (TID 4)
	org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/g38L100c50Nhs20upload2.adam/0/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
		at java.lang.Thread.run(Unknown Source)
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:157)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:42)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:92)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:177)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
	2016-06-09 19:25:36 WARN  TaskSetManager:71 Lost task 0.0 in stage 4.0 (TID 4, localhost): org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/g38L100c50Nhs20upload2.adam/0/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
		at java.lang.Thread.run(Unknown Source)
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:157)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:42)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:92)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:177)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
	
	2016-06-09 19:25:36 ERROR TaskSetManager:75 Task 0 in stage 4.0 failed 1 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 4.0 failed 1 times, most recent failure: Lost task 0.0 in stage 4.0 (TID 4, localhost): org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/g38L100c50Nhs20upload2.adam/0/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
		at java.lang.Thread.run(Unknown Source)
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:157)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:42)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:92)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:177)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
	
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
		at org.gcdss.cli.test.adamSaveTest$.main(adamSaveTest.scala:47)
		at org.gcdss.cli.test.adamSaveTest.main(adamSaveTest.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
		at java.lang.reflect.Method.invoke(Unknown Source)
		at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
	Caused by: org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/g38L100c50Nhs20upload2.adam/0/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
		at java.lang.Thread.run(Unknown Source)
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:157)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:42)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:92)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:177)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more


（2）adam-shell：

	scala>  val file = "hdfs://219.219.220.149:9000/xubo/alignment/output/SRR003161.merge.adam"
	file: String = hdfs://219.219.220.149:9000/xubo/alignment/output/SRR003161.merge.adam
	
	scala>  val rdd2=  sc.loadParquetAlignments(file)
	rdd2: org.apache.spark.rdd.RDD[org.bdgenomics.formats.avro.AlignmentRecord] = MapPartitionsRDD[7] at map at ADAMContext.scala:167
	
	scala> rdd2.count
	[Stage 3:>                                                         (0 + 2) / 18]16/06/09 17:17:54 ERROR Executor: Exception in task 1.0 in stage 3.0 (TID 4)
	org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/SRR003161.merge.adam/part-r-00001.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
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
	Caused by: java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Long
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:261)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:168)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:46)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:95)
		at org.apache.parquet.avro.AvroConverters$BinaryConverter.addValueFromDictionary(AvroConverters.java:81)
		at org.apache.parquet.column.impl.ColumnReaderImpl$1.writeValue(ColumnReaderImpl.java:170)
		at org.apache.parquet.column.impl.ColumnReaderImpl.writeCurrentValueToConverter(ColumnReaderImpl.java:365)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:405)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
	16/06/09 17:17:54 ERROR Executor: Exception in task 0.0 in stage 3.0 (TID 3)
	org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/SRR003161.merge.adam/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
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
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:168)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:46)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:95)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:189)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
	[Stage 3:>                                                         (0 + 3) / 18]16/06/09 17:17:54 ERROR TaskSetManager: Task 0 in stage 3.0 failed 1 times; aborting job
	org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 3.0 failed 1 times, most recent failure: Lost task 0.0 in stage 3.0 (TID 3, localhost): org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/SRR003161.merge.adam/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
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
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:168)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:46)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:95)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:189)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
	
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
		at $iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC.<init>(<console>:29)
		at $iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC.<init>(<console>:34)
		at $iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC.<init>(<console>:36)
		at $iwC$$iwC$$iwC$$iwC$$iwC$$iwC$$iwC.<init>(<console>:38)
		at $iwC$$iwC$$iwC$$iwC$$iwC$$iwC.<init>(<console>:40)
		at $iwC$$iwC$$iwC$$iwC$$iwC.<init>(<console>:42)
		at $iwC$$iwC$$iwC$$iwC.<init>(<console>:44)
		at $iwC$$iwC$$iwC.<init>(<console>:46)
		at $iwC$$iwC.<init>(<console>:48)
		at $iwC.<init>(<console>:50)
		at <init>(<console>:52)
		at .<init>(<console>:56)
		at .<clinit>(<console>)
		at .<init>(<console>:7)
		at .<clinit>(<console>)
		at $print(<console>)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.repl.SparkIMain$ReadEvalPrint.call(SparkIMain.scala:1065)
		at org.apache.spark.repl.SparkIMain$Request.loadAndRun(SparkIMain.scala:1340)
		at org.apache.spark.repl.SparkIMain.loadAndRunReq$1(SparkIMain.scala:840)
		at org.apache.spark.repl.SparkIMain.interpret(SparkIMain.scala:871)
		at org.apache.spark.repl.SparkIMain.interpret(SparkIMain.scala:819)
		at org.apache.spark.repl.SparkILoop.reallyInterpret$1(SparkILoop.scala:857)
		at org.apache.spark.repl.SparkILoop.interpretStartingWith(SparkILoop.scala:902)
		at org.apache.spark.repl.SparkILoop.command(SparkILoop.scala:814)
		at org.apache.spark.repl.SparkILoop.processLine$1(SparkILoop.scala:657)
		at org.apache.spark.repl.SparkILoop.innerLoop$1(SparkILoop.scala:665)
		at org.apache.spark.repl.SparkILoop.org$apache$spark$repl$SparkILoop$$loop(SparkILoop.scala:670)
		at org.apache.spark.repl.SparkILoop$$anonfun$org$apache$spark$repl$SparkILoop$$process$1.apply$mcZ$sp(SparkILoop.scala:997)
		at org.apache.spark.repl.SparkILoop$$anonfun$org$apache$spark$repl$SparkILoop$$process$1.apply(SparkILoop.scala:945)
		at org.apache.spark.repl.SparkILoop$$anonfun$org$apache$spark$repl$SparkILoop$$process$1.apply(SparkILoop.scala:945)
		at scala.tools.nsc.util.ScalaClassLoader$.savingContextLoader(ScalaClassLoader.scala:135)
		at org.apache.spark.repl.SparkILoop.org$apache$spark$repl$SparkILoop$$process(SparkILoop.scala:945)
		at org.apache.spark.repl.SparkILoop.process(SparkILoop.scala:1059)
		at org.apache.spark.repl.Main$.main(Main.scala:31)
		at org.apache.spark.repl.Main.main(Main.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: org.apache.parquet.io.ParquetDecodingException: Can not read value at 0 in block 0 in file hdfs://219.219.220.149:9000/xubo/alignment/output/SRR003161.merge.adam/part-r-00000.gz.parquet
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:228)
		at org.apache.parquet.hadoop.ParquetRecordReader.nextKeyValue(ParquetRecordReader.java:201)
		at org.apache.spark.rdd.NewHadoopRDD$$anon$1.hasNext(NewHadoopRDD.scala:163)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
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
	Caused by: java.lang.ClassCastException: org.bdgenomics.formats.avro.Contig cannot be cast to java.lang.Integer
		at org.bdgenomics.formats.avro.AlignmentRecord.put(AlignmentRecord.java:257)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.set(AvroIndexedRecordConverter.java:168)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.access$000(AvroIndexedRecordConverter.java:46)
		at org.apache.parquet.avro.AvroIndexedRecordConverter$1.add(AvroIndexedRecordConverter.java:95)
		at org.apache.parquet.avro.AvroIndexedRecordConverter.end(AvroIndexedRecordConverter.java:189)
		at org.apache.parquet.io.RecordReaderImplementation.read(RecordReaderImplementation.java:413)
		at org.apache.parquet.hadoop.InternalParquetRecordReader.nextKeyValue(InternalParquetRecordReader.java:209)
		... 15 more
