1. art：

```
	
	art_illumina -ss HS20 -i GRCH38BWAindex/GRCH38chr1L3556522.fna -p -l 100 -m 200 -s 10  -c 10000000 -o g38L100c10000000Nhs20Paired

```


2.fastq上传到hdfs

```

	spark-submit  --class cs.ucla.edu.bwaspark.BWAMEMSpark --master spark://219.219.220.149:7077  /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar upload-fastq   1 21 g38L100c10000000Nhs20Paired1.fq g38L100c10000000Nhs20Paired2.fq /xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired12.fastq

```


3.配置：
需要将fasta dispatch到各个节点，每个节点需要有cs-bwamem的jar包，jni搞全局路径

4.align：

```

 	spark-submit --executor-memory 4g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=4g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar cs-bwamem -bfn 1 -bPSW 1 -sbatch 10 -bPSWJNI 1  -oChoice 2 -oPath hdfs://219.219.220.149:9000/xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired12F2.adam -localRef 1 -jniPath /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/jniNative.so -isSWExtBatched 1  1 /home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/GRCH38BWAindex/GRCH38chr1L3556522.fasta  /xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired12.fastq
```

5.merge：

	spark-submit --executor-memory 6g --class cs.ucla.edu.bwaspark.BWAMEMSpark --total-executor-cores 20 --master spark://219.219.220.149:7077  --conf spark.driver.host=219.219.220.149 --conf spark.driver.cores=4 --conf spark.driver.maxResultSize=6g --conf spark.storage.memoryFraction=0.7  --conf spark.akka.threads=2 --conf spark.akka.frameSize=1024 /home/hadoop/xubo/tools/cloud-scale-bwamem-0.2.1/target/cloud-scale-bwamem-0.2.0-assembly.jar merge hdfs://219.219.220.149:9000 /xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired12F2.adam /xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired12F2.merge.adam


6.统计：

```

	package org.bdgenomics.avocado.cli
	
	import org.apache.spark.sql.SQLContext
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/27.
	  * 从hdfs下载经过avocado匹配好的数据
	  * run:success
	  */
	object parquetRead2csbwamemDup {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    val sqlContext = new SQLContext(sc)
	    println("start:")
	    //    val file = "hdfs://219.219.220.149:9000/xubo/16.adam/0"
	    //    val file = "hdfs://219.219.220.149:9000/xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20.merge.adam/"
	    val file = "hdfs://219.219.220.149:9000/xubo/data/alignment/cs-bwamem/fastq/g38L100c10000000Nhs20Paired12F2.merge.adam/"
	
	
	    val df3 = sqlContext.read.option("mergeSchema", "true").parquet(file)
	    //    df3.printSchema()
	    df3.show()
	    println(df3.count())
	    var j = 1
	    //    for (i <- df3) {
	    //      println(j + ":" + i)
	    //      j += 1
	    //    }
	    //    println("distinct:" + df3.distinct.count())
	    sc.stop
	    println("end")
	  }
	}

```

结果：

```

	scala>     println(df3.count())
	18512773
	scala> println("distinct:" + df3.distinct.count())
	distinct:18512773   
```


附录：
部分记录：

```
	
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.56094168004282, 9.939863106970265)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.56094168004282 9.939863106970265
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.3929171883384, 9.895888368589208)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.3929171883384 9.895888368589208
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5008221332571, 9.893101752855983)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5008221332571 9.893101752855983
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.50341742708892, 9.938821490084942)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.50341742708892 9.938821490084942
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.43662172257996, 9.956950171714343)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.43662172257996 9.956950171714343
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5294684266857, 9.903683785238687)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5294684266857 9.903683785238687
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.40190347187567, 9.937420104198324)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.40190347187567 9.937420104198324
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.45073240443014, 10.004935473704805)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.45073240443014 10.004935473704805
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.48925135028793, 9.872713569624056)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.48925135028793 9.872713569624056
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.40273561658512, 9.90951049687331)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.40273561658512 9.90951049687331
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.46782169411932, 9.994092930915187)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.46782169411932 9.994092930915187
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.4832529043789, 9.916498387414416)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.4832529043789 9.916498387414416
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.51942615912995, 9.980650734352077)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.51942615912995 9.980650734352077
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.42283366088975, 10.025277342223173)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.42283366088975 10.025277342223173
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.56863795443184, 9.884954572476323)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.56863795443184 9.884954572476323
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.54418222714128, 9.937606729429495)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.54418222714128 9.937606729429495
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.51789788933257, 9.908230182966792)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.51789788933257 9.908230182966792
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.49175824175825, 9.953633581247528)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.49175824175825 9.953633581247528
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.57901688501767, 9.95075215935561)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.57901688501767 9.95075215935561
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.47238496713348, 9.984373782742304)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.47238496713348 9.984373782742304
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.46635524016688, 9.968761617488683)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.46635524016688 9.968761617488683
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.38825547732228, 9.92027510738216)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.38825547732228 9.92027510738216
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.4851967207246, 9.937352774317741)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.4851967207246 9.937352774317741
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.55340706386016, 9.817553555623133)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.55340706386016 9.817553555623133
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.44619450694668, 9.920089825716484)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.44619450694668 9.920089825716484
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5452329749104, 9.926594228354224)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5452329749104 9.926594228354224
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.45703727621714, 9.948262102053539)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.45703727621714 9.948262102053539
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.4996774887121, 9.889445679734042)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.4996774887121 9.889445679734042
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.44845544695727, 10.04637179033811)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.44845544695727 10.04637179033811
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.54115079081086, 9.861927310088358)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.54115079081086 9.861927310088358
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.50392688847637, 9.923422645866905)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.50392688847637 9.923422645866905
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.47992413398225, 9.938359869833343)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.47992413398225 9.938359869833343
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.58786034019695, 9.881771439959131)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.58786034019695 9.881771439959131
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.53944973771544, 9.928751173123029)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.53944973771544 9.928751173123029
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.51932833154697, 9.921047819212657)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.51932833154697 9.921047819212657
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5051575828961, 9.955724349633446)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5051575828961 9.955724349633446
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.45987665323875, 9.934862525129335)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.45987665323875 9.934862525129335
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.41697601370646, 9.924344174968864)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.41697601370646 9.924344174968864
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.4504008016032, 10.037075657682921)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.4504008016032 10.037075657682921
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.53644939965696, 9.99170757810556)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.53644939965696 9.99170757810556
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.48251923421006, 9.977411795227688)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.48251923421006 9.977411795227688
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.50750643408637, 9.996386292381906)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.50750643408637 9.996386292381906
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.43163108941235, 9.93712833366825)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.43163108941235 9.93712833366825
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.4462753788962, 9.969547663168125)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.4462753788962 9.969547663168125
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.564805511698, 9.981653834837397)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.564805511698 9.981653834837397
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.36601983305985, 9.935551164661065)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.36601983305985 9.935551164661065
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5214522629195, 9.948307577425197)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5214522629195 9.948307577425197
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.4983700519434, 9.945836975580079)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.4983700519434 9.945836975580079
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.55142989753293, 9.949033183252514)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.55142989753293 9.949033183252514
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.57046907934694, 9.951195165671601)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.57046907934694 9.951195165671601
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5627628483855, 9.940990579395123)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5627628483855 9.940990579395123
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.57557661362418, 9.88907098626934)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.57557661362418 9.88907098626934
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.43170531280145, 9.97153529406552)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.43170531280145 9.97153529406552
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.50119476443524, 9.993324406109274)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.50119476443524 9.993324406109274
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.53636818766986, 9.949249012517377)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.53636818766986 9.949249012517377
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.56565548290277, 9.982952754471368)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.56565548290277 9.982952754471368
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.44116064703562, 9.922618947362455)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.44116064703562 9.922618947362455
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.48944921316166, 9.932084984684073)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.48944921316166 9.932084984684073
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.3957828750534, 9.897098539777856)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.3957828750534 9.897098539777856
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.46895465769603, 9.819260659759172)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.46895465769603 9.819260659759172
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.5120634807163, 9.905862404052492)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.5120634807163 9.905862404052492
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.50274353310056, 9.979749125168556)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.50274353310056 9.979749125168556
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.49695820211852, 9.940759507891329)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.49695820211852 9.940759507891329
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.42262032467997, 9.919691202862072)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.42262032467997 9.919691202862072
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.49617638650656, 9.973742669699334)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.49617638650656 9.973742669699334
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.57427937915742, 9.952728233473406)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.57427937915742 9.952728233473406
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 198, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.48755438271164, 9.944608296251676)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.48755438271164 9.944608296251676
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.52546792398914, 10.000808728139058)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.52546792398914 10.000808728139058
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (192, 199, 205)
	low and high boundaries for computing mean and std.dev: (166, 231)
	mean and std.dev: (198.49446902654867, 9.999977060170599)
	low and high boundaries for proper pairs: (153, 244)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 153 244 0 198.49446902654867 9.999977060170599
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Load FASTQ files                                                                
	@Worker1
	skip orientation FF as there are not enough pairs                               
	analyzing insert size distribution for orientation
	(25, 50, 75) percentile: (191, 198, 205)
	low and high boundaries for computing mean and std.dev: (163, 233)
	mean and std.dev: (198.28641975308642, 10.159216233717126)
	low and high boundaries for proper pairs: (149, 247)
	skip orientation RF as there are not enough pairs
	skip orientation RR as there are not enough pairs
	@MemPeStat
	pes(0): 0 0 1 0.0 0.0
	pes(1): 149 247 0 198.28641975308642 10.159216233717126
	pes(2): 0 0 1 0.0 0.0
	pes(3): 0 0 1 0.0 0.0
	Summary:
	Worker1 Time: 815792
	Calculate Metrics Time: 2093
	Worker2 Time: 688463
	16/06/03 18:07:19 ERROR LiveListenerBus: SparkListenerBus has already stopped! Dropping event SparkListenerExecutorMetricsUpdate(4,WrappedArray())
	16/06/03 18:07:19 WARN QueuedThreadPool: 1 threads could not be stopped
	CS-BWAMEM Finished!!!
	Jun 3, 2016 5:41:47 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 21
	Jun 3, 2016 5:41:57 PM INFO: parquet.hadoop.ParquetInputFormat: Total input paths to process : 21
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ 

```

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
	
	