
1.代码：

	/**
	  * @author xubo
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.gcdss.cli.disease
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	
	class DataProcessing(vcfFile: String, dbSnp2omimFile: String, omimFile: String, output: String) {
	  def run(sc: SparkContext): Unit = {
	    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    //    val sc = new SparkContext(conf)
	    println("start:")
	    val startTime = System.currentTimeMillis()
	
	    println("vcfFile:" + vcfFile)
	    println("dbSnp2omimFile:" + dbSnp2omimFile)
	    println("omimFile:" + omimFile)
	    println("output:" + output)
	
	    //1.filter vcf
	    val vcfRdd = sc.textFile(vcfFile).filter(!_.startsWith("#"))
	    println("vcfRdd.count:" + vcfRdd.count())
	    //      .map(each => each.split("\\s+"))
	    val vcfFilterRDD = vcfRdd.map { each =>
	      each.split("\\s+")
	    }.filter(_ (2).startsWith("rs"))
	      .map {
	        each2 =>
	          (each2(2), ("vcf", each2(0), each2(1), each2(3), each2(4), each2(5), each2(6)))
	      }
	    println("vcfFilterRDD.count:" + vcfFilterRDD.count())
	
	    //2.filter dbSnp2omim
	    val dbSnp2omimRdd = sc.textFile(dbSnp2omimFile).map(_.split("\\s+"))
	    println("dbSnp2omimRdd.count:" + dbSnp2omimRdd.count())
	    val dbSnp2omimFilterRDD = dbSnp2omimRdd.map { each =>
	      ("rs" + each(8), ("dbSnp2omim", each(0), each(1), each(2), each(3), each(4), each(5), each(6), each(7)))
	    }
	    println("dbSnp2omimFilterRDD.count:" + dbSnp2omimFilterRDD.count())
	    val vcf2omimRDD = vcfFilterRDD.join(dbSnp2omimFilterRDD)
	    println("vcf2omimRDD.count:" + vcf2omimRDD.count())
	    //    vcf2omimRDD.foreach(println)
	
	    val vcf2omimSimpleRDD = vcf2omimRDD.map { each =>
	      (each._1, each._2._2._2, each._2._1._2, each._2._1._3, each._2._1._4, each._2._1._5)
	    }
	    println("vcf2omimSimpleRDD.count:" + vcf2omimSimpleRDD.count())
	    //    vcf2omimSimpleRDD.foreach(println)
	
	
	    //3.filter omim information
	    val omimRdd = sc.textFile(omimFile).map(_.split('|'))
	    println("omimRdd.count:" + omimRdd.count())
	    //    omimRdd.take(10).foreach(each => println(each(9)))
	    val omimFilterRDD = omimRdd.map { each =>
	      (each(9), ("omim", each(0), each(1), each(2), each(3), each(4), each(5), each(6), each(7), each(8), each(10)))
	    }
	
	    val outputRDD = vcf2omimSimpleRDD.map(each => (each._2, (each._1, each._3, each._4, each._5, each._6))).join(omimFilterRDD)
	    println("outputRDD.count:" + outputRDD.count())
	    //    outputRDD.foreach(println)
	
	    val saveRDD = outputRDD.map { each =>
	      (each._1, each._2._1, each._2._2)
	      //        each._2._2._1, each._2._2._2, each._2._2._3, each._2._2._4, each._2._2._5, each._2._2._6,
	      //        each._2._2._7, each._2._2._8, each._2._2._9, each._2._2._10, each._2._2._11)
	    }
	    val saveRDD2 = outputRDD.map { each =>
	      (each._1, each._2._1._1, each._2._1._2, each._2._1._3, each._2._1._4, each._2._1._5)
	    }
	    //    saveRDD.foreach(println)
	    val loadTime = System.currentTimeMillis()
	    println("load time:" + (loadTime - startTime) + " ms")
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val outputSaveRDD = output + "/" + iString
	    val outputSaveRDD2 = output + "/Simple" + iString
	    saveRDD.repartition(1).saveAsTextFile(outputSaveRDD)
	    saveRDD2.repartition(1).saveAsTextFile(outputSaveRDD2)
	    println("outputSaveRDD:" + outputSaveRDD)
	    println("outputSaveRDD2:" + outputSaveRDD2)
	    val saveTime = System.currentTimeMillis()
	    println("save time:" + (saveTime - loadTime) + " ms")
	    println("run time:" + (saveTime - startTime) + " ms")
	    println("end")
	    //    sc.stop
	  }
	}
	
	object DataProcessing {
	  def main(args: Array[String]): Unit = {
	    if (args.length < 4) {
	      System.err.println("at least three argument required, e.g. vcfFile dbSnp2omimFile omimFile outputPath")
	      System.exit(1)
	    }
	    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    val dataProcessing = new DataProcessing(args(0), args(1), args(2), args(3))
	    dataProcessing.run(sc)
	    sc.stop
	  }
	
	  def runLocal(args: Array[String]): Unit = {
	    if (args.length < 4) {
	      System.err.println("at least three argument required, e.g. vcfFile dbSnp2omimFile omimFile outputPath")
	      System.exit(1)
	    }
	    println("local[4]")
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    val dataProcessing = new DataProcessing(args(0), args(1), args(2), args(3))
	    dataProcessing.run(sc)
	    sc.stop
	  }
	}


2.脚本：

	hadoop@Master:~/xubo/project/callDisease/DataProcessing$ cat load.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.disease.DataProcessing \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/callDisease/input/small.vcf /xubo/callDisease/input/omimFilter9Text.txt /xubo/callDisease/input/genemap.txt /xubo/callDisease/output/small.output
	
	hadoop@Master:~/xubo/project/callDisease/DataProcessing$ cat allVcf.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.disease.DataProcessing \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/callVariant/vcf/All_20160407.vcf /xubo/callDisease/input/omimFilter9Text.txt /xubo/callDisease/input/genemap.txt /xubo/callDisease/output/AllVCF.output




3.结果：

	hadoop@Master:~/xubo/project/callDisease/DataProcessing$ ./allVcf.sh 
	start:
	vcfFile:/xubo/callVariant/vcf/All_20160407.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	output:/xubo/callDisease/output/AllVCF.output
	vcfRdd.count:152331373                                                          
	vcfFilterRDD.count:152331373                                                    
	dbSnp2omimRdd.count:11199
	dbSnp2omimFilterRDD.count:11199
	vcf2omimRDD.count:11189                                                         
	vcf2omimSimpleRDD.count:11189                                                   
	omimRdd.count:15705                                                             
	outputRDD.count:10884                                                           
	load time:1492430 ms
	outputSaveRDD:/xubo/callDisease/output/AllVCF.output/20160609111943636          
	outputSaveRDD2:/xubo/callDisease/output/AllVCF.output/Simple20160609111943636
	save time:69135 ms
	run time:1561565 ms
	end
	16/06/09 11:20:53 WARN QueuedThreadPool: 1 threads could not be stopped
	hadoop@Master:~/xubo/project/callDisease/DataProcessing$ ./load.sh 
	start:
	vcfFile:/xubo/callDisease/input/small.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	output:/xubo/callDisease/output/small.output
	vcfRdd.count:5                                                                  
	vcfFilterRDD.count:2                                                            
	dbSnp2omimRdd.count:11199                                                       
	dbSnp2omimFilterRDD.count:11199                                                 
	vcf2omimRDD.count:1                                                             
	vcf2omimSimpleRDD.count:1                                                       
	omimRdd.count:15705                                                             
	outputRDD.count:1                                                               
	load time:46928 ms
	outputSaveRDD:/xubo/callDisease/output/small.output/20160609112821601           
	outputSaveRDD2:/xubo/callDisease/output/small.output/Simple20160609112821601
	save time:3858 ms
	run time:50786 ms
	end



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
	