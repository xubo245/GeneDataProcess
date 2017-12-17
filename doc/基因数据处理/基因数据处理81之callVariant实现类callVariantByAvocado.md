

1.代码：

	package org.gcdss.cli.callVariant
	
	import java.text.SimpleDateFormat
	import java.util._
	
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.rdd.ADAMContext._
	import org.gcdss.cli.Gcdss
	
	//import org.bdgenomics.avocado.AvocadoFunSuite
	class callVariantByAvocado(fqFile: String, faFile: String, output: String, configFile: String) {
	  def run(sc: SparkContext): Unit = {
	    println("start run:")
	    val fqLoad = sc.loadAlignments(fqFile)
	    val faLoad = sc.loadFasta(faFile, 10000)
	    println("fqFile:" + fqFile)
	    println("faFile:" + faFile)
	    println("configFile:" + configFile)
	    println("output:" + output)
	
	    println("fqLoad.count:" + fqLoad.count)
	    println("faLoad.count:" + faLoad.count)
	    Gcdss(Array(fqFile, faFile, output, configFile)).run(sc)
	    val read1 = sc.loadAlignments(output)
	    println("read parquet:" + read1.count())
	    read1.foreach(println)
	    println("*************end*************")
	  }
	
	}
	
	object callVariantByAvocado {
	  def main(args: Array[String]) {
	    if (args.length < 4) {
	      System.err.println("at least three argument required, e.g. vcfFile dbSnp2omimFile omimFile outputPath")
	      System.exit(1)
	    }
	    println("start main:")
	    var conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val callVariantByAvocadoMaster = new callVariantByAvocado(args(0), args(1), args(2) + iString, args(3))
	    callVariantByAvocadoMaster.run(sc)
	    sc.stop()
	
	  }
	
	  def runLocal(args: Array[String]): Unit = {
	    if (args.length < 4) {
	      System.err.println("at least three argument required, e.g. vcfFile dbSnp2omimFile omimFile outputPath")
	      System.exit(1)
	    }
	    var conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val callVariantByAvocadoLocal = new callVariantByAvocado(args(0), args(1), args(2) + iString, args(3))
	    callVariantByAvocadoLocal.run(sc)
	    sc.stop()
	  }
	
	}


2.测试：

	package org.gcdss.cli.callVariant
	
	import org.scalatest.FunSuite
	
	/**
	  * Created by xubo on 2016/6/9.
	  */
	class callVariantByAvocadoLocalSuite extends FunSuite {
	  test("artificial fa By runLocal") {
	//    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    println("start callVariantByAvocadoLocalSuite:")
	    val fqFile = "hdfs://219.219.220.149:9000/xubo/callVariant/avocado/artificial/artificial.realigned.sam"
	    val faFile = "hdfs://219.219.220.149:9000/xubo/callVariant/avocado/artificial/artificial.fa"
	    val output = "hdfs://219.219.220.149:9000/xubo/callVariant/avocado/output/artificialT"
	    val configFile = "D:/all/idea/gcdss-master/file/avocado-sample-configs/basic.properties"
	
	    callVariantByAvocado.runLocal(Array(fqFile, faFile, output, configFile))
	    println("end")
	    //      .runLocal
	  }
	}

运行结果：
	
	start run:
	2016-06-09 13:18:07 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%20, but we couldn't find any external IP address!
	fqFile:hdfs://219.219.220.149:9000/xubo/callVariant/avocado/artificial/artificial.realigned.sam
	faFile:hdfs://219.219.220.149:9000/xubo/callVariant/avocado/artificial/artificial.fa
	configFile:D:/all/idea/gcdss-master/file/avocado-sample-configs/basic.properties
	output:hdfs://219.219.220.149:9000/xubo/callVariant/avocado/output/artificialT20160609131806104
	fqLoad.count:10
	faLoad.count:1
	Loading reads in from hdfs://219.219.220.149:9000/xubo/callVariant/avocado/artificial/artificial.realigned.sam
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	read parquet:11
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 33, "end": 44, "referenceAllele": "AGGGGGGGGGG", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": null, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 0, "alternateReadDepth": 5, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 18, "genotypeLikelihoods": [-1.1486835E-6, -3.465736, -77.136604], "nonReferenceLikelihoods": [-1.1486835E-6, -3.465736, -77.136604], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 54, "end": 55, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 55, "end": 56, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 56, "end": 57, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 57, "end": 58, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 58, "end": 59, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 59, "end": 60, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 60, "end": 61, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 61, "end": 62, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 62, "end": 63, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	{"variant": {"variantErrorProbability": null, "contig": {"contigName": "artificial", "contigLength": 1120, "contigMD5": null, "referenceURL": null, "assembly": null, "species": null, "referenceIndex": null}, "start": 63, "end": 64, "referenceAllele": "G", "alternateAllele": "A", "svAllele": null, "isSomatic": false}, "variantCallingAnnotations": {"variantIsPassing": null, "variantFilters": [], "downsampled": null, "baseQRankSum": null, "fisherStrandBiasPValue": "Infinity", "rmsMapQ": 94.12757, "mapq0Reads": null, "mqRankSum": -1.7320508, "readPositionRankSum": null, "genotypePriors": [], "genotypePosteriors": [], "vqslod": null, "culprit": null, "attributes": {}}, "sampleId": "sequencing_center", "sampleDescription": null, "processingDescription": null, "alleles": ["Ref", "Alt"], "expectedAlleleDosage": null, "referenceReadDepth": 2, "alternateReadDepth": 3, "readDepth": 5, "minReadDepth": null, "genotypeQuality": 2147483647, "genotypeLikelihoods": [-32.23619, -3.465736, -44.90041], "nonReferenceLikelihoods": [-32.23619, -3.465736, -44.90041], "strandBiasComponents": [], "splitFromMultiAllelic": false, "isPhased": false, "phaseSetId": null, "phaseQuality": null}
	*************end*************
	end


4.脚本：
	
	hadoop@Master:~/xubo/project/callVariant$ cat load2.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.callVariant.callVariantByAvocado \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/callVariant/avocado/artificial/artificial.realigned.sam /xubo/callVariant/avocado/artificial/artificial.fa /xubo/callVariant/avocado/output/artificialT /home/hadoop/xubo/data/testTools/basic.properties


运行记录：

	hadoop@Master:~/xubo/project/callVariant$ ./load2.sh 
	start main:
	start run:
	fqFile:/xubo/callVariant/avocado/artificial/artificial.realigned.sam
	faFile:/xubo/callVariant/avocado/artificial/artificial.fa
	configFile:/home/hadoop/xubo/data/testTools/basic.properties
	output:/xubo/callVariant/avocado/output/artificialT20160609132038080
	fqLoad.count:10
	faLoad.count:1
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".                
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	read parquet:11                                                                 
	*************end*************
