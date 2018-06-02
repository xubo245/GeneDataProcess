更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1 简述
当partitions超过节点数量的时候Lost executor的问题，已经提交到SparkBWA中，https://github.com/citiususc/SparkBWA/issues/35

另外发现

###1.1.1 tmp里面有临时文件没有删除
![](http://i.imgur.com/lSv5U8z.png)

可能会导致空间不足，特别是大文件，多次失败

###1.1.2 stage retry问题

![](http://i.imgur.com/r273Gq8.png)

###1.1.3 同时还会出现sam文件中有两组SQ和PQ的情况： 

![](http://i.imgur.com/sl3191M.png)


##1.2 疑问或引深的问题

###1.2.1 问什么要排序？
问题是耗时，不知为啥

###1.2.2 partitions不能增加的问题（执行的是没有报错的，但是partitions比较小）
数据分布不均匀，导致执行时间不一样，stages中以最慢task为准，所以会延长总的，如果能增加partitions数量，会一定程度上优化。
![](http://i.imgur.com/ZhXRthd.png)

stage以task中最慢的3.7min为准：
![](http://i.imgur.com/o5qQRHz.png)

而不是最快的3.0min

##未解决

# 2.记录


完整报错：

	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c100000Nhs20Paired1.fastq-18-NoSort-app-20170213192407-1107-4.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c100000Nhs20Paired1.fastq-18-NoSort-app-20170213192407-1107-4.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD4_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 8 '/home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD4_2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD4_1.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[6]: /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD4_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 10284 sequences (1028400 bp)...
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c100000Nhs20Paired1.fastq-18-NoSort-app-20170213192407-1107-12.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c100000Nhs20Paired1.fastq-18-NoSort-app-20170213192407-1107-12.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD12_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 8 '/home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD12_2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD12_1.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[6]: /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD12_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 10286 sequences (1028600 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 4579, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (191, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (163, 233)
	[M::mem_pestat] mean and std.dev: (198.15, 10.05)
	[M::mem_pestat] low and high boundaries for proper pairs: (149, 247)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 10284 reads in 3.555 CPU sec, 1.835 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD4_1 /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD4_2
	[main] Real time: 2.076 sec; CPU: 16.998 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	17/02/13 19:24:28 ERROR BwaAlignmentBase: getOutputFile:/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c100000Nhs20Paired1.fastq-18-NoSort-app-20170213192407-1107-4.sam
	17/02/13 19:24:28 ERROR BwaAlignmentBase: outputSamFileName:/xubo/project/alignment/sparkBWA/output/g38chr1/standaloneT20170213192403L100c100000Nhs20Paired12/SparkBWA_g38L100c100000Nhs20Paired1.fastq-18-NoSort-app-20170213192407-1107-4.sam
	17/02/13 19:24:29 ERROR RetryingBlockFetcher: Exception while beginning fetch of 1 outstanding blocks
	java.io.IOException: Failed to connect to Mcnode1/219.219.220.180:44294
	        at org.apache.spark.network.client.TransportClientFactory.createClient(TransportClientFactory.java:193)
	        at org.apache.spark.network.client.TransportClientFactory.createClient(TransportClientFactory.java:156)
	        at org.apache.spark.network.netty.NettyBlockTransferService$$anon$1.createAndStart(NettyBlockTransferService.scala:88)
	        at org.apache.spark.network.shuffle.RetryingBlockFetcher.fetchAllOutstanding(RetryingBlockFetcher.java:140)
	        at org.apache.spark.network.shuffle.RetryingBlockFetcher.start(RetryingBlockFetcher.java:120)
	        at org.apache.spark.network.netty.NettyBlockTransferService.fetchBlocks(NettyBlockTransferService.scala:97)
	        at org.apache.spark.storage.ShuffleBlockFetcherIterator.sendRequest(ShuffleBlockFetcherIterator.scala:152)
	        at org.apache.spark.storage.ShuffleBlockFetcherIterator.initialize(ShuffleBlockFetcherIterator.scala:265)
	        at org.apache.spark.storage.ShuffleBlockFetcherIterator.<init>(ShuffleBlockFetcherIterator.scala:112)
	        at org.apache.spark.shuffle.hash.HashShuffleReader.read(HashShuffleReader.scala:43)
	        at org.apache.spark.rdd.ShuffledRDD.compute(ShuffledRDD.scala:90)
	        at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
	        at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
	        at org.apache.spark.rdd.CoalescedRDD$$anonfun$compute$1.apply(CoalescedRDD.scala:96)
	        at org.apache.spark.rdd.CoalescedRDD$$anonfun$compute$1.apply(CoalescedRDD.scala:95)
	        at scala.collection.Iterator$$anon$13.hasNext(Iterator.scala:371)
	        at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
	        at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
	        at scala.collection.convert.Wrappers$IteratorWrapper.hasNext(Wrappers.scala:29)
	        at com.github.sparkbwa.BwaPairedAlignment.call(BwaPairedAlignment.java:94)
	        at com.github.sparkbwa.BwaPairedAlignment.call(BwaPairedAlignment.java:33)
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
	Caused by: java.net.ConnectException: Connection refused: Mcnode1/219.219.220.180:44294
	        at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)
	        at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:739)
	        at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:224)
	        at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:289)
	        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:528)
	        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:468)
	        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)
	        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)
	        at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:111)
	        ... 1 more
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 4601, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.69, 9.94)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 10286 reads in 6.262 CPU sec, 4.261 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD12_1 /home/hadoop/cloud/workspace/tmps/app-20170213192407-1107-RDD12_2
	[main] Real time: 4.478 sec; CPU: 20.226 sec
	*** Error in `/usr/lib/jvm/jdk1.7.0/bin/java': munmap_chunk(): invalid pointer: 0x00007fc3702d3710 ***



参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
