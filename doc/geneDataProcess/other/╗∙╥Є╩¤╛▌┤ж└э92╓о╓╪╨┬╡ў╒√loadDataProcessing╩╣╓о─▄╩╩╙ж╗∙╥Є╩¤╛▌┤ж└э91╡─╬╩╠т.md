	
1.解决思路：

正如基因数据处理91之disease的vcf2omim和dataProcessing的数据对不上描述的问题，目前解决办法如下：采取简单的map和union的方式将alternateAllele的读取改为逗号分开的。然后进行union
	
余留问题，这样的方法需要遍历四次RDD，可以将返回的类型改为Array或者其他形式来减少时间开销。还好RDD不大， 只有1万多行。
	
	
2.解决代码：
	
	/**
	  * @author xubo
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.gcdss.cli.disease
	
	import org.apache.spark.rdd.RDD
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object loadDataProcessing {
	  def simple(sc: SparkContext, file: String): RDD[((String, String, String, String), String, String)] = {
	    val rdd = sc.textFile(file)
	    //    val rdd2 = sc.textFile(file).map(each => each.split(Array(',', '(', ')')).filter { every => every != "" })
	    val rdd2 = sc.textFile(file).map(each => each.split('|'))
	    val rdd31 = rdd2.map { each =>
	      val alternateAllele = each(5).split(',')
	      if (alternateAllele.length > 0) {
	        ((each(2), each(3), each(4), alternateAllele(0)), each(0), each(1))
	      } else {
	        ((each(2), each(3), each(4), each(5)), each(0), each(1))
	        //        <((each(2), each(3), each(4), each(5)), each(0), each(1)),((each(2), each(3), each(4), each(5)), each(0), each(1))>
	      }
	    }
	
	    val rdd32 = rdd2.filter(each => each(5).split(',').length > 1).map { each =>
	      val alternateAllele = each(5).split(',')
	      ((each(2), each(3), each(4), alternateAllele(1)), each(0), each(1))
	    }
	    val rdd33 = rdd2.filter(each => each(5).split(',').length > 2).map { each =>
	      val alternateAllele = each(5).split(',')
	      ((each(2), each(3), each(4), alternateAllele(2)), each(0), each(1))
	    }
	    val rdd34 = rdd2.filter(each => each(5).split(',').length > 3).map { each =>
	      val alternateAllele = each(5).split(',')
	      ((each(2), each(3), each(4), alternateAllele(3)), each(0), each(1))
	    }
	    val rdd3 = rdd31.union(rdd32).union(rdd33).union(rdd34)
	    //    rdd2.foreach { each =>
	    //      each.foreach(every => print(every + " "))
	    //    }
	    rdd3
	  }
	
	  def complex(sc: SparkContext, file: String): RDD[((String, String, String, String), (String, String, String, String, String, String, String, String, String, String, String, String, String))] = {
	    val rdd = sc.textFile(file)
	    val rdd2 = sc.textFile(file).map(each => each.split('|'))
	    rdd2.take(1).foreach(println)
	    //    rdd2.foreach(each => println(each.length))
	    val rdd3 = rdd2.map { each =>
	      if (each.length == 17) {
	        ((each(2), each(3), each(4), each(5)), (each(0), each(1), each(6), each(7), each(8), each(9), each(10), each(11), each(12), each(13), each(14), each(15), each(16)))
	      } else {
	        //有两条数据长度为16
	        //        16
	        //        107580 rs121909574 6 10404509 T C,G omim 6.60 6 27 08 6p24.3 TFAP2A, AP2TF, BOFS C Transcription factor AP-2 alpha (activating enhancer-binding protein 2 alpha)
	        //        16
	        //        107580 rs121909575 6 10402590 C T omim 6.60 6 27 08 6p24.3 TFAP2A, AP2TF, BOFS C Transcription factor AP-2 alpha (activating enhancer-binding protein 2 alpha)
	        ((each(2), each(3), each(4), each(5)), (each(0), each(1), each(6), each(7), each(8), each(9), each(10), each(11), each(12), each(13), each(14), each(15), "no data"))
	      }
	    }
	
	    val rdd41 = rdd3.filter(_._1._4.split(',').length > 0).map { each =>
	      val alternateAllele = each._1._4.split(',')
	      ((each._1._1, each._1._2, each._1._3, alternateAllele(0)), each._2)
	    }
	    val rdd42 = rdd3.filter(_._1._4.split(',').length > 1).map { each =>
	      val alternateAllele = each._1._4.split(',')
	      ((each._1._1, each._1._2, each._1._3, alternateAllele(1)), each._2)
	    }
	    val rdd43 = rdd3.filter(_._1._4.split(',').length > 2).map { each =>
	      val alternateAllele = each._1._4.split(',')
	      ((each._1._1, each._1._2, each._1._3, alternateAllele(2)), each._2)
	    }
	    val rdd44 = rdd3.filter(_._1._4.split(',').length > 3).map { each =>
	      val alternateAllele = each._1._4.split(',')
	      ((each._1._1, each._1._2, each._1._3, alternateAllele(3)), each._2)
	    }
	
	    //    rdd2.foreach { each =>
	    //      each.foreach(every => print(every + " "))
	    //    }
	    val rdd5 = rdd41.union(rdd42).union(rdd43).union(rdd44)
	    rdd5
	    //    rdd3
	  }
	
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    println("start:")
	    val startTime = System.currentTimeMillis()
	
	    val file = "file/callDisease/input/vcf2omimSimple.txt"
	    val rdd = sc.textFile(file)
	    //      .map(each => each.split("\\s+"))
	
	    println("rdd.count():" + rdd.count())
	    rdd.take(10).foreach(println)
	
	    val rdd2 = sc.textFile(file).map(each => each.split(Array(',', '(', ')')).filter {
	      every => every != ""
	    })
	    rdd2.foreach {
	      each =>
	        each.foreach(every => print(every + " "))
	        println
	        println(each.length)
	        println("***A" + each(0) + "B*******")
	        println(each(1))
	        println(each(2))
	    }
	
	    println("\n file2:")
	    val file2 = "file/callDisease/input/vcf2omim.txt"
	    val rdd3 = sc.textFile(file2)
	    rdd3.foreach(println)
	    val rdd4 = sc.textFile(file2).map(each => each.split(Array(',', '(', ')')).filter {
	      every => every != ""
	    })
	    rdd4.foreach {
	      each =>
	        each.foreach(every => print(every + " "))
	        println
	        println(each.length)
	        println("***A" + each(0) + "B*******")
	        println(each(1))
	        println(each(2))
	    }
	    val loadTime = System.currentTimeMillis()
	    println("load time:" + (loadTime - startTime) + " ms")
	
	    val saveTime = System.currentTimeMillis()
	    println("save time:" + (saveTime - loadTime) + " ms")
	    println("run time:" + (saveTime - startTime) + " ms")
	
	    sc.stop
	  }
	}
	

3.测试数据：

（1）

	172460|rs2236225|1|63735|CCTA|C
	172461|rs2236225|1|63735|CCTA|C,T
	172462|rs2236225|1|63735|CCTA|C,T,A
	172463|rs2236225|1|63735|CCTA|C,T,A,G

读取效果：

	rdd println:10
	((1,63735,CCTA,C),172460,rs2236225)
	((1,63735,CCTA,C),172461,rs2236225)
	((1,63735,CCTA,C),172462,rs2236225)
	((1,63735,CCTA,T),172461,rs2236225)
	((1,63735,CCTA,T),172462,rs2236225)
	((1,63735,CCTA,C),172463,rs2236225)
	((1,63735,CCTA,T),172463,rs2236225)
	((1,63735,CCTA,A),172463,rs2236225)
	((1,63735,CCTA,A),172462,rs2236225)
	((1,63735,CCTA,G),172463,rs2236225)

（2）
	
	172460|rs2236225|1|63735|CCTA|C|omim|14.277|8|25|06|14q23.3|MTHFD, MTHFC|C|5,10-methylenetetrahydrofolate dehydrogenase,|5,10-methylenetetrahydrofolate cyclohydrolase|S, REa, A
	172461|rs2236225|1|63735|CCTA|C,A|omim|14.277|8|25|06|14q23.3|MTHFD, MTHFC|C|5,10-methylenetetrahydrofolate dehydrogenase,|5,10-methylenetetrahydrofolate cyclohydrolase|S, REa, A
	172462|rs2236225|1|63735|CCTA|C,A,T|omim|14.277|8|25|06|14q23.3|MTHFD, MTHFC|C|5,10-methylenetetrahydrofolate dehydrogenase,|5,10-methylenetetrahydrofolate cyclohydrolase|S, REa, A
	172463|rs2236225|1|63735|CCTA|C,A,T,G|omim|14.277|8|25|06|14q23.3|MTHFD, MTHFC|C|5,10-methylenetetrahydrofolate dehydrogenase,|5,10-methylenetetrahydrofolate cyclohydrolase|S, REa, A

读取：
	
	rdd println:10
	((1,63735,CCTA,A),(172461,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,A),(172462,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,C),(172460,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,C),(172461,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,C),(172462,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,A),(172463,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,T),(172462,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,T),(172463,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,G),(172463,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))
	((1,63735,CCTA,C),(172463,rs2236225,omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))


4.测试代码：

	  test("test By changing some value,  function:loadDataProcessing.simple,data:vcf2omimSimple.txt") {
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val file = "D:/all/idea/gcdss-master/file/callDisease/input/test/vcf2omimSimple.txt"
	    val rdd = loadDataProcessing.simple(sc, file)
	    println("rdd println:" + rdd.count())
	    rdd.foreach(println)
	    sc.stop()
	  }
	  test("test By changing some value, function:loadDataProcessing.simple ,data:vcf2omim.txt") {
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val file = "D:/all/idea/gcdss-master/file/callDisease/input/test/vcf2omim.txt"
	    val rdd = loadDataProcessing.complex(sc, file)
	    println("rdd println:" + rdd.count())
	    rdd.foreach(println)
	    sc.stop()
	  }



5.结果修改之后变成了13687条与疾病相关的。

与DataProcessing处理的数据能匹配的上，omim数量都为1956，dbSNpId都为10476.只是数据形式不一样，dataProcessing处理出来的alternateAllele有多个，所需少于13687.

	all:13687
	3 81646403 A T 0 607839 rs137852887 
	14 75032069 A G 0 604395 rs121908439 
	16 88841001 A G 0 612222 rs118204436 
	7 117587833 G A 0 602421 rs80055610 
	7 117587833 G A 0 602421 rs80055610 
	12 112450362 A C 0 176876 rs121918461 
	1 21563135 C T 0 171760 rs121918015 
	2 166277281 A G 0 603415 rs80356474 
	X 101356112 G T 0 300300 rs41310709 
	10 102837199 TGAA T 0 609300 rs121434319 
	omim distinct count:1956
	dbSnpId distinct count:10476
	vcf2omimSimpleAll:
	rdd2.count()10884
	omim distinct count:1956
	dbSnpId distinct count:10476

统计代码：

 	test("anaysis data,count :vcf2omimSimpleAllResult") {
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    val sc = new SparkContext(conf)
    val file = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimSimpleAllResult.txt"
    val rdd = sc.textFile(file).map(each => each.split('|'))
    //    rdd1.take(10).foreach(println)
    //    val rdd = sc.textFile(file).map(each => each.split(Array('|')))

    println("all:" + rdd.count())
    rdd.take(10).foreach { each =>
      each.foreach(every => print(every + " "))
      println
    }

    //    rdd.map(_ (5)).foreach(println)
    println("omim distinct count:" + rdd.map(_ (5)).distinct().count())
    println("dbSnpId distinct count:" + rdd.map(_ (6)).distinct().count())


    //DataProcessing
    println("vcf2omimSimpleAll:")
    val file2 = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimSimpleAll.txt"
    val rdd2 = sc.textFile(file2).map(each => each.split('|'))
    println("rdd2.count()"+rdd2.count())
    println("omim distinct count:" + rdd2.map(_ (0)).distinct().count())
    println("dbSnpId distinct count:" + rdd2.map(_ (1)).distinct().count())
    sc.stop()
  }