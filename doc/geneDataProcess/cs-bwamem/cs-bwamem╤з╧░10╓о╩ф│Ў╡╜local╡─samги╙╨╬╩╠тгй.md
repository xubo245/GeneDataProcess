更多代码请见：https://github.com/xubo245
	
基因数据处理系列之cs-bwamem

# 1.解释
##1.1

当运行cs-bwamem代码时，产生的数据输出到local节点的sam文件。fastq是两个2.4g的paired-end文件，产生的sam文件大概4.3G

	
	hadoop@Master:~/disk2/xubo/project/alignment/cs-bwamem$ cat newg38L50c10000000Nhs20Paired12P64bn200000000t100k7sbatch.sam |wc -l
	20256760

中间出现了error，见3.1
# 2.代码
##2.1

	hadoop@Master:~/disk2/xubo/project/alignment/cs-bwamem$ cat  csbwamemAlignP1Test10sam.sh 
	#for t in 1 2 3 4 5 6 7 8 9 10 15 20 30 40 50 60 70 80 90 100 120 140 160 180 200 300 400 500 600 700 800 900 1000 2000 3000 4000 5000 6000 7000 8000 9000 10000
	#for t in 1 10 50 100 400 1000 5000 10000
	#for t in {90..400..10}
	for t in 100
	do
	for k in {7..9}
	do 
	#for j in 10000 100000 1000000 10000000
	for j in 10000000
	do
	for i in 50
	do
	echo $i
	echo $j
	echo 't'$t
	echo 'k'$k
	#fq='g38L'$i'c'$j'Nhs20Paired'$k'.fq'
	#fq0='g38L'$i'c'$j'Nhs20Paired*.fastq'
	#fq1='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired1.fastq'
	#fq2='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired2.fastq'
	#out='g38L'$i'c'$j'Nhs20Paired12.sam'
	#out='/xubo/project/alignment/cs-bwamem/input/fastq/newg38L'$i'c'$j'Nhs20Paired12P64bn200000000t'$t'k'$k'sbatch.adam'
	out='/home/hadoop/disk2/xubo/project/alignment/cs-bwamem/newg38L'$i'c'$j'Nhs20Paired12P64bn200000000t'$t'k'$k'sbatch.sam'
	#out='/home/hadoop/disk2/xubo/project/alignment/cs-bwamem/newg38L'$i'c'$j'Nhs20Paired12P64bn200000000.sam'
	file='/xubo/project/alignment/cs-bwamem/input/fastq/newg38L'$i'c'$j'Nhs20Paired12P64bn200000000.fastq'
	#out='/xubo/project/alignment/cs-bwamem/input/fastq/newg38L'$i'c'$j'Nhs20Paired12P1k'$k'.adam'
	#file='/xubo/project/alignment/cs-bwamem/input/fastq/newg38L'$i'c'$j'Nhs20Paired12P1.fastq'
	
	echo $file
	echo $out
	
	spark-submit --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --executor-cores 2 --executor-memory 20G \
	--master spark://219.219.220.149:7077 /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/cloud-scale-bwamem-0.2.2-assembly.jar \
	cs-bwamem -bfn 1 -bPSW 1 -sbatch $t -bPSWJNI 1  -oChoice 1 -oPath $out -localRef 1 \
	-jniPath /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/jniNative.so \
	-isSWExtBatched 1  1 \
	/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta  $file
	
	#spark-submit --executor-memory 6g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 $file $out
	
	
	#/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	#/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12YarnMaster
	
	done 
	done
	done
	done
	#--master spark://219.219.220.149:7077 /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar \
	#--master spark://219.219.220.149:7077 /curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.0-assembly.jar \

修改了cs-bwamem配置，不然会报错：cs.ucla.edu.bwaspark.BWAMEMSpark#main

  	conf.set("spark.kryoserializer.buffer.max","2047m")
    conf.set("spark.driver.maxResultSize","20470m")

# 3.结果
##3.1
	
	hadoop@Master:~/disk2/xubo/project/alignment/cs-bwamem$ ./csbwamemAlignP1Test10sam.sh > csbwamemAlignP1Test10samtime201702281820.txt
	[Stage 2:========================================>               (46 + 18) / 64]17/02/28 18:40:01 ERROR TaskSchedulerImpl: Lost executor 2 on Master: Executor heartbeat timed out after 138044 ms
	[Stage 2:========================================>               (46 + 17) / 64]17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 1 on Mcnode2: Executor heartbeat timed out after 138057 ms
	17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 4 on Mcnode7: Executor heartbeat timed out after 138038 ms
	17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 0 on Mcnode4: Executor heartbeat timed out after 192160 ms
	17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 3 on Mcnode5: Executor heartbeat timed out after 135875 ms
	17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 5 on Mcnode6: Executor heartbeat timed out after 210361 ms
	17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 7 on Mcnode1: Executor heartbeat timed out after 210554 ms
	17/02/28 18:40:57 ERROR TaskSchedulerImpl: Lost executor 6 on Mcnode3: Executor heartbeat timed out after 211929 ms
	[Stage 2:====================================================>   (60 + -3) / 64]17/02/28 18:47:54 ERROR TaskSchedulerImpl: Lost executor 4 on Mcnode7: remote Rpc client disassociated
	[Stage 2:====================================================>   (60 + -4) / 64]17/02/28 18:47:54 ERROR TaskSchedulerImpl: Lost executor 1 on Mcnode2: remote Rpc client disassociated
	17/02/28 18:47:54 ERROR TaskSchedulerImpl: Lost executor 2 on Master: remote Rpc client disassociated
	[Stage 2:=======================================================(65 + -10) / 64]17/02/28 18:47:54 ERROR Utils: Uncaught exception in thread kill-executor-thread
	org.apache.spark.SparkException: Error sending message [message = KillExecutors(app-20170228182352-0891,List(0))]
		at org.apache.spark.rpc.RpcEndpointRef.askWithRetry(RpcEndpointRef.scala:118)
		at org.apache.spark.rpc.RpcEndpointRef.askWithRetry(RpcEndpointRef.scala:77)
		at org.apache.spark.deploy.client.AppClient.killExecutors(AppClient.scala:298)
		at org.apache.spark.scheduler.cluster.SparkDeploySchedulerBackend.doKillExecutors(SparkDeploySchedulerBackend.scala:176)
		at org.apache.spark.scheduler.cluster.CoarseGrainedSchedulerBackend.killExecutors(CoarseGrainedSchedulerBackend.scala:439)
		at org.apache.spark.SparkContext.killAndReplaceExecutor(SparkContext.scala:1500)
		at org.apache.spark.HeartbeatReceiver$$anonfun$org$apache$spark$HeartbeatReceiver$$expireDeadHosts$3$$anon$3$$anonfun$run$3.apply$mcV$sp(HeartbeatReceiver.scala:206)
		at org.apache.spark.util.Utils$.tryLogNonFatalError(Utils.scala:1185)
		at org.apache.spark.HeartbeatReceiver$$anonfun$org$apache$spark$HeartbeatReceiver$$expireDeadHosts$3$$anon$3.run(HeartbeatReceiver.scala:203)
		at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:471)
		at java.util.concurrent.FutureTask.run(FutureTask.java:262)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	Caused by: org.apache.spark.rpc.RpcTimeoutException: Futures timed out after [120 seconds]. This timeout is controlled by spark.rpc.askTimeout
		at org.apache.spark.rpc.RpcTimeout.org$apache$spark$rpc$RpcTimeout$$createRpcTimeoutException(RpcEnv.scala:214)
		at org.apache.spark.rpc.RpcTimeout$$anonfun$addMessageIfTimeout$1.applyOrElse(RpcEnv.scala:229)
		at org.apache.spark.rpc.RpcTimeout$$anonfun$addMessageIfTimeout$1.applyOrElse(RpcEnv.scala:225)
		at scala.runtime.AbstractPartialFunction.apply(AbstractPartialFunction.scala:33)
		at org.apache.spark.rpc.RpcTimeout.awaitResult(RpcEnv.scala:242)
		at org.apache.spark.rpc.RpcEndpointRef.askWithRetry(RpcEndpointRef.scala:101)
		... 13 more
	Caused by: java.util.concurrent.TimeoutException: Futures timed out after [120 seconds]
		at scala.concurrent.impl.Promise$DefaultPromise.ready(Promise.scala:219)
		at scala.concurrent.impl.Promise$DefaultPromise.result(Promise.scala:223)
		at scala.concurrent.Await$$anonfun$result$1.apply(package.scala:107)
		at scala.concurrent.BlockContext$DefaultBlockContext$.blockOn(BlockContext.scala:53)
		at scala.concurrent.Await$.result(package.scala:107)
		at org.apache.spark.rpc.RpcTimeout.awaitResult(RpcEnv.scala:241)
		... 14 more
	17/02/28 18:47:55 ERROR TaskSchedulerImpl: Lost executor 0 on Mcnode4: remote Rpc client disassociated
	[Stage 2:=======================================================(66 + -11) / 64]17/02/28 18:47:56 ERROR TaskSchedulerImpl: Lost executor 3 on Mcnode5: remote Rpc client disassociated
	[Stage 2:=======================================================(66 + -12) / 64]17/02/28 18:47:56 ERROR TaskSchedulerImpl: Lost executor 7 on Mcnode1: remote Rpc client disassociated
	17/02/28 18:47:56 ERROR TaskSchedulerImpl: Lost executor 6 on Mcnode3: remote Rpc client disassociated
	17/02/28 18:47:56 ERROR TaskSchedulerImpl: Lost executor 5 on Mcnode6: remote Rpc client disassociated

第二次运行直接被kill了：
	17/02/28 18:47:56 ERROR TaskSchedulerImpl: Lost executor 6 on Mcnode3: remote Rpc client disassociated
	17/02/28 18:47:56 ERROR TaskSchedulerImpl: Lost executor 5 on Mcnode6: remote Rpc client disassociated
	[Stage 2:===========================================>            (50 + 14) / 64]17/02/28 19:09:17 ERROR TaskSchedulerImpl: Lost executor 2 on Master: Executor heartbeat timed out after 183375 ms
	[Stage 2:===========================================>            (50 + 13) / 64]17/02/28 19:10:58 ERROR TaskSchedulerImpl: Lost executor 7 on Mcnode1: Executor heartbeat timed out after 157983 ms
	17/02/28 19:10:58 ERROR TaskSchedulerImpl: Lost executor 4 on Mcnode7: Executor heartbeat timed out after 131491 ms
	17/02/28 19:10:58 ERROR TaskSchedulerImpl: Lost executor 6 on Mcnode3: Executor heartbeat timed out after 130132 ms
	17/02/28 19:10:58 ERROR TaskSchedulerImpl: Lost executor 0 on Mcnode4: Executor heartbeat timed out after 130895 ms
	17/02/28 19:10:59 ERROR TaskSchedulerImpl: Lost executor 5 on Mcnode6: Executor heartbeat timed out after 203762 ms
	17/02/28 19:10:59 ERROR TaskSchedulerImpl: Lost executor 1 on Mcnode2: Executor heartbeat timed out after 204465 ms
	17/02/28 19:10:59 ERROR TaskSchedulerImpl: Lost executor 3 on Mcnode5: Executor heartbeat timed out after 244520 ms
	[Stage 2:===========================================>            (50 + 12) / 64]./csbwamemAlignP1Test10sam.sh: line 11:  5631 Killed                  spark-submit --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --executor-cores 2 --executor-memory 20G --master spark://219.219.220.149:7077 /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/cloud-scale-bwamem-0.2.2-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch $t -bPSWJNI 1 -oChoice 1 -oPath $out -localRef 1 -jniPath /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/jniNative.so -isSWExtBatched 1 1 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta $file


参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
