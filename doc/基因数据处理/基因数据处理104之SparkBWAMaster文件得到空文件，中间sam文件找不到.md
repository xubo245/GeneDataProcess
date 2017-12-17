	
	
脚本1：
	
	spark-submit --class SparkBWA \
	--master  spark://219.219.220.149:7077 \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	--driver-java-options "-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-r \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 3 \
	/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6
	
运行结果1：

	hadoop@Mcnode6:~/xubo/tools/SparkBWA/build$ ./pairedGRCH38L1Master.sh 
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: -r
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: -algorithm
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: mem
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: -reads
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: paired
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: -index
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: -partitions
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: 3
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq
	16/06/24 21:59:41 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6
	16/06/24 21:59:41 INFO spark.SparkContext: Running Spark version 1.5.2
	16/06/24 21:59:42 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	16/06/24 21:59:42 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/24 21:59:42 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/24 21:59:42 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/24 21:59:43 INFO slf4j.Slf4jLogger: Slf4jLogger started
	16/06/24 21:59:43 INFO Remoting: Starting remoting
	16/06/24 21:59:43 INFO Remoting: Remoting started; listening on addresses :[akka.tcp://sparkDriver@219.219.220.223:36912]
	16/06/24 21:59:43 INFO util.Utils: Successfully started service 'sparkDriver' on port 36912.
	16/06/24 21:59:43 INFO spark.SparkEnv: Registering MapOutputTracker
	16/06/24 21:59:43 INFO spark.SparkEnv: Registering BlockManagerMaster
	16/06/24 21:59:43 INFO storage.DiskBlockManager: Created local directory at /tmp/blockmgr-eedfa9ee-25ac-41f6-ada9-c6e085203b43
	16/06/24 21:59:43 INFO storage.MemoryStore: MemoryStore started with capacity 1060.3 MB
	16/06/24 21:59:43 INFO spark.HttpFileServer: HTTP File server directory is /tmp/spark-c8e2a5c3-da2c-47ec-affa-b992c1a4dcf9/httpd-ce0a1a0c-bb17-468b-b0d6-f8a450f03fda
	16/06/24 21:59:43 INFO spark.HttpServer: Starting HTTP Server
	16/06/24 21:59:43 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/24 21:59:43 INFO server.AbstractConnector: Started SocketConnector@0.0.0.0:44366
	16/06/24 21:59:43 INFO util.Utils: Successfully started service 'HTTP file server' on port 44366.
	16/06/24 21:59:43 INFO spark.SparkEnv: Registering OutputCommitCoordinator
	16/06/24 21:59:43 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/24 21:59:43 INFO server.AbstractConnector: Started SelectChannelConnector@0.0.0.0:4040
	16/06/24 21:59:43 INFO util.Utils: Successfully started service 'SparkUI' on port 4040.
	16/06/24 21:59:43 INFO ui.SparkUI: Started SparkUI at http://219.219.220.223:4040
	16/06/24 21:59:44 INFO spark.SparkContext: Added JAR file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar at http://219.219.220.223:44366/jars/SparkBWA.jar with timestamp 1466776784037
	16/06/24 21:59:44 WARN metrics.MetricsSystem: Using default name DAGScheduler for source because spark.app.id is not set.
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Connecting to master spark://219.219.220.149:7077...
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Connected to Spark cluster with app ID app-20160624215947-0113
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/0 on worker-20160620224519-219.219.220.215-54719 (219.219.220.215:54719) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/0 on hostPort 219.219.220.215:54719 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/1 on worker-20160620224514-219.219.220.248-40879 (219.219.220.248:40879) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/1 on hostPort 219.219.220.248:40879 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/2 on worker-20160620224513-219.219.220.149-33714 (219.219.220.149:33714) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/2 on hostPort 219.219.220.149:33714 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/3 on worker-20160620224514-219.219.220.131-52525 (219.219.220.131:52525) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/3 on hostPort 219.219.220.131:52525 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/4 on worker-20160620224513-219.219.220.223-37164 (219.219.220.223:37164) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/4 on hostPort 219.219.220.223:37164 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/5 on worker-20160620224513-219.219.220.180-51937 (219.219.220.180:51937) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/5 on hostPort 219.219.220.180:51937 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215947-0113/6 on worker-20160620224512-219.219.220.233-33505 (219.219.220.233:33505) with 2 cores
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215947-0113/6 on hostPort 219.219.220.233:33505 with 2 cores, 4.0 GB RAM
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/3 is now LOADING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/4 is now LOADING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/1 is now LOADING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/6 is now LOADING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/5 is now LOADING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/0 is now RUNNING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/1 is now RUNNING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/2 is now RUNNING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/3 is now RUNNING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/0 is now LOADING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/4 is now RUNNING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/5 is now RUNNING
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/6 is now RUNNING
	16/06/24 21:59:44 INFO util.Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 34509.
	16/06/24 21:59:44 INFO netty.NettyBlockTransferService: Server created on 34509
	16/06/24 21:59:44 INFO storage.BlockManagerMaster: Trying to register BlockManager
	16/06/24 21:59:44 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.223:34509 with 1060.3 MB RAM, BlockManagerId(driver, 219.219.220.223, 34509)
	16/06/24 21:59:44 INFO storage.BlockManagerMaster: Registered BlockManager
	16/06/24 21:59:44 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215947-0113/2 is now LOADING
	16/06/24 21:59:44 INFO cluster.SparkDeploySchedulerBackend: SchedulerBackend is ready for scheduling beginning after reached minRegisteredResourcesRatio: 0.0
	16/06/24 21:59:46 INFO BwaInterpreter: JMAbuin:: Starting sorting if desired
	16/06/24 21:59:46 INFO BwaInterpreter: JMAbuin::Not sorting in HDFS. Timing: 501993907543717
	16/06/24 21:59:47 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.131:50628/user/Executor#-2094608193]) with ID 3
	16/06/24 21:59:47 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.180:53082/user/Executor#-367781461]) with ID 5
	16/06/24 21:59:47 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.233:57042/user/Executor#-681590259]) with ID 6
	16/06/24 21:59:47 INFO storage.MemoryStore: ensureFreeSpace(237240) called with curMem=0, maxMem=1111794647
	16/06/24 21:59:47 INFO storage.MemoryStore: Block broadcast_0 stored as values in memory (estimated size 231.7 KB, free 1060.1 MB)
	16/06/24 21:59:47 INFO storage.MemoryStore: ensureFreeSpace(20558) called with curMem=237240, maxMem=1111794647
	16/06/24 21:59:47 INFO storage.MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 20.1 KB, free 1060.0 MB)
	16/06/24 21:59:47 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 219.219.220.223:34509 (size: 20.1 KB, free: 1060.3 MB)
	16/06/24 21:59:47 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.131:60373 with 2.1 GB RAM, BlockManagerId(3, 219.219.220.131, 60373)
	16/06/24 21:59:47 INFO spark.SparkContext: Created broadcast 0 from newAPIHadoopFile at BwaInterpreter.java:221
	16/06/24 21:59:47 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.248:34450/user/Executor#-1807774933]) with ID 1
	16/06/24 21:59:47 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/24 21:59:47 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.180:52738 with 2.1 GB RAM, BlockManagerId(5, 219.219.220.180, 52738)
	16/06/24 21:59:47 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.233:60363 with 2.1 GB RAM, BlockManagerId(6, 219.219.220.233, 60363)
	16/06/24 21:59:47 INFO storage.MemoryStore: ensureFreeSpace(237240) called with curMem=257798, maxMem=1111794647
	16/06/24 21:59:47 INFO storage.MemoryStore: Block broadcast_1 stored as values in memory (estimated size 231.7 KB, free 1059.8 MB)
	16/06/24 21:59:47 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.248:57238 with 2.1 GB RAM, BlockManagerId(1, 219.219.220.248, 57238)
	16/06/24 21:59:47 INFO storage.MemoryStore: ensureFreeSpace(20558) called with curMem=495038, maxMem=1111794647
	16/06/24 21:59:47 INFO storage.MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 20.1 KB, free 1059.8 MB)
	16/06/24 21:59:47 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on 219.219.220.223:34509 (size: 20.1 KB, free: 1060.3 MB)
	16/06/24 21:59:47 INFO spark.SparkContext: Created broadcast 1 from newAPIHadoopFile at BwaInterpreter.java:222
	16/06/24 21:59:47 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/24 21:59:47 INFO BwaInterpreter: JMAbuin:: No sort with partitioning
	16/06/24 21:59:47 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/24 21:59:47 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/24 21:59:47 INFO BwaInterpreter: JMAbuin:: Repartition with no sort
	16/06/24 21:59:47 INFO rdd.MapPartitionsRDD: Removing RDD 4 from persistence list
	16/06/24 21:59:47 INFO storage.BlockManager: Removing RDD 4
	16/06/24 21:59:47 INFO rdd.NewHadoopRDD: Removing RDD 0 from persistence list
	16/06/24 21:59:47 INFO storage.BlockManager: Removing RDD 0
	16/06/24 21:59:47 INFO rdd.NewHadoopRDD: Removing RDD 1 from persistence list
	16/06/24 21:59:47 INFO storage.BlockManager: Removing RDD 1
	16/06/24 21:59:47 INFO storage.BlockManager: Removing RDD 0
	16/06/24 21:59:47 INFO spark.ContextCleaner: Cleaned RDD 0
	16/06/24 21:59:47 INFO storage.BlockManager: Removing RDD 1
	16/06/24 21:59:47 INFO spark.ContextCleaner: Cleaned RDD 1
	16/06/24 21:59:47 INFO BwaInterpreter: JMAbuin:: End of sorting. Timing: 501995469185292
	16/06/24 21:59:47 INFO BwaInterpreter: JMAbuin:: Total time: 0.026027359583333333 minutes
	16/06/24 21:59:48 INFO BwaInterpreter: JMAbuin:: Starting BWA
	16/06/24 21:59:48 INFO BwaInterpreter: JMAbuin:: app-20160624215947-0113 - SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort
	16/06/24 21:59:48 INFO spark.SparkContext: Starting job: collect at BwaRDD.java:108
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Registering RDD 1 (newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Registering RDD 0 (newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Registering RDD 5 (repartition at BwaInterpreter.java:364)
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Got job 0 (collect at BwaRDD.java:108) with 3 output partitions
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Final stage: ResultStage 3(collect at BwaRDD.java:108)
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Parents of final stage: List(ShuffleMapStage 2)
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Missing parents: List(ShuffleMapStage 2)
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 0 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222), which has no missing parents
	16/06/24 21:59:48 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=515596, maxMem=1111794647
	16/06/24 21:59:48 INFO storage.MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/24 21:59:48 INFO storage.MemoryStore: ensureFreeSpace(1289) called with curMem=517732, maxMem=1111794647
	16/06/24 21:59:48 INFO storage.MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1289.0 B, free 1059.8 MB)
	16/06/24 21:59:48 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on 219.219.220.223:34509 (size: 1289.0 B, free: 1060.2 MB)
	16/06/24 21:59:48 INFO spark.SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:861
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 0 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/24 21:59:48 INFO scheduler.TaskSchedulerImpl: Adding task set 0.0 with 1 tasks
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 1 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221), which has no missing parents
	16/06/24 21:59:48 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=519021, maxMem=1111794647
	16/06/24 21:59:48 INFO storage.MemoryStore: Block broadcast_3 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/24 21:59:48 INFO storage.MemoryStore: ensureFreeSpace(1286) called with curMem=521157, maxMem=1111794647
	16/06/24 21:59:48 INFO storage.MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 1286.0 B, free 1059.8 MB)
	16/06/24 21:59:48 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on 219.219.220.223:34509 (size: 1286.0 B, free: 1060.2 MB)
	16/06/24 21:59:48 INFO spark.SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:861
	16/06/24 21:59:48 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 1 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/24 21:59:48 INFO scheduler.TaskSchedulerImpl: Adding task set 1.0 with 1 tasks
	16/06/24 21:59:48 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, 219.219.220.233, ANY, 2266 bytes)
	16/06/24 21:59:48 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 1.0 (TID 1, 219.219.220.131, ANY, 2266 bytes)
	16/06/24 21:59:48 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.149:48499/user/Executor#-2083167900]) with ID 2
	16/06/24 21:59:48 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.223:53592/user/Executor#822531264]) with ID 4
	16/06/24 21:59:48 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.149:48793 with 2.1 GB RAM, BlockManagerId(2, 219.219.220.149, 48793)
	16/06/24 21:59:49 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on 219.219.220.131:60373 (size: 1286.0 B, free: 2.1 GB)
	16/06/24 21:59:49 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on 219.219.220.233:60363 (size: 1289.0 B, free: 2.1 GB)
	16/06/24 21:59:49 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.223:34424 with 2.1 GB RAM, BlockManagerId(4, 219.219.220.223, 34424)
	16/06/24 21:59:49 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 219.219.220.131:60373 (size: 20.1 KB, free: 2.1 GB)
	16/06/24 21:59:49 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on 219.219.220.233:60363 (size: 20.1 KB, free: 2.1 GB)
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: ShuffleMapStage 1 (newAPIHadoopFile at BwaInterpreter.java:221) finished in 1.378 s
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: running: Set(ShuffleMapStage 0)
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: waiting: Set(ShuffleMapStage 2, ResultStage 3)
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: failed: Set()
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: Missing parents for ShuffleMapStage 2: List(ShuffleMapStage 0)
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: Missing parents for ResultStage 3: List(ShuffleMapStage 2)
	16/06/24 21:59:49 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 1.0 (TID 1) in 1350 ms on 219.219.220.131 (1/1)
	16/06/24 21:59:49 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 1.0, whose tasks have all completed, from pool 
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: ShuffleMapStage 0 (newAPIHadoopFile at BwaInterpreter.java:222) finished in 1.491 s
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: running: Set()
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: waiting: Set(ShuffleMapStage 2, ResultStage 3)
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: failed: Set()
	16/06/24 21:59:49 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 1494 ms on 219.219.220.233 (1/1)
	16/06/24 21:59:49 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool 
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: Missing parents for ShuffleMapStage 2: List()
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: Missing parents for ResultStage 3: List(ShuffleMapStage 2)
	16/06/24 21:59:49 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 2 (MapPartitionsRDD[5] at repartition at BwaInterpreter.java:364), which is now runnable
	16/06/24 21:59:50 INFO storage.MemoryStore: ensureFreeSpace(3000) called with curMem=522443, maxMem=1111794647
	16/06/24 21:59:50 INFO storage.MemoryStore: Block broadcast_4 stored as values in memory (estimated size 2.9 KB, free 1059.8 MB)
	16/06/24 21:59:50 INFO storage.MemoryStore: ensureFreeSpace(1620) called with curMem=525443, maxMem=1111794647
	16/06/24 21:59:50 INFO storage.MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 1620.0 B, free 1059.8 MB)
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on 219.219.220.223:34509 (size: 1620.0 B, free: 1060.2 MB)
	16/06/24 21:59:50 INFO spark.SparkContext: Created broadcast 4 from broadcast at DAGScheduler.scala:861
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 2 (MapPartitionsRDD[5] at repartition at BwaInterpreter.java:364)
	16/06/24 21:59:50 INFO scheduler.TaskSchedulerImpl: Adding task set 2.0 with 1 tasks
	16/06/24 21:59:50 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 2.0 (TID 2, 219.219.220.149, PROCESS_LOCAL, 2019 bytes)
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on 219.219.220.149:48793 (size: 1620.0 B, free: 2.1 GB)
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 0 to 219.219.220.149:48499
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 0 is 140 bytes
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 1 to 219.219.220.149:48499
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 1 is 140 bytes
	16/06/24 21:59:50 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 2.0 (TID 2) in 658 ms on 219.219.220.149 (1/1)
	16/06/24 21:59:50 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 2.0, whose tasks have all completed, from pool 
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: ShuffleMapStage 2 (repartition at BwaInterpreter.java:364) finished in 0.655 s
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: running: Set()
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: waiting: Set(ResultStage 3)
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: failed: Set()
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: Missing parents for ResultStage 3: List()
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: Submitting ResultStage 3 (MapPartitionsRDD[10] at mapPartitionsWithIndex at BwaRDD.java:108), which is now runnable
	16/06/24 21:59:50 INFO storage.MemoryStore: ensureFreeSpace(4256) called with curMem=527063, maxMem=1111794647
	16/06/24 21:59:50 INFO storage.MemoryStore: Block broadcast_5 stored as values in memory (estimated size 4.2 KB, free 1059.8 MB)
	16/06/24 21:59:50 INFO storage.MemoryStore: ensureFreeSpace(2452) called with curMem=531319, maxMem=1111794647
	16/06/24 21:59:50 INFO storage.MemoryStore: Block broadcast_5_piece0 stored as bytes in memory (estimated size 2.4 KB, free 1059.8 MB)
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.223:34509 (size: 2.4 KB, free: 1060.2 MB)
	16/06/24 21:59:50 INFO spark.SparkContext: Created broadcast 5 from broadcast at DAGScheduler.scala:861
	16/06/24 21:59:50 INFO scheduler.DAGScheduler: Submitting 3 missing tasks from ResultStage 3 (MapPartitionsRDD[10] at mapPartitionsWithIndex at BwaRDD.java:108)
	16/06/24 21:59:50 INFO scheduler.TaskSchedulerImpl: Adding task set 3.0 with 3 tasks
	16/06/24 21:59:50 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 3.0 (TID 3, 219.219.220.149, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:50 INFO scheduler.TaskSetManager: Starting task 1.0 in stage 3.0 (TID 4, 219.219.220.180, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:50 INFO scheduler.TaskSetManager: Starting task 2.0 in stage 3.0 (TID 5, 219.219.220.131, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.131:60373 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.149:48793 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 2 to 219.219.220.149:48499
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 2 is 143 bytes
	16/06/24 21:59:50 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 2 to 219.219.220.131:50628
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added rdd_9_0 in memory on 219.219.220.149:48793 (size: 2.1 KB, free: 2.1 GB)
	16/06/24 21:59:50 INFO storage.BlockManagerInfo: Added rdd_9_2 in memory on 219.219.220.131:60373 (size: 2.0 KB, free: 2.1 GB)
	16/06/24 21:59:51 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.180:52738 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:59:51 WARN scheduler.TaskSetManager: Lost task 2.0 in stage 3.0 (TID 5, 219.219.220.131): java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/3)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Starting task 2.1 in stage 3.0 (TID 6, 219.219.220.248, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:51 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 2 to 219.219.220.180:53082
	16/06/24 21:59:51 WARN scheduler.TaskSetManager: Lost task 0.0 in stage 3.0 (TID 3, 219.219.220.149): java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/2)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Starting task 0.1 in stage 3.0 (TID 7, 219.219.220.149, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:51 INFO storage.BlockManagerInfo: Added rdd_9_1 in memory on 219.219.220.180:52738 (size: 2.7 KB, free: 2.1 GB)
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Lost task 0.1 in stage 3.0 (TID 7) on executor 219.219.220.149: java.io.IOException (Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/2)) [duplicate 1]
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Starting task 0.2 in stage 3.0 (TID 8, 219.219.220.131, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:51 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.248:57238 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:59:51 WARN scheduler.TaskSetManager: Lost task 1.0 in stage 3.0 (TID 4, 219.219.220.180): java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/5)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Starting task 1.1 in stage 3.0 (TID 9, 219.219.220.149, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Lost task 0.2 in stage 3.0 (TID 8) on executor 219.219.220.131: java.io.IOException (Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/3)) [duplicate 1]
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Starting task 0.3 in stage 3.0 (TID 10, 219.219.220.233, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:51 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.233:60363 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Lost task 1.1 in stage 3.0 (TID 9) on executor 219.219.220.149: java.io.IOException (Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/2)) [duplicate 2]
	16/06/24 21:59:51 INFO scheduler.TaskSetManager: Starting task 1.2 in stage 3.0 (TID 11, 219.219.220.223, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:52 WARN scheduler.TaskSetManager: Lost task 2.1 in stage 3.0 (TID 6, 219.219.220.248): java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/1)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	
	16/06/24 21:59:52 INFO scheduler.TaskSetManager: Starting task 2.2 in stage 3.0 (TID 12, 219.219.220.248, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:59:52 WARN scheduler.TaskSetManager: Lost task 0.3 in stage 3.0 (TID 10, 219.219.220.233): java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/6)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	
	16/06/24 21:59:52 ERROR scheduler.TaskSetManager: Task 0 in stage 3.0 failed 4 times; aborting job
	16/06/24 21:59:52 INFO scheduler.TaskSchedulerImpl: Cancelling stage 3
	16/06/24 21:59:52 INFO scheduler.TaskSchedulerImpl: Stage 3 was cancelled
	16/06/24 21:59:52 INFO scheduler.DAGScheduler: ResultStage 3 (collect at BwaRDD.java:108) failed in 1.549 s
	16/06/24 21:59:52 INFO scheduler.DAGScheduler: Job 0 failed: collect at BwaRDD.java:108, took 3.854887 s
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 3.0 failed 4 times, most recent failure: Lost task 0.3 in stage 3.0 (TID 10, 219.219.220.233): java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/6)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	Caused by: java.io.IOException: Mkdirs failed to create /xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20160624215947-0113/6)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:442)
		at org.apache.hadoop.fs.ChecksumFileSystem.create(ChecksumFileSystem.java:428)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:908)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:889)
		at org.apache.hadoop.fs.FileSystem.create(FileSystem.java:786)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:365)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:338)
		at org.apache.hadoop.fs.FileUtil.copy(FileUtil.java:289)
		at org.apache.hadoop.fs.LocalFileSystem.copyFromLocalFile(LocalFileSystem.java:82)
		at org.apache.hadoop.fs.FileSystem.copyFromLocalFile(FileSystem.java:1838)
		at BwaRDD$BwaAlignment.call(BwaRDD.java:317)
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
	16/06/24 21:59:52 INFO spark.SparkContext: Invoking stop() from shutdown hook
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/metrics/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/kill,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/api,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/static,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/json,null}
	16/06/24 21:59:52 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs,null}
	16/06/24 21:59:52 INFO ui.SparkUI: Stopped Spark web UI at http://219.219.220.223:4040
	16/06/24 21:59:52 INFO scheduler.DAGScheduler: Stopping DAGScheduler
	16/06/24 21:59:52 INFO cluster.SparkDeploySchedulerBackend: Shutting down all executors
	16/06/24 21:59:52 INFO cluster.SparkDeploySchedulerBackend: Asking each executor to shut down
	16/06/24 21:59:52 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
	16/06/24 21:59:52 INFO storage.MemoryStore: MemoryStore cleared
	16/06/24 21:59:52 INFO storage.BlockManager: BlockManager stopped
	16/06/24 21:59:52 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
	16/06/24 21:59:52 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
	16/06/24 21:59:52 INFO spark.SparkContext: Successfully stopped SparkContext
	16/06/24 21:59:52 INFO util.ShutdownHookManager: Shutdown hook called
	16/06/24 21:59:52 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-c8e2a5c3-da2c-47ec-affa-b992c1a4dcf9
	16/06/24 21:59:52 INFO remote.RemoteActorRefProvider$RemotingTerminator: Shutting down remote daemon.
	16/06/24 21:59:52 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remote daemon shut down; proceeding with flushing remote transports.
	16/06/24 21:59:52 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remoting shut down.
	
	
	
	
脚本2：
	
	spark-submit --class SparkBWA \
	--master  spark://219.219.220.149:7077 \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	--driver-java-options "-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-r \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 3 \
	/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6
	
运行结果2：

	hadoop@Mcnode6:~/xubo/tools/SparkBWA/build$ ./pairedGRCH38L1Master.sh 
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: -r
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: -algorithm
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: mem
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: -reads
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: paired
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: -index
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: -partitions
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: 3
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq
	16/06/24 21:57:01 INFO BwaOptions: JMAbuin:: Received argument: sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6
	16/06/24 21:57:01 INFO spark.SparkContext: Running Spark version 1.5.2
	16/06/24 21:57:02 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	16/06/24 21:57:02 INFO spark.SecurityManager: Changing view acls to: hadoop
	16/06/24 21:57:02 INFO spark.SecurityManager: Changing modify acls to: hadoop
	16/06/24 21:57:02 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users with view permissions: Set(hadoop); users with modify permissions: Set(hadoop)
	16/06/24 21:57:03 INFO slf4j.Slf4jLogger: Slf4jLogger started
	16/06/24 21:57:03 INFO Remoting: Starting remoting
	16/06/24 21:57:03 INFO Remoting: Remoting started; listening on addresses :[akka.tcp://sparkDriver@219.219.220.223:46373]
	16/06/24 21:57:03 INFO util.Utils: Successfully started service 'sparkDriver' on port 46373.
	16/06/24 21:57:03 INFO spark.SparkEnv: Registering MapOutputTracker
	16/06/24 21:57:03 INFO spark.SparkEnv: Registering BlockManagerMaster
	16/06/24 21:57:03 INFO storage.DiskBlockManager: Created local directory at /tmp/blockmgr-08a6c733-11b5-4ae1-9f85-780c2c219027
	16/06/24 21:57:03 INFO storage.MemoryStore: MemoryStore started with capacity 1060.3 MB
	16/06/24 21:57:03 INFO spark.HttpFileServer: HTTP File server directory is /tmp/spark-10d9526a-3bb5-47c9-bf15-fa3a3acbc2d9/httpd-bb39bad9-0cb0-46dc-b81a-ef3630c39721
	16/06/24 21:57:03 INFO spark.HttpServer: Starting HTTP Server
	16/06/24 21:57:03 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/24 21:57:03 INFO server.AbstractConnector: Started SocketConnector@0.0.0.0:40359
	16/06/24 21:57:03 INFO util.Utils: Successfully started service 'HTTP file server' on port 40359.
	16/06/24 21:57:03 INFO spark.SparkEnv: Registering OutputCommitCoordinator
	16/06/24 21:57:03 INFO server.Server: jetty-8.y.z-SNAPSHOT
	16/06/24 21:57:03 INFO server.AbstractConnector: Started SelectChannelConnector@0.0.0.0:4040
	16/06/24 21:57:03 INFO util.Utils: Successfully started service 'SparkUI' on port 4040.
	16/06/24 21:57:03 INFO ui.SparkUI: Started SparkUI at http://219.219.220.223:4040
	16/06/24 21:57:03 INFO spark.SparkContext: Added JAR file:/home/hadoop/xubo/tools/SparkBWA/build/SparkBWA.jar at http://219.219.220.223:40359/jars/SparkBWA.jar with timestamp 1466776623773
	16/06/24 21:57:03 WARN metrics.MetricsSystem: Using default name DAGScheduler for source because spark.app.id is not set.
	16/06/24 21:57:03 INFO client.AppClient$ClientEndpoint: Connecting to master spark://219.219.220.149:7077...
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Connected to Spark cluster with app ID app-20160624215707-0112
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/0 on worker-20160620224519-219.219.220.215-54719 (219.219.220.215:54719) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/0 on hostPort 219.219.220.215:54719 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/1 on worker-20160620224514-219.219.220.248-40879 (219.219.220.248:40879) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/1 on hostPort 219.219.220.248:40879 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/2 on worker-20160620224513-219.219.220.149-33714 (219.219.220.149:33714) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/2 on hostPort 219.219.220.149:33714 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/3 on worker-20160620224514-219.219.220.131-52525 (219.219.220.131:52525) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/3 on hostPort 219.219.220.131:52525 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/4 on worker-20160620224513-219.219.220.223-37164 (219.219.220.223:37164) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/4 on hostPort 219.219.220.223:37164 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/5 on worker-20160620224513-219.219.220.180-51937 (219.219.220.180:51937) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/5 on hostPort 219.219.220.180:51937 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor added: app-20160624215707-0112/6 on worker-20160620224512-219.219.220.233-33505 (219.219.220.233:33505) with 2 cores
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: Granted executor ID app-20160624215707-0112/6 on hostPort 219.219.220.233:33505 with 2 cores, 4.0 GB RAM
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/3 is now LOADING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/1 is now LOADING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/6 is now LOADING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/5 is now LOADING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/0 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/1 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/2 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/3 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/4 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/5 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/6 is now RUNNING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/4 is now LOADING
	16/06/24 21:57:04 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/2 is now LOADING
	16/06/24 21:57:04 INFO util.Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 45478.
	16/06/24 21:57:04 INFO netty.NettyBlockTransferService: Server created on 45478
	16/06/24 21:57:04 INFO storage.BlockManagerMaster: Trying to register BlockManager
	16/06/24 21:57:04 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.223:45478 with 1060.3 MB RAM, BlockManagerId(driver, 219.219.220.223, 45478)
	16/06/24 21:57:04 INFO storage.BlockManagerMaster: Registered BlockManager
	16/06/24 21:57:04 INFO cluster.SparkDeploySchedulerBackend: SchedulerBackend is ready for scheduling beginning after reached minRegisteredResourcesRatio: 0.0
	16/06/24 21:57:05 INFO client.AppClient$ClientEndpoint: Executor updated: app-20160624215707-0112/0 is now LOADING
	16/06/24 21:57:05 INFO BwaInterpreter: JMAbuin:: Starting sorting if desired
	16/06/24 21:57:05 INFO BwaInterpreter: JMAbuin::Not sorting in HDFS. Timing: 501833409005797
	16/06/24 21:57:06 INFO storage.MemoryStore: ensureFreeSpace(237240) called with curMem=0, maxMem=1111794647
	16/06/24 21:57:06 INFO storage.MemoryStore: Block broadcast_0 stored as values in memory (estimated size 231.7 KB, free 1060.1 MB)
	16/06/24 21:57:06 INFO storage.MemoryStore: ensureFreeSpace(20558) called with curMem=237240, maxMem=1111794647
	16/06/24 21:57:06 INFO storage.MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 20.1 KB, free 1060.0 MB)
	16/06/24 21:57:06 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 219.219.220.223:45478 (size: 20.1 KB, free: 1060.3 MB)
	16/06/24 21:57:06 INFO spark.SparkContext: Created broadcast 0 from newAPIHadoopFile at BwaInterpreter.java:221
	16/06/24 21:57:06 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/24 21:57:07 INFO storage.MemoryStore: ensureFreeSpace(237240) called with curMem=257798, maxMem=1111794647
	16/06/24 21:57:07 INFO storage.MemoryStore: Block broadcast_1 stored as values in memory (estimated size 231.7 KB, free 1059.8 MB)
	16/06/24 21:57:07 INFO storage.MemoryStore: ensureFreeSpace(20558) called with curMem=495038, maxMem=1111794647
	16/06/24 21:57:07 INFO storage.MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 20.1 KB, free 1059.8 MB)
	16/06/24 21:57:07 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on 219.219.220.223:45478 (size: 20.1 KB, free: 1060.3 MB)
	16/06/24 21:57:07 INFO spark.SparkContext: Created broadcast 1 from newAPIHadoopFile at BwaInterpreter.java:222
	16/06/24 21:57:07 WARN rdd.NewHadoopRDD: Caching NewHadoopRDDs as deserialized objects usually leads to undesired behavior because Hadoop's RecordReader reuses the same Writable object for all records. Use a map transformation to make copies of the records.
	16/06/24 21:57:07 INFO BwaInterpreter: JMAbuin:: No sort with partitioning
	16/06/24 21:57:07 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/24 21:57:07 INFO input.FileInputFormat: Total input paths to process : 1
	16/06/24 21:57:07 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.248:51064/user/Executor#-850382572]) with ID 1
	16/06/24 21:57:07 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.233:46500/user/Executor#2042684799]) with ID 6
	16/06/24 21:57:07 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.131:46548/user/Executor#121680607]) with ID 3
	16/06/24 21:57:07 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.180:43553/user/Executor#-658725370]) with ID 5
	16/06/24 21:57:07 INFO BwaInterpreter: JMAbuin:: Repartition with no sort
	16/06/24 21:57:07 INFO rdd.MapPartitionsRDD: Removing RDD 4 from persistence list
	16/06/24 21:57:07 INFO storage.BlockManager: Removing RDD 4
	16/06/24 21:57:07 INFO rdd.NewHadoopRDD: Removing RDD 0 from persistence list
	16/06/24 21:57:07 INFO storage.BlockManager: Removing RDD 0
	16/06/24 21:57:07 INFO rdd.NewHadoopRDD: Removing RDD 1 from persistence list
	16/06/24 21:57:07 INFO storage.BlockManager: Removing RDD 1
	16/06/24 21:57:07 INFO storage.BlockManager: Removing RDD 0
	16/06/24 21:57:07 INFO spark.ContextCleaner: Cleaned RDD 0
	16/06/24 21:57:07 INFO storage.BlockManager: Removing RDD 1
	16/06/24 21:57:07 INFO spark.ContextCleaner: Cleaned RDD 1
	16/06/24 21:57:07 INFO BwaInterpreter: JMAbuin:: End of sorting. Timing: 501834822637393
	16/06/24 21:57:07 INFO BwaInterpreter: JMAbuin:: Total time: 0.023560526600000003 minutes
	16/06/24 21:57:07 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.233:41760 with 2.1 GB RAM, BlockManagerId(6, 219.219.220.233, 41760)
	16/06/24 21:57:07 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.248:39326 with 2.1 GB RAM, BlockManagerId(1, 219.219.220.248, 39326)
	16/06/24 21:57:07 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.180:51338 with 2.1 GB RAM, BlockManagerId(5, 219.219.220.180, 51338)
	16/06/24 21:57:07 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.131:47987 with 2.1 GB RAM, BlockManagerId(3, 219.219.220.131, 47987)
	16/06/24 21:57:07 INFO BwaInterpreter: JMAbuin:: Starting BWA
	16/06/24 21:57:07 INFO BwaInterpreter: JMAbuin:: app-20160624215707-0112 - SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort
	16/06/24 21:57:07 INFO spark.SparkContext: Starting job: collect at BwaRDD.java:108
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Registering RDD 1 (newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Registering RDD 0 (newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Registering RDD 5 (repartition at BwaInterpreter.java:364)
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Got job 0 (collect at BwaRDD.java:108) with 3 output partitions
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Final stage: ResultStage 3(collect at BwaRDD.java:108)
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Parents of final stage: List(ShuffleMapStage 2)
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Missing parents: List(ShuffleMapStage 2)
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 0 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222), which has no missing parents
	16/06/24 21:57:07 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=515596, maxMem=1111794647
	16/06/24 21:57:07 INFO storage.MemoryStore: Block broadcast_2 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/24 21:57:07 INFO storage.MemoryStore: ensureFreeSpace(1289) called with curMem=517732, maxMem=1111794647
	16/06/24 21:57:07 INFO storage.MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 1289.0 B, free 1059.8 MB)
	16/06/24 21:57:07 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on 219.219.220.223:45478 (size: 1289.0 B, free: 1060.2 MB)
	16/06/24 21:57:07 INFO spark.SparkContext: Created broadcast 2 from broadcast at DAGScheduler.scala:861
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 0 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq NewHadoopRDD[1] at newAPIHadoopFile at BwaInterpreter.java:222)
	16/06/24 21:57:07 INFO scheduler.TaskSchedulerImpl: Adding task set 0.0 with 1 tasks
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 1 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221), which has no missing parents
	16/06/24 21:57:07 INFO storage.MemoryStore: ensureFreeSpace(2136) called with curMem=519021, maxMem=1111794647
	16/06/24 21:57:07 INFO storage.MemoryStore: Block broadcast_3 stored as values in memory (estimated size 2.1 KB, free 1059.8 MB)
	16/06/24 21:57:07 INFO storage.MemoryStore: ensureFreeSpace(1286) called with curMem=521157, maxMem=1111794647
	16/06/24 21:57:07 INFO storage.MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 1286.0 B, free 1059.8 MB)
	16/06/24 21:57:07 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on 219.219.220.223:45478 (size: 1286.0 B, free: 1060.2 MB)
	16/06/24 21:57:07 INFO spark.SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:861
	16/06/24 21:57:07 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 1 (/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq NewHadoopRDD[0] at newAPIHadoopFile at BwaInterpreter.java:221)
	16/06/24 21:57:07 INFO scheduler.TaskSchedulerImpl: Adding task set 1.0 with 1 tasks
	16/06/24 21:57:07 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, 219.219.220.233, ANY, 2266 bytes)
	16/06/24 21:57:07 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 1.0 (TID 1, 219.219.220.233, ANY, 2266 bytes)
	16/06/24 21:57:08 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.149:46495/user/Executor#-4025863]) with ID 2
	16/06/24 21:57:08 INFO storage.BlockManagerInfo: Added broadcast_2_piece0 in memory on 219.219.220.233:41760 (size: 1289.0 B, free: 2.1 GB)
	16/06/24 21:57:08 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.149:39791 with 2.1 GB RAM, BlockManagerId(2, 219.219.220.149, 39791)
	16/06/24 21:57:08 INFO storage.BlockManagerInfo: Added broadcast_3_piece0 in memory on 219.219.220.233:41760 (size: 1286.0 B, free: 2.1 GB)
	16/06/24 21:57:08 INFO storage.BlockManagerInfo: Added broadcast_1_piece0 in memory on 219.219.220.233:41760 (size: 20.1 KB, free: 2.1 GB)
	16/06/24 21:57:08 INFO cluster.SparkDeploySchedulerBackend: Registered executor: AkkaRpcEndpointRef(Actor[akka.tcp://sparkExecutor@219.219.220.223:48390/user/Executor#649580107]) with ID 4
	16/06/24 21:57:08 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 219.219.220.233:41760 (size: 20.1 KB, free: 2.1 GB)
	16/06/24 21:57:08 INFO storage.BlockManagerMasterEndpoint: Registering block manager 219.219.220.223:35436 with 2.1 GB RAM, BlockManagerId(4, 219.219.220.223, 35436)
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: ShuffleMapStage 1 (newAPIHadoopFile at BwaInterpreter.java:221) finished in 1.512 s
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: running: Set(ShuffleMapStage 0)
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: waiting: Set(ShuffleMapStage 2, ResultStage 3)
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: failed: Set()
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: Missing parents for ShuffleMapStage 2: List(ShuffleMapStage 0)
	16/06/24 21:57:09 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 1.0 (TID 1) in 1498 ms on 219.219.220.233 (1/1)
	16/06/24 21:57:09 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 1.0, whose tasks have all completed, from pool 
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: Missing parents for ResultStage 3: List(ShuffleMapStage 2)
	16/06/24 21:57:09 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 1560 ms on 219.219.220.233 (1/1)
	16/06/24 21:57:09 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool 
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: ShuffleMapStage 0 (newAPIHadoopFile at BwaInterpreter.java:222) finished in 1.553 s
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: running: Set()
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: waiting: Set(ShuffleMapStage 2, ResultStage 3)
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: failed: Set()
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: Missing parents for ShuffleMapStage 2: List()
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: Missing parents for ResultStage 3: List(ShuffleMapStage 2)
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: Submitting ShuffleMapStage 2 (MapPartitionsRDD[5] at repartition at BwaInterpreter.java:364), which is now runnable
	16/06/24 21:57:09 INFO storage.MemoryStore: ensureFreeSpace(3000) called with curMem=522443, maxMem=1111794647
	16/06/24 21:57:09 INFO storage.MemoryStore: Block broadcast_4 stored as values in memory (estimated size 2.9 KB, free 1059.8 MB)
	16/06/24 21:57:09 INFO storage.MemoryStore: ensureFreeSpace(1620) called with curMem=525443, maxMem=1111794647
	16/06/24 21:57:09 INFO storage.MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 1620.0 B, free 1059.8 MB)
	16/06/24 21:57:09 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on 219.219.220.223:45478 (size: 1620.0 B, free: 1060.2 MB)
	16/06/24 21:57:09 INFO spark.SparkContext: Created broadcast 4 from broadcast at DAGScheduler.scala:861
	16/06/24 21:57:09 INFO scheduler.DAGScheduler: Submitting 1 missing tasks from ShuffleMapStage 2 (MapPartitionsRDD[5] at repartition at BwaInterpreter.java:364)
	16/06/24 21:57:09 INFO scheduler.TaskSchedulerImpl: Adding task set 2.0 with 1 tasks
	16/06/24 21:57:09 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 2.0 (TID 2, 219.219.220.180, PROCESS_LOCAL, 2019 bytes)
	16/06/24 21:57:09 INFO storage.BlockManagerInfo: Added broadcast_4_piece0 in memory on 219.219.220.180:51338 (size: 1620.0 B, free: 2.1 GB)
	16/06/24 21:57:09 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 0 to 219.219.220.180:43553
	16/06/24 21:57:09 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 0 is 140 bytes
	16/06/24 21:57:10 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 1 to 219.219.220.180:43553
	16/06/24 21:57:10 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 1 is 140 bytes
	16/06/24 21:57:10 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 2.0 (TID 2) in 675 ms on 219.219.220.180 (1/1)
	16/06/24 21:57:10 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 2.0, whose tasks have all completed, from pool 
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: ShuffleMapStage 2 (repartition at BwaInterpreter.java:364) finished in 0.678 s
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: looking for newly runnable stages
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: running: Set()
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: waiting: Set(ResultStage 3)
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: failed: Set()
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: Missing parents for ResultStage 3: List()
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: Submitting ResultStage 3 (MapPartitionsRDD[10] at mapPartitionsWithIndex at BwaRDD.java:108), which is now runnable
	16/06/24 21:57:10 INFO storage.MemoryStore: ensureFreeSpace(4232) called with curMem=527063, maxMem=1111794647
	16/06/24 21:57:10 INFO storage.MemoryStore: Block broadcast_5 stored as values in memory (estimated size 4.1 KB, free 1059.8 MB)
	16/06/24 21:57:10 INFO storage.MemoryStore: ensureFreeSpace(2439) called with curMem=531295, maxMem=1111794647
	16/06/24 21:57:10 INFO storage.MemoryStore: Block broadcast_5_piece0 stored as bytes in memory (estimated size 2.4 KB, free 1059.8 MB)
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.223:45478 (size: 2.4 KB, free: 1060.2 MB)
	16/06/24 21:57:10 INFO spark.SparkContext: Created broadcast 5 from broadcast at DAGScheduler.scala:861
	16/06/24 21:57:10 INFO scheduler.DAGScheduler: Submitting 3 missing tasks from ResultStage 3 (MapPartitionsRDD[10] at mapPartitionsWithIndex at BwaRDD.java:108)
	16/06/24 21:57:10 INFO scheduler.TaskSchedulerImpl: Adding task set 3.0 with 3 tasks
	16/06/24 21:57:10 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 3.0 (TID 3, 219.219.220.131, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:57:10 INFO scheduler.TaskSetManager: Starting task 1.0 in stage 3.0 (TID 4, 219.219.220.233, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:57:10 INFO scheduler.TaskSetManager: Starting task 2.0 in stage 3.0 (TID 5, 219.219.220.180, PROCESS_LOCAL, 2226 bytes)
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.233:41760 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.180:51338 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:57:10 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 2 to 219.219.220.180:43553
	16/06/24 21:57:10 INFO spark.MapOutputTrackerMaster: Size of output statuses for shuffle 2 is 143 bytes
	16/06/24 21:57:10 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 2 to 219.219.220.233:46500
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added rdd_9_2 in memory on 219.219.220.180:51338 (size: 2.0 KB, free: 2.1 GB)
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added rdd_9_1 in memory on 219.219.220.233:41760 (size: 2.7 KB, free: 2.1 GB)
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added broadcast_5_piece0 in memory on 219.219.220.131:47987 (size: 2.4 KB, free: 2.1 GB)
	16/06/24 21:57:10 INFO scheduler.TaskSetManager: Finished task 1.0 in stage 3.0 (TID 4) in 453 ms on 219.219.220.233 (1/3)
	16/06/24 21:57:10 INFO scheduler.TaskSetManager: Finished task 2.0 in stage 3.0 (TID 5) in 469 ms on 219.219.220.180 (2/3)
	16/06/24 21:57:10 INFO spark.MapOutputTrackerMasterEndpoint: Asked to send map output locations for shuffle 2 to 219.219.220.131:46548
	16/06/24 21:57:10 INFO storage.BlockManagerInfo: Added rdd_9_0 in memory on 219.219.220.131:47987 (size: 2.1 KB, free: 2.1 GB)
	16/06/24 21:57:11 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 3.0 (TID 3) in 965 ms on 219.219.220.131 (3/3)
	16/06/24 21:57:11 INFO scheduler.DAGScheduler: ResultStage 3 (collect at BwaRDD.java:108) finished in 0.965 s
	16/06/24 21:57:11 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 3.0, whose tasks have all completed, from pool 
	16/06/24 21:57:11 INFO scheduler.DAGScheduler: Job 0 finished: collect at BwaRDD.java:108, took 3.353936 s
	16/06/24 21:57:11 INFO BwaInterpreter: BwaRDD :: Total of returned lines from RDDs :: 3
	16/06/24 21:57:11 INFO BwaInterpreter: JMAbuin:: SparkBWA :: Returned file ::sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6/SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort-app-20160624215707-0112-0.sam
	java.io.FileNotFoundException: File does not exist: /user/hadoop/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6/SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort-app-20160624215707-0112-0.sam
		at org.apache.hadoop.hdfs.server.namenode.INodeFile.valueOf(INodeFile.java:66)
		at org.apache.hadoop.hdfs.server.namenode.INodeFile.valueOf(INodeFile.java:56)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocationsUpdateTimes(FSNamesystem.java:1891)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocationsInt(FSNamesystem.java:1832)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocations(FSNamesystem.java:1812)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocations(FSNamesystem.java:1784)
		at org.apache.hadoop.hdfs.server.namenode.NameNodeRpcServer.getBlockLocations(NameNodeRpcServer.java:542)
		at org.apache.hadoop.hdfs.protocolPB.ClientNamenodeProtocolServerSideTranslatorPB.getBlockLocations(ClientNamenodeProtocolServerSideTranslatorPB.java:362)
		at org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos$ClientNamenodeProtocol$2.callBlockingMethod(ClientNamenodeProtocolProtos.java)
		at org.apache.hadoop.ipc.ProtobufRpcEngine$Server$ProtoBufRpcInvoker.call(ProtobufRpcEngine.java:619)
		at org.apache.hadoop.ipc.RPC$Server.call(RPC.java:962)
		at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:2039)
		at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:2035)
		at java.security.AccessController.doPrivileged(Native Method)
		at javax.security.auth.Subject.doAs(Subject.java:415)
		at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1628)
		at org.apache.hadoop.ipc.Server$Handler.run(Server.java:2033)
	
		at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
		at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)
		at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
		at java.lang.reflect.Constructor.newInstance(Constructor.java:526)
		at org.apache.hadoop.ipc.RemoteException.instantiateException(RemoteException.java:106)
		at org.apache.hadoop.ipc.RemoteException.unwrapRemoteException(RemoteException.java:73)
		at org.apache.hadoop.hdfs.DFSClient.callGetBlockLocations(DFSClient.java:1222)
		at org.apache.hadoop.hdfs.DFSClient.getLocatedBlocks(DFSClient.java:1210)
		at org.apache.hadoop.hdfs.DFSClient.getLocatedBlocks(DFSClient.java:1200)
		at org.apache.hadoop.hdfs.DFSInputStream.fetchLocatedBlocksAndGetLastBlockLength(DFSInputStream.java:271)
		at org.apache.hadoop.hdfs.DFSInputStream.openInfo(DFSInputStream.java:238)
		at org.apache.hadoop.hdfs.DFSInputStream.<init>(DFSInputStream.java:231)
		at org.apache.hadoop.hdfs.DFSClient.open(DFSClient.java:1498)
		at org.apache.hadoop.hdfs.DistributedFileSystem$3.doCall(DistributedFileSystem.java:302)
		at org.apache.hadoop.hdfs.DistributedFileSystem$3.doCall(DistributedFileSystem.java:298)
		at org.apache.hadoop.fs.FileSystemLinkResolver.resolve(FileSystemLinkResolver.java:81)
		at org.apache.hadoop.hdfs.DistributedFileSystem.open(DistributedFileSystem.java:298)
		at org.apache.hadoop.fs.FileSystem.open(FileSystem.java:766)
		at BwaRDD.MapBwa(BwaRDD.java:125)
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
	Caused by: org.apache.hadoop.ipc.RemoteException(java.io.FileNotFoundException): File does not exist: /user/hadoop/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6/SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort-app-20160624215707-0112-0.sam
		at org.apache.hadoop.hdfs.server.namenode.INodeFile.valueOf(INodeFile.java:66)
		at org.apache.hadoop.hdfs.server.namenode.INodeFile.valueOf(INodeFile.java:56)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocationsUpdateTimes(FSNamesystem.java:1891)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocationsInt(FSNamesystem.java:1832)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocations(FSNamesystem.java:1812)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocations(FSNamesystem.java:1784)
		at org.apache.hadoop.hdfs.server.namenode.NameNodeRpcServer.getBlockLocations(NameNodeRpcServer.java:542)
		at org.apache.hadoop.hdfs.protocolPB.ClientNamenodeProtocolServerSideTranslatorPB.getBlockLocations(ClientNamenodeProtocolServerSideTranslatorPB.java:362)
		at org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos$ClientNamenodeProtocol$2.callBlockingMethod(ClientNamenodeProtocolProtos.java)
		at org.apache.hadoop.ipc.ProtobufRpcEngine$Server$ProtoBufRpcInvoker.call(ProtobufRpcEngine.java:619)
		at org.apache.hadoop.ipc.RPC$Server.call(RPC.java:962)
		at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:2039)
		at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:2035)
		at java.security.AccessController.doPrivileged(Native Method)
		at javax.security.auth.Subject.doAs(Subject.java:415)
		at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1628)
		at org.apache.hadoop.ipc.Server$Handler.run(Server.java:2033)
	
		at org.apache.hadoop.ipc.Client.call(Client.java:1468)
		at org.apache.hadoop.ipc.Client.call(Client.java:1399)
		at org.apache.hadoop.ipc.ProtobufRpcEngine$Invoker.invoke(ProtobufRpcEngine.java:232)
		at com.sun.proxy.$Proxy12.getBlockLocations(Unknown Source)
		at org.apache.hadoop.hdfs.protocolPB.ClientNamenodeProtocolTranslatorPB.getBlockLocations(ClientNamenodeProtocolTranslatorPB.java:254)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.hadoop.io.retry.RetryInvocationHandler.invokeMethod(RetryInvocationHandler.java:187)
		at org.apache.hadoop.io.retry.RetryInvocationHandler.invoke(RetryInvocationHandler.java:102)
		at com.sun.proxy.$Proxy13.getBlockLocations(Unknown Source)
		at org.apache.hadoop.hdfs.DFSClient.callGetBlockLocations(DFSClient.java:1220)
		... 23 more
	16/06/24 21:57:11 ERROR BwaInterpreter: java.io.FileNotFoundException: File does not exist: /user/hadoop/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12Master3Mcnode6/SparkBWA_GRCH38chr1L3556522N10L50paired1.fastq-3-NoSort-app-20160624215707-0112-0.sam
		at org.apache.hadoop.hdfs.server.namenode.INodeFile.valueOf(INodeFile.java:66)
		at org.apache.hadoop.hdfs.server.namenode.INodeFile.valueOf(INodeFile.java:56)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocationsUpdateTimes(FSNamesystem.java:1891)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocationsInt(FSNamesystem.java:1832)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocations(FSNamesystem.java:1812)
		at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.getBlockLocations(FSNamesystem.java:1784)
		at org.apache.hadoop.hdfs.server.namenode.NameNodeRpcServer.getBlockLocations(NameNodeRpcServer.java:542)
		at org.apache.hadoop.hdfs.protocolPB.ClientNamenodeProtocolServerSideTranslatorPB.getBlockLocations(ClientNamenodeProtocolServerSideTranslatorPB.java:362)
		at org.apache.hadoop.hdfs.protocol.proto.ClientNamenodeProtocolProtos$ClientNamenodeProtocol$2.callBlockingMethod(ClientNamenodeProtocolProtos.java)
		at org.apache.hadoop.ipc.ProtobufRpcEngine$Server$ProtoBufRpcInvoker.call(ProtobufRpcEngine.java:619)
		at org.apache.hadoop.ipc.RPC$Server.call(RPC.java:962)
		at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:2039)
		at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:2035)
		at java.security.AccessController.doPrivileged(Native Method)
		at javax.security.auth.Subject.doAs(Subject.java:415)
		at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1628)
		at org.apache.hadoop.ipc.Server$Handler.run(Server.java:2033)
	
	16/06/24 21:57:11 INFO spark.SparkContext: Invoking stop() from shutdown hook
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/metrics/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/kill,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/api,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/static,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/threadDump,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/executors,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/environment,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/rdd,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/storage,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/pool,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/stage,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/stages,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/job,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs/json,null}
	16/06/24 21:57:11 INFO handler.ContextHandler: stopped o.s.j.s.ServletContextHandler{/jobs,null}
	16/06/24 21:57:11 INFO ui.SparkUI: Stopped Spark web UI at http://219.219.220.223:4040
	16/06/24 21:57:11 INFO scheduler.DAGScheduler: Stopping DAGScheduler
	16/06/24 21:57:11 INFO cluster.SparkDeploySchedulerBackend: Shutting down all executors
	16/06/24 21:57:11 INFO cluster.SparkDeploySchedulerBackend: Asking each executor to shut down
	16/06/24 21:57:11 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
	16/06/24 21:57:11 INFO storage.MemoryStore: MemoryStore cleared
	16/06/24 21:57:11 INFO storage.BlockManager: BlockManager stopped
	16/06/24 21:57:11 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
	16/06/24 21:57:11 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
	16/06/24 21:57:11 INFO spark.SparkContext: Successfully stopped SparkContext
	16/06/24 21:57:11 INFO remote.RemoteActorRefProvider$RemotingTerminator: Shutting down remote daemon.
	16/06/24 21:57:11 INFO util.ShutdownHookManager: Shutdown hook called
	16/06/24 21:57:11 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-10d9526a-3bb5-47c9-bf15-fa3a3acbc2d9
	16/06/24 21:57:11 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remote daemon shut down; proceeding with flushing remote transports.
	16/06/24 21:57:11 INFO remote.RemoteActorRefProvider$RemotingTerminator: Remoting shut down.
	hadoop@Mcnode6:~/xubo/tools/SparkBWA/build$ 
	
	
解决办法参考【1】，没有实践

参考
	【1】 http://blog.csdn.net/walkerjong/article/details/37763777