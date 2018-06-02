更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
##1.1 原因
spark下没法编译，有问题

	[INFO] Makefile:18: recipe for target 'sparkbwa' failed
	[INFO] make: *** [sparkbwa] Error 1
	[INFO] make: Leaving directory 'C:/all/idea/SparkBWA-0.2/src/main/native'
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 3.454 s
	[INFO] Finished at: 2017-01-22T23:51:46+08:00
	[INFO] Final Memory: 20M/307M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal org.codehaus.mojo:exec-maven-plugin:1.1.1:exec (makeBwa) on project SparkBWA: Result of cmd.exe /X /C "make -C ./src/main/native/" execution is: '2'. -> [Help 1]
	[ERROR] 
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR] 
## 1.2 步骤

	ubuntu下IDEA修改代码
	mvn package
	scp xubo@Mcnodex1:/home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/target/SparkBWA-0.2.jar .
	运行

## 1.3运行脚本

	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ cat runsparkBWA2.sh 
	
	for j in 10000 100000 1000000 10000000
	do
	for i in 50 100
	do
	
	fq1='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired1.fastq'
	fq2='/xubo/project/alignment/sparkBWA/input/g38/g38L'$i'c'$j'Nhs20Paired2.fastq'
	
	out='/xubo/project/alignment/sparkBWA/output/g38/CCg38L'$i'c'$j'Nhs20Paired12YarnT201701222304'
	
	echo $fq1
	echo $fq2
	echo $out
	
	spark-submit --class com.github.sparkbwa.SparkBWA --master yarn-client --driver-memory 1500m --executor-memory 7g --executor-cores 1 --num-executors 7 \
	 SparkBWA-0.2.jar -n 7 -m -r -s -i /home/hadoop/disk2/xubo/ref/GRCH38L1Index/GRCH38chr1L3556522.fasta \
	-w "-R @RG\tID:foo\tLB:bar\tPL:illumina\tPU:illumina\tSM:ERR000589" \
	$fq1 $fq2 $out
	
	
	done 
	done

## 1.4 结果
		
	hadoop@Master:~/disk2/xubo/project/alignment/sparkBWA$ ./runsparkBWA2.sh 
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000Nhs20Paired12YarnT201701222304
	time:   42      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000Nhs20Paired12YarnT201701222304
	time:   43      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c100000Nhs20Paired12YarnT201701222304
	time:   56      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c100000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c100000Nhs20Paired12YarnT201701222304
	time:   40      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c1000000Nhs20Paired12YarnT201701222304
	time:   77      s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c1000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c1000000Nhs20Paired12YarnT201701222304
	time:   124     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L50c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L50c10000000Nhs20Paired12YarnT201701222304
	time:   431     s                                                               
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired1.fastq
	/xubo/project/alignment/sparkBWA/input/g38/g38L100c10000000Nhs20Paired2.fastq
	/xubo/project/alignment/sparkBWA/output/g38/CCg38L100c10000000Nhs20Paired12YarnT201701222304
	time:   561     s 


参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
