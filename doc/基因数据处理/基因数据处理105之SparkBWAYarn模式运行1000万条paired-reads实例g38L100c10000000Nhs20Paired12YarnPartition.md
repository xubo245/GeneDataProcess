
1.数据生成：

	art_illumina -ss HS20 -i GRCH38BWAindex/GRCH38chr1L3556522.fna -p -l 100 -m 200 -s 10  -c 10000000 -o g38L100c10000000Nhs20Paired
位置：
	
	hadoop@Master:~/xubo/ref/GRCH38L1Index/pe$ pwd
	/home/hadoop/xubo/ref/GRCH38L1Index/pe
	hadoop@Master:~/xubo/ref/GRCH38L1Index/pe$ ll -h
	total 14G
	drwxrwxr-x 2 hadoop hadoop 4.0K  6月 25 16:09 ./
	drwxrwxr-x 4 hadoop hadoop 4.0K  6月 23 16:46 ../
	-rw-rw-r-- 1 hadoop hadoop 2.1G  6月 24 22:52 g38L100c10000000Nhs20.aln
	-rw-rw-r-- 1 hadoop hadoop 1.9G  6月 24 22:52 g38L100c10000000Nhs20.fq
	-rw-rw-r-- 1 hadoop hadoop 479M  6月 25 16:16 g38L100c10000000Nhs20Paired12.sam
	-rw-rw-r-- 1 hadoop hadoop 2.1G  6月 24 23:06 g38L100c10000000Nhs20Paired1.aln
	-rw-rw-r-- 1 hadoop hadoop 2.0G  6月 24 23:06 g38L100c10000000Nhs20Paired1.fq
	-rw-rw-r-- 1 hadoop hadoop 2.1G  6月 24 23:06 g38L100c10000000Nhs20Paired2.aln
	-rw-rw-r-- 1 hadoop hadoop 2.0G  6月 24 23:06 g38L100c10000000Nhs20Paired2.fq
	-rw-rw-r-- 1 hadoop hadoop 621M  6月 24 00:09 GRCH38chr1L3556522N1000000L100paired12.sam
	-rw-rw-r-- 1 hadoop hadoop 4.6M  6月 20 21:19 GRCH38chr1L3556522N1000000L100paired12.wgsim
	-rw-rw-r-- 1 hadoop hadoop 238M  6月 20 21:19 GRCH38chr1L3556522N1000000L100paired1.fastq
	-rw-rw-r-- 1 hadoop hadoop 238M  6月 20 21:19 GRCH38chr1L3556522N1000000L100paired2.fastq
	-rw-rw-r-- 1 hadoop hadoop 1.5K  6月 19 19:31 GRCH38chr1L3556522N10L50paired1.fastq
	-rw-rw-r-- 1 hadoop hadoop 1.5K  6月 19 19:31 GRCH38chr1L3556522N10L50paired2.fastq
	-rw-rw-r-- 1 hadoop hadoop 4.4K  6月 19 19:32 GRCH38chr1L3556522N10L50paired.sam

上传到的位置为/xubo/alignment/sparkBWA/，并且将后缀fq改为fastq，不然sparkBWA处理报错：

	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./g38L100c10000000Nhs20Paired12YarnPartition.sh 
	start
	1466837745.574430509
	Exception in thread "main" java.lang.NumberFormatException: For input string: "/xubo/alignment/sparkBWA/g38L100c10000000Nhs20Paired1.fq"
		at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
		at java.lang.Integer.parseInt(Integer.java:481)
		at java.lang.Integer.parseInt(Integer.java:527)
		at BwaOptions.<init>(BwaOptions.java:186)
		at BwaInterpreter.<init>(BwaInterpreter.java:93)
		at SparkBWA.main(SparkBWA.java:25)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)


2.脚本：

查看：

	hadoop@Master:~/xubo/project/alignment/sparkBWA$ cat g38L100c10000000Nhs20Paired12YarnPartition.sh 

代码：
	
	echo "start"
	startTime4=`date +"%s.%N"`
	        time4=`date +"%Y%m%d%H%M%S"`
	         #spark-submit --class org.apache.spark.examples.SparkPi     --master spark://219.219.220.149:7077     /home/hadoop/cloud/spark-1.5.2/lib/spark-examples*.jar     $i
	
	echo $startTime4
	j=7
	output2='/xubo/alignment/output/sparkBWA/AAg38L100c10000000Nhs20Paired12YarnPartition'$j
	
	
	
	spark-submit --class SparkBWA \
	--master yarn-client \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions $j \
	/xubo/alignment/sparkBWA/g38L100c10000000Nhs20Paired1.fastq /xubo/alignment/sparkBWA/g38L100c10000000Nhs20Paired2.fastq \
	$output2
	
	        endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " bwa mem local with ERR000589_12 RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	echo "end"


3.运行记录：
	
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./g38L100c10000000Nhs20Paired12YarnPartition.sh 
	start
	1466838029.335796561
	=> bwa mem local with ERR000589_12 RunTime:3797.094127 s                        
	end


4.结果文件：

![](http://i.imgur.com/UjkDI81.png)

因为设置的partition为7，所以结果是7，没有使用reduce

