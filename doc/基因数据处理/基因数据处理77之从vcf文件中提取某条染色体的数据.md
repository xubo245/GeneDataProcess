
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


#参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
	【5】http://stackoverflow.com/questions/28166667/how-to-pass-d-parameter-or-environment-variable-to-spark-job  
	【6】http://stackoverflow.com/questions/28840438/how-to-override-sparks-log4j-properties-per-driver

		
#研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
#Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	
	