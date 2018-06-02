更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1
  SparkBWA可以指定partitions的数量，下面将分析使用一个partitions和8个partitions的运行时间，都是使用两个线程。

一个partitions时即在本地运行。

# 2.代码
##2.1
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L'$i'c'$j'Nhs20Paired12'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA \
	 --master spark://219.219.220.149:7077 \
	 --executor-memory 17g \
	  SparkBWA-0.2.jar -n 1 -m -p -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2" \
	$fq1 $fq2 $out
	
	done
	done

# 3.结果
结论：
明显使用一个partitions时的时间长于8个partitions时的时间，但没有成八倍，应该是数据集过小，运行时间中系统启动和集群交互时间等占比大

后来分析发现-n 1使用的是单端匹配，而-n 8 使用的是双端匹配，所以数据多一倍，所以正好是4倍左右的关系型

（）猜测：有可能代码在集群中的步骤增加了运行时间？？待大数据集分析=》待验证都是单端或双端的情况）

##3.1运行记录 

###使用一个partition的时候
-n 1

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2standalone.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L50c10000Nhs20Paired12
	run********
	time:   15      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L100c10000Nhs20Paired12
	run********
	time:   16      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L50c100000Nhs20Paired12
	run********
	time:   24      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L100c100000Nhs20Paired12
	run********
	time:   29      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L50c1000000Nhs20Paired12
	run********
	time:   118     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L100c1000000Nhs20Paired12
	run********
	time:   161     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L50c10000000Nhs20Paired12
	run********
	time:   845     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031735L100c10000000Nhs20Paired12
	run********
	time:   1246    s                                                               
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi runsparkBWA2standalone.sh 

###使用八个partition的时候： -n 8

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2standalone.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c10000Nhs20Paired12
	run********
	time:   14      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c10000Nhs20Paired12
	run********
	time:   14      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c100000Nhs20Paired12
	run********
	time:   17      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c100000Nhs20Paired12
	run********
	time:   18      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c1000000Nhs20Paired12
	run********
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c1000000Nhs20Paired12
	run********
	time:   55      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c10000000Nhs20Paired12
	run********
	time:   219     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c10000000Nhs20Paired12
	run********
	time:   265     s                                                               
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi runsparkBWA2standalone.sh 

###第二次
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2standalone.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c10000Nhs20Paired12
	run********
	time:   14      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c10000Nhs20Paired12
	run********
	time:   17      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c100000Nhs20Paired12
	run********
	time:   17      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c100000Nhs20Paired12
	run********
	time:   19      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c1000000Nhs20Paired12
	run********
	time:   46      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c1000000Nhs20Paired12
	run********
	time:   61      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L50c10000000Nhs20Paired12
	run********
	time:   197     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702031936L100c10000000Nhs20Paired12
	run********
	time:   290     s  


参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
