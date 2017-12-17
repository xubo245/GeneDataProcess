
数据来自：  

http://219.219.220.149:18080/history/application_1466866953605_0001/executors/


http://219.219.220.248:8042/node/containerlogs/container_1466866953605_0001_01_000003/hadoop/stderr/?start=0
	
	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/filecache/10/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/home/hadoop/cloud/hadoop-2.6.0/share/hadoop/common/lib/slf4j-log4j12-1.7.5.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	16/06/25 23:28:05 INFO executor.CoarseGrainedExecutorBackend: Registered signal handlers for [TERM, HUP, INT]
	16/06/25 23:28:06 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	16/06/25 23:28:06 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/25 23:28:06 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/25 23:28:06 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/25 23:28:07 INFO slf4j.Slf4jLogger: Slf4jLogger started
	16/06/25 23:28:07 INFO Remoting: Starting remoting
	16/06/25 23:28:07 INFO Remoting: Remoting started; listening on addresses :[akka.tcp://driverPropsFetcher@Mcnode2:53394]
	16/06/25 23:28:07 INFO util.Utils: Successfully started service 'driverPropsFetcher' on port 53394.
	16/06/25 23:28:08 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/25 23:28:08 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/25 23:28:08 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/25 23:28:08 INFO remote.RemoteActorRefProvider$RemotingTerminator: Shutting down remote daemon.
	16/06/25 23:28:08 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remote daemon shut down; proceeding with flushing remote transports.
	16/06/25 23:28:08 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remoting shut down.
	16/06/25 23:28:08 INFO slf4j.Slf4jLogger: Slf4jLogger started
	16/06/25 23:28:08 INFO Remoting: Starting remoting
	16/06/25 23:28:08 INFO Remoting: Remoting started; listening on addresses :[akka.tcp://sparkExecutor@Mcnode2:56481]
	16/06/25 23:28:08 INFO util.Utils: Successfully started service 'sparkExecutor' on port 56481.
	16/06/25 23:28:08 INFO storage.DiskBlockManager: Created local directory at /home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/appcache/application_1466866953605_0001/blockmgr-cdbd5c40-dbcb-4125-bbb5-e08e828fdc6d
	16/06/25 23:28:08 INFO storage.MemoryStore: MemoryStore started with capacity 2.1 GB
	16/06/25 23:28:08 INFO executor.CoarseGrainedExecutorBackend: Connecting to driver: akka.tcp://sparkDriver@219.219.220.149:34876/user/CoarseGrainedScheduler
	16/06/25 23:28:08 INFO executor.CoarseGrainedExecutorBackend: Successfully registered with driver
	16/06/25 23:28:08 INFO executor.Executor: Starting executor ID 1 on host Mcnode2
	16/06/25 23:28:08 INFO util.Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 53069.
	16/06/25 23:28:08 INFO netty.NettyBlockTransferService: Server created on 53069
	16/06/25 23:28:08 INFO storage.BlockManagerMaster: Trying to register BlockManager
	16/06/25 23:28:08 INFO storage.BlockManagerMaster: Registered BlockManager
	16/06/25 23:28:08 INFO executor.CoarseGrainedExecutorBackend: Got assigned task 0
	16/06/25 23:28:08 INFO executor.Executor: Running task 0.0 in stage 0.0 (TID 0)
	16/06/25 23:28:08 INFO executor.Executor: Fetching http://219.219.220.149:49344/jars/SparkBWA.jar with timestamp 1466868430534
	16/06/25 23:28:09 INFO util.Utils: Fetching http://219.219.220.149:49344/jars/SparkBWA.jar to /home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/appcache/application_1466866953605_0001/spark-1755b7f0-a414-4e4c-ab0a-ba6eb1ae2e1c/fetchFileTemp4557595424669144985.tmp
	16/06/25 23:28:09 INFO util.Utils: Copying /home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/appcache/application_1466866953605_0001/spark-1755b7f0-a414-4e4c-ab0a-ba6eb1ae2e1c/-20723091621466868430534_cache to /home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/appcache/application_1466866953605_0001/container_1466866953605_0001_01_000003/./SparkBWA.jar
	16/06/25 23:28:09 INFO executor.Executor: Adding file:/home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/appcache/application_1466866953605_0001/container_1466866953605_0001_01_000003/./SparkBWA.jar to class loader
	16/06/25 23:28:09 INFO broadcast.TorrentBroadcast: Started reading broadcast variable 2
	16/06/25 23:28:09 INFO storage.MemoryStore: ensureFreeSpace(1289) called with curMem=0, maxMem=2223023063
	16/06/25 23:28:09 INFO storage.MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1289.0 B, free 2.1 GB)
	16/06/25 23:28:09 INFO broadcast.TorrentBroadcast: Reading broadcast variable 2 took 311 ms
	16/06/25 23:28:09 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=1289, maxMem=2223023063
	16/06/25 23:28:09 INFO storage.MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.1 KB, free 2.1 GB)
	16/06/25 23:28:09 INFO rdd.NewHadoopRDD: Input split: hdfs://Master:9000/xubo/alignment/sparkBWA/g38L50c10000Nhs20Paired2.fastq:0+1085189
	16/06/25 23:28:09 INFO broadcast.TorrentBroadcast: Started reading broadcast variable 1
	16/06/25 23:28:09 INFO storage.MemoryStore: ensureFreeSpace(20491) called with curMem=3425, maxMem=2223023063
	16/06/25 23:28:09 INFO storage.MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 20.0 KB, free 2.1 GB)
	16/06/25 23:28:09 INFO broadcast.TorrentBroadcast: Reading broadcast variable 1 took 19 ms
	16/06/25 23:28:09 INFO storage.MemoryStore: ensureFreeSpace(324048) called with curMem=23916, maxMem=2223023063
	16/06/25 23:28:09 INFO storage.MemoryStore: Block broadcast_1 stored as values in memory (estimated size 316.5 KB, free 2.1 GB)
	16/06/25 23:28:10 INFO executor.Executor: Finished task 0.0 in stage 0.0 (TID 0). 2244 bytes result sent to driver
	16/06/25 23:28:13 INFO executor.CoarseGrainedExecutorBackend: Got assigned task 3
	16/06/25 23:28:13 INFO executor.Executor: Running task 0.0 in stage 3.0 (TID 3)
	16/06/25 23:28:13 INFO spark.MapOutputTrackerWorker: Updating epoch to 3 and clearing cache
	16/06/25 23:28:13 INFO broadcast.TorrentBroadcast: Started reading broadcast variable 5
	16/06/25 23:28:13 INFO storage.MemoryStore: ensureFreeSpace(2450) called with curMem=347964, maxMem=2223023063
	16/06/25 23:28:13 INFO storage.MemoryStore: Block broadcast_5_piece0 stored as bytes in memory (estimated size 2.4 KB, free 2.1 GB)
	16/06/25 23:28:13 INFO broadcast.TorrentBroadcast: Reading broadcast variable 5 took 15 ms
	16/06/25 23:28:13 INFO storage.MemoryStore: ensureFreeSpace(4240) called with curMem=350414, maxMem=2223023063
	16/06/25 23:28:13 INFO storage.MemoryStore: Block broadcast_5 stored as values in memory (estimated size 4.1 KB, free 2.1 GB)
	16/06/25 23:28:13 INFO spark.CacheManager: Partition rdd_9_0 not found, computing it
	16/06/25 23:28:13 INFO spark.MapOutputTrackerWorker: Don't have map outputs for shuffle 2, fetching them
	16/06/25 23:28:13 INFO spark.MapOutputTrackerWorker: Doing the fetch; tracker endpoint = AkkaRpcEndpointRef(Actor[akka.tcp://sparkDriver@219.219.220.149:34876/user/MapOutputTracker#612302847])
	16/06/25 23:28:13 INFO spark.MapOutputTrackerWorker: Got the output locations
	16/06/25 23:28:13 INFO storage.ShuffleBlockFetcherIterator: Getting 1 non-empty blocks out of 1 blocks
	16/06/25 23:28:13 INFO storage.ShuffleBlockFetcherIterator: Started 1 remote fetches in 11 ms
	16/06/25 23:28:13 INFO storage.MemoryStore: ensureFreeSpace(752944) called with curMem=354654, maxMem=2223023063
	16/06/25 23:28:13 INFO storage.MemoryStore: Block rdd_9_0 stored as values in memory (estimated size 735.3 KB, free 2.1 GB)
	16/06/25 23:28:13 INFO BwaInterpreter: JMAbuin:: Writing file: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_1
	16/06/25 23:28:13 INFO BwaInterpreter: JMAbuin:: Writing file: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_2
	[Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-application_1466866953605_0001-0.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-application_1466866953605_0001-0.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 2640 sequences (132000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 1078, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 198, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.56, 9.68)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 2640 reads in 0.447 CPU sec, 0.480 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_1 /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD0_2
	[main] Real time: 8.008 sec; CPU: 10.281 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	16/06/25 23:28:22 INFO executor.Executor: Finished task 0.0 in stage 3.0 (TID 3). 1908 bytes result sent to driver
	16/06/25 23:28:22 INFO executor.CoarseGrainedExecutorBackend: Got assigned task 8
	16/06/25 23:28:22 INFO executor.Executor: Running task 5.0 in stage 3.0 (TID 8)
	16/06/25 23:28:22 INFO spark.CacheManager: Partition rdd_9_5 not found, computing it
	16/06/25 23:28:22 INFO storage.ShuffleBlockFetcherIterator: Getting 1 non-empty blocks out of 1 blocks
	16/06/25 23:28:22 INFO storage.ShuffleBlockFetcherIterator: Started 1 remote fetches in 2 ms
	16/06/25 23:28:22 INFO storage.MemoryStore: ensureFreeSpace(754336) called with curMem=1107598, maxMem=2223023063
	16/06/25 23:28:22 INFO storage.MemoryStore: Block rdd_9_5 stored as values in memory (estimated size 736.7 KB, free 2.1 GB)
	16/06/25 23:28:22 INFO BwaInterpreter: JMAbuin:: Writing file: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_1
	16/06/25 23:28:22 INFO BwaInterpreter: JMAbuin:: Writing file: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_2
	[Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-application_1466866953605_0001-5.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-application_1466866953605_0001-5.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 2640 sequences (132000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 1069, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 206)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (164, 234)
	[M::mem_pestat] mean and std.dev: (199.09, 10.15)
	[M::mem_pestat] low and high boundaries for proper pairs: (150, 248)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 2640 reads in 0.570 CPU sec, 0.490 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_1 /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD5_2
	[main] Real time: 0.790 sec; CPU: 12.031 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	16/06/25 23:28:23 INFO executor.Executor: Finished task 5.0 in stage 3.0 (TID 8). 1908 bytes result sent to driver
	16/06/25 23:28:23 INFO executor.CoarseGrainedExecutorBackend: Got assigned task 9
	16/06/25 23:28:23 INFO executor.Executor: Running task 6.0 in stage 3.0 (TID 9)
	16/06/25 23:28:23 INFO spark.CacheManager: Partition rdd_9_6 not found, computing it
	16/06/25 23:28:23 INFO storage.ShuffleBlockFetcherIterator: Getting 1 non-empty blocks out of 1 blocks
	16/06/25 23:28:23 INFO storage.ShuffleBlockFetcherIterator: Started 1 remote fetches in 1 ms
	16/06/25 23:28:23 INFO storage.MemoryStore: ensureFreeSpace(752896) called with curMem=1861934, maxMem=2223023063
	16/06/25 23:28:23 INFO storage.MemoryStore: Block rdd_9_6 stored as values in memory (estimated size 735.3 KB, free 2.1 GB)
	16/06/25 23:28:23 INFO BwaInterpreter: JMAbuin:: Writing file: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_1
	16/06/25 23:28:23 INFO BwaInterpreter: JMAbuin:: Writing file: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_2
	[Java_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_BwaJni_bwa_1jni] Filename parameter -f found 2 '-f'
	[Java_BwaJni_bwa_1jni] Arg 2 '-f'
	[Java_BwaJni_bwa_1jni] Filename found 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-application_1466866953605_0001-6.sam'
	[Java_BwaJni_bwa_1jni] Arg 3 '/home/hadoop/cloud/workspace/tmpSparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-application_1466866953605_0001-6.sam'
	[Java_BwaJni_bwa_1jni] Arg 4 '/home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_1'
	[Java_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_2'
	[Java_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_BwaJni_bwa_1jni] option[1]: mem.
	[Java_BwaJni_bwa_1jni] option[2]: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_BwaJni_bwa_1jni] option[3]: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_1.
	[Java_BwaJni_bwa_1jni] option[4]: /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_2.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 2640 sequences (132000 bp)...
	[M::mem_pestat] # candidate unique pairs for (FF, FR, RF, RR): (0, 1032, 0, 0)
	[M::mem_pestat] skip orientation FF as there are not enough pairs
	[M::mem_pestat] analyzing insert size distribution for orientation FR...
	[M::mem_pestat] (25, 50, 75) percentile: (192, 199, 205)
	[M::mem_pestat] low and high boundaries for computing mean and std.dev: (166, 231)
	[M::mem_pestat] mean and std.dev: (198.42, 10.13)
	[M::mem_pestat] low and high boundaries for proper pairs: (153, 244)
	[M::mem_pestat] skip orientation RF as there are not enough pairs
	[M::mem_pestat] skip orientation RR as there are not enough pairs
	[M::mem_process_seqs] Processed 2640 reads in 0.563 CPU sec, 0.560 real sec
	[main] Version: 0.7.12-r1044
	[main] CMD: bwa mem /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_1 /home/hadoop/cloud/workspace/tmpapplication_1466866953605_0001-RDD6_2
	[main] Real time: 0.754 sec; CPU: 12.901 sec
	[Java_BwaJni_bwa_1jni] Return code from BWA 0.
	16/06/25 23:28:24 INFO executor.Executor: Finished task 6.0 in stage 3.0 (TID 9). 1908 bytes result sent to driver
	16/06/25 23:28:24 INFO executor.CoarseGrainedExecutorBackend: Driver commanded a shutdown
	16/06/25 23:28:24 INFO storage.MemoryStore: MemoryStore cleared
	16/06/25 23:28:24 INFO storage.BlockManager: BlockManager stopped
	16/06/25 23:28:25 INFO remote.RemoteActorRefProvider$RemotingTerminator: Shutting down remote daemon.
	16/06/25 23:28:25 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remote daemon shut down; proceeding with flushing remote transports.
	16/06/25 23:28:25 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remoting shut down.
	16/06/25 23:28:25 INFO util.ShutdownHookManager: Shutdown hook called
	16/06/25 23:28:25 INFO util.ShutdownHookManager: Deleting directory /home/hadoop/cloud/workspace/tmp/nm-local-dir/usercache/hadoop/appcache/application_1466866953605_0001/spark-1755b7f0-a414-4e4c-ab0a-ba6eb1ae2e1c