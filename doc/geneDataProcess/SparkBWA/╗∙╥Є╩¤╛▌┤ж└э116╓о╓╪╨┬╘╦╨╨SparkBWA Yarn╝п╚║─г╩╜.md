
更多代码请见：https://github.com/xubo245

基因数据处理系列

# 1.解释

	很久没运行SparkBWA了，系统文件有点多，重新运行。


# 2.代码：

	end
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ vi g38L100c100000Nhs20Paired12SparkBWAYarnPartition0.sh 
	
	echo "start"
	startTime4=`date +"%s.%N"`
	        time4=`date +"%Y%m%d%H%M%S"`
	         #spark-submit --class org.apache.spark.examples.SparkPi     --master spark://219.219.220.149:7077     /home/hadoop/cloud/spark-1.5.2/lib/spark-examples*.jar     $i
	
	echo $startTime4
	j=0
	output2='/xubo/project/alignment/sparkBWA/output/AAg38L100c100000Nhs20Paired12SparkBWAYarnPartition0shell'$j
	
	
	
	spark-submit --class SparkBWA \
	--master yarn-client \
	--executor-memory 7G \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/disk2/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions $j \
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq /xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq \
	$output2
	
	        endTime4=`date +"%s.%N"`
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " g38L100c10000000Nhs20Paired12SparkBWAYarnPartition0 RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	echo "end"


# 3.结果：

## 3.1 terminal
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./g38L100c100000Nhs20Paired12SparkBWAYarnPartition0.sh 
	start
	1479306305.415351298
	=> g38L100c10000000Nhs20Paired12SparkBWAYarnPartition0 RunTime:98.942027 s
	end

## 3.2 文件
![](http://i.imgur.com/1XrD61M.png)

![](http://i.imgur.com/cnNnQTo.png)

参考

	【1】https://github.com/xubo245
	【4】http://blog.csdn.net/xubo245/
