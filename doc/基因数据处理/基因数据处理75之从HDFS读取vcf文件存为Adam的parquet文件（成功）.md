

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
