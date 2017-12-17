	
	
脚本：
	
	spark-submit --class SparkBWA \
	--master local \
	--archives bwa.zip \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 3 \
	/xubo/alignment/sparkBWA/GRCH38chr1L3556522N1000000L100paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N1000000L100paired2.fastq \
	/xubo/alignment/output/sparkBWA/GRCH38chr1L3556522N1000000L100paired12
	
	
运行记录：
	
	hadoop@Master:~/xubo/tools/SparkBWA/build$ ./pairedGRCH38L1N1000000Local.sh             
	[Stage 3:>                                                          (0 + 1) / 3][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1466761536651-0.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1466761536651-0.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD0_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD0_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD0_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD0_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44550, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (499.07, 49.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 40.231 CPU sec, 40.252 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44518, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.90, 49.73)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 40.499 CPU sec, 40.241 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44507, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.72, 49.73)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 40.312 CPU sec, 40.061 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44480, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (499.20, 49.64)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 40.590 CPU sec, 40.329 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44530, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (466, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (332, 667)
	[M::mem_pestat] mean and std.dev: (499.18, 49.79)
	[M::mem_pestat] low and high boundaries for proper pairs: (265, 734)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 40.252 CPU sec, 39.980 real sec
	[M::process] read 66664 sequences (6666400 bp)...
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44367, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (499.10, 49.91)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 40.689 CPU sec, 40.409 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 29620, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 498, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.56, 49.76)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 66664 reads in 27.274 CPU sec, 27.130 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD0_1 /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD0_2
	[main] Real time: 282.681 sec; CPU: 346.015 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 3:===================>                                       (1 + 1) / 3][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1466761536651-1.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1466761536651-1.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD1_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD1_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD1_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD1_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44527, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 498, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.57, 49.60)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 37.971 CPU sec, 37.765 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44541, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.65, 49.71)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.467 CPU sec, 38.186 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44503, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.76, 49.80)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.133 CPU sec, 38.846 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44619, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.90, 49.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 37.928 CPU sec, 37.648 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44326, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.85, 49.90)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.490 CPU sec, 38.212 real sec
	[M::process] read 66668 sequences (6666800 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44544, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.79, 49.59)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_process_seqs] Processed 100000 reads in 38.020 CPU sec, 37.772 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 29608, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.91, 50.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 66668 reads in 25.369 CPU sec, 25.211 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD1_1 /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD1_2
	[main] Real time: 263.547 sec; CPU: 608.818 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 3:=======================================>                   (2 + 1) / 3][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1466761536651-2.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1466761536651-2.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD2_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD2_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD2_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD2_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 100000 sequences (10000000 bp)...
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44486, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.84, 49.88)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.847 CPU sec, 38.695 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44536, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (499.12, 49.82)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.578 CPU sec, 39.324 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44545, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.84, 50.12)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.928 CPU sec, 38.646 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44524, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (466, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (332, 667)
	[M::mem_pestat] mean and std.dev: (499.18, 49.89)
	[M::mem_pestat] low and high boundaries for proper pairs: (265, 734)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.112 CPU sec, 38.839 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44500, 1, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (466, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (332, 667)
	[M::mem_pestat] mean and std.dev: (499.06, 49.72)
	[M::mem_pestat] low and high boundaries for proper pairs: (265, 734)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.338 CPU sec, 39.066 real sec
	[M::process] read 66666 sequences (6666600 bp)...
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44478, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (464, 498, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (328, 668)
	[M::mem_pestat] mean and std.dev: (498.47, 49.71)
	[M::mem_pestat] low and high boundaries for proper pairs: (260, 736)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.372 CPU sec, 39.132 real sec
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 29691, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 498, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.29, 49.72)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 66666 reads in 26.443 CPU sec, 26.296 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD2_1 /home/hadoop/cloud/workspace/tmplocal-1466761536651-RDD2_2
	[main] Real time: 269.126 sec; CPU: 879.037 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	hadoop@Master:~/xubo/tools/SparkBWA/build$    
	
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
	