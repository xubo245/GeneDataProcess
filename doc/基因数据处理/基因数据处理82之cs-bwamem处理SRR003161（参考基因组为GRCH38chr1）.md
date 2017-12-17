
core用不少了，只用了4个，实际可以14个。

1.由于GRCH过大，及其内存小，运行不了全基因组匹配

2.上传：

	spark-submit  --class cs.ucla.edu.bwaspark.BWAMEMSpark --master spark://219.219.220.149:7077  /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar upload-fastq   0 5 /xubo/alignment/data/SRR003161.fastq /xubo/data/alignment/data/SRR003161Upload.fastq
	hadoop@Master:~/xubo/project/alignment$ spark-submit  --class cs.ucla.edu.bwaspark.BWAMEMSpark --master spark://219.219.220.149:7077  /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar upload-fastq   0 5 /xubo/alignment/data/SRR003161.fastq /xubo/data/alignment/data/SRR003161Upload.fastq
	command: upload-fastq
	Map('isPairEnd -> 0, 'filePartNum -> 5, 'inFilePath1 -> /xubo/alignment/data/SRR003161.fastq, 'outFilePath -> /xubo/data/alignment/data/SRR003161Upload.fastq)
	Upload FASTQ command line arguments: 0 5 /xubo/alignment/data/SRR003161.fastq  /xubo/data/alignment/data/SRR003161Upload.fastq 250000
	[WARNING] Avro: Invalid default for field comment: null not a "bytes"
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	Upload FASTQ to HDFS Finished!!!

3.cs-bwamem比对：

	hadoop@Master:~/xubo/project/alignment$ spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath /xubo/data/alignment/output/SRR003161.adam -localRef 1  -isSWExtBatched 1  0 /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta  /xubo/data/alignment/data/SRR003161Upload.fastq
	command: cs-bwamem
	Map('isPSWJNI -> 1, 'localRef -> 1, 'batchedFolderNum -> 1, 'isPSWBatched -> 1, 'subBatchSize -> 10, 'inFASTQPath -> /xubo/data/alignment/data/SRR003161Upload.fastq, 'inFASTAPath -> /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta, 'outputPath -> /xubo/data/alignment/output/SRR003161.adam, 'isSWExtBatched -> 1, 'isPairEnd -> 0, 'outputChoice -> 2)
	CS- BWAMEM command line arguments: false /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta /xubo/data/alignment/data/SRR003161Upload.fastq 1 true 10 true ./target/jniNative.so 2 /xubo/data/alignment/output/SRR003161.adam
	HDFS master: hdfs://Master:9000
	Input HDFS folder number: 23
	Head line: @RG	ID:foo	SM:bar
	Read Group ID: foo
	Load Index Files
	Load BWA-MEM options
	Output choice: 2
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	CS-BWAMEM Finished!!!  
	Jun 9, 2016 1:44:32 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	16/06/09 14:37:41 WARN QueuedThreadPool: 6 threads could not be stopped
	16/06/09 14:37:48 WARN QueuedThreadPool: 1 threads could not be stopped
	               

4.移动数据：

	hadoop@Master:~/xubo/project/alignment$ hadoop fs -mv /xubo/data/alignment/data/SRR003161Upload.fastq /xubo/alignment/data/SRR003161Upload.fastq
	hadoop@Master:~/xubo/project/alignment$ hadoop fs -mv /xubo/data/alignment/output/SRR003161.adam /xubo/alignment/output/SRR003161.adam

5.merge：

	hadoop@Master:~/xubo/project/alignment$ spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 4 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 /xubo/alignment/output/SRR003161.adam /xubo/alignment/output/SRR003161.merge.adam
	command: merge
	Total number of new file partitions18
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	Jun 9, 2016 3:09:34 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:08 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:17 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:24 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:32 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:39 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:47 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:10:55 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:03 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:10 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:18 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:25 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:32 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:40 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:49 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:55 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:11:56 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:12:03 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:12:11 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:12:18 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:12:26 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:12:34 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5
	Jun 9, 2016 3:12:41 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 5

6.数据读取统计：
集群运行： 大数据集：

	hadoop@Master:~/xubo/project/alignment/CountAlignment$ cat load.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.alignment.CountAlignment \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/alignment/output/SRR003161.merge.adam

运行结果：
	
	hadoop@Master:~/xubo/project/alignment/CountAlignment$ ./load.sh 
	start main:
	+--------------------+---------+---------+----+----------------+--------------------+--------------------+----------------+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	|              contig|    start|      end|mapq|        readName|            sequence|                qual|           cigar|basesTrimmedFromStart|basesTrimmedFromEnd|readPaired|properPair|readMapped|mateMapped|firstOfPair|secondOfPair|failedVendorQualityChecks|duplicateRead|readNegativeStrand|mateNegativeStrand|primaryAlignment|secondaryAlignment|supplementaryAlignment|mismatchingPositions|origQual|          attributes|recordGroupName|recordGroupSequencingCenter|recordGroupDescription|recordGroupRunDateEpoch|recordGroupFlowOrder|recordGroupKeySequence|recordGroupLibrary|recordGroupPredictedMedianInsertSize|recordGroupPlatform|recordGroupPlatformUnit|recordGroupSample|mateAlignmentStart|mateAlignmentEnd|mateContig|
	+--------------------+---------+---------+----+----------------+--------------------+--------------------+----------------+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	|[chr1,248956422,n...|230167209|230167288|   3|SRR003161.900001|TCAGGAAGGCTTTGGGT...|DDDDDDDDDDDDDDDDD...|     263S79M161S|                    0|                  0|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|            true|             false|                 false|       5G41T12C0A7G9|    null|NM:i:5	AS:i:54	XS...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|231374587|231374657|   0|SRR003161.900001|GCTCACTGCAGCCTCAA...|<=====<<<<====;66...|     269H70M164H|                  269|                164|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|        9G7C24A12A14|    null|NM:i:4	AS:i:50	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 30946793| 30946858|   0|SRR003161.900001|AGCTACTCAGGAGGCTG...|====<:66666::;:::...|     171H65M267H|                  171|                267|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|           8T11T5G38|    null|NM:i:3	AS:i:50	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|245252150|245252217|   0|SRR003161.900001|CTGTAGTCCTAGCTACT...|>>><:::::=====<:6...|     161H67M275H|                  161|                275|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|         9C7A0G11T36|    null|NM:i:4	AS:i:47	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|224087945|224088001|   0|SRR003161.900001|CCTGTAGTCCTAGCTAC...|>>>><:::::=====<:...|     160H56M287H|                  160|                287|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|            10C20T24|    null|NM:i:2	AS:i:46	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|155567224|155567270|   0|SRR003161.900001|GTGATTCTCCCGCCTCA...|./4555:7.11:77;::...|     300H46M157H|                  300|                157|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|                  46|    null|NM:i:0	AS:i:46	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 83991503| 83991589|   0|SRR003161.900001|GGCACGGTGGTACACCT...|::::>>>>>>>>>>>>>...|     146H86M271H|                  146|                271|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|24C11G8T5G3G1T11A...|    null|NM:i:8	AS:i:46	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|235432538|235432598|   0|SRR003161.900001|GGAGGCTGAGGCGGGAG...|66::;:::;77:11.7:...|     180H60M263H|                  180|                263|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|           11T5G5T36|    null|NM:i:3	AS:i:45	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|200393343|200393386|   0|SRR003161.900001|GATTCTCCCGCCTCAGC...|4555:7.11:77;:::;...|     302H43M158H|                  302|                158|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|                  43|    null|NM:i:0	AS:i:43	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|244608406|244608484|   0|SRR003161.900001|ACACCTGTAGTCCTAGC...|>>>>>>><:::::====...|     157H78M268H|                  157|                268|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|  40G2T0G1T12G1C0A15|    null|NM:i:7	AS:i:43	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 99915639| 99915700|   0|SRR003161.900001|GTACACCTGTAGTCCTA...|>>>>>>>>><:::::==...|     155H61M287H|                  155|                287|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|         32A4A4T5T12|    null|NM:i:4	AS:i:41	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 26229317| 26229393|   0|SRR003161.900001|ACCTGTAGTCCTAGCTA...|>>>>><:::::=====<...|     159H76M268H|                  159|                268|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|  9T1C8G11T24G1C0A15|    null|NM:i:7	AS:i:41	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|207776701|207776752|   0|SRR003161.900001|CACTGCAGCCTCAAACT...|===<<<<====;666:;...|     272H51M180H|                  272|                180|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|            14C24A11|    null|NM:i:2	AS:i:41	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 64969003| 64969063|   0|SRR003161.900001|GGAGGCTGAGGCGGGAG...|66::;:::;77:11.7:...|     180H60M263H|                  180|                263|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|          9T2T4G5T36|    null|NM:i:4	AS:i:40	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|215011363|215011437|   0|SRR003161.900001|GCTCACTGCAGCCTCAA...|<=====<<<<====;66...|     269H74M160H|                  269|                160|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false| 10T4G1C24A0T6T12G10|    null|NM:i:7	AS:i:39	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|202096162|202096200|   0|SRR003161.900001|TAGCTCACTGCAGCCTC...|6:<=====<<<<====;...|     267H38M198H|                  267|                198|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|                  38|    null|NM:i:0	AS:i:38	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|201518889|201518942|   0|SRR003161.900001|GCCTCAGCCTCCTGAGT...|:77;:::;::66666:<...|311H36M2D15M141H|                  311|                141|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|            36^TG5A9|    null|NM:i:3	AS:i:38	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|160381379|160381422|   0|SRR003161.900001|TATCCTAGCTCACTGCA...|:<<666:<=====<<<<...|     262H43M198H|                  262|                198|     false|     false|      true|     false|      false|       false|                    false|        false|             false|             false|           false|              true|                 false|                37A5|    null|NM:i:1	AS:i:38	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...|202041920|202041962|   0|SRR003161.900001|CCTGTAGTCCTAGCTAC...|>>>><:::::=====<:...|     160H42M301H|                  160|                301|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|                6A35|    null|NM:i:1	AS:i:37	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	|[chr1,248956422,n...| 42275579| 42275615|   0|SRR003161.900001|TGAGCCCAGGAGTTTGA...|/455...47;;:666;=...|     204H36M263H|                  204|                263|     false|     false|      true|     false|      false|       false|                    false|        false|              true|             false|           false|              true|                 false|                  36|    null|NM:i:0	AS:i:36	RG...|            foo|                       null|                  null|                   null|                null|                  null|              null|                                null|               null|                   null|              bar|              null|            null|      null|
	+--------------------+---------+---------+----+----------------+--------------------+--------------------+----------------+---------------------+-------------------+----------+----------+----------+----------+-----------+------------+-------------------------+-------------+------------------+------------------+----------------+------------------+----------------------+--------------------+--------+--------------------+---------------+---------------------------+----------------------+-----------------------+--------------------+----------------------+------------------+------------------------------------+-------------------+-----------------------+-----------------+------------------+----------------+----------+
	only showing top 20 rows

24808265                                                 




附录：

问题：

	hadoop@Master:~/xubo/project/alignment$ spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath /xubo/data/alignment/output/SRR003161.adam -localRef 1  -isSWExtBatched 1  0 /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna  /xubo/alignment/data/SRR003161Upload.fastq
	command: cs-bwamem
	Map('isPSWJNI -> 1, 'localRef -> 1, 'batchedFolderNum -> 1, 'isPSWBatched -> 1, 'subBatchSize -> 10, 'inFASTQPath -> /xubo/alignment/data/SRR003161Upload.fastq, 'inFASTAPath -> /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna, 'outputPath -> /xubo/data/alignment/output/SRR003161.adam, 'isSWExtBatched -> 1, 'isPairEnd -> 0, 'outputChoice -> 2)
	CS- BWAMEM command line arguments: false /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna /xubo/alignment/data/SRR003161Upload.fastq 1 true 10 true ./target/jniNative.so 2 /xubo/data/alignment/output/SRR003161.adam
	Exception in thread "main" java.io.FileNotFoundException: File /xubo/alignment/data/SRR003161Upload.fastq does not exist.
		at org.apache.hadoop.hdfs.DistributedFileSystem.listStatusInternal(DistributedFileSystem.java:697)
		at org.apache.hadoop.hdfs.DistributedFileSystem.access$600(DistributedFileSystem.java:105)
		at org.apache.hadoop.hdfs.DistributedFileSystem$15.doCall(DistributedFileSystem.java:755)
		at org.apache.hadoop.hdfs.DistributedFileSystem$15.doCall(DistributedFileSystem.java:751)
		at org.apache.hadoop.fs.FileSystemLinkResolver.resolve(FileSystemLinkResolver.java:81)
		at org.apache.hadoop.hdfs.DistributedFileSystem.listStatus(DistributedFileSystem.java:751)
		at cs.ucla.edu.bwaspark.FastMap$.memMain(FastMap.scala:103)
		at cs.ucla.edu.bwaspark.BWAMEMSpark$.main(BWAMEMSpark.scala:301)
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
	 hadoop@Master:~/xubo/project/alignment$ spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath /xubo/data/alignment/output/SRR003161.adam -localRef 1  -isSWExtBatched 1  0 /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna  /xubo/data/alignment/data/SRR003161Upload.fastq
	command: cs-bwamem
	Map('isPSWJNI -> 1, 'localRef -> 1, 'batchedFolderNum -> 1, 'isPSWBatched -> 1, 'subBatchSize -> 10, 'inFASTQPath -> /xubo/data/alignment/data/SRR003161Upload.fastq, 'inFASTAPath -> /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna, 'outputPath -> /xubo/data/alignment/output/SRR003161.adam, 'isSWExtBatched -> 1, 'isPairEnd -> 0, 'outputChoice -> 2)
	CS- BWAMEM command line arguments: false /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna /xubo/data/alignment/data/SRR003161Upload.fastq 1 true 10 true ./target/jniNative.so 2 /xubo/data/alignment/output/SRR003161.adam
	HDFS master: hdfs://Master:9000
	Input HDFS folder number: 23
	Head line: @RG	ID:foo	SM:bar
	Read Group ID: foo
	Load Index Files
	Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		at cs.ucla.edu.bwaspark.datatype.BinaryFileReadUtil$.readIntArray(BinaryFileReadUtil.scala:151)
		at cs.ucla.edu.bwaspark.datatype.BWTType.BWTLoad(BWTType.scala:147)
		at cs.ucla.edu.bwaspark.datatype.BWTType.load(BWTType.scala:54)
		at cs.ucla.edu.bwaspark.datatype.BWAIdxType.load(BWAIdxType.scala:58)
		at cs.ucla.edu.bwaspark.FastMap$.memMain(FastMap.scala:119)
		at cs.ucla.edu.bwaspark.BWAMEMSpark$.main(BWAMEMSpark.scala:301)
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
	hadoop@Master:~/xubo/project/alignment$ spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath /xubo/data/alignment/output/SRR003161.adam -localRef 1  -isSWExtBatched 1  0 /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna  /xubo/data/alignment/data/SRR003161Upload.fastq
	command: cs-bwamem
	Map('isPSWJNI -> 1, 'localRef -> 1, 'batchedFolderNum -> 1, 'isPSWBatched -> 1, 'subBatchSize -> 10, 'inFASTQPath -> /xubo/data/alignment/data/SRR003161Upload.fastq, 'inFASTAPath -> /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna, 'outputPath -> /xubo/data/alignment/output/SRR003161.adam, 'isSWExtBatched -> 1, 'isPairEnd -> 0, 'outputChoice -> 2)
	CS- BWAMEM command line arguments: false /xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna /xubo/data/alignment/data/SRR003161Upload.fastq 1 true 10 true ./target/jniNative.so 2 /xubo/data/alignment/output/SRR003161.adam
	HDFS master: hdfs://Master:9000
	Input HDFS folder number: 23
	Head line: @RG	ID:foo	SM:bar
	Read Group ID: foo
	Load Index Files
	Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		at cs.ucla.edu.bwaspark.datatype.BinaryFileReadUtil$.readIntArray(BinaryFileReadUtil.scala:151)
		at cs.ucla.edu.bwaspark.datatype.BWTType.BWTLoad(BWTType.scala:147)
		at cs.ucla.edu.bwaspark.datatype.BWTType.load(BWTType.scala:54)
		at cs.ucla.edu.bwaspark.datatype.BWAIdxType.load(BWAIdxType.scala:58)
		at cs.ucla.edu.bwaspark.FastMap$.memMain(FastMap.scala:119)
		at cs.ucla.edu.bwaspark.BWAMEMSpark$.main(BWAMEMSpark.scala:301)
		at cs.ucla.edu.bwaspark.BWAMEMSpark.main(BWAMEMSpark.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
