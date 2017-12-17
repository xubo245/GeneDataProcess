	
	
	hadoop@Master:~/xubo/project/callDisease/DataProcessing$ ./allVcf.sh 
	start:
	vcfFile:/xubo/callVariant/vcf/All_20160407.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	output:/xubo/callDisease/output/AllVCF.output
	vcfRdd.count:152331373                                                          
	vcfFilterRDD.count:152331373                                                    
	dbSnp2omimRdd.count:11199
	dbSnp2omimFilterRDD.count:11199
	vcf2omimRDD.count:11189                                                         
	vcf2omimSimpleRDD.count:11189                                                   
	omimRdd.count:15705                                                             
	outputRDD.count:10884                                                           
	end
	load time:2107773 ms
	outputSaveRDD:/xubo/callDisease/output/AllVCF.output/20160610000857365          
	outputSaveRDD2:/xubo/callDisease/output/AllVCF.output/Simple20160610000857365
	save time:64535 ms
	run time:2172308 ms
	16/06/10 00:10:02 WARN QueuedThreadPool: 1 threads could not be stopped


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
	