更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1 遇到的问题
当将脚本的yarn-client模式改为standalone模式时，--master spark://MasterIP:7077，发现在HDFS中没有结果文件，而执行的临时问文件有成功生成： 

	hadoop@Master:~/cloud/workspace/tmps$ ll -t
	total 1355884
	drwxr-xr-x 5 hadoop hadoop      4096  2月  2 20:40 nm-local-dir/
	-rw-rw-r-- 1 hadoop hadoop    469301  2月  2 20:36 SparkBWA_g38L50c10000Nhs20Paired1.fastq-7-NoSort-app-20170202203642-0089-2.sam

通过查询日志来查找问题=》

###log报错：
hadoop@Master:~/cloud/spark-1.5.2/work$ vi app-20170202210407-0103/4/stderr 

	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/app-20170202210407-0103-RDD1_1
	[main] Real time: 154.699 sec; CPU: 359.016 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	17/02/02 21:07:51 ERROR BwaAlignmentBase: getOutputFile:/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L100c10000000Nhs20Paired1.fastq-7-NoSort-app-20170202210407-0103-1.sam
	17/02/02 21:07:51 ERROR BwaAlignmentBase: outputSamFileName:/xubo/project/alignment/sparkBWA/output/g38/standaloneL100c10000000Nhs20Paired12YarnT201702022036/SparkBWA_g38L100c10000000Nhs20Paired1.fastq-7-NoSort-app-20170202210407-0103-1.sam
	java.io.IOException: Mkdirs failed to create /xubo/project/alignment/sparkBWA/output/g38/standaloneL100c10000000Nhs20Paired12YarnT201702022036 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20170202210407-0103/4)
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
	        at com.github.sparkbwa.BwaAlignmentBase.copyResults(BwaAlignmentBase.java:155)
	        at com.github.sparkbwa.BwaAlignmentBase.runAlignmentProcess(BwaAlignmentBase.java:203)
	        at com.github.sparkbwa.BwaSingleAlignment.call(BwaSingleAlignment.java:94)
	        at com.github.sparkbwa.BwaSingleAlignment.call(BwaSingleAlignment.java:31)
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
	17/02/02 21:07:51 ERROR BwaAlignmentBase: java.io.IOException: Mkdirs failed to create /xubo/project/alignment/sparkBWA/output/g38/standaloneL100c10000000Nhs20Paired12YarnT201702022036 (exists=false, cwd=file:/home/hadoop/cloud/spark-1.5.2/work/app-20170202210407-0103/4)
	   
###脚本：

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi runsparkBWA2standalone.sh 
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	out='/xubo/project/alignment/sparkBWA/output/g38/standaloneL'$i'c'$j'Nhs20Paired12YarnT201702022036'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA \
	 --master spark://MasterIP:7077 \
	 --executor-memory 7g \
	  SparkBWA-0.2.jar -n 7 -m -s -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-t 2" \
	$fq1 $fq2 $out
	
	done
	done


# 2.代码
##2.1  问题解决
查找日志发现是BwaAlignmentBase的copyFromLocalFile出现问题，通过参考【3】，并修改下列代码，可以成功运行。

com.github.sparkbwa.BwaAlignmentBase#copyResults

      		 Configuration conf = new Configuration();
            conf.set("fs.default.name","hdfs://Master:9000/");
			FileSystem fs = FileSystem.get(new URI("hdfs://Master:9000/"),conf);

            System.out.println("getOutputFile:"+this.bwaInterpreter.getOutputFile());
            System.out.println("outputSamFileName:"+outputDir + "/" + outputSamFileName);
            this.LOG.error("getOutputFile:"+this.bwaInterpreter.getOutputFile());
            this.LOG.error("outputSamFileName:"+outputDir + "/" + outputSamFileName);

            fs.copyFromLocalFile(
					new Path(this.bwaInterpreter.getOutputFile()),
					new Path(outputDir + "/" + outputSamFileName)
			);

主要是加了：FileSystem fs = FileSystem.get(new URI("hdfs://Master:9000/"),conf);因为不加在一项会使得Path是本地路径：Path

由于已经在hadoop中配置了：conf.set("fs.default.name","hdfs://Master:9000/");所以这一项可以不加

未成功方法：
在脚本输入中的输出路径中加入HDFS的IP和hostname等前缀都不行。

注意：换了集群需要换配置 new URI("hdfs://Master:9000/")

# 3.结果

##3.1 日志查看
	hadoop@Master:~/cloud/spark-1.5.2/work$ vi app-20170202214536-0106/4/stderr
	
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 0 'bwa'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Algorithm found 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 1 'mem'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 2 '-t'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 3 '2'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename parameter -f found 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 4 '-f'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Filename found 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c100000Nhs20Paired1.fastq-7-NoSort-app-20170202214536-0106-1.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 5 '/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c100000Nhs20Paired1.fastq-7-NoSort-app-20170202214536-0106-1.sam'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 6 '/home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Arg 7 '/home/hadoop/cloud/workspace/tmps/app-20170202214536-0106-RDD1_1'
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[0]: bwa.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[1]: mem.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[2]: -t.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[3]: 2.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[4]: /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta.
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] option[5]: /home/hadoop/cloud/workspace/tmps/app-20170202214536-0106-RDD1_1.
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 13224 sequences (661200 bp)...
	[M::mem_process_seqs] Processed 13224 reads in 1.951 CPU sec, 1.035 real sec
	[main] Version: 0.7.15-r1140
	[main] CMD: bwa mem -t 2 /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta /home/hadoop/cloud/workspace/tmps/app-20170202214536-0106-RDD1_1
	[main] Real time: 1.258 sec; CPU: 8.671 sec
	[Java_com_github_sparkbwa_BwaJni_bwa_1jni] Return code from BWA 0.
	17/02/02 21:45:51 ERROR BwaAlignmentBase: getOutputFile:/home/hadoop/cloud/workspace/tmps/SparkBWA_g38L50c100000Nhs20Paired1.fastq-7-NoSort-app-20170202214536-0106-1.sam
	17/02/02 21:45:51 ERROR BwaAlignmentBase: outputSamFileName:/xubo/project/alignment/sparkBWA/output/g38/standaloneL50c100000Nhs20Paired12YarnT201702022036/SparkBWA_g38L50c100000Nhs20Paired1.fastq-7-NoSort-app-20170202214536-0106-1.sam

后面两行是自己加的，前面的是bwa的。

参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
		【3】http://blog.csdn.net/dongbeiman/article/details/51767006
