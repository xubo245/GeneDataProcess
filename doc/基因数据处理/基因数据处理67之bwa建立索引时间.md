两次，GRCH38 的1号染色体

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/bwaindex$ bwa index GRCH38chr1L3556522.fasta 
	[bwa_index] Pack FASTA... 2.50 sec
	[bwa_index] Construct BWT for the packed sequence...
	[BWTIncCreate] textLength=497912844, availableWord=47034604
	[BWTIncConstructFromPacked] 10 iterations done. 76325452 characters processed.
	[BWTIncConstructFromPacked] 20 iterations done. 142216380 characters processed.
	[BWTIncConstructFromPacked] 30 iterations done. 200776364 characters processed.
	[BWTIncConstructFromPacked] 40 iterations done. 252820604 characters processed.
	[BWTIncConstructFromPacked] 50 iterations done. 299073676 characters processed.
	[BWTIncConstructFromPacked] 60 iterations done. 340179500 characters processed.
	[BWTIncConstructFromPacked] 70 iterations done. 376710428 characters processed.
	[BWTIncConstructFromPacked] 80 iterations done. 409175164 characters processed.
	[BWTIncConstructFromPacked] 90 iterations done. 438025868 characters processed.
	[BWTIncConstructFromPacked] 100 iterations done. 463664428 characters processed.
	[BWTIncConstructFromPacked] 110 iterations done. 486447996 characters processed.
	[bwt_gen] Finished constructing BWT in 116 iterations.
	[bwa_index] 200.50 seconds elapse.
	[bwa_index] Update BWT... 1.68 sec
	[bwa_index] Pack forward-only FASTA... 1.62 sec
	[bwa_index] Construct SA from BWT and Occ... 63.19 sec
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa index GRCH38chr1L3556522.fasta
	[main] Real time: 277.699 sec; CPU: 269.497 sec
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/bwaindex$ bwa index GRCH38chr1L3556522.fasta 
	[bwa_index] Pack FASTA... 2.48 sec
	[bwa_index] Construct BWT for the packed sequence...
	[BWTIncCreate] textLength=497912844, availableWord=47034604
	[BWTIncConstructFromPacked] 10 iterations done. 76325452 characters processed.
	[BWTIncConstructFromPacked] 20 iterations done. 142216380 characters processed.
	[BWTIncConstructFromPacked] 30 iterations done. 200776364 characters processed.
	[BWTIncConstructFromPacked] 40 iterations done. 252820604 characters processed.
	[BWTIncConstructFromPacked] 50 iterations done. 299073676 characters processed.
	[BWTIncConstructFromPacked] 60 iterations done. 340179500 characters processed.
	[BWTIncConstructFromPacked] 70 iterations done. 376710428 characters processed.
	[BWTIncConstructFromPacked] 80 iterations done. 409175164 characters processed.
	[BWTIncConstructFromPacked] 90 iterations done. 438025868 characters processed.
	[BWTIncConstructFromPacked] 100 iterations done. 463664428 characters processed.
	[BWTIncConstructFromPacked] 110 iterations done. 486447996 characters processed.
	[bwt_gen] Finished constructing BWT in 116 iterations.
	[bwa_index] 201.29 seconds elapse.
	[bwa_index] Update BWT... 1.69 sec
	[bwa_index] Pack forward-only FASTA... 1.60 sec
	[bwa_index] Construct SA from BWT and Occ... 62.07 sec
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa index GRCH38chr1L3556522.fasta
	[main] Real time: 278.396 sec; CPU: 269.118 sec
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/bwaindex$ 


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
	