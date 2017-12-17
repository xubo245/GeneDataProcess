	
	
1.总的脚本
	
		
		hadoop@Master:~/xubo/project/alignment$ cat runSparkBWAAndCsbwamem.sh 
		echo "start sparkBWA"
		./sparkBWA/sparkBWA.sh 
		
		echo "startCsbwamem algin"
		./cs-bwamem/csbwamemAlign.sh
		
		echo "startCsbwamem merge"
		 ./cs-bwamem/csbwamemMerge.sh 
		
		echo "start sparkBWA local"
		 ./sparkBWA/sparkBWALocal.sh
	

2.各分脚本：
	
2.1 hadoop@Master:~/xubo/project/alignment$ cat sparkBWA/sparkBWA.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	echo $i
	echo $j
	 startTime4=`date +"%s.%N"`
	#fq='g38L'$i'c'$j'Nhs20Paired'$k'.fq'
	#fq0='g38L'$i'c'$j'Nhs20Paired*.fastq'
	fq1='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired2.fastq'
	#out='g38L'$i'c'$j'Nhs20Paired12.sam'
	out='/xubo/alignment/output/sparkBWA/CCg38L'$i'c'$j'Nhs20Paired12YarnT201606252236'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class SparkBWA \
	--master yarn-client \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 7 \
	$fq1 $fq2 $out
	
	
	#/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	#/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12YarnMaster
	
	
	endTime4=`date +"%s.%N"`
	echo "startTime"
	echo $startTime4
	echo "endTime"
	echo $endTime4
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " create fastq RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	done 
	done
	
	
2.2 hadoop@Master:~/xubo/project/alignment$ cat cs-bwamem/csbwamemAlign.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	echo $i
	echo $j
	 startTime4=`date +"%s.%N"`
	#fq='g38L'$i'c'$j'Nhs20Paired'$k'.fq'
	#fq0='g38L'$i'c'$j'Nhs20Paired*.fastq'
	#fq1='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired1.fastq'
	#fq2='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired2.fastq'
	#out='g38L'$i'c'$j'Nhs20Paired12.sam'
	out='/xubo/alignment/cs-bwamem/input/fastq/CCg38L'$i'c'$j'Nhs20Paired12T201606252236.adam'
	file='/xubo/alignment/cs-bwamem/input/fastq/g38L'$i'c'$j'Nhs20Paired12.fastq'
	
	echo $file
	echo $out
	
	spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath $out -localRef 1 -jniPath /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/jniNative.so -isSWExtBatched 1  1 /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta  $file
	
	#spark-submit --executor-memory 6g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 $file $out
	
	
	#/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	#/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12YarnMaster
	
	
	endTime4=`date +"%s.%N"`
	echo "startTime"
	echo $startTime4
	echo "endTime"
	echo $endTime4
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " create fastq RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	done 
	done
	hadoop@Master:~/xubo/project/alignment$ 
	
	
2.3 hadoop@Master:~/xubo/project/alignment$ cat cs-bwamem/csbwamemMerge.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	echo $i
	echo $j
	 startTime4=`date +"%s.%N"`
	#fq='g38L'$i'c'$j'Nhs20Paired'$k'.fq'
	#fq0='g38L'$i'c'$j'Nhs20Paired*.fastq'
	#fq1='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired1.fastq'
	#fq2='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired2.fastq'
	#out='g38L'$i'c'$j'Nhs20Paired12.sam'
	out='/xubo/alignment/cs-bwamem/input/fastq/CCg38L'$i'c'$j'Nhs20Paired12T201606252236.merge.adam'
	file='/xubo/alignment/cs-bwamem/input/fastq/CCg38L'$i'c'$j'Nhs20Paired12T201606252236.adam'
	#file='/xubo/alignment/cs-bwamem/input/fastq/g38L'$i'c'$j'Nhs20Paired12.fastq'
	
	echo $file
	echo $out
	
	spark-submit --executor-memory 6g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 $file $out
	
	
	#/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	#/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12YarnMaster
	
	
	endTime4=`date +"%s.%N"`
	echo "startTime"
	echo $startTime4
	echo "endTime"
	echo $endTime4
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " create fastq RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	done 
	done
	
	
	
	
2.4 hadoop@Master:~/xubo/project/alignment$ cat sparkBWA/sparkBWALocal.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	echo $i
	echo $j
	 startTime4=`date +"%s.%N"`
	#fq='g38L'$i'c'$j'Nhs20Paired'$k'.fq'
	#fq0='g38L'$i'c'$j'Nhs20Paired*.fastq'
	fq1='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/alignment/sparkBWA/g38L'$i'c'$j'Nhs20Paired2.fastq'
	#out='g38L'$i'c'$j'Nhs20Paired12.sam'
	out='/xubo/alignment/output/sparkBWA/CCg38L'$i'c'$j'Nhs20Paired12YarnT201606252236Local'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class SparkBWA \
	--master local \
	--conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/xubo/tools/SparkBWA/build" \
	SparkBWA.jar \
	-algorithm mem -reads paired \
	-index /home/hadoop/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-partitions 7 \
	$fq1 $fq2 $out
	
	
	#/xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired1.fastq /xubo/alignment/sparkBWA/GRCH38chr1L3556522N10L50paired2.fastq \
	#/xubo/alignment/output/sparkBWA/datatestLocalGRCH38chr1L3556522N10L50paired12YarnMaster
	
	
	endTime4=`date +"%s.%N"`
	echo "startTime"
	echo $startTime4
	echo "endTime"
	echo $endTime4
	   echo $k"=>"`awk -v x1="$(echo $endTime4 | cut -d '.' -f 1)" -v x2="$(echo $startTime4 | cut -d '.' -f 1)" -v y1="$[$(echo $endTime4 | cut -d '.' -f 2) / 1000]" -v y2="$[$(echo $startTime4 | cut -d '.' -f 2) /1000]"  'BEGIN{printf " create fastq RunTime:%.6f s",(x1-x2)+(y1-y2)/1000000}'`
	
	done 
	done


3. 运行结果：


基因数据处理110之批量测试SparkBWA和CS-bwamem算法【附录 数据】
【还未处理】


#参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
		
#研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
#Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	