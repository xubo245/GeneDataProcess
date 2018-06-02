	
更多代码请见：https://github.com/xubo245
	
基因数据处理系列
	
# 1.记录
	hadoop@Master:~/disk2/xubo/tools/SparkBWA/build$ ./pairedGRCH38L1Local.sh 
	[Stage 3:>                                                          (0 + 1) / 3][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpsSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1479300604508-0.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpsSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1479300604508-0.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD0_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD0_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD0_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD0_2.
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
	[M::mem_process_seqs] Processed 100000 reads in 38.406 CPU sec, 38.215 real sec
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
	[M::mem_process_seqs] Processed 100000 reads in 38.646 CPU sec, 38.372 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44507, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.72, 49.73)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_process_seqs] Processed 100000 reads in 38.608 CPU sec, 38.342 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44491, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.80, 49.43)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.493 CPU sec, 38.234 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44497, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (466, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (332, 667)
	[M::mem_pestat] mean and std.dev: (499.10, 49.93)
	[M::mem_pestat] low and high boundaries for proper pairs: (265, 734)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.288 CPU sec, 38.021 real sec
	[M::process] read 66664 sequences (6666400 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44588, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.70, 49.66)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 37.605 CPU sec, 37.345 real sec
	[Stage 3:>                                                          (0 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 29604, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.72, 49.99)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 66664 reads in 26.105 CPU sec, 25.902 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD0_1 /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD0_2
	[main] Real time: 259.793 sec; CPU: 317.648 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 3:===================>                                       (1 + 1) / 3][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpsSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1479300604508-1.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpsSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1479300604508-1.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD1_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD1_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD1_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD1_2.
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
	[M::mem_process_seqs] Processed 100000 reads in 37.906 CPU sec, 37.718 real sec
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
	[M::mem_process_seqs] Processed 100000 reads in 38.475 CPU sec, 38.211 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44503, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.76, 49.80)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.242 CPU sec, 38.973 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44439, 1, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.90, 49.53)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.897 CPU sec, 38.633 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44487, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.85, 49.58)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.052 CPU sec, 37.788 real sec
	[M::process] read 66668 sequences (6666800 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44574, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.85, 50.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.777 CPU sec, 38.556 real sec
	[Stage 3:===================>                                       (1 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 29582, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (466, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (332, 667)
	[M::mem_pestat] mean and std.dev: (499.30, 49.77)
	[M::mem_pestat] low and high boundaries for proper pairs: (265, 734)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 66668 reads in 25.815 CPU sec, 25.663 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD1_1 /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD1_2
	[main] Real time: 256.666 sec; CPU: 582.084 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 3:=======================================>                   (2 + 1) / 3][Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpsSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1479300604508-2.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpsSparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort-local-1479300604508-2.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD2_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD2_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD2_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD2_2.
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
	[M::mem_process_seqs] Processed 100000 reads in 38.738 CPU sec, 38.551 real sec
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
	[M::mem_process_seqs] Processed 100000 reads in 39.234 CPU sec, 38.977 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44545, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.84, 50.12)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.286 CPU sec, 38.019 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44494, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 532)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (331, 666)
	[M::mem_pestat] mean and std.dev: (498.93, 49.67)
	[M::mem_pestat] low and high boundaries for proper pairs: (264, 733)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.448 CPU sec, 38.180 real sec
	[M::process] read 100000 sequences (10000000 bp)...
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44456, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (466, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (332, 667)
	[M::mem_pestat] mean and std.dev: (499.09, 50.00)
	[M::mem_pestat] low and high boundaries for proper pairs: (265, 734)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 38.483 CPU sec, 38.219 real sec
	[M::process] read 66666 sequences (6666600 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 44425, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (498.65, 50.03)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 100000 reads in 39.137 CPU sec, 38.911 real sec
	[Stage 3:=======================================>                   (2 + 1) / 3][M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 29650, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (465, 499, 533)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (329, 669)
	[M::mem_pestat] mean and std.dev: (499.02, 50.06)
	[M::mem_pestat] low and high boundaries for proper pairs: (261, 737)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 66666 reads in 25.690 CPU sec, 25.550 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD2_1 /home/hadoop/cloud/workspace/tmpslocal-1479300604508-RDD2_2
	[main] Real time: 257.350 sec; CPU: 846.181 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	
	
	
	
参考
	
	【1】https://github.com/xubo245
	【4】http://blog.csdn.net/xubo245/
