	
	
由于每次make都需要下载spark包，180M，所以在Make中将其注释掉了。

然后运行make：
	
	hadoop@Mcnode1:~/xubo/tools/SparkBWA$ make
	if [ ! -d "build" ]; then mkdir build; fi
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS -I/usr/lib/jvm/jdk1.7.0/include -I/usr/lib/jvm/jdk1.7.0/include/linux ./src/bwa_jni.c -o build/bwa_jni.o -lrt  
	./src/bwa_jni.c: In function ‘Java_BwaJni_bwa_1jni’:
	./src/bwa_jni.c:55:21: warning: assignment discards ‘const’ qualifier from pointer target type [enabled by default]
	          argvTmp[i] = (*env)->GetStringUTFChars(env, string, 0);
	                     ^
	make -C ./bwa/bwa-0.7.12
	make[1]: Entering directory `/home/hadoop/xubo/tools/SparkBWA/bwa/bwa-0.7.12'
	make[1]: Nothing to be done for `all'.
	make[1]: Leaving directory `/home/hadoop/xubo/tools/SparkBWA/bwa/bwa-0.7.12'
	if [ ! -d "build" ]; then mkdir build; fi
	cp ./bwa/bwa-0.7.12/*.o build
	gcc -shared -o build/libbwa.so build/*.o -lrt 
	cd build && zip -r bwa ./* && cd ..
	updating: QSufSort.o (deflated 66%)
	updating: bamlite.o (deflated 67%)
	updating: bntseq.o (deflated 70%)
	updating: bwa.o (deflated 70%)
	updating: bwa_jni.o (deflated 70%)
	updating: bwamem.o (deflated 70%)
	updating: bwamem_extra.o (deflated 75%)
	updating: bwamem_pair.o (deflated 65%)
	updating: bwape.o (deflated 69%)
	updating: bwase.o (deflated 68%)
	updating: bwaseqio.o (deflated 67%)
	updating: bwashm.o (deflated 70%)
	updating: bwt.o (deflated 66%)
	updating: bwt_gen.o (deflated 68%)
	updating: bwt_lite.o (deflated 64%)
	updating: bwtaln.o (deflated 71%)
	updating: bwtgap.o (deflated 70%)
	updating: bwtindex.o (deflated 71%)
	updating: bwtsw2_aux.o (deflated 68%)
	updating: bwtsw2_chain.o (deflated 64%)
	updating: bwtsw2_core.o (deflated 70%)
	updating: bwtsw2_main.o (deflated 72%)
	updating: bwtsw2_pair.o (deflated 64%)
	updating: fastmap.o (deflated 72%)
	updating: is.o (deflated 65%)
	updating: kopen.o (deflated 69%)
	updating: kstring.o (deflated 65%)
	updating: ksw.o (deflated 71%)
	updating: kthread.o (deflated 65%)
	updating: libbwa.so (deflated 64%)
	updating: main.o (deflated 78%)
	updating: malloc_wrap.o (deflated 70%)
	updating: maxk.o (deflated 66%)
	updating: pemerge.o (deflated 69%)
	updating: utils.o (deflated 69%)
	updating: Bwa.class (deflated 56%)
	updating: BwaInterpreter$BigFastq2RDDDouble.class (deflated 52%)
	updating: BwaInterpreter$BigFastq2RDDPartitionsDouble.class (deflated 50%)
	updating: BwaInterpreter.class (deflated 54%)
	updating: BwaJni.class (deflated 32%)
	updating: BwaOptions.class (deflated 54%)
	updating: BwaRDD$BwaAlignment.class (deflated 49%)
	updating: BwaRDD.class (deflated 48%)
	updating: BwaSeq.class (deflated 24%)
	updating: FastqInputFormat.class (deflated 56%)
	updating: FastqInputFormatDouble.class (deflated 56%)
	updating: FastqRecordReader.class (deflated 50%)
	updating: FastqRecordReaderDouble.class (deflated 50%)
	updating: SparkBWA.class (deflated 23%)
	updating: SparkBWA.jar (deflated 6%)
	updating: paired.sh (deflated 56%)
	updating: pairedGRCH38L1.sh (deflated 58%)
	#cd ./libs && wget http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz && tar xzvf spark-1.6.1-bin-hadoop2.6.tgz && cp spark-1.6.1-bin-hadoop2.6/lib/spark-assembly-1.6.1-hadoop2.6.0.jar ./ && rm -Rf spark-1.6.1-bin-hadoop2.6 && rm spark-1.6.1-bin-hadoop2.6.tgz && cd ..
	javac -cp ./libs/commons-cli-1.2.jar:./libs/spark-assembly-1.6.1-hadoop2.6.0.jar -d build -Xlint:none ./src/*.java
	cd build && jar cfe SparkBWA.jar SparkBWA ./*.class && cd ..
	#cd build && jar cfe SparkBWASeq.jar BwaSeq ./*.class && cd ..
	================================================================================
	SparkBWA has been compiled.
	Location    = /home/hadoop/xubo/tools/SparkBWA/build/
	JAVA_HOME   = /usr/lib/jvm/jdk1.7.0
	HADOOP_HOME = /home/hadoop/cloud/hadoop-2.6.0/
