更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1 分析

但使用-r表示的reduce功能时，SparkBWA-0.2没有输出结果，但是分析发现中间tmp中是有结果的，通过分析代码得出，是由于outputHdfsDir和outputPath使用不一致的问题，前面的非reduce操作是使用的outputPath，而reduce操作使用的是outputHdfsDir，但是初始化的时候把输出路径初始化给了outputPath，而没有给outputHdfsDir，所以reduce的时候outputHdfsDir为空

# 2.解决办法
##2.1 代码
在com.github.sparkbwa.BwaOptions#BwaOptions(java.lang.String[])中加入outputHdfsDir=outputPath：

	else if (otherArguments.length == 2) {
				inputPath = otherArguments[0];
				outputPath = otherArguments[1];
			}
			else if (otherArguments.length == 3) {
				inputPath = otherArguments[0];
				inputPath2 = otherArguments[1];
				outputPath = otherArguments[2];

			}
	outputHdfsDir=outputPath

## 2.2运行脚本

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi runsparkBWA2standalone.sh 
		
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	time4=`date +"%Y%m%d%H%M%S"`
	out='/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT'$time4'L'$i'c'$j'Nhs20Paired12'
	
	#echo $fq1
	#echo $fq2
	#echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA \
	 --master spark://MasterIP:7077 \
	 --executor-memory 17g \
	  SparkBWA-0.2.jar -n 8 -m -p -r -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2" \
	$fq1 $fq2 $out
	
	done
	done


# 3.结果
##3.1 有输出结果

![](http://i.imgur.com/4dL3RvD.png)


###记录
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2standalone.sh 
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214839L50c10000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214839L50c10000Nhs20Paired12	time_s :	19.031	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214900L100c10000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214900L100c10000Nhs20Paired12	time_s :	18.629	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214920L50c100000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214920L50c100000Nhs20Paired12	time_s :	24.793	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214946L100c100000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204214946L100c100000Nhs20Paired12	time_s :	27.137	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204215014L50c1000000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204215014L50c1000000Nhs20Paired12	time_s :	94.811	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204215150L100c1000000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204215150L100c1000000Nhs20Paired12	time_s :	140.144	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204215412L50c10000000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204215412L50c10000000Nhs20Paired12	time_s :	666.622	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false
	finalHdfsOutputFile:FullOutput.sam                                              
	getOutputHdfsDir:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204220520L100c10000000Nhs20Paired12
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170204220520L100c10000000Nhs20Paired12	time_s :	937.156	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	true	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithtrue	isBwaswAlgorithm	false	isAlnAlgorithm	false

分析，时间明显变长了。因为reduce要耗时。

参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
