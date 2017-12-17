
在处理500bp和1000bp的时候，snap都无法处理：

	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l500N10000.fq -o g38l500N10000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 30s.  248957422 bases, seed size 20
	Aligning.
	BaseAligner:: got too big read (500 > 400)
	Increase MAX_READ_LENGTH at the beginning of Read.h and recompile
	SNAP exited with exit code 1 from line 302 of file SNAPLib/BaseAligner.cpp
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l1000N10000.fq -o g38l1000N10000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 31s.  248957422 bases, seed size 20
	Aligning.
	BaseAligner:: got too big read (1000 > 400)
	Increase MAX_READ_LENGTH at the beginning of Read.h and recompile
	SNAP exited with exit code 1 from line 302 of file SNAPLib/BaseAligner.cpp
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ 


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
	