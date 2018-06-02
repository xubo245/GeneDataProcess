代码：
	
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ cat g38L100c10000000Nhs20Paired12SparkBWAlocalPartition0.sh 
	echo "start"
	startTime4=`date +"%s.%N"`
	        time4=`date +"%Y%m%d%H%M%S"`
	         #spark-submit --class org.apache.spark.examples.SparkPi     --master spark://219.219.220.149:7077     /home/hadoop/cloud/spark-1.5.2/lib/spark-examples*.jar     $i
	
	echo $startTime4
	j=0
	output2='/xubo/alignment/output/sparkBWA/AAg38L100c10000000Nhs20Paired12SparkBWAlocalPartition'$j
	
	
	
	spark-submit --class SparkBWA \
	--master local \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions $j \
	/xubo/alignment/sparkBWA/g38L100c10000000Nhs20Paired1.fastq /xubo/alignment/sparkBWA/g38L100c10000000Nhs20Paired2.fastq \
	$output2
	
	        endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf "  g38L100c10000000Nhs20Paired12SparkBWAlocalPartition0  RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	echo "end"
		
	
记录：
	
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD9_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD9_2
	[main] Real time: 173.507 sec; CPU: 3291.728 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:===================================>                     (10 + 1) / 16][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-10.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-10.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD10_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD10_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD10_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD10_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44785, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_process_seqs] Processed 100000 reads in 27.339 CPU sec, 27.213 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44790, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.025 CPU sec, 26.834 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44763, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.354 CPU sec, 27.170 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44700, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.956 CPU sec, 26.756 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44771, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.758 CPU sec, 27.549 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44686, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.37, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.541 CPU sec, 27.325 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44569, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 28.372 CPU sec, 28.164 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44554, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.921 CPU sec, 27.704 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44646, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.462 CPU sec, 27.256 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44704, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.445 CPU sec, 27.231 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44673, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.113 CPU sec, 26.910 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44894, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 10.01)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_process_seqs] Processed 100000 reads in 26.783 CPU sec, 26.586 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44825, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.675 CPU sec, 26.471 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44762, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.58, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.982 CPU sec, 26.774 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44789, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.817 CPU sec, 26.617 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44857, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.503 CPU sec, 26.289 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44712, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.704 CPU sec, 26.493 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44750, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.42, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.341 CPU sec, 27.128 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44710, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.055 CPU sec, 26.863 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44693, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.280 CPU sec, 27.079 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44736, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_process_seqs] Processed 100000 reads in 27.419 CPU sec, 27.246 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44769, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.156 CPU sec, 26.956 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44696, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 28.512 CPU sec, 27.343 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44618, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.729 CPU sec, 27.321 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44689, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.804 CPU sec, 26.602 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:===================================>                     (10 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44658, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.620 CPU sec, 26.408 real sec
	[M::process] read 24880 sequences (2488000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44770, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.47, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.686 CPU sec, 26.533 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 11071, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 206)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (164, 234)
	[M::mem_pestat] mean and std.dev: (198.75, 10.08)
	[M::mem_pestat] low and high boundaries for proper pairs: (150, 248)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 24880 reads in 6.567 CPU sec, 6.474 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD10_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD10_2
	[main] Real time: 742.582 sec; CPU: 4137.643 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:=======================================>                 (11 + 1) / 16][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-11.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-11.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD11_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD11_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD11_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD11_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44657, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.191 CPU sec, 26.069 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=======================================>                 (11 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44700, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.57, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.577 CPU sec, 26.379 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44588, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.232 CPU sec, 27.036 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44742, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.202 CPU sec, 25.985 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=======================================>                 (11 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44802, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.663 CPU sec, 26.464 real sec
	[M::process] read 31106 sequences (3110600 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44585, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.332 CPU sec, 27.170 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 13934, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:=======================================>                 (11 + 1) / 16][M::mem_process_seqs] Processed 31106 reads in 8.253 CPU sec, 8.162 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD11_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD11_2
	[main] Real time: 176.186 sec; CPU: 4345.330 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:==========================================>              (12 + 1) / 16][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-12.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-12.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD12_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD12_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD12_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD12_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44586, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.147 CPU sec, 27.038 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:==========================================>              (12 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44826, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.56, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.657 CPU sec, 26.465 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44649, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.054 CPU sec, 26.876 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:==========================================>              (12 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44652, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.941 CPU sec, 26.742 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44783, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.278 CPU sec, 27.127 real sec
	[M::process] read 41932 sequences (4193200 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44695, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.44, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:==========================================>              (12 + 1) / 16][M::mem_process_seqs] Processed 100000 reads in 26.638 CPU sec, 26.472 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 18723, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 10.01)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 41932 reads in 11.339 CPU sec, 11.239 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD12_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD12_2
	[main] Real time: 179.552 sec; CPU: 4536.304 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:==============================================>          (13 + 1) / 16][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-13.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-13.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD13_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD13_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD13_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD13_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44759, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.56, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.837 CPU sec, 26.719 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:==============================================>          (13 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44712, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.762 CPU sec, 26.548 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44771, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.582 CPU sec, 26.379 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44857, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.796 CPU sec, 26.578 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:==============================================>          (13 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44760, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.964 CPU sec, 26.764 real sec
	[M::process] read 31102 sequences (3110200 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44707, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.967 CPU sec, 26.802 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 13951, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.35, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 31102 reads in 8.415 CPU sec, 8.322 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD13_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD13_2
	[main] Real time: 175.634 sec; CPU: 4713.433 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:=================================================>       (14 + 1) / 16][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-14.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-14.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD14_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD14_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD14_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD14_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44648, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_process_seqs] Processed 100000 reads in 27.549 CPU sec, 27.423 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44715, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.444 CPU sec, 27.240 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44734, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.009 CPU sec, 26.793 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44779, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.58, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.211 CPU sec, 27.022 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44745, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.44, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.279 CPU sec, 27.084 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44776, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.57, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.005 CPU sec, 26.809 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44795, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.879 CPU sec, 26.685 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44604, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.567 CPU sec, 27.367 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44687, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.40, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.195 CPU sec, 27.001 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44611, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.59, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_process_seqs] Processed 100000 reads in 27.279 CPU sec, 27.072 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44720, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.822 CPU sec, 26.610 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44684, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.57, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.259 CPU sec, 27.043 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44637, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.189 CPU sec, 26.973 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44770, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.47, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.268 CPU sec, 27.056 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44742, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.58, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.871 CPU sec, 26.662 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44713, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.490 CPU sec, 27.284 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44672, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.945 CPU sec, 26.735 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44766, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.47, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.917 CPU sec, 26.707 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44702, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.88)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.341 CPU sec, 27.120 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44700, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.131 CPU sec, 26.915 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44798, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.334 CPU sec, 26.123 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44737, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.290 CPU sec, 27.075 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44790, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.39, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.615 CPU sec, 26.397 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44669, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.827 CPU sec, 26.614 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44695, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.805 CPU sec, 27.591 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=================================================>       (14 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44686, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 27.034 CPU sec, 26.815 real sec
	[M::process] read 24882 sequences (2488200 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44736, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.996 CPU sec, 26.829 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 11126, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 24882 reads in 6.845 CPU sec, 6.754 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD14_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD14_2
	[main] Real time: 741.079 sec; CPU: 5555.997 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:=====================================================>   (15 + 1) / 16][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-15.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L100c10000000Nhs20Paired1.fastq-0-NoSort-local-1466855179484-15.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD15_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD15_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD15_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD15_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44791, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.724 CPU sec, 26.607 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=====================================================>   (15 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44715, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.70, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.226 CPU sec, 26.031 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44732, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.307 CPU sec, 26.119 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 2:=====================================================>   (15 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44808, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.248 CPU sec, 26.068 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44764, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.628 CPU sec, 26.441 real sec
	[M::process] read 31100 sequences (3110000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44775, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.44, 9.88)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.547 CPU sec, 26.396 real sec
	[Stage 2:=====================================================>   (15 + 1) / 16][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 13967, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 10.03)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 31100 reads in 8.007 CPU sec, 7.915 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD15_1 /home/hadoop/cloud/workspace/tmplocal-1466855179484-RDD15_2
	[main] Real time: 172.849 sec; CPU: 5754.717 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	=> g38L100c10000000Nhs20Paired12SparkBWAlocalPartition0 RunTime:6444.173342 s   
	end
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ 
