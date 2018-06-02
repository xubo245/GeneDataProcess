（一）问题

问题1：avocado数据读取：

avocado存到磁盘是：RDD[Genotype]

    val processedGenotypes: RDD[Genotype] = postProcessVariants(calledVariants, stats).flatMap(variantContext => variantContext.genotypes)

	  // save variants to output file
    log.info("Writing calls to disk.")
    SaveVariants.time {
      processedGenotypes.adamParquetSave(args.variantOutput,
        args.blockSize,
        args.pageSize,
        args.compressionCodec,
        args.disableDictionaryEncoding)


所以读取也要loadGenotypes，然后继续转换，变成RDD[VariantContext]

    val rdd = sc.loadGenotypes(path)
    var rdd2 = rdd.map(_.getVariant).map(each => VariantContext(each))

然后才可以调用处理函数：
	
	    val vcf2Omim = new Vcf2Omim(rdd2)
	    val returnRDD = vcf2Omim.runComplex(sc, vcf2omimSimpleFile)


问题2：变异数据的染色体是chr开头，训练的数据库是数字，所以要去除chr:

将VCFOmim类中compute方法中的

	 val vcfArrRDD = vcfRDD.map(_.variant.variant).map { each =>
		      ((each.getContig.getContigName, each.getStart.toString, each.getReferenceAllele, each.getAlternateAllele), each.getVariantErrorProbability)
		    }

改成：

	 val vcfArrRDD = vcfRDD.map(_.variant.variant).map { each =>
	      ((each.getContig.getContigName, each.getStart.toString, each.getReferenceAllele, each.getAlternateAllele), each.getVariantErrorProbability)
	    }.map{each=>
	      /**
	        * 训练得出的数据库染色体是以数字表示的，没有chr开头
	        */
	      if (each._1._1.startsWith("chr")) {
	        (((each._1._1.split("r")) (1).toString, each._1._2, each._1._3, each._1._4), each._2)
	      } else {
	        each
	      }
	    }



问题3：BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition中没有omim变异，所以返回结果为零，为了检测其正确性，所以加了下面的测试

  	/**
      * 手动加上一个进行测试，检测是否运行正常
      * 如何样本中没有omim变异数据，可以用下面的进行手动添加测试
      * 但为什么是3？
      */

    var flag = true
    rdd2 = rdd2.map { each =>
      if (flag == true) {
        each.variant.setStart(229432659L)
        each.variant.setReferenceAllele("T")
        each.variant.setAlternateAllele("C")
        flag = false
      }
      each
    }

（二）代码：

 test("test data:.sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition vcf") {
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    val sc = new SparkContext(conf)
    //    var vcfFile = "D:/all/idea/gcdss-master/file/callDisease/input/small.vcf"
    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVarNoRG20160627113153282/"

    var output = "D:/all/idea/gcdss-master/file/callDisease/output/vcf2omim/test1"
    //    val vcf2omimSimpleFile = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimAll.txt"
    val vcf2omimSimpleFile = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimAll.txt"
    val sd: Option[SequenceDictionary] = None
    //    val rdd = sc.loadVariantAnnotations(path)
    val rdd = sc.loadGenotypes(path)
    println(rdd.count())
    println(rdd.toDebugString)
    rdd.map(_.getVariant).foreach(println)
    var rdd2 = rdd.map(_.getVariant).map(each => VariantContext(each))

    /**
      * 手动加上一个进行测试，检测是否运行正常
      * 如何样本中没有omim变异数据，可以用下面的进行手动添加测试
      * 但为什么是3？
      */
    var flag = true
    rdd2 = rdd2.map { each =>
      if (flag == true) {
        each.variant.setStart(229432659L)
        each.variant.setReferenceAllele("T")
        each.variant.setAlternateAllele("C")
        flag = false
      }
      each
    }

    println("vatiantContext count:" + rdd2.count())

    //    val rdd0 = sc.loadVcf(vcfFile, sd)

    println("start call Vcf2Omim")
    val vcf2Omim = new Vcf2Omim(rdd2)
    val returnRDD = vcf2Omim.runComplex(sc, vcf2omimSimpleFile)
    println("runComplex end")
    println("returnRDD.count:" + returnRDD.count())
    returnRDD.foreach(println)

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val output1 = output + "/ComplexT" + iString
    println("output:" + output1)

    val saveRDD = returnRDD.map { each =>
      val str1 = each._1.split(Array(',', '(', ')'))
      println(str1.length)
      str1.foreach(every => print("|" + every + "| "))
      val str = str1(1) + '|' + str1(2) + '|' + str1(3) + '|' + str1(4) + '|' + each._2 + '|' +
        each._3 + '|' + each._4 + '|' + each._5 + '|' + each._6 + '|' + each._7 + '|' +
        each._8 + '|' + each._9 + '|' + each._10 + '|' + each._11 + '|' + each._12 + '|' +
        each._13 + '|' + each._14 + '|' + each._15
      str
    }
    //    returnRDD.repartition(1).saveAsTextFile(output)
    saveRDD.repartition(1).saveAsTextFile(output1)

    sc.stop()
  }


位置：

	package org.gcdss.cli.disease
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.models.{VariantContext, SequenceDictionary}
	import org.scalatest.FunSuite
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	/**
	  * Created by xubo on 2016/6/9.
	  */
	class vcf2omimSuite extends FunSuite {


（三）部分结果：

	vcfRDD:
	((1,229432659,T,C),null)
	((1,914022,A,G),null)
	((1,931246,T,A),null)
	((1,931248,G,T),null)
	((1,996956,C,T),null)
	((1,1041378,A,C),null)
	((1,1041404,C,T),null)
	((1,1084438,C,T),null)
	((1,1109119,A,C),null)
	((1,1109253,G,T),null)
	vcfRDDJoin:5677
	vcf2omimRDDJoin:5677
	runComplex end
	nalParquetRecordReader: block read in memory in 15 ms. row count = 2174

	
	((1,229432660,T,C),0,102610,rs121909520,omim,1.1474,8,2,13,1q42.13,ACTA1, ASMA, NEM3, CFTD1,C,Actin, alpha-1, skeletal muscle,,REa, H, A)
	((1,229432660,T,C),0,102610,rs121909520,omim,1.1474,8,2,13,1q42.13,ACTA1, ASMA, NEM3, CFTD1,C,Actin, alpha-1, skeletal muscle,,REa, H, A)
	((1,229432660,T,C),0,102610,rs121909520,omim,1.1474,8,2,13,1q42.13,ACTA1, ASMA, NEM3, CFTD1,C,Actin, alpha-1, skeletal muscle,,REa, H, A)
	output:D:/all/idea/gcdss-master/file/callDisease/output/vcf2omim/test1/ComplexT20160627233506311
	5
	|| |1| |229432660| |T| |C| 5
	|| |1| |229432660| |T| |C| 5
	|| |1| |229432660| |T| |C|


生成的数据文件：

	1|229432660|T|C|0|102610|rs121909520|omim|1.1474|8|2|13|1q42.13|ACTA1, ASMA, NEM3, CFTD1|C|Actin, alpha-1, skeletal muscle||REa, H, A
	1|229432660|T|C|0|102610|rs121909520|omim|1.1474|8|2|13|1q42.13|ACTA1, ASMA, NEM3, CFTD1|C|Actin, alpha-1, skeletal muscle||REa, H, A
	1|229432660|T|C|0|102610|rs121909520|omim|1.1474|8|2|13|1q42.13|ACTA1, ASMA, NEM3, CFTD1|C|Actin, alpha-1, skeletal muscle||REa, H, A

疑问，为什么会是三个？