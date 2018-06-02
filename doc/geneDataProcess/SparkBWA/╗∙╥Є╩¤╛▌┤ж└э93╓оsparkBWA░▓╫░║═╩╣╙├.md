	
1.安装
	
	git clone https://github.com/citiususc/SparkBWA.git
	cd SparkBWA
	make
	
2.使用：
报错：没有成功
	
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./run.sh 
	Error: Must specify a primary resource (JAR or Python or R file)
	Run with --help for usage help or --verbose for debug output
	./run.sh: line 5: --executor-memory: command not found
	./run.sh: line 11: -index: command not found
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ vi run.sh 
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./run.sh 
	Error: Must specify a primary resource (JAR or Python or R file)
	Run with --help for usage help or --verbose for debug output
	./run.sh: line 5: --executor-memory: command not found
	./run.sh: line 13: -index: command not found
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ vi run.sh 
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ls
	run.sh  SparkBWA.jar
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./run.sh 
	Error: Must specify a primary resource (JAR or Python or R file)
	Run with --help for usage help or --verbose for debug output
	./run.sh: line 5: --executor-memory: command not found
	./run.sh: line 13: -index: command not found
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ vi run.sh 
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./run.sh 
	Error: Must specify a primary resource (JAR or Python or R file)
	Run with --help for usage help or --verbose for debug output
	./run.sh: line 5: --executor-memory: command not found
	./run.sh: line 14: /home/hadoop/xubo/data/alignment/bwa/datatest.fa: Permission denied
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ vi run.sh 
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./run.sh 
	Error: Must specify a primary resource (JAR or Python or R file)
	Run with --help for usage help or --verbose for debug output
	./run.sh: line 7: --archives: command not found
	./run.sh: line 14: /home/hadoop/xubo/data/alignment/bwa/datatest.fa: Permission denied
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ll
	total 36
	drwxrwxr-x 2 hadoop hadoop  4096  6月 12 18:56 ./
	drwxrwxr-x 4 hadoop hadoop  4096  6月 12 18:28 ../
	-rwxr-xr-x 1 hadoop hadoop   453  6月 12 18:56 run.sh*
	-rw-rw-r-- 1 hadoop hadoop 22906  6月 12 18:29 SparkBWA.jar
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ vi run.sh 
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ ./run.sh 
	Error: Must specify a primary resource (JAR or Python or R file)
	Run with --help for usage help or --verbose for debug output
	./run.sh: line 9: --verbose: command not found
	./run.sh: line 14: /home/hadoop/xubo/data/alignment/bwa/datatest.fa: Permission denied
	hadoop@Master:~/xubo/project/alignment/sparkBWA$ 

	
	
参考：
【1】 https://github.com/citiususc/SparkBWA
 	
	
安装记录：
	
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtgap.c -o bwtgap.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtaln.c -o bwtaln.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bamlite.c -o bamlite.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  is.c -o is.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtindex.c -o bwtindex.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwape.c -o bwape.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  kopen.c -o kopen.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  pemerge.c -o pemerge.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  maxk.c -o maxk.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_core.c -o bwtsw2_core.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_main.c -o bwtsw2_main.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_aux.c -o bwtsw2_aux.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwt_lite.c -o bwt_lite.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_chain.c -o bwtsw2_chain.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  fastmap.c -o fastmap.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_pair.c -o bwtsw2_pair.o
	gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  main.c -o main.o
	gcc -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS QSufSort.o bwt_gen.o bwashm.o bwase.o bwaseqio.o bwtgap.o bwtaln.o bamlite.o is.o bwtindex.o bwape.o kopen.o pemerge.o maxk.o bwtsw2_core.o bwtsw2_main.o bwtsw2_aux.o bwt_lite.o bwtsw2_chain.o fastmap.o bwtsw2_pair.o main.o -o bwa -L. -lbwa -lm -lz -lpthread -lrt
	make[1]: Leaving directory `/home/hadoop/xubo/tools/SparkBWA/bwa/bwa-0.7.12'
	if [ ! -d "build" ]; then mkdir build; fi
	cp ./bwa/bwa-0.7.12/*.o build
	gcc -shared -o build/libbwa.so build/*.o -lrt 
	cd build && zip -r bwa ./* && cd ..
	  adding: QSufSort.o (deflated 66%)
	  adding: bamlite.o (deflated 67%)
	  adding: bntseq.o (deflated 70%)
	  adding: bwa.o (deflated 70%)
	  adding: bwa_jni.o (deflated 70%)
	  adding: bwamem.o (deflated 70%)
	  adding: bwamem_extra.o (deflated 75%)
	  adding: bwamem_pair.o (deflated 65%)
	  adding: bwape.o (deflated 69%)
	  adding: bwase.o (deflated 68%)
	  adding: bwaseqio.o (deflated 68%)
	  adding: bwashm.o (deflated 70%)
	  adding: bwt.o (deflated 67%)
	  adding: bwt_gen.o (deflated 68%)
	  adding: bwt_lite.o (deflated 65%)
	  adding: bwtaln.o (deflated 71%)
	  adding: bwtgap.o (deflated 70%)
	  adding: bwtindex.o (deflated 71%)
	  adding: bwtsw2_aux.o (deflated 68%)
	  adding: bwtsw2_chain.o (deflated 64%)
	  adding: bwtsw2_core.o (deflated 70%)
	  adding: bwtsw2_main.o (deflated 72%)
	  adding: bwtsw2_pair.o (deflated 64%)
	  adding: fastmap.o (deflated 72%)
	  adding: is.o (deflated 65%)
	  adding: kopen.o (deflated 69%)
	  adding: kstring.o (deflated 65%)
	  adding: ksw.o (deflated 71%)
	  adding: kthread.o (deflated 65%)
	  adding: libbwa.so (deflated 64%)
	  adding: main.o (deflated 78%)
	  adding: malloc_wrap.o (deflated 70%)
	  adding: maxk.o (deflated 66%)
	  adding: pemerge.o (deflated 69%)
	  adding: utils.o (deflated 69%)
	cd ./libs && wget http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz && tar xzvf spark-1.6.1-bin-hadoop2.6.tgz && cp spark-1.6.1-bin-hadoop2.6/lib/spark-assembly-1.6.1-hadoop2.6.0.jar ./ && rm -Rf spark-1.6.1-bin-hadoop2.6 && rm spark-1.6.1-bin-hadoop2.6.tgz && cd ..
	--2016-06-12 16:46:09--  http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz
	Resolving ftp.cixug.es (ftp.cixug.es)... 193.144.61.75
	Connecting to ftp.cixug.es (ftp.cixug.es)|193.144.61.75|:80... connected.
	HTTP request sent, awaiting response... 200 OK
	Length: 289405702 (276M) [application/x-gzip]
	Saving to: ‘spark-1.6.1-bin-hadoop2.6.tgz’
	
	39% [==========================================================>                                                                                           ] 114,566,890 28.6KB/s   in 26m 13s
	
	2016-06-12 17:12:29 (71.1 KB/s) - Connection closed at byte 114566890. Retrying.
	
	--2016-06-12 17:12:30--  (try: 2)  http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz
	Connecting to ftp.cixug.es (ftp.cixug.es)|193.144.61.75|:80... connected.
	HTTP request sent, awaiting response... 206 Partial Content
	Length: 289405702 (276M), 174838812 (167M) remaining [application/x-gzip]
	Saving to: ‘spark-1.6.1-bin-hadoop2.6.tgz’
	
	41% [+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==>                                                                                        ] 120,833,451 11.9KB/s   in 3m 47s 
	
	2016-06-12 17:16:19 (26.9 KB/s) - Connection closed at byte 120833451. Retrying.
	
	--2016-06-12 17:16:21--  (try: 3)  http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz
	Connecting to ftp.cixug.es (ftp.cixug.es)|193.144.61.75|:80... connected.
	HTTP request sent, awaiting response... 206 Partial Content
	Length: 289405702 (276M), 168572251 (161M) remaining [application/x-gzip]
	Saving to: ‘spark-1.6.1-bin-hadoop2.6.tgz’
	
	46% [++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=======>                                                                                ] 135,476,692 8.89KB/s   in 7m 54s 
	
	2016-06-12 17:24:16 (30.1 KB/s) - Connection closed at byte 135476692. Retrying.
	
	--2016-06-12 17:24:19--  (try: 4)  http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz
	Connecting to ftp.cixug.es (ftp.cixug.es)|193.144.61.75|:80... connected.
	HTTP request sent, awaiting response... 206 Partial Content
	Length: 289405702 (276M), 153929010 (147M) remaining [application/x-gzip]
	Saving to: ‘spark-1.6.1-bin-hadoop2.6.tgz’
	
	58% [++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++================>                                                               ] 169,085,837 28.2KB/s   in 12m 46s
	
	2016-06-12 17:37:06 (42.8 KB/s) - Connection closed at byte 169085837. Retrying.
	
	--2016-06-12 17:37:10--  (try: 5)  http://ftp.cixug.es/apache/spark/spark-1.6.1/spark-1.6.1-bin-hadoop2.6.tgz
	Connecting to ftp.cixug.es (ftp.cixug.es)|193.144.61.75|:80... connected.
	HTTP request sent, awaiting response... 206 Partial Content
	Length: 289405702 (276M), 120319865 (115M) remaining [application/x-gzip]
	Saving to: ‘spark-1.6.1-bin-hadoop2.6.tgz’
	
	100%[+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==============================================================>] 289,405,702  129KB/s   in 29m 13s
	
	2016-06-12 18:06:24 (67.0 KB/s) - ‘spark-1.6.1-bin-hadoop2.6.tgz’ saved [289405702/289405702]
	
	spark-1.6.1-bin-hadoop2.6/
	spark-1.6.1-bin-hadoop2.6/NOTICE
	spark-1.6.1-bin-hadoop2.6/CHANGES.txt
	spark-1.6.1-bin-hadoop2.6/python/
	spark-1.6.1-bin-hadoop2.6/python/run-tests.py
	spark-1.6.1-bin-hadoop2.6/python/test_support/
	spark-1.6.1-bin-hadoop2.6/python/test_support/userlibrary.py
	spark-1.6.1-bin-hadoop2.6/python/test_support/userlib-0.1.zip
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/people.json
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/people1.json
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=1/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=1/c=1/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=1/c=1/part-r-00000-829af031-b970-49d6-ad39-30460a0be2c8.orc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=1/c=1/.part-r-00000-829af031-b970-49d6-ad39-30460a0be2c8.orc.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/_SUCCESS
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=0/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=0/c=0/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=0/c=0/part-r-00000-829af031-b970-49d6-ad39-30460a0be2c8.orc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/orc_partitioned/b=0/c=0/.part-r-00000-829af031-b970-49d6-ad39-30460a0be2c8.orc.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/text-test.txt
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2014/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2014/month=9/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2014/month=9/day=1/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2014/month=9/day=1/.part-r-00008.gz.parquet.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2014/month=9/day=1/part-r-00008.gz.parquet
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/_SUCCESS
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=26/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=26/part-r-00005.gz.parquet
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=26/.part-r-00005.gz.parquet.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=25/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=25/part-r-00002.gz.parquet
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=25/.part-r-00002.gz.parquet.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=25/part-r-00004.gz.parquet
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=10/day=25/.part-r-00004.gz.parquet.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=9/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=9/day=1/
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=9/day=1/.part-r-00007.gz.parquet.crc
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/year=2015/month=9/day=1/part-r-00007.gz.parquet
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/_metadata
	spark-1.6.1-bin-hadoop2.6/python/test_support/sql/parquet_partitioned/_common_metadata
	spark-1.6.1-bin-hadoop2.6/python/test_support/SimpleHTTPServer.py
	spark-1.6.1-bin-hadoop2.6/python/test_support/hello.txt
	spark-1.6.1-bin-hadoop2.6/python/docs/
	spark-1.6.1-bin-hadoop2.6/python/docs/pyspark.ml.rst
	spark-1.6.1-bin-hadoop2.6/python/docs/pyspark.streaming.rst
	spark-1.6.1-bin-hadoop2.6/python/docs/conf.py
	spark-1.6.1-bin-hadoop2.6/python/docs/_templates/
	spark-1.6.1-bin-hadoop2.6/python/docs/_templates/layout.html
	spark-1.6.1-bin-hadoop2.6/python/docs/pyspark.rst
	spark-1.6.1-bin-hadoop2.6/python/docs/make.bat
	spark-1.6.1-bin-hadoop2.6/python/docs/epytext.py
	spark-1.6.1-bin-hadoop2.6/python/docs/make2.bat
	spark-1.6.1-bin-hadoop2.6/python/docs/index.rst
	spark-1.6.1-bin-hadoop2.6/python/docs/_static/
	spark-1.6.1-bin-hadoop2.6/python/docs/_static/pyspark.js
	spark-1.6.1-bin-hadoop2.6/python/docs/_static/pyspark.css
	spark-1.6.1-bin-hadoop2.6/python/docs/pyspark.sql.rst
	spark-1.6.1-bin-hadoop2.6/python/docs/pyspark.mllib.rst
	spark-1.6.1-bin-hadoop2.6/python/docs/Makefile
	spark-1.6.1-bin-hadoop2.6/python/.gitignore
	spark-1.6.1-bin-hadoop2.6/python/pyspark/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/status.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/conf.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/evaluation.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/util.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/classification.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/regression.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/tests.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/tuning.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/pipeline.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/feature.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/clustering.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/recommendation.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/wrapper.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/param/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/param/_shared_params_code_gen.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/param/shared.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/ml/param/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/statcounter.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/profiler.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/serializers.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/traceback_utils.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/shell.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/window.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/tests.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/utils.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/group.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/types.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/context.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/dataframe.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/column.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/readwriter.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/sql/functions.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/daemon.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/tests.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/resultiterable.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/heapq3.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/broadcast.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/shuffle.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/cloudpickle.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/accumulators.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/java_gateway.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/util.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/listener.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/tests.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/flume.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/kafka.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/kinesis.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/dstream.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/context.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/mqtt.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/streaming/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/context.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/storagelevel.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/join.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/tree.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/evaluation.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/util.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/classification.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/regression.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/tests.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/common.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/linalg/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/linalg/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/linalg/distributed.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/feature.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/clustering.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/recommendation.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/stat/
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/stat/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/stat/_statistics.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/stat/KernelDensity.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/stat/test.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/stat/distribution.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/random.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/__init__.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/mllib/fpm.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/rdd.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/rddsampler.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/worker.py
	spark-1.6.1-bin-hadoop2.6/python/pyspark/files.py
	spark-1.6.1-bin-hadoop2.6/python/run-tests
	spark-1.6.1-bin-hadoop2.6/python/lib/
	spark-1.6.1-bin-hadoop2.6/python/lib/py4j-0.9-src.zip
	spark-1.6.1-bin-hadoop2.6/python/lib/pyspark.zip
	spark-1.6.1-bin-hadoop2.6/python/lib/PY4J_LICENSE.txt
	spark-1.6.1-bin-hadoop2.6/RELEASE
	spark-1.6.1-bin-hadoop2.6/sbin/
	spark-1.6.1-bin-hadoop2.6/sbin/start-mesos-shuffle-service.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-mesos-dispatcher.sh
	spark-1.6.1-bin-hadoop2.6/sbin/spark-daemon.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-slaves.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-thriftserver.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-shuffle-service.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-history-server.sh
	spark-1.6.1-bin-hadoop2.6/sbin/spark-config.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-history-server.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-thriftserver.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-shuffle-service.sh
	spark-1.6.1-bin-hadoop2.6/sbin/spark-daemons.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-all.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-master.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-mesos-dispatcher.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-slave.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-slave.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-mesos-shuffle-service.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-slaves.sh
	spark-1.6.1-bin-hadoop2.6/sbin/stop-all.sh
	spark-1.6.1-bin-hadoop2.6/sbin/slaves.sh
	spark-1.6.1-bin-hadoop2.6/sbin/start-master.sh
	spark-1.6.1-bin-hadoop2.6/examples/
	spark-1.6.1-bin-hadoop2.6/examples/src/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/r/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/r/data-manipulation.R
	spark-1.6.1-bin-hadoop2.6/examples/src/main/r/ml.R
	spark-1.6.1-bin-hadoop2.6/examples/src/main/r/dataframe.R
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/status_api_demo.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/random_forest_regressor_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/stopwords_remover_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/standard_scaler_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/vector_assembler_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/binarizer_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/cross_validator.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/simple_text_classification_pipeline.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/dataframe_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/decision_tree_regression_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/linear_regression_with_elastic_net.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/index_to_string_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/sql_transformer.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/gradient_boosted_tree_regressor_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/multilayer_perceptron_classification.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/gradient_boosted_tree_classifier_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/kmeans_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/pca_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/polynomial_expansion_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/onehot_encoder_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/aft_survival_regression.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/rformula_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/logistic_regression_with_elastic_net.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/decision_tree_classification_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/tokenizer_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/random_forest_classifier_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/string_indexer_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/n_gram_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/vector_indexer_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/normalizer_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/bucketizer_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/simple_params_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/elementwise_product_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/tf_idf_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/ml/word2vec_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/pagerank.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/pi.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/hbase_inputformat.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/logistic_regression.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/cassandra_outputformat.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/sql_network_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/queue_stream.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/network_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/kafka_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/stateful_network_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/direct_kafka_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/hdfs_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/recoverable_network_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/mqtt_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/streaming/flume_wordcount.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/transitive_closure.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/kmeans.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/avro_inputformat.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/recommendation_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/regression_metrics_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/random_forest_regression_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/sampled_rdds.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/fpgrowth_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/gradient_boosting_classification_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/multi_class_metrics_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/naive_bayes_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/decision_tree_regression_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/ranking_metrics_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/gaussian_mixture_model.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/gradient_boosting_regression_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/binary_classification_metrics_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/logistic_regression.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/isotonic_regression_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/word2vec.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/multi_label_metrics_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/kmeans.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/decision_tree_classification_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/random_rdd_generation.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/random_forest_classification_example.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/mllib/correlations.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/parquet_inputformat.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/hbase_outputformat.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/als.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/sql.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/sort.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/python/cassandra_inputformat.py
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaPCAExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaSimpleTextClassificationPipeline.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaAFTSurvivalRegressionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaLogisticRegressionSummaryExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaLogisticRegressionWithElasticNetExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaVectorIndexerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaKMeansExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaRandomForestRegressorExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaSimpleParamsExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaTfIdfExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaVectorAssemblerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaTrainValidationSplitExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaBucketizerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaDecisionTreeRegressionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaSQLTransformerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaLinearRegressionWithElasticNetExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaDeveloperApiExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaLDAExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaCrossValidatorExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaDCTExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaIndexToStringExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaOneVsRestExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaStopWordsRemoverExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaCountVectorizerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaRFormulaExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaOneHotEncoderExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaQuantileDiscretizerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaRandomForestClassifierExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaGradientBoostedTreeClassifierExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaMultilayerPerceptronClassifierExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaNGramExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaStandardScalerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaDecisionTreeClassificationExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaNormalizerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaPolynomialExpansionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaBinarizerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaGradientBoostedTreeRegressorExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaStringIndexerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaWord2VecExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaVectorSlicerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaChiSqSelectorExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaMinMaxScalerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaElementwiseProductExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/ml/JavaTokenizerExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaSparkPi.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/sql/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/sql/JavaSparkSQL.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaLogQuery.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaTC.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaStatusTrackerDemo.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaRecord.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaFlumeEventCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaDirectKafkaWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaNetworkWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaSqlNetworkWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaRecoverableNetworkWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaStatefulNetworkWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaCustomReceiver.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaQueueStream.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/streaming/JavaKafkaWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaHdfsLR.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaPageRank.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/JavaWordCount.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaLBFGSExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaMultiLabelClassificationMetricsExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaMulticlassClassificationMetricsExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaPrefixSpanExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaDecisionTreeRegressionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaAssociationRulesExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaBinaryClassificationMetricsExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaRandomForestClassificationExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaLDAExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaRandomForestRegressionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaNaiveBayesExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaGradientBoostingClassificationExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaPowerIterationClusteringExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaRankingMetricsExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaALS.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaRecommendationExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaBisectingKMeansExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaFPGrowthExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaLR.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaGradientBoostingRegressionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaIsotonicRegressionExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaKMeans.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaSimpleFPGrowth.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaRegressionMetricsExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/java/org/apache/spark/examples/mllib/JavaDecisionTreeClassificationExample.java
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/DFSReadWriteTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/GroupByTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/RandomForestExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/CrossValidatorExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/SQLTransformerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/StandardScalerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/ElementwiseProductExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/IndexToStringExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/LogisticRegressionSummaryExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/BucketizerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/VectorIndexerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/StringIndexerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/TokenizerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/LogisticRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/PCAExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/StopWordsRemoverExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/MultilayerPerceptronClassifierExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/GBTExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/RandomForestRegressorExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/DeveloperApiExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/ChiSqSelectorExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/TfIdfExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/DecisionTreeExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/MovieLensALS.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/BinarizerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/GradientBoostedTreeClassifierExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/MinMaxScalerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/OneVsRestExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/OneHotEncoderExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/VectorAssemblerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/Word2VecExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/RandomForestClassifierExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/DCTExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/GradientBoostedTreeRegressorExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/LinearRegressionWithElasticNetExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/DataFrameExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/DecisionTreeClassificationExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/KMeansExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/CountVectorizerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/VectorSlicerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/NormalizerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/SimpleTextClassificationPipeline.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/PolynomialExpansionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/LogisticRegressionWithElasticNetExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/LinearRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/DecisionTreeRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/SimpleParamsExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/TrainValidationSplitExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/LDAExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/RFormulaExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/AFTSurvivalRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/QuantileDiscretizerExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ml/NGramExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkKMeans.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkTachyonPi.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/MultiBroadcastTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/sql/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/sql/hive/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/sql/hive/HiveFromSpark.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/sql/RDDRelation.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/pythonconverters/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/pythonconverters/HBaseConverters.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/pythonconverters/CassandraConverters.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/pythonconverters/AvroConverters.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/LocalLR.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkTC.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/BroadcastTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/ExceptionHandlingTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/LocalKMeans.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/graphx/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/graphx/Analytics.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/graphx/SynthBenchmark.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/graphx/LiveJournalPageRank.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/HdfsTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SimpleSkewedGroupByTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkPageRank.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkTachyonHdfsLR.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/StatefulNetworkWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/TwitterAlgebirdCMS.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/HdfsWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/DirectKafkaWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/QueueStream.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/TwitterPopularTags.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/FlumePollingEventCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/SqlNetworkWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/FlumeEventCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/ZeroMQWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/RecoverableNetworkWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/clickstream/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/clickstream/PageViewStream.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/clickstream/PageViewGenerator.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/ActorWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/MQTTWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/TwitterAlgebirdHLL.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/StreamingExamples.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/NetworkWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/CustomReceiver.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/KafkaWordCount.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/streaming/RawNetworkGrep.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkPi.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkALS.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/LocalFileLR.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/DriverSubmissionTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/LogQuery.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/HBaseTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/MultiLabelMetricsExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/RankingMetricsExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/AbstractParams.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/BisectingKMeansExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/StreamingKMeansExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/GradientBoostingClassificationExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/RandomForestClassificationExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/StreamingTestExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/GradientBoostingRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/TallSkinnyPCA.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/StreamingLinearRegression.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/AssociationRulesExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/DecisionTreeRunner.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/TallSkinnySVD.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/DenseGaussianMixture.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/IsotonicRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/BinaryClassificationMetricsExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/LBFGSExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/PrefixSpanExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/Correlations.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/RecommendationExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/MovieLensALS.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/CosineSimilarity.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/MulticlassMetricsExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/StreamingLogisticRegression.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/NaiveBayesExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/RegressionMetricsExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/SampledRDDs.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/DecisionTreeClassificationExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/RandomRDDGeneration.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/SparseNaiveBayes.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/BinaryClassification.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/PowerIterationClusteringExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/DenseKMeans.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/MultivariateSummarizer.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/RandomForestRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/FPGrowthExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/GradientBoostedTreesRunner.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/DecisionTreeRegressionExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/LinearRegression.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/SimpleFPGrowth.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/mllib/LDAExample.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkLR.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/LocalPi.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/CassandraCQLTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SparkHdfsLR.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/SkewedGroupByTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/CassandraTest.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/scala/org/apache/spark/examples/LocalALS.scala
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/people.json
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/people.txt
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/full_user.avsc
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/kv1.txt
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/users.parquet
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/user.avsc
	spark-1.6.1-bin-hadoop2.6/examples/src/main/resources/users.avro
	spark-1.6.1-bin-hadoop2.6/data/
	spark-1.6.1-bin-hadoop2.6/data/mllib/
	spark-1.6.1-bin-hadoop2.6/data/mllib/pagerank_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/kmeans_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/pic_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/als/
	spark-1.6.1-bin-hadoop2.6/data/mllib/als/sample_movielens_movies.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/als/test.data
	spark-1.6.1-bin-hadoop2.6/data/mllib/als/sample_movielens_ratings.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/lr-data/
	spark-1.6.1-bin-hadoop2.6/data/mllib/lr-data/random.data
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_naive_bayes_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_tree_data.csv
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_fpgrowth.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_libsvm_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/ridge-data/
	spark-1.6.1-bin-hadoop2.6/data/mllib/ridge-data/lpsa.data
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_multiclass_classification_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_linear_regression_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_isotonic_regression_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_binary_classification_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_lda_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_movielens_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/sample_svm_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/lr_data.txt
	spark-1.6.1-bin-hadoop2.6/data/mllib/gmm_data.txt
	spark-1.6.1-bin-hadoop2.6/R/
	spark-1.6.1-bin-hadoop2.6/R/lib/
	spark-1.6.1-bin-hadoop2.6/R/lib/sparkr.zip
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/groupBy.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sql.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/year.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/tan.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/last_day.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/DataFrame.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/randn.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/otherwise.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/hashCode.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/bin.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/dim.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/minute.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/distinct.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/print.jobj.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/md5.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cbrt.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sparkRHive.init.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/registerTempTable.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/acos.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/tables.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sum.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/structType.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/hex.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/isLocal.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/from_utc_timestamp.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/tableNames.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/createDataFrame.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/except.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/months_between.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/write.parquet.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sumDistinct.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sha2.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/abs.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/date_format.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/withColumn.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/dayofyear.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sort_array.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/ceil.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/floor.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/stddev_pop.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sd.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/print.structType.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/predict.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/count.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/unhex.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/mean.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/instr.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/from_unixtime.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/saveAsTable.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/ltrim.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/read.parquet.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/match.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/is.nan.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/lag.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/write.json.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/corr.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rint.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/persist.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/var_pop.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/selectExpr.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/crc32.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/expr.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/with.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/generateAliasesForIntersectedCols.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/shiftRightUnsigned.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/base64.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/array_contains.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/expm1.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/insertInto.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/merge.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/dayofmonth.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/summarize.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/format_number.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cache.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/write.text.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/approxCountDistinct.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/stddev_samp.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/showDF.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/between.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/struct.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/subset.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/lit.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/shiftLeft.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/glm.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/hypot.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/translate.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/shiftRight.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/regexp_replace.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/length.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/schema.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/toRadians.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/filter.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cancelJobGroup.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/second.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/upper.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/table.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/head.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/limit.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/concat_ws.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/when.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/unbase64.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/soundex.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/structField.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cacheTable.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cosh.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/ntile.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/atan2.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/dtypes.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/reverse.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sinh.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/negate.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/asin.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rank.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/toDegrees.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/columns.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/substring_index.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/statfunctions.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/PipelineModel-class.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/atan.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/factorial.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/countDistinct.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/quarter.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/unpersist-methods.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/least.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/read.text.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cume_dist.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/dense_rank.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/arrange.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/encode.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rpad.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/uncacheTable.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/size.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/conv.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/log10.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/collect.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/format_string.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/infer_type.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sparkR.stop.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/nanvl.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/mutate.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/explain.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/R.css
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/signum.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/var_samp.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/log2.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/attach.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/min.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/ncol.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/month.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/percent_rank.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/to_utc_timestamp.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/take.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/exp.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/column.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/ifelse.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/show.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/setJobGroup.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/clearJobGroup.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/last.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/printSchema.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rename.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rbind.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/createExternalTable.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/coltypes.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sparkR.init.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/datediff.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/lead.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/agg.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/summary.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/unix_timestamp.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/tanh.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/to_date.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/00Index.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/max.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/var.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/print.structField.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/alias.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sha1.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/write.df.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/round.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/nrow.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/pmod.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/intersect.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sparkRSQL.init.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rtrim.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/substr.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/log.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/levenshtein.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/decode.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/read.json.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/trim.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/select.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/regexp_extract.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/as.data.frame.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/dropTempTable.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sample.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/lower.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/repartition.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/concat.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cast.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/date_add.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/col.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/hour.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/initcap.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/explode.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/add_months.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/bitwiseNOT.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/kurtosis.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/greatest.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/first.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/read.df.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/rand.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/next_day.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/clearCache.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/nafunctions.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/row_number.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/lpad.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/skewness.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/locate.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/avg.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sqrt.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/cos.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/log1p.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/str.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/ascii.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/sin.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/weekofyear.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/GroupedData.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/date_sub.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/html/join.html
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/test_support/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/test_support/sparktestjar_2.10-1.0.jar
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/INDEX
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/R/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/R/SparkR.rdx
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/R/SparkR
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/R/SparkR.rdb
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/help/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/help/aliases.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/help/paths.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/help/SparkR.rdx
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/help/AnIndex
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/help/SparkR.rdb
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/DESCRIPTION
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/Meta/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/Meta/hsearch.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/Meta/nsInfo.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/Meta/package.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/Meta/links.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/Meta/Rd.rds
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/profile/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/profile/general.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/profile/shell.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/worker/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/worker/daemon.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/worker/worker.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/NAMESPACE
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_textFile.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/jarTest.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_client.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_includeJAR.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_broadcast.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_binaryFile.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_rdd.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/packageInAJarTest.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_sparkSQL.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_parallelize_collect.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_includePackage.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_shuffle.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_Serde.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_mllib.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_binary_function.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_context.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_take.R
	spark-1.6.1-bin-hadoop2.6/R/lib/SparkR/tests/testthat/test_utils.R
	spark-1.6.1-bin-hadoop2.6/licenses/
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-slf4j.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-scalacheck.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-py4j.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-paranamer.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-netlib.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-Mockito.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-minlog.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-graphlib-dot.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-d3.min.js.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-f2j.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-junit-interface.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-boto.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-spire.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-pyrolite.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-xmlenc.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-scala.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-SnapTree.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-AnchorJS.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-jline.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-jblas.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-heapq.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-cloudpickle.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-reflectasm.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-jpmml-model.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-javolution.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-jbcrypt.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-sbt-launch-lib.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-kryo.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-DPark.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-scopt.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-sorttable.js.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-dagre-d3.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-jquery.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-protobuf.txt
	spark-1.6.1-bin-hadoop2.6/licenses/LICENSE-antlr.txt
	spark-1.6.1-bin-hadoop2.6/ec2/
	spark-1.6.1-bin-hadoop2.6/ec2/spark_ec2.py
	spark-1.6.1-bin-hadoop2.6/ec2/README
	spark-1.6.1-bin-hadoop2.6/ec2/spark-ec2
	spark-1.6.1-bin-hadoop2.6/ec2/deploy.generic/
	spark-1.6.1-bin-hadoop2.6/ec2/deploy.generic/root/
	spark-1.6.1-bin-hadoop2.6/ec2/deploy.generic/root/spark-ec2/
	spark-1.6.1-bin-hadoop2.6/ec2/deploy.generic/root/spark-ec2/ec2-variables.sh
	spark-1.6.1-bin-hadoop2.6/conf/
	spark-1.6.1-bin-hadoop2.6/conf/fairscheduler.xml.template
	spark-1.6.1-bin-hadoop2.6/conf/metrics.properties.template
	spark-1.6.1-bin-hadoop2.6/conf/spark-env.sh.template
	spark-1.6.1-bin-hadoop2.6/conf/log4j.properties.template
	spark-1.6.1-bin-hadoop2.6/conf/docker.properties.template
	spark-1.6.1-bin-hadoop2.6/conf/slaves.template
	spark-1.6.1-bin-hadoop2.6/conf/spark-defaults.conf.template
	spark-1.6.1-bin-hadoop2.6/LICENSE
	spark-1.6.1-bin-hadoop2.6/bin/
	spark-1.6.1-bin-hadoop2.6/bin/spark-shell
	spark-1.6.1-bin-hadoop2.6/bin/spark-submit.cmd
	spark-1.6.1-bin-hadoop2.6/bin/spark-shell2.cmd
	spark-1.6.1-bin-hadoop2.6/bin/pyspark
	spark-1.6.1-bin-hadoop2.6/bin/sparkR.cmd
	spark-1.6.1-bin-hadoop2.6/bin/spark-class2.cmd
	spark-1.6.1-bin-hadoop2.6/bin/run-example.cmd
	spark-1.6.1-bin-hadoop2.6/bin/spark-submit2.cmd
	spark-1.6.1-bin-hadoop2.6/bin/spark-class
	spark-1.6.1-bin-hadoop2.6/bin/spark-submit
	spark-1.6.1-bin-hadoop2.6/bin/spark-sql
	spark-1.6.1-bin-hadoop2.6/bin/run-example
	spark-1.6.1-bin-hadoop2.6/bin/beeline
	spark-1.6.1-bin-hadoop2.6/bin/pyspark2.cmd
	spark-1.6.1-bin-hadoop2.6/bin/spark-shell.cmd
	spark-1.6.1-bin-hadoop2.6/bin/spark-class.cmd
	spark-1.6.1-bin-hadoop2.6/bin/pyspark.cmd
	spark-1.6.1-bin-hadoop2.6/bin/sparkR
	spark-1.6.1-bin-hadoop2.6/bin/beeline.cmd
	spark-1.6.1-bin-hadoop2.6/bin/sparkR2.cmd
	spark-1.6.1-bin-hadoop2.6/bin/run-example2.cmd
	spark-1.6.1-bin-hadoop2.6/bin/load-spark-env.sh
	spark-1.6.1-bin-hadoop2.6/bin/load-spark-env.cmd
	spark-1.6.1-bin-hadoop2.6/lib/
	spark-1.6.1-bin-hadoop2.6/lib/datanucleus-core-3.2.10.jar
	spark-1.6.1-bin-hadoop2.6/lib/spark-assembly-1.6.1-hadoop2.6.0.jar
	spark-1.6.1-bin-hadoop2.6/lib/datanucleus-api-jdo-3.2.6.jar
	spark-1.6.1-bin-hadoop2.6/lib/datanucleus-rdbms-3.2.9.jar
	spark-1.6.1-bin-hadoop2.6/lib/spark-1.6.1-yarn-shuffle.jar
	spark-1.6.1-bin-hadoop2.6/lib/spark-examples-1.6.1-hadoop2.6.0.jar
	spark-1.6.1-bin-hadoop2.6/README.md
	javac -cp ./libs/commons-cli-1.2.jar:./libs/spark-assembly-1.6.1-hadoop2.6.0.jar -d build -Xlint:none ./src/*.java
	cd build && jar cfe SparkBWA.jar SparkBWA ./*.class && cd ..
	#cd build && jar cfe SparkBWASeq.jar BwaSeq ./*.class && cd ..
	================================================================================
	SparkBWA has been compiled.
	Location    = /home/hadoop/xubo/tools/SparkBWA/build/
	JAVA_HOME   = /usr/lib/jvm/jdk1.7.0
	HADOOP_HOME = 
	================================================================================
	hadoop@Master:~/xubo/tools/SparkBWA$ 
	hadoop@Master:~/xubo/tools/SparkBWA$ 
