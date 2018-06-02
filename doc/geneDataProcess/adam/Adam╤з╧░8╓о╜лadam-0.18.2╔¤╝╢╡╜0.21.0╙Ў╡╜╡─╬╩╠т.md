更多代码请见：https://github.com/xubo245
	
基因数据处理系列之Adam学习

# 1.解释
##1.1 升级后再运行CloudBWA发现有问题

	hadoop@Master:~/disk2/xubo/project/alignment/CloudBWA$ ./cloudBWAalignTestL50.sh 
	Exception in thread "main" java.lang.UnsupportedClassVersionError: htsjdk/samtools/seekablestream/SeekableStream : Unsupported major.minor version 52.0
		at java.lang.ClassLoader.defineClass1(Native Method)
		at java.lang.ClassLoader.defineClass(ClassLoader.java:800)
		at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
		at java.net.URLClassLoader.defineClass(URLClassLoader.java:449)
		at java.net.URLClassLoader.access$100(URLClassLoader.java:71)
		at java.net.URLClassLoader$1.run(URLClassLoader.java:361)
		at java.net.URLClassLoader$1.run(URLClassLoader.java:355)
		at java.security.AccessController.doPrivileged(Native Method)
		at java.net.URLClassLoader.findClass(URLClassLoader.java:354)
		at java.lang.ClassLoader.loadClass(ClassLoader.java:425)
		at java.lang.ClassLoader.loadClass(ClassLoader.java:358)
		at org.gcdss.alignment.CloudBWA$.main(CloudBWA.scala:123)
		at org.gcdss.alignment.CloudBWA.main(CloudBWA.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)


##1.2 问题分析

java版本问题：
Adam-0.21.0要求java8或以上
在pom文件中修改了并且编译成功，但是仍然报上述错误：

	 <properties>
	    <java.version>1.8</java.version>
	    <avro.version>1.8.0</avro.version>
	    <scala.version>2.10.5</scala.version>
	    <scala.version.prefix>2.10</scala.version.prefix>
	    <!--<spark.version>2.0.0</spark.version>-->
	    <spark.version>1.5.2</spark.version>
	    <parquet.version>1.8.1</parquet.version>
	    <!-- Edit the following line to configure the Hadoop (HDFS) version. -->
	    <hadoop.version>2.6.0</hadoop.version>
	    <hadoop-bam.version>7.7.0</hadoop-bam.version>
	    <slf4j.version>1.7.21</slf4j.version>
	    <bdg-formats.version>0.10.1</bdg-formats.version>
	    <bdg-utils.version>0.2.11</bdg-utils.version>
	    <htsjdk.version>2.5.0</htsjdk.version>
	    <scoverage.plugin.version>1.1.1</scoverage.plugin.version>
	  </properties>

分析发现是Spark和hadoop配套的java版本仍为jdk1.7

去掉spark和hadoop的env文件中的JAVA_HOME配置后重启报错（CLoud/allrestart.sh）：

	stopping org.apache.spark.deploy.master.Master
	This script is Deprecated. Instead use stop-dfs.sh and stop-yarn.sh
	Stopping namenodes on [Master]
	Master: Error: JAVA_HOME is not set and could not be found.
	Mcnode5: Error: JAVA_HOME is not set and could not be found.
	Mcnode3: Error: JAVA_HOME is not set and could not be found.
	Master: Error: JAVA_HOME is not set and could not be found.
	Mcnode7: Error: JAVA_HOME is not set and could not be found.
	Mcnode1: Error: JAVA_HOME is not set and could not be found.
	Mcnode2: Error: JAVA_HOME is not set and could not be found.
	Mcnode6: Error: JAVA_HOME is not set and could not be found.
	Mcnode4: Error: JAVA_HOME is not set and could not be found.
	Stopping secondary namenodes [0.0.0.0]
	0.0.0.0: Error: JAVA_HOME is not set and could not be found.
	stopping yarn daemons
	stopping resourcemanager
	Master: Error: JAVA_HOME is not set and could not be found.
	Mcnode6: Error: JAVA_HOME is not set and could not be found.
	Mcnode1: Error: JAVA_HOME is not set and could not be found.
	Mcnode5: Error: JAVA_HOME is not set and could not be found.
	Mcnode3: Error: JAVA_HOME is not set and could not be found.
	Mcnode4: Error: JAVA_HOME is not set and could not be found.
	Mcnode7: Error: JAVA_HOME is not set and could not be found.
	Mcnode2: Error: JAVA_HOME is not set and could not be found.
	no proxyserver to stop
	This script is Deprecated. Instead use start-dfs.sh and start-yarn.sh
	Starting namenodes on [Master]
	Master: Error: JAVA_HOME is not set and could not be found.
	Master: Error: JAVA_HOME is not set and could not be found.
	Mcnode3: Error: JAVA_HOME is not set and could not be found.
	Mcnode2: Error: JAVA_HOME is not set and could not be found.
	Mcnode5: Error: JAVA_HOME is not set and could not be found.
	Mcnode1: Error: JAVA_HOME is not set and could not be found.
	Mcnode7: Error: JAVA_HOME is not set and could not be found.
	Mcnode6: Error: JAVA_HOME is not set and could not be found.
	Mcnode4: Error: JAVA_HOME is not set and could not be found.
	Starting secondary namenodes [0.0.0.0]
	0.0.0.0: Error: JAVA_HOME is not set and could not be found.
	starting yarn daemons
	starting resourcemanager, logging to /home/hadoop/cloud/hadoop-2.6.0/logs/yarn-hadoop-resourcemanager-Master.out
	Mcnode4: Error: JAVA_HOME is not set and could not be found.
	Mcnode2: Error: JAVA_HOME is not set and could not be found.
	Mcnode7: Error: JAVA_HOME is not set and could not be found.
	Mcnode6: Error: JAVA_HOME is not set and could not be found.
	Mcnode5: Error: JAVA_HOME is not set and could not be found.
	Mcnode3: Error: JAVA_HOME is not set and could not be found.
	Mcnode1: Error: JAVA_HOME is not set and could not be found.
	Master: Error: JAVA_HOME is not set and could not be found.

解决办法：

将每个节点的spark和hadoop的env文件中的JAVA_HOME改为jdk8：

位置

	hadoop@Mcnode1:~$ vi ~/cloud/spark-1.5.2/conf/spark-env.sh
	hadoop@Mcnode1:~$ vi /home/hadoop/cloud/hadoop-2.6.0/etc/hadoop/hadoop-env.sh
	
修改：
	
	 #export JAVA_HOME=/usr/lib/jvm/jdk1.7.0
	 export JAVA_HOME=/home/hadoop/cloud/jdk1.8.0_121



# 2.结果
##2.1
spark重启正常

	hadoop@Master:~/cloud/spark-1.5.2/conf$ ~/cloud/allrestart.sh 

运行CloudBWA正常。


运行结果：

	hadoop@Master:~/disk2/xubo/project/alignment/CloudBWA$ ./cloudBWAalignTestL50.sh 
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c10000Nhs20Paired12time1.sam20170306201135120	bacth	1	numPatition	32	time:	20.85	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c10000Nhs20Paired12time1.sam20170306201157083	bacth	1	numPatition	32	time:	19.944	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c10000Nhs20Paired12time1.sam20170306201218157	bacth	1	numPatition	32	time:	19.937	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c10000Nhs20Paired12time1.sam20170306201239186	bacth	1	numPatition	32	time:	19.482	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c10000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c10000Nhs20Paired12time1.sam20170306201259762	bacth	1	numPatition	32	time:	19.608	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c100000Nhs20Paired12time1.sam20170306201320372	bacth	1	numPatition	32	time:	26.592	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c100000Nhs20Paired12time1.sam20170306201347663	bacth	1	numPatition	32	time:	25.966	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c100000Nhs20Paired12time1.sam20170306201414647	bacth	1	numPatition	32	time:	25.418	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c100000Nhs20Paired12time1.sam20170306201441185	bacth	1	numPatition	32	time:	26.253	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c100000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c100000Nhs20Paired12time1.sam20170306201508628	bacth	1	numPatition	32	time:	25.151	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c1000000Nhs20Paired12time1.sam20170306201534897	bacth	1	numPatition	32	time:	66.854	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c1000000Nhs20Paired12time1.sam20170306201642829	bacth	1	numPatition	32	time:	69.817	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c1000000Nhs20Paired12time1.sam20170306201753966	bacth	1	numPatition	32	time:	64.611	
	index:  /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta      fastq1:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired1.fastq	fastq2:	/xubo/project/alignment/sparkBWA/input/g38/newg38L50c1000000Nhs20Paired2.fastq	output	/xubo/project/alignment/sparkBWA/input/g38/cloudBWA/time/cloudBWAnewg38L50c1000000Nhs20Paired12time1.sam20170306201859708	bacth	1	numPatition	32	time:	68.224	
	
	



参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
