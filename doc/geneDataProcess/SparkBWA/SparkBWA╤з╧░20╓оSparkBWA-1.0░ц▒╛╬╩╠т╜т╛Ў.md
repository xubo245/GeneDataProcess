更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
集群配置为八个节点，每个节点两个core

##1.1 问题发现

运行时设置num-executors为7，executor-cores为2时，会出现ERROR YarnScheduler: Lost executor 7 on Mcnode5: remote Rpc client disassociated。出发点是想利用集群的所有core

之前也请教过作者相关的问题：见参考三【3】

分析：主要是每个节点设置了两格core，SparkBWA 1.0 会出现问题  


## 1.2 执行脚本文件

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat sparkBWA.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701160934'

	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class SparkBWA \
	 --master yarn-client \
	 --conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/disk2/xubo/tools/SparkBWA/build" \
	 --archives ./bwa.zip \
	 --num-executors 7 --executor-cores 2 --executor-memory 7G \
	 --driver-memory 1500m \
	SparkBWA.jar \
	 -algorithm mem -reads paired \
	 -index /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	 -partitions 16 \
	$fq1 $fq2 $out
	
	done 
	done


## 1.3 问题记录

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./sparkBWA.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701160934
	[Stage 3:>                                                        (0 + 14) / 16]17/01/21 21:50:24 ERROR YarnScheduler: Lost executor 7 on Mcnode5: remote Rpc client disassociated
	[Stage 3:>                                                        (0 + 12) / 16]17/01/21 21:50:24 ERROR YarnScheduler: Lost executor 6 on Mcnode3: remote Rpc client disassociated
	[Stage 3:>                                                        (0 + 11) / 16]17/01/21 21:50:24 ERROR YarnScheduler: Lost executor 3 on Mcnode2: remote Rpc client disassociated
	17/01/21 21:50:25 ERROR YarnScheduler: Lost executor 4 on Mcnode6: remote Rpc client disassociated
	[Stage 3:=====================>                                    (6 + 6) / 16]17/01/21 21:50:26 ERROR YarnScheduler: Lost executor 2 on Master: remote Rpc client disassociated
	[Stage 3:===================================>                     (10 + 4) / 16]17/01/21 21:50:27 ERROR YarnScheduler: Lost executor 5 on Mcnode7: remote Rpc client disassociated
	[Stage 3:=====================================================>   (15 + 1) / 16]17/01/21 21:50:28 ERROR YarnScheduler: Lost executor 1 on Mcnode4: remote Rpc client disassociated
	time=   54      s    


# 2.问题解决
##2.1 解决思路

每个executor只用一个core


##2.2 修改的脚本

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat sparkBWA.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701160934'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class SparkBWA \
	 --master yarn-client \
	 --conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/disk2/xubo/tools/SparkBWA/build" \
	 --archives ./bwa.zip \
	 --num-executors 7 --executor-cores 1 --executor-memory 7G \
	 --driver-memory 1500m \
	SparkBWA.jar \
	 -algorithm mem -reads paired \
	 -index /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	 -partitions 16 \
	$fq1 $fq2 $out
	
	done 
	done


## 2.3成功运行结果

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./sparkBWA.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701160934
	time=   40      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701160934
	time=   38      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701160934
	time=   44      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701160934
	time=   51      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701160934
	time=   152     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701160934
	time=   161     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701160934
	time=   848     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701160934
	time=   1156    s 


###第二遍

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./sparkBWA.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701160934
	time=   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701160934
	time=   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701160934
	time=   53      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701160934
	time=   55      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701160934
	time=   144     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701160934
	time=   162     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701160934
	time=   943     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701160934
	time=   1155    s                                                   

![](http://i.imgur.com/gFSE71f.png)
# 3.结果
##3.1 分析

2.3可以看出，CPU使用率都没有超过50%。

当--num-executors 16 --executor-cores 2后CPU利用率有提高，但是会出现1.3中的问题

![](http://i.imgur.com/6FJuHri.png) 

错误：

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./sparkBWA.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701160934
	[Stage 3:=====================>                                   (6 + 10) / 16]17/01/21 23:22:47 ERROR YarnScheduler: Lost executor 2 on Mcnode4: remote Rpc client disassociated
	[Stage 3:================================>                         (9 + 7) / 16]17/01/21 23:22:47 ERROR YarnScheduler: Lost executor 1 on Mcnode7: remote Rpc client disassociated
	[Stage 3:==========================================>              (12 + 4) / 16]17/01/21 23:22:48 ERROR YarnScheduler: Lost executor 5 on Master: remote Rpc client disassociated
	17/01/21 23:22:48 ERROR YarnScheduler: Lost executor 7 on Mcnode2: remote Rpc client disassociated
	time=   68      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701160934
	[Stage 3:>                                                        (0 + 14) / 16]17/01/21 23:23:53 ERROR YarnScheduler: Lost executor 7 on Mcnode4: remote Rpc client disassociated
	[Stage 3:>                                                        (0 + 12) / 16]17/01/21 23:23:53 ERROR YarnScheduler: Lost executor 3 on Mcnode5: remote Rpc client disassociated
	17/01/21 23:23:53 ERROR YarnScheduler: Lost executor 4 on Mcnode2: remote Rpc client disassociated
	17/01/21 23:23:53 ERROR YarnScheduler: Lost executor 6 on Mcnode6: remote Rpc client disassociated
	[Stage 3:>                                                         (0 + 6) / 16]17/01/21 23:23:54 ERROR YarnScheduler: Lost executor 2 on Master: remote Rpc client disassociated
	[Stage 3:=======================================>                 (11 + 4) / 16]17/01/21 23:23:56 ERROR YarnScheduler: Lost executor 1 on Mcnode3: remote Rpc client disassociated
	[Stage 3:=====================================================>   (15 + 1) / 16]17/01/21 23:23:57 ERROR YarnScheduler: Lost executor 5 on Mcnode1: remote Rpc client disassociated
	time=   53      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701160934
	[Stage 3:>                                                        (0 + 10) / 16]17/01/21 23:24:54 ERROR YarnScheduler: Lost executor 2 on Mcnode7: remote Rpc client disassociated
	[Stage 3:=============================>                            (8 + 8) / 16]17/01/21 23:24:58 ERROR YarnScheduler: Lost executor 4 on Master: remote Rpc client disassociated
	[Stage 3:================================>                         (9 + 6) / 16]17/01/21 23:24:59 ERROR YarnScheduler: Lost executor 3 on Mcnode4: remote Rpc client disassociated
	time=   68      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701160934
	[Stage 3:>                                                        (0 + 14) / 16]17/01/21 23:26:09 ERROR YarnScheduler: Lost executor 2 on Mcnode1: remote Rpc client disassociated
	[Stage 3:>                                                        (0 + 12) / 16]17/01/21 23:26:09 ERROR YarnScheduler: Lost executor 1 on Mcnode3: remote Rpc client disassociated
	[Stage 3:===>                                                     (1 + 10) / 16]17/01/21 23:26:09 ERROR YarnScheduler: Lost executor 7 on Mcnode4: remote Rpc client disassociated
	17/01/21 23:26:10 ERROR YarnScheduler: Lost executor 5 on Master: remote Rpc client disassociated
	[Stage 3:================================>                         (9 + 7) / 16]17/01/21 23:26:15 ERROR YarnScheduler: Lost executor 3 on Mcnode5: remote Rpc client disassociated
	[Stage 3:===================================>                     (10 + 6) / 16]17/01/21 23:26:18 ERROR YarnScheduler: Lost executor 4 on Mcnode6: remote Rpc client disassociated
	17/01/21 23:26:18 ERROR YarnScheduler: Lost executor 6 on Mcnode7: remote Rpc client disassociated
	time=   74      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701160934
	[Stage 3:>                                                        (0 + 14) / 16]17/01/21 23:28:00 ERROR YarnScheduler: Lost executor 7 on Mcnode4: remote Rpc client disassociated
	[Stage 3:==========>                                              (3 + 12) / 16]17/01/21 23:28:01 ERROR YarnScheduler: Lost executor 6 on Mcnode7: remote Rpc client disassociated
	[Stage 3:==========>                                              (3 + 10) / 16]17/01/21 23:28:02 ERROR YarnScheduler: Lost executor 4 on Mcnode2: remote Rpc client disassociated
	[Stage 3:==========>                                               (3 + 9) / 16]17/01/21 23:28:02 ERROR YarnScheduler: Lost executor 1 on Mcnode3: remote Rpc client disassociated
	[Stage 3:==============>                                           (4 + 6) / 16]17/01/21 23:28:03 ERROR YarnScheduler: Lost executor 3 on Mcnode1: remote Rpc client disassociated
	[Stage 3:===============>                                          (3 + 8) / 11]17/01/21 23:28:59 ERROR YarnScheduler: Lost executor 2 on Mcnode5: remote Rpc client disassociated
	[Stage 3:===================================================>     (10 + 1) / 11]17/01/21 23:31:00 ERROR YarnScheduler: Lost executor 10 on Mcnode7: remote Rpc client disassociated
	time=   290     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701160934
	[Stage 3:=======>                                                 (2 + 14) / 16]17/01/21 23:33:00 ERROR YarnScheduler: Lost executor 2 on Mcnode3: remote Rpc client disassociated
	[Stage 3:=======>                                                 (2 + 12) / 16]17/01/21 23:33:01 ERROR YarnScheduler: Lost executor 1 on Mcnode5: remote Rpc client disassociated
	[Stage 3:==============>                                          (4 + 10) / 16]17/01/21 23:33:02 ERROR YarnScheduler: Lost executor 7 on Mcnode7: remote Rpc client disassociated
	[Stage 3:==============>                                           (4 + 8) / 16]17/01/21 23:33:02 ERROR YarnScheduler: Lost executor 4 on Mcnode1: remote Rpc client disassociated
	[Stage 3:=========================>                                (7 + 9) / 16]17/01/21 23:33:31 ERROR YarnScheduler: Lost executor 3 on Mcnode2: remote Rpc client disassociated
	17/01/21 23:33:32 ERROR YarnScheduler: Lost executor 5 on Mcnode6: remote Rpc client disassociated
	[Stage 3:=============================================>             (7 + 2) / 9]17/01/21 23:34:35 ERROR YarnScheduler: Lost executor 13 on Mcnode6: remote Rpc client disassociated
	17/01/21 23:34:36 ERROR YarnScheduler: Lost executor 6 on Master: remote Rpc client disassociated
	time=   224     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701160934
	[Stage 3:=======>                                                 (2 + 14) / 16]17/01/21 23:41:31 ERROR YarnScheduler: Lost executor 4 on Mcnode1: remote Rpc client disassociated
	[Stage 3:==========>                                              (3 + 13) / 16]17/01/21 23:41:41 ERROR YarnScheduler: Lost executor 3 on Mcnode6: remote Rpc client disassociated
	17/01/21 23:41:42 ERROR YarnScheduler: Lost executor 1 on Mcnode2: remote Rpc client disassociated
	[Stage 0:>                  (0 + 3) / 3][Stage 1:>                  (0 + 3) / 3]17/01/21 23:41:50 ERROR YarnScheduler: Lost executor 7 on Mcnode7: remote Rpc client disassociated
	[Stage 0:>                  (0 + 2) / 2][Stage 1:============>      (2 + 1) / 3]17/01/21 23:41:56 ERROR YarnScheduler: Lost executor 6 on Mcnode5: remote Rpc client disassociated
	[Stage 0:=============================>                             (1 + 1) / 2]17/01/21 23:42:04 ERROR YarnScheduler: Lost executor 2 on Master: remote Rpc client disassociated
	[Stage 3:=======>                                                   (1 + 7) / 8]17/01/21 23:47:26 ERROR YarnScheduler: Lost executor 5 on Mcnode4: remote Rpc client disassociated
	[Stage 1:============================================>              (3 + 1) / 4]17/01/21 23:47:50 ERROR YarnScheduler: Lost executor 12 on Mcnode5: remote Rpc client disassociated
	time=   1054    s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701160934
	[Stage 3:=================>                                       (5 + 11) / 16]17/01/22 00:01:17 ERROR YarnScheduler: Lost executor 7 on Mcnode5: remote Rpc client disassociated
	17/01/22 00:01:17 ERROR YarnScheduler: Lost executor 3 on Mcnode4: remote Rpc client disassociated
	[Stage 3:=========================>                                (7 + 9) / 16]17/01/22 00:01:31 ERROR YarnScheduler: Lost executor 1 on Mcnode1: remote Rpc client disassociated
	[Stage 0:====>              (2 + 6) / 8][Stage 1:>                  (0 + 1) / 7]17/01/22 00:01:40 ERROR YarnScheduler: Lost executor 5 on Mcnode7: remote Rpc client disassociated
	[Stage 1:==================================================>        (6 + 1) / 7]17/01/22 00:03:42 ERROR YarnScheduler: Lost executor 4 on Mcnode6: remote Rpc client disassociated
	[Stage 3:=========================>                                 (3 + 4) / 7]17/01/22 00:10:42 ERROR YarnScheduler: Lost executor 2 on Mcnode3: remote Rpc client disassociated
	17/01/22 00:10:43 ERROR YarnScheduler: Lost executor 6 on Mcnode2: remote Rpc client disassociated
	time=   1142    s   

参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
		【3】https://github.com/citiususc/SparkBWA/issues/6
