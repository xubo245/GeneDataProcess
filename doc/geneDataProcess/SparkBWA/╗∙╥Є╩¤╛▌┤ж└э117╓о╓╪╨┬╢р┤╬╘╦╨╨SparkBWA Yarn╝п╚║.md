	
更多代码请见：https://github.com/xubo245
	
基因数据处理系列
	
# 1.解释
	
	重新运行，跟换了文件地址
	后来终端，需要运行其他的
	
	
# 2.代码：
	
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi sparkBWA.sh 
	
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	echo $i
	echo $j
	 startTime4=`date +"%s.%N"`
	#fq='g38L'$i'c'$j'Nhs20Paired'$k'.fq'
	#fq0='g38L'$i'c'$j'Nhs20Paired*.fastq'
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	#out='g38L'$i'c'$j'Nhs20Paired12.sam'
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201606252236'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class SparkBWA \
	--master yarn-client \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/disk2/xubo/tools/SparkBWA/build" \
	--num-executors 7 --executor-cores 2 --executor-memory 4G \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 7 \
	$fq1 $fq2 $out
	
	
	#/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	#/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12YarnMaster
	
	
	endTime4=`date +"%s.%N"`
	echo "startTime"
	echo $startTime4
	echo "endTime"
	echo $endTime4
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " create fastq RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	done
	done
	
# 3.结果：
	
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./sparkBWA.sh 
	50
	10000
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201606252236
	startTime                                                                       
	1479351086.505011371
	endTime
	1479351134.077351683
	./sparkBWA.sh: line 40: 077351683: value too great for base (error token is "077351683")
	=>
	100
	10000
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201606252236
	[Stage 3:=========================>                                 (3 + 4) / 7]16/11/17 10:52:57 ERROR YarnScheduler: Lost executor 2 on Mcnode7: remote Rpc client disassociated
	startTime                                                                       
	1479351134.085401079
	endTime
	1479351179.286150158
	./sparkBWA.sh: line 40: 085401079: value too great for base (error token is "085401079")
	=>
	50
	100000
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201606252236
	startTime                                                                       
	1479351179.296705885
	endTime
	1479351229.506118524
	=> create fastq RunTime:50.209413 s
	100
	100000
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201606252236
	[Stage 3:================>                                          (2 + 5) / 7]16/11/17 10:54:52 ERROR YarnScheduler: Lost executor 5 on Mcnode2: remote Rpc client disassociated
	[Stage 3:=========================>                                 (3 + 4) / 7]16/11/17 10:54:53 ERROR YarnScheduler: Lost executor 4 on Mcnode1: remote Rpc client disassociated
	[Stage 3:==========================================>                (5 + 2) / 7]16/11/17 10:55:01 ERROR YarnScheduler: Lost executor 7 on Mcnode5: remote Rpc client disassociated
	startTime                                                                       
	1479351229.517251895
	endTime
	1479351312.629971202
	=> create fastq RunTime:83.112720 s
	50
	1000000
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201606252236
	startTime                                                                       
	1479351312.641663516
	endTime
	1479351453.475203453
	=> create fastq RunTime:140.833540 s
	100
	1000000
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201606252236
	startTime                                                                       
	1479351453.486862090
	endTime
	1479351620.803003402
	=> create fastq RunTime:167.316141 s
	50
	10000000
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201606252236
	startTime                                                                       
	1479351620.814108735
	endTime
	1479352429.512924153
	=> create fastq RunTime:808.698816 s
	100
	10000000
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201606252236
	[Stage 3:>                                                          (0 + 7) / 7]^CException in thread "main" org.apache.spark.SparkException: Job cancelled because SparkContext was shut down
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$cleanUpAfterSchedulerStop$1.apply(DAGScheduler.scala:703)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$cleanUpAfterSchedulerStop$1.apply(DAGScheduler.scala:702)
		at scala.collection.mutable.HashSet.foreach(HashSet.scala:79)
		at org.apache.spark.scheduler.DAGScheduler.cleanUpAfterSchedulerStop(DAGScheduler.scala:702)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onStop(DAGScheduler.scala:1514)
		at org.apache.spark.util.EventLoop.stop(EventLoop.scala:84)
		at org.apache.spark.scheduler.DAGScheduler.stop(DAGScheduler.scala:1438)
		at org.apache.spark.SparkContext$$anonfun$stop$7.apply$mcV$sp(SparkContext.scala:1724)
		at org.apache.spark.util.Utils$.tryLogNonFatalError(Utils.scala:1185)
		at org.apache.spark.SparkContext.stop(SparkContext.scala:1723)
		at org.apache.spark.SparkContext$$anonfun$3.apply$mcV$sp(SparkContext.scala:587)
		at org.apache.spark.util.SparkShutdownHook.run(ShutdownHookManager.scala:264)
		at org.apache.spark.util.SparkShutdownHookManager$$anonfun$runAll$1$$anonfun$apply$mcV$sp$1.apply$mcV$sp(ShutdownHookManager.scala:234)
		at org.apache.spark.util.SparkShutdownHookManager$$anonfun$runAll$1$$anonfun$apply$mcV$sp$1.apply(ShutdownHookManager.scala:234)
		at org.apache.spark.util.SparkShutdownHookManager$$anonfun$runAll$1$$anonfun$apply$mcV$sp$1.apply(ShutdownHookManager.scala:234)
		at org.apache.spark.util.Utils$.logUncaughtExceptions(Utils.scala:1699)
		at org.apache.spark.util.SparkShutdownHookManager$$anonfun$runAll$1.apply$mcV$sp(ShutdownHookManager.scala:234)
		at org.apache.spark.util.SparkShutdownHookManager$$anonfun$runAll$1.apply(ShutdownHookManager.scala:234)
		at org.apache.spark.util.SparkShutdownHookManager$$anonfun$runAll$1.apply(ShutdownHookManager.scala:234)
		at scala.util.Try$.apply(Try.scala:161)
		at org.apache.spark.util.SparkShutdownHookManager.runAll(ShutdownHookManager.scala:234)
		at org.apache.spark.util.SparkShutdownHookManager$$anon$2.run(ShutdownHookManager.scala:216)
		at org.apache.hadoop.util.ShutdownHookManager$1.run(ShutdownHookManager.java:54)
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
	startTime
	1479352429.523683024
	endTime
	1479352730.305239313
	=> create fastq RunTime:300.781556 s
	
	
参考
	
		【1】https://github.com/xubo245
		【4】http://blog.csdn.net/xubo245/
