
# 1 原来脚本：

	spark-submit --class SparkBWA \
	--master yarn-client \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	--archives ./bwa.zip \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 3 \
	/xubo/alignment/sparkBWA/GRCH38chr1L3556522N1000000L100paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N1000000L100paired2.fastq \
	/xubo/alignment/output/sparkBWA/GRCH38chr1L3556522N1000000L100paired12Yarn


# 2 更改后的脚本：

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi pairedGRCH38L1N1000000Yarn.sh
	
	spark-submit --class SparkBWA \
	--master yarn-client \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 3 \
	/xubo/project/alignment/sparkBWA/input/GRCH38chr1L3556522N1000000L100paired1.fastq /xubo/project/alignment/sparkBWA/input/GRCH38chr1L3556522N1000000L100paired2.fastq \
	/xubo/project/alignment/sparkBWA/output/sparkBWA/GRCH38chr1L3556522N1000000L100paired12Yarn
	
# 3 运行问题：

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./pairedGRCH38L1N1000000Yarn.sh 
	Error: Could not load YARN classes. This copy of Spark may not have been compiled with YARN support.
	Run with --help for usage help or --verbose for debug output

# 4 原因分析
	主要是由于之前装配ganglia的时候更改了jar包
# 5 解决办法

	ssh Mcnode1
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Mcnode2
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Mcnode3
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Mcnode4
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Mcnode5
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Mcnode6
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Mcnode7
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.withMetrics
	
	mv ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar.native ~/cloud/spark-1.5.2/lib/spark-assembly-1.5.2-hadoop2.6.0.jar
	
	ssh Master
参考：  
【1】 http://stackoverflow.com/questions/28166667/how-to-pass-d-parameter-or-environment-variable-to-spark-job  
【2】http://stackoverflow.com/questions/28840438/how-to-override-sparks-log4j-properties-per-driver
