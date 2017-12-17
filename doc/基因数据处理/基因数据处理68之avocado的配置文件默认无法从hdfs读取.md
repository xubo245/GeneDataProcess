
（1）配置文件设置为hdfs路劲有问题

    val configFile = "hdfs://219.219.220.149:9000/xubo/avocado/avocado-sample-configs/basic.properties"

报错：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/test$ ./GcdssCallVariant2.sh 
	start:
	fqFile:hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.realigned.sam
	faFile:hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.fa
	configFile:hdfs://219.219.220.149:9000/xubo/avocado/avocado-sample-configs/basic.properties
	output:hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060505
	fqLoad.count:10
	faLoad.count:1
	faLoad:
	hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060505
	tempPath:/tmp/config8081833845300900496
	tempFilePath:/tmp/config8081833845300900496/temp.properties
	Exception in thread "main" org.apache.commons.configuration.ConfigurationException: Cannot locate configuration source hdfs://219.219.220.149:9000/xubo/avocado/avocado-sample-configs/basic.properties
	at org.apache.commons.configuration.AbstractFileConfiguration.load(AbstractFileConfiguration.java:217)
	at org.apache.commons.configuration.AbstractFileConfiguration.load(AbstractFileConfiguration.java:197)
	at org.apache.commons.configuration.AbstractHierarchicalFileConfiguration.load(AbstractHierarchicalFileConfiguration.java:164)
	at org.apache.commons.configuration.AbstractHierarchicalFileConfiguration.<init>(AbstractHierarchicalFileConfiguration.java:91)
	at org.apache.commons.configuration.plist.PropertyListConfiguration.<init>(PropertyListConfiguration.java:159)
	at org.gcdss.cli.Gcdss.<init>(Gcdss.scala:84)
	at org.gcdss.cli.Gcdss$.apply(Gcdss.scala:46)
	at org.gcdss.cli.GcdssCallVariant$.main(GcdssCallVariant.scala:64)
	at org.gcdss.cli.GcdssCallVariant.main(GcdssCallVariant.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
	at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
	at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
	at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
	at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)


（2）将配置文件设置为本地路劲可以通过：

	val configFile = "/home/hadoop/xubo/data/testTools/basic.properties"



记录：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/test$ ./GcdssCallVariant2.sh 
	start:
	fqFile:hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.realigned.sam
	faFile:hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.fa
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060505
	fqLoad.count:10
	faLoad.count:1
	faLoad:
	hdfs://219.219.220.149:9000/xubo/avocado/test201605281620AvocadoZidai060505
	tempPath:/tmp/config5809810828492689651
	tempFilePath:/tmp/config5809810828492689651/temp.properties
	Loading reads in from hdfs://219.219.220.149:9000/xubo/avocado/artificial/artificial.realigned.sam
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	read parquet:                                                                   
	*************end*************   
	
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
	