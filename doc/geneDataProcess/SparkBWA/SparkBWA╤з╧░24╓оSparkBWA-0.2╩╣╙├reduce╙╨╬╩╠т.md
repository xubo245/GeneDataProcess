更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1 使用-r最终没有文件

SparkBWA使用reduce时会有错误，运行时会有等多个文件生成，但是最后没有文件生成，应该是reduce节点把文件都删除了，新的文件没有生成

本地模式运行查看记录，yarn-client不好查看

##1.2 脚本

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat runsparkBWA2.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701240015Local'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA --master local[1] --driver-memory 1500m --executor-memory 7g --executor-cores 1 --num-executors 17 \
	 SparkBWA-0.2.jar -n 7 -m -r -s -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2" \
	$fq1 $fq2 $out
	
	done 
	done

##1.3 截图

###开始生成第一个：

![](http://i.imgur.com/aVxrTe9.png)

###生成四个：

![](http://i.imgur.com/AnDHgzB.png)

###最后没了：

![](http://i.imgur.com/mJrNJJT.png)


# 2.运行正常版本-本地模式
##2.1 脚本

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat runsparkBWA2.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701240021Local'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA --master local[1] --driver-memory 1500m --executor-memory 7g --executor-cores 1 --num-executors 17 \
	 SparkBWA-0.2.jar -n 7 -m -s -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2" \
	$fq1 $fq2 $out
	
	done 
	done

## 2.2 部分运行结果
	
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701240021Local
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-0.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-0.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD0_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD0_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[M::mem_process_seqs] Processed 1320 reads in 0.170 CPU sec, 0.086 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD0_1
	[main] Real time: 0.264 sec; CPU: 13.174 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:========>                                                  (1 + 1) / 7][Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-1.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-1.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD1_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD1_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[M::mem_process_seqs] Processed 1320 reads in 0.178 CPU sec, 0.179 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD1_1
	[main] Real time: 0.369 sec; CPU: 13.961 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-2.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-2.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD2_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD2_1.
	[Stage 2:================>                                          (2 + 1) / 7][M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[M::mem_process_seqs] Processed 1320 reads in 0.157 CPU sec, 0.157 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD2_1
	[main] Real time: 0.351 sec; CPU: 14.333 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-3.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-3.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD3_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD3_1.
	[Stage 2:=========================>                                 (3 + 1) / 7][M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[M::mem_process_seqs] Processed 1320 reads in 0.195 CPU sec, 0.194 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD3_1
	[main] Real time: 0.375 sec; CPU: 14.776 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:=================================>                         (4 + 1) / 7][Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-4.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-4.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD4_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD4_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[M::mem_process_seqs] Processed 1320 reads in 0.162 CPU sec, 0.161 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD4_1
	[main] Real time: 0.352 sec; CPU: 15.150 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-5.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-5.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD5_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD5_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[Stage 2:==========================================>                (5 + 1) / 7][M::mem_process_seqs] Processed 1320 reads in 0.178 CPU sec, 0.178 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD5_1
	[main] Real time: 0.357 sec; CPU: 15.542 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-6.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-local-1485188492617-6.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD6_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD6_1.
	[Stage 2:==================================================>        (6 + 1) / 7][M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1320 sequences (66000 bp)...
	[M::mem_process_seqs] Processed 1320 reads in 0.182 CPU sec, 0.182 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188492617-RDD6_1
	[main] Real time: 0.366 sec; CPU: 15.932 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq      
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701240021Local
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-0.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-0.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD0_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD0_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1314 sequences (131400 bp)...
	[M::mem_process_seqs] Processed 1314 reads in 0.234 CPU sec, 0.119 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD0_1
	[main] Real time: 0.319 sec; CPU: 13.292 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:========>                                                  (1 + 1) / 7][Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-1.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-1.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD1_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD1_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1314 sequences (131400 bp)...
	[M::mem_process_seqs] Processed 1314 reads in 0.275 CPU sec, 0.269 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD1_1
	[main] Real time: 0.463 sec; CPU: 14.280 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-2.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-2.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD2_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD2_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1314 sequences (131400 bp)...
	[Stage 2:================>                                          (2 + 1) / 7][M::mem_process_seqs] Processed 1314 reads in 0.324 CPU sec, 0.323 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD2_1
	[main] Real time: 0.509 sec; CPU: 14.842 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Stage 2:=========================>                                 (3 + 1) / 7][Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-3.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-3.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD3_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD3_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1314 sequences (131400 bp)...
	[M::mem_process_seqs] Processed 1314 reads in 0.282 CPU sec, 0.279 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD3_1
	[main] Real time: 0.469 sec; CPU: 15.378 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-4.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-4.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD4_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD4_1.
	[Stage 2:=================================>                         (4 + 1) / 7][M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1313 sequences (131300 bp)...
	[M::mem_process_seqs] Processed 1313 reads in 0.247 CPU sec, 0.246 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD4_1
	[main] Real time: 0.454 sec; CPU: 15.837 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-5.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-5.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD5_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD5_1.
	[Stage 2:==========================================>                (5 + 1) / 7][M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1313 sequences (131300 bp)...
	[M::mem_process_seqs] Processed 1313 reads in 0.249 CPU sec, 0.249 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD5_1
	[main] Real time: 0.439 sec; CPU: 16.334 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-6.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000Nhs20Paired1.fastq-7-NoSort-local-1485188504998-6.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD6_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD6_1.
	[Stage 2:==================================================>        (6 + 1) / 7][M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 1314 sequences (131400 bp)...
	[M::mem_process_seqs] Processed 1314 reads in 0.269 CPU sec, 0.264 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/local-1485188504998-RDD6_1
	[main] Real time: 0.444 sec; CPU: 16.805 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	

# 3.运行成功版本--yarn-client模式
##3.1脚本
	
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat runsparkBWA2.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701240028Local'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA --master yarn-client --driver-memory 1500m --executor-memory 7g --executor-cores 1 --num-executors 17 \
	 SparkBWA-0.2.jar -n 7 -m -s -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2" \
	$fq1 $fq2 $out
	
	done 
	done

## 3.2 成功记录

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701240028Local
	time:   47      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701240028Local
	time:   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701240028Local
	time:   47      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701240028Local
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701240028Local
	time:   76      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701240028Local
	time:   87      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701240028Local
	time:   268     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701240028Local
	time:   321     s  
###第二次

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi runsparkBWA2.sh 
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701240044Local
	time:   48      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701240044Local
	time:   49      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701240044Local
	time:   47      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701240044Local
	time:   47      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701240044Local
	time:   74      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701240044Local
	time:   89      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701240044Local
	time:   279     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701240044Local
	time:   369     s  

第三次：没有修改位置
                                                             
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701240044Local
	time:   40      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701240044Local
	time:   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701240044Local
	time:   44      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701240044Local
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701240044Local
	time:   79      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701240044Local
	time:   93      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701240044Local
	time:   250     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701240044Local
	time:   361     s 

第四次：

	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701240132Local
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701240132Local
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701240132Local
	time:   45      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701240132Local
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701240132Local
	time:   74      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701240132Local
	time:   90      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701240132Local
	time:   238     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701240132Local
	time:   297     s 

## 3.3截图

![](http://i.imgur.com/fHAxCI6.png)


如何解决reduce的问题，将在过完年后分析

参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
