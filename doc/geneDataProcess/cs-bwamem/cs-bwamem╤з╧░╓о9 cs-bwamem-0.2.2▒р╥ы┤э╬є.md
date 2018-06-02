	更多代码请见：https://github.com/xubo245
		
	基因数据处理系列之cs-bwamem
	
	# 1.解释
	##1.1
	 cs-bwamem-0.2.1编译运行没问题，但是比较老
	
	cs-bwamem-0.2.2编译出现问题
	
	# 2.代码
	##2.1
	
	# 3.结果
	##3.1
	
	master节点：
	
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:cloud-scale-bwamem:jar:0.2.2
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-shade-plugin is missing. @ line 151, column 21
	[WARNING] 'build.plugins.plugin.version' for org.scala-tools:maven-scala-plugin is missing. @ line 95, column 21
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Cloud-Scale-BWAMEM 0.2.2
	[INFO] ------------------------------------------------------------------------
	Downloading: http://scala-tools.org/repo-releases/org/scala-tools/maven-scala-plugin/maven-metadata.xml
	[WARNING] Could not transfer metadata org.scala-tools:maven-scala-plugin/maven-metadata.xml from/to scala-tools.org (http://scala-tools.org/repo-releases): scala-tools.org: Name or service not known
	Downloading: http://scala-tools.org/repo-releases/org/apache/maven/plugins/maven-shade-plugin/maven-metadata.xml
	[WARNING] Could not transfer metadata org.apache.maven.plugins:maven-shade-plugin/maven-metadata.xml from/to scala-tools.org (http://scala-tools.org/repo-releases): scala-tools.org
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ cloud-scale-bwamem ---
	[INFO] Deleting /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:schema (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:protocol (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:idl-protocol (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ cloud-scale-bwamem ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (default) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.2 requires scala version: 2.10.4
	[WARNING]  com.twitter:chill_2.10:0.5.0 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-remote_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-actor_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-slf4j_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  org.apache.spark:spark-core_2.10:1.5.1 requires scala version: 2.10.4
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/java:-1: info: compiling
	[INFO] /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/scala:-1: info: compiling
	[INFO] Compiling 77 source files to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes at 1487736385220
	[WARNING] warning: there were 22 deprecation warning(s); re-run with -deprecation for details
	[WARNING] warning: there were 1 feature warning(s); re-run with -feature for details
	[WARNING] two warnings found
	[INFO] prepare-compile in 0 s
	[INFO] compile in 95 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ cloud-scale-bwamem ---
	[INFO] Changes detected - recompiling the module!
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 8 source files to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (compile) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.2 requires scala version: 2.10.4
	[WARNING]  com.twitter:chill_2.10:0.5.0 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-remote_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-actor_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-slf4j_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  org.apache.spark:spark-core_2.10:1.5.1 requires scala version: 2.10.4
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ cloud-scale-bwamem ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ cloud-scale-bwamem ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:testCompile (test-compile) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.2 requires scala version: 2.10.4
	[WARNING]  com.twitter:chill_2.10:0.5.0 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-remote_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-actor_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-slf4j_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  org.apache.spark:spark-core_2.10:1.5.1 requires scala version: 2.10.4
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[WARNING] No source files found.
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ cloud-scale-bwamem ---
	[INFO] Building jar: /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/cloud-scale-bwamem-0.2.2.jar
	[INFO] 
	[INFO] --- maven-dependency-plugin:2.8:copy-dependencies (default) @ cloud-scale-bwamem ---
	[INFO] Copying jackson-annotations-2.4.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-annotations-2.4.0.jar
	[INFO] Copying protobuf-java-2.5.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/protobuf-java-2.5.0.jar
	[INFO] Copying oro-2.0.8.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/oro-2.0.8.jar
	[INFO] Copying adam-core_2.10-0.18.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/adam-core_2.10-0.18.0.jar
	[INFO] Copying jul-to-slf4j-1.7.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jul-to-slf4j-1.7.10.jar
	[INFO] Copying jcl-over-slf4j-1.7.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jcl-over-slf4j-1.7.10.jar
	[INFO] Copying parquet-common-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-common-1.6.0.jar
	[INFO] Copying curator-client-2.1.0-incubating.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/curator-client-2.1.0-incubating.jar
	[INFO] Copying testng-6.8.8.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/testng-6.8.8.jar
	[INFO] Copying hadoop-mapreduce-client-app-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-app-2.5.2.jar
	[INFO] Copying jakarta-regexp-1.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jakarta-regexp-1.4.jar
	[INFO] Copying tachyon-underfs-local-0.7.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/tachyon-underfs-local-0.7.1.jar
	[INFO] Copying ant-1.8.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/ant-1.8.2.jar
	[INFO] Copying scalap-2.10.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scalap-2.10.0.jar
	[INFO] Copying parquet-encoding-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-encoding-1.8.1.jar
	[INFO] Copying hadoop-auth-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-auth-2.5.2.jar
	[INFO] Copying hadoop-yarn-server-common-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-server-common-2.5.2.jar
	[INFO] Copying scala-compiler-2.10.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scala-compiler-2.10.0.jar
	[INFO] Copying akka-slf4j_2.10-2.3.11.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/akka-slf4j_2.10-2.3.11.jar
	[INFO] Copying commons-beanutils-1.7.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-beanutils-1.7.0.jar
	[INFO] Copying hadoop-client-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-client-2.5.2.jar
	[INFO] Copying metrics-jvm-3.1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-jvm-3.1.2.jar
	[INFO] Copying ant-launcher-1.8.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/ant-launcher-1.8.2.jar
	[INFO] Copying parquet-encoding-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-encoding-1.6.0.jar
	[INFO] Copying metrics-graphite-3.1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-graphite-3.1.2.jar
	[INFO] Copying commons-httpclient-3.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-httpclient-3.1.jar
	[INFO] Copying avro-ipc-1.7.7-tests.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-ipc-1.7.7-tests.jar
	[INFO] Copying paranamer-2.3.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/paranamer-2.3.jar
	[INFO] Copying curator-framework-2.4.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/curator-framework-2.4.0.jar
	[INFO] Copying parquet-format-2.2.0-rc1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-format-2.2.0-rc1.jar
	[INFO] Copying scala-reflect-2.10.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scala-reflect-2.10.4.jar
	[INFO] Copying commons-cli-1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-cli-1.2.jar
	[INFO] Copying stax-api-1.0-2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/stax-api-1.0-2.jar
	[INFO] Copying compress-lzf-1.0.3.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/compress-lzf-1.0.3.jar
	[INFO] Copying utils-io_2.10-0.2.3.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-io_2.10-0.2.3.jar
	[INFO] Copying parquet-column-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-column-1.8.1.jar
	[INFO] Copying utils-metrics_2.10-0.2.3.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-metrics_2.10-0.2.3.jar
	[INFO] Copying spark-network-common_2.10-1.5.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-network-common_2.10-1.5.1.jar
	[INFO] Copying utils-cli_2.10-0.2.3.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-cli_2.10-0.2.3.jar
	[INFO] Copying zookeeper-3.4.6.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/zookeeper-3.4.6.jar
	[INFO] Copying json4s-jackson_2.10-3.2.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/json4s-jackson_2.10-3.2.10.jar
	[INFO] Copying spark-core_2.10-1.5.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-core_2.10-1.5.1.jar
	[INFO] Copying hadoop-mapreduce-client-common-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-common-2.5.2.jar
	[INFO] Copying commons-compress-1.4.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-compress-1.4.1.jar
	[INFO] Copying hadoop-hdfs-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-hdfs-2.5.2.jar
	[INFO] Copying minlog-1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/minlog-1.2.jar
	[INFO] Copying spark-unsafe_2.10-1.5.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-unsafe_2.10-1.5.1.jar
	[INFO] Copying avro-mapred-1.7.7-hadoop2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-mapred-1.7.7-hadoop2.jar
	[INFO] Copying parquet-scala_2.10-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-scala_2.10-1.8.1.jar
	[INFO] Copying commons-math3-3.4.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-math3-3.4.1.jar
	[INFO] Copying commons-codec-1.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-codec-1.4.jar
	[INFO] Copying hadoop-common-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-common-2.5.2.jar
	[INFO] Copying json4s-core_2.10-3.2.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/json4s-core_2.10-3.2.10.jar
	[INFO] Copying commons-net-2.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-net-2.2.jar
	[INFO] Copying config-1.2.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/config-1.2.1.jar
	[INFO] Copying args4j-2.0.23.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/args4j-2.0.23.jar
	[INFO] Copying parquet-avro-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-avro-1.6.0.jar
	[INFO] Copying bsh-2.0b4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/bsh-2.0b4.jar
	[INFO] Copying ivy-2.4.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/ivy-2.4.0.jar
	[INFO] Copying guava-14.0.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/guava-14.0.1.jar
	[INFO] Copying jackson-core-asl-1.9.13.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-core-asl-1.9.13.jar
	[INFO] Copying hadoop-yarn-api-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-api-2.5.2.jar
	[INFO] Copying commons-jexl-2.1.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-jexl-2.1.1.jar
	[INFO] Copying httpclient-4.3.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/httpclient-4.3.2.jar
	[INFO] Copying avro-1.7.6.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-1.7.6.jar
	[INFO] Copying bdg-formats-0.6.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/bdg-formats-0.6.1.jar
	[INFO] Copying parquet-generator-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-generator-1.6.0.jar
	[INFO] Copying stream-2.7.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/stream-2.7.0.jar
	[INFO] Copying asm-3.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/asm-3.1.jar
	[INFO] Copying utils-misc_2.10-0.2.3.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-misc_2.10-0.2.3.jar
	[INFO] Copying hadoop-mapreduce-client-shuffle-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-shuffle-2.5.2.jar
	[INFO] Copying javax.servlet-3.0.0.v201112011016.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/javax.servlet-3.0.0.v201112011016.jar
	[INFO] Copying jcommander-1.27.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jcommander-1.27.jar
	[INFO] Copying api-asn1-api-1.0.0-M20.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/api-asn1-api-1.0.0-M20.jar
	[INFO] Copying curator-recipes-2.4.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/curator-recipes-2.4.0.jar
	[INFO] Copying uncommons-maths-1.2.2a.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/uncommons-maths-1.2.2a.jar
	[INFO] Copying parquet-hadoop-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-hadoop-1.6.0.jar
	[INFO] Copying api-util-1.0.0-M20.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/api-util-1.0.0-M20.jar
	[INFO] Copying xz-1.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/xz-1.0.jar
	[INFO] Copying commons-logging-1.1.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-logging-1.1.1.jar
	[INFO] Copying avro-ipc-1.7.7.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-ipc-1.7.7.jar
	[INFO] Copying akka-remote_2.10-2.3.11.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/akka-remote_2.10-2.3.11.jar
	[INFO] Copying htsjdk-1.133.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/htsjdk-1.133.jar
	[INFO] Copying kryo-2.21.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/kryo-2.21.jar
	[INFO] Copying commons-lang-2.6.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-lang-2.6.jar
	[INFO] Copying metrics-core-3.1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-core-3.1.2.jar
	[INFO] Copying reflectasm-1.07-shaded.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/reflectasm-1.07-shaded.jar
	[INFO] Copying jersey-core-1.9.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jersey-core-1.9.jar
	[INFO] Copying bcel-5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/bcel-5.2.jar
	[INFO] Copying parquet-common-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-common-1.8.1.jar
	[INFO] Copying jackson-mapper-asl-1.9.13.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-mapper-asl-1.9.13.jar
	[INFO] Copying leveldbjni-all-1.8.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/leveldbjni-all-1.8.jar
	[INFO] Copying snappy-java-1.1.1.7.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/snappy-java-1.1.1.7.jar
	[INFO] Copying hadoop-bam-7.0.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-bam-7.0.0.jar
	[INFO] Copying jetty-util-6.1.26.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jetty-util-6.1.26.jar
	[INFO] Copying annotations-2.0.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/annotations-2.0.0.jar
	[INFO] Copying objenesis-1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/objenesis-1.2.jar
	[INFO] Copying log4j-1.2.17.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/log4j-1.2.17.jar
	[INFO] Copying netty-3.6.2.Final.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/netty-3.6.2.Final.jar
	[INFO] Copying commons-digester-1.8.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-digester-1.8.jar
	[INFO] Copying activation-1.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/activation-1.1.jar
	[INFO] Copying parquet-format-2.3.0-incubating.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-format-2.3.0-incubating.jar
	[INFO] Copying parquet-jackson-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-jackson-1.6.0.jar
	[INFO] Copying metrics-json-3.1.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-json-3.1.2.jar
	[INFO] Copying xmlenc-0.52.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/xmlenc-0.52.jar
	[INFO] Copying tachyon-underfs-hdfs-0.7.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/tachyon-underfs-hdfs-0.7.1.jar
	[INFO] Copying fastutil-6.5.7.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/fastutil-6.5.7.jar
	[INFO] Copying parquet-hadoop-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-hadoop-1.8.1.jar
	[INFO] Copying jets3t-0.7.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jets3t-0.7.1.jar
	[INFO] Copying hadoop-annotations-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-annotations-2.5.2.jar
	[INFO] Copying commons-beanutils-core-1.8.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-beanutils-core-1.8.0.jar
	[INFO] Copying hadoop-mapreduce-client-core-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-core-2.5.2.jar
	[INFO] Copying jackson-module-scala_2.10-2.4.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-module-scala_2.10-2.4.4.jar
	[INFO] Copying py4j-0.8.2.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/py4j-0.8.2.1.jar
	[INFO] Copying json4s-ast_2.10-3.2.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/json4s-ast_2.10-3.2.10.jar
	[INFO] Copying slf4j-api-1.7.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/slf4j-api-1.7.10.jar
	[INFO] Copying servo-core-0.5.5.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/servo-core-0.5.5.jar
	[INFO] Copying commons-io-1.3.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-io-1.3.2.jar
	[INFO] Copying apacheds-kerberos-codec-2.0.0-M15.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/apacheds-kerberos-codec-2.0.0-M15.jar
	[INFO] Copying htsjdk-1.118.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/htsjdk-1.118.jar
	[INFO] Copying hadoop-yarn-common-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-common-2.5.2.jar
	[INFO] Copying unused-1.0.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/unused-1.0.0.jar
	[INFO] Copying chill-java-0.5.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/chill-java-0.5.0.jar
	[INFO] Copying jsr305-1.3.9.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jsr305-1.3.9.jar
	[INFO] Copying jaxb-api-2.2.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jaxb-api-2.2.2.jar
	[INFO] Copying apacheds-i18n-2.0.0-M15.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/apacheds-i18n-2.0.0-M15.jar
	[INFO] Copying commons-lang3-3.3.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-lang3-3.3.2.jar
	[INFO] Copying cofoja-1.1-r150.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/cofoja-1.1-r150.jar
	[INFO] Copying parquet-jackson-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-jackson-1.8.1.jar
	[INFO] Copying commons-collections-3.2.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-collections-3.2.1.jar
	[INFO] Copying jersey-client-1.9.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jersey-client-1.9.jar
	[INFO] Copying mesos-0.21.1-shaded-protobuf.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/mesos-0.21.1-shaded-protobuf.jar
	[INFO] Copying pyrolite-4.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/pyrolite-4.4.jar
	[INFO] Copying jackson-databind-2.4.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-databind-2.4.4.jar
	[INFO] Copying lz4-1.3.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/lz4-1.3.0.jar
	[INFO] Copying hadoop-yarn-client-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-client-2.5.2.jar
	[INFO] Copying scalac-scoverage-plugin_2.10-1.1.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scalac-scoverage-plugin_2.10-1.1.1.jar
	[INFO] Copying commons-configuration-1.6.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-configuration-1.6.jar
	[INFO] Copying httpcore-4.3.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/httpcore-4.3.1.jar
	[INFO] Copying hadoop-mapreduce-client-jobclient-2.5.2.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-jobclient-2.5.2.jar
	[INFO] Copying jackson-core-2.4.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-core-2.4.4.jar
	[INFO] Copying slf4j-log4j12-1.7.10.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/slf4j-log4j12-1.7.10.jar
	[INFO] Copying spark-launcher_2.10-1.5.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-launcher_2.10-1.5.1.jar
	[INFO] Copying parquet-avro-1.8.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-avro-1.8.1.jar
	[INFO] Copying chill_2.10-0.5.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/chill_2.10-0.5.0.jar
	[INFO] Copying akka-actor_2.10-2.3.11.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/akka-actor_2.10-2.3.11.jar
	[INFO] Copying jersey-server-1.9.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jersey-server-1.9.jar
	[INFO] Copying asm-4.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/asm-4.0.jar
	[INFO] Copying scala-library-2.10.4.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scala-library-2.10.4.jar
	[INFO] Copying parquet-column-1.6.0.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-column-1.6.0.jar
	[INFO] Copying spark-network-shuffle_2.10-1.5.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-network-shuffle_2.10-1.5.1.jar
	[INFO] Copying RoaringBitmap-0.4.5.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/RoaringBitmap-0.4.5.jar
	[INFO] Copying netty-all-4.0.29.Final.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/netty-all-4.0.29.Final.jar
	[INFO] Copying tachyon-client-0.7.1.jar to /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/tachyon-client-0.7.1.jar
	[INFO] 
	[INFO] --- maven-shade-plugin:3.0.0:shade (default) @ cloud-scale-bwamem ---
	Downloading: https://repo1.maven.org/maven2/commons-io/commons-io/2.5/commons-io-2.5.pom
	Downloading: http://scala-tools.org/repo-releases/commons-io/commons-io/2.5/commons-io-2.5.pom
	Downloading: https://repo1.maven.org/maven2/com/google/guava/guava/19.0/guava-19.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/google/guava/guava/19.0/guava-19.0.pom
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 02:48 min
	[INFO] Finished at: 2017-02-22T12:08:27+08:00
	[INFO] Final Memory: 53M/809M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal org.apache.maven.plugins:maven-shade-plugin:3.0.0:shade (default) on project cloud-scale-bwamem: Execution default of goal org.apache.maven.plugins:maven-shade-plugin:3.0.0:shade failed: Plugin org.apache.maven.plugins:maven-shade-plugin:3.0.0 or one of its dependencies could not be resolved: Failed to collect dependencies at org.apache.maven.plugins:maven-shade-plugin:jar:3.0.0 -> commons-io:commons-io:jar:2.5: Failed to read artifact descriptor for commons-io:commons-io:jar:2.5: Could not transfer artifact commons-io:commons-io:pom:2.5 from/to central (https://repo1.maven.org/maven2): repo1.maven.org: Name or service not known: Unknown host repo1.maven.org: Name or service not known -> [Help 1]
	[ERROR] 
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR] 
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginResolutionException
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:jniNative:so:0.2.2
	[WARNING] 'dependencies.dependency.systemPath' for cs.ucla.edu:cloud-scale-bwamem:jar should use a variable instead of a hard-coded path /curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar @ line 19, column 19
	[WARNING] 'build.plugins.plugin.version' for org.codehaus.mojo:native-maven-plugin is missing. @ line 33, column 15
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 25, column 15
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building JNI Pair-End Smith-Waterman AVX Library 0.2.2
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:initialize (default-initialize) @ jniNative ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:unzipinc (default-unzipinc) @ jniNative ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (default-javah) @ jniNative ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (javah) @ jniNative ---
	[INFO] /bin/sh -c cd /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target && javah -o /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/custom-javah/jni_mate_sw.h -classpath /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes:/curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar cs.ucla.edu.bwaspark.jni.HelloWorld cs.ucla.edu.bwaspark.jni.MateSWType cs.ucla.edu.bwaspark.jni.SeqSWType cs.ucla.edu.bwaspark.jni.MateSWJNI cs.ucla.edu.bwaspark.datatype.MemAlnRegType cs.ucla.edu.bwaspark.datatype.MemOptType cs.ucla.edu.bwaspark.datatype.MemPeStat cs.ucla.edu.bwaspark.datatype.FASTQSingleNode
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature': class file for scala.reflect.ScalaSignature not found
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Error: Class scala.Serializable could not be found.
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 4.624 s
	[INFO] Finished at: 2017-02-22T12:08:35+08:00
	[INFO] Final Memory: 8M/452M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal org.codehaus.mojo:native-maven-plugin:1.0-alpha-8:javah (javah) on project jniNative: Error running javah command: Error executing command line. Exit code:1 -> [Help 1]
	[ERROR] 
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR] 
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:jniSWExtend:so:0.2.2
	[WARNING] 'dependencies.dependency.systemPath' for cs.ucla.edu:cloud-scale-bwamem:jar should use a variable instead of a hard-coded path /curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar @ line 19, column 19
	[WARNING] 'build.plugins.plugin.version' for org.codehaus.mojo:native-maven-plugin is missing. @ line 33, column 15
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 25, column 15
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building JNI Smith-Waterman Extend on FPGA 0.2.2
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:initialize (default-initialize) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:unzipinc (default-unzipinc) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (default-javah) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (javah) @ jniSWExtend ---
	[INFO] /bin/sh -c cd /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target && javah -o /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/custom-javah/jni_sw_extend.h -classpath /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes:/curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar cs.ucla.edu.bwaspark.jni.SWExtendFPGAJNI
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature': class file for scala.reflect.ScalaSignature not found
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:compile (default-compile) @ jniSWExtend ---
	[INFO] /bin/sh -c cd /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga && gcc -s -fPIC -O2 -I/home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga -I/home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/custom-javah -I/usr/lib/jvm/jdk1.7.0/jre/../include -I/usr/lib/jvm/jdk1.7.0/jre/../include/linux -o/home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/objs/sw_extend_fpga.o -c /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga/sw_extend_fpga.c
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:link (default-link) @ jniSWExtend ---
	[INFO] /bin/sh -c cd /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga && gcc -shared -lrt -o/home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/jniSWExtend.so /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/target/objs/sw_extend_fpga.o
	[INFO] 
	[INFO] --- maven-resources-plugin:3.0.0:testResources (default-testResources) @ jniSWExtend ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/hadoop/disk2/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.5.1:testCompile (default-testCompile) @ jniSWExtend ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.19.1:test (default-test) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:inczip (default-inczip) @ jniSWExtend ---
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 6.468 s
	[INFO] Finished at: 2017-02-22T12:08:44+08:00
	[INFO] Final Memory: 14M/570M
	[INFO] ------------------------------------------------------------------------
	
	
	xubo节点：
	
	
	xubo@xubo:~/xubo/tools/cloud-scale-bwamem-0.2.2$ ./compile.pl 
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:cloud-scale-bwamem:jar:0.2.2
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-shade-plugin is missing. @ line 151, column 21
	[WARNING] 'build.plugins.plugin.version' for org.scala-tools:maven-scala-plugin is missing. @ line 95, column 21
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Cloud-Scale-BWAMEM 0.2.2
	[INFO] ------------------------------------------------------------------------
	Downloading: http://scala-tools.org/repo-releases/org/scala-tools/maven-scala-plugin/maven-metadata.xml
	[WARNING] Could not transfer metadata org.scala-tools:maven-scala-plugin/maven-metadata.xml from/to scala-tools.org (http://scala-tools.org/repo-releases): scala-tools.org: Name or service not known
	Downloading: http://scala-tools.org/repo-releases/org/apache/maven/plugins/maven-shade-plugin/maven-metadata.xml
	[WARNING] Could not transfer metadata org.apache.maven.plugins:maven-shade-plugin/maven-metadata.xml from/to scala-tools.org (http://scala-tools.org/repo-releases): scala-tools.org
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ cloud-scale-bwamem ---
	[INFO] Deleting /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:schema (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:protocol (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:idl-protocol (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ cloud-scale-bwamem ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (default) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.2 requires scala version: 2.10.4
	[WARNING]  com.twitter:chill_2.10:0.5.0 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-remote_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-actor_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-slf4j_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  org.apache.spark:spark-core_2.10:1.5.1 requires scala version: 2.10.4
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/java:-1: info: compiling
	[INFO] /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/scala:-1: info: compiling
	[INFO] Compiling 77 source files to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes at 1487745384066
	[WARNING] warning: there were 22 deprecation warning(s); re-run with -deprecation for details
	[WARNING] warning: there were 1 feature warning(s); re-run with -feature for details
	[WARNING] two warnings found
	[INFO] prepare-compile in 0 s
	[INFO] compile in 49 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ cloud-scale-bwamem ---
	[INFO] Changes detected - recompiling the module!
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 8 source files to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (compile) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.2 requires scala version: 2.10.4
	[WARNING]  com.twitter:chill_2.10:0.5.0 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-remote_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-actor_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-slf4j_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  org.apache.spark:spark-core_2.10:1.5.1 requires scala version: 2.10.4
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ cloud-scale-bwamem ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ cloud-scale-bwamem ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:testCompile (test-compile) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.2 requires scala version: 2.10.4
	[WARNING]  com.twitter:chill_2.10:0.5.0 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-remote_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-actor_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  com.typesafe.akka:akka-slf4j_2.10:2.3.11 requires scala version: 2.10.4
	[WARNING]  org.apache.spark:spark-core_2.10:1.5.1 requires scala version: 2.10.4
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[WARNING] No source files found.
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ cloud-scale-bwamem ---
	[INFO] Building jar: /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/cloud-scale-bwamem-0.2.2.jar
	[INFO] 
	[INFO] --- maven-dependency-plugin:2.8:copy-dependencies (default) @ cloud-scale-bwamem ---
	[INFO] Copying jackson-annotations-2.4.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-annotations-2.4.0.jar
	[INFO] Copying protobuf-java-2.5.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/protobuf-java-2.5.0.jar
	[INFO] Copying oro-2.0.8.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/oro-2.0.8.jar
	[INFO] Copying adam-core_2.10-0.18.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/adam-core_2.10-0.18.0.jar
	[INFO] Copying jul-to-slf4j-1.7.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jul-to-slf4j-1.7.10.jar
	[INFO] Copying jcl-over-slf4j-1.7.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jcl-over-slf4j-1.7.10.jar
	[INFO] Copying parquet-common-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-common-1.6.0.jar
	[INFO] Copying curator-client-2.1.0-incubating.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/curator-client-2.1.0-incubating.jar
	[INFO] Copying testng-6.8.8.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/testng-6.8.8.jar
	[INFO] Copying hadoop-mapreduce-client-app-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-app-2.5.2.jar
	[INFO] Copying jakarta-regexp-1.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jakarta-regexp-1.4.jar
	[INFO] Copying tachyon-underfs-local-0.7.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/tachyon-underfs-local-0.7.1.jar
	[INFO] Copying ant-1.8.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/ant-1.8.2.jar
	[INFO] Copying scalap-2.10.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scalap-2.10.0.jar
	[INFO] Copying parquet-encoding-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-encoding-1.8.1.jar
	[INFO] Copying hadoop-auth-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-auth-2.5.2.jar
	[INFO] Copying hadoop-yarn-server-common-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-server-common-2.5.2.jar
	[INFO] Copying scala-compiler-2.10.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scala-compiler-2.10.0.jar
	[INFO] Copying akka-slf4j_2.10-2.3.11.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/akka-slf4j_2.10-2.3.11.jar
	[INFO] Copying commons-beanutils-1.7.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-beanutils-1.7.0.jar
	[INFO] Copying hadoop-client-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-client-2.5.2.jar
	[INFO] Copying metrics-jvm-3.1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-jvm-3.1.2.jar
	[INFO] Copying ant-launcher-1.8.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/ant-launcher-1.8.2.jar
	[INFO] Copying parquet-encoding-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-encoding-1.6.0.jar
	[INFO] Copying metrics-graphite-3.1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-graphite-3.1.2.jar
	[INFO] Copying commons-httpclient-3.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-httpclient-3.1.jar
	[INFO] Copying avro-ipc-1.7.7-tests.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-ipc-1.7.7-tests.jar
	[INFO] Copying paranamer-2.3.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/paranamer-2.3.jar
	[INFO] Copying curator-framework-2.4.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/curator-framework-2.4.0.jar
	[INFO] Copying parquet-format-2.2.0-rc1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-format-2.2.0-rc1.jar
	[INFO] Copying scala-reflect-2.10.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scala-reflect-2.10.4.jar
	[INFO] Copying commons-cli-1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-cli-1.2.jar
	[INFO] Copying stax-api-1.0-2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/stax-api-1.0-2.jar
	[INFO] Copying compress-lzf-1.0.3.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/compress-lzf-1.0.3.jar
	[INFO] Copying utils-io_2.10-0.2.3.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-io_2.10-0.2.3.jar
	[INFO] Copying parquet-column-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-column-1.8.1.jar
	[INFO] Copying utils-metrics_2.10-0.2.3.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-metrics_2.10-0.2.3.jar
	[INFO] Copying spark-network-common_2.10-1.5.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-network-common_2.10-1.5.1.jar
	[INFO] Copying utils-cli_2.10-0.2.3.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-cli_2.10-0.2.3.jar
	[INFO] Copying zookeeper-3.4.6.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/zookeeper-3.4.6.jar
	[INFO] Copying json4s-jackson_2.10-3.2.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/json4s-jackson_2.10-3.2.10.jar
	[INFO] Copying spark-core_2.10-1.5.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-core_2.10-1.5.1.jar
	[INFO] Copying hadoop-mapreduce-client-common-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-common-2.5.2.jar
	[INFO] Copying commons-compress-1.4.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-compress-1.4.1.jar
	[INFO] Copying hadoop-hdfs-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-hdfs-2.5.2.jar
	[INFO] Copying minlog-1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/minlog-1.2.jar
	[INFO] Copying spark-unsafe_2.10-1.5.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-unsafe_2.10-1.5.1.jar
	[INFO] Copying avro-mapred-1.7.7-hadoop2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-mapred-1.7.7-hadoop2.jar
	[INFO] Copying parquet-scala_2.10-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-scala_2.10-1.8.1.jar
	[INFO] Copying commons-math3-3.4.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-math3-3.4.1.jar
	[INFO] Copying commons-codec-1.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-codec-1.4.jar
	[INFO] Copying hadoop-common-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-common-2.5.2.jar
	[INFO] Copying json4s-core_2.10-3.2.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/json4s-core_2.10-3.2.10.jar
	[INFO] Copying commons-net-2.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-net-2.2.jar
	[INFO] Copying config-1.2.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/config-1.2.1.jar
	[INFO] Copying args4j-2.0.23.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/args4j-2.0.23.jar
	[INFO] Copying parquet-avro-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-avro-1.6.0.jar
	[INFO] Copying bsh-2.0b4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/bsh-2.0b4.jar
	[INFO] Copying ivy-2.4.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/ivy-2.4.0.jar
	[INFO] Copying guava-14.0.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/guava-14.0.1.jar
	[INFO] Copying jackson-core-asl-1.9.13.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-core-asl-1.9.13.jar
	[INFO] Copying hadoop-yarn-api-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-api-2.5.2.jar
	[INFO] Copying commons-jexl-2.1.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-jexl-2.1.1.jar
	[INFO] Copying httpclient-4.3.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/httpclient-4.3.2.jar
	[INFO] Copying avro-1.7.6.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-1.7.6.jar
	[INFO] Copying bdg-formats-0.6.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/bdg-formats-0.6.1.jar
	[INFO] Copying parquet-generator-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-generator-1.6.0.jar
	[INFO] Copying stream-2.7.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/stream-2.7.0.jar
	[INFO] Copying asm-3.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/asm-3.1.jar
	[INFO] Copying utils-misc_2.10-0.2.3.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/utils-misc_2.10-0.2.3.jar
	[INFO] Copying hadoop-mapreduce-client-shuffle-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-shuffle-2.5.2.jar
	[INFO] Copying javax.servlet-3.0.0.v201112011016.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/javax.servlet-3.0.0.v201112011016.jar
	[INFO] Copying jcommander-1.27.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jcommander-1.27.jar
	[INFO] Copying api-asn1-api-1.0.0-M20.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/api-asn1-api-1.0.0-M20.jar
	[INFO] Copying curator-recipes-2.4.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/curator-recipes-2.4.0.jar
	[INFO] Copying uncommons-maths-1.2.2a.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/uncommons-maths-1.2.2a.jar
	[INFO] Copying parquet-hadoop-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-hadoop-1.6.0.jar
	[INFO] Copying api-util-1.0.0-M20.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/api-util-1.0.0-M20.jar
	[INFO] Copying xz-1.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/xz-1.0.jar
	[INFO] Copying commons-logging-1.1.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-logging-1.1.1.jar
	[INFO] Copying avro-ipc-1.7.7.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/avro-ipc-1.7.7.jar
	[INFO] Copying akka-remote_2.10-2.3.11.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/akka-remote_2.10-2.3.11.jar
	[INFO] Copying htsjdk-1.133.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/htsjdk-1.133.jar
	[INFO] Copying kryo-2.21.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/kryo-2.21.jar
	[INFO] Copying commons-lang-2.6.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-lang-2.6.jar
	[INFO] Copying metrics-core-3.1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-core-3.1.2.jar
	[INFO] Copying reflectasm-1.07-shaded.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/reflectasm-1.07-shaded.jar
	[INFO] Copying jersey-core-1.9.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jersey-core-1.9.jar
	[INFO] Copying bcel-5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/bcel-5.2.jar
	[INFO] Copying parquet-common-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-common-1.8.1.jar
	[INFO] Copying jackson-mapper-asl-1.9.13.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-mapper-asl-1.9.13.jar
	[INFO] Copying leveldbjni-all-1.8.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/leveldbjni-all-1.8.jar
	[INFO] Copying snappy-java-1.1.1.7.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/snappy-java-1.1.1.7.jar
	[INFO] Copying hadoop-bam-7.0.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-bam-7.0.0.jar
	[INFO] Copying jetty-util-6.1.26.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jetty-util-6.1.26.jar
	[INFO] Copying annotations-2.0.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/annotations-2.0.0.jar
	[INFO] Copying objenesis-1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/objenesis-1.2.jar
	[INFO] Copying log4j-1.2.17.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/log4j-1.2.17.jar
	[INFO] Copying netty-3.6.2.Final.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/netty-3.6.2.Final.jar
	[INFO] Copying commons-digester-1.8.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-digester-1.8.jar
	[INFO] Copying activation-1.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/activation-1.1.jar
	[INFO] Copying parquet-format-2.3.0-incubating.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-format-2.3.0-incubating.jar
	[INFO] Copying parquet-jackson-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-jackson-1.6.0.jar
	[INFO] Copying metrics-json-3.1.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/metrics-json-3.1.2.jar
	[INFO] Copying xmlenc-0.52.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/xmlenc-0.52.jar
	[INFO] Copying tachyon-underfs-hdfs-0.7.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/tachyon-underfs-hdfs-0.7.1.jar
	[INFO] Copying fastutil-6.5.7.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/fastutil-6.5.7.jar
	[INFO] Copying parquet-hadoop-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-hadoop-1.8.1.jar
	[INFO] Copying jets3t-0.7.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jets3t-0.7.1.jar
	[INFO] Copying hadoop-annotations-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-annotations-2.5.2.jar
	[INFO] Copying commons-beanutils-core-1.8.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-beanutils-core-1.8.0.jar
	[INFO] Copying hadoop-mapreduce-client-core-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-core-2.5.2.jar
	[INFO] Copying jackson-module-scala_2.10-2.4.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-module-scala_2.10-2.4.4.jar
	[INFO] Copying py4j-0.8.2.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/py4j-0.8.2.1.jar
	[INFO] Copying json4s-ast_2.10-3.2.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/json4s-ast_2.10-3.2.10.jar
	[INFO] Copying slf4j-api-1.7.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/slf4j-api-1.7.10.jar
	[INFO] Copying servo-core-0.5.5.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/servo-core-0.5.5.jar
	[INFO] Copying commons-io-1.3.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-io-1.3.2.jar
	[INFO] Copying apacheds-kerberos-codec-2.0.0-M15.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/apacheds-kerberos-codec-2.0.0-M15.jar
	[INFO] Copying htsjdk-1.118.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/htsjdk-1.118.jar
	[INFO] Copying hadoop-yarn-common-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-common-2.5.2.jar
	[INFO] Copying unused-1.0.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/unused-1.0.0.jar
	[INFO] Copying chill-java-0.5.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/chill-java-0.5.0.jar
	[INFO] Copying jsr305-1.3.9.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jsr305-1.3.9.jar
	[INFO] Copying jaxb-api-2.2.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jaxb-api-2.2.2.jar
	[INFO] Copying apacheds-i18n-2.0.0-M15.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/apacheds-i18n-2.0.0-M15.jar
	[INFO] Copying commons-lang3-3.3.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-lang3-3.3.2.jar
	[INFO] Copying cofoja-1.1-r150.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/cofoja-1.1-r150.jar
	[INFO] Copying parquet-jackson-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-jackson-1.8.1.jar
	[INFO] Copying commons-collections-3.2.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-collections-3.2.1.jar
	[INFO] Copying jersey-client-1.9.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jersey-client-1.9.jar
	[INFO] Copying mesos-0.21.1-shaded-protobuf.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/mesos-0.21.1-shaded-protobuf.jar
	[INFO] Copying pyrolite-4.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/pyrolite-4.4.jar
	[INFO] Copying jackson-databind-2.4.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-databind-2.4.4.jar
	[INFO] Copying lz4-1.3.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/lz4-1.3.0.jar
	[INFO] Copying hadoop-yarn-client-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-yarn-client-2.5.2.jar
	[INFO] Copying scalac-scoverage-plugin_2.10-1.1.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scalac-scoverage-plugin_2.10-1.1.1.jar
	[INFO] Copying commons-configuration-1.6.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/commons-configuration-1.6.jar
	[INFO] Copying httpcore-4.3.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/httpcore-4.3.1.jar
	[INFO] Copying hadoop-mapreduce-client-jobclient-2.5.2.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/hadoop-mapreduce-client-jobclient-2.5.2.jar
	[INFO] Copying jackson-core-2.4.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jackson-core-2.4.4.jar
	[INFO] Copying slf4j-log4j12-1.7.10.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/slf4j-log4j12-1.7.10.jar
	[INFO] Copying spark-launcher_2.10-1.5.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-launcher_2.10-1.5.1.jar
	[INFO] Copying parquet-avro-1.8.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-avro-1.8.1.jar
	[INFO] Copying chill_2.10-0.5.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/chill_2.10-0.5.0.jar
	[INFO] Copying akka-actor_2.10-2.3.11.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/akka-actor_2.10-2.3.11.jar
	[INFO] Copying jersey-server-1.9.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/jersey-server-1.9.jar
	[INFO] Copying asm-4.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/asm-4.0.jar
	[INFO] Copying scala-library-2.10.4.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/scala-library-2.10.4.jar
	[INFO] Copying parquet-column-1.6.0.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/parquet-column-1.6.0.jar
	[INFO] Copying spark-network-shuffle_2.10-1.5.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/spark-network-shuffle_2.10-1.5.1.jar
	[INFO] Copying RoaringBitmap-0.4.5.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/RoaringBitmap-0.4.5.jar
	[INFO] Copying netty-all-4.0.29.Final.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/netty-all-4.0.29.Final.jar
	[INFO] Copying tachyon-client-0.7.1.jar to /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/lib/tachyon-client-0.7.1.jar
	[INFO] 
	[INFO] --- maven-shade-plugin:3.0.0:shade (default) @ cloud-scale-bwamem ---
	Downloading: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.0/maven-artifact-transfer-0.9.0.pom
	Downloaded: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.0/maven-artifact-transfer-0.9.0.pom (8 KB at 3.1 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/3.0.0/maven-common-artifact-filters-3.0.0.pom
	Downloaded: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/3.0.0/maven-common-artifact-filters-3.0.0.pom (5 KB at 3.2 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-shared-components/22/maven-shared-components-22.pom
	Downloaded: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-shared-components/22/maven-shared-components-22.pom (5 KB at 8.1 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm/5.1/asm-5.1.pom
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm/5.1/asm-5.1.pom (2 KB at 1.4 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm-parent/5.1/asm-parent-5.1.pom
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm-parent/5.1/asm-parent-5.1.pom (6 KB at 9.0 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm-commons/5.1/asm-commons-5.1.pom
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm-commons/5.1/asm-commons-5.1.pom (3 KB at 1.6 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm-tree/5.1/asm-tree-5.1.pom
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm-tree/5.1/asm-tree-5.1.pom (3 KB at 3.6 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/jdom/jdom/1.1.3/jdom-1.1.3.pom
	Downloaded: https://repo1.maven.org/maven2/org/jdom/jdom/1.1.3/jdom-1.1.3.pom (2 KB at 1.3 KB/sec)
	Downloading: https://repo1.maven.org/maven2/com/google/guava/guava/19.0/guava-19.0.pom
	Downloaded: https://repo1.maven.org/maven2/com/google/guava/guava/19.0/guava-19.0.pom (7 KB at 7.6 KB/sec)
	Downloading: https://repo1.maven.org/maven2/com/google/guava/guava-parent/19.0/guava-parent-19.0.pom
	Downloaded: https://repo1.maven.org/maven2/com/google/guava/guava-parent/19.0/guava-parent-19.0.pom (10 KB at 11.4 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.0/maven-artifact-transfer-0.9.0.jar
	Downloading: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/3.0.0/maven-common-artifact-filters-3.0.0.jar
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm/5.1/asm-5.1.jar
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm-commons/5.1/asm-commons-5.1.jar
	Downloading: https://repo1.maven.org/maven2/org/ow2/asm/asm-tree/5.1/asm-tree-5.1.jar
	Downloaded: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/3.0.0/maven-common-artifact-filters-3.0.0.jar (56 KB at 29.5 KB/sec)
	Downloading: https://repo1.maven.org/maven2/org/jdom/jdom/1.1.3/jdom-1.1.3.jar
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm-commons/5.1/asm-commons-5.1.jar (47 KB at 23.3 KB/sec)
	Downloading: https://repo1.maven.org/maven2/com/google/guava/guava/19.0/guava-19.0.jar
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm-tree/5.1/asm-tree-5.1.jar (29 KB at 11.8 KB/sec)
	Downloaded: https://repo1.maven.org/maven2/org/ow2/asm/asm/5.1/asm-5.1.jar (53 KB at 20.7 KB/sec)
	Downloaded: https://repo1.maven.org/maven2/org/jdom/jdom/1.1.3/jdom-1.1.3.jar (148 KB at 49.2 KB/sec)
	Downloaded: https://repo1.maven.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.0/maven-artifact-transfer-0.9.0.jar (121 KB at 29.3 KB/sec)
	Downloaded: https://repo1.maven.org/maven2/com/google/guava/guava/19.0/guava-19.0.jar (2255 KB at 63.2 KB/sec)
	[INFO] Including org.scala-lang:scala-library:jar:2.10.4 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-client:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-common:jar:2.5.2 in the shaded jar.
	[INFO] Including commons-cli:commons-cli:jar:1.2 in the shaded jar.
	[INFO] Including xmlenc:xmlenc:jar:0.52 in the shaded jar.
	[INFO] Including commons-httpclient:commons-httpclient:jar:3.1 in the shaded jar.
	[INFO] Including commons-codec:commons-codec:jar:1.4 in the shaded jar.
	[INFO] Including commons-collections:commons-collections:jar:3.2.1 in the shaded jar.
	[INFO] Including commons-lang:commons-lang:jar:2.6 in the shaded jar.
	[INFO] Including commons-configuration:commons-configuration:jar:1.6 in the shaded jar.
	[INFO] Including commons-digester:commons-digester:jar:1.8 in the shaded jar.
	[INFO] Including commons-beanutils:commons-beanutils:jar:1.7.0 in the shaded jar.
	[INFO] Including commons-beanutils:commons-beanutils-core:jar:1.8.0 in the shaded jar.
	[INFO] Including com.google.protobuf:protobuf-java:jar:2.5.0 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-auth:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.directory.server:apacheds-kerberos-codec:jar:2.0.0-M15 in the shaded jar.
	[INFO] Including org.apache.directory.server:apacheds-i18n:jar:2.0.0-M15 in the shaded jar.
	[INFO] Including org.apache.directory.api:api-asn1-api:jar:1.0.0-M20 in the shaded jar.
	[INFO] Including org.apache.directory.api:api-util:jar:1.0.0-M20 in the shaded jar.
	[INFO] Including org.apache.zookeeper:zookeeper:jar:3.4.6 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-hdfs:jar:2.5.2 in the shaded jar.
	[INFO] Including org.mortbay.jetty:jetty-util:jar:6.1.26 in the shaded jar.
	[INFO] Including io.netty:netty:jar:3.6.2.Final in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-mapreduce-client-app:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-mapreduce-client-common:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-yarn-client:jar:2.5.2 in the shaded jar.
	[INFO] Including com.sun.jersey:jersey-client:jar:1.9 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-yarn-server-common:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-mapreduce-client-shuffle:jar:2.5.2 in the shaded jar.
	[INFO] Including org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-yarn-api:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-mapreduce-client-core:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-yarn-common:jar:2.5.2 in the shaded jar.
	[INFO] Including javax.xml.bind:jaxb-api:jar:2.2.2 in the shaded jar.
	[INFO] Including javax.xml.stream:stax-api:jar:1.0-2 in the shaded jar.
	[INFO] Including javax.activation:activation:jar:1.1 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-mapreduce-client-jobclient:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.hadoop:hadoop-annotations:jar:2.5.2 in the shaded jar.
	[INFO] Including org.apache.spark:spark-core_2.10:jar:1.5.1 in the shaded jar.
	[INFO] Including org.apache.avro:avro-mapred:jar:hadoop2:1.7.7 in the shaded jar.
	[INFO] Including org.apache.avro:avro-ipc:jar:1.7.7 in the shaded jar.
	[INFO] Including org.apache.avro:avro-ipc:jar:tests:1.7.7 in the shaded jar.
	[INFO] Including com.twitter:chill_2.10:jar:0.5.0 in the shaded jar.
	[INFO] Including com.twitter:chill-java:jar:0.5.0 in the shaded jar.
	[INFO] Including org.apache.spark:spark-launcher_2.10:jar:1.5.1 in the shaded jar.
	[INFO] Including org.apache.spark:spark-network-common_2.10:jar:1.5.1 in the shaded jar.
	[INFO] Including org.apache.spark:spark-network-shuffle_2.10:jar:1.5.1 in the shaded jar.
	[INFO] Including org.apache.spark:spark-unsafe_2.10:jar:1.5.1 in the shaded jar.
	[INFO] Including net.java.dev.jets3t:jets3t:jar:0.7.1 in the shaded jar.
	[INFO] Including org.apache.curator:curator-recipes:jar:2.4.0 in the shaded jar.
	[INFO] Including org.apache.curator:curator-framework:jar:2.4.0 in the shaded jar.
	[INFO] Including org.eclipse.jetty.orbit:javax.servlet:jar:3.0.0.v201112011016 in the shaded jar.
	[INFO] Including org.apache.commons:commons-lang3:jar:3.3.2 in the shaded jar.
	[INFO] Including org.apache.commons:commons-math3:jar:3.4.1 in the shaded jar.
	[INFO] Including com.google.code.findbugs:jsr305:jar:1.3.9 in the shaded jar.
	[INFO] Including org.slf4j:slf4j-api:jar:1.7.10 in the shaded jar.
	[INFO] Including org.slf4j:jul-to-slf4j:jar:1.7.10 in the shaded jar.
	[INFO] Including org.slf4j:jcl-over-slf4j:jar:1.7.10 in the shaded jar.
	[INFO] Including log4j:log4j:jar:1.2.17 in the shaded jar.
	[INFO] Including org.slf4j:slf4j-log4j12:jar:1.7.10 in the shaded jar.
	[INFO] Including com.ning:compress-lzf:jar:1.0.3 in the shaded jar.
	[INFO] Including org.xerial.snappy:snappy-java:jar:1.1.1.7 in the shaded jar.
	[INFO] Including net.jpountz.lz4:lz4:jar:1.3.0 in the shaded jar.
	[INFO] Including org.roaringbitmap:RoaringBitmap:jar:0.4.5 in the shaded jar.
	[INFO] Including commons-net:commons-net:jar:2.2 in the shaded jar.
	[INFO] Including com.typesafe.akka:akka-remote_2.10:jar:2.3.11 in the shaded jar.
	[INFO] Including com.typesafe.akka:akka-actor_2.10:jar:2.3.11 in the shaded jar.
	[INFO] Including com.typesafe:config:jar:1.2.1 in the shaded jar.
	[INFO] Including org.uncommons.maths:uncommons-maths:jar:1.2.2a in the shaded jar.
	[INFO] Including com.typesafe.akka:akka-slf4j_2.10:jar:2.3.11 in the shaded jar.
	[INFO] Including org.json4s:json4s-jackson_2.10:jar:3.2.10 in the shaded jar.
	[INFO] Including org.json4s:json4s-core_2.10:jar:3.2.10 in the shaded jar.
	[INFO] Including org.json4s:json4s-ast_2.10:jar:3.2.10 in the shaded jar.
	[INFO] Including org.scala-lang:scalap:jar:2.10.0 in the shaded jar.
	[INFO] Including org.scala-lang:scala-compiler:jar:2.10.0 in the shaded jar.
	[INFO] Including com.sun.jersey:jersey-server:jar:1.9 in the shaded jar.
	[INFO] Including asm:asm:jar:3.1 in the shaded jar.
	[INFO] Including com.sun.jersey:jersey-core:jar:1.9 in the shaded jar.
	[INFO] Including org.apache.mesos:mesos:jar:shaded-protobuf:0.21.1 in the shaded jar.
	[INFO] Including io.netty:netty-all:jar:4.0.29.Final in the shaded jar.
	[INFO] Including com.clearspring.analytics:stream:jar:2.7.0 in the shaded jar.
	[INFO] Including io.dropwizard.metrics:metrics-core:jar:3.1.2 in the shaded jar.
	[INFO] Including io.dropwizard.metrics:metrics-jvm:jar:3.1.2 in the shaded jar.
	[INFO] Including io.dropwizard.metrics:metrics-json:jar:3.1.2 in the shaded jar.
	[INFO] Including io.dropwizard.metrics:metrics-graphite:jar:3.1.2 in the shaded jar.
	[INFO] Including com.fasterxml.jackson.core:jackson-databind:jar:2.4.4 in the shaded jar.
	[INFO] Including com.fasterxml.jackson.core:jackson-annotations:jar:2.4.0 in the shaded jar.
	[INFO] Including com.fasterxml.jackson.core:jackson-core:jar:2.4.4 in the shaded jar.
	[INFO] Including com.fasterxml.jackson.module:jackson-module-scala_2.10:jar:2.4.4 in the shaded jar.
	[INFO] Including org.scala-lang:scala-reflect:jar:2.10.4 in the shaded jar.
	[INFO] Including org.apache.ivy:ivy:jar:2.4.0 in the shaded jar.
	[INFO] Including oro:oro:jar:2.0.8 in the shaded jar.
	[INFO] Including org.tachyonproject:tachyon-client:jar:0.7.1 in the shaded jar.
	[INFO] Including org.apache.curator:curator-client:jar:2.1.0-incubating in the shaded jar.
	[INFO] Including org.tachyonproject:tachyon-underfs-hdfs:jar:0.7.1 in the shaded jar.
	[INFO] Including org.tachyonproject:tachyon-underfs-local:jar:0.7.1 in the shaded jar.
	[INFO] Including net.razorvine:pyrolite:jar:4.4 in the shaded jar.
	[INFO] Including net.sf.py4j:py4j:jar:0.8.2.1 in the shaded jar.
	[INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
	[INFO] Including org.apache.avro:avro:jar:1.7.6 in the shaded jar.
	[INFO] Including org.codehaus.jackson:jackson-core-asl:jar:1.9.13 in the shaded jar.
	[INFO] Including org.codehaus.jackson:jackson-mapper-asl:jar:1.9.13 in the shaded jar.
	[INFO] Including com.thoughtworks.paranamer:paranamer:jar:2.3 in the shaded jar.
	[INFO] Including org.apache.commons:commons-compress:jar:1.4.1 in the shaded jar.
	[INFO] Including org.tukaani:xz:jar:1.0 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-avro:jar:1.8.1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-column:jar:1.8.1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-common:jar:1.8.1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-encoding:jar:1.8.1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-hadoop:jar:1.8.1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-jackson:jar:1.8.1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-format:jar:2.3.0-incubating in the shaded jar.
	[INFO] Including it.unimi.dsi:fastutil:jar:6.5.7 in the shaded jar.
	[INFO] Including com.twitter:parquet-avro:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-column:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-common:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-encoding:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-generator:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-hadoop:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-jackson:jar:1.6.0 in the shaded jar.
	[INFO] Including com.twitter:parquet-format:jar:2.2.0-rc1 in the shaded jar.
	[INFO] Including org.apache.parquet:parquet-scala_2.10:jar:1.8.1 in the shaded jar.
	[INFO] Including org.bdgenomics.bdg-formats:bdg-formats:jar:0.6.1 in the shaded jar.
	[INFO] Including org.bdgenomics.adam:adam-core_2.10:jar:0.18.0 in the shaded jar.
	[INFO] Including org.bdgenomics.utils:utils-metrics_2.10:jar:0.2.3 in the shaded jar.
	[INFO] Including org.bdgenomics.utils:utils-misc_2.10:jar:0.2.3 in the shaded jar.
	[INFO] Including org.bdgenomics.utils:utils-io_2.10:jar:0.2.3 in the shaded jar.
	[INFO] Including org.bdgenomics.utils:utils-cli_2.10:jar:0.2.3 in the shaded jar.
	[INFO] Including args4j:args4j:jar:2.0.23 in the shaded jar.
	[INFO] Including com.esotericsoftware.kryo:kryo:jar:2.21 in the shaded jar.
	[INFO] Including com.esotericsoftware.reflectasm:reflectasm:jar:shaded:1.07 in the shaded jar.
	[INFO] Including org.ow2.asm:asm:jar:4.0 in the shaded jar.
	[INFO] Including com.esotericsoftware.minlog:minlog:jar:1.2 in the shaded jar.
	[INFO] Including org.objenesis:objenesis:jar:1.2 in the shaded jar.
	[INFO] Including org.scoverage:scalac-scoverage-plugin_2.10:jar:1.1.1 in the shaded jar.
	[INFO] Including commons-io:commons-io:jar:1.3.2 in the shaded jar.
	[INFO] Including org.seqdoop:hadoop-bam:jar:7.0.0 in the shaded jar.
	[INFO] Including com.github.samtools:htsjdk:jar:1.133 in the shaded jar.
	[INFO] Including org.apache.httpcomponents:httpclient:jar:4.3.2 in the shaded jar.
	[INFO] Including org.apache.httpcomponents:httpcore:jar:4.3.1 in the shaded jar.
	[INFO] Including com.netflix.servo:servo-core:jar:0.5.5 in the shaded jar.
	[INFO] Including com.google.code.findbugs:annotations:jar:2.0.0 in the shaded jar.
	[INFO] Including com.google.guava:guava:jar:14.0.1 in the shaded jar.
	[INFO] Including org.seqdoop:htsjdk:jar:1.118 in the shaded jar.
	[INFO] Including org.apache.ant:ant:jar:1.8.2 in the shaded jar.
	[INFO] Including org.apache.ant:ant-launcher:jar:1.8.2 in the shaded jar.
	[INFO] Including org.apache.bcel:bcel:jar:5.2 in the shaded jar.
	[INFO] Including jakarta-regexp:jakarta-regexp:jar:1.4 in the shaded jar.
	[INFO] Including org.seqdoop:cofoja:jar:1.1-r150 in the shaded jar.
	[INFO] Including org.apache.commons:commons-jexl:jar:2.1.1 in the shaded jar.
	[INFO] Including commons-logging:commons-logging:jar:1.1.1 in the shaded jar.
	[INFO] Including org.testng:testng:jar:6.8.8 in the shaded jar.
	[INFO] Including org.beanshell:bsh:jar:2.0b4 in the shaded jar.
	[INFO] Including com.beust:jcommander:jar:1.27 in the shaded jar.
	[WARNING] commons-beanutils-core-1.8.0.jar, commons-collections-3.2.1.jar, commons-beanutils-1.7.0.jar define 10 overlapping classes: 
	[WARNING]   - org.apache.commons.collections.FastHashMap$EntrySet
	[WARNING]   - org.apache.commons.collections.ArrayStack
	[WARNING]   - org.apache.commons.collections.FastHashMap$1
	[WARNING]   - org.apache.commons.collections.FastHashMap$KeySet
	[WARNING]   - org.apache.commons.collections.FastHashMap$CollectionView
	[WARNING]   - org.apache.commons.collections.BufferUnderflowException
	[WARNING]   - org.apache.commons.collections.Buffer
	[WARNING]   - org.apache.commons.collections.FastHashMap$CollectionView$CollectionViewIterator
	[WARNING]   - org.apache.commons.collections.FastHashMap$Values
	[WARNING]   - org.apache.commons.collections.FastHashMap
	[WARNING] minlog-1.2.jar, kryo-2.21.jar define 2 overlapping classes: 
	[WARNING]   - com.esotericsoftware.minlog.Log$Logger
	[WARNING]   - com.esotericsoftware.minlog.Log
	[WARNING] asm-4.0.jar, cofoja-1.1-r150.jar define 1 overlapping classes: 
	[WARNING]   - org.objectweb.asm.Handle
	[WARNING] objenesis-1.2.jar, kryo-2.21.jar define 32 overlapping classes: 
	[WARNING]   - org.objenesis.Objenesis
	[WARNING]   - org.objenesis.strategy.StdInstantiatorStrategy
	[WARNING]   - org.objenesis.instantiator.basic.ObjectStreamClassInstantiator
	[WARNING]   - org.objenesis.instantiator.sun.SunReflectionFactorySerializationInstantiator
	[WARNING]   - org.objenesis.instantiator.perc.PercSerializationInstantiator
	[WARNING]   - org.objenesis.instantiator.NullInstantiator
	[WARNING]   - org.objenesis.instantiator.jrockit.JRockitLegacyInstantiator
	[WARNING]   - org.objenesis.instantiator.gcj.GCJInstantiatorBase
	[WARNING]   - org.objenesis.ObjenesisException
	[WARNING]   - org.objenesis.instantiator.basic.ObjectInputStreamInstantiator$MockStream
	[WARNING]   - 22 more...
	[WARNING] htsjdk-1.133.jar, htsjdk-1.118.jar define 644 overlapping classes: 
	[WARNING]   - htsjdk.samtools.Bin
	[WARNING]   - htsjdk.samtools.util.ftp.FTPStream
	[WARNING]   - htsjdk.variant.variantcontext.VariantJEXLContext$11
	[WARNING]   - htsjdk.tribble.example.ProfileIndexReading
	[WARNING]   - htsjdk.tribble.index.tabix.TabixIndexCreator$TabixFeature
	[WARNING]   - htsjdk.samtools.SAMFileHeader
	[WARNING]   - htsjdk.samtools.util.CoordMath
	[WARNING]   - htsjdk.samtools.CoordinateSortedPairInfoMap$1
	[WARNING]   - htsjdk.tribble.readers.TabixReader$TIndex
	[WARNING]   - htsjdk.samtools.util.Tuple
	[WARNING]   - 634 more...
	[WARNING] reflectasm-1.07-shaded.jar, kryo-2.21.jar define 23 overlapping classes: 
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Opcodes
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Frame
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Label
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.FieldWriter
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.AnnotationVisitor
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.FieldVisitor
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Item
	[WARNING]   - com.esotericsoftware.reflectasm.AccessClassLoader
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.Edge
	[WARNING]   - com.esotericsoftware.reflectasm.shaded.org.objectweb.asm.ClassVisitor
	[WARNING]   - 13 more...
	[WARNING] parquet-format-2.3.0-incubating.jar, parquet-format-2.2.0-rc1.jar define 151 overlapping classes: 
	[WARNING]   - parquet.org.apache.thrift.protocol.TCompactProtocol$Types
	[WARNING]   - parquet.org.slf4j.helpers.BasicMarkerFactory
	[WARNING]   - parquet.org.apache.thrift.TSerializer
	[WARNING]   - parquet.org.apache.thrift.protocol.TJSONProtocol
	[WARNING]   - parquet.org.apache.thrift.protocol.TProtocolException
	[WARNING]   - parquet.org.apache.thrift.transport.TSaslTransport$NegotiationStatus
	[WARNING]   - parquet.org.apache.thrift.transport.TSeekableFile
	[WARNING]   - parquet.org.apache.thrift.TServiceClientFactory
	[WARNING]   - parquet.org.apache.thrift.transport.THttpClient
	[WARNING]   - parquet.org.slf4j.ILoggerFactory
	[WARNING]   - 141 more...
	[WARNING] hadoop-yarn-api-2.5.2.jar, hadoop-yarn-common-2.5.2.jar define 3 overlapping classes: 
	[WARNING]   - org.apache.hadoop.yarn.factories.package-info
	[WARNING]   - org.apache.hadoop.yarn.util.package-info
	[WARNING]   - org.apache.hadoop.yarn.factory.providers.package-info
	[WARNING] commons-logging-1.1.1.jar, jcl-over-slf4j-1.7.10.jar define 6 overlapping classes: 
	[WARNING]   - org.apache.commons.logging.impl.NoOpLog
	[WARNING]   - org.apache.commons.logging.impl.SimpleLog
	[WARNING]   - org.apache.commons.logging.LogFactory
	[WARNING]   - org.apache.commons.logging.LogConfigurationException
	[WARNING]   - org.apache.commons.logging.impl.SimpleLog$1
	[WARNING]   - org.apache.commons.logging.Log
	[WARNING] commons-beanutils-core-1.8.0.jar, commons-beanutils-1.7.0.jar define 82 overlapping classes: 
	[WARNING]   - org.apache.commons.beanutils.WrapDynaBean
	[WARNING]   - org.apache.commons.beanutils.Converter
	[WARNING]   - org.apache.commons.beanutils.converters.IntegerConverter
	[WARNING]   - org.apache.commons.beanutils.locale.LocaleBeanUtilsBean
	[WARNING]   - org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter
	[WARNING]   - org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter
	[WARNING]   - org.apache.commons.beanutils.converters.ShortConverter
	[WARNING]   - org.apache.commons.beanutils.converters.StringArrayConverter
	[WARNING]   - org.apache.commons.beanutils.locale.LocaleConvertUtilsBean
	[WARNING]   - org.apache.commons.beanutils.LazyDynaClass
	[WARNING]   - 72 more...
	[WARNING] annotations-2.0.0.jar, jsr305-1.3.9.jar define 34 overlapping classes: 
	[WARNING]   - javax.annotation.Nonnegative
	[WARNING]   - javax.annotation.CheckForSigned
	[WARNING]   - javax.annotation.CheckForNull
	[WARNING]   - javax.annotation.Tainted
	[WARNING]   - javax.annotation.meta.TypeQualifierValidator
	[WARNING]   - javax.annotation.meta.TypeQualifier
	[WARNING]   - javax.annotation.Syntax
	[WARNING]   - javax.annotation.Detainted
	[WARNING]   - javax.annotation.Nonnull$Checker
	[WARNING]   - javax.annotation.meta.TypeQualifierNickname
	[WARNING]   - 24 more...
	[WARNING] spark-unsafe_2.10-1.5.1.jar, spark-launcher_2.10-1.5.1.jar, unused-1.0.0.jar, spark-network-shuffle_2.10-1.5.1.jar, spark-network-common_2.10-1.5.1.jar, spark-core_2.10-1.5.1.jar define 1 overlapping classes: 
	[WARNING]   - org.apache.spark.unused.UnusedStubClass
	[WARNING] asm-4.0.jar, cofoja-1.1-r150.jar, asm-3.1.jar define 21 overlapping classes: 
	[WARNING]   - org.objectweb.asm.Item
	[WARNING]   - org.objectweb.asm.signature.SignatureWriter
	[WARNING]   - org.objectweb.asm.MethodWriter
	[WARNING]   - org.objectweb.asm.Type
	[WARNING]   - org.objectweb.asm.Opcodes
	[WARNING]   - org.objectweb.asm.Handler
	[WARNING]   - org.objectweb.asm.MethodVisitor
	[WARNING]   - org.objectweb.asm.Label
	[WARNING]   - org.objectweb.asm.FieldWriter
	[WARNING]   - org.objectweb.asm.signature.SignatureVisitor
	[WARNING]   - 11 more...
	[WARNING] guava-14.0.1.jar, spark-network-common_2.10-1.5.1.jar define 7 overlapping classes: 
	[WARNING]   - com.google.common.base.Optional$1$1
	[WARNING]   - com.google.common.base.Supplier
	[WARNING]   - com.google.common.base.Function
	[WARNING]   - com.google.common.base.Optional
	[WARNING]   - com.google.common.base.Optional$1
	[WARNING]   - com.google.common.base.Absent
	[WARNING]   - com.google.common.base.Present
	[WARNING] maven-shade-plugin has detected that some class files are
	[WARNING] present in two or more JARs. When this happens, only one
	[WARNING] single version of the class is copied to the uber jar.
	[WARNING] Usually this is not harmful and you can skip these warnings,
	[WARNING] otherwise try to manually exclude artifacts based on
	[WARNING] mvn dependency:tree -Ddetail=true and the above output.
	[WARNING] See http://maven.apache.org/plugins/maven-shade-plugin/
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 02:26 min
	[INFO] Finished at: 2017-02-22T14:38:28+08:00
	[INFO] Final Memory: 47M/402M
	[INFO] ------------------------------------------------------------------------
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:jniNative:so:0.2.2
	[WARNING] 'dependencies.dependency.systemPath' for cs.ucla.edu:cloud-scale-bwamem:jar should use a variable instead of a hard-coded path /curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar @ line 19, column 19
	[WARNING] 'build.plugins.plugin.version' for org.codehaus.mojo:native-maven-plugin is missing. @ line 33, column 15
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 25, column 15
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building JNI Pair-End Smith-Waterman AVX Library 0.2.2
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:initialize (default-initialize) @ jniNative ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:unzipinc (default-unzipinc) @ jniNative ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (default-javah) @ jniNative ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (javah) @ jniNative ---
	[INFO] /bin/sh -c cd /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target && javah -o /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/custom-javah/jni_mate_sw.h -classpath /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes:/curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar cs.ucla.edu.bwaspark.jni.HelloWorld cs.ucla.edu.bwaspark.jni.MateSWType cs.ucla.edu.bwaspark.jni.SeqSWType cs.ucla.edu.bwaspark.jni.MateSWJNI cs.ucla.edu.bwaspark.datatype.MemAlnRegType cs.ucla.edu.bwaspark.datatype.MemOptType cs.ucla.edu.bwaspark.datatype.MemPeStat cs.ucla.edu.bwaspark.datatype.FASTQSingleNode
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature': class file for scala.reflect.ScalaSignature not found
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature'
	Error: Class scala.Serializable could not be found.
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 1.943 s
	[INFO] Finished at: 2017-02-22T14:38:32+08:00
	[INFO] Final Memory: 9M/104M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal org.codehaus.mojo:native-maven-plugin:1.0-alpha-8:javah (javah) on project jniNative: Error running javah command: Error executing command line. Exit code:1 -> [Help 1]
	[ERROR] 
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR] 
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:jniSWExtend:so:0.2.2
	[WARNING] 'dependencies.dependency.systemPath' for cs.ucla.edu:cloud-scale-bwamem:jar should use a variable instead of a hard-coded path /curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar @ line 19, column 19
	[WARNING] 'build.plugins.plugin.version' for org.codehaus.mojo:native-maven-plugin is missing. @ line 33, column 15
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-compiler-plugin is missing. @ line 25, column 15
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building JNI Smith-Waterman Extend on FPGA 0.2.2
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:initialize (default-initialize) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:unzipinc (default-unzipinc) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (default-javah) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:javah (javah) @ jniSWExtend ---
	[INFO] /bin/sh -c cd /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target && javah -o /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/custom-javah/jni_sw_extend.h -classpath /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/classes:/curr/pengwei/github/cloud-scale-bwamem/target/cloud-scale-bwamem-0.2.2.jar cs.ucla.edu.bwaspark.jni.SWExtendFPGAJNI
	Cannot find annotation method 'bytes()' in type 'scala.reflect.ScalaSignature': class file for scala.reflect.ScalaSignature not found
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:compile (default-compile) @ jniSWExtend ---
	[INFO] /bin/sh -c cd /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga && gcc -s -fPIC -O2 -I/home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga -I/home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/custom-javah -I/home/xubo/cloud/jdk1.7.0/jre/../include -I/home/xubo/cloud/jdk1.7.0/jre/../include/linux -o/home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/objs/sw_extend_fpga.o -c /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga/sw_extend_fpga.c
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:link (default-link) @ jniSWExtend ---
	[INFO] /bin/sh -c cd /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga && gcc -shared -lrt -o/home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/jniSWExtend.so /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/target/objs/sw_extend_fpga.o
	[INFO] 
	[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ jniSWExtend ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/cloud-scale-bwamem-0.2.2/src/main/jni_fpga/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.6.1:testCompile (default-testCompile) @ jniSWExtend ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.19.1:test (default-test) @ jniSWExtend ---
	[INFO] 
	[INFO] --- native-maven-plugin:1.0-alpha-8:inczip (default-inczip) @ jniSWExtend ---
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 3.282 s
	[INFO] Finished at: 2017-02-22T14:38:37+08:00
	[INFO] Final Memory: 14M/173M
	[INFO] ------------------------------------------------------------------------
	
	
	
	参考
	
			【1】https://github.com/xubo245
			【2】http://blog.csdn.net/xubo245/
