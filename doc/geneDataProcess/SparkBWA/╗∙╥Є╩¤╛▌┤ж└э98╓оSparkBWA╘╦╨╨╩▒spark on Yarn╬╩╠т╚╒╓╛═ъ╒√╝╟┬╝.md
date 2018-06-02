	
脚本：
	
hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ cat paired.sh 
		
		spark-submit --class SparkBWA \
		--master yarn-client  \
		--conf "spark.executor.extraJavaOptions=-XX:MaxPermSize=1024M" --driver-java-options "-Djava.library.path=." \
		--archives bwa.zip \
		--verbose \
		SparkBWA.jar \
		-algorithm mem -reads paired \
		-index /home/hadoop/xubo/ref/datatest/datatest.fasta \
		/xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest4
	
	
运行记录：
	
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ ./paired.sh 
	Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	Adding default property: spark.master=spark://master:7077
	Adding default property: spark.yarn.executor.memoryOverhead=1704
	Parsed arguments:
	  master                  yarn-client
	  deployMode              null
	  executorMemory          4G
	  executorCores           null
	  totalExecutorCores      null
	  propertiesFile          /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	  driverMemory            2G
	  driverCores             null
	  driverExtraClassPath    null
	  driverExtraLibraryPath  null
	  driverExtraJavaOptions  -Djava.library.path=.
	  supervise               false
	  queue                   null
	  numExecutors            null
	  files                   null
	  pyFiles                 null
	  archives                file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	  mainClass               SparkBWA
	  primaryResource         file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
	  name                    SparkBWA
	  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/ref/datatest/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest4]
	  jars                    null
	  packages                null
	  packagesExclusions      null
	  repositories            null
	  verbose                 true
	
	Spark properties used, including those specified through
	 --conf and those from the properties file /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf:
	  spark.executor.extraJavaOptions -> -XX:MaxPermSize=1024M
	  spark.yarn.executor.memoryOverhead -> 1704
	  spark.driver.extraJavaOptions -> -Djava.library.path=.
	  spark.master -> spark://master:7077
	
	    
	Main class:
	SparkBWA
	Arguments:
	-algorithm
	mem
	-reads
	paired
	-index
	/home/hadoop/xubo/ref/datatest/datatest.fasta
	/xubo/alignment/bwa/datatest.fq
	/xubo/alignment/bwa/datatest.fq
	/xubo/alignment/output/sparkBWA/datatest4
	System properties:
	spark.executor.memory -> 4G
	spark.driver.memory -> 2G
	SPARK_SUBMIT -> true
	spark.executor.extraJavaOptions -> -XX:MaxPermSize=1024M
	spark.app.name -> SparkBWA
	spark.yarn.executor.memoryOverhead -> 1704
	spark.driver.extraJavaOptions -> -Djava.library.path=.
	spark.jars -> file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
	spark.yarn.dist.archives -> file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	spark.submit.deployMode -> client
	spark.master -> yarn-client
	Classpath elements:
	file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
	
	
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: -algorithm
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: mem
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: -reads
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: paired
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: -index
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: /home/hadoop/xubo/ref/datatest/datatest.fasta
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/bwa/datatest.fq
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/bwa/datatest.fq
	16/06/23 15:45:09 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/output/sparkBWA/datatest4
	16/06/23 15:45:09 INFO spark.SparkContext: Running Spark version 1.5.2
	16/06/23 15:45:09 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	16/06/23 15:45:09 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/23 15:45:09 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/23 15:45:09 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/23 15:45:10 INFO slf4j.Slf4jLogger: Slf4jLogger started
	16/06/23 15:45:10 INFO Remoting: Starting remoting
	16/06/23 15:45:10 INFO Remoting: Remoting started; listening on addresses :[akka.tcp://sparkDriver@219.219.220.180:57033]
	16/06/23 15:45:10 INFO util.Utils: Successfully started service 'sparkDriver' on port 57033.
	16/06/23 15:45:11 INFO spark.SparkEnv: Registering MapOutputTracker
	16/06/23 15:45:11 INFO spark.SparkEnv: Registering BlockManagerMaster
	16/06/23 15:45:11 INFO storage.DiskBlockManager: Created local directory at /tmp/blockmgr-66c202ff-09e1-44a6-b4a5-c258d4d3e9a8
	16/06/23 15:45:11 INFO storage.MemoryStore: MemoryStore started with capacity 1060.3 MB
	16/06/23 15:45:11 INFO spark.HttpFileServer: HTTP File server directory is /tmp/spark-f8c6ff03-446a-4cb5-8ebe-914d3f3cefac/httpd-3d72ecc1-7fa1-4a46-9372-fa489a38cf11
	16/06/23 15:45:11 INFO spark.HttpServer: Starting HTTP Server
	16/06/23 15:45:11 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/23 15:45:11 INFO server.AbstractConnector: Started SocketConnector@0.0.0.0:49781
	16/06/23 15:45:11 INFO util.Utils: Successfully started service 'HTTP file server' on port 49781.
	16/06/23 15:45:11 INFO spark.SparkEnv: Registering OutputCommitCoordinator
	16/06/23 15:45:11 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/23 15:45:11 INFO server.AbstractConnector: Started SelectChannelConnector@0.0.0.0:4040
	16/06/23 15:45:11 INFO util.Utils: Successfully started service 'SparkUI' on port 4040.
	16/06/23 15:45:11 INFO ui.SparkUI: Started SparkUI at http://219.219.220.180:4040
	16/06/23 15:45:11 INFO spark.SparkContext: Added JAR file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar at http://219.219.220.180:49781/jars/SparkBWA.jar with timestamp 1466667911695
	16/06/23 15:45:11 WARN metrics.MetricsSystem: Using default name DAGScheduler for source because spark.app.id is not set.
	16/06/23 15:45:11 INFO client.RMProxy: Connecting to ResourceManager at Master/219.219.220.149:8080
	16/06/23 15:45:12 INFO yarn.Client: Requesting a new application from cluster with 6 NodeManagers
	16/06/23 15:45:12 INFO yarn.Client: Verifying our application has not requested more than the maximum memory capability of the cluster (8192 MB per container)
	16/06/23 15:45:12 INFO yarn.Client: Will allocate AM container, with 896 MB memory including 384 MB overhead
	16/06/23 15:45:12 INFO yarn.Client: Setting up container launch context for our AM
	16/06/23 15:45:12 INFO yarn.Client: Setting up the launch environment for our AM container
	16/06/23 15:45:12 INFO yarn.Client: Preparing resources for our AM container
	16/06/23 15:45:12 INFO yarn.Client: Uploading resource file:/home/hadoop/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar -> hdfs://Master:9000/user/hadoop/.sparkStaging/application_1466433907244_0078/spark-assembly-1.5.2-hadoop2.6.0.jar
	16/06/23 15:45:29 INFO yarn.Client: Uploading resource file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip -> hdfs://Master:9000/user/hadoop/.sparkStaging/application_1466433907244_0078/bwa.zip
	16/06/23 15:45:29 INFO yarn.Client: Uploading resource file:/tmp/spark-f8c6ff03-446a-4cb5-8ebe-914d3f3cefac/__spark_conf__6614046580730597232.zip -> hdfs://Master:9000/user/hadoop/.sparkStaging/application_1466433907244_0078/__spark_conf__6614046580730597232.zip
	16/06/23 15:45:29 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/23 15:45:29 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/23 15:45:29 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/23 15:45:29 INFO yarn.Client: Submitting application 78 to ResourceManager
	16/06/23 15:45:29 INFO impl.YarnClientImpl: Submitted application application_1466433907244_0078
	16/06/23 15:45:30 INFO yarn.Client: Application report for application_1466433907244_0078 (state: ACCEPTED)
	16/06/23 15:45:30 INFO yarn.Client: 
		 client token: N/A
		 diagnostics: N/A
		 ApplicationMaster host: N/A
		 ApplicationMaster RPC port: -1
		 queue: default
		 start time: 1466667930343
		 final status: UNDEFINED
		 tracking URL: http://Master:8088/proxy/application_1466433907244_0078/
		 user: hadoop
	16/06/23 15:45:31 INFO yarn.Client: Application report for application_1466433907244_0078 (state: ACCEPTED)
	16/06/23 15:45:32 INFO yarn.Client: Application report for application_1466433907244_0078 (state: ACCEPTED)
	16/06/23 15:45:33 INFO yarn.Client: Application report for application_1466433907244_0078 (state: ACCEPTED)
	16/06/23 15:45:34 INFO yarn.Client: Application report for application_1466433907244_0078 (state: ACCEPTED)
	16/06/23 15:45:35 INFO yarn.Client: Application report for application_1466433907244_0078 (state: ACCEPTED)
	16/06/23 15:45:36 INFO cluster.YarnSchedulerBackend$YarnSchedulerEndpoint: ApplicationMaster registered as AkkaRpcEndpointRef(Actor[akka.tcp://sparkYarnAM@219.219.220.248:57910/user/YarnAM#1129726867])
	16/06/23 15:45:36 INFO cluster.YarnClientSchedulerBackend: Add WebUI Filter. org.apache.hadoop.yarn.server.webproxy.amfilter.AmIpFilter, Map(PROXY_HOSTS -> Mcnode2, PROXY_URI_BASES -> http://Mcnode2:8088/proxy/application_1466433907244_0078), /proxy/application_1466433907244_0078
	16/06/23 15:45:36 INFO ui.JettyUtils: Adding filter: org.apache.hadoop.yarn.server.webproxy.amfilter.AmIpFilter
	16/06/23 15:45:36 INFO yarn.Client: Application report for application_1466433907244_0078 (state: RUNNING)
	16/06/23 15:45:36 INFO yarn.Client: 
		 client token: N/A
		 diagnostics: N/A
		 ApplicationMaster host: 219.219.220.248
		 ApplicationMaster RPC port: 0
		 queue: default
		 start time: 1466667930343
		 final status: UNDEFINED
		 tracking URL: http://Master:8088/proxy/application_1466433907244_0078/
		 user: hadoop
	16/06/23 15:45:36 INFO cluster.YarnClientSchedulerBackend: Application application_1466433907244_0078 has started running.
	16/06/23 15:45:36 INFO util.Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 51093.
	16/06/23 15:45:36 INFO netty.NettyBlockTransferService: Server created on 51093
	16/06/23 15:45:36 INFO storage.BlockManagerMaster: Trying to register BlockManager
	16/06/23 15:45:36 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.180:51093 with 1060.3 MB RAM, BlockManagerId(driver, 219.219.220.180, 51093)
	16/06/23 15:45:36 INFO storage.BlockManagerMaster: Registered BlockManager
	16/06/23 15:45:41 INFO cluster.YarnClientSchedulerBackend: SchedulerBackend is ready for scheduling beginning after waiting maxRegisteredResourcesWaitingTime: 30000(ms)
	16/06/23 15:45:41 INFO BwaInterpreter: JMAbuin:: Starting sorting if desired
	16/06/23 15:45:41 INFO BwaInterpreter: JMAbuin::Not sorting in HDFS. Timing: 392974530380132
	16/06/23 15:45:42 INFO cluster.YarnClientSchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@Mcnode3:60632/user/Executor#1196905479]) with ID 1
	16/06/23 15:45:42 INFO storage.MemoryStore: ensureFreeSpace(237184) called with curMem=0, maxMem=1111794647
	16/06/23 15:45:42 INFO storage.MemoryStore: Block broadcast_0 stored as values in memory (estimated size 231.6 KB, free 1060.1 MB)
	16/06/23 15:45:42 INFO storage.BlockManagerMasterEndpoint: Registering block manager Mcnode3:43344 with 2.1 GB RAM, BlockManagerId(1, Mcnode3, 43344)
	16/06/23 15:45:42 INFO storage.MemoryStore: ensureFreeSpace(20516) called with curMem=237184, maxMem=1111794647
	16/06/23 15:45:42 INFO storage.MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 20.0 KB, free 1060.0 MB)
	16/06/23 15:45:42 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 219.219.220.180:51093 (size: 20.0 KB, free: 1060.3 MB)
	16/06/23 15:45:42 INFO spark.SparkContext: Created broadcast 0 from newAPIHadoopFile at BwaInterpreter.java:221
	16/06/23 15:45:42 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/23 15:45:42 INFO storage.MemoryStore: ensureFreeSpace(236848) called with curMem=257700, maxMem=1111794647
	16/06/23 15:45:42 INFO storage.MemoryStore: Block broadcast_1 stored as values in memory (estimated size 231.3 KB, free 1059.8 MB)
	16/06/23 15:45:42 INFO storage.MemoryStore: ensureFreeSpace(20457) called with curMem=494548, maxMem=1111794647
	16/06/23 15:45:42 INFO storage.MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 20.0 KB, free 1059.8 MB)
	16/06/23 15:45:42 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on 219.219.220.180:51093 (size: 20.0 KB, free: 1060.3 MB)
	16/06/23 15:45:42 INFO spark.SparkContext: Created broadcast 1 from newAPIHadoopFile at BwaInterpreter.java:222
	16/06/23 15:45:42 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/23 15:45:42 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/23 15:45:42 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/23 15:45:42 INFO BwaInterpreter: JMAbuin:: No sort and no partitioning
	16/06/23 15:45:42 INFO rdd.NewHadoopRDD: Removing RDD 0 from persistence list
	16/06/23 15:45:42 INFO storage.BlockManager: Removing RDD 0
	16/06/23 15:45:42 INFO rdd.NewHadoopRDD: Removing RDD 1 from persistence list
	16/06/23 15:45:42 INFO storage.BlockManager: Removing RDD 1
	16/06/23 15:45:42 INFO storage.BlockManager: Removing RDD 0
	16/06/23 15:45:42 INFO spark.ContextCleaner: Cleaned RDD 0
	16/06/23 15:45:42 INFO storage.BlockManager: Removing RDD 1
	16/06/23 15:45:42 INFO spark.ContextCleaner: Cleaned RDD 1
	16/06/23 15:45:42 INFO BwaInterpreter: JMAbuin:: End of sorting. Timing: 392975332080559
	16/06/23 15:45:42 INFO BwaInterpreter: JMAbuin:: Total time: 0.013361673783333333 minutes
	16/06/23 15:45:43 INFO BwaInterpreter: JMAbuin:: Starting BWA
	16/06/23 15:45:43 INFO BwaInterpreter: JMAbuin:: application_1466433907244_0078 - SparkBWA_datatest.fq-0-NoSort
	16/06/23 15:45:43 INFO spark.SparkContext: Starting job: collect at BwaRDD.java:108
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Registering RDD 0 (newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Registering RDD 1 (newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Got job 0 (collect at BwaRDD.java:108) with 1 output partitions
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Final stage: ResultStage 2(collect at BwaRDD.java:108)
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Parents of final stage: List(ShuffleMapStage 0, ShuffleMapStage 1)
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Missing parents: List(ShuffleMapStage 0, ShuffleMapStage 1)
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 0 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221), which has no missing parents
	16/06/23 15:45:43 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=515005, maxMem=1111794647
	16/06/23 15:45:43 INFO storage.MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/23 15:45:43 INFO storage.MemoryStore: ensureFreeSpace(1286) called with curMem=517141, maxMem=1111794647
	16/06/23 15:45:43 INFO storage.MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1286.0 B, free 1059.8 MB)
	16/06/23 15:45:43 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on 219.219.220.180:51093 (size: 1286.0 B, free: 1060.2 MB)
	16/06/23 15:45:43 INFO spark.SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:861
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 0 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/23 15:45:43 INFO cluster.YarnScheduler: Adding task set 0.0 with 1 tasks
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 1 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222), which has no missing parents
	16/06/23 15:45:43 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=518427, maxMem=1111794647
	16/06/23 15:45:43 INFO storage.MemoryStore: Block broadcast_3 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/23 15:45:43 INFO storage.MemoryStore: ensureFreeSpace(1289) called with curMem=520563, maxMem=1111794647
	16/06/23 15:45:43 INFO storage.MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 1289.0 B, free 1059.8 MB)
	16/06/23 15:45:43 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on 219.219.220.180:51093 (size: 1289.0 B, free: 1060.2 MB)
	16/06/23 15:45:43 INFO spark.SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:861
	16/06/23 15:45:43 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 1 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/23 15:45:43 INFO cluster.YarnScheduler: Adding task set 1.0 with 1 tasks
	16/06/23 15:45:43 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, Mcnode3, NODE_LOCAL, 2235 bytes)
	16/06/23 15:45:43 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on Mcnode3:43344 (size: 1286.0 B, free: 2.1 GB)
	16/06/23 15:45:43 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on Mcnode3:43344 (size: 20.0 KB, free: 2.1 GB)
	16/06/23 15:45:44 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 1.0 (TID 1, Mcnode3, NODE_LOCAL, 2235 bytes)
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: ShuffleMapStage 0 (newAPIHadoopFile at BwaInterpreter.java:221) finished in 1.384 s
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: running: Set(ShuffleMapStage 1)
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: waiting: Set(ResultStage 2)
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: failed: Set()
	16/06/23 15:45:44 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 1375 ms on Mcnode3 (1/1)
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: Missing parents for ResultStage 2: List(ShuffleMapStage 1)
	16/06/23 15:45:44 INFO cluster.YarnScheduler: Removed TaskSet 0.0, whose tasks have all completed, from pool 
	16/06/23 15:45:44 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on Mcnode3:43344 (size: 1289.0 B, free: 2.1 GB)
	16/06/23 15:45:44 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on Mcnode3:43344 (size: 20.0 KB, free: 2.1 GB)
	16/06/23 15:45:44 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 1.0 (TID 1) in 165 ms on Mcnode3 (1/1)
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: ShuffleMapStage 1 (newAPIHadoopFile at BwaInterpreter.java:222) finished in 1.504 s
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: running: Set()
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: waiting: Set(ResultStage 2)
	16/06/23 15:45:44 INFO cluster.YarnScheduler: Removed TaskSet 1.0, whose tasks have all completed, from pool 
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: failed: Set()
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: Missing parents for ResultStage 2: List()
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: Submitting ResultStage 2 (MapPartitionsRDD[6] at mapPartitionsWithIndex at BwaRDD.java:108), which is now runnable
	16/06/23 15:45:44 INFO storage.MemoryStore: ensureFreeSpace(4280) called with curMem=521852, maxMem=1111794647
	16/06/23 15:45:44 INFO storage.MemoryStore: Block broadcast_4 stored as values in memory (estimated size 4.2 KB, free 1059.8 MB)
	16/06/23 15:45:44 INFO storage.MemoryStore: ensureFreeSpace(2355) called with curMem=526132, maxMem=1111794647
	16/06/23 15:45:44 INFO storage.MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 2.3 KB, free 1059.8 MB)
	16/06/23 15:45:44 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on 219.219.220.180:51093 (size: 2.3 KB, free: 1060.2 MB)
	16/06/23 15:45:44 INFO spark.SparkContext: Created broadcast 4 from broadcast at DAGScheduler.scala:861
	16/06/23 15:45:44 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ResultStage 2 (MapPartitionsRDD[6] at mapPartitionsWithIndex at BwaRDD.java:108)
	16/06/23 15:45:44 INFO cluster.YarnScheduler: Adding task set 2.0 with 1 tasks
	16/06/23 15:45:44 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 2.0 (TID 2, Mcnode3, PROCESS_LOCAL, 2030 bytes)
	16/06/23 15:45:44 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on Mcnode3:43344 (size: 2.3 KB, free: 2.1 GB)
	16/06/23 15:45:44 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 0 to Mcnode3:60632
	16/06/23 15:45:44 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 0 is 136 bytes
	16/06/23 15:45:44 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 1 to Mcnode3:60632
	16/06/23 15:45:44 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 1 is 136 bytes
	16/06/23 15:45:44 INFO storage.BlockManagerInfo: Added rdd_5_0 in memory on Mcnode3:43344 (size: 1928.0 B, free: 2.1 GB)
	16/06/23 15:45:45 WARN scheduler.TaskSetManager: Lost task 0.0 in stage 2.0 (TID 2, Mcnode3): java.lang.UnsatisfiedLinkError: no bwa in java.library.path
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
	
	16/06/23 15:45:45 INFO scheduler.TaskSetManager: Starting task 0.1 in stage 2.0 (TID 3, Mcnode3, PROCESS_LOCAL, 2030 bytes)
	16/06/23 15:45:45 WARN scheduler.TaskSetManager: Lost task 0.1 in stage 2.0 (TID 3, Mcnode3): java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	
	16/06/23 15:45:45 INFO scheduler.TaskSetManager: Starting task 0.2 in stage 2.0 (TID 4, Mcnode3, PROCESS_LOCAL, 2030 bytes)
	16/06/23 15:45:45 INFO scheduler.TaskSetManager: Lost task 0.2 in stage 2.0 (TID 4) on executor Mcnode3: java.lang.NoClassDefFoundError (Could not initialize class BwaJni) [duplicate 1]
	16/06/23 15:45:45 INFO scheduler.TaskSetManager: Starting task 0.3 in stage 2.0 (TID 5, Mcnode3, PROCESS_LOCAL, 2030 bytes)
	16/06/23 15:45:45 INFO scheduler.TaskSetManager: Lost task 0.3 in stage 2.0 (TID 5) on executor Mcnode3: java.lang.NoClassDefFoundError (Could not initialize class BwaJni) [duplicate 2]
	16/06/23 15:45:45 ERROR scheduler.TaskSetManager: Task 0 in stage 2.0 failed 4 times; aborting job
	16/06/23 15:45:45 INFO cluster.YarnScheduler: Removed TaskSet 2.0, whose tasks have all completed, from pool 
	16/06/23 15:45:45 INFO cluster.YarnScheduler: Cancelling stage 2
	16/06/23 15:45:45 INFO scheduler.DAGScheduler: ResultStage 2 (collect at BwaRDD.java:108) failed in 0.679 s
	16/06/23 15:45:45 INFO scheduler.DAGScheduler: Job 0 failed: collect at BwaRDD.java:108, took 2.305540 s
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 2.0 failed 4 times, most recent failure: Lost task 0.3 in stage 2.0 (TID 5, Mcnode3): java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	16/06/23 15:45:45 INFO spark.SparkContext: Invoking stop() from shutdown hook
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/metrics/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/kill,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/api,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/static,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/json,null}
	16/06/23 15:45:45 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs,null}
	16/06/23 15:45:45 INFO ui.SparkUI: Stopped Spark web UI at http://219.219.220.180:4040
	16/06/23 15:45:45 INFO scheduler.DAGScheduler: Stopping DAGScheduler
	16/06/23 15:45:45 INFO cluster.YarnClientSchedulerBackend: Shutting down all executors
	16/06/23 15:45:45 INFO cluster.YarnClientSchedulerBackend: Interrupting monitor thread
	16/06/23 15:45:45 INFO cluster.YarnClientSchedulerBackend: Asking each executor to shut down
	16/06/23 15:45:45 INFO cluster.YarnClientSchedulerBackend: Stopped
	16/06/23 15:45:45 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
	16/06/23 15:45:45 INFO storage.MemoryStore: MemoryStore cleared
	16/06/23 15:45:45 INFO storage.BlockManager: BlockManager stopped
	16/06/23 15:45:45 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
	16/06/23 15:45:45 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
	16/06/23 15:45:45 INFO remote.RemoteActorRefProvider$RemotingTerminator: Shutting down remote daemon.
	16/06/23 15:45:45 INFO spark.SparkContext: Successfully stopped SparkContext
	16/06/23 15:45:45 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remote daemon shut down; proceeding with flushing remote transports.
	16/06/23 15:45:45 INFO util.ShutdownHookManager: Shutdown hook called
	16/06/23 15:45:45 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-f8c6ff03-446a-4cb5-8ebe-914d3f3cefac
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ ls
	bamlite.o                                          bwamem_extra.o             bwase.o       bwtindex.o      fastmap.o                      ksw.o          QSufSort.o
	bntseq.o                                           bwamem.o                   BwaSeq.class  bwt_lite.o      FastqInputFormat.class         kthread.o      SparkBWA.class
	Bwa.class                                          bwamem_pair.o              bwaseqio.o    bwt.o           FastqInputFormatDouble.class   libbwa.so      SparkBWA.jar
	BwaInterpreter$BigFastq2RDDDouble.class            bwa.o                      bwashm.o      bwtsw2_aux.o    FastqRecordReader.class        main.o         utils.o
	BwaInterpreter$BigFastq2RDDPartitionsDouble.class  BwaOptions.class           bwa.zip       bwtsw2_chain.o  FastqRecordReaderDouble.class  malloc_wrap.o
	BwaInterpreter.class                               bwape.o                    bwtaln.o      bwtsw2_core.o   is.o                           maxk.o
	BwaJni.class                                       BwaRDD$BwaAlignment.class  bwtgap.o      bwtsw2_main.o   kopen.o                        paired.sh
	bwa_jni.o                                          BwaRDD.class               bwt_gen.o     bwtsw2_pair.o   kstring.o                      pemerge.o
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ vi libbwa.so
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ vi bwa_jni.o
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ vi paired.sh 
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ vi paired.sh 
	hadoop@Mcnode1:~/xubo/tools/SparkBWA/build$ ./paired.sh 
	Using properties file: /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	Adding default property: spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	Adding default property: spark.master=spark://master:7077
	Adding default property: spark.yarn.executor.memoryOverhead=1704
	Parsed arguments:
	  master                  yarn-client
	  deployMode              null
	  executorMemory          4G
	  executorCores           null
	  totalExecutorCores      null
	  propertiesFile          /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf
	  driverMemory            2G
	  driverCores             null
	  driverExtraClassPath    null
	  driverExtraLibraryPath  null
	  driverExtraJavaOptions  -Djava.library.path=.
	  supervise               false
	  queue                   null
	  numExecutors            null
	  files                   null
	  pyFiles                 null
	  archives                file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	  mainClass               SparkBWA
	  primaryResource         file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
	  name                    SparkBWA
	  childArgs               [-algorithm mem -reads paired -index /home/hadoop/xubo/ref/datatest/datatest.fasta /xubo/alignment/bwa/datatest.fq /xubo/alignment/bwa/datatest.fq /xubo/alignment/output/sparkBWA/datatest4]
	  jars                    null
	  packages                null
	  packagesExclusions      null
	  repositories            null
	  verbose                 true
	
	Spark properties used, including those specified through
	 --conf and those from the properties file /home/hadoop/cloud/spark-1.5.2/conf/spark-defaults.conf:
	  spark.executor.extraJavaOptions -> -XX:MaxPermSize=1024M
	  spark.yarn.executor.memoryOverhead -> 1704
	  spark.driver.extraJavaOptions -> -Djava.library.path=.
	  spark.master -> spark://master:7077
	
	    
	Main class:
	SparkBWA
	Arguments:
	-algorithm
	mem
	-reads
	paired
	-index
	/home/hadoop/xubo/ref/datatest/datatest.fasta
	/xubo/alignment/bwa/datatest.fq
	/xubo/alignment/bwa/datatest.fq
	/xubo/alignment/output/sparkBWA/datatest4
	System properties:
	spark.executor.memory -> 4G
	spark.driver.memory -> 2G
	SPARK_SUBMIT -> true
	spark.executor.extraJavaOptions -> -XX:MaxPermSize=1024M
	spark.app.name -> SparkBWA
	spark.yarn.executor.memoryOverhead -> 1704
	spark.driver.extraJavaOptions -> -Djava.library.path=.
	spark.jars -> file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
	spark.yarn.dist.archives -> file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip
	spark.submit.deployMode -> client
	spark.master -> yarn-client
	Classpath elements:
	file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar
	
	
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: -algorithm
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: mem
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: -reads
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: paired
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: -index
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: /home/hadoop/xubo/ref/datatest/datatest.fasta
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/bwa/datatest.fq
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/bwa/datatest.fq
	16/06/23 16:30:40 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/output/sparkBWA/datatest4
	16/06/23 16:30:40 INFO spark.SparkContext: Running Spark version 1.5.2
	16/06/23 16:30:41 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	16/06/23 16:30:41 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/23 16:30:41 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/23 16:30:41 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/23 16:30:42 INFO slf4j.Slf4jLogger: Slf4jLogger started
	16/06/23 16:30:42 INFO Remoting: Starting remoting
	16/06/23 16:30:42 INFO Remoting: Remoting started; listening on addresses :[akka.tcp://sparkDriver@219.219.220.180:56547]
	16/06/23 16:30:42 INFO util.Utils: Successfully started service 'sparkDriver' on port 56547.
	16/06/23 16:30:42 INFO spark.SparkEnv: Registering MapOutputTracker
	16/06/23 16:30:42 INFO spark.SparkEnv: Registering BlockManagerMaster
	16/06/23 16:30:42 INFO storage.DiskBlockManager: Created local directory at /tmp/blockmgr-fc2493e0-58fe-4482-bbf0-2a3aece7c728
	16/06/23 16:30:42 INFO storage.MemoryStore: MemoryStore started with capacity 1060.3 MB
	16/06/23 16:30:42 INFO spark.HttpFileServer: HTTP File server directory is /tmp/spark-31b96b18-7351-4bdf-8a1b-6e05925b9ed8/httpd-9b39b974-fe10-4c78-894f-448f935ff7cd
	16/06/23 16:30:42 INFO spark.HttpServer: Starting HTTP Server
	16/06/23 16:30:42 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/23 16:30:42 INFO server.AbstractConnector: Started SocketConnector@0.0.0.0:44143
	16/06/23 16:30:42 INFO util.Utils: Successfully started service 'HTTP file server' on port 44143.
	16/06/23 16:30:42 INFO spark.SparkEnv: Registering OutputCommitCoordinator
	16/06/23 16:30:43 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/23 16:30:43 INFO server.AbstractConnector: Started SelectChannelConnector@0.0.0.0:4040
	16/06/23 16:30:43 INFO util.Utils: Successfully started service 'SparkUI' on port 4040.
	16/06/23 16:30:43 INFO ui.SparkUI: Started SparkUI at http://219.219.220.180:4040
	16/06/23 16:30:43 INFO spark.SparkContext: Added JAR file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar at http://219.219.220.180:44143/jars/SparkBWA.jar with timestamp 1466670643147
	16/06/23 16:30:43 WARN metrics.MetricsSystem: Using default name DAGScheduler for source because spark.app.id is not set.
	16/06/23 16:30:43 INFO client.RMProxy: Connecting to ResourceManager at Master/219.219.220.149:8080
	16/06/23 16:30:43 INFO yarn.Client: Requesting a new application from cluster with 6 NodeManagers
	16/06/23 16:30:43 INFO yarn.Client: Verifying our application has not requested more than the maximum memory capability of the cluster (8192 MB per container)
	16/06/23 16:30:43 INFO yarn.Client: Will allocate AM container, with 896 MB memory including 384 MB overhead
	16/06/23 16:30:43 INFO yarn.Client: Setting up container launch context for our AM
	16/06/23 16:30:43 INFO yarn.Client: Setting up the launch environment for our AM container
	16/06/23 16:30:43 INFO yarn.Client: Preparing resources for our AM container
	16/06/23 16:30:44 INFO yarn.Client: Uploading resource file:/home/hadoop/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar -> hdfs://Master:9000/user/hadoop/.sparkStaging/application_1466433907244_0084/spark-assembly-1.5.2-hadoop2.6.0.jar
	16/06/23 16:30:59 INFO yarn.Client: Uploading resource file:/home/hadoop/xubo/tools/SparkBWA/build/bwa.zip -> hdfs://Master:9000/user/hadoop/.sparkStaging/application_1466433907244_0084/bwa.zip
	16/06/23 16:30:59 INFO yarn.Client: Uploading resource file:/tmp/spark-31b96b18-7351-4bdf-8a1b-6e05925b9ed8/__spark_conf__4773742016560488016.zip -> hdfs://Master:9000/user/hadoop/.sparkStaging/application_1466433907244_0084/__spark_conf__4773742016560488016.zip
	16/06/23 16:30:59 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/23 16:30:59 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/23 16:30:59 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/23 16:30:59 INFO yarn.Client: Submitting application 84 to ResourceManager
	16/06/23 16:30:59 INFO impl.YarnClientImpl: Submitted application application_1466433907244_0084
	16/06/23 16:31:00 INFO yarn.Client: Application report for application_1466433907244_0084 (state: ACCEPTED)
	16/06/23 16:31:00 INFO yarn.Client: 
		 client token: N/A
		 diagnostics: N/A
		 ApplicationMaster host: N/A
		 ApplicationMaster RPC port: -1
		 queue: default
		 start time: 1466670660322
		 final status: UNDEFINED
		 tracking URL: http://Master:8088/proxy/application_1466433907244_0084/
		 user: hadoop
	16/06/23 16:31:01 INFO yarn.Client: Application report for application_1466433907244_0084 (state: ACCEPTED)
	16/06/23 16:31:02 INFO yarn.Client: Application report for application_1466433907244_0084 (state: ACCEPTED)
	16/06/23 16:31:03 INFO yarn.Client: Application report for application_1466433907244_0084 (state: ACCEPTED)
	16/06/23 16:31:04 INFO yarn.Client: Application report for application_1466433907244_0084 (state: ACCEPTED)
	16/06/23 16:31:05 INFO cluster.YarnSchedulerBackend$YarnSchedulerEndpoint: ApplicationMaster registered as AkkaRpcEndpointRef(Actor[akka.tcp://sparkYarnAM@219.219.220.233:52600/user/YarnAM#-269038267])
	16/06/23 16:31:05 INFO cluster.YarnClientSchedulerBackend: Add WebUI Filter. org.apache.hadoop.yarn.server.webproxy.amfilter.AmIpFilter, Map(PROXY_HOSTS -> Mcnode4, PROXY_URI_BASES -> http://Mcnode4:8088/proxy/application_1466433907244_0084), /proxy/application_1466433907244_0084
	16/06/23 16:31:05 INFO ui.JettyUtils: Adding filter: org.apache.hadoop.yarn.server.webproxy.amfilter.AmIpFilter
	16/06/23 16:31:05 INFO yarn.Client: Application report for application_1466433907244_0084 (state: RUNNING)
	16/06/23 16:31:05 INFO yarn.Client: 
		 client token: N/A
		 diagnostics: N/A
		 ApplicationMaster host: 219.219.220.233
		 ApplicationMaster RPC port: 0
		 queue: default
		 start time: 1466670660322
		 final status: UNDEFINED
		 tracking URL: http://Master:8088/proxy/application_1466433907244_0084/
		 user: hadoop
	16/06/23 16:31:05 INFO cluster.YarnClientSchedulerBackend: Application application_1466433907244_0084 has started running.
	16/06/23 16:31:05 INFO util.Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 54019.
	16/06/23 16:31:05 INFO netty.NettyBlockTransferService: Server created on 54019
	16/06/23 16:31:05 INFO storage.BlockManagerMaster: Trying to register BlockManager
	16/06/23 16:31:05 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.180:54019 with 1060.3 MB RAM, BlockManagerId(driver, 219.219.220.180, 54019)
	16/06/23 16:31:05 INFO storage.BlockManagerMaster: Registered BlockManager
	16/06/23 16:31:09 INFO cluster.YarnClientSchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@Mcnode4:54790/user/Executor#847839644]) with ID 1
	16/06/23 16:31:09 INFO storage.BlockManagerMasterEndpoint: Registering block manager Mcnode4:49158 with 2.1 GB RAM, BlockManagerId(1, Mcnode4, 49158)
	16/06/23 16:31:13 INFO cluster.YarnClientSchedulerBackend: SchedulerBackend is ready for scheduling beginning after waiting maxRegisteredResourcesWaitingTime: 30000(ms)
	16/06/23 16:31:13 INFO BwaInterpreter: JMAbuin:: Starting sorting if desired
	16/06/23 16:31:13 INFO BwaInterpreter: JMAbuin::Not sorting in HDFS. Timing: 395706001182397
	16/06/23 16:31:13 INFO storage.MemoryStore: ensureFreeSpace(237184) called with curMem=0, maxMem=1111794647
	16/06/23 16:31:13 INFO storage.MemoryStore: Block broadcast_0 stored as values in memory (estimated size 231.6 KB, free 1060.1 MB)
	16/06/23 16:31:13 INFO storage.MemoryStore: ensureFreeSpace(20516) called with curMem=237184, maxMem=1111794647
	16/06/23 16:31:13 INFO storage.MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 20.0 KB, free 1060.0 MB)
	16/06/23 16:31:13 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 219.219.220.180:54019 (size: 20.0 KB, free: 1060.3 MB)
	16/06/23 16:31:13 INFO spark.SparkContext: Created broadcast 0 from newAPIHadoopFile at BwaInterpreter.java:221
	16/06/23 16:31:13 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/23 16:31:13 INFO storage.MemoryStore: ensureFreeSpace(236848) called with curMem=257700, maxMem=1111794647
	16/06/23 16:31:13 INFO storage.MemoryStore: Block broadcast_1 stored as values in memory (estimated size 231.3 KB, free 1059.8 MB)
	16/06/23 16:31:14 INFO storage.MemoryStore: ensureFreeSpace(20457) called with curMem=494548, maxMem=1111794647
	16/06/23 16:31:14 INFO storage.MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 20.0 KB, free 1059.8 MB)
	16/06/23 16:31:14 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on 219.219.220.180:54019 (size: 20.0 KB, free: 1060.3 MB)
	16/06/23 16:31:14 INFO spark.SparkContext: Created broadcast 1 from newAPIHadoopFile at BwaInterpreter.java:222
	16/06/23 16:31:14 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/23 16:31:14 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/23 16:31:14 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/23 16:31:14 INFO BwaInterpreter: JMAbuin:: No sort and no partitioning
	16/06/23 16:31:14 INFO rdd.NewHadoopRDD: Removing RDD 0 from persistence list
	16/06/23 16:31:14 INFO storage.BlockManager: Removing RDD 0
	16/06/23 16:31:14 INFO rdd.NewHadoopRDD: Removing RDD 1 from persistence list
	16/06/23 16:31:14 INFO storage.BlockManager: Removing RDD 1
	16/06/23 16:31:14 INFO storage.BlockManager: Removing RDD 0
	16/06/23 16:31:14 INFO spark.ContextCleaner: Cleaned RDD 0
	16/06/23 16:31:14 INFO storage.BlockManager: Removing RDD 1
	16/06/23 16:31:14 INFO spark.ContextCleaner: Cleaned RDD 1
	16/06/23 16:31:14 INFO BwaInterpreter: JMAbuin:: End of sorting. Timing: 395706853769978
	16/06/23 16:31:14 INFO BwaInterpreter: JMAbuin:: Total time: 0.014209793016666666 minutes
	16/06/23 16:31:14 INFO BwaInterpreter: JMAbuin:: Starting BWA
	16/06/23 16:31:14 INFO BwaInterpreter: JMAbuin:: application_1466433907244_0084 - SparkBWA_datatest.fq-0-NoSort
	16/06/23 16:31:14 INFO spark.SparkContext: Starting job: collect at BwaRDD.java:108
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Registering RDD 0 (newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Registering RDD 1 (newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Got job 0 (collect at BwaRDD.java:108) with 1 output partitions
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Final stage: ResultStage 2(collect at BwaRDD.java:108)
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Parents of final stage: List(ShuffleMapStage 0, ShuffleMapStage 1)
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Missing parents: List(ShuffleMapStage 0, ShuffleMapStage 1)
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 0 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221), which has no missing parents
	16/06/23 16:31:14 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=515005, maxMem=1111794647
	16/06/23 16:31:14 INFO storage.MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/23 16:31:14 INFO storage.MemoryStore: ensureFreeSpace(1286) called with curMem=517141, maxMem=1111794647
	16/06/23 16:31:14 INFO storage.MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1286.0 B, free 1059.8 MB)
	16/06/23 16:31:14 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on 219.219.220.180:54019 (size: 1286.0 B, free: 1060.2 MB)
	16/06/23 16:31:14 INFO spark.SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:861
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 0 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/23 16:31:14 INFO cluster.YarnScheduler: Adding task set 0.0 with 1 tasks
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 1 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222), which has no missing parents
	16/06/23 16:31:14 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=518427, maxMem=1111794647
	16/06/23 16:31:14 INFO storage.MemoryStore: Block broadcast_3 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/23 16:31:14 INFO storage.MemoryStore: ensureFreeSpace(1289) called with curMem=520563, maxMem=1111794647
	16/06/23 16:31:14 INFO storage.MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 1289.0 B, free 1059.8 MB)
	16/06/23 16:31:14 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on 219.219.220.180:54019 (size: 1289.0 B, free: 1060.2 MB)
	16/06/23 16:31:14 INFO spark.SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:861
	16/06/23 16:31:14 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 1 (/xubo/alignment/bwa/datatest.fq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/23 16:31:14 INFO cluster.YarnScheduler: Adding task set 1.0 with 1 tasks
	16/06/23 16:31:14 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, Mcnode4, NODE_LOCAL, 2235 bytes)
	16/06/23 16:31:15 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on Mcnode4:49158 (size: 1286.0 B, free: 2.1 GB)
	16/06/23 16:31:15 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on Mcnode4:49158 (size: 20.0 KB, free: 2.1 GB)
	16/06/23 16:31:16 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 1.0 (TID 1, Mcnode4, NODE_LOCAL, 2235 bytes)
	16/06/23 16:31:16 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 1683 ms on Mcnode4 (1/1)
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: ShuffleMapStage 0 (newAPIHadoopFile at BwaInterpreter.java:221) finished in 1.691 s
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: running: Set(ShuffleMapStage 1)
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: waiting: Set(ResultStage 2)
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: failed: Set()
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: Missing parents for ResultStage 2: List(ShuffleMapStage 1)
	16/06/23 16:31:16 INFO cluster.YarnScheduler: Removed TaskSet 0.0, whose tasks have all completed, from pool 
	16/06/23 16:31:16 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on Mcnode4:49158 (size: 1289.0 B, free: 2.1 GB)
	16/06/23 16:31:16 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on Mcnode4:49158 (size: 20.0 KB, free: 2.1 GB)
	16/06/23 16:31:16 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 1.0 (TID 1) in 304 ms on Mcnode4 (1/1)
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: ShuffleMapStage 1 (newAPIHadoopFile at BwaInterpreter.java:222) finished in 1.948 s
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: running: Set()
	16/06/23 16:31:16 INFO cluster.YarnScheduler: Removed TaskSet 1.0, whose tasks have all completed, from pool 
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: waiting: Set(ResultStage 2)
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: failed: Set()
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: Missing parents for ResultStage 2: List()
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: Submitting ResultStage 2 (MapPartitionsRDD[6] at mapPartitionsWithIndex at BwaRDD.java:108), which is now runnable
	16/06/23 16:31:16 INFO storage.MemoryStore: ensureFreeSpace(4280) called with curMem=521852, maxMem=1111794647
	16/06/23 16:31:16 INFO storage.MemoryStore: Block broadcast_4 stored as values in memory (estimated size 4.2 KB, free 1059.8 MB)
	16/06/23 16:31:16 INFO storage.MemoryStore: ensureFreeSpace(2355) called with curMem=526132, maxMem=1111794647
	16/06/23 16:31:16 INFO storage.MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 2.3 KB, free 1059.8 MB)
	16/06/23 16:31:16 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on 219.219.220.180:54019 (size: 2.3 KB, free: 1060.2 MB)
	16/06/23 16:31:16 INFO spark.SparkContext: Created broadcast 4 from broadcast at DAGScheduler.scala:861
	16/06/23 16:31:16 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ResultStage 2 (MapPartitionsRDD[6] at mapPartitionsWithIndex at BwaRDD.java:108)
	16/06/23 16:31:16 INFO cluster.YarnScheduler: Adding task set 2.0 with 1 tasks
	16/06/23 16:31:16 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 2.0 (TID 2, Mcnode4, PROCESS_LOCAL, 2030 bytes)
	16/06/23 16:31:16 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on Mcnode4:49158 (size: 2.3 KB, free: 2.1 GB)
	16/06/23 16:31:16 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 0 to Mcnode4:54790
	16/06/23 16:31:16 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 0 is 136 bytes
	16/06/23 16:31:16 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 1 to Mcnode4:54790
	16/06/23 16:31:16 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 1 is 136 bytes
	16/06/23 16:31:16 INFO storage.BlockManagerInfo: Added rdd_5_0 in memory on Mcnode4:49158 (size: 1928.0 B, free: 2.1 GB)
	16/06/23 16:31:17 WARN scheduler.TaskSetManager: Lost task 0.0 in stage 2.0 (TID 2, Mcnode4): java.lang.UnsatisfiedLinkError: no bwa in java.library.path
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
	
	16/06/23 16:31:17 INFO scheduler.TaskSetManager: Starting task 0.1 in stage 2.0 (TID 3, Mcnode4, PROCESS_LOCAL, 2030 bytes)
	16/06/23 16:31:17 WARN scheduler.TaskSetManager: Lost task 0.1 in stage 2.0 (TID 3, Mcnode4): java.lang.NoClassDefFoundError: Could not initialize class BwaJni
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
	
	16/06/23 16:31:17 INFO scheduler.TaskSetManager: Starting task 0.2 in stage 2.0 (TID 4, Mcnode4, PROCESS_LOCAL, 2030 bytes)
	16/06/23 16:31:17 INFO scheduler.TaskSetManager: Lost task 0.2 in stage 2.0 (TID 4) on executor Mcnode4: java.lang.NoClassDefFoundError (Could not initialize class BwaJni) [duplicate 1]
	16/06/23 16:31:17 INFO scheduler.TaskSetManager: Starting task 0.3 in stage 2.0 (TID 5, Mcnode4, PROCESS_LOCAL, 2030 bytes)
	16/06/23 16:31:17 ERROR cluster.YarnScheduler: Lost executor 1 on Mcnode4: remote Rpc client disassociated
	16/06/23 16:31:17 WARN remote.ReliableDeliverySupervisor: Association with remote system [akka.tcp://sparkExecutor@Mcnode4:54790] has failed, address is now gated for [5000] ms. Reason: [Disassociated] 
	16/06/23 16:31:17 INFO scheduler.TaskSetManager: Re-queueing tasks for 1 from TaskSet 2.0
	16/06/23 16:31:17 WARN scheduler.TaskSetManager: Lost task 0.3 in stage 2.0 (TID 5, Mcnode4): ExecutorLostFailure (executor 1 lost)
	16/06/23 16:31:17 ERROR scheduler.TaskSetManager: Task 0 in stage 2.0 failed 4 times; aborting job
	16/06/23 16:31:17 INFO cluster.YarnScheduler: Removed TaskSet 2.0, whose tasks have all completed, from pool 
	16/06/23 16:31:17 INFO cluster.YarnScheduler: Cancelling stage 2
	16/06/23 16:31:17 INFO scheduler.DAGScheduler: ResultStage 2 (collect at BwaRDD.java:108) failed in 0.756 s
	16/06/23 16:31:17 INFO scheduler.DAGScheduler: Job 0 failed: collect at BwaRDD.java:108, took 2.832610 s
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 2.0 failed 4 times, most recent failure: Lost task 0.3 in stage 2.0 (TID 5, Mcnode4): ExecutorLostFailure (executor 1 lost)
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
	16/06/23 16:31:17 INFO spark.SparkContext: Invoking stop() from shutdown hook
	16/06/23 16:31:17 INFO scheduler.DAGScheduler: Executor lost: 1 (epoch 2)
	16/06/23 16:31:17 INFO storage.BlockManagerMasterEndpoint: Trying to remove executor 1 from BlockManagerMaster.
	16/06/23 16:31:17 INFO storage.BlockManagerMasterEndpoint: Removing block manager BlockManagerId(1, Mcnode4, 49158)
	16/06/23 16:31:17 INFO storage.BlockManagerMaster: Removed 1 successfully in removeExecutor
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/metrics/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/kill,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/api,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/static,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/json,null}
	16/06/23 16:31:17 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs,null}
	16/06/23 16:31:17 INFO ui.SparkUI: Stopped Spark web UI at http://219.219.220.180:4040
	16/06/23 16:31:17 INFO scheduler.DAGScheduler: Stopping DAGScheduler
	16/06/23 16:31:17 INFO cluster.YarnClientSchedulerBackend: Shutting down all executors
	16/06/23 16:31:17 INFO cluster.YarnClientSchedulerBackend: Interrupting monitor thread
	16/06/23 16:31:17 INFO cluster.YarnClientSchedulerBackend: Asking each executor to shut down
	16/06/23 16:31:17 INFO cluster.YarnClientSchedulerBackend: Stopped
	16/06/23 16:31:17 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
	16/06/23 16:31:17 INFO storage.MemoryStore: MemoryStore cleared
	16/06/23 16:31:17 INFO storage.BlockManager: BlockManager stopped
	16/06/23 16:31:17 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
	16/06/23 16:31:17 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
	16/06/23 16:31:17 INFO spark.SparkContext: Successfully stopped SparkContext
	16/06/23 16:31:17 INFO util.ShutdownHookManager: Shutdown hook called
	16/06/23 16:31:17 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-31b96b18-7351-4bdf-8a1b-6e05925b9ed8
	16/06/23 16:31:17 INFO remote.RemoteActorRefProvider$RemotingTerminator: Shutting down remote daemon.
