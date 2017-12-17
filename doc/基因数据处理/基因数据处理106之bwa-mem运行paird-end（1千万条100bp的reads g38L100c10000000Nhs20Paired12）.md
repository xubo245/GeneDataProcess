脚本：
	
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ cat g38L100c10000000Nhs20Paired12Bwamem.sh 
	echo "start"
	startTime4=`date +"%s.%N"`
	        time4=`date +"%Y%m%d%H%M%S"`
	         #spark-submit --class org.apache.spark.examples.SparkPi     --master spark://219.219.220.149:7077     /home/hadoop/cloud/spark-1.5.2/lib/spark-examples*.jar     $i
	
	echo $startTime4
	
	bwa mem ~/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta ~/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired1.fq ~/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired2.fq > ~/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired12.sam
	
	        endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " bwa mem local with ERR000589_12 RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	echo "end"
	
	
	
记录：
	
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.354 CPU sec, 25.239 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44634, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.825 CPU sec, 25.734 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44612, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.643 CPU sec, 25.571 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44699, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.62, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.080 CPU sec, 24.988 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44694, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.333 CPU sec, 25.231 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44813, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.902 CPU sec, 25.801 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44662, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.88)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.619 CPU sec, 25.505 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44752, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.404 CPU sec, 25.295 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44530, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.502 CPU sec, 25.394 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44689, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.477 CPU sec, 25.383 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44749, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.526 CPU sec, 25.409 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44604, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.745 CPU sec, 25.643 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44728, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.44, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.977 CPU sec, 24.877 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44769, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.485 CPU sec, 25.380 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44720, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.144 CPU sec, 25.026 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44643, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.426 CPU sec, 25.320 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44676, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.226 CPU sec, 25.111 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44710, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.942 CPU sec, 25.839 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44653, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.614 CPU sec, 25.530 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44682, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.005 CPU sec, 24.908 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44719, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.172 CPU sec, 25.058 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44687, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.542 CPU sec, 25.433 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44843, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.39, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.707 CPU sec, 25.593 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44781, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.149 CPU sec, 25.039 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44672, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.42, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.893 CPU sec, 25.782 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44777, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.765 CPU sec, 25.658 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44713, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.294 CPU sec, 25.189 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44731, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.773 CPU sec, 25.670 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44803, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.44, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.314 CPU sec, 25.213 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44684, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.328 CPU sec, 26.227 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44803, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 10.01)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.084 CPU sec, 24.969 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44680, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.218 CPU sec, 25.119 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44654, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.868 CPU sec, 25.758 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44794, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.56, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.767 CPU sec, 25.665 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44698, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.466 CPU sec, 25.357 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44754, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.61, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.511 CPU sec, 25.400 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44784, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.964 CPU sec, 25.845 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44739, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.091 CPU sec, 25.984 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44855, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.177 CPU sec, 25.071 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44792, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 10.03)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.830 CPU sec, 24.720 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44821, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.732 CPU sec, 25.617 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44799, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.656 CPU sec, 25.561 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44810, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.186 CPU sec, 25.075 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44695, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.40, 9.87)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.526 CPU sec, 25.424 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44842, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.39, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.200 CPU sec, 25.085 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44693, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.608 CPU sec, 25.502 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44706, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.050 CPU sec, 25.935 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44776, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.227 CPU sec, 25.123 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44789, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.698 CPU sec, 25.591 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44783, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.300 CPU sec, 25.198 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44654, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.211 CPU sec, 26.115 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44603, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.43, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.386 CPU sec, 26.280 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44783, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.571 CPU sec, 25.453 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44651, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.88)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.384 CPU sec, 25.277 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44727, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.238 CPU sec, 25.119 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44686, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.063 CPU sec, 25.975 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44641, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.048 CPU sec, 25.956 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44727, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.87)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.376 CPU sec, 25.285 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44789, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.992 CPU sec, 24.895 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44684, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.782 CPU sec, 25.679 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44620, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.586 CPU sec, 25.468 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44801, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.58, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.257 CPU sec, 25.150 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44693, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.47, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.061 CPU sec, 24.962 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44779, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.272 CPU sec, 25.167 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44738, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.95)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.339 CPU sec, 25.222 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44783, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.786 CPU sec, 25.677 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44795, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.274 CPU sec, 25.164 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44818, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.176 CPU sec, 25.082 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44678, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.53, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.897 CPU sec, 24.794 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44749, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.592 CPU sec, 25.487 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44812, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.692 CPU sec, 25.599 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44694, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.52, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.887 CPU sec, 24.779 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44731, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.57, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.292 CPU sec, 25.188 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44670, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.837 CPU sec, 25.739 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44714, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.40, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.407 CPU sec, 25.309 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44701, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.826 CPU sec, 25.728 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44706, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 10.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.390 CPU sec, 25.286 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44719, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.586 CPU sec, 25.492 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44701, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.772 CPU sec, 25.668 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44874, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.46, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.794 CPU sec, 24.704 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44770, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.940 CPU sec, 24.838 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44604, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.97)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.605 CPU sec, 25.498 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44639, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.58, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.624 CPU sec, 25.516 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44647, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.493 CPU sec, 25.407 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44694, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.96)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.431 CPU sec, 25.326 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44737, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.55, 10.02)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.444 CPU sec, 25.339 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44769, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.940 CPU sec, 24.834 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44734, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.283 CPU sec, 25.182 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44764, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.88)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.399 CPU sec, 25.286 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44740, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.49, 9.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.323 CPU sec, 25.218 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44718, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.45, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.525 CPU sec, 25.414 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44829, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.48, 9.92)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.162 CPU sec, 25.054 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44706, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.54, 10.01)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 24.970 CPU sec, 24.873 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44677, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.50, 9.98)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 25.687 CPU sec, 25.590 real sec
	[M::process] read 15264 sequences (1526400 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44727, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.51, 9.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 26.220 CPU sec, 26.188 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 6854, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.57, 9.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 15264 reads in 4.018 CPU sec, 3.951 real sec
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired1.fq /home/hadoop/xubo/ref/GRCH38L1Index/pe/g38L100c10000000Nhs20Paired2.fq
	[main] Real time: 4709.851 sec; CPU: 4722.743 sec
	=> bwa mem local with ERR000589_12 RunTime:4709.892036 s
	end
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ 


性能评估：

	hadoop@Master:~/xubo/ref/GRCH38L1Index/pe$ samtools flagstat g38L100c10000000Nhs20Paired12.sam 
	18515265 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	1 + 0 supplementary
	0 + 0 duplicates
	18515265 + 0 mapped (100.00% : N/A)
	18515264 + 0 paired in sequencing
	9257632 + 0 read1
	9257632 + 0 read2
	18515118 + 0 properly paired (100.00% : N/A)
	18515264 + 0 with itself and mate mapped
	0 + 0 singletons (0.00% : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)

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
	