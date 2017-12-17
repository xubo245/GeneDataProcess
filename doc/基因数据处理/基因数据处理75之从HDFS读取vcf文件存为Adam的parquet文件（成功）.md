

1.参考：

	package org.bdgenomics.adam.cli
	class FlattenSuite extends ADAMFunSuite {
    val loader = Thread.currentThread().getContextClassLoader
    val inputPath = loader.getResource("small.vcf").getPath
    val outputFile = File.createTempFile("adam-cli.FlattenSuite", ".adam")
    val outputPath = outputFile.getAbsolutePath
    val flatFile = File.createTempFile("adam-cli.FlattenSuite", ".adam-flat")
    val flatPath = flatFile.getAbsolutePath

    assert(outputFile.delete(), "Couldn't delete (empty) temp file")
    assert(flatFile.delete(), "Couldn't delete (empty) temp file")

    val argLine = "%s %s".format(inputPath, outputPath).split("\\s+")
    val args: Vcf2ADAMArgs = Args4j.apply[Vcf2ADAMArgs](argLine)
    val vcf2Adam = new Vcf2ADAM(args)
    vcf2Adam.run(sc)


2.代码：

	package org.gcdss.cli.load
	
	import org.apache.spark.sql.SQLContext
	import org.apache.spark.{SparkConf, SparkContext}
	import org.bdgenomics.adam.cli.{Vcf2ADAMArgs, Vcf2ADAM}
	import org.bdgenomics.adam.rdd.ADAMContext
	import org.bdgenomics.adam.rdd.ADAMContext._
	import org.bdgenomics.utils.cli.Args4j
	
	//import org.bdgenomics.avocado.AvocadoFunSuite
	
	object Callvcf2Adam {
	  //  def resourcePath(path: String) = ClassLoader.getSystemClassLoader.getResource(path).getFile
	
	  //  def tmpFile(path: String) = Files.createTempDirectory("").toAbsolutePath.toString + "/" + path
	
	  //  def apply(local: Boolean, fqFile: String, faFile: String, configFile: String, output: String) {
	  def main(args: Array[String]) {
	    println("start:")
	    var conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("spark://219.219.220.149:7077")
	    //    var conf = new SparkConf().setAppName("AvocadoSuite").setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val startTime = System.currentTimeMillis()
	    val path = "hdfs://219.219.220.149:9000/xubo/callVariant/vcf/All_20160407.vcf"
	    val output = "/xubo/callVariant/vcf/All_20160407.adam"
	    val argLine = "%s %s".format(path, output).split("\\s+")
	    val args: Vcf2ADAMArgs = Args4j.apply[Vcf2ADAMArgs](argLine)
	    //    val arr=Array(argLine)
	    val vcf2Adam = new Vcf2ADAM(args)
	    vcf2Adam.run(sc)
	    val saveTime = System.currentTimeMillis()
	    println("run time:" + (saveTime - startTime) + " ms")
	    println("*************end*************")
	    sc.stop()
	  }
	}


3.结果：
202个小文件

时间：
211898ms
有点快。

通过adam-shell读取，记录为0：
                                                                      
scala> val rdd= sc.loadVariantAnnotations("/xubo/callVariant/vcf/All_20160407.adam")
print(rdd.count)


0         


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
	