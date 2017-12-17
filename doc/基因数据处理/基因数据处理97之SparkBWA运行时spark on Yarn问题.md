hadoop@Master:~/xubo/tools/SparkBWA/build$ ./paired.sh 
Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
Adding default property: spark.eventLog.enabled=true
Adding default property: spark.eventLog.dir=file:///home/hadoop/Downloads/hangc/sparklog
Adding default property: spark.eventLog.compress=true
Adding default property: spark.yarn.executor.memoryOverhead=1704
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
  archives                file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
  mainClass               SparkBWA
  primaryResource         file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
  name                    SparkBWA
  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest4]
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
  spark.yarn.executor.memoryOverhead -> 1704
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
/xubo/alignment/output/sparkBWA/datatest4
System properties:
spark.driver.memory -> 1500m
spark.executor.memory -> 1500m
spark.executor.instances -> 32
spark.eventLog.enabled -> true
spark.eventLog.compress -> true
SPARK_SUBMIT -> true
spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
spark.app.name -> SparkBWA
spark.yarn.executor.memoryOverhead -> 1704
spark.jars -> file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
spark.submit.deployMode -> client
spark.yarn.dist.archives -> file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
spark.master -> yarn-client
spark.executor.cores -> 1
Classpath elements:
file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar


16/06/20 20:07:27 ERROR YarnScheduler: Lost executor 1 on Mcnode4: remote Rpc client disassociated
16/06/20 20:07:29 ERROR YarnScheduler: Lost executor 4 on Mcnode2: remote Rpc client disassociated
16/06/20 20:07:30 ERROR YarnScheduler: Lost executor 9 on Mcnode2: remote Rpc client disassociated
16/06/20 20:07:30 ERROR TaskSetManager: Task 0 in stage 2.1 failed 4 times; aborting job
Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 2.1 failed 4 times, most recent failure: Lost task 0.3 in stage 2.1 (TID 8, Mcnode2): ExecutorLostFailure (executor 9 lost)
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
hadoop@Master:~/xubo/tools/SparkBWA/build$ ./paired.sh 
Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
Adding default property: spark.eventLog.enabled=true
Adding default property: spark.eventLog.dir=file:///home/hadoop/Downloads/hangc/sparklog
Adding default property: spark.eventLog.compress=true
Adding default property: spark.yarn.executor.memoryOverhead=1704
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
  archives                file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
  mainClass               SparkBWA
  primaryResource         file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
  name                    SparkBWA
  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest4]
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
  spark.yarn.executor.memoryOverhead -> 1704
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
/xubo/alignment/output/sparkBWA/datatest4
System properties:
spark.driver.memory -> 1500m
spark.executor.memory -> 1500m
spark.executor.instances -> 32
spark.eventLog.enabled -> true
spark.eventLog.compress -> true
SPARK_SUBMIT -> true
spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
spark.app.name -> SparkBWA
spark.yarn.executor.memoryOverhead -> 1704
spark.jars -> file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
spark.submit.deployMode -> client
spark.yarn.dist.archives -> file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
spark.master -> yarn-client
spark.executor.cores -> 1
Classpath elements:
file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar


16/06/20 20:50:13 ERROR YarnScheduler: Lost executor 3 on Mcnode3: remote Rpc client disassociated
16/06/20 20:50:13 ERROR TaskSetManager: Task 0 in stage 2.0 failed 4 times; aborting job
Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 2.0 failed 4 times, most recent failure: Lost task 0.3 in stage 2.0 (TID 5, Mcnode3): ExecutorLostFailure (executor 3 lost)
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
hadoop@Master:~/xubo/tools/SparkBWA/build$ vi paired.sh 
hadoop@Master:~/xubo/tools/SparkBWA/build$ ./paired.sh 
Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
Adding default property: spark.eventLog.enabled=true
Adding default property: spark.eventLog.dir=file:///home/hadoop/Downloads/hangc/sparklog
Adding default property: spark.eventLog.compress=true
Adding default property: spark.yarn.executor.memoryOverhead=1704
Parsed arguments:
  master                  yarn-cluster
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
  archives                file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
  mainClass               SparkBWA
  primaryResource         file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
  name                    SparkBWA
  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest4]
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
  spark.yarn.executor.memoryOverhead -> 1704
  spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog

    
Main class:
org.apache.spark.deploy.yarn.Client
Arguments:
--name
SparkBWA
--driver-memory
1500m
--executor-memory
1500m
--executor-cores
1
--archives
file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
--jar
file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
--class
SparkBWA
--arg
-algorithm
--arg
mem
--arg
-reads
--arg
paired
--arg
-index
--arg
/home/hadoop/xubo/project/alignment/sparkBWA/index/datatest.fasta
--arg
/xubo/alignment/bwa/datatest.fq
--arg
/xubo/alignment/bwa/datatest.fq
--arg
/xubo/alignment/output/sparkBWA/datatest4
System properties:
spark.executor.memory -> 1500m
spark.driver.memory -> 1500m
spark.executor.instances -> 32
spark.eventLog.enabled -> true
spark.eventLog.compress -> true
SPARK_SUBMIT -> true
spark.executor.extraJavaOptions -> -Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
spark.app.name -> SparkBWA
spark.yarn.executor.memoryOverhead -> 1704
spark.submit.deployMode -> cluster
spark.eventLog.dir -> file:///home/hadoop/Downloads/hangc/sparklog
spark.master -> yarn-cluster
spark.executor.cores -> 1
Classpath elements:



Exception in thread "main" org.apache.spark.SparkException: Application application_1466418440530_0017 finished with failed status
	at org.apache.spark.deploy.yarn.Client.run(Client.scala:925)
	at org.apache.spark.deploy.yarn.Client$.main(Client.scala:971)
	at org.apache.spark.deploy.yarn.Client.main(Client.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
	at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
	at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
	at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
	at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)


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
	