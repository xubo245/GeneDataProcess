	

脚本：

	hadoop@Master:~/xubo/project/alignment/sparkBWA$ cat pairedERR.sh 
	spark-submit --class SparkBWA \
	--master local[4] \
	--driver-memory 1500m \
	--executor-memory 1500m \
	--executor-cores 1 \
	--archives bwa.zip \
	--verbose \
	--num-executors 32 \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna \
	-partitions 30 \
	/xubo/alignment/sparkBWA/ERR000589_1.filt.fastq /xubo/alignment/sparkBWA/ERR000589_2.filt.fastq \
	/xubo/alignment/output/sparkBWA/datatestERR
	
	
	#--archives ./bwa.zip \
	#-partitions 1 /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest
	
	#/home/hadoop/xubo/data/alignment/bwa/datatest.fa \
	#spark_dir/bin/spark-submit --class SparkBWA --master yarn-client --driver-memory 1500m --executor-memory 1500m --executor-cores 1 --archives bwa.zip --verbose --num-executors 32 SparkBWA.jar -algorithm mem -reads paired -index /Data/HumanBase/hg38 -partitions 32 ERR000589_1.filt.fastq ERR000589_2.filt.fastq Output_ERR000589
	
	
报错问题：	
	
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./pairedERR.sh 
	Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	Adding default property: spark.eventLog.enabled=true
	Adding default property: spark.eventLog.dir=file:///home/hadoop/Downloads/hangc/sparklog
	Adding default property: spark.eventLog.compress=true
	Adding default property: spark.yarn.executor.memoryOverhead=8704
	Parsed arguments:
	  master                  local[4]
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
	  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna -partitions 30 /xubo/alignment/sparkBWA/ERR000589_1.filt.fastq /xubo/alignment/sparkBWA/ERR000589_2.filt.fastq /xubo/alignment/output/sparkBWA/datatestERR]
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
	  spark.yarn.executor.memoryOverhead -> 8704
	  spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
	
	    
	Main class:
	SparkBWA
	Arguments:
	-algorithm
	mem
	-reads
	paired
	-index
	/home/hadoop/xubo/ref/GRCH38Index/GCA_000001405.15_GRCh38_full_analysis_set.fna
	-partitions
	30
	/xubo/alignment/sparkBWA/ERR000589_1.filt.fastq
	/xubo/alignment/sparkBWA/ERR000589_2.filt.fastq
	/xubo/alignment/output/sparkBWA/datatestERR
	System properties:
	spark.driver.memory -> 1500m
	spark.eventLog.compress -> true
	spark.eventLog.enabled -> true
	SPARK_SUBMIT -> true
	spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	spark.app.name -> SparkBWA
	spark.yarn.executor.memoryOverhead -> 8704
	spark.jars -> file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
	spark.submit.deployMode -> client
	spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
	spark.master -> local[4]
	Classpath elements:
	file:/home/hadoop/xubo/project/alignment/sparkBWA/SparkBWA.jar
	
	
	[Stage 3:>                                                         (0 + 4) / 30]16/06/19 21:18:36 ERROR Executor: Exception in task 1.0 in stage 3.0 (TID 43)
	java.lang.UnsatisfiedLinkError: no bwa in java.library.path
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
	16/06/19 21:18:36 ERROR Executor: Exception in task 2.0 in stage 3.0 (TID 44)
	java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	16/06/19 21:18:36 ERROR Executor: Exception in task 3.0 in stage 3.0 (TID 45)
	java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	16/06/19 21:18:36 ERROR SparkUncaughtExceptionHandler: Uncaught exception in thread Thread[Executor task launch worker-8,5,main]
	java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	16/06/19 21:18:36 ERROR SparkUncaughtExceptionHandler: Uncaught exception in thread Thread[Executor task launch worker-6,5,main]
	java.lang.UnsatisfiedLinkError: no bwa in java.library.path
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
	16/06/19 21:18:36 ERROR SparkUncaughtExceptionHandler: Uncaught exception in thread Thread[Executor task launch worker-5,5,main]
	java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	16/06/19 21:18:37 ERROR Executor: Exception in task 0.0 in stage 3.0 (TID 42)
	java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	16/06/19 21:18:37 ERROR SparkUncaughtExceptionHandler: Uncaught exception in thread Thread[Executor task launch worker-3,5,main]
	java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	[Stage 3:>                                                         (0 + 5) / 30]16/06/19 21:18:37 ERROR TaskSetManager: Task 2 in stage 3.0 failed 1 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 2 in stage 3.0 failed 1 times, most recent failure: Lost task 2.0 in stage 3.0 (TID 44, localhost): java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	Caused by: java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
