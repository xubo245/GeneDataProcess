更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1


# 2.代码
##2.1

# 3.结果
##2.1 在节点Mcnode1运行bwa mem：

	hadoop@Mcnode1:~/disk2/xubo/ref/GRCH38L1Index$ time bwa mem -t 2 GRCH38chr1L3556522.fasta pe/g38L50c10000000Nhs20Paired1.fastq pe/g38L50c10000000Nhs20Paired2.fastq &> sparkBWA/g38L50c10000000Nhs20Paired12.sam
	
	real	31m4.412s
	user	60m38.646s
	sys	0m11.888s
	hadoop@Mcnode1:~/disk2/xubo/ref/GRCH38L1Index$ ll -h sparkBWA/g38L50c10000000Nhs20Paired12.sam
	-rw-rw-r-- 1 hadoop hadoop 3.4G  2月  3 21:16 sparkBWA/g38L50c10000000Nhs20Paired12.sam
	hadoop@Mcnode1:~/disk2/xubo/ref/GRCH38L1Index$ cat sparkBWA/g38L50c10000000Nhs20Paired12.sam |head -20
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 400000 sequences (20000000 bp)...
	[M::process] read 400000 sequences (20000000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 158507, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.44, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 400000 reads in 79.647 CPU sec, 40.691 real sec
	@SQ	SN:chr1	LN:248956422
	@PG	ID:bwa	PN:bwa	VN:0.7.12-r1039	CL:bwa mem -t 2 GRCH38chr1L3556522.fasta pe/g38L50c10000000Nhs20Paired1.fastq pe/g38L50c10000000Nhs20Paired2.fastq
	chr1-20000000	99	chr1	170096648	60	50M	=	170096799	201	TCTCCAGAGCCCATATTTAAACCCAGTTATTTCTGACTTCAAAGCCTCTG	+CCFFFFFHAFHGJIHJJHJGJJJJIJDJJIJJHDGCI?.JGJ@AHIJ?J	NM:i:0	MD:Z:50	AS:i:50	XS:i:0
	chr1-20000000	147	chr1	170096799	60	50M	=	170096648	-201	ACACCCGTCTTGCTCTAAGAATGTTTTCTTCTTTGCTGTTAAGCTTATAT	*IJHHIJI8D:@HDCIIABJJIJIJGAIEECHC2JJJHHHHHFFF7DC@B	NM:i:0	MD:Z:50	AS:i:50	XS:i:0
	chr1-19999998	99	chr1	205916413	60	50M	=	205916562	199	TTAAGGCTTGTCCACATGCAATAATACTTCATTTGTAGACCCAGAATCCA	BC=FFD,FA?HHHEIJJJJEJJJHDI)IHHJ,GJIJEIFGIBDGGI<DFJ	NM:i:1	MD:Z:26A23	AS:i:45	XS:i:0
	chr1-19999998	147	chr1	205916562	60	50M	=	205916413	-199	CCATAAATACCTGCTGAATTAATGAAAGAACAAGTGACTGGCCTGCCAAT	GEG=HGG9DGIGG)JJ8HIFHCI:JHGIJ@GGJ)JID:HH2HFFFFAC:@	NM:i:1	MD:Z:40C9	AS:i:45	XS:i:20
	chr1-19999996	83	chr1	225591281	41	50M	=	225591115	-216	TAACATGGTAAAACCCTGTCTTTACTAAAAATACAAAAATTAGAAGGGCG	IJADGIII'(ECAIGFJ?JI1JJGIJGHIGEHGIJJJHFHHHFFFDD@;7	NM:i:1	MD:Z:9G40	AS:i:45	XS:i:42

=》应该去掉&>中的&。这样就不会把运行中的记录输出到文件中。

31m4.412s=>1864.412s


##3.2 使用集群：

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2standalone.sh
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L50c10000Nhs20Paired12
	run********
	time:   17      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L100c10000Nhs20Paired12
	run********
	time:   17      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L50c100000Nhs20Paired12
	run********
	time:   22      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L100c100000Nhs20Paired12
	run********
	time:   24      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L50c1000000Nhs20Paired12
	run********
	time:   77      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L100c1000000Nhs20Paired12
	run********
	time:   115     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L50c10000000Nhs20Paired12
	run********
	time:   511     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702032044L100c10000000Nhs20Paired12
	run********
	time:   607     s 

##3.3 分析：
1864.412s/511s=3.648555773倍的加速比

8台机器3.65倍加速比。还有待提高。如果按理论8倍的加速比来分析，应该是233.05s。

查看起DAG图如下：

![](http://i.imgur.com/a0AMWep.png)

分析中间repartition步骤太多，而且有shuffle等，还有IO开销，带来很多开销。


###补充实验
对长度为100个也测试了。
	
单机

	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 115264 reads in 30.401 CPU sec, 15.523 real sec
	[main] Version: 0.7.12-r1039
	[main] CMD: bwa mem -t 2 GRCH38chr1L3556522.fasta pe/g38L100c10000000Nhs20Paired1.fastq pe/g38L100c10000000Nhs20Paired2.fastq
	[main] Real time: 2426.889 sec; CPU: 4752.089 sec
	
	real	40m26.923s
	user	78m59.714s
	sys	0m12.377s
	hadoop@Mcnode1:~/disk2/xubo/ref/GRCH38L1Index$ time bwa mem -t 2 GRCH38chr1L3556522.fasta pe/g38L100c10000000Nhs20Paired1.fastq pe/g38L100c10000000Nhs20Paired2.fastq > sparkBWA/g38L100c10000000Nhs20Paired12.sam

集群：
	
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702041747L100c10000000Nhs20Paired12K1	time_s:	693.192	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	false	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithm	true	isBwaswAlgorithm	false	isAlnAlgorithm	false
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702041747L100c10000000Nhs20Paired12K2	time_s:	591.07	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	false	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithm	true	isBwaswAlgorithm	false	isAlnAlgorithm	false
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702041747L100c10000000Nhs20Paired12K3	time_s:	612.369	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	false	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithm	true	isBwaswAlgorithm	false	isAlnAlgorithm	false
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702041747L100c10000000Nhs20Paired12K4	time_s:	657.702	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	false	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithm	true	isBwaswAlgorithm	false	isAlnAlgorithm	false
	InputPath	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq	InputPath2	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq	OutputPath	/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT201702041747L100c10000000Nhs20Paired12K5	time_s:	641.52	IndexPath	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta	PartitionNumber	8	Reducer	false	BwaArgs	-t 2	isPairedReads	true	isSingleReads	false	isMemAlgorithm	true	isBwaswAlgorithm	false	isAlnAlgorithm	false

平均时间为639.1706s

2426.889/639.1706=3.796934653

2426.889s/8=303.361125s

差不多。


参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
