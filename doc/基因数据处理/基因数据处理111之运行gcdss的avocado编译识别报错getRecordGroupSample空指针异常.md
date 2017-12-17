	
脚本：

	hadoop@Master:~/xubo/project/callVariant$ cat runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.callVariant.callVariantByAvocado \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/alignment/output/sparkBWA/BBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c100000Nhs20Paired1.fastq-0-NoSort-local-1466932179576-0.sam \
	/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVar \
	/home/hadoop/xubo/data/testTools/basic.properties


运行错误记录
	
	
	hadoop@Master:~/xubo/project/callVariant$ ./run.sh 
	start main:
	start run:
	fqFile:/xubo/alignment/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.sam
	faFile:/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVar20160626211512908
	fqLoad.count:18480
	faLoad.count:24896                                                              
	[Stage 11:===================>                                      (1 + 2) / 3]16/06/26 21:17:27 ERROR TaskSetManager: Task 0 in stage 11.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 11.0 failed 4 times, most recent failure: Lost task 0.3 in stage 11.0 (TID 22, 219.219.220.248): java.lang.NullPointerException
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:54)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:46)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.bdgenomics.avocado.discovery.ReadExplorer.readToObservations(ReadExplorer.scala:46)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at scala.collection.Iterator$$anon$13.hasNext(Iterator.scala:371)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.insertAll(BypassMergeSortShuffleWriter.java:99)
		at org.apache.spark.shuffle.sort.SortShuffleWriter.write(SortShuffleWriter.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:41)
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
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1914)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopDataset$1.apply$mcV$sp(PairRDDFunctions.scala:1055)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopDataset$1.apply(PairRDDFunctions.scala:998)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopDataset$1.apply(PairRDDFunctions.scala:998)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.PairRDDFunctions.saveAsNewAPIHadoopDataset(PairRDDFunctions.scala:998)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply$mcV$sp(PairRDDFunctions.scala:938)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(PairRDDFunctions.scala:930)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(PairRDDFunctions.scala:930)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.PairRDDFunctions.saveAsNewAPIHadoopFile(PairRDDFunctions.scala:930)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply$mcV$sp(InstrumentedPairRDDFunctions.scala:485)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(InstrumentedPairRDDFunctions.scala:485)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(InstrumentedPairRDDFunctions.scala:485)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.apache.spark.rdd.InstrumentedRDD$.recordOperation(InstrumentedRDD.scala:378)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions.saveAsNewAPIHadoopFile(InstrumentedPairRDDFunctions.scala:484)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions$$anonfun$adamParquetSave$1.apply$mcV$sp(ADAMRDDFunctions.scala:75)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions$$anonfun$adamParquetSave$1.apply(ADAMRDDFunctions.scala:60)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions$$anonfun$adamParquetSave$1.apply(ADAMRDDFunctions.scala:60)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions.adamParquetSave(ADAMRDDFunctions.scala:60)
		at org.gcdss.cli.Gcdss$$anonfun$run$1.apply$mcV$sp(Gcdss.scala:220)
		at org.gcdss.cli.Gcdss$$anonfun$run$1.apply(Gcdss.scala:220)
		at org.gcdss.cli.Gcdss$$anonfun$run$1.apply(Gcdss.scala:220)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.gcdss.cli.Gcdss.run(Gcdss.scala:219)
		at org.gcdss.cli.callVariant.callVariantByAvocado.run(callVariantByAvocado.scala:23)
		at org.gcdss.cli.callVariant.callVariantByAvocado$.main(callVariantByAvocado.scala:43)
		at org.gcdss.cli.callVariant.callVariantByAvocado.main(callVariantByAvocado.scala)
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
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:54)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:46)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.bdgenomics.avocado.discovery.ReadExplorer.readToObservations(ReadExplorer.scala:46)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at scala.collection.Iterator$$anon$13.hasNext(Iterator.scala:371)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.insertAll(BypassMergeSortShuffleWriter.java:99)
		at org.apache.spark.shuffle.sort.SortShuffleWriter.write(SortShuffleWriter.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:41)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	hadoop@Master:~/xubo/project/callVariant$ ^C
	hadoop@Master:~/xubo/project/callVariant$ ls
	BWAMEMSparkAll.jar  load2.sh  run.sh  SRR003161.sh
	hadoop@Master:~/xubo/project/callVariant$ mv run.sh runBBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	hadoop@Master:~/xubo/project/callVariant$ cp runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	cp: missing destination file operand after ‘runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh’
	Try 'cp --help' for more information.
	hadoop@Master:~/xubo/project/callVariant$ cp runBBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition.sh runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	hadoop@Master:~/xubo/project/callVariant$ vi runBBg38L50c10000
	runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh  runBBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition.sh
	hadoop@Master:~/xubo/project/callVariant$ vi runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	hadoop@Master:~/xubo/project/callVariant$ ./runBBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	start main:
	start run:
	fqFile:/xubo/alignment/output/sparkBWA/BBg38L50c100000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c100000Nhs20Paired1.fastq-0-NoSort-local-1466932179576-0.sam
	faFile:/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVar20160626212446531
	fqLoad.count:185136
	faLoad.count:24896                                                              
	[Stage 11:===================>                                      (1 + 2) / 3]16/06/26 21:27:52 ERROR TaskSetManager: Task 0 in stage 11.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 11.0 failed 4 times, most recent failure: Lost task 0.3 in stage 11.0 (TID 22, 219.219.220.248): java.lang.NullPointerException
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:54)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:46)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.bdgenomics.avocado.discovery.ReadExplorer.readToObservations(ReadExplorer.scala:46)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at scala.collection.Iterator$$anon$13.hasNext(Iterator.scala:371)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.insertAll(BypassMergeSortShuffleWriter.java:99)
		at org.apache.spark.shuffle.sort.SortShuffleWriter.write(SortShuffleWriter.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:41)
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
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1914)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopDataset$1.apply$mcV$sp(PairRDDFunctions.scala:1055)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopDataset$1.apply(PairRDDFunctions.scala:998)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopDataset$1.apply(PairRDDFunctions.scala:998)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.PairRDDFunctions.saveAsNewAPIHadoopDataset(PairRDDFunctions.scala:998)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply$mcV$sp(PairRDDFunctions.scala:938)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(PairRDDFunctions.scala:930)
		at org.apache.spark.rdd.PairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(PairRDDFunctions.scala:930)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:147)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:108)
		at org.apache.spark.rdd.RDD.withScope(RDD.scala:310)
		at org.apache.spark.rdd.PairRDDFunctions.saveAsNewAPIHadoopFile(PairRDDFunctions.scala:930)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply$mcV$sp(InstrumentedPairRDDFunctions.scala:485)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(InstrumentedPairRDDFunctions.scala:485)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions$$anonfun$saveAsNewAPIHadoopFile$2.apply(InstrumentedPairRDDFunctions.scala:485)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.apache.spark.rdd.InstrumentedRDD$.recordOperation(InstrumentedRDD.scala:378)
		at org.apache.spark.rdd.InstrumentedPairRDDFunctions.saveAsNewAPIHadoopFile(InstrumentedPairRDDFunctions.scala:484)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions$$anonfun$adamParquetSave$1.apply$mcV$sp(ADAMRDDFunctions.scala:75)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions$$anonfun$adamParquetSave$1.apply(ADAMRDDFunctions.scala:60)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions$$anonfun$adamParquetSave$1.apply(ADAMRDDFunctions.scala:60)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.bdgenomics.adam.rdd.ADAMRDDFunctions.adamParquetSave(ADAMRDDFunctions.scala:60)
		at org.gcdss.cli.Gcdss$$anonfun$run$1.apply$mcV$sp(Gcdss.scala:220)
		at org.gcdss.cli.Gcdss$$anonfun$run$1.apply(Gcdss.scala:220)
		at org.gcdss.cli.Gcdss$$anonfun$run$1.apply(Gcdss.scala:220)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.gcdss.cli.Gcdss.run(Gcdss.scala:219)
		at org.gcdss.cli.callVariant.callVariantByAvocado.run(callVariantByAvocado.scala:23)
		at org.gcdss.cli.callVariant.callVariantByAvocado$.main(callVariantByAvocado.scala:43)
		at org.gcdss.cli.callVariant.callVariantByAvocado.main(callVariantByAvocado.scala)
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
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:54)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$readToObservations$1.apply(ReadExplorer.scala:46)
		at org.apache.spark.rdd.Timer.time(Timer.scala:57)
		at org.bdgenomics.avocado.discovery.ReadExplorer.readToObservations(ReadExplorer.scala:46)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at org.bdgenomics.avocado.discovery.ReadExplorer$$anonfun$discover$1$$anonfun$apply$3.apply(ReadExplorer.scala:177)
		at scala.collection.Iterator$$anon$13.hasNext(Iterator.scala:371)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.insertAll(BypassMergeSortShuffleWriter.java:99)
		at org.apache.spark.shuffle.sort.SortShuffleWriter.write(SortShuffleWriter.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:41)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)



#参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
		
#研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
#Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	