		
		
		
		
		
		
		
		hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./paired.sh 
		Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
		Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
		Adding default property: spark.eventLog.enabled=true
		Adding default property: spark.eventLog.dir=file:///home/hadoop/Downloads/hangc/sparklog
		Adding default property: spark.eventLog.compress=true
		Adding default property: spark.yarn.executor.memoryOverhead=4704
		Parsed arguments:
		  master                  yarn-client
		  deployMode              null
		  executorMemory          1500m
		  executorCores           1
		  totalExecutorCores      null
		  propertiesFile          /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
		  driverMemory            1500m
		  driverCores             null
		  driverExtraClassPath    null
		  driverExtraLibraryPath  null
		  driverExtraJavaOptions  null
		  supervise               false
		  queue                   null
		  numExecutors            32
		  files                   null
		  pyFiles                 null
		  archives                file:/home/hadoop/xubo/project/alignment/sparkBWA/bwa.zip
		  mainClass               SparkBWA
		  primaryResource         file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
		  name                    SparkBWA
		  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest]
		  jars                    null
		  packages                null
		  packagesExclusions      null
		  repositories            null
		  verbose                 true
		
		Spark properties used, including those specified through
		 --conf and those from the properties file /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf:
		  spark.driver.memory -> 1500m
		  spark.eventLog.enabled -> true
		  spark.eventLog.compress -> true
		  spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
		  spark.yarn.executor.memoryOverhead -> 4704
		  spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
		
		    
		Main class:
		SparkBWA
		Arguments:
		-algorithm
		mem
		-reads
		paired
		-index
		/home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta
		/xubo/alignment/bwa/datatest.fq
		/xubo/alignment/bwa/datatest.fq
		/xubo/alignment/output/sparkBWA/datatest
		System properties:
		spark.driver.memory -> 1500m
		spark.executor.memory -> 1500m
		spark.executor.instances -> 32
		spark.eventLog.enabled -> true
		spark.eventLog.compress -> true
		SPARK_SUBMIT -> true
		spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
		spark.app.name -> SparkBWA
		spark.yarn.executor.memoryOverhead -> 4704
		spark.jars -> file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
		spark.submit.deployMode -> client
		spark.yarn.dist.archives -> file:/home/hadoop/xubo/project/alignment/sparkBWA/bwa.zip
		spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
		spark.master -> yarn-client
		spark.executor.cores -> 1
		Classpath elements:
		file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
		
		
		16/06/19 21:44:45 ERROR YarnScheduler: Lost executor 2 on Mcnode3: remote Rpc client disassociated
		16/06/19 21:44:45 ERROR TaskSetManager: Task 0 in stage 2.0 failed 4 times; aborting job
		Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 2.0 failed 4 times, most recent failure: Lost task 0.3 in stage 2.0 (TID 5, Mcnode3): ExecutorLostFailure (executor 2 lost)
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
			at org.apache.spark.rdd.RDD$$anonfun$collect$1.apply(RDD.scala:909)
			at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
			at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
			at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
			at org.apache.spark.rdd.RDD.collect(RDD.scala:908)
			at org.apache.spark.api.java.JavaRDDLike$class.collect(JavaRDDLike.scala:338)
			at org.apache.spark.api.java.AbstractJavaRDDLike.collect(JavaRDDLike.scala:47)
			at BwaRDD.MapBwa(BwaRDD.java:108)
			at BwaInterpreter.RunBwa(BwaInterpreter.java:437)
			at SparkBWA.main(SparkBWA.java:30)
			at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
			at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
			at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
			at java.lang.reflect.Method.invoke(Method.java:606)
			at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
			at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
			at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
			at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
			at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
		hadoop@Master:~/xubo/project/alignment/sparkBWA$ 
	
	
	第二次运行：
	
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./paired.sh 
	Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	Adding default property: spark.eventLog.enabled=true
	Adding default property: spark.eventLog.dir=file:///home/hadoop/Downloads/hangc/sparklog
	Adding default property: spark.eventLog.compress=true
	Adding default property: spark.yarn.executor.memoryOverhead=4704
	Parsed arguments:
	  master                  yarn-client
	  deployMode              null
	  executorMemory          1500m
	  executorCores           1
	  totalExecutorCores      null
	  propertiesFile          /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	  driverMemory            1500m
	  driverCores             null
	  driverExtraClassPath    null
	  driverExtraLibraryPath  null
	  driverExtraJavaOptions  null
	  supervise               false
	  queue                   null
	  numExecutors            32
	  files                   null
	  pyFiles                 null
	  archives                file:/home/hadoop/xubo/project/alignment/sparkBWA/bwa.zip
	  mainClass               SparkBWA
	  primaryResource         file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
	  name                    SparkBWA
	  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest]
	  jars                    null
	  packages                null
	  packagesExclusions      null
	  repositories            null
	  verbose                 true
	
	Spark properties used, including those specified through
	 --conf and those from the properties file /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf:
	  spark.driver.memory -> 1500m
	  spark.eventLog.enabled -> true
	  spark.eventLog.compress -> true
	  spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	  spark.yarn.executor.memoryOverhead -> 4704
	  spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
	
	    
	Main class:
	SparkBWA
	Arguments:
	-algorithm
	mem
	-reads
	paired
	-index
	/home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta
	/xubo/alignment/bwa/datatest.fq
	/xubo/alignment/bwa/datatest.fq
	/xubo/alignment/output/sparkBWA/datatest
	System properties:
	spark.driver.memory -> 1500m
	spark.executor.memory -> 1500m
	spark.executor.instances -> 32
	spark.eventLog.enabled -> true
	spark.eventLog.compress -> true
	SPARK_SUBMIT -> true
	spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	spark.app.name -> SparkBWA
	spark.yarn.executor.memoryOverhead -> 4704
	spark.jars -> file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
	spark.submit.deployMode -> client
	spark.yarn.dist.archives -> file:/home/hadoop/xubo/project/alignment/sparkBWA/bwa.zip
	spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
	spark.master -> yarn-client
	spark.executor.cores -> 1
	Classpath elements:
	file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
	
	
	16/06/19 21:57:49 ERROR YarnScheduler: Lost executor 1 on Mcnode4: remote Rpc client disassociated
	16/06/19 21:57:55 ERROR YarnScheduler: Lost executor 4 on Mcnode2: remote Rpc client disassociated
	16/06/19 21:58:11 ERROR YarnScheduler: Lost executor 7 on Mcnode4: remote Rpc client disassociated
	16/06/19 21:58:11 ERROR TaskSetManager: Task 0 in stage 2.1 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 2.1 failed 4 times, most recent failure: Lost task 0.3 in stage 2.1 (TID 11, Mcnode3): java.lang.UnsatisfiedLinkError: no bwa in java.library.path
		at java.lang.ClassLoader.loadLibrary(ClassLoader.java:1886)
		at java.lang.Runtime.loadLibrary0(Runtime.java:849)
		at java.lang.System.loadLibrary(System.java:1088)
		at BwaJni.<clinit>(BwaJni.java:44)
		at Bwa.run(Bwa.java:443)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:283)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:173)
		at org.apache.spark.api.java.JavaPairRDD$$anonfun$toScalaFunction2$1.apply(JavaPairRDD.scala:1024)
		at org.apache.spark.api.java.JavaRDDLike$$anonfun$mapPartitionsWithIndex$1.apply(JavaRDDLike.scala:102)
		at org.apache.spark.api.java.JavaRDDLike$$anonfun$mapPartitionsWithIndex$1.apply(JavaRDDLike.scala:102)
		at org.apache.spark.rdd.RDD$$anonfun$mapPartitionsWithIndex$1$$anonfun$apply$18.apply(RDD.scala:727)
		at org.apache.spark.rdd.RDD$$anonfun$mapPartitionsWithIndex$1$$anonfun$apply$18.apply(RDD.scala:727)
		at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
		at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
		at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
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
		at org.apache.spark.rdd.RDD$$anonfun$collect$1.apply(RDD.scala:909)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.RDD.collect(RDD.scala:908)
		at org.apache.spark.api.java.JavaRDDLike$class.collect(JavaRDDLike.scala:338)
		at org.apache.spark.api.java.AbstractJavaRDDLike.collect(JavaRDDLike.scala:47)
		at BwaRDD.MapBwa(BwaRDD.java:108)
		at BwaInterpreter.RunBwa(BwaInterpreter.java:437)
		at SparkBWA.main(SparkBWA.java:30)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.lang.UnsatisfiedLinkError: no bwa in java.library.path
		at java.lang.ClassLoader.loadLibrary(ClassLoader.java:1886)
		at java.lang.Runtime.loadLibrary0(Runtime.java:849)
		at java.lang.System.loadLibrary(System.java:1088)
		at BwaJni.<clinit>(BwaJni.java:44)
		at Bwa.run(Bwa.java:443)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:283)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:173)
		at org.apache.spark.api.java.JavaPairRDD$$anonfun$toScalaFunction2$1.apply(JavaPairRDD.scala:1024)
		at org.apache.spark.api.java.JavaRDDLike$$anonfun$mapPartitionsWithIndex$1.apply(JavaRDDLike.scala:102)
		at org.apache.spark.api.java.JavaRDDLike$$anonfun$mapPartitionsWithIndex$1.apply(JavaRDDLike.scala:102)
		at org.apache.spark.rdd.RDD$$anonfun$mapPartitionsWithIndex$1$$anonfun$apply$18.apply(RDD.scala:727)
		at org.apache.spark.rdd.RDD$$anonfun$mapPartitionsWithIndex$1$$anonfun$apply$18.apply(RDD.scala:727)
		at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
		at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
		at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ 
