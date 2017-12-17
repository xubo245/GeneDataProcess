
前面一片已经讲了遇到的问题，之前也遇到过：

 基因数据处理31之avocado运行avocado-cli中的avocado问题3-变异识别找不到RecordGroupSample（null）  
 http://blog.csdn.net/xubo245/article/details/51525241

解决办法：

在读入的sam/bam/adam数据进行判定，如果RecordGroup等数据为空，则加上默认值


在gcdss/avocado中的run方法后

	val reads: RDD[AlignmentRecord] = LoadReads.time {
	      Input(sc, args.readInput, reference, config)
	    }

修改并加入：


	    val readsTmp: RDD[AlignmentRecord] = LoadReads.time {
	      Input(sc, args.readInput, reference, config)
	    }
	    val reads = readsTmp.map { each =>
	      if (each.getRecordGroupSample == null) {
	        each.setRecordGroupSample("sample")
	      }
	      if (each.getRecordGroupName == null) {
	        each.setRecordGroupName("read_group_id")
	      }
	      if (each.getRecordGroupPlatform == null) {
	        each.setRecordGroupPlatform("illumina")
	      }
	      if (each.getRecordGroupPlatformUnit == null) {
	        each.setRecordGroupPlatformUnit("platform_unit")
	      }
	      if (each.getRecordGroupLibrary == null) {
	        each.setRecordGroupLibrary("library")
	      }
	      each
	    }


然后就可以运行SparkBWA或者bwamem处理的sam数据了。

处理代码：
	
	hadoop@Master:~/xubo/project/callVariant/sparkBWAResult$ cat runBBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.callVariant.callVariantByAvocado \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/alignment/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0WithRG.sam \
	/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVar \
	/home/hadoop/xubo/data/testTools/basic.properties


运行结果：
	
	hadoop@Master:~/xubo/project/callVariant/sparkBWAResult$ ./runBBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition.sh 
	start main:
	start run:
	fqFile:/xubo/alignment/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0WithRG.sam
	faFile:/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVar20160627101927816
	fqLoad.count:18480
	faLoad.count:24896                                                              
	[Stage 11:======================================>                   (2 + 1) / 3]16/06/27 10:30:28 ERROR TaskSchedulerImpl: Lost executor 3 on 219.219.220.149: Executor heartbeat timed out after 157049 ms
	[Stage 11:======================================>                   (2 + 1) / 3]16/06/27 10:35:28 ERROR TaskSchedulerImpl: Lost executor 3 on 219.219.220.149: remote Rpc client disassociated
	[Stage 12:==============>                                           (1 + 3) / 4]16/06/27 10:57:26 ERROR TaskSchedulerImpl: Lost executor 154 on 219.219.220.149: Executor heartbeat timed out after 154828 ms
	[Stage 12:==============>                                           (1 + 3) / 4]16/06/27 10:58:39 ERROR TaskSchedulerImpl: Lost executor 154 on 219.219.220.149: remote Rpc client disassociated
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	read parquet:5677                                                               
	*************end*************       

数据查看：

	
	package org.gcdss.cli.load
	
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.rdd.ADAMContext._
	
	//import org.bdgenomics.avocado.AvocadoFunSuite
	
	object loadVcfFromAdamSparkBWAResult {
	  //  def resourcePath(path: String) = ClassLoader.getSystemClassLoader.getResource(path).getFile
	
	  //  def tmpFile(path: String) = Files.createTempDirectory("").toAbsolutePath.toString + "/" + path
	
	  //  def apply(local: Boolean, fqFile: String, faFile: String, configFile: String, output: String) {
	  def main(args: Array[String]) {
	    println("start:")
	    //    var conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("spark://219.219.220.149:7077")
	    var conf = new SparkConf().setAppName("AvocadoSuite").setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val startTime = System.currentTimeMillis()
	    //    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/vcf/All_20160407.vcf"
	    //    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/vcf/small.vcf"
	//    val path = "file/callVariant/small.adam"
	    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/avocado/output/sparkBWA/BBg38L50c10000Nhs20Paired12YarnT201606252236LocalNopartition/SparkBWA_g38L50c10000Nhs20Paired1.fastq-0-NoSort-local-1466932122385-0.samVarNoRG20160627113153282/"
	
	    val rdd = sc.loadVariantAnnotations(path)
	    println(rdd.count())
	    val loadTime = System.currentTimeMillis()
	    println("load time:" + (loadTime - startTime) + " ms")
	    //    rdd.take(10).foreach(println)
	    rdd.foreach(println)
	
	    val saveTime = System.currentTimeMillis()
	    println("rdd.count:"+rdd.count())
	    println("run time:" + (saveTime - startTime) + " ms")
	    println("*************end*************")
	    sc.stop()
	
	  }
	
	}

部分结果：
	
	
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "chr1", "contigLength": 248956422, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 248855372, "end": 248855373, "referenceAllele": "C", "alternateAllele": "G", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 60.0, "mapq0Reads": null, "mqRankSum": null, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sample", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 0, "alternateReadDepth": 1, "readDepth": 1, "minReadDepth": null, "genotypeQuality": 5, "genotypeLikelihoods": [-3.9818644E-4, -0.6931472, -7.828789], "nonReferenceLikelihoods": [-3.9818644E-4, -0.6931472, -7.828789], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "chr1", "contigLength": 248956422, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 248934548, "end": 248934549, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 60.0, "mapq0Reads": null, "mqRankSum": null, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sample", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 0, "alternateReadDepth": 1, "readDepth": 1, "minReadDepth": null, "genotypeQuality": 3, "genotypeLikelihoods": [-7.946439E-4, -0.6931472, -7.138014], "nonReferenceLikelihoods": [-7.946439E-4, -0.6931472, -7.138014], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "chr1", "contigLength": 248956422, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 248934572, "end": 248934573, "referenceAllele": "C", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 60.0, "mapq0Reads": null, "mqRankSum": null, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sample", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 0, "alternateReadDepth": 1, "readDepth": 1, "minReadDepth": null, "genotypeQuality": 15, "genotypeLikelihoods": [-2.511918E-5, -0.6931472, -10.591891], "nonReferenceLikelihoods": [-2.511918E-5, -0.6931472, -10.591891], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "chr1", "contigLength": 248956422, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 248943770, "end": 248943771, "referenceAllele": "A", "alternateAllele": "T", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 60.0, "mapq0Reads": null, "mqRankSum": null, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sample", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 0, "alternateReadDepth": 1, "readDepth": 1, "minReadDepth": null, "genotypeQuality": 3, "genotypeLikelihoods": [-7.946439E-4, -0.6931472, -7.138014], "nonReferenceLikelihoods": [-7.946439E-4, -0.6931472, -7.138014], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "chr1", "contigLength": 248956422, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 248943800, "end": 248943801, "referenceAllele": "A", "alternateAllele": "G", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 60.0, "mapq0Reads": null, "mqRankSum": null, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sample", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 0, "alternateReadDepth": 1, "readDepth": 1, "minReadDepth": null, "genotypeQuality": 3, "genotypeLikelihoods": [-7.946439E-4, -0.6931472, -7.138014], "nonReferenceLikelihoods": [-7.946439E-4, -0.6931472, -7.138014], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	rdd.count:5677
	run time:8708 ms
	*************end*************
	
	
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
	