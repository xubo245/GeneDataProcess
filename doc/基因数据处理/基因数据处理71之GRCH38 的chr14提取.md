

1.获取开始和结束行号

	cat GCA_000001405.15_GRCh38_full_analysis_set.fna |grep -i -n '>'

2.提取chr14

	cat GCA_000001405.15_GRCh38_full_analysis_set.fna |head -32835035|tail -1529197 >GRCH38ch14.fasta	

3.整理：

	hadoop@Mcnode2:~/cloud/adam/xubo/data/test20160310/GRCH38chr14$ ll -h
	total 104M
	drwxrwxr-x 2 hadoop hadoop 4.0K  6月  7 20:50 ./
	drwxrwxr-x 8 hadoop hadoop 4.0K  6月  7 20:50 ../
	-rw-rw-r-- 1 hadoop hadoop 104M  6月  7 20:49 GRCH38chr14.fasta

4.构建BWA索引：

	hadoop@Master:~/xubo/data/GRCH38chr14$ bwa index GRCH38chr14.fasta 
	[bwa_index] Pack FASTA... 1.18 sec
	[bwa_index] Construct BWT for the packed sequence...
	[BWTIncCreate] textLength=214087436, availableWord=27063796
	[BWTIncConstructFromPacked] 10 iterations done. 44642828 characters processed.
	[BWTIncConstructFromPacked] 20 iterations done. 82473580 characters processed.
	[BWTIncConstructFromPacked] 30 iterations done. 116093612 characters processed.
	[BWTIncConstructFromPacked] 40 iterations done. 145971148 characters processed.
	[BWTIncConstructFromPacked] 50 iterations done. 172522364 characters processed.
	[BWTIncConstructFromPacked] 60 iterations done. 196117116 characters processed.
	[bwt_gen] Finished constructing BWT in 69 iterations.
	[bwa_index] 90.98 seconds elapse.
	[bwa_index] Update BWT... 0.73 sec
	[bwa_index] Pack forward-only FASTA... 0.81 sec
	[bwa_index] Construct SA from BWT and Occ... 26.56 sec
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa index GRCH38chr14.fasta
	[main] Real time: 123.991 sec; CPU: 120.265 sec

5.查看：

	hadoop@Master:~/xubo/data/GRCH38chr14$ samtools tview fq2.sorted.bam GRCH38chr14.fasta

add到20160530的ppt中

	Dbsnp：
	>gi|568815584|ref|NC_000014.9|:64442077-64442178 Homo sapiens chromosome 14, GRCh38.p7 Primary AssemblyTGGCCCGTTTGCCAACATCGCACATGGCAATTCCTCCATCATTGCAGACCGGATCGCACTCAAGCTTGTTGGCCCAGAAGGGTTTGTAGGTTAGTGTTTTTT
	GRCH38 从64442127开始：
	GGATCGCACTCAAGCTTGTTGGCCCAGAAGGGTTTGTAGGTTAGTGTTTTTTGCAAAACCAGTGAATA
	往两边：
	CGTTTGCCAACATCGCACATGGCAATTCCTCCATCATTGCAGACCGGATCGCACTCAAGCTTGTTGGCCCAGAAGGGTTTGTAGGTTAGTGTTTTTTGCAAAACCAGTGAAT
	Dbsnp和GRCH中一致



# 参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
	【5】http://stackoverflow.com/questions/28166667/how-to-pass-d-parameter-or-environment-variable-to-spark-job  
	【6】http://stackoverflow.com/questions/28840438/how-to-override-sparks-log4j-properties-per-driver

		
# 研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
# Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	