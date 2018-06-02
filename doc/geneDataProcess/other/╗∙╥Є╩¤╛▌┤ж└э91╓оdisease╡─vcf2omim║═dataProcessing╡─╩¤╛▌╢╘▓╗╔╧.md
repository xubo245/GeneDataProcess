


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