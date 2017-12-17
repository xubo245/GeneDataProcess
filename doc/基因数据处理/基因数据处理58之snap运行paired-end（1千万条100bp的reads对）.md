```
	
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner index GRCH38BWAindex/GRCH38chr1L3556522.fasta snapindex
	Welcome to SNAP version 1.0beta.23.
	
	Hash table slack 0.300000
	Loading FASTA file 'GRCH38BWAindex/GRCH38chr1L3556522.fasta' into memory...
	FASTA file contained a character that's not a valid base (or N): 'M', full line 'TCACCCCCCACACACACCAAACAMCCCACACAACACACACACACCACACCACACAAACACAAACACACCA'; 
	converting to 'N'.  This may happen again, but there will be no more warnings.
	5s
	Saving genome...0s
	Computing bias table.
	Bias computation: 100000000 / 248957422
	Bias computation: 200000000 / 248957422
	Computed bias table in 10s
	Allocating memory for hash tables...3s
	Building hash tables.
	Indexing 100000000 / 248957422
	Indexing 200000000 / 248957422
	7173030(2%) seeds occur more than once, total of 45140283(18%) genome locations are not unique, 18478659(7%) bad seeds, 0 both complements used 500 no string
	Hash table build took 38s
	Building overflow table.
	Overflow table build and hash table save took 19s
	Saving overflow table...0s
	Index build and save took 76s (3275755 bases/s)
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner paired snapindex g38L100c10000000Nhs20Paired1.
	g38L100c10000000Nhs20Paired1.aln  g38L100c10000000Nhs20Paired1.fq   g38L100c10000000Nhs20Paired1.sai  
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner paired snapindex g38L100c10000000Nhs20Paired1.fq  g38L100c10000000Nhs20Paired2.fq -o g38L100c10000000Nhs20Paired12.snap.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 0s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns  %Pairs    Reads/s   Time in Aligner (s)
	18,512,662     18,007,468 (97.27%)    502,480 (2.71%)        2,714 (0.01%)          0 (0.00%)              99.95%    47,683    388
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ cat g38L100c10000000Nhs20Paired12.snap.sam |wc -l
	18512666

```

第二次
```

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner paired snap/snapindex g38L100c10000000Nhs20Paired1.fq  g38L100c10000000Nhs20Paired2.fq -o snap/g38L100c10000000Nhs20Paired12.snap2.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 12s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns  %Pairs    Reads/s   Time in Aligner (s)
	18,512,662     18,007,468 (97.27%)    502,480 (2.71%)        2,714 (0.01%)          0 (0.00%)              99.95%    47,020    394

```


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
	
