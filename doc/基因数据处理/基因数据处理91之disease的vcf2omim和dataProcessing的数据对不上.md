


1.介绍：   
vcf2omim数据量为：rdd2.count:8623	   
dataProcessing数据为：
rdd2.count:10884
sum:2300
8584

2300为AlternateAllele有逗号的数量，例如ref为A，AlternateAllele为G,C


2.原因分析，主要是读入vcf时上诉情况会变成两条：
数据：

	1	10493	rs199606420	C	A,G	.	.	RS=199606420;RSPOS=10493;dbSNPBuildID=137;SSR=0;SAO=0;VP=0x050000020005000002000100;GENEINFO=DDX11L1:100287102;WGT=1;VC=SNV;R5;ASP


loadVcf：

	{"variantErrorProbability": null, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 10492, "end": 10493, "referenceAllele": "C", "alternateAllele": "A", "svAllele": null, "isSomatic": false}
	{"variantErrorProbability": null, "contig": {"contigName": "1", "contigLength": null, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 10492, "end": 10493, "referenceAllele": "C", "alternateAllele": "G", "svAllele": null, "isSomatic": false}


3.测试代码：
	
	  test("test data:All_20160407L10000.vcf") {
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    var vcfFile = "D:/all/idea/gcdss-master/file/callDisease/input/All_20160407L10000.vcf"
	    var output = "D:/all/idea/gcdss-master/file/callDisease/output/vcf2omim/test1"
	    val vcf2omimFile = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimAll.txt"
	    val sd: Option[SequenceDictionary] = None
	    val rdd = sc.loadVcf(vcfFile, sd)
	
	    val rddAlternateAllele = rdd.map { each =>
	      each.variant.variant.getAlternateAllele
	    }
	
	    rdd.foreach { each =>
	      if ((each.variant.variant.getStart.toInt + 1) == 10493) {
	        println(each.variant.variant)
	      }
	    }
	    println(rddAlternateAllele.count())
	    rddAlternateAllele.take(10).foreach(println)
	    rddAlternateAllele.foreach { each =>
	      if (each.split(',').length > 1) {
	        println(each)
	      }
	    }
	    sc.stop()
	  }
	  
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
	