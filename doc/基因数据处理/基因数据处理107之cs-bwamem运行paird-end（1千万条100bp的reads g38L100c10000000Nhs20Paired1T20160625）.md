

1.upload:
	
	hadoop@Master:~/xubo/project/alignment/cs-bwamem$ cat align.sh 
	#spark-submit  --class cs.ucla.edu.bwaspark.BWAMEMSpark --master spark://219.219.220.149:7077  /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar upload-fastq   1 7 ~/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired1.fastq ~/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired2.fastq /xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired1T20160625.fastq
	 startTime4=`date +"%s.%N"`
	
	spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath hdfs://219.219.220.149:9000/xubo/alignment/cs-bwamem/input/fastq/g38L100c10000000Nhs20Paired1T20160625.adam -localRef 1 -jniPath /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/jniNative.so -isSWExtBatched 1  1 /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta  /xubo/alignment/cs-bwamem/input/fastq/g38L100c10000000Nhs20Paired1T20160625.fastq
	
	endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`

成功：

	Remaining raw read #: 7632
	[Stage 295:>                                                        (0 + 0) / 7]Remaining raw read #: 7632
	[DEBUG] Main Thread, Before while loop: isHDFSWriteDone = false
	Waiting for I/O
	[Stage 295:>                                                        (0 + 7) / 7]Waiting for I/O
	[DEBUG] Forked thread, Before: isHDFSWriteDone = false                          
	Successfully write the FASTQ file partitions to HDFS: 1
	[DEBUG] Forked thread, After: isHDFSWriteDone = true
	[DEBUG] Main Thread, After while loop: isHDFSWriteDone = true
	[DEBUG] Main Thread, Final value: isHDFSWriteDone = false
	[DEBUG] Main Thread (Final iteration), Before while loop: isHDFSWriteDone = false
	Waiting for I/O
	[DEBUG] Forked thread, Before: isHDFSWriteDone = false
	Successfully write the FASTQ file partitions to HDFS: 1
	[DEBUG] Forked thread, After: isHDFSWriteDone = true
	[DEBUG] Main Thread (Final iteration), After while loop: isHDFSWriteDone = true
	[DEBUG] Main Thread (Final iteration), Final value: isHDFSWriteDone = false
	Upload FASTQ to HDFS Finished!!!

时间：
18min12s

2.align:
	
运行脚本：
	
	hadoop@Master:~/xubo/project/alignment/cs-bwamem$ cat align.sh 
	
	 startTime4=`date +"%s.%N"`
	
	spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath hdfs://219.219.220.149:9000/xubo/alignment/cs-bwamem/input/fastq/g38L100c10000000Nhs20Paired1T20160625.adam -localRef 1 -jniPath /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/jniNative.so -isSWExtBatched 1  1 /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta  /xubo/alignment/cs-bwamem/input/fastq/g38L100c10000000Nhs20Paired1T20160625.fastq
	
	endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`



部分结果：

	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.48672724670865 9.97095286867575
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.57582385535142, 9.936669332978644)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.57582385535142 9.936669332978644
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Summary:                                                                        
	Worker1 Time: 1485278
	Calculate Metrics Time: 5404
	Worker2 Time: 2266951
	CS-BWAMEM Finished!!!
	Jun 25, 2016 6:18:20 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 6:19:05 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	=> RunTime:3930.020333 s


3.merge:

运行代码：

	hadoop@Master:~/xubo/project/alignment/cs-bwamem$ cat merge.sh 
	
	 startTime4=`date +"%s.%N"`
	
	spark-submit --executor-memory 6g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 /xubo/alignment/cs-bwamem/input/fastq/g38L100c10000000Nhs20Paired1T20160625.adam /xubo/alignment/cs-bwamem/input/fastq/g38L100c10000000Nhs20Paired1T20160625.merge.adam
	
	endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`

部分结果：
	
	Jun 25, 2016 7:38:55 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:56 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:56 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:57 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:57 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:58 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:58 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:58 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:59 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:38:59 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:39:00 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:39:00 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:39:01 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	Jun 25, 2016 7:39:01 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 7
	=> RunTime:443.641028 s



#参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
		
#研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
#Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	