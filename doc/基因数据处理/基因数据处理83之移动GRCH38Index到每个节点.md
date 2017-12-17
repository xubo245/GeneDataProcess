
1.从cloud/adam移出到xubo/ref:

	hadoop@Master:~/cloud/adam/xubo/data/test20160310$ mkdir -p ~/xubo/ref/GRCH38Index/
	hadoop@Master:~/cloud/adam/xubo/data/test20160310$ mv GCA_000001405.15_GRCh38/* ~/xubo/ref/GRCH38Index/
	hadoop@Master:~/cloud/adam/xubo/data/test20160310$ cd ~/xubo/ref/GRCH38Index/
	hadoop@Master:~/xubo/ref/GRCH38Index$ ls
	createFastqBywgsim.sh   GCA_000001405.15_GRCh38_full_analysis_set.fna      GCA_000001405.15_GRCh38_full_analysis_set.fna.ann  GCA_000001405.15_GRCh38_full_analysis_set.fna.pac
	createFastqBywgsim.txt  GCA_000001405.15_GRCh38_full_analysis_set.fna.alt  GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt  GCA_000001405.15_GRCh38_full_analysis_set.fna.sa
	fastq                   GCA_000001405.15_GRCh38_full_analysis_set.fna.amb  GCA_000001405.15_GRCh38_full_analysis_set.fna.fai


2.每个节点创建目录：

	mkdir -p ~/xubo/ref/
	ssh Mcnode2
	mkdir -p ~/xubo/ref/
	ssh Mcnode3
	mkdir -p ~/xubo/ref/
	ssh Mcnode4
	mkdir -p ~/xubo/ref/
	ssh Mcnode5
	mkdir -p ~/xubo/ref/
	ssh Mcnode6
	mkdir -p ~/xubo/ref/


3.分发index到每个节点：

	hadoop@Master:~/xubo/ref$ dispatch.sh GRCH38Index/

比较耗时。
	
	hadoop@Master:~/xubo/ref$ dispatch.sh GRCH38Index/
	GCA_000001405.15_GRCh38_full_analysis_set.fna.ann                                                                                                            100%   72KB  71.7KB/s   00:00    
	createFastqBywgsim.sh                                                                                                                                        100%  541     0.5KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.pac                                                                                                            100%  765MB  10.8MB/s   01:11    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.sa                                                                                                             100% 1530MB  10.5MB/s   02:26    
	GCA_000001405.15_GRCh38_full_analysis_set.fna                                                                                                                100% 3105MB  10.7MB/s   04:50    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.amb                                                                                                            100%   20KB  19.7KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.alt                                                                                                            100%  214KB 214.2KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.fai                                                                                                            100%   19KB  19.0KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt                                                                                                            100% 3061MB  10.6MB/s   04:49    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.ann                                                                                                            100%   72KB  71.7KB/s   00:00    
	createFastqBywgsim.sh                                                                                                                                        100%  541     0.5KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.pac                                                                                                            100%  765MB  10.5MB/s   01:13    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.sa                                                                                                             100% 1530MB  10.7MB/s   02:23    
	GCA_000001405.15_GRCh38_full_analysis_set.fna                                                                                                                100% 3105MB  10.7MB/s   04:50    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.amb                                                                                                            100%   20KB  19.7KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.alt                                                                                                            100%  214KB 214.2KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.fai                                                                                                            100%   19KB  19.0KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt                                                                                                            100% 3061MB  10.3MB/s   04:57    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.ann                                                                                                            100%   72KB  71.7KB/s   00:00    
	createFastqBywgsim.sh                                                                                                                                        100%  541     0.5KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.pac                                                                                                            100%  765MB  10.9MB/s   01:10    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.sa                                                                                                             100% 1530MB   8.3MB/s   03:04    
	GCA_000001405.15_GRCh38_full_analysis_set.fna                                                                                                                100% 3105MB   9.9MB/s   05:13    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.amb                                                                                                            100%   20KB  19.7KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.alt                                                                                                            100%  214KB 214.2KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.fai                                                                                                            100%   19KB  19.0KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt                                                                                                            100% 3061MB  10.3MB/s   04:58    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.ann                                                                                                            100%   72KB  71.7KB/s   00:00    
	createFastqBywgsim.sh                                                                                                                                        100%  541     0.5KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.pac                                                                                                            100%  765MB  10.9MB/s   01:10    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.sa                                                                                                             100% 1530MB  10.1MB/s   02:32    
	GCA_000001405.15_GRCh38_full_analysis_set.fna                                                                                                                100% 3105MB   9.7MB/s   05:20    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.amb                                                                                                            100%   20KB  19.7KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.alt                                                                                                            100%  214KB 214.2KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.fai                                                                                                            100%   19KB  19.0KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt                                                                                                            100% 3061MB  10.4MB/s   04:54    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.ann                                                                                                            100%   72KB  71.7KB/s   00:00    
	createFastqBywgsim.sh                                                                                                                                        100%  541     0.5KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.pac                                                                                                            100%  765MB  10.8MB/s   01:11    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.sa                                                                                                             100% 1530MB  10.8MB/s   02:22    
	GCA_000001405.15_GRCh38_full_analysis_set.fna                                                                                                                100% 3105MB  10.0MB/s   05:11    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.amb                                                                                                            100%   20KB  19.7KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.alt                                                                                                            100%  214KB 214.2KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.fai                                                                                                            100%   19KB  19.0KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt                                                                                                            100% 3061MB  10.9MB/s   04:42    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.ann                                                                                                            100%   72KB  71.7KB/s   00:00    
	createFastqBywgsim.sh                                                                                                                                        100%  541     0.5KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.pac                                                                                                            100%  765MB  10.6MB/s   01:12    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.sa                                                                                                             100% 1530MB  10.4MB/s   02:27    
	GCA_000001405.15_GRCh38_full_analysis_set.fna                                                                                                                100% 3105MB   9.8MB/s   05:17    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.amb                                                                                                            100%   20KB  19.7KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.alt                                                                                                            100%  214KB 214.2KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.fai                                                                                                            100%   19KB  19.0KB/s   00:00    
	GCA_000001405.15_GRCh38_full_analysis_set.fna.bwt                                                                                                            100% 3061MB   9.7MB/s   05:15    
	hadoop@Master:~/xubo/ref$ mv GCA_000001405.15_GRCh38/* ~/xubo/ref/GRCH38Index/


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
	