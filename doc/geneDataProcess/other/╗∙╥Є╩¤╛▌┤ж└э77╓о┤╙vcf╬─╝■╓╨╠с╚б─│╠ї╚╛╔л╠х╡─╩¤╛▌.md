
1.代码：

	/**
	  * @author xubo
	  */
	package org.gcdss.cli.vcf
	
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object extractGRCH38chr20vcf {
	  def main(args: Array[String]) {
	        val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	//    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    println("start:")
	    val startTime = System.currentTimeMillis()
	           val rdd = sc.textFile(args(0)).filter { each =>
          val line = each.split("\t")
          if (line(0) == args(1).toString) {
            true
          } else {
            false
          }
        }
	    
	    println(rdd.count())
	
	    val loadTime = System.currentTimeMillis()
	    println("load time:" + (loadTime - startTime) + " ms")
	
	    //    rdd.repartition(1).saveAsTextFile(args(0) + "chr" + args(1) + ".vcf")
	
	    val saveTime = System.currentTimeMillis()
	    println("save time:" + (saveTime - loadTime) + " ms")
	    println("run time:" + (saveTime - startTime) + " ms")
	    sc.stop
	  }
	}

2.脚本：

	hadoop@Master:~/xubo/project/vcf/extractGRCH38chr20vcf$ cat run.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.vcf.extractGRCH38chr20vcf \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	hdfs://219.219.220.149:9000/xubo/callVariant/vcf/All_20160407.vcf 20


3.结果：
GRCH38chr20:

	hadoop@Master:~/xubo/project/vcf/extractGRCH38chr20vcf$ ./run.sh 
	start:
	3360948                                                                         
	load time:232552 ms
	save time:243793 ms                                                             
	run time:476345 ms

GRCH38chr22:

	hadoop@Master:~/xubo/project/vcf/extractGRCH38chr20vcf$ ./GRCH38chr22.sh 
	start:
	2077087                                                                         
	load time:224112 ms
	save time:220048 ms                                                             
	run time:444160 ms
