	
1.下载：

	https://github.com/broadinstitute/picard.git
	
2.安装：

	hadoop@Master:~/xubo/tools/picard$ ant clone-htsjdk
	Buildfile: /home/hadoop/xubo/tools/picard/build.xml
	
	clone-htsjdk:
	     [exec] Cloning into 'htsjdk'...
	     [echo] Checking out HTSJDK tagged version [2.4.1]
	     [exec] Note: checking out '2.4.1'.
	     [exec] 
	     [exec] You are in 'detached HEAD' state. You can look around, make experimental
	     [exec] changes and commit them, and you can discard any commits you make in this
	     [exec] state without impacting any branches by performing another checkout.
	     [exec] 
	     [exec] If you want to create a new branch to retain commits you create, you may
	     [exec] do so (now or later) by using -b with the checkout command again. Example:
	     [exec] 
	     [exec]   git checkout -b new_branch_name
	     [exec] 
	     [exec] HEAD is now at 52df499... Merge pull request #615 from samtools/dr_disable_intel_gkl
	
	BUILD SUCCESSFUL
	Total time: 34 minutes 17 seconds
	hadoop@Master:~/xubo/tools/picard$ ant
	Buildfile: /home/hadoop/xubo/tools/picard/build.xml
	
	write-version-property:
	[propertyfile] Creating new property file: /home/hadoop/xubo/tools/picard/htsjdk/htsjdk.version.properties
	
	set-htsjdk-version:
	
	compile-htsjdk:
	     [exec] :compileJava FAILED
	     [exec] 
	     [exec] FAILURE: Build failed with an exception.
	     [exec] 
	     [exec] * What went wrong:
	     [exec] Execution failed for task ':compileJava'.
	     [exec] > invalid source release: 1.8
	     [exec] 
	     [exec] * Try:
	     [exec] Run with --stacktrace option to get the stack trace. Run with --info or --debug
	     [exec] BUILD FAILED
	     [exec] 
	     [exec] Total time: 26.918 secs
	     [exec]  option to get more log output.
	     [exec] Result: 1
	
	BUILD FAILED
	/home/hadoop/xubo/tools/picard/build.xml:174: /home/hadoop/xubo/tools/picard/htsjdk/build/libs does not exist.
	
	Total time: 47 seconds
	hadoop@Master:~/xubo/tools/picard$ 


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
	