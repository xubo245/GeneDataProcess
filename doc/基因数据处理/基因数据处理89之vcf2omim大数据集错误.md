	
	hadoop@Master:~/xubo/project/callDisease/Vcf2Omim$ ./allVcf.sh 
	start call Vcf2Omim
	start:
	Vcf2Omim
	vcfArrRDD:
	end
	[Stage 1:>                                                       (0 + 15) / 203]16/06/10 01:43:57 ERROR TaskSetManager: Task 3 in stage 1.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 3 in stage 1.0 failed 4 times, most recent failure: Lost task 3.3 in stage 1.0 (TID 24, 219.219.220.149): java.lang.NullPointerException
		at org.gcdss.cli.disease.Vcf2Omim$$anonfun$4.apply(Vcf2Omim.scala:45)
		at org.gcdss.cli.disease.Vcf2Omim$$anonfun$4.apply(Vcf2Omim.scala:44)
		at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1555)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at org.gcdss.cli.disease.Vcf2Omim.runSimple(Vcf2Omim.scala:50)
		at org.gcdss.cli.disease.Vcf2Omim$.main(Vcf2Omim.scala:87)
		at org.gcdss.cli.disease.Vcf2Omim.main(Vcf2Omim.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.lang.NullPointerException
		at org.gcdss.cli.disease.Vcf2Omim$$anonfun$4.apply(Vcf2Omim.scala:45)
		at org.gcdss.cli.disease.Vcf2Omim$$anonfun$4.apply(Vcf2Omim.scala:44)
		at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1555)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	hadoop@Master:~/xubo/project/callDisease/Vcf2Omim$ 

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
	