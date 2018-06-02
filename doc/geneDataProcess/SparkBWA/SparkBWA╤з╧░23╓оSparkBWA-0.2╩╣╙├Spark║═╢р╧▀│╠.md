更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1原因

SparkBWA-0.2只能通过--executor-cores 1利用一个core，需要提高CPU利用率，所以使用bwa多线程

## 1.2 脚本

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat runsparkBWA2.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701222304'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA --master yarn-client --driver-memory 1500m --executor-memory 7g --executor-cores 1 --num-executors 17 \
	 SparkBWA-0.2.jar -n 7 -m -r -s -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2 -R @RG\tID:foo\tLB:bar\tPL:illumina\tPU:illumina\tSM:ERR000589" \
	$fq1 $fq2 $out
	
	done 
	done


##1.3运行结果

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   52      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   86      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   102     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   401     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   390     s                                                               

###第二次

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   43      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   45      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   77      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   106     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   353     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   523     s  

###继续
	
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   43      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   47      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   47      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   83      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   89      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   308     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   488     s                                                               
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   44      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   55      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   86      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   102     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   282     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   475     s              

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   41      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   48      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   81      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   104     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   321     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   479     s                                         
## 1.4截图
![](http://i.imgur.com/aFlYJaj.png)

## 1.5对比
默认每个节点只使用一个线程

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   44      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   45      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   48      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   112     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   118     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   399     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   636     s                                                               
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi runsparkBWA2.sh 
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   43      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   45      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   51      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   48      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   91      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   104     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   436     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   568     s               


## 1.6 分析

当使用大数据集时，集群CPU利用率能超过70%，而单线程不超过50%。

没有到达90是因为Yarn模式下有个节点当作ResourceManager，需要作为master，而不作为计算节点。


参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
