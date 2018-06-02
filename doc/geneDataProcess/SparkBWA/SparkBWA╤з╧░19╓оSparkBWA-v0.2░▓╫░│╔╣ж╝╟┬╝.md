更多代码请见：https://github.com/xubo245
	
基因数据处理系列之SparkBWA

# 1.解释
SparkBWA[3]升级了
##1.1 遇到的问题
第一次按照project教程失败了：

	Downloading: https://mvn.128.no/maven2/cz/adamh/utils/native-utils/1.0-SNAPSHOT/native-utils-1.0-SNAPSHOT.pom
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 55.939 s
	[INFO] Finished at: 2017-01-16T10:27:53+08:00
	[INFO] Final Memory: 16M/108M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal on project SparkBWA: Could not resolve dependencies for project com.github.sparkbwa:SparkBWA:jar:0.2: Failed to collect dependencies at cz.adamh.utils:native-utils:jar:1.0-SNAPSHOT: Failed to read artifact descriptor for cz.adamh.utils:native-utils:jar:1.0-SNAPSHOT: Could not transfer artifact cz.adamh.utils:native-utils:pom:1.0-SNAPSHOT from/to 128 (https://mvn.128.no/maven2): sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target -> [Help 1]
	[ERROR] 
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR] 
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException

## 1.2 解决办法
搜索了cz.adamh.utils，发现没有，于是搜到了相关的github project [4]，自己编译安装

	make install


###记录

	xubo@xubo:~/xubo/tools/SparkBWA20170116$ git clone https://github.com/adamheinrich/native-utils.git
	Cloning into 'native-utils'...
	remote: Counting objects: 43, done.
	remote: Total 43 (delta 0), reused 0 (delta 0), pack-reused 43
	Unpacking objects: 100% (43/43), done.
	Checking connectivity... done.
	xubo@xubo:~/xubo/tools/SparkBWA20170116$ 
	xubo@xubo:~/xubo/tools/SparkBWA20170116$ ls
	native-utils  SparkBWA
	xubo@xubo:~/xubo/tools/SparkBWA20170116$ cd native-utils/
	xubo@xubo:~/xubo/tools/SparkBWA20170116/native-utils$ ls
	LICENSE  pom.xml  README.md  src
	xubo@xubo:~/xubo/tools/SparkBWA20170116/native-utils$ mvn package
	[INFO] Scanning for projects...
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building native-utils 1.0-SNAPSHOT
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ native-utils ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/SparkBWA20170116/native-utils/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ native-utils ---
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 1 source file to /home/xubo/xubo/tools/SparkBWA20170116/native-utils/target/classes
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ native-utils ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/SparkBWA20170116/native-utils/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ native-utils ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ native-utils ---
	[INFO] No tests to run.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ native-utils ---
	[INFO] Building jar: /home/xubo/xubo/tools/SparkBWA20170116/native-utils/target/native-utils-1.0-SNAPSHOT.jar
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 3.259 s
	[INFO] Finished at: 2017-01-16T10:46:53+08:00
	[INFO] Final Memory: 14M/104M
	[INFO] ------------------------------------------------------------------------
	xubo@xubo:~/xubo/tools/SparkBWA20170116/native-utils$ mvn install
	[INFO] Scanning for projects...
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building native-utils 1.0-SNAPSHOT
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ native-utils ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/SparkBWA20170116/native-utils/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ native-utils ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ native-utils ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/SparkBWA20170116/native-utils/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ native-utils ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ native-utils ---
	[INFO] No tests to run.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ native-utils ---
	[INFO] 
	[INFO] --- maven-install-plugin:2.4:install (default-install) @ native-utils ---
	[INFO] Installing /home/xubo/xubo/tools/SparkBWA20170116/native-utils/target/native-utils-1.0-SNAPSHOT.jar to /home/xubo/.m2/repository/cz/adamh/utils/native-utils/1.0-SNAPSHOT/native-utils-1.0-SNAPSHOT.jar
	[INFO] Installing /home/xubo/xubo/tools/SparkBWA20170116/native-utils/pom.xml to /home/xubo/.m2/repository/cz/adamh/utils/native-utils/1.0-SNAPSHOT/native-utils-1.0-SNAPSHOT.pom
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 1.824 s
	[INFO] Finished at: 2017-01-16T10:47:01+08:00
	[INFO] Final Memory: 11M/104M
	[INFO] ------------------------------------------------------------------------
	


# 2.代码
##2.1 SparkBWA-v0.2安装

安装完依赖后就没问题了

	mvn package


	[INFO] Dependency-reduced POM written at: /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/dependency-reduced-pom.xml
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 17:09 min
	[INFO] Finished at: 2017-01-16T11:05:10+08:00
	[INFO] Final Memory: 37M/295M
	[INFO] ------------------------------------------------------------------------
# 3.结果
##3.1 记录

	xubo@xubo:~/xubo/tools/SparkBWA20170116/SparkBWA$ mvn package
	[INFO] Scanning for projects...
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building SparkBWA 0.2
	[INFO] ------------------------------------------------------------------------
	Downloading: https://mvn.128.no/maven2/org/apache/spark/spark-core_2.11/2.0.1/spark-core_2.11-2.0.1.jar
	Downloading: https://mvn.128.no/maven2/org/apache/spark/spark-launcher_2.11/2.0.1/spark-launcher_2.11-2.0.1.jar
	Downloading: https://mvn.128.no/maven2/org/apache/spark/spark-network-common_2.11/2.0.1/spark-network-common_2.11-2.0.1.jar
	Downloading: https://mvn.128.no/maven2/org/apache/spark/spark-network-shuffle_2.11/2.0.1/spark-network-shuffle_2.11-2.0.1.jar
	Downloading: https://mvn.128.no/maven2/org/apache/spark/spark-unsafe_2.11/2.0.1/spark-unsafe_2.11-2.0.1.jar
	Downloading: https://mvn.128.no/maven2/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar
	Downloading: https://mvn.128.no/maven2/org/scala-lang/scalap/2.11.0/scalap-2.11.0.jar
	Downloading: https://mvn.128.no/maven2/org/scala-lang/scala-compiler/2.11.0/scala-compiler-2.11.0.jar
	Downloading: https://mvn.128.no/maven2/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar
	Downloading: https://mvn.128.no/maven2/net/sf/py4j/py4j/0.10.3/py4j-0.10.3.jar
	Downloading: https://mvn.128.no/maven2/org/apache/spark/spark-tags_2.11/2.0.1/spark-tags_2.11-2.0.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/spark/spark-core_2.11/2.0.1/spark-core_2.11-2.0.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/spark/spark-launcher_2.11/2.0.1/spark-launcher_2.11-2.0.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/spark/spark-network-common_2.11/2.0.1/spark-network-common_2.11-2.0.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/spark/spark-unsafe_2.11/2.0.1/spark-unsafe_2.11-2.0.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/spark/spark-network-shuffle_2.11/2.0.1/spark-network-shuffle_2.11-2.0.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/spark/spark-unsafe_2.11/2.0.1/spark-unsafe_2.11-2.0.1.jar (41 KB at 19.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/spark/spark-network-shuffle_2.11/2.0.1/spark-network-shuffle_2.11-2.0.1.jar (55 KB at 14.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scala-lang/scalap/2.11.0/scalap-2.11.0.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/spark/spark-launcher_2.11/2.0.1/spark-launcher_2.11-2.0.1.jar (65 KB at 9.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scala-lang/scala-compiler/2.11.0/scala-compiler-2.11.0.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/scala-lang/scalap/2.11.0/scalap-2.11.0.jar (754 KB at 14.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar (1032 KB at 17.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/net/sf/py4j/py4j/0.10.3/py4j-0.10.3.jar
	Downloaded: https://repo.maven.apache.org/maven2/net/sf/py4j/py4j/0.10.3/py4j-0.10.3.jar (113 KB at 1.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/spark/spark-tags_2.11/2.0.1/spark-tags_2.11-2.0.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/spark/spark-tags_2.11/2.0.1/spark-tags_2.11-2.0.1.jar (15 KB at 0.2 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar (410 KB at 5.0 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/spark/spark-network-common_2.11/2.0.1/spark-network-common_2.11-2.0.1.jar (2301 KB at 14.3 KB/sec)
	1574/13336 KB   2288/11448 KB                  
	Downloaded: https://repo.maven.apache.org/maven2/org/scala-lang/scala-compiler/2.11.0/scala-compiler-2.11.0.jar (13336 KB at 13.9 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/spark/spark-core_2.11/2.0.1/spark-core_2.11-2.0.1.jar (11448 KB at 11.4 KB/sec)
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ SparkBWA ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ SparkBWA ---
	[INFO] Changes detected - recompiling the module!
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 11 source files to /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/target/classes
	[WARNING] /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/java/com/github/sparkbwa/BwaOptions.java: /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/java/com/github/sparkbwa/BwaOptions.java uses unchecked or unsafe operations.
	[WARNING] /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/java/com/github/sparkbwa/BwaOptions.java: Recompile with -Xlint:unchecked for details.
	[INFO] 
	[INFO] --- exec-maven-plugin:1.1.1:exec (makeBwa) @ SparkBWA ---
	[INFO] make: Entering directory `/home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/native'
	[INFO] if [ ! -d "build" ]; then mkdir build; fi
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS -I/home/xubo/cloud/jdk1.7.0/include -I/home/xubo/cloud/jdk1.7.0/include/linux bwa_jni.c -o build/bwa_jni.o -lrt -lz
	[INFO] bwa_jni.c: In function ‘Java_com_github_sparkbwa_BwaJni_bwa_1jni’:
	[INFO] bwa_jni.c:55:21: warning: assignment discards ‘const’ qualifier from pointer target type [enabled by default]
	[INFO]           argvTmp[i] = (*env)->GetStringUTFChars(env, string, 0);
	[INFO]                      ^
	[INFO] make -C ./bwa-0.7.15
	[INFO] make[1]: Entering directory `/home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/native/bwa-0.7.15'
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  utils.c -o utils.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  kthread.c -o kthread.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  kstring.c -o kstring.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  ksw.c -o ksw.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwt.c -o bwt.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bntseq.c -o bntseq.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwa.c -o bwa.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwamem.c -o bwamem.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwamem_pair.c -o bwamem_pair.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwamem_extra.c -o bwamem_extra.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  malloc_wrap.c -o malloc_wrap.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  QSufSort.c -o QSufSort.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwt_gen.c -o bwt_gen.o
	[INFO] bwt_gen.c: In function ‘BWTIncBuildRelativeRank’:
	[INFO] bwt_gen.c:878:10: warning: variable ‘oldInverseSa0RelativeRank’ set but not used [-Wunused-but-set-variable]
	[INFO]   bgint_t oldInverseSa0RelativeRank = 0;
	[INFO]           ^
	[INFO] bwt_gen.c: In function ‘BWTIncMergeBwt’:
	[INFO] bwt_gen.c:952:15: warning: variable ‘bitsInWordMinusBitPerChar’ set but not used [-Wunused-but-set-variable]
	[INFO]   unsigned int bitsInWordMinusBitPerChar;
	[INFO]                ^
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  rope.c -o rope.o
	[INFO] rope.c: In function ‘rope_restore_node’:
	[INFO] rope.c:282:7: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]   fread(&is_bottom, 1, 1, fp);
	[INFO]        ^
	[INFO] rope.c:283:7: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]   fread(&n, 2, 1, fp);
	[INFO]        ^
	[INFO] rope.c:291:9: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]     fread(p[i].c, 8, 6, fp);
	[INFO]          ^
	[INFO] rope.c:292:9: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]     fread(q, 2, 1, fp);
	[INFO]          ^
	[INFO] rope.c:293:9: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]     fread(q + 1, 1, *q, fp);
	[INFO]          ^
	[INFO] rope.c: In function ‘rope_restore’:
	[INFO] rope.c:312:7: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]   fread(&r->max_nodes, 4, 1, fp);
	[INFO]        ^
	[INFO] rope.c:313:7: warning: ignoring return value of ‘fread’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]   fread(&r->block_len, 4, 1, fp);
	[INFO]        ^
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  rle.c -o rle.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  is.c -o is.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtindex.c -o bwtindex.o
	[INFO] ar -csru libbwa.a utils.o kthread.o kstring.o ksw.o bwt.o bntseq.o bwa.o bwamem.o bwamem_pair.o bwamem_extra.o malloc_wrap.o QSufSort.o bwt_gen.o rope.o rle.o is.o bwtindex.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwashm.c -o bwashm.o
	[INFO] bwashm.c: In function ‘bwa_shm_stage’:
	[INFO] bwashm.c:29:11: warning: ignoring return value of ‘ftruncate’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]   ftruncate(shmid, BWA_CTL_SIZE);
	[INFO]            ^
	[INFO] bwashm.c:66:11: warning: ignoring return value of ‘ftruncate’, declared with attribute warn_unused_result [-Wunused-result]
	[INFO]   ftruncate(shmid, idx->l_mem);
	[INFO]            ^
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwase.c -o bwase.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwaseqio.c -o bwaseqio.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtgap.c -o bwtgap.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtaln.c -o bwtaln.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bamlite.c -o bamlite.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwape.c -o bwape.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  kopen.c -o kopen.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  pemerge.c -o pemerge.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  maxk.c -o maxk.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_core.c -o bwtsw2_core.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_main.c -o bwtsw2_main.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_aux.c -o bwtsw2_aux.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwt_lite.c -o bwt_lite.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_chain.c -o bwtsw2_chain.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  fastmap.c -o fastmap.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  bwtsw2_pair.c -o bwtsw2_pair.o
	[INFO] gcc -c -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS  main.c -o main.o
	[INFO] gcc -g -Wall -Wno-unused-function -O2 -fPIC -DHAVE_PTHREAD -DUSE_MALLOC_WRAPPERS bwashm.o bwase.o bwaseqio.o bwtgap.o bwtaln.o bamlite.o bwape.o kopen.o pemerge.o maxk.o bwtsw2_core.o bwtsw2_main.o bwtsw2_aux.o bwt_lite.o bwtsw2_chain.o fastmap.o bwtsw2_pair.o main.o -o bwa -L. -lbwa -lm -lz -lpthread -lrt
	[INFO] make[1]: Leaving directory `/home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/native/bwa-0.7.15'
	[INFO] if [ ! -d "build" ]; then mkdir build; fi
	[INFO] cp ./bwa-0.7.15/*.o build
	[INFO] gcc -shared -o build/libbwa.so build/*.o -lrt -lz
	[INFO] #cp build/libbwa.so ../resources/
	[INFO] cp build/libbwa.so ../../../target/classes/
	[INFO] #cd build && zip -r bwa ./* && cd ..
	[INFO] ================================================================================
	[INFO] SparkBWA library has been built.
	[INFO] Location    = /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/native/build/
	[INFO] JAVA_HOME   = /home/xubo/cloud/jdk1.7.0
	[INFO] ================================================================================
	[INFO] make: Leaving directory `/home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/main/native'
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ SparkBWA ---
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ SparkBWA ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ SparkBWA ---
	[INFO] No tests to run.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ SparkBWA ---
	[INFO] Building jar: /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/target/SparkBWA-0.2.jar
	[INFO] 
	[INFO] --- maven-shade-plugin:2.4.3:shade (default) @ SparkBWA ---
	[INFO] Excluding org.apache.spark:spark-core_2.11:jar:2.0.1 from the shaded jar.
	[INFO] Excluding org.apache.avro:avro-mapred:jar:hadoop2:1.7.7 from the shaded jar.
	[INFO] Excluding org.apache.avro:avro-ipc:jar:1.7.7 from the shaded jar.
	[INFO] Excluding org.apache.avro:avro:jar:1.7.7 from the shaded jar.
	[INFO] Excluding org.apache.avro:avro-ipc:jar:tests:1.7.7 from the shaded jar.
	[INFO] Excluding org.codehaus.jackson:jackson-core-asl:jar:1.9.13 from the shaded jar.
	[INFO] Excluding org.codehaus.jackson:jackson-mapper-asl:jar:1.9.13 from the shaded jar.
	[INFO] Excluding com.twitter:chill_2.11:jar:0.8.0 from the shaded jar.
	[INFO] Excluding com.esotericsoftware:kryo-shaded:jar:3.0.3 from the shaded jar.
	[INFO] Excluding com.esotericsoftware:minlog:jar:1.3.0 from the shaded jar.
	[INFO] Excluding org.objenesis:objenesis:jar:2.1 from the shaded jar.
	[INFO] Excluding com.twitter:chill-java:jar:0.8.0 from the shaded jar.
	[INFO] Excluding org.apache.xbean:xbean-asm5-shaded:jar:4.4 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-client:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-common:jar:2.2.0 from the shaded jar.
	[INFO] Excluding commons-cli:commons-cli:jar:1.2 from the shaded jar.
	[INFO] Excluding org.apache.commons:commons-math:jar:2.1 from the shaded jar.
	[INFO] Excluding xmlenc:xmlenc:jar:0.52 from the shaded jar.
	[INFO] Excluding commons-io:commons-io:jar:2.1 from the shaded jar.
	[INFO] Excluding commons-lang:commons-lang:jar:2.5 from the shaded jar.
	[INFO] Excluding commons-configuration:commons-configuration:jar:1.6 from the shaded jar.
	[INFO] Excluding commons-collections:commons-collections:jar:3.2.1 from the shaded jar.
	[INFO] Excluding commons-digester:commons-digester:jar:1.8 from the shaded jar.
	[INFO] Excluding commons-beanutils:commons-beanutils:jar:1.7.0 from the shaded jar.
	[INFO] Excluding commons-beanutils:commons-beanutils-core:jar:1.8.0 from the shaded jar.
	[INFO] Excluding com.google.protobuf:protobuf-java:jar:2.5.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-auth:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.commons:commons-compress:jar:1.4.1 from the shaded jar.
	[INFO] Excluding org.tukaani:xz:jar:1.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-hdfs:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.mortbay.jetty:jetty-util:jar:6.1.26 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-app:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-common:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-yarn-client:jar:2.2.0 from the shaded jar.
	[INFO] Excluding com.google.inject:guice:jar:3.0 from the shaded jar.
	[INFO] Excluding javax.inject:javax.inject:jar:1 from the shaded jar.
	[INFO] Excluding aopalliance:aopalliance:jar:1.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-yarn-server-common:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-shuffle:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-yarn-api:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-core:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-yarn-common:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-jobclient:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.hadoop:hadoop-annotations:jar:2.2.0 from the shaded jar.
	[INFO] Excluding org.apache.spark:spark-launcher_2.11:jar:2.0.1 from the shaded jar.
	[INFO] Excluding org.apache.spark:spark-network-common_2.11:jar:2.0.1 from the shaded jar.
	[INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
	[INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.5 from the shaded jar.
	[INFO] Excluding org.apache.spark:spark-network-shuffle_2.11:jar:2.0.1 from the shaded jar.
	[INFO] Excluding org.apache.spark:spark-unsafe_2.11:jar:2.0.1 from the shaded jar.
	[INFO] Excluding net.java.dev.jets3t:jets3t:jar:0.7.1 from the shaded jar.
	[INFO] Excluding commons-codec:commons-codec:jar:1.3 from the shaded jar.
	[INFO] Excluding commons-httpclient:commons-httpclient:jar:3.1 from the shaded jar.
	[INFO] Excluding org.apache.curator:curator-recipes:jar:2.4.0 from the shaded jar.
	[INFO] Excluding org.apache.curator:curator-framework:jar:2.4.0 from the shaded jar.
	[INFO] Excluding org.apache.curator:curator-client:jar:2.4.0 from the shaded jar.
	[INFO] Excluding org.apache.zookeeper:zookeeper:jar:3.4.5 from the shaded jar.
	[INFO] Excluding com.google.guava:guava:jar:14.0.1 from the shaded jar.
	[INFO] Excluding javax.servlet:javax.servlet-api:jar:3.1.0 from the shaded jar.
	[INFO] Excluding org.apache.commons:commons-lang3:jar:3.3.2 from the shaded jar.
	[INFO] Excluding org.apache.commons:commons-math3:jar:3.4.1 from the shaded jar.
	[INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
	[INFO] Excluding org.slf4j:slf4j-api:jar:1.7.16 from the shaded jar.
	[INFO] Excluding org.slf4j:jul-to-slf4j:jar:1.7.16 from the shaded jar.
	[INFO] Excluding org.slf4j:jcl-over-slf4j:jar:1.7.16 from the shaded jar.
	[INFO] Excluding log4j:log4j:jar:1.2.17 from the shaded jar.
	[INFO] Excluding org.slf4j:slf4j-log4j12:jar:1.7.16 from the shaded jar.
	[INFO] Excluding com.ning:compress-lzf:jar:1.0.3 from the shaded jar.
	[INFO] Excluding org.xerial.snappy:snappy-java:jar:1.1.2.6 from the shaded jar.
	[INFO] Excluding net.jpountz.lz4:lz4:jar:1.3.0 from the shaded jar.
	[INFO] Excluding org.roaringbitmap:RoaringBitmap:jar:0.5.11 from the shaded jar.
	[INFO] Excluding commons-net:commons-net:jar:2.2 from the shaded jar.
	[INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
	[INFO] Excluding org.json4s:json4s-jackson_2.11:jar:3.2.11 from the shaded jar.
	[INFO] Excluding org.json4s:json4s-core_2.11:jar:3.2.11 from the shaded jar.
	[INFO] Excluding org.json4s:json4s-ast_2.11:jar:3.2.11 from the shaded jar.
	[INFO] Excluding com.thoughtworks.paranamer:paranamer:jar:2.6 from the shaded jar.
	[INFO] Excluding org.scala-lang:scalap:jar:2.11.0 from the shaded jar.
	[INFO] Excluding org.scala-lang:scala-compiler:jar:2.11.0 from the shaded jar.
	[INFO] Excluding org.scala-lang.modules:scala-parser-combinators_2.11:jar:1.0.1 from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.core:jersey-client:jar:2.22.2 from the shaded jar.
	[INFO] Excluding javax.ws.rs:javax.ws.rs-api:jar:2.0.1 from the shaded jar.
	[INFO] Excluding org.glassfish.hk2:hk2-api:jar:2.4.0-b34 from the shaded jar.
	[INFO] Excluding org.glassfish.hk2:hk2-utils:jar:2.4.0-b34 from the shaded jar.
	[INFO] Excluding org.glassfish.hk2.external:aopalliance-repackaged:jar:2.4.0-b34 from the shaded jar.
	[INFO] Excluding org.glassfish.hk2.external:javax.inject:jar:2.4.0-b34 from the shaded jar.
	[INFO] Excluding org.glassfish.hk2:hk2-locator:jar:2.4.0-b34 from the shaded jar.
	[INFO] Excluding org.javassist:javassist:jar:3.18.1-GA from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.core:jersey-common:jar:2.22.2 from the shaded jar.
	[INFO] Excluding javax.annotation:javax.annotation-api:jar:1.2 from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.bundles.repackaged:jersey-guava:jar:2.22.2 from the shaded jar.
	[INFO] Excluding org.glassfish.hk2:osgi-resource-locator:jar:1.0.1 from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.core:jersey-server:jar:2.22.2 from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.media:jersey-media-jaxb:jar:2.22.2 from the shaded jar.
	[INFO] Excluding javax.validation:validation-api:jar:1.1.0.Final from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet:jar:2.22.2 from the shaded jar.
	[INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.22.2 from the shaded jar.
	[INFO] Excluding org.apache.mesos:mesos:jar:shaded-protobuf:0.21.1 from the shaded jar.
	[INFO] Excluding io.netty:netty-all:jar:4.0.29.Final from the shaded jar.
	[INFO] Excluding io.netty:netty:jar:3.8.0.Final from the shaded jar.
	[INFO] Excluding com.clearspring.analytics:stream:jar:2.7.0 from the shaded jar.
	[INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.2 from the shaded jar.
	[INFO] Excluding io.dropwizard.metrics:metrics-jvm:jar:3.1.2 from the shaded jar.
	[INFO] Excluding io.dropwizard.metrics:metrics-json:jar:3.1.2 from the shaded jar.
	[INFO] Excluding io.dropwizard.metrics:metrics-graphite:jar:3.1.2 from the shaded jar.
	[INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.5 from the shaded jar.
	[INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.5 from the shaded jar.
	[INFO] Excluding com.fasterxml.jackson.module:jackson-module-scala_2.11:jar:2.6.5 from the shaded jar.
	[INFO] Excluding org.scala-lang:scala-reflect:jar:2.11.7 from the shaded jar.
	[INFO] Excluding com.fasterxml.jackson.module:jackson-module-paranamer:jar:2.6.5 from the shaded jar.
	[INFO] Excluding org.apache.ivy:ivy:jar:2.4.0 from the shaded jar.
	[INFO] Excluding oro:oro:jar:2.0.8 from the shaded jar.
	[INFO] Excluding net.razorvine:pyrolite:jar:4.9 from the shaded jar.
	[INFO] Excluding net.sf.py4j:py4j:jar:0.10.3 from the shaded jar.
	[INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.0.1 from the shaded jar.
	[INFO] Excluding org.scalatest:scalatest_2.11:jar:2.2.6 from the shaded jar.
	[INFO] Excluding org.scala-lang.modules:scala-xml_2.11:jar:1.0.2 from the shaded jar.
	[INFO] Excluding org.spark-project.spark:unused:jar:1.0.0 from the shaded jar.
	[INFO] Including cz.adamh.utils:native-utils:jar:1.0-SNAPSHOT in the shaded jar.
	[INFO] Replacing original artifact with shaded artifact.
	[INFO] Replacing /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/target/SparkBWA-0.2.jar with /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/target/SparkBWA-0.2-shaded.jar
	[INFO] Dependency-reduced POM written at: /home/xubo/xubo/tools/SparkBWA20170116/SparkBWA/dependency-reduced-pom.xml
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 17:09 min
	[INFO] Finished at: 2017-01-16T11:05:10+08:00
	[INFO] Final Memory: 37M/295M
	[INFO] ------------------------------------------------------------------------
	xubo@xubo:~/xubo/tools/SparkBWA20170116/SparkBWA$ 




参考

		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
		【3】https://github.com/citiususc/SparkBWA
		【4】https://github.com/adamheinrich/native-utils
