

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
import org.apache.spark.rdd.RDD
import org.bdgenomics.adam.models.{SequenceDictionary, VariantContext}
import org.bdgenomics.adam.rdd.ADAMContext._

/**
  * Created by xubo on 2016/5/23.
  */

class Vcf2Omim(vcfRDD: RDD[VariantContext]) {
  def compute(): RDD[((String, String, String, String), Integer)] = {
    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    //    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    //    val sc = new SparkContext(conf)
    println("start:")
    //    println(vcfArr.length)
    println("Vcf2Omim")
    //    vcfRDD.map(_.variant.variant).foreach(println)
    val vcfArrRDD = vcfRDD.map(_.variant.variant).map { each =>
      ((each.getContig.getContigName, each.getStart.toString, each.getReferenceAllele, each.getAlternateAllele), each.getVariantErrorProbability)
    }
    println("vcfArrRDD:")
    //    vcfArrRDD.foreach(println)
    println("end")
    vcfArrRDD
  }

  def runSimple(sc: SparkContext, file: String): RDD[(String, String, String, String)] = {
    val vcfRDD = compute()
    val vcf2omimRDD = loadDataProcessing.simple(sc, file)
    //    vcf2omimRDD.jo
    val vcfRDDJoin = vcfRDD.map { each =>
      ((each._1._1, ((each._1._2).toInt + 1).toString(), each._1._3, each._1._4), each._2)
    }
      .map { each =>
        (each._1.toString(), (each._2.toString))
      }
    val vcf2omimRDDJoin = vcf2omimRDD.map { each =>
      (each._1.toString(), (each._2, each._3))
    }
    println("vcfRDDJoin:" + vcfRDDJoin.count())
    vcfRDDJoin.foreach(println)
    println("vcf2omimRDDJoin:" + vcfRDDJoin.count())
    vcf2omimRDDJoin.foreach(println)


    val joinRDD = vcfRDDJoin.join(vcf2omimRDDJoin)
    val outputRDD = joinRDD.map { each =>
      (each._1, each._2._1, each._2._2._1, each._2._2._2)
    }
    outputRDD
  }

}

object Vcf2Omim {
  def main(args: Array[String]) {
    if (args.length < 3) {
      System.err.println("at least three argument required, e.g.1. vcfFile 2.vcf2omimSimple")
      System.exit(1)
    }
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)
    //    var vcfFile = "D:/all/idea/gcdss-master/file/callDisease/input/small.vcf"
    //    var output = "D:/all/idea/gcdss-master/file/callDisease/output/vcf2omim/test1"
    //    val vcf2omimSimpleFile = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimSimple.txt"
    var vcfFile = args(0)
    val vcf2omimSimpleFile = args(1)
    val sd: Option[SequenceDictionary] = None
    val rdd = sc.loadVcf(vcfFile, sd)
    //    rdd.map(_.variant.variant).foreach(println)

    //        val vcfRDD = sc.loadGenotypes(vcfFile).toVariantContext.collect.sortBy(_.position)
    //        println("vcfRDD.head:")
    //        println(vcfRDD.head.genotypes.size)
    println("start call Vcf2Omim")
    val vcf2Omim = new Vcf2Omim(rdd)
    val returnRDD = vcf2Omim.runSimple(sc, vcf2omimSimpleFile)
    println("returnRDD.count:" + returnRDD.count())
    returnRDD.foreach(println)
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val output = args(2) + "/T" + iString
    println("output:" + output)
    returnRDD.saveAsTextFile(output)
    sc.stop()
  }
}




2.测试：

package org.gcdss.cli.disease

import org.apache.spark.{SparkConf, SparkContext}
import org.bdgenomics.adam.models.SequenceDictionary
import org.scalatest.FunSuite
import org.bdgenomics.adam.rdd.ADAMContext._

/**
  * Created by xubo on 2016/6/9.
  */
class vcf2omimSuite extends FunSuite {
  test("vcf2omim simple") {
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    val sc = new SparkContext(conf)
    var vcfFile = "D:/all/idea/gcdss-master/file/callDisease/input/small.vcf"
    var output = "D:/all/idea/gcdss-master/file/callDisease/output/vcf2omim/test1"
    val vcf2omimSimpleFile = "D:/all/idea/gcdss-master/file/callDisease/input/vcf2omimSimple.txt"
    val sd: Option[SequenceDictionary] = None
    val rdd = sc.loadVcf(vcfFile, sd)
    rdd.map(_.variant.variant).foreach(println)

    //        val vcfRDD = sc.loadGenotypes(vcfFile).toVariantContext.collect.sortBy(_.position)
    //        println("vcfRDD.head:")
    //        println(vcfRDD.head.genotypes.size)
    println("start call Vcf2Omim")
    val vcf2Omim = new Vcf2Omim(rdd)
   val returnRDD= vcf2Omim.runSimple(sc,vcf2omimSimpleFile)
    println("returnRDD.count:"+returnRDD.count())
    returnRDD.foreach(println)
    sc.stop()
  }
}


3.脚本：

hadoop@Master:~/xubo/project/callDisease/Vcf2Omim$ cat load.sh 
    #!/usr/bin/env bash  
    spark-submit   \
--class  org.gcdss.cli.disease.Vcf2Omim \
--master spark://219.219.220.149:7077 \
--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
--executor-memory 4096M \
--total-executor-cores 20 BWAMEMSparkAll.jar \
 /xubo/callDisease/input/VCF2Omim/small.vcf /xubo/callDisease/input/VCF2Omim/vcf2omimSimple.txt /xubo/callDisease/output/VCF2Omim


4.结果：

hadoop@Master:~/xubo/project/callDisease/Vcf2Omim$ ./load.sh 
start call Vcf2Omim
start:
Vcf2Omim
vcfArrRDD:
end
vcfRDDJoin:5                                                                    
vcf2omimRDDJoin:5
returnRDD.count:1                                                               
output:/xubo/callDisease/output/VCF2Omim/T20160610002428038


5.数据：

((1,63735,CCTA,C),2994,rs2236225,rs2236225)


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
	