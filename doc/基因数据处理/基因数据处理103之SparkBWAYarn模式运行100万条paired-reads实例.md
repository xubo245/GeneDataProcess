
脚本：

	spark-submit --class SparkBWA \
	--master yarn-client \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	--archives ./bwa.zip \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 3 \
	/xubo/alignment/sparkBWA/GRCH38chr1L3556522N1000000L100paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N1000000L100paired2.fastq \
	/xubo/alignment/output/sparkBWA/GRCH38chr1L3556522N1000000L100paired12Yarn


运行脚本记录：

	hadoop@Master:~/xubo/tools/SparkBWA/build$ ./pairedGRCH38L1N1000000Yarn.sh 
	hadoop@Master:~/xubo/tools/SparkBWA/build$  



本地和yarn比较：
	
	App ID	App Name	Started	Completed ▾	Duration	Spark User	Last Updated
	application_1466433907244_0149	SparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort 	2016/06/24 19:02:26 	2016/06/24 19:13:26 	11 min 	hadoop 	2016/06/24 19:13:26
	application_1466433907244_0148	SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort 	2016/06/24 18:59:28 	2016/06/24 19:00:07 	39 s 	hadoop 	2016/06/24 19:00:07
	application_1466433907244_0147	SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort 	2016/06/24 18:55:04 	2016/06/24 18:56:54 	1.8 min 	hadoop 	2016/06/24 18:56:54
	application_1466433907244_0145	SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort 	2016/06/24 18:46:51 	2016/06/24 18:47:51 	1.0 min 	hadoop 	2016/06/24 18:47:51
	application_1466433907244_0143	SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort 	2016/06/24 18:33:20 	2016/06/24 18:35:07 	1.8 min 	hadoop 	2016/06/24 18:35:07
	local-1466761536651	SparkBWA_GRCH38chr1L3556522N1000000L100paired1.fastq-3-NoSort 	2016/06/24 17:45:34 	2016/06/24 18:01:46 	16 min 	hadoop 	2016/06/24 18:01:46

local模式是16min  
yarn模式是11min

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
	