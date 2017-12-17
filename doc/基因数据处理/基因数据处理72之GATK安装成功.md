	
	
1.下载：
	
	git clone https://github.com/broadgsa/gatk-protected.git

2.安装：

	git checkout 3.5
	mvn clean package -DskipTests

	
3.安装成功：

	[INFO] Reactor Summary:
	[INFO] 
	[INFO] GATK Root .......................................... SUCCESS [  0.590 s]
	[INFO] GATK Aggregator .................................... SUCCESS [  0.502 s]
	[INFO] GATK GSALib ........................................ SUCCESS [  0.863 s]
	[INFO] GATK Utils ......................................... SUCCESS [ 32.395 s]
	[INFO] GATK Engine ........................................ SUCCESS [  9.264 s]
	[INFO] GATK Tools Public .................................. SUCCESS [ 23.222 s]
	[INFO] External Example ................................... SUCCESS [ 12.317 s]
	[INFO] GATK Queue ......................................... SUCCESS [11:32 min]
	[INFO] GATK Queue Extensions Generator .................... SUCCESS [  0.128 s]
	[INFO] GATK Queue Extensions Public ....................... SUCCESS [02:07 min]
	[INFO] GATK Aggregator Public ............................. SUCCESS [  0.003 s]
	[INFO] GATK Tools Protected ............................... SUCCESS [ 32.863 s]
	[INFO] GATK Package Distribution .......................... SUCCESS [01:08 min]
	[INFO] GATK Queue Extensions Distribution ................. SUCCESS [01:34 min]
	[INFO] GATK Queue Package Distribution .................... SUCCESS [02:37 min]
	[INFO] GATK Aggregator Protected .......................... SUCCESS [  0.005 s]
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------

参考：
【1】https://github.com/broadgsa/gatk-protected
【2】https://www.broadinstitute.org/gatk/download/

	记录：
（1）Master：
	
	[WARNING]   - org.apache.commons.httpclient.auth.AuthScope
	[WARNING]   - org.apache.commons.httpclient.cookie.RFC2965Spec$CookieCommentUrlAttributeHandler
	[WARNING]   - org.apache.commons.httpclient.HttpClientError
	[WARNING]   - 157 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-engine-3.5.jar define 305 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.engine.iterators.BoundedReadIterator
	[WARNING]   - org.broadinstitute.gatk.engine.filters.ReadNameFilter
	[WARNING]   - org.broadinstitute.gatk.engine.datasources.providers.LocusReferenceView
	[WARNING]   - org.broadinstitute.gatk.engine.alignment.reference.packing.BasePackedInputStream
	[WARNING]   - org.broadinstitute.gatk.engine.io.NWaySAMFileWriter
	[WARNING]   - org.broadinstitute.gatk.engine.filters.MissingReadGroupFilter
	[WARNING]   - org.broadinstitute.gatk.engine.alignment.reference.bwt.SuffixArray$SuffixArrayComparator
	[WARNING]   - org.broadinstitute.gatk.engine.filters.BadMateFilter
	[WARNING]   - org.broadinstitute.gatk.engine.walkers.Allows
	[WARNING]   - org.broadinstitute.gatk.engine.traversals.TraverseReadPairs
	[WARNING]   - 295 more...
	[WARNING] gatk-tools-public-3.5.jar, gatk-package-distribution-3.5.jar define 228 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ConcordanceMetrics$SiteConcordanceType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$7
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.VariantSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.MultiallelicSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AnnotationInterfaceManager
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.readutils.ClipReads
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$1
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ValidateVariants$ValidationType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.SnpEffUtil
	[WARNING]   - 218 more...
	[WARNING] commons-logging-1.1.1.jar, gatk-package-distribution-3.5.jar define 28 overlappping classes: 
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$2
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl
	[WARNING]   - org.apache.commons.logging.LogFactory$3
	[WARNING]   - org.apache.commons.logging.impl.WeakHashtable$1
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$3
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$1
	[WARNING]   - org.apache.commons.logging.LogFactory$6
	[WARNING]   - org.apache.commons.logging.impl.WeakHashtable
	[WARNING]   - org.apache.commons.logging.impl.AvalonLogger
	[WARNING]   - org.apache.commons.logging.LogConfigurationException
	[WARNING]   - 18 more...
	[WARNING] maven-shade-plugin has detected that some .class files
	[WARNING] are present in two or more JARs. When this happens, only
	[WARNING] one single version of the class is copied in the uberjar.
	[WARNING] Usually this is not harmful and you can skeep these
	[WARNING] warnings, otherwise try to manually exclude artifacts
	[WARNING] based on mvn dependency:tree -Ddetail=true and the above
	[WARNING] output
	[WARNING] See http://docs.codehaus.org/display/MAVENUSER/Shade+Plugin
	[INFO] Minimized 28439 -> 10985 (38%)
	[INFO] Replacing original artifact with shaded artifact.
	[INFO] Replacing /home/hadoop/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5.jar with /home/hadoop/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5-shaded.jar
	[INFO] 
	[INFO] --- maven-assembly-plugin:2.4:single (binary-dist) @ gatk-package-distribution ---
	[INFO] Reading assembly descriptor: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-package-distribution/../../public/src/main/assembly/binary-dist.xml
	[WARNING] Invalid POM for com.google.code.cofoja:cofoja:jar:1.2-20140817, transitive dependencies (if any) will not be available, enable debug logging for more details
	[INFO] Building tar: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5-binary-dist.tar.bz2
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-executable-jar) @ gatk-package-distribution ---
	Downloading: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.pom (7 KB at 16.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0/maven-artifact-2.0.jar
	Downloaded: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.jar (65 KB at 29.7 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0/maven-artifact-2.0.jar (77 KB at 15.4 KB/sec)
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-package-jar) @ gatk-package-distribution ---
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-git-release) @ gatk-package-distribution ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building GATK Queue Extensions Distribution 3.5
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ gatk-queue-extensions-distribution ---
	[INFO] Deleting /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution (includes = [javadoc.sh, options, packages], excludes = [])
	[INFO] Deleting /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution (includes = [dependency-reduced-pom.xml], excludes = [])
	[INFO] 
	[INFO] --- gitdescribe-maven-plugin:2.0:gitdescribe (gitdescribe-initialize) @ gatk-queue-extensions-distribution ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:regex-property (fix-version-initialize) @ gatk-queue-extensions-distribution ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:add-source (add-gatk-extensions) @ gatk-queue-extensions-distribution ---
	[INFO] Source directory: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/../../public/gatk-queue-extensions-public/src/main/scala added.
	[INFO] Source directory: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/generated-sources/gatk-extensions added.
	[INFO] 
	[INFO] --- exec-maven-plugin:1.2.1:exec (generate-gatk-extensions) @ gatk-queue-extensions-distribution ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gatk-queue-extensions-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/src/main/resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (default) @ gatk-queue-extensions-distribution ---
	[INFO] Checking for multiple versions of scala
	[WARNING] Invalid POM for com.google.code.cofoja:cofoja:jar:1.2-20140817, transitive dependencies (if any) will not be available, enable debug logging for more details
	[WARNING] Invalid POM for com.google.code.cofoja:cofoja:jar:1.2-20140817, transitive dependencies (if any) will not be available, enable debug logging for more details
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] /home/hadoop/xubo/tools/gatk-protected/public/gatk-queue-extensions-public/src/main/scala:-1: info: compiling
	[INFO] /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/generated-sources/gatk-extensions:-1: info: compiling
	[INFO] Compiling 148 source files to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/classes at 1465303337200
	[INFO] prepare-compile in 0 s
	[INFO] compile in 79 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-package-info) @ gatk-queue-extensions-distribution ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-java) @ gatk-queue-extensions-distribution ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gatk-queue-extensions-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/src/test/resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:testCompile (default) @ gatk-queue-extensions-distribution ---
	[INFO] Checking for multiple versions of scala
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/src/test/scala:-1: info: compiling
	[INFO] Compiling 2 source files to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/test-classes at 1465303417190
	[INFO] prepare-compile in 0 s
	[INFO] compile in 6 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (testCompile-java) @ gatk-queue-extensions-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.16:test (unit-tests) @ gatk-queue-extensions-distribution ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ gatk-queue-extensions-distribution ---
	[INFO] Building jar: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/gatk-queue-extensions-distribution-3.5.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (test-jar) @ gatk-queue-extensions-distribution ---
	[INFO] Building jar: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/gatk-queue-extensions-distribution-3.5-tests.jar
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building GATK Queue Package Distribution 3.5
	[INFO] ------------------------------------------------------------------------
	Downloading: file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom
	[WARNING] Could not validate integrity of download from file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom: Checksum validation failed, no checksums available
	[WARNING] Checksum validation failed, no checksums available for file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom
	Downloaded: file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom (363 B at 354.5 KB/sec)
	Downloading: file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar
	[WARNING] Could not validate integrity of download from file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar: Checksum validation failed, no checksums available
	[WARNING] Checksum validation failed, no checksums available for file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar
	Downloaded: file:/home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar (4081 KB at 54405.5 KB/sec)
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ gatk-queue-package-distribution ---
	[INFO] Deleting /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution (includes = [javadoc.sh, options, packages], excludes = [])
	[INFO] Deleting /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution (includes = [dependency-reduced-pom.xml], excludes = [])
	[INFO] 
	[INFO] --- gitdescribe-maven-plugin:2.0:gitdescribe (gitdescribe-initialize) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:regex-property (fix-version-initialize) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gatk-queue-package-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-package-info) @ gatk-queue-package-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-java) @ gatk-queue-package-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gatk-queue-package-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (testCompile-java) @ gatk-queue-package-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.16:test (unit-tests) @ gatk-queue-package-distribution ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-dependency-plugin:2.8:unpack-dependencies (unpack-direct-dependencies) @ gatk-queue-package-distribution ---
	[INFO] Unpacking /home/hadoop/.m2/repository/org/scala-lang/scala-compiler/2.10.2/scala-compiler-2.10.2.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/net/java/dev/jna/jna/3.2.7/jna-3.2.7.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/com/google/code/cofoja/cofoja/1.2-20140817/cofoja-1.2-20140817.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/gatk-queue-extensions-distribution-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/com/github/broadinstitute/picard/1.141/picard-1.141.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/org/scala-lang/scala-library/2.10.2/scala-library-2.10.2.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/xubo/tools/gatk-protected/public/gatk-queue/target/gatk-queue-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/hadoop/.m2/repository/javax/mail/mail/1.4.4/mail-1.4.4.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (executable-jar) @ gatk-queue-package-distribution ---
	[WARNING] JAR will be empty - no content was marked for inclusion!
	[INFO] Building jar: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/Queue.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (unshaded-default-jar) @ gatk-queue-package-distribution ---
	[INFO] Building jar: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (test-jar) @ gatk-queue-package-distribution ---
	[INFO] Skipping packaging of the test-jar
	[INFO] 
	[INFO] --- maven-dependency-plugin:2.8:copy-dependencies (executable-jar-lib) @ gatk-queue-package-distribution ---
	[INFO] Copying scala-reflect-2.10.2.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/scala-reflect-2.10.2.jar
	[INFO] Copying gatk-queue-extensions-public-3.5-example-resources.tar.bz2 to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-extensions-public-3.5-example-resources.tar.bz2
	[INFO] Copying scala-compiler-2.10.2.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/scala-compiler-2.10.2.jar
	[INFO] Copying gatk-queue-extensions-distribution-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-extensions-distribution-3.5.jar
	[INFO] Copying guava-18.0.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/guava-18.0.jar
	[INFO] Copying gatk-package-distribution-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-package-distribution-3.5.jar
	[INFO] Copying gatk-queue-extensions-generator-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-extensions-generator-3.5.jar
	[INFO] Copying snpeff-2.0.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/snpeff-2.0.5.jar
	[INFO] Copying scala-library-2.10.2.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/scala-library-2.10.2.jar
	[INFO] Copying gatk-queue-3.5.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-3.5.jar
	[INFO] Copying commons-email-1.2.jar to /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/commons-email-1.2.jar
	[INFO] httpcore-4.1.jar already exists in destination.
	[INFO] google-api-client-1.19.0.jar already exists in destination.
	[INFO] jcommander-1.27.jar already exists in destination.
	[INFO] stax-api-1.0.1.jar already exists in destination.
	[INFO] commons-logging-1.1.1.jar already exists in destination.
	[INFO] gatk-tools-java-1.1.jar already exists in destination.
	[INFO] concurrent-1.3.4.jar already exists in destination.
	[INFO] stax-1.2.0.jar already exists in destination.
	[INFO] ant-1.8.2.jar already exists in destination.
	[INFO] picard-1.141.jar already exists in destination.
	[INFO] gson-2.2.2.jar already exists in destination.
	[INFO] google-oauth-client-java6-1.19.0.jar already exists in destination.
	[INFO] jgrapht-0.8.3.jar already exists in destination.
	[INFO] commons-io-2.1.jar already exists in destination.
	[INFO] jetty-util-6.1.26.jar already exists in destination.
	[INFO] ant-launcher-1.8.2.jar already exists in destination.
	[INFO] commons-httpclient-3.1.jar already exists in destination.
	[INFO] xml-apis-1.0.b2.jar already exists in destination.
	[INFO] commons-codec-1.2.jar already exists in destination.
	[INFO] activation-1.1.jar already exists in destination.
	[INFO] simple-xml-2.0.4.jar already exists in destination.
	[INFO] commons-lang-2.5.jar already exists in destination.
	[INFO] drmaa-gridengine-6.2u5.jar already exists in destination.
	[INFO] reflections-0.9.9-RC1.jar already exists in destination.
	[INFO] htsjdk-1.141.jar already exists in destination.
	[INFO] jna-3.2.7.jar already exists in destination.
	[INFO] colt-1.2.0.jar already exists in destination.
	[INFO] httpclient-4.1.1.jar already exists in destination.
	[INFO] xz-1.5.jar already exists in destination.
	[INFO] google-api-client-java6-1.19.0.jar already exists in destination.
	[INFO] jets3t-0.8.1.jar already exists in destination.
	[INFO] cofoja-1.2-20140817.jar already exists in destination.
	[INFO] google-oauth-client-1.19.0.jar already exists in destination.
	[INFO] google-oauth-client-jetty-1.19.0.jar already exists in destination.
	[INFO] jsr305-1.3.9.jar already exists in destination.
	[INFO] gatk-utils-3.5-example-resources.tar.bz2 already exists in destination.
	[INFO] gsalib-3.5.tar.gz already exists in destination.
	[INFO] gatk-utils-3.5.jar already exists in destination.
	[INFO] mail-1.4.4.jar already exists in destination.
	[INFO] commons-compress-1.4.1.jar already exists in destination.
	[INFO] snappy-java-1.0.3-rc3.jar already exists in destination.
	[INFO] javassist-3.16.1-GA.jar already exists in destination.
	[INFO] google-http-client-jackson2-1.19.0.jar already exists in destination.
	[INFO] servlet-api-2.5.jar already exists in destination.
	[INFO] fastutil-6.5.3.jar already exists in destination.
	[INFO] commons-collections-3.2.1.jar already exists in destination.
	[INFO] gatk-engine-3.5.jar already exists in destination.
	[INFO] freemarker-2.3.18.jar already exists in destination.
	[INFO] jama-1.0.2.jar already exists in destination.
	[INFO] commons-math-2.2.jar already exists in destination.
	[INFO] slf4j-log4j12-1.7.5.jar already exists in destination.
	[INFO] log4j-1.2.15.jar already exists in destination.
	[INFO] gov.nist.math.jama-1.1.1.jar already exists in destination.
	[INFO] gatk-tools-protected-3.5.jar already exists in destination.
	[INFO] slf4j-api-1.6.1.jar already exists in destination.
	[INFO] commons-jexl-2.1.1.jar already exists in destination.
	[INFO] google-genomics-utils-v1beta2-0.19.jar already exists in destination.
	[INFO] dom4j-1.6.1.jar already exists in destination.
	[INFO] google-api-services-genomics-v1beta2-rev9-1.19.0.jar already exists in destination.
	[INFO] jackson-core-2.1.3.jar already exists in destination.
	[INFO] drmaa-common-1.0.jar already exists in destination.
	[INFO] google-http-client-1.19.0.jar already exists in destination.
	[INFO] jetty-6.1.26.jar already exists in destination.
	[INFO] java-xmlbuilder-0.4.jar already exists in destination.
	[INFO] gatk-tools-public-3.5.jar already exists in destination.
	[INFO] 
	[INFO] --- maven-shade-plugin:2.1:shade (package-jar) @ gatk-queue-package-distribution ---
	[WARNING] Map in class org.apache.maven.plugins.shade.resource.ManifestResourceTransformer declares value type as: class java.util.jar.Attributes but saw: class java.lang.String at runtime
	[INFO] Including org.broadinstitute.gatk:gatk-queue:jar:3.5 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-utils:jar:3.5 in the shaded jar.
	[INFO] Including log4j:log4j:jar:1.2.15 in the shaded jar.
	[INFO] Including net.sf.jgrapht:jgrapht:jar:0.8.3 in the shaded jar.
	[INFO] Including org.apache.commons:commons-email:jar:1.2 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-package-distribution:jar:3.5 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-engine:jar:3.5 in the shaded jar.
	[INFO] Including net.java.dev.jets3t:jets3t:jar:0.8.1 in the shaded jar.
	[INFO] Including com.jamesmurty.utils:java-xmlbuilder:jar:0.4 in the shaded jar.
	[INFO] Including org.simpleframework:simple-xml:jar:2.0.4 in the shaded jar.
	[INFO] Including stax:stax-api:jar:1.0.1 in the shaded jar.
	[INFO] Including stax:stax:jar:1.2.0 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-tools-public:jar:3.5 in the shaded jar.
	[INFO] Including org.apache.commons:commons-jexl:jar:2.1.1 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-tools-protected:jar:3.5 in the shaded jar.
	[INFO] Including gov.nist.math:jama:jar:1.0.2 in the shaded jar.
	[INFO] Including org.slf4j:slf4j-log4j12:jar:1.7.5 in the shaded jar.
	[INFO] Including com.github.samtools:htsjdk:jar:1.141 in the shaded jar.
	[INFO] Including org.xerial.snappy:snappy-java:jar:1.0.3-rc3 in the shaded jar.
	[INFO] Including org.apache.commons:commons-compress:jar:1.4.1 in the shaded jar.
	[INFO] Including org.tukaani:xz:jar:1.5 in the shaded jar.
	[INFO] Including org.apache.ant:ant:jar:1.8.2 in the shaded jar.
	[INFO] Including org.apache.ant:ant-launcher:jar:1.8.2 in the shaded jar.
	[INFO] Including commons-logging:commons-logging:jar:1.1.1 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-queue-extensions-distribution:jar:3.5 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-queue-extensions-generator:jar:3.5 in the shaded jar.
	[INFO] Including org.scala-lang:scala-library:jar:2.10.2 in the shaded jar.
	[INFO] Including org.scala-lang:scala-compiler:jar:2.10.2 in the shaded jar.
	[INFO] Including org.scala-lang:scala-reflect:jar:2.10.2 in the shaded jar.
	[INFO] Including com.github.broadinstitute:picard:jar:1.141 in the shaded jar.
	[INFO] Including com.google.cloud.genomics:gatk-tools-java:jar:1.1 in the shaded jar.
	[INFO] Including com.google.api-client:google-api-client:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.oauth-client:google-oauth-client:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.oauth-client:google-oauth-client-jetty:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.oauth-client:google-oauth-client-java6:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.http-client:google-http-client:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.http-client:google-http-client-jackson2:jar:1.19.0 in the shaded jar.
	[INFO] Including com.fasterxml.jackson.core:jackson-core:jar:2.1.3 in the shaded jar.
	[INFO] Including com.google.apis:google-api-services-genomics:jar:v1beta2-rev9-1.19.0 in the shaded jar.
	[INFO] Including com.google.cloud.genomics:google-genomics-utils:jar:v1beta2-0.19 in the shaded jar.
	[INFO] Including com.google.api-client:google-api-client-java6:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.guava:guava:jar:18.0 in the shaded jar.
	[INFO] Including gov.nist.math.jama:gov.nist.math.jama:jar:1.1.1 in the shaded jar.
	[INFO] Including org.mortbay.jetty:jetty:jar:6.1.26 in the shaded jar.
	[INFO] Including org.mortbay.jetty:jetty-util:jar:6.1.26 in the shaded jar.
	[INFO] Including javax.servlet:servlet-api:jar:2.5 in the shaded jar.
	[INFO] Including javax.mail:mail:jar:1.4.4 in the shaded jar.
	[INFO] Including javax.activation:activation:jar:1.1 in the shaded jar.
	[INFO] Including net.java.dev.jna:jna:jar:3.2.7 in the shaded jar.
	[INFO] Including com.google.code.cofoja:cofoja:jar:1.2-20140817 in the shaded jar.
	[INFO] Including net.sf.snpeff:snpeff:jar:2.0.5 in the shaded jar.
	[INFO] Including commons-httpclient:commons-httpclient:jar:3.1 in the shaded jar.
	[INFO] Including commons-codec:commons-codec:jar:1.2 in the shaded jar.
	[INFO] Excluding org.broadinstitute.gatk:gatk-utils:tar.bz2:example-resources:3.5 from the shaded jar.
	[INFO] Including colt:colt:jar:1.2.0 in the shaded jar.
	[INFO] Including concurrent:concurrent:jar:1.3.4 in the shaded jar.
	[INFO] Including it.unimi.dsi:fastutil:jar:6.5.3 in the shaded jar.
	[INFO] Including org.reflections:reflections:jar:0.9.9-RC1 in the shaded jar.
	[INFO] Including org.javassist:javassist:jar:3.16.1-GA in the shaded jar.
	[INFO] Including dom4j:dom4j:jar:1.6.1 in the shaded jar.
	[INFO] Including xml-apis:xml-apis:jar:1.0.b2 in the shaded jar.
	[INFO] Including org.slf4j:slf4j-api:jar:1.6.1 in the shaded jar.
	[INFO] Including org.freemarker:freemarker:jar:2.3.18 in the shaded jar.
	[INFO] Including commons-lang:commons-lang:jar:2.5 in the shaded jar.
	[INFO] Including commons-io:commons-io:jar:2.1 in the shaded jar.
	[INFO] Including commons-collections:commons-collections:jar:3.2.1 in the shaded jar.
	[INFO] Including org.apache.commons:commons-math:jar:2.2 in the shaded jar.
	[INFO] Including us.levk:drmaa-gridengine:jar:6.2u5 in the shaded jar.
	[INFO] Including us.levk:drmaa-common:jar:1.0 in the shaded jar.
	[INFO] Including com.google.code.gson:gson:jar:2.2.2 in the shaded jar.
	[INFO] Including org.apache.httpcomponents:httpclient:jar:4.1.1 in the shaded jar.
	[INFO] Including org.apache.httpcomponents:httpcore:jar:4.1 in the shaded jar.
	[INFO] Excluding org.broadinstitute.gatk:gsalib:tar.gz:3.5 from the shaded jar.
	[INFO] Excluding org.broadinstitute.gatk:gatk-queue-extensions-public:tar.bz2:example-resources:3.5 from the shaded jar.
	[INFO] Including com.google.code.findbugs:jsr305:jar:1.3.9 in the shaded jar.
	[INFO] Including com.beust:jcommander:jar:1.27 in the shaded jar.
	[INFO] Minimizing jar org.broadinstitute.gatk:gatk-queue-package-distribution:jar:3.5
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, commons-codec-1.2.jar define 10 overlappping classes: 
	[WARNING]   - org.apache.commons.codec.BinaryEncoder
	[WARNING]   - org.apache.commons.codec.BinaryDecoder
	[WARNING]   - org.apache.commons.codec.Encoder
	[WARNING]   - org.apache.commons.codec.binary.Base64
	[WARNING]   - org.apache.commons.codec.Decoder
	[WARNING]   - org.apache.commons.codec.net.URLCodec
	[WARNING]   - org.apache.commons.codec.DecoderException
	[WARNING]   - org.apache.commons.codec.EncoderException
	[WARNING]   - org.apache.commons.codec.StringEncoder
	[WARNING]   - org.apache.commons.codec.StringDecoder
	[WARNING] dom4j-1.6.1.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 88 overlappping classes: 
	[WARNING]   - org.dom4j.io.DispatchHandler
	[WARNING]   - org.dom4j.dtd.ElementDecl
	[WARNING]   - org.dom4j.io.SAXHelper
	[WARNING]   - org.dom4j.Branch
	[WARNING]   - org.dom4j.DocumentException
	[WARNING]   - org.dom4j.tree.ContentListFacade
	[WARNING]   - org.dom4j.tree.ConcurrentReaderHashMap$1
	[WARNING]   - org.dom4j.Visitor
	[WARNING]   - org.dom4j.tree.AbstractDocumentType
	[WARNING]   - org.dom4j.tree.NamespaceCache
	[WARNING]   - 78 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, freemarker-2.3.18.jar, snpeff-2.0.5.jar define 172 overlappping classes: 
	[WARNING]   - freemarker.ext.xml.JdomNavigator
	[WARNING]   - freemarker.ext.jdom.NodeListModel$NamedNodeOperator
	[WARNING]   - freemarker.ext.xml.DomNavigator
	[WARNING]   - freemarker.core.CommandLine
	[WARNING]   - freemarker.ext.jdom.NodeListModel$QNameOp
	[WARNING]   - freemarker.ext.jsp.FreeMarkerJspFactory
	[WARNING]   - freemarker.ext.xml.Navigator$ParentOp
	[WARNING]   - freemarker.core.RegexBuiltins$RegexMatchModel$2
	[WARNING]   - freemarker.debug.DebuggerClient
	[WARNING]   - freemarker.core.RegexBuiltins$ReplaceMethod
	[WARNING]   - 162 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, gatk-engine-3.5.jar define 305 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.engine.iterators.BoundedReadIterator
	[WARNING]   - org.broadinstitute.gatk.engine.filters.ReadNameFilter
	[WARNING]   - org.broadinstitute.gatk.engine.datasources.providers.LocusReferenceView
	[WARNING]   - org.broadinstitute.gatk.engine.alignment.reference.packing.BasePackedInputStream
	[WARNING]   - org.broadinstitute.gatk.engine.io.NWaySAMFileWriter
	[WARNING]   - org.broadinstitute.gatk.engine.filters.MissingReadGroupFilter
	[WARNING]   - org.broadinstitute.gatk.engine.alignment.reference.bwt.SuffixArray$SuffixArrayComparator
	[WARNING]   - org.broadinstitute.gatk.engine.filters.BadMateFilter
	[WARNING]   - org.broadinstitute.gatk.engine.walkers.Allows
	[WARNING]   - org.broadinstitute.gatk.engine.traversals.TraverseReadPairs
	[WARNING]   - 295 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, jgrapht-0.8.3.jar define 63 overlappping classes: 
	[WARNING]   - org.jgrapht.graph.DefaultDirectedGraph
	[WARNING]   - org.jgrapht.traverse.CrossComponentIterator$FlyweightEdgeEvent
	[WARNING]   - org.jgrapht.graph.IntrusiveEdge
	[WARNING]   - org.jgrapht.graph.AbstractBaseGraph
	[WARNING]   - org.jgrapht.alg.CycleDetector$1
	[WARNING]   - org.jgrapht.alg.StrongConnectivityInspector$1
	[WARNING]   - org.jgrapht.graph.Subgraph$BaseGraphListener
	[WARNING]   - org.jgrapht.EdgeFactory
	[WARNING]   - org.jgrapht.event.TraversalListener
	[WARNING]   - org.jgrapht.graph.AbstractBaseGraph$DirectedSpecifics
	[WARNING]   - 53 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, commons-io-2.1.jar define 32 overlappping classes: 
	[WARNING]   - org.apache.commons.io.filefilter.FalseFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.SuffixFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.TrueFileFilter
	[WARNING]   - org.apache.commons.io.input.ClosedInputStream
	[WARNING]   - org.apache.commons.io.filefilter.NotFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.ConditionalFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.IOFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.OrFileFilter
	[WARNING]   - org.apache.commons.io.comparator.LastModifiedFileComparator
	[WARNING]   - org.apache.commons.io.filefilter.PrefixFileFilter
	[WARNING]   - 22 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, commons-jexl-2.1.1.jar, gatk-package-distribution-3.5.jar define 158 overlappping classes: 
	[WARNING]   - org.apache.commons.jexl2.ExpressionImpl$1
	[WARNING]   - org.apache.commons.jexl2.parser.ASTNotNode
	[WARNING]   - org.apache.commons.jexl2.parser.Parser$JJCalls
	[WARNING]   - org.apache.commons.jexl2.parser.ASTReference
	[WARNING]   - org.apache.commons.jexl2.parser.Token
	[WARNING]   - org.apache.commons.jexl2.internal.introspection.MethodMap
	[WARNING]   - org.apache.commons.jexl2.parser.ASTSizeFunction
	[WARNING]   - org.apache.commons.jexl2.ExpressionImpl
	[WARNING]   - org.apache.commons.jexl2.parser.ASTForeachStatement
	[WARNING]   - org.apache.commons.jexl2.introspection.JexlPropertySet
	[WARNING]   - 148 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, scala-compiler-2.10.2.jar define 8560 overlappping classes: 
	[WARNING]   - scala.tools.nsc.transform.patmat.MatchTranslation$MatchTranslator$ExtractorCallProd
	[WARNING]   - scala.tools.nsc.ast.DocComments$DocComment$$anonfun$defineVariables$2
	[WARNING]   - ch.epfl.lamp.compiler.msil.emit.ConstructorBuilder
	[WARNING]   - scala.tools.nsc.backend.msil.GenMSIL$BytecodeGenerator$$anonfun$scala$tools$nsc$backend$msil$GenMSIL$BytecodeGenerator$$genMethod$3$$anonfun$apply$5
	[WARNING]   - scala.tools.nsc.transform.Constructors$ConstructorTransformer$$anonfun$8
	[WARNING]   - scala.tools.nsc.backend.msil.GenMSIL$BytecodeGenerator$$anonfun$customModifiers$1
	[WARNING]   - scala.tools.nsc.backend.MSILPlatform$class
	[WARNING]   - scala.tools.nsc.ast.DocComments$$anonfun$expandInternal$1$1$$anonfun$apply$5
	[WARNING]   - scala.tools.nsc.CommonRunner
	[WARNING]   - scala.tools.nsc.interpreter.Power$ReplUtilities$$anonfun$clazz$1
	[WARNING]   - 8550 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-tools-protected-3.5.jar, gatk-package-distribution-3.5.jar define 524 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.CombineGVCFs$OverallState
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.diagnostics.diagnosetargets.CallableStatus
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.haplotypecaller.PairHMMLikelihoodCalculationEngine$PCR_ERROR_MODEL
	[WARNING]   - org.broadinstitute.gatk.utils.collections.CountSet
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.haplotypecaller.LDMerger$LDMergeData
	[WARNING]   - org.broadinstitute.gatk.utils.variant.TandemRepeatFinder$Result
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.DepthPerAlleleBySample
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.bqsr.ReadRecalibrationInfo
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.haplotypecaller.graphs.TestGraph
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.validation.validationsiteselector.KeepAFSpectrumFrequencySelector
	[WARNING]   - 514 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, commons-lang-2.5.jar, gatk-package-distribution-3.5.jar define 45 overlappping classes: 
	[WARNING]   - org.apache.commons.lang.ObjectUtils
	[WARNING]   - org.apache.commons.lang.builder.IDKey
	[WARNING]   - org.apache.commons.lang.exception.NestableRuntimeException
	[WARNING]   - org.apache.commons.lang.builder.ToStringStyle$MultiLineToStringStyle
	[WARNING]   - org.apache.commons.lang.StringEscapeUtils
	[WARNING]   - org.apache.commons.lang.CharRange
	[WARNING]   - org.apache.commons.lang.IntHashMap
	[WARNING]   - org.apache.commons.lang.builder.EqualsBuilder
	[WARNING]   - org.apache.commons.lang.Entities$ArrayEntityMap
	[WARNING]   - org.apache.commons.lang.Entities$BinaryEntityMap
	[WARNING]   - 35 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, snpeff-2.0.5.jar define 1319 overlappping classes: 
	[WARNING]   - flanagan.physprop.IonicRadii
	[WARNING]   - junit.awtui.TestRunner$2
	[WARNING]   - gnu.trove.THashMap$EqProcedure
	[WARNING]   - gnu.trove.TFloatStack
	[WARNING]   - gnu.trove.decorator.TDoubleByteHashMapDecorator$1
	[WARNING]   - gnu.trove.decorator.TDoubleShortHashMapDecorator$1$1
	[WARNING]   - gnu.trove.decorator.TLongDoubleHashMapDecorator$1
	[WARNING]   - flanagan.analysis.RegressionFunction2
	[WARNING]   - gnu.trove.TShortHashSet$1
	[WARNING]   - ca.mcgill.mcb.pcingola.interval.codonChange.CodonChangeSnp
	[WARNING]   - 1309 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, slf4j-log4j12-1.7.5.jar define 6 overlappping classes: 
	[WARNING]   - org.slf4j.impl.StaticMarkerBinder
	[WARNING]   - org.slf4j.impl.Log4jLoggerFactory
	[WARNING]   - org.slf4j.impl.StaticLoggerBinder
	[WARNING]   - org.slf4j.impl.Log4jMDCAdapter
	[WARNING]   - org.slf4j.impl.Log4jLoggerAdapter
	[WARNING]   - org.slf4j.impl.StaticMDCBinder
	[WARNING] jna-3.2.7.jar, gatk-queue-package-distribution-3.5.jar define 16 overlappping classes: 
	[WARNING]   - com.sun.jna.win32.StdCallLibrary$StdCallCallback
	[WARNING]   - com.sun.jna.win32.W32APIOptions$1
	[WARNING]   - com.sun.jna.win32.W32APIFunctionMapper
	[WARNING]   - com.sun.jna.win32.StdCall
	[WARNING]   - com.sun.jna.DefaultTypeMapper
	[WARNING]   - com.sun.jna.win32.W32APITypeMapper
	[WARNING]   - com.sun.jna.DefaultTypeMapper$Entry
	[WARNING]   - com.sun.jna.win32.StdCallLibrary
	[WARNING]   - com.sun.jna.ptr.ShortByReference
	[WARNING]   - com.sun.jna.win32.W32APITypeMapper$2
	[WARNING]   - 6 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, guava-18.0.jar, gatk-package-distribution-3.5.jar define 477 overlappping classes: 
	[WARNING]   - com.google.common.collect.MapMakerInternalMap$SoftEvictableEntry
	[WARNING]   - com.google.common.collect.Iterators$12
	[WARNING]   - com.google.common.base.Predicates$InstanceOfPredicate
	[WARNING]   - com.google.common.collect.ImmutableMultiset$1
	[WARNING]   - com.google.common.collect.MapMaker$RemovalCause$4
	[WARNING]   - com.google.common.collect.MapMakerInternalMap$WeakValueReference
	[WARNING]   - com.google.common.collect.Maps$TransformedEntriesSortedMap
	[WARNING]   - com.google.common.base.Predicates$AndPredicate
	[WARNING]   - com.google.common.collect.Multimaps$Keys$KeysEntrySet
	[WARNING]   - com.google.common.collect.ImmutableSortedSet$Builder
	[WARNING]   - 467 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, mail-1.4.4.jar define 286 overlappping classes: 
	[WARNING]   - javax.mail.internet.ContentDisposition
	[WARNING]   - com.sun.mail.pop3.Protocol
	[WARNING]   - com.sun.mail.iap.Response
	[WARNING]   - com.sun.mail.smtp.DigestMD5
	[WARNING]   - javax.mail.internet.MimePart
	[WARNING]   - com.sun.mail.imap.IMAPMessage
	[WARNING]   - javax.mail.Message
	[WARNING]   - com.sun.mail.imap.Rights
	[WARNING]   - com.sun.mail.util.SocketFetcher
	[WARNING]   - com.sun.mail.pop3.POP3Store
	[WARNING]   - 276 more...
	[WARNING] stax-api-1.0.1.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 24 overlappping classes: 
	[WARNING]   - javax.xml.stream.FactoryFinder
	[WARNING]   - javax.xml.stream.events.StartElement
	[WARNING]   - javax.xml.stream.Location
	[WARNING]   - javax.xml.stream.EventFilter
	[WARNING]   - javax.xml.stream.XMLInputFactory
	[WARNING]   - javax.xml.stream.XMLEventReader
	[WARNING]   - javax.xml.stream.events.Attribute
	[WARNING]   - javax.xml.stream.events.Characters
	[WARNING]   - javax.xml.stream.XMLStreamException
	[WARNING]   - javax.xml.stream.XMLStreamReader
	[WARNING]   - 14 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, picard-1.141.jar define 574 overlappping classes: 
	[WARNING]   - picard.illumina.parser.BarcodeParser$BarcodeDataIterator$1
	[WARNING]   - picard.illumina.parser.readers.BclQualityEvaluationStrategy$1
	[WARNING]   - picard.illumina.parser.PerTileCycleParser
	[WARNING]   - picard.sam.SamToFastq$FastqWriters$1
	[WARNING]   - picard.illumina.IlluminaBasecallsConverter
	[WARNING]   - picard.analysis.CountingFilter
	[WARNING]   - picard.analysis.InsertSizeMetrics
	[WARNING]   - picard.illumina.quality.CollectHiSeqXPfFailMetrics$ReadClassifier
	[WARNING]   - picard.analysis.AlignmentSummaryMetrics$Category
	[WARNING]   - picard.illumina.parser.PosParser$2
	[WARNING]   - 564 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, commons-collections-3.2.1.jar, gatk-package-distribution-3.5.jar define 37 overlappping classes: 
	[WARNING]   - org.apache.commons.collections.list.TransformedList$TransformedListIterator
	[WARNING]   - org.apache.commons.collections.collection.TypedCollection
	[WARNING]   - org.apache.commons.collections.collection.UnmodifiableCollection
	[WARNING]   - org.apache.commons.collections.collection.UnmodifiableBoundedCollection
	[WARNING]   - org.apache.commons.collections.list.UnmodifiableList
	[WARNING]   - org.apache.commons.collections.BoundedCollection
	[WARNING]   - org.apache.commons.collections.iterators.AbstractEmptyIterator
	[WARNING]   - org.apache.commons.collections.iterators.UnmodifiableListIterator
	[WARNING]   - org.apache.commons.collections.collection.SynchronizedCollection
	[WARNING]   - org.apache.commons.collections.Factory
	[WARNING]   - 27 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, freemarker-2.3.18.jar, gatk-package-distribution-3.5.jar define 24 overlappping classes: 
	[WARNING]   - freemarker.core.DateBuiltins$iso_BI$Result
	[WARNING]   - freemarker.core.TemplateClassResolver$4
	[WARNING]   - freemarker.core.TemplateClassResolver
	[WARNING]   - freemarker.core.TemplateClassResolver$2
	[WARNING]   - freemarker.core.DateBuiltins
	[WARNING]   - freemarker.core.TemplateClassResolver$1
	[WARNING]   - freemarker.core.DateBuiltins$iso_BI
	[WARNING]   - freemarker.ext.beans.BeansWrapper$MethodAppearanceDecision
	[WARNING]   - freemarker.core.TemplateClassResolver$3
	[WARNING]   - freemarker.template.utility.DateUtil
	[WARNING]   - 14 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, ant-1.8.2.jar, gatk-package-distribution-3.5.jar define 4 overlappping classes: 
	[WARNING]   - org.apache.tools.bzip2.CBZip2InputStream$Data
	[WARNING]   - org.apache.tools.bzip2.CBZip2InputStream
	[WARNING]   - org.apache.tools.bzip2.CRC
	[WARNING]   - org.apache.tools.bzip2.BZip2Constants
	[WARNING] servlet-api-2.5.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 11 overlappping classes: 
	[WARNING]   - javax.servlet.ServletInputStream
	[WARNING]   - javax.servlet.ServletConfig
	[WARNING]   - javax.servlet.RequestDispatcher
	[WARNING]   - javax.servlet.ServletRequest
	[WARNING]   - javax.servlet.ServletResponse
	[WARNING]   - javax.servlet.ServletException
	[WARNING]   - javax.servlet.ServletContext
	[WARNING]   - javax.servlet.ServletContextListener
	[WARNING]   - javax.servlet.ServletOutputStream
	[WARNING]   - javax.servlet.Servlet
	[WARNING]   - 1 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, colt-1.2.0.jar, gatk-package-distribution-3.5.jar define 15 overlappping classes: 
	[WARNING]   - cern.jet.math.Constants
	[WARNING]   - cern.jet.random.Normal
	[WARNING]   - cern.jet.stat.Gamma
	[WARNING]   - cern.colt.function.DoubleFunction
	[WARNING]   - cern.jet.random.AbstractContinousDistribution
	[WARNING]   - cern.colt.function.IntFunction
	[WARNING]   - cern.jet.random.engine.MersenneTwister
	[WARNING]   - cern.colt.PersistentObject
	[WARNING]   - cern.jet.math.Arithmetic
	[WARNING]   - cern.jet.stat.Probability
	[WARNING]   - 5 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, xz-1.5.jar, gatk-package-distribution-3.5.jar define 84 overlappping classes: 
	[WARNING]   - org.tukaani.xz.lzma.Optimum
	[WARNING]   - org.tukaani.xz.index.IndexBase
	[WARNING]   - org.tukaani.xz.lzma.LZMAEncoderNormal
	[WARNING]   - org.tukaani.xz.delta.DeltaDecoder
	[WARNING]   - org.tukaani.xz.DeltaCoder
	[WARNING]   - org.tukaani.xz.simple.SPARC
	[WARNING]   - org.tukaani.xz.LZMA2Coder
	[WARNING]   - org.tukaani.xz.common.DecoderUtil
	[WARNING]   - org.tukaani.xz.XZOutputStream
	[WARNING]   - org.tukaani.xz.UnsupportedOptionsException
	[WARNING]   - 74 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, commons-httpclient-3.1.jar, gatk-package-distribution-3.5.jar define 167 overlappping classes: 
	[WARNING]   - org.apache.commons.httpclient.util.URIUtil$Coder
	[WARNING]   - org.apache.commons.httpclient.HttpMethodDirector
	[WARNING]   - org.apache.commons.httpclient.cookie.CookiePolicy
	[WARNING]   - org.apache.commons.httpclient.MethodRetryHandler
	[WARNING]   - org.apache.commons.httpclient.auth.NTLMScheme
	[WARNING]   - org.apache.commons.httpclient.auth.AuthChallengeParser
	[WARNING]   - org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource
	[WARNING]   - org.apache.commons.httpclient.cookie.RFC2965Spec$CookieCommentUrlAttributeHandler
	[WARNING]   - org.apache.commons.httpclient.auth.AuthScope
	[WARNING]   - org.apache.commons.httpclient.HttpClientError
	[WARNING]   - 157 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, httpcore-4.1.jar, gatk-package-distribution-3.5.jar define 121 overlappping classes: 
	[WARNING]   - org.apache.http.ConnectionReuseStrategy
	[WARNING]   - org.apache.http.params.AbstractHttpParams
	[WARNING]   - org.apache.http.util.VersionInfo
	[WARNING]   - org.apache.http.MalformedChunkCodingException
	[WARNING]   - org.apache.http.HttpClientConnection
	[WARNING]   - org.apache.http.params.BasicHttpParams
	[WARNING]   - org.apache.http.impl.io.AbstractSessionOutputBuffer
	[WARNING]   - org.apache.http.impl.io.ContentLengthInputStream
	[WARNING]   - org.apache.http.impl.AbstractHttpClientConnection
	[WARNING]   - org.apache.http.protocol.HttpResponseInterceptorList
	[WARNING]   - 111 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-queue-extensions-distribution-3.5.jar define 405 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.DocumentationTest$$anonfun$2
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.RealignerTargetCreator$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.GATKScatterFunction$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.VariantEval
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.Sample$class
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.ASEReadCounter$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.MergeVCFs
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.UnifiedGenotyper$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.RodSystemValidation$$anonfun$freezeFieldValues$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.PrepareTargets
	[WARNING]   - 395 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, xml-apis-1.0.b2.jar, gatk-package-distribution-3.5.jar define 68 overlappping classes: 
	[WARNING]   - javax.xml.parsers.FactoryConfigurationError
	[WARNING]   - javax.xml.parsers.SAXParserFactory
	[WARNING]   - javax.xml.parsers.SAXParser
	[WARNING]   - org.w3c.dom.Document
	[WARNING]   - javax.xml.transform.TransformerException
	[WARNING]   - javax.xml.transform.SourceLocator
	[WARNING]   - org.w3c.dom.Node
	[WARNING]   - org.xml.sax.helpers.AttributesImpl
	[WARNING]   - org.xml.sax.DTDHandler
	[WARNING]   - javax.xml.transform.TransformerConfigurationException
	[WARNING]   - 58 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 183 overlappping classes: 
	[WARNING]   - com.google.common.collect.Multisets$SetMultiset$ElementSet
	[WARNING]   - com.google.common.collect.Multimaps$FilteredMultimap$AsMap$Values$2
	[WARNING]   - com.google.common.collect.SortedIterables$2
	[WARNING]   - com.google.common.collect.ImmutableMultimap$Values$1
	[WARNING]   - com.google.common.collect.Maps$AbstractFilteredMap$Values$1
	[WARNING]   - com.google.common.collect.Sets$PowerSet$BitFilteredSetIterator
	[WARNING]   - com.google.common.collect.BstRangeOps$1
	[WARNING]   - com.google.common.collect.RegularImmutableMultiset$1
	[WARNING]   - com.google.common.collect.Multimaps$UnmodifiableAsMapValues
	[WARNING]   - com.google.common.collect.Multimaps$FilteredMultimap$AsMap$Values
	[WARNING]   - 173 more...
	[WARNING] gov.nist.math.jama-1.1.1.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, jama-1.0.2.jar define 7 overlappping classes: 
	[WARNING]   - Jama.SingularValueDecomposition
	[WARNING]   - Jama.EigenvalueDecomposition
	[WARNING]   - Jama.CholeskyDecomposition
	[WARNING]   - Jama.util.Maths
	[WARNING]   - Jama.Matrix
	[WARNING]   - Jama.LUDecomposition
	[WARNING]   - Jama.QRDecomposition
	[WARNING] gatk-queue-package-distribution-3.5.jar, commons-compress-1.4.1.jar, gatk-package-distribution-3.5.jar define 10 overlappping classes: 
	[WARNING]   - org.apache.commons.compress.compressors.xz.XZCompressorInputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream$Data
	[WARNING]   - org.apache.commons.compress.utils.CountingOutputStream
	[WARNING]   - org.apache.commons.compress.compressors.xz.XZCompressorOutputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.BZip2Constants
	[WARNING]   - org.apache.commons.compress.compressors.CompressorOutputStream
	[WARNING]   - org.apache.commons.compress.compressors.CompressorInputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.CRC
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.Rand
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, java-xmlbuilder-0.4.jar define 4 overlappping classes: 
	[WARNING]   - net.iharder.base64.Base64$OutputStream
	[WARNING]   - net.iharder.base64.Base64
	[WARNING]   - net.iharder.base64.Base64$InputStream
	[WARNING]   - com.jamesmurty.utils.XMLBuilder
	[WARNING] gatk-queue-package-distribution-3.5.jar, fastutil-6.5.3.jar, gatk-package-distribution-3.5.jar define 124 overlappping classes: 
	[WARNING]   - it.unimi.dsi.fastutil.ints.AbstractIntList$1
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectIterators$UnmodifiableIterator
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2IntMap
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectArrayList$1
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap$KeyIterator
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap$MapEntry
	[WARNING]   - it.unimi.dsi.fastutil.Arrays
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectIterators
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2ObjectMap$FastEntrySet
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
	[WARNING]   - 114 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, freemarker-2.3.18.jar, gatk-package-distribution-3.5.jar, snpeff-2.0.5.jar define 457 overlappping classes: 
	[WARNING]   - freemarker.ext.jython.JythonWrapper
	[WARNING]   - freemarker.ext.dom.CharacterDataNodeModel
	[WARNING]   - freemarker.template.SimpleCollection$SimpleTemplateModelIterator
	[WARNING]   - freemarker.debug.impl.DebuggerService
	[WARNING]   - freemarker.core.CollectionAndSequence$SequenceIterator
	[WARNING]   - freemarker.template.EmptyMap
	[WARNING]   - freemarker.ext.beans.CollectionAdapter$1
	[WARNING]   - freemarker.debug.impl.DebuggerService$NoOpDebuggerService
	[WARNING]   - freemarker.core.FMParserTokenManager
	[WARNING]   - freemarker.core.NumericalBuiltins$longBI
	[WARNING]   - 447 more...
	[WARNING] commons-logging-1.1.1.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 28 overlappping classes: 
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$2
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl
	[WARNING]   - org.apache.commons.logging.impl.WeakHashtable$1
	[WARNING]   - org.apache.commons.logging.LogFactory$3
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$3
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$1
	[WARNING]   - org.apache.commons.logging.LogFactory$6
	[WARNING]   - org.apache.commons.logging.impl.WeakHashtable
	[WARNING]   - org.apache.commons.logging.LogConfigurationException
	[WARNING]   - org.apache.commons.logging.impl.AvalonLogger
	[WARNING]   - 18 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, picard-1.141.jar, gatk-package-distribution-3.5.jar define 16 overlappping classes: 
	[WARNING]   - picard.cmdline.CommandLineParseException
	[WARNING]   - picard.cmdline.CommandLineParser$ChildOptionArg
	[WARNING]   - picard.cmdline.NestedOptions
	[WARNING]   - picard.cmdline.CommandLineParserDefinitionException
	[WARNING]   - picard.cmdline.programgroups.None
	[WARNING]   - picard.cmdline.Option
	[WARNING]   - picard.cmdline.PositionalArguments
	[WARNING]   - picard.cmdline.CommandLineProgramProperties
	[WARNING]   - picard.cmdline.CommandLineProgram
	[WARNING]   - picard.cmdline.CommandLineProgramGroup
	[WARNING]   - 6 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, jets3t-0.8.1.jar define 157 overlappping classes: 
	[WARNING]   - org.jets3t.service.multi.event.ServiceEvent
	[WARNING]   - org.jets3t.service.impl.rest.XmlResponsesSaxParser$ListBucketHandler
	[WARNING]   - org.jets3t.service.io.OutputStreamWrapper
	[WARNING]   - org.jets3t.service.multi.ThreadedStorageService$3
	[WARNING]   - org.jets3t.service.io.RepeatableFileInputStream
	[WARNING]   - org.jets3t.service.model.BaseVersionOrDeleteMarker
	[WARNING]   - org.jets3t.service.impl.rest.XmlResponsesSaxParser$ListMultipartUploadsResultHandler
	[WARNING]   - org.jets3t.service.utils.MultipartUtils
	[WARNING]   - org.jets3t.service.multi.ThreadedStorageService$AbstractRunnable
	[WARNING]   - org.jets3t.service.utils.RestUtils$1
	[WARNING]   - 147 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, reflections-0.9.9-RC1.jar define 82 overlappping classes: 
	[WARNING]   - org.reflections.vfs.SystemFile
	[WARNING]   - org.reflections.vfs.Vfs$DefaultUrlTypes
	[WARNING]   - org.reflections.vfs.Vfs$DefaultUrlTypes$3
	[WARNING]   - org.reflections.vfs.Vfs$DefaultUrlTypes$2
	[WARNING]   - org.reflections.util.FilterBuilder$Exclude
	[WARNING]   - org.reflections.vfs.ZipDir$1
	[WARNING]   - org.reflections.vfs.JarInputDir$1$1
	[WARNING]   - org.reflections.ReflectionUtils$2
	[WARNING]   - org.reflections.Store
	[WARNING]   - org.reflections.ReflectionUtils$5
	[WARNING]   - 72 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, log4j-1.2.15.jar define 72 overlappping classes: 
	[WARNING]   - org.apache.log4j.or.ObjectRenderer
	[WARNING]   - org.apache.log4j.helpers.AbsoluteTimeDateFormat
	[WARNING]   - org.apache.log4j.helpers.FileWatchdog
	[WARNING]   - org.apache.log4j.Priority
	[WARNING]   - org.apache.log4j.WriterAppender
	[WARNING]   - org.apache.log4j.helpers.PatternParser$NamedPatternConverter
	[WARNING]   - org.apache.log4j.spi.NOPLogger
	[WARNING]   - org.apache.log4j.NDC$DiagnosticContext
	[WARNING]   - org.apache.log4j.spi.ErrorHandler
	[WARNING]   - org.apache.log4j.spi.AppenderAttachable
	[WARNING]   - 62 more...
	[WARNING] gatk-tools-public-3.5.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 228 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ConcordanceMetrics$SiteConcordanceType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$7
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.MultiallelicSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.VariantSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AnnotationInterfaceManager
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.readutils.ClipReads
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$1
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ValidateVariants$ValidationType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.SnpEffUtil
	[WARNING]   - 218 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, jsr305-1.3.9.jar define 11 overlappping classes: 
	[WARNING]   - javax.annotation.meta.When
	[WARNING]   - javax.annotation.concurrent.Immutable
	[WARNING]   - javax.annotation.CheckForNull
	[WARNING]   - javax.annotation.meta.TypeQualifierValidator
	[WARNING]   - javax.annotation.Nonnull
	[WARNING]   - javax.annotation.Nullable
	[WARNING]   - javax.annotation.meta.TypeQualifier
	[WARNING]   - javax.annotation.concurrent.GuardedBy
	[WARNING]   - javax.annotation.Nonnull$Checker
	[WARNING]   - javax.annotation.CheckReturnValue
	[WARNING]   - 1 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, slf4j-api-1.6.1.jar define 19 overlappping classes: 
	[WARNING]   - org.slf4j.spi.MarkerFactoryBinder
	[WARNING]   - org.slf4j.helpers.BasicMarker
	[WARNING]   - org.slf4j.helpers.Util
	[WARNING]   - org.slf4j.LoggerFactory
	[WARNING]   - org.slf4j.Marker
	[WARNING]   - org.slf4j.helpers.NamedLoggerBase
	[WARNING]   - org.slf4j.Logger
	[WARNING]   - org.slf4j.spi.LocationAwareLogger
	[WARNING]   - org.slf4j.ILoggerFactory
	[WARNING]   - org.slf4j.helpers.BasicMarkerFactory
	[WARNING]   - 9 more...
	[WARNING] scala-library-2.10.2.jar, gatk-queue-package-distribution-3.5.jar define 4894 overlappping classes: 
	[WARNING]   - scala.Function2$mcIJI$sp$class
	[WARNING]   - scala.xml.parsing.TokenTests
	[WARNING]   - scala.runtime.NonLocalReturnControl$mcF$sp
	[WARNING]   - scala.runtime.RichFloat
	[WARNING]   - scala.collection.mutable.ArrayBuilder$ofLong
	[WARNING]   - scala.util.parsing.combinator.Parsers$$anonfun$elem$1
	[WARNING]   - scala.concurrent.impl.Promise$KeptPromise
	[WARNING]   - scala.collection.IterableViewLike$$anonfun$sliding$1$$anonfun$apply$2
	[WARNING]   - scala.collection.parallel.ParIterableLike$Composite
	[WARNING]   - scala.concurrent.duration.package$span$
	[WARNING]   - 4884 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, htsjdk-1.141.jar, gatk-package-distribution-3.5.jar define 913 overlappping classes: 
	[WARNING]   - htsjdk.samtools.Bin
	[WARNING]   - htsjdk.samtools.util.ftp.FTPStream
	[WARNING]   - htsjdk.tribble.example.ProfileIndexReading
	[WARNING]   - htsjdk.samtools.cram.encoding.writer.Writer
	[WARNING]   - htsjdk.samtools.util.CoordMath
	[WARNING]   - htsjdk.samtools.cram.encoding.ByteArrayStopEncoding$ByteArrayStopCodec
	[WARNING]   - htsjdk.samtools.CoordinateSortedPairInfoMap$1
	[WARNING]   - htsjdk.samtools.util.Tuple
	[WARNING]   - htsjdk.samtools.cram.encoding.writer.DataWriter
	[WARNING]   - htsjdk.samtools.cram.encoding.huffman.codec.HuffmanIntHelper$1
	[WARNING]   - 903 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, httpclient-4.1.1.jar, gatk-package-distribution-3.5.jar define 206 overlappping classes: 
	[WARNING]   - org.apache.http.conn.routing.RouteInfo$TunnelType
	[WARNING]   - org.apache.http.client.methods.HttpUriRequest
	[WARNING]   - org.apache.http.impl.client.RedirectLocations
	[WARNING]   - org.apache.http.conn.scheme.SchemeSocketFactoryAdaptor
	[WARNING]   - org.apache.http.impl.cookie.BrowserCompatSpecFactory
	[WARNING]   - org.apache.http.conn.ssl.AbstractVerifier
	[WARNING]   - org.apache.http.client.protocol.RequestDefaultHeaders
	[WARNING]   - org.apache.http.impl.cookie.RFC2965SpecFactory
	[WARNING]   - org.apache.http.annotation.ThreadSafe
	[WARNING]   - org.apache.http.client.methods.HttpRequestBase
	[WARNING]   - 196 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, cofoja-1.2-20140817.jar, gatk-package-distribution-3.5.jar define 144 overlappping classes: 
	[WARNING]   - com.google.java.contract.util.Iterables
	[WARNING]   - com.google.java.contract.core.apt.MethodContractCreator$PostMethodCreationTrait
	[WARNING]   - com.google.java.contract.core.apt.SourcePreprocessor
	[WARNING]   - com.google.java.contract.core.util.JavaTokenizer
	[WARNING]   - com.google.java.contract.core.apt.AnnotationProcessor$1
	[WARNING]   - com.google.java.contract.core.util.JavaTokenizer$TokenKind
	[WARNING]   - com.google.java.contract.core.util.SyntheticJavaFile
	[WARNING]   - com.google.java.contract.core.apt.MethodContractCreator
	[WARNING]   - com.google.java.contract.ContractImport
	[WARNING]   - com.google.java.contract.util.Predicates$11
	[WARNING]   - 134 more...
	[WARNING] gatk-queue-3.5.jar, gatk-queue-package-distribution-3.5.jar define 405 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.queue.library.ipf.SortByRef$$anonfun$contigVal$2
	[WARNING]   - org.broadinstitute.gatk.queue.engine.CommandLineJobRunner$$anonfun$init$1
	[WARNING]   - org.broadinstitute.gatk.queue.library.clf.vcf.VCFExtractIntervals
	[WARNING]   - org.broadinstitute.gatk.queue.engine.QGraph$$anonfun$addFailedFunctions$2
	[WARNING]   - org.broadinstitute.gatk.queue.engine.QGraph$$anonfun$getReadyJobs$1
	[WARNING]   - org.broadinstitute.gatk.queue.QCommandLine$$anonfun$execute$8$$anonfun$5
	[WARNING]   - org.broadinstitute.gatk.queue.engine.CommandLineJobManager$class
	[WARNING]   - org.broadinstitute.gatk.queue.engine.lsf.Lsf706JobRunner$$anonfun$tryStop$2
	[WARNING]   - org.broadinstitute.gatk.queue.engine.QGraph$$anonfun$logFailed$1
	[WARNING]   - org.broadinstitute.gatk.queue.function.RetryMemoryLimit$$anonfun$isMemoryError$1
	[WARNING]   - 395 more...
	[WARNING] gatk-utils-3.5.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 1208 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.utils.help.GATKDocWorkUnit
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibLsf$lsSharedResourceInfo$ByReference
	[WARNING]   - org.broadinstitute.gatk.utils.variant.GATKVariantContextUtils$AlleleMapper
	[WARNING]   - org.broadinstitute.gatk.utils.downsampling.SimplePositionalDownsamplerFactory
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$jgrpCtrl$ByReference
	[WARNING]   - org.broadinstitute.gatk.utils.R.RUtils
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$_limitConsumer$ByValue
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$addRsvRequest$ByValue
	[WARNING]   - org.broadinstitute.gatk.utils.codecs.refseq.RefSeqFeature
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$hostPartInfoEnt
	[WARNING]   - 1198 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, simple-xml-2.0.4.jar, gatk-package-distribution-3.5.jar define 187 overlappping classes: 
	[WARNING]   - org.simpleframework.xml.stream.OutputStack
	[WARNING]   - org.simpleframework.xml.transform.BigIntegerTransform
	[WARNING]   - org.simpleframework.xml.transform.PackageMatcher
	[WARNING]   - org.simpleframework.xml.stream.OutputNodeMap
	[WARNING]   - org.simpleframework.xml.core.GetPart
	[WARNING]   - org.simpleframework.xml.core.CompositeValue
	[WARNING]   - org.simpleframework.xml.stream.Formatter
	[WARNING]   - org.simpleframework.xml.core.Contact
	[WARNING]   - org.simpleframework.xml.transform.DoubleTransform
	[WARNING]   - org.simpleframework.xml.Namespace
	[WARNING]   - 177 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, drmaa-common-1.0.jar define 33 overlappping classes: 
	[WARNING]   - org.ggf.drmaa.DrmsInitException
	[WARNING]   - org.ggf.drmaa.InvalidAttributeFormatException
	[WARNING]   - org.ggf.drmaa.ReleaseInconsistentStateException
	[WARNING]   - org.ggf.drmaa.TryLaterException
	[WARNING]   - org.ggf.drmaa.SessionFactory$NewFactoryAction
	[WARNING]   - org.ggf.drmaa.AlreadyActiveSessionException
	[WARNING]   - org.ggf.drmaa.JobInfo
	[WARNING]   - org.ggf.drmaa.FileTransferMode
	[WARNING]   - org.ggf.drmaa.ResumeInconsistentStateException
	[WARNING]   - org.ggf.drmaa.InvalidContactStringException
	[WARNING]   - 23 more...
	[WARNING] javassist-3.16.1-GA.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 285 overlappping classes: 
	[WARNING]   - javassist.bytecode.CodeIterator$Jump32
	[WARNING]   - javassist.CtMember$Cache
	[WARNING]   - javassist.bytecode.LineNumberAttribute
	[WARNING]   - javassist.expr.NewArray
	[WARNING]   - javassist.bytecode.SignatureAttribute$1
	[WARNING]   - javassist.bytecode.SignatureAttribute$BaseType
	[WARNING]   - javassist.CtField$LongInitializer
	[WARNING]   - javassist.compiler.ast.BinExpr
	[WARNING]   - javassist.bytecode.StackMap$Writer
	[WARNING]   - javassist.CodeConverter$DefaultArrayAccessReplacementMethodNames
	[WARNING]   - 275 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar, snappy-java-1.0.3-rc3.jar define 11 overlappping classes: 
	[WARNING]   - org.xerial.snappy.OSInfo
	[WARNING]   - org.xerial.snappy.SnappyOutputStream
	[WARNING]   - org.xerial.snappy.SnappyInputStream
	[WARNING]   - org.xerial.snappy.SnappyErrorCode
	[WARNING]   - org.xerial.snappy.SnappyCodec
	[WARNING]   - org.xerial.snappy.SnappyException
	[WARNING]   - org.xerial.snappy.SnappyNative
	[WARNING]   - org.xerial.snappy.Snappy
	[WARNING]   - org.xerial.snappy.LoadSnappy
	[WARNING]   - org.xerial.snappy.SnappyError
	[WARNING]   - 1 more...
	[WARNING] jna-3.2.7.jar, gatk-queue-package-distribution-3.5.jar, gatk-package-distribution-3.5.jar define 79 overlappping classes: 
	[WARNING]   - com.sun.jna.NativeLong
	[WARNING]   - com.sun.jna.Structure$FFIType$size_t
	[WARNING]   - com.sun.jna.Structure$StructField
	[WARNING]   - com.sun.jna.InvocationMapper
	[WARNING]   - com.sun.jna.StructureWriteContext
	[WARNING]   - com.sun.jna.Callback$UncaughtExceptionHandler
	[WARNING]   - com.sun.jna.StringArray
	[WARNING]   - com.sun.jna.ptr.LongByReference
	[WARNING]   - com.sun.jna.Callback
	[WARNING]   - com.sun.jna.TypeMapper
	[WARNING]   - 69 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, commons-math-2.2.jar, gatk-package-distribution-3.5.jar define 247 overlappping classes: 
	[WARNING]   - org.apache.commons.math.stat.descriptive.moment.Kurtosis
	[WARNING]   - org.apache.commons.math.MathRuntimeException$6
	[WARNING]   - org.apache.commons.math.distribution.GammaDistribution
	[WARNING]   - org.apache.commons.math.distribution.ExponentialDistributionImpl
	[WARNING]   - org.apache.commons.math.linear.FieldVector
	[WARNING]   - org.apache.commons.math.exception.DimensionMismatchException
	[WARNING]   - org.apache.commons.math.linear.AbstractRealMatrix$4
	[WARNING]   - org.apache.commons.math.analysis.ComposableFunction$2
	[WARNING]   - org.apache.commons.math.fraction.FractionField$LazyHolder
	[WARNING]   - org.apache.commons.math.special.Beta
	[WARNING]   - 237 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gson-2.2.2.jar, gatk-package-distribution-3.5.jar define 153 overlappping classes: 
	[WARNING]   - com.google.gson.internal.bind.TypeAdapters$27
	[WARNING]   - com.google.gson.internal.bind.TypeAdapters$10
	[WARNING]   - com.google.gson.TreeTypeAdapter
	[WARNING]   - com.google.gson.internal.bind.TypeAdapters$15
	[WARNING]   - com.google.gson.JsonIOException
	[WARNING]   - com.google.gson.internal.StringMap
	[WARNING]   - com.google.gson.internal.StringMap$LinkedHashIterator
	[WARNING]   - com.google.gson.annotations.Until
	[WARNING]   - com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper
	[WARNING]   - com.google.gson.stream.JsonReader$2
	[WARNING]   - 143 more...
	[WARNING] maven-shade-plugin has detected that some .class files
	[WARNING] are present in two or more JARs. When this happens, only
	[WARNING] one single version of the class is copied in the uberjar.
	[WARNING] Usually this is not harmful and you can skeep these
	[WARNING] warnings, otherwise try to manually exclude artifacts
	[WARNING] based on mvn dependency:tree -Ddetail=true and the above
	[WARNING] output
	[WARNING] See http://docs.codehaus.org/display/MAVENUSER/Shade+Plugin
	[INFO] Minimized 75339 -> 58916 (78%)
	[INFO] Replacing original artifact with shaded artifact.
	[INFO] Replacing /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5.jar with /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5-shaded.jar
	[INFO] 
	[INFO] --- maven-assembly-plugin:2.4:single (binary-dist) @ gatk-queue-package-distribution ---
	[INFO] Reading assembly descriptor: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/src/main/assembly/binary-dist.xml
	[WARNING] Invalid POM for com.google.code.cofoja:cofoja:jar:1.2-20140817, transitive dependencies (if any) will not be available, enable debug logging for more details
	[INFO] Building tar: /home/hadoop/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5-binary-dist.tar.bz2
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-executable-jar) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-package-jar) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-git-release) @ gatk-queue-package-distribution ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building GATK Aggregator Protected 3.5
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ gatk-aggregator-protected ---
	[INFO] 
	[INFO] --- gitdescribe-maven-plugin:2.0:gitdescribe (gitdescribe-initialize) @ gatk-aggregator-protected ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:regex-property (fix-version-initialize) @ gatk-aggregator-protected ---
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO] 
	[INFO] GATK Root .......................................... SUCCESS [  0.590 s]
	[INFO] GATK Aggregator .................................... SUCCESS [  0.502 s]
	[INFO] GATK GSALib ........................................ SUCCESS [  0.863 s]
	[INFO] GATK Utils ......................................... SUCCESS [ 32.395 s]
	[INFO] GATK Engine ........................................ SUCCESS [  9.264 s]
	[INFO] GATK Tools Public .................................. SUCCESS [ 23.222 s]
	[INFO] External Example ................................... SUCCESS [ 12.317 s]
	[INFO] GATK Queue ......................................... SUCCESS [11:32 min]
	[INFO] GATK Queue Extensions Generator .................... SUCCESS [  0.128 s]
	[INFO] GATK Queue Extensions Public ....................... SUCCESS [02:07 min]
	[INFO] GATK Aggregator Public ............................. SUCCESS [  0.003 s]
	[INFO] GATK Tools Protected ............................... SUCCESS [ 32.863 s]
	[INFO] GATK Package Distribution .......................... SUCCESS [01:08 min]
	[INFO] GATK Queue Extensions Distribution ................. SUCCESS [01:34 min]
	[INFO] GATK Queue Package Distribution .................... SUCCESS [02:37 min]
	[INFO] GATK Aggregator Protected .......................... SUCCESS [  0.005 s]
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 20:52 min
	[INFO] Finished at: 2016-06-07T20:46:21+08:00
	[INFO] Final Memory: 73M/988M
	[INFO] ------------------------------------------------------------------------

（2）xubo：

	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.MultiallelicSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.VariantSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AnnotationInterfaceManager
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.readutils.ClipReads
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$1
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ValidateVariants$ValidationType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.SnpEffUtil
	[WARNING]   - 218 more...
	[WARNING] gatk-package-distribution-3.5.jar, slf4j-log4j12-1.7.5.jar define 6 overlappping classes: 
	[WARNING]   - org.slf4j.impl.StaticMarkerBinder
	[WARNING]   - org.slf4j.impl.Log4jLoggerFactory
	[WARNING]   - org.slf4j.impl.StaticLoggerBinder
	[WARNING]   - org.slf4j.impl.Log4jMDCAdapter
	[WARNING]   - org.slf4j.impl.Log4jLoggerAdapter
	[WARNING]   - org.slf4j.impl.StaticMDCBinder
	[WARNING] htsjdk-1.141.jar, gatk-package-distribution-3.5.jar define 913 overlappping classes: 
	[WARNING]   - htsjdk.samtools.Bin
	[WARNING]   - htsjdk.samtools.util.ftp.FTPStream
	[WARNING]   - htsjdk.tribble.example.ProfileIndexReading
	[WARNING]   - htsjdk.samtools.cram.encoding.writer.Writer
	[WARNING]   - htsjdk.samtools.util.CoordMath
	[WARNING]   - htsjdk.samtools.cram.encoding.ByteArrayStopEncoding$ByteArrayStopCodec
	[WARNING]   - htsjdk.samtools.CoordinateSortedPairInfoMap$1
	[WARNING]   - htsjdk.samtools.util.Tuple
	[WARNING]   - htsjdk.samtools.cram.encoding.writer.DataWriter
	[WARNING]   - htsjdk.samtools.cram.encoding.huffman.codec.HuffmanIntHelper$1
	[WARNING]   - 903 more...
	[WARNING] maven-shade-plugin has detected that some .class files
	[WARNING] are present in two or more JARs. When this happens, only
	[WARNING] one single version of the class is copied in the uberjar.
	[WARNING] Usually this is not harmful and you can skeep these
	[WARNING] warnings, otherwise try to manually exclude artifacts
	[WARNING] based on mvn dependency:tree -Ddetail=true and the above
	[WARNING] output
	[WARNING] See http://docs.codehaus.org/display/MAVENUSER/Shade+Plugin
	[INFO] Minimized 28606 -> 11039 (38%)
	[INFO] Replacing original artifact with shaded artifact.
	[INFO] Replacing /home/xubo/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5.jar with /home/xubo/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5-shaded.jar
	[INFO] 
	[INFO] --- maven-assembly-plugin:2.4:single (binary-dist) @ gatk-package-distribution ---
	[INFO] Reading assembly descriptor: /home/xubo/xubo/tools/gatk-protected/protected/gatk-package-distribution/../../public/src/main/assembly/binary-dist.xml
	[INFO] Building tar: /home/xubo/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5-binary-dist.tar.bz2
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-executable-jar) @ gatk-package-distribution ---
	Downloading: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.pom (7 KB at 10.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0/maven-artifact-2.0.jar
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/1.0.4/plexus-utils-1.0.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/1.0.4/plexus-utils-1.0.4.jar (160 KB at 82.2 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-artifact/2.0/maven-artifact-2.0.jar (77 KB at 33.6 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/commons-io/commons-io/1.2/commons-io-1.2.jar (65 KB at 25.7 KB/sec)
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-package-jar) @ gatk-package-distribution ---
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-git-release) @ gatk-package-distribution ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building GATK Queue Extensions Distribution 3.5
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ gatk-queue-extensions-distribution ---
	[INFO] Deleting /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution (includes = [javadoc.sh, options, packages], excludes = [])
	[INFO] Deleting /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution (includes = [dependency-reduced-pom.xml], excludes = [])
	[INFO] 
	[INFO] --- gitdescribe-maven-plugin:2.0:gitdescribe (gitdescribe-initialize) @ gatk-queue-extensions-distribution ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:regex-property (fix-version-initialize) @ gatk-queue-extensions-distribution ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:add-source (add-gatk-extensions) @ gatk-queue-extensions-distribution ---
	[INFO] Source directory: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/../../public/gatk-queue-extensions-public/src/main/scala added.
	[INFO] Source directory: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/generated-sources/gatk-extensions added.
	[INFO] 
	[INFO] --- exec-maven-plugin:1.2.1:exec (generate-gatk-extensions) @ gatk-queue-extensions-distribution ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gatk-queue-extensions-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/src/main/resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (default) @ gatk-queue-extensions-distribution ---
	[INFO] Checking for multiple versions of scala
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] /home/xubo/xubo/tools/gatk-protected/public/gatk-queue-extensions-public/src/main/scala:-1: info: compiling
	[INFO] /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/generated-sources/gatk-extensions:-1: info: compiling
	[INFO] Compiling 148 source files to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/classes at 1465304334840
	[INFO] prepare-compile in 0 s
	[INFO] compile in 114 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-package-info) @ gatk-queue-extensions-distribution ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-java) @ gatk-queue-extensions-distribution ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gatk-queue-extensions-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/src/test/resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:testCompile (default) @ gatk-queue-extensions-distribution ---
	[INFO] Checking for multiple versions of scala
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/src/test/scala:-1: info: compiling
	[INFO] Compiling 2 source files to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/test-classes at 1465304449319
	[INFO] prepare-compile in 0 s
	[INFO] compile in 11 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (testCompile-java) @ gatk-queue-extensions-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.16:test (unit-tests) @ gatk-queue-extensions-distribution ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ gatk-queue-extensions-distribution ---
	[INFO] Building jar: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/gatk-queue-extensions-distribution-3.5.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (test-jar) @ gatk-queue-extensions-distribution ---
	[INFO] Building jar: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/gatk-queue-extensions-distribution-3.5-tests.jar
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building GATK Queue Package Distribution 3.5
	[INFO] ------------------------------------------------------------------------
	Downloading: file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom
	[WARNING] Could not validate integrity of download from file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom: Checksum validation failed, no checksums available
	[WARNING] Checksum validation failed, no checksums available for file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom
	Downloaded: file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.pom (363 B at 14.8 KB/sec)
	Downloading: file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar
	[WARNING] Could not validate integrity of download from file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar: Checksum validation failed, no checksums available
	[WARNING] Checksum validation failed, no checksums available for file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar
	Downloaded: file:/home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/repo/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar (4081 KB at 9027.5 KB/sec)
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ gatk-queue-package-distribution ---
	[INFO] Deleting /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution (includes = [javadoc.sh, options, packages], excludes = [])
	[INFO] Deleting /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution (includes = [dependency-reduced-pom.xml], excludes = [])
	[INFO] 
	[INFO] --- gitdescribe-maven-plugin:2.0:gitdescribe (gitdescribe-initialize) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:regex-property (fix-version-initialize) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gatk-queue-package-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/src/main/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-package-info) @ gatk-queue-package-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (compile-java) @ gatk-queue-package-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gatk-queue-package-distribution ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/src/test/resources
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (testCompile-java) @ gatk-queue-package-distribution ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.16:test (unit-tests) @ gatk-queue-package-distribution ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-dependency-plugin:2.8:unpack-dependencies (unpack-direct-dependencies) @ gatk-queue-package-distribution ---
	[INFO] Unpacking /home/xubo/.m2/repository/org/scala-lang/scala-compiler/2.10.2/scala-compiler-2.10.2.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/net/java/dev/jna/jna/3.2.7/jna-3.2.7.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/com/google/code/cofoja/cofoja/1.2-20140817/cofoja-1.2-20140817.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-extensions-distribution/target/gatk-queue-extensions-distribution-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/xubo/tools/gatk-protected/protected/gatk-package-distribution/target/gatk-package-distribution-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/com/github/broadinstitute/picard/1.141/picard-1.141.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/net/sf/snpeff/snpeff/2.0.5/snpeff-2.0.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/org/scala-lang/scala-library/2.10.2/scala-library-2.10.2.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/xubo/tools/gatk-protected/public/gatk-queue/target/gatk-queue-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] Unpacking /home/xubo/.m2/repository/javax/mail/mail/1.4.4/mail-1.4.4.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/classes with includes "" and excludes "GATKText.properties"
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (executable-jar) @ gatk-queue-package-distribution ---
	[WARNING] JAR will be empty - no content was marked for inclusion!
	[INFO] Building jar: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/Queue.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (unshaded-default-jar) @ gatk-queue-package-distribution ---
	[INFO] Building jar: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (test-jar) @ gatk-queue-package-distribution ---
	[INFO] Skipping packaging of the test-jar
	[INFO] 
	[INFO] --- maven-dependency-plugin:2.8:copy-dependencies (executable-jar-lib) @ gatk-queue-package-distribution ---
	[INFO] Copying scala-reflect-2.10.2.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/scala-reflect-2.10.2.jar
	[INFO] Copying gatk-queue-extensions-public-3.5-example-resources.tar.bz2 to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-extensions-public-3.5-example-resources.tar.bz2
	[INFO] Copying scala-compiler-2.10.2.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/scala-compiler-2.10.2.jar
	[INFO] Copying gatk-queue-extensions-distribution-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-extensions-distribution-3.5.jar
	[INFO] Copying guava-18.0.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/guava-18.0.jar
	[INFO] Copying gatk-package-distribution-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-package-distribution-3.5.jar
	[INFO] Copying gatk-queue-extensions-generator-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-extensions-generator-3.5.jar
	[INFO] Copying snpeff-2.0.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/snpeff-2.0.5.jar
	[INFO] Copying scala-library-2.10.2.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/scala-library-2.10.2.jar
	[INFO] Copying gatk-queue-3.5.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/gatk-queue-3.5.jar
	[INFO] Copying commons-email-1.2.jar to /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../target/executable/lib/commons-email-1.2.jar
	[INFO] httpcore-4.1.jar already exists in destination.
	[INFO] google-api-client-1.19.0.jar already exists in destination.
	[INFO] jcommander-1.27.jar already exists in destination.
	[INFO] stax-api-1.0.1.jar already exists in destination.
	[INFO] commons-logging-1.1.1.jar already exists in destination.
	[INFO] gatk-tools-java-1.1.jar already exists in destination.
	[INFO] concurrent-1.3.4.jar already exists in destination.
	[INFO] stax-1.2.0.jar already exists in destination.
	[INFO] ant-1.8.2.jar already exists in destination.
	[INFO] picard-1.141.jar already exists in destination.
	[INFO] gson-2.2.2.jar already exists in destination.
	[INFO] google-oauth-client-java6-1.19.0.jar already exists in destination.
	[INFO] jgrapht-0.8.3.jar already exists in destination.
	[INFO] commons-io-2.1.jar already exists in destination.
	[INFO] jetty-util-6.1.26.jar already exists in destination.
	[INFO] ant-launcher-1.8.2.jar already exists in destination.
	[INFO] commons-httpclient-3.1.jar already exists in destination.
	[INFO] xml-apis-1.0.b2.jar already exists in destination.
	[INFO] commons-codec-1.2.jar already exists in destination.
	[INFO] activation-1.1.jar already exists in destination.
	[INFO] simple-xml-2.0.4.jar already exists in destination.
	[INFO] commons-lang-2.5.jar already exists in destination.
	[INFO] drmaa-gridengine-6.2u5.jar already exists in destination.
	[INFO] reflections-0.9.9-RC1.jar already exists in destination.
	[INFO] htsjdk-1.141.jar already exists in destination.
	[INFO] jna-3.2.7.jar already exists in destination.
	[INFO] colt-1.2.0.jar already exists in destination.
	[INFO] httpclient-4.1.1.jar already exists in destination.
	[INFO] xz-1.5.jar already exists in destination.
	[INFO] google-api-client-java6-1.19.0.jar already exists in destination.
	[INFO] asm-all-5.0.4.jar already exists in destination.
	[INFO] jets3t-0.8.1.jar already exists in destination.
	[INFO] cofoja-1.2-20140817.jar already exists in destination.
	[INFO] google-oauth-client-1.19.0.jar already exists in destination.
	[INFO] google-oauth-client-jetty-1.19.0.jar already exists in destination.
	[INFO] jsr305-1.3.9.jar already exists in destination.
	[INFO] gatk-utils-3.5-example-resources.tar.bz2 already exists in destination.
	[INFO] gsalib-3.5.tar.gz already exists in destination.
	[INFO] gatk-utils-3.5.jar already exists in destination.
	[INFO] mail-1.4.4.jar already exists in destination.
	[INFO] commons-compress-1.4.1.jar already exists in destination.
	[INFO] snappy-java-1.0.3-rc3.jar already exists in destination.
	[INFO] javassist-3.16.1-GA.jar already exists in destination.
	[INFO] google-http-client-jackson2-1.19.0.jar already exists in destination.
	[INFO] servlet-api-2.5.jar already exists in destination.
	[INFO] fastutil-6.5.3.jar already exists in destination.
	[INFO] commons-collections-3.2.1.jar already exists in destination.
	[INFO] gatk-engine-3.5.jar already exists in destination.
	[INFO] freemarker-2.3.18.jar already exists in destination.
	[INFO] jama-1.0.2.jar already exists in destination.
	[INFO] commons-math-2.2.jar already exists in destination.
	[INFO] slf4j-log4j12-1.7.5.jar already exists in destination.
	[INFO] log4j-1.2.15.jar already exists in destination.
	[INFO] gov.nist.math.jama-1.1.1.jar already exists in destination.
	[INFO] gatk-tools-protected-3.5.jar already exists in destination.
	[INFO] slf4j-api-1.6.1.jar already exists in destination.
	[INFO] commons-jexl-2.1.1.jar already exists in destination.
	[INFO] google-genomics-utils-v1beta2-0.19.jar already exists in destination.
	[INFO] dom4j-1.6.1.jar already exists in destination.
	[INFO] google-api-services-genomics-v1beta2-rev9-1.19.0.jar already exists in destination.
	[INFO] jackson-core-2.1.3.jar already exists in destination.
	[INFO] drmaa-common-1.0.jar already exists in destination.
	[INFO] google-http-client-1.19.0.jar already exists in destination.
	[INFO] jetty-6.1.26.jar already exists in destination.
	[INFO] java-xmlbuilder-0.4.jar already exists in destination.
	[INFO] gatk-tools-public-3.5.jar already exists in destination.
	[INFO] 
	[INFO] --- maven-shade-plugin:2.1:shade (package-jar) @ gatk-queue-package-distribution ---
	[WARNING] Map in class org.apache.maven.plugins.shade.resource.ManifestResourceTransformer declares value type as: class java.util.jar.Attributes but saw: class java.lang.String at runtime
	[INFO] Including org.broadinstitute.gatk:gatk-queue:jar:3.5 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-utils:jar:3.5 in the shaded jar.
	[INFO] Including log4j:log4j:jar:1.2.15 in the shaded jar.
	[INFO] Including net.sf.jgrapht:jgrapht:jar:0.8.3 in the shaded jar.
	[INFO] Including org.apache.commons:commons-email:jar:1.2 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-package-distribution:jar:3.5 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-engine:jar:3.5 in the shaded jar.
	[INFO] Including net.java.dev.jets3t:jets3t:jar:0.8.1 in the shaded jar.
	[INFO] Including com.jamesmurty.utils:java-xmlbuilder:jar:0.4 in the shaded jar.
	[INFO] Including org.simpleframework:simple-xml:jar:2.0.4 in the shaded jar.
	[INFO] Including stax:stax-api:jar:1.0.1 in the shaded jar.
	[INFO] Including stax:stax:jar:1.2.0 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-tools-public:jar:3.5 in the shaded jar.
	[INFO] Including org.apache.commons:commons-jexl:jar:2.1.1 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-tools-protected:jar:3.5 in the shaded jar.
	[INFO] Including gov.nist.math:jama:jar:1.0.2 in the shaded jar.
	[INFO] Including org.slf4j:slf4j-log4j12:jar:1.7.5 in the shaded jar.
	[INFO] Including com.github.samtools:htsjdk:jar:1.141 in the shaded jar.
	[INFO] Including org.xerial.snappy:snappy-java:jar:1.0.3-rc3 in the shaded jar.
	[INFO] Including org.apache.commons:commons-compress:jar:1.4.1 in the shaded jar.
	[INFO] Including org.tukaani:xz:jar:1.5 in the shaded jar.
	[INFO] Including org.apache.ant:ant:jar:1.8.2 in the shaded jar.
	[INFO] Including org.apache.ant:ant-launcher:jar:1.8.2 in the shaded jar.
	[INFO] Including commons-logging:commons-logging:jar:1.1.1 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-queue-extensions-distribution:jar:3.5 in the shaded jar.
	[INFO] Including org.broadinstitute.gatk:gatk-queue-extensions-generator:jar:3.5 in the shaded jar.
	[INFO] Including org.scala-lang:scala-library:jar:2.10.2 in the shaded jar.
	[INFO] Including org.scala-lang:scala-compiler:jar:2.10.2 in the shaded jar.
	[INFO] Including org.scala-lang:scala-reflect:jar:2.10.2 in the shaded jar.
	[INFO] Including com.github.broadinstitute:picard:jar:1.141 in the shaded jar.
	[INFO] Including com.google.cloud.genomics:gatk-tools-java:jar:1.1 in the shaded jar.
	[INFO] Including com.google.api-client:google-api-client:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.oauth-client:google-oauth-client:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.oauth-client:google-oauth-client-jetty:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.oauth-client:google-oauth-client-java6:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.http-client:google-http-client:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.http-client:google-http-client-jackson2:jar:1.19.0 in the shaded jar.
	[INFO] Including com.fasterxml.jackson.core:jackson-core:jar:2.1.3 in the shaded jar.
	[INFO] Including com.google.apis:google-api-services-genomics:jar:v1beta2-rev9-1.19.0 in the shaded jar.
	[INFO] Including com.google.cloud.genomics:google-genomics-utils:jar:v1beta2-0.19 in the shaded jar.
	[INFO] Including com.google.api-client:google-api-client-java6:jar:1.19.0 in the shaded jar.
	[INFO] Including com.google.guava:guava:jar:18.0 in the shaded jar.
	[INFO] Including gov.nist.math.jama:gov.nist.math.jama:jar:1.1.1 in the shaded jar.
	[INFO] Including org.mortbay.jetty:jetty:jar:6.1.26 in the shaded jar.
	[INFO] Including org.mortbay.jetty:jetty-util:jar:6.1.26 in the shaded jar.
	[INFO] Including javax.servlet:servlet-api:jar:2.5 in the shaded jar.
	[INFO] Including javax.mail:mail:jar:1.4.4 in the shaded jar.
	[INFO] Including javax.activation:activation:jar:1.1 in the shaded jar.
	[INFO] Including net.java.dev.jna:jna:jar:3.2.7 in the shaded jar.
	[INFO] Including com.google.code.cofoja:cofoja:jar:1.2-20140817 in the shaded jar.
	[INFO] Including org.ow2.asm:asm-all:jar:5.0.4 in the shaded jar.
	[INFO] Including net.sf.snpeff:snpeff:jar:2.0.5 in the shaded jar.
	[INFO] Including commons-httpclient:commons-httpclient:jar:3.1 in the shaded jar.
	[INFO] Including commons-codec:commons-codec:jar:1.2 in the shaded jar.
	[INFO] Excluding org.broadinstitute.gatk:gatk-utils:tar.bz2:example-resources:3.5 from the shaded jar.
	[INFO] Including colt:colt:jar:1.2.0 in the shaded jar.
	[INFO] Including concurrent:concurrent:jar:1.3.4 in the shaded jar.
	[INFO] Including it.unimi.dsi:fastutil:jar:6.5.3 in the shaded jar.
	[INFO] Including org.reflections:reflections:jar:0.9.9-RC1 in the shaded jar.
	[INFO] Including org.javassist:javassist:jar:3.16.1-GA in the shaded jar.
	[INFO] Including dom4j:dom4j:jar:1.6.1 in the shaded jar.
	[INFO] Including xml-apis:xml-apis:jar:1.0.b2 in the shaded jar.
	[INFO] Including org.slf4j:slf4j-api:jar:1.6.1 in the shaded jar.
	[INFO] Including org.freemarker:freemarker:jar:2.3.18 in the shaded jar.
	[INFO] Including commons-lang:commons-lang:jar:2.5 in the shaded jar.
	[INFO] Including commons-io:commons-io:jar:2.1 in the shaded jar.
	[INFO] Including commons-collections:commons-collections:jar:3.2.1 in the shaded jar.
	[INFO] Including org.apache.commons:commons-math:jar:2.2 in the shaded jar.
	[INFO] Including us.levk:drmaa-gridengine:jar:6.2u5 in the shaded jar.
	[INFO] Including us.levk:drmaa-common:jar:1.0 in the shaded jar.
	[INFO] Including com.google.code.gson:gson:jar:2.2.2 in the shaded jar.
	[INFO] Including org.apache.httpcomponents:httpclient:jar:4.1.1 in the shaded jar.
	[INFO] Including org.apache.httpcomponents:httpcore:jar:4.1 in the shaded jar.
	[INFO] Excluding org.broadinstitute.gatk:gsalib:tar.gz:3.5 from the shaded jar.
	[INFO] Excluding org.broadinstitute.gatk:gatk-queue-extensions-public:tar.bz2:example-resources:3.5 from the shaded jar.
	[INFO] Including com.google.code.findbugs:jsr305:jar:1.3.9 in the shaded jar.
	[INFO] Including com.beust:jcommander:jar:1.27 in the shaded jar.
	[INFO] Minimizing jar org.broadinstitute.gatk:gatk-queue-package-distribution:jar:3.5
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, dom4j-1.6.1.jar define 88 overlappping classes: 
	[WARNING]   - org.dom4j.io.DispatchHandler
	[WARNING]   - org.dom4j.dtd.ElementDecl
	[WARNING]   - org.dom4j.io.SAXHelper
	[WARNING]   - org.dom4j.Branch
	[WARNING]   - org.dom4j.DocumentException
	[WARNING]   - org.dom4j.tree.ContentListFacade
	[WARNING]   - org.dom4j.tree.ConcurrentReaderHashMap$1
	[WARNING]   - org.dom4j.Visitor
	[WARNING]   - org.dom4j.tree.AbstractDocumentType
	[WARNING]   - org.dom4j.tree.NamespaceCache
	[WARNING]   - 78 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, reflections-0.9.9-RC1.jar define 82 overlappping classes: 
	[WARNING]   - org.reflections.vfs.SystemFile
	[WARNING]   - org.reflections.vfs.Vfs$DefaultUrlTypes
	[WARNING]   - org.reflections.vfs.Vfs$DefaultUrlTypes$3
	[WARNING]   - org.reflections.vfs.Vfs$DefaultUrlTypes$2
	[WARNING]   - org.reflections.util.FilterBuilder$Exclude
	[WARNING]   - org.reflections.vfs.ZipDir$1
	[WARNING]   - org.reflections.vfs.JarInputDir$1$1
	[WARNING]   - org.reflections.ReflectionUtils$2
	[WARNING]   - org.reflections.Store
	[WARNING]   - org.reflections.ReflectionUtils$5
	[WARNING]   - 72 more...
	[WARNING] gov.nist.math.jama-1.1.1.jar, gatk-package-distribution-3.5.jar, jama-1.0.2.jar, gatk-queue-package-distribution-3.5.jar define 7 overlappping classes: 
	[WARNING]   - Jama.SingularValueDecomposition
	[WARNING]   - Jama.EigenvalueDecomposition
	[WARNING]   - Jama.CholeskyDecomposition
	[WARNING]   - Jama.util.Maths
	[WARNING]   - Jama.Matrix
	[WARNING]   - Jama.LUDecomposition
	[WARNING]   - Jama.QRDecomposition
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, commons-math-2.2.jar define 247 overlappping classes: 
	[WARNING]   - org.apache.commons.math.stat.descriptive.moment.Kurtosis
	[WARNING]   - org.apache.commons.math.MathRuntimeException$6
	[WARNING]   - org.apache.commons.math.distribution.GammaDistribution
	[WARNING]   - org.apache.commons.math.distribution.ExponentialDistributionImpl
	[WARNING]   - org.apache.commons.math.linear.FieldVector
	[WARNING]   - org.apache.commons.math.exception.DimensionMismatchException
	[WARNING]   - org.apache.commons.math.linear.AbstractRealMatrix$4
	[WARNING]   - org.apache.commons.math.analysis.ComposableFunction$2
	[WARNING]   - org.apache.commons.math.fraction.FractionField$LazyHolder
	[WARNING]   - org.apache.commons.math.special.Beta
	[WARNING]   - 237 more...
	[WARNING] gatk-package-distribution-3.5.jar, stax-api-1.0.1.jar, gatk-queue-package-distribution-3.5.jar define 24 overlappping classes: 
	[WARNING]   - javax.xml.stream.FactoryFinder
	[WARNING]   - javax.xml.stream.events.StartElement
	[WARNING]   - javax.xml.stream.Location
	[WARNING]   - javax.xml.stream.EventFilter
	[WARNING]   - javax.xml.stream.XMLInputFactory
	[WARNING]   - javax.xml.stream.XMLEventReader
	[WARNING]   - javax.xml.stream.events.Attribute
	[WARNING]   - javax.xml.stream.events.Characters
	[WARNING]   - javax.xml.stream.XMLStreamException
	[WARNING]   - javax.xml.stream.XMLStreamReader
	[WARNING]   - 14 more...
	[WARNING] gatk-package-distribution-3.5.jar, javassist-3.16.1-GA.jar, gatk-queue-package-distribution-3.5.jar define 285 overlappping classes: 
	[WARNING]   - javassist.bytecode.CodeIterator$Jump32
	[WARNING]   - javassist.CtMember$Cache
	[WARNING]   - javassist.bytecode.LineNumberAttribute
	[WARNING]   - javassist.expr.NewArray
	[WARNING]   - javassist.bytecode.SignatureAttribute$1
	[WARNING]   - javassist.bytecode.SignatureAttribute$BaseType
	[WARNING]   - javassist.CtField$LongInitializer
	[WARNING]   - javassist.compiler.ast.BinExpr
	[WARNING]   - javassist.bytecode.StackMap$Writer
	[WARNING]   - javassist.CodeConverter$DefaultArrayAccessReplacementMethodNames
	[WARNING]   - 275 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, gatk-queue-3.5.jar define 405 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.queue.library.ipf.SortByRef$$anonfun$contigVal$2
	[WARNING]   - org.broadinstitute.gatk.queue.engine.CommandLineJobRunner$$anonfun$init$1
	[WARNING]   - org.broadinstitute.gatk.queue.library.clf.vcf.VCFExtractIntervals
	[WARNING]   - org.broadinstitute.gatk.queue.engine.QGraph$$anonfun$addFailedFunctions$2
	[WARNING]   - org.broadinstitute.gatk.queue.engine.QGraph$$anonfun$getReadyJobs$1
	[WARNING]   - org.broadinstitute.gatk.queue.QCommandLine$$anonfun$execute$8$$anonfun$5
	[WARNING]   - org.broadinstitute.gatk.queue.engine.CommandLineJobManager$class
	[WARNING]   - org.broadinstitute.gatk.queue.engine.lsf.Lsf706JobRunner$$anonfun$tryStop$2
	[WARNING]   - org.broadinstitute.gatk.queue.engine.QGraph$$anonfun$logFailed$1
	[WARNING]   - org.broadinstitute.gatk.queue.function.RetryMemoryLimit$$anonfun$isMemoryError$1
	[WARNING]   - 395 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, snappy-java-1.0.3-rc3.jar define 11 overlappping classes: 
	[WARNING]   - org.xerial.snappy.OSInfo
	[WARNING]   - org.xerial.snappy.SnappyOutputStream
	[WARNING]   - org.xerial.snappy.SnappyInputStream
	[WARNING]   - org.xerial.snappy.SnappyErrorCode
	[WARNING]   - org.xerial.snappy.SnappyCodec
	[WARNING]   - org.xerial.snappy.SnappyException
	[WARNING]   - org.xerial.snappy.SnappyNative
	[WARNING]   - org.xerial.snappy.Snappy
	[WARNING]   - org.xerial.snappy.LoadSnappy
	[WARNING]   - org.xerial.snappy.SnappyError
	[WARNING]   - 1 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, slf4j-log4j12-1.7.5.jar define 6 overlappping classes: 
	[WARNING]   - org.slf4j.impl.StaticMarkerBinder
	[WARNING]   - org.slf4j.impl.Log4jLoggerFactory
	[WARNING]   - org.slf4j.impl.StaticLoggerBinder
	[WARNING]   - org.slf4j.impl.Log4jMDCAdapter
	[WARNING]   - org.slf4j.impl.Log4jLoggerAdapter
	[WARNING]   - org.slf4j.impl.StaticMDCBinder
	[WARNING] gatk-package-distribution-3.5.jar, gatk-tools-public-3.5.jar, gatk-queue-package-distribution-3.5.jar define 228 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ConcordanceMetrics$SiteConcordanceType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$7
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.MultiallelicSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.varianteval.evaluators.VariantSummary
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AnnotationInterfaceManager
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.readutils.ClipReads
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.VariantsToTable$1
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.ValidateVariants$ValidationType
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.SnpEffUtil
	[WARNING]   - 218 more...
	[WARNING] gatk-package-distribution-3.5.jar, jgrapht-0.8.3.jar, gatk-queue-package-distribution-3.5.jar define 63 overlappping classes: 
	[WARNING]   - org.jgrapht.graph.DefaultDirectedGraph
	[WARNING]   - org.jgrapht.traverse.CrossComponentIterator$FlyweightEdgeEvent
	[WARNING]   - org.jgrapht.graph.IntrusiveEdge
	[WARNING]   - org.jgrapht.graph.AbstractBaseGraph
	[WARNING]   - org.jgrapht.alg.CycleDetector$1
	[WARNING]   - org.jgrapht.alg.StrongConnectivityInspector$1
	[WARNING]   - org.jgrapht.graph.Subgraph$BaseGraphListener
	[WARNING]   - org.jgrapht.EdgeFactory
	[WARNING]   - org.jgrapht.event.TraversalListener
	[WARNING]   - org.jgrapht.graph.AbstractBaseGraph$DirectedSpecifics
	[WARNING]   - 53 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, slf4j-api-1.6.1.jar define 19 overlappping classes: 
	[WARNING]   - org.slf4j.spi.MarkerFactoryBinder
	[WARNING]   - org.slf4j.helpers.BasicMarker
	[WARNING]   - org.slf4j.helpers.Util
	[WARNING]   - org.slf4j.LoggerFactory
	[WARNING]   - org.slf4j.Marker
	[WARNING]   - org.slf4j.helpers.NamedLoggerBase
	[WARNING]   - org.slf4j.Logger
	[WARNING]   - org.slf4j.spi.LocationAwareLogger
	[WARNING]   - org.slf4j.ILoggerFactory
	[WARNING]   - org.slf4j.helpers.BasicMarkerFactory
	[WARNING]   - 9 more...
	[WARNING] gatk-package-distribution-3.5.jar, commons-compress-1.4.1.jar, gatk-queue-package-distribution-3.5.jar define 10 overlappping classes: 
	[WARNING]   - org.apache.commons.compress.compressors.xz.XZCompressorInputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream$Data
	[WARNING]   - org.apache.commons.compress.utils.CountingOutputStream
	[WARNING]   - org.apache.commons.compress.compressors.xz.XZCompressorOutputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.BZip2Constants
	[WARNING]   - org.apache.commons.compress.compressors.CompressorOutputStream
	[WARNING]   - org.apache.commons.compress.compressors.CompressorInputStream
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.CRC
	[WARNING]   - org.apache.commons.compress.compressors.bzip2.Rand
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, servlet-api-2.5.jar define 11 overlappping classes: 
	[WARNING]   - javax.servlet.ServletInputStream
	[WARNING]   - javax.servlet.ServletConfig
	[WARNING]   - javax.servlet.RequestDispatcher
	[WARNING]   - javax.servlet.ServletRequest
	[WARNING]   - javax.servlet.ServletResponse
	[WARNING]   - javax.servlet.ServletException
	[WARNING]   - javax.servlet.ServletContext
	[WARNING]   - javax.servlet.ServletContextListener
	[WARNING]   - javax.servlet.ServletOutputStream
	[WARNING]   - javax.servlet.Servlet
	[WARNING]   - 1 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, gatk-engine-3.5.jar define 305 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.engine.iterators.BoundedReadIterator
	[WARNING]   - org.broadinstitute.gatk.engine.filters.ReadNameFilter
	[WARNING]   - org.broadinstitute.gatk.engine.datasources.providers.LocusReferenceView
	[WARNING]   - org.broadinstitute.gatk.engine.alignment.reference.packing.BasePackedInputStream
	[WARNING]   - org.broadinstitute.gatk.engine.io.NWaySAMFileWriter
	[WARNING]   - org.broadinstitute.gatk.engine.filters.MissingReadGroupFilter
	[WARNING]   - org.broadinstitute.gatk.engine.alignment.reference.bwt.SuffixArray$SuffixArrayComparator
	[WARNING]   - org.broadinstitute.gatk.engine.filters.BadMateFilter
	[WARNING]   - org.broadinstitute.gatk.engine.walkers.Allows
	[WARNING]   - org.broadinstitute.gatk.engine.traversals.TraverseReadPairs
	[WARNING]   - 295 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, httpclient-4.1.1.jar define 206 overlappping classes: 
	[WARNING]   - org.apache.http.conn.routing.RouteInfo$TunnelType
	[WARNING]   - org.apache.http.client.methods.HttpUriRequest
	[WARNING]   - org.apache.http.impl.client.RedirectLocations
	[WARNING]   - org.apache.http.conn.scheme.SchemeSocketFactoryAdaptor
	[WARNING]   - org.apache.http.impl.cookie.BrowserCompatSpecFactory
	[WARNING]   - org.apache.http.conn.ssl.AbstractVerifier
	[WARNING]   - org.apache.http.client.protocol.RequestDefaultHeaders
	[WARNING]   - org.apache.http.impl.cookie.RFC2965SpecFactory
	[WARNING]   - org.apache.http.annotation.ThreadSafe
	[WARNING]   - org.apache.http.client.methods.HttpRequestBase
	[WARNING]   - 196 more...
	[WARNING] htsjdk-1.141.jar, gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 913 overlappping classes: 
	[WARNING]   - htsjdk.samtools.Bin
	[WARNING]   - htsjdk.samtools.util.ftp.FTPStream
	[WARNING]   - htsjdk.tribble.example.ProfileIndexReading
	[WARNING]   - htsjdk.samtools.cram.encoding.writer.Writer
	[WARNING]   - htsjdk.samtools.util.CoordMath
	[WARNING]   - htsjdk.samtools.cram.encoding.ByteArrayStopEncoding$ByteArrayStopCodec
	[WARNING]   - htsjdk.samtools.CoordinateSortedPairInfoMap$1
	[WARNING]   - htsjdk.samtools.util.Tuple
	[WARNING]   - htsjdk.samtools.cram.encoding.writer.DataWriter
	[WARNING]   - htsjdk.samtools.cram.encoding.huffman.codec.HuffmanIntHelper$1
	[WARNING]   - 903 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, asm-all-5.0.4.jar define 53 overlappping classes: 
	[WARNING]   - org.objectweb.asm.tree.LocalVariableNode
	[WARNING]   - org.objectweb.asm.Opcodes
	[WARNING]   - org.objectweb.asm.commons.GeneratorAdapter
	[WARNING]   - org.objectweb.asm.tree.VarInsnNode
	[WARNING]   - org.objectweb.asm.AnnotationVisitor
	[WARNING]   - org.objectweb.asm.tree.InvokeDynamicInsnNode
	[WARNING]   - org.objectweb.asm.tree.FieldInsnNode
	[WARNING]   - org.objectweb.asm.commons.AdviceAdapter
	[WARNING]   - org.objectweb.asm.tree.IincInsnNode
	[WARNING]   - org.objectweb.asm.tree.LookupSwitchInsnNode
	[WARNING]   - 43 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, picard-1.141.jar define 16 overlappping classes: 
	[WARNING]   - picard.cmdline.CommandLineParseException
	[WARNING]   - picard.cmdline.CommandLineParser$ChildOptionArg
	[WARNING]   - picard.cmdline.NestedOptions
	[WARNING]   - picard.cmdline.CommandLineParserDefinitionException
	[WARNING]   - picard.cmdline.programgroups.None
	[WARNING]   - picard.cmdline.Option
	[WARNING]   - picard.cmdline.PositionalArguments
	[WARNING]   - picard.cmdline.CommandLineProgramProperties
	[WARNING]   - picard.cmdline.CommandLineProgram
	[WARNING]   - picard.cmdline.CommandLineProgramGroup
	[WARNING]   - 6 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, java-xmlbuilder-0.4.jar define 4 overlappping classes: 
	[WARNING]   - net.iharder.base64.Base64$OutputStream
	[WARNING]   - net.iharder.base64.Base64
	[WARNING]   - net.iharder.base64.Base64$InputStream
	[WARNING]   - com.jamesmurty.utils.XMLBuilder
	[WARNING] xml-apis-1.0.b2.jar, gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 68 overlappping classes: 
	[WARNING]   - javax.xml.parsers.FactoryConfigurationError
	[WARNING]   - javax.xml.parsers.SAXParserFactory
	[WARNING]   - javax.xml.parsers.SAXParser
	[WARNING]   - org.w3c.dom.Document
	[WARNING]   - javax.xml.transform.TransformerException
	[WARNING]   - javax.xml.transform.SourceLocator
	[WARNING]   - org.w3c.dom.Node
	[WARNING]   - org.xml.sax.helpers.AttributesImpl
	[WARNING]   - org.xml.sax.DTDHandler
	[WARNING]   - javax.xml.transform.TransformerConfigurationException
	[WARNING]   - 58 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, colt-1.2.0.jar define 15 overlappping classes: 
	[WARNING]   - cern.jet.math.Constants
	[WARNING]   - cern.jet.random.Normal
	[WARNING]   - cern.jet.stat.Gamma
	[WARNING]   - cern.colt.function.DoubleFunction
	[WARNING]   - cern.jet.random.AbstractContinousDistribution
	[WARNING]   - cern.colt.function.IntFunction
	[WARNING]   - cern.jet.random.engine.MersenneTwister
	[WARNING]   - cern.colt.PersistentObject
	[WARNING]   - cern.jet.math.Arithmetic
	[WARNING]   - cern.jet.stat.Probability
	[WARNING]   - 5 more...
	[WARNING] gson-2.2.2.jar, gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 153 overlappping classes: 
	[WARNING]   - com.google.gson.internal.bind.TypeAdapters$27
	[WARNING]   - com.google.gson.internal.bind.TypeAdapters$10
	[WARNING]   - com.google.gson.TreeTypeAdapter
	[WARNING]   - com.google.gson.internal.bind.TypeAdapters$15
	[WARNING]   - com.google.gson.JsonIOException
	[WARNING]   - com.google.gson.internal.StringMap
	[WARNING]   - com.google.gson.internal.StringMap$LinkedHashIterator
	[WARNING]   - com.google.gson.annotations.Until
	[WARNING]   - com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper
	[WARNING]   - com.google.gson.stream.JsonReader$2
	[WARNING]   - 143 more...
	[WARNING] gatk-package-distribution-3.5.jar, ant-1.8.2.jar, gatk-queue-package-distribution-3.5.jar define 4 overlappping classes: 
	[WARNING]   - org.apache.tools.bzip2.CBZip2InputStream$Data
	[WARNING]   - org.apache.tools.bzip2.CBZip2InputStream
	[WARNING]   - org.apache.tools.bzip2.CRC
	[WARNING]   - org.apache.tools.bzip2.BZip2Constants
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, commons-codec-1.2.jar define 10 overlappping classes: 
	[WARNING]   - org.apache.commons.codec.BinaryEncoder
	[WARNING]   - org.apache.commons.codec.BinaryDecoder
	[WARNING]   - org.apache.commons.codec.Encoder
	[WARNING]   - org.apache.commons.codec.binary.Base64
	[WARNING]   - org.apache.commons.codec.Decoder
	[WARNING]   - org.apache.commons.codec.net.URLCodec
	[WARNING]   - org.apache.commons.codec.DecoderException
	[WARNING]   - org.apache.commons.codec.EncoderException
	[WARNING]   - org.apache.commons.codec.StringEncoder
	[WARNING]   - org.apache.commons.codec.StringDecoder
	[WARNING] gatk-queue-package-distribution-3.5.jar, mail-1.4.4.jar define 286 overlappping classes: 
	[WARNING]   - javax.mail.internet.ContentDisposition
	[WARNING]   - com.sun.mail.pop3.Protocol
	[WARNING]   - com.sun.mail.iap.Response
	[WARNING]   - com.sun.mail.smtp.DigestMD5
	[WARNING]   - javax.mail.internet.MimePart
	[WARNING]   - com.sun.mail.imap.IMAPMessage
	[WARNING]   - javax.mail.Message
	[WARNING]   - com.sun.mail.imap.Rights
	[WARNING]   - com.sun.mail.util.SocketFetcher
	[WARNING]   - com.sun.mail.pop3.POP3Store
	[WARNING]   - 276 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, commons-io-2.1.jar define 32 overlappping classes: 
	[WARNING]   - org.apache.commons.io.filefilter.FalseFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.SuffixFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.TrueFileFilter
	[WARNING]   - org.apache.commons.io.input.ClosedInputStream
	[WARNING]   - org.apache.commons.io.filefilter.NotFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.ConditionalFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.IOFileFilter
	[WARNING]   - org.apache.commons.io.filefilter.OrFileFilter
	[WARNING]   - org.apache.commons.io.comparator.LastModifiedFileComparator
	[WARNING]   - org.apache.commons.io.filefilter.PrefixFileFilter
	[WARNING]   - 22 more...
	[WARNING] scala-compiler-2.10.2.jar, gatk-queue-package-distribution-3.5.jar define 8560 overlappping classes: 
	[WARNING]   - scala.tools.nsc.transform.patmat.MatchTranslation$MatchTranslator$ExtractorCallProd
	[WARNING]   - scala.tools.nsc.ast.DocComments$DocComment$$anonfun$defineVariables$2
	[WARNING]   - ch.epfl.lamp.compiler.msil.emit.ConstructorBuilder
	[WARNING]   - scala.tools.nsc.transform.Constructors$ConstructorTransformer$$anonfun$8
	[WARNING]   - scala.tools.nsc.backend.msil.GenMSIL$BytecodeGenerator$$anonfun$scala$tools$nsc$backend$msil$GenMSIL$BytecodeGenerator$$genMethod$3$$anonfun$apply$5
	[WARNING]   - scala.tools.nsc.backend.msil.GenMSIL$BytecodeGenerator$$anonfun$customModifiers$1
	[WARNING]   - scala.tools.nsc.backend.MSILPlatform$class
	[WARNING]   - scala.tools.nsc.ast.DocComments$$anonfun$expandInternal$1$1$$anonfun$apply$5
	[WARNING]   - scala.tools.nsc.CommonRunner
	[WARNING]   - scala.tools.nsc.interpreter.Power$ReplUtilities$$anonfun$clazz$1
	[WARNING]   - 8550 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, xz-1.5.jar define 84 overlappping classes: 
	[WARNING]   - org.tukaani.xz.lzma.Optimum
	[WARNING]   - org.tukaani.xz.index.IndexBase
	[WARNING]   - org.tukaani.xz.lzma.LZMAEncoderNormal
	[WARNING]   - org.tukaani.xz.delta.DeltaDecoder
	[WARNING]   - org.tukaani.xz.DeltaCoder
	[WARNING]   - org.tukaani.xz.simple.SPARC
	[WARNING]   - org.tukaani.xz.LZMA2Coder
	[WARNING]   - org.tukaani.xz.common.DecoderUtil
	[WARNING]   - org.tukaani.xz.XZOutputStream
	[WARNING]   - org.tukaani.xz.UnsupportedOptionsException
	[WARNING]   - 74 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, freemarker-2.3.18.jar define 24 overlappping classes: 
	[WARNING]   - freemarker.core.DateBuiltins$iso_BI$Result
	[WARNING]   - freemarker.core.TemplateClassResolver$4
	[WARNING]   - freemarker.core.TemplateClassResolver
	[WARNING]   - freemarker.core.TemplateClassResolver$2
	[WARNING]   - freemarker.core.DateBuiltins
	[WARNING]   - freemarker.core.TemplateClassResolver$1
	[WARNING]   - freemarker.core.DateBuiltins$iso_BI
	[WARNING]   - freemarker.ext.beans.BeansWrapper$MethodAppearanceDecision
	[WARNING]   - freemarker.core.TemplateClassResolver$3
	[WARNING]   - freemarker.template.utility.DateUtil
	[WARNING]   - 14 more...
	[WARNING] gatk-package-distribution-3.5.jar, commons-httpclient-3.1.jar, gatk-queue-package-distribution-3.5.jar define 167 overlappping classes: 
	[WARNING]   - org.apache.commons.httpclient.util.URIUtil$Coder
	[WARNING]   - org.apache.commons.httpclient.HttpMethodDirector
	[WARNING]   - org.apache.commons.httpclient.cookie.CookiePolicy
	[WARNING]   - org.apache.commons.httpclient.MethodRetryHandler
	[WARNING]   - org.apache.commons.httpclient.auth.NTLMScheme
	[WARNING]   - org.apache.commons.httpclient.auth.AuthChallengeParser
	[WARNING]   - org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource
	[WARNING]   - org.apache.commons.httpclient.cookie.RFC2965Spec$CookieCommentUrlAttributeHandler
	[WARNING]   - org.apache.commons.httpclient.auth.AuthScope
	[WARNING]   - org.apache.commons.httpclient.HttpClientError
	[WARNING]   - 157 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, commons-jexl-2.1.1.jar define 158 overlappping classes: 
	[WARNING]   - org.apache.commons.jexl2.ExpressionImpl$1
	[WARNING]   - org.apache.commons.jexl2.parser.ASTNotNode
	[WARNING]   - org.apache.commons.jexl2.parser.Parser$JJCalls
	[WARNING]   - org.apache.commons.jexl2.parser.ASTReference
	[WARNING]   - org.apache.commons.jexl2.parser.Token
	[WARNING]   - org.apache.commons.jexl2.internal.introspection.MethodMap
	[WARNING]   - org.apache.commons.jexl2.parser.ASTSizeFunction
	[WARNING]   - org.apache.commons.jexl2.ExpressionImpl
	[WARNING]   - org.apache.commons.jexl2.parser.ASTForeachStatement
	[WARNING]   - org.apache.commons.jexl2.introspection.JexlPropertySet
	[WARNING]   - 148 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, cofoja-1.2-20140817.jar define 144 overlappping classes: 
	[WARNING]   - com.google.java.contract.util.Iterables
	[WARNING]   - com.google.java.contract.core.apt.MethodContractCreator$PostMethodCreationTrait
	[WARNING]   - com.google.java.contract.core.apt.SourcePreprocessor
	[WARNING]   - com.google.java.contract.core.util.JavaTokenizer
	[WARNING]   - com.google.java.contract.core.apt.AnnotationProcessor$1
	[WARNING]   - com.google.java.contract.core.util.JavaTokenizer$TokenKind
	[WARNING]   - com.google.java.contract.core.util.SyntheticJavaFile
	[WARNING]   - com.google.java.contract.core.apt.MethodContractCreator
	[WARNING]   - com.google.java.contract.ContractImport
	[WARNING]   - com.google.java.contract.util.Predicates$11
	[WARNING]   - 134 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 183 overlappping classes: 
	[WARNING]   - com.google.common.collect.Multisets$SetMultiset$ElementSet
	[WARNING]   - com.google.common.collect.Multimaps$FilteredMultimap$AsMap$Values$2
	[WARNING]   - com.google.common.collect.SortedIterables$2
	[WARNING]   - com.google.common.collect.ImmutableMultimap$Values$1
	[WARNING]   - com.google.common.collect.Maps$AbstractFilteredMap$Values$1
	[WARNING]   - com.google.common.collect.Sets$PowerSet$BitFilteredSetIterator
	[WARNING]   - com.google.common.collect.BstRangeOps$1
	[WARNING]   - com.google.common.collect.RegularImmutableMultiset$1
	[WARNING]   - com.google.common.collect.Multimaps$UnmodifiableAsMapValues
	[WARNING]   - com.google.common.collect.Multimaps$FilteredMultimap$AsMap$Values
	[WARNING]   - 173 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, scala-library-2.10.2.jar define 4894 overlappping classes: 
	[WARNING]   - scala.xml.parsing.TokenTests
	[WARNING]   - scala.Function2$mcIJI$sp$class
	[WARNING]   - scala.runtime.NonLocalReturnControl$mcF$sp
	[WARNING]   - scala.runtime.RichFloat
	[WARNING]   - scala.collection.mutable.ArrayBuilder$ofLong
	[WARNING]   - scala.util.parsing.combinator.Parsers$$anonfun$elem$1
	[WARNING]   - scala.concurrent.impl.Promise$KeptPromise
	[WARNING]   - scala.collection.IterableViewLike$$anonfun$sliding$1$$anonfun$apply$2
	[WARNING]   - scala.collection.parallel.ParIterableLike$Composite
	[WARNING]   - scala.concurrent.duration.package$span$
	[WARNING]   - 4884 more...
	[WARNING] snpeff-2.0.5.jar, gatk-queue-package-distribution-3.5.jar, freemarker-2.3.18.jar define 172 overlappping classes: 
	[WARNING]   - freemarker.ext.xml.JdomNavigator
	[WARNING]   - freemarker.ext.jdom.NodeListModel$NamedNodeOperator
	[WARNING]   - freemarker.ext.xml.DomNavigator
	[WARNING]   - freemarker.core.CommandLine
	[WARNING]   - freemarker.ext.jdom.NodeListModel$QNameOp
	[WARNING]   - freemarker.ext.jsp.FreeMarkerJspFactory
	[WARNING]   - freemarker.ext.xml.Navigator$ParentOp
	[WARNING]   - freemarker.core.RegexBuiltins$RegexMatchModel$2
	[WARNING]   - freemarker.debug.DebuggerClient
	[WARNING]   - freemarker.core.RegexBuiltins$ReplaceMethod
	[WARNING]   - 162 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, simple-xml-2.0.4.jar define 187 overlappping classes: 
	[WARNING]   - org.simpleframework.xml.stream.OutputStack
	[WARNING]   - org.simpleframework.xml.transform.BigIntegerTransform
	[WARNING]   - org.simpleframework.xml.transform.PackageMatcher
	[WARNING]   - org.simpleframework.xml.stream.OutputNodeMap
	[WARNING]   - org.simpleframework.xml.core.GetPart
	[WARNING]   - org.simpleframework.xml.core.CompositeValue
	[WARNING]   - org.simpleframework.xml.stream.Formatter
	[WARNING]   - org.simpleframework.xml.core.Contact
	[WARNING]   - org.simpleframework.xml.transform.DoubleTransform
	[WARNING]   - org.simpleframework.xml.Namespace
	[WARNING]   - 177 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, guava-18.0.jar define 477 overlappping classes: 
	[WARNING]   - com.google.common.collect.MapMakerInternalMap$SoftEvictableEntry
	[WARNING]   - com.google.common.collect.Iterators$12
	[WARNING]   - com.google.common.base.Predicates$InstanceOfPredicate
	[WARNING]   - com.google.common.collect.ImmutableMultiset$1
	[WARNING]   - com.google.common.collect.MapMaker$RemovalCause$4
	[WARNING]   - com.google.common.collect.MapMakerInternalMap$WeakValueReference
	[WARNING]   - com.google.common.collect.Maps$TransformedEntriesSortedMap
	[WARNING]   - com.google.common.base.Predicates$AndPredicate
	[WARNING]   - com.google.common.collect.Multimaps$Keys$KeysEntrySet
	[WARNING]   - com.google.common.collect.ImmutableSortedSet$Builder
	[WARNING]   - 467 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, gatk-utils-3.5.jar define 1208 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.utils.help.GATKDocWorkUnit
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibLsf$lsSharedResourceInfo$ByReference
	[WARNING]   - org.broadinstitute.gatk.utils.variant.GATKVariantContextUtils$AlleleMapper
	[WARNING]   - org.broadinstitute.gatk.utils.downsampling.SimplePositionalDownsamplerFactory
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$jgrpCtrl$ByReference
	[WARNING]   - org.broadinstitute.gatk.utils.R.RUtils
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$_limitConsumer$ByValue
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$addRsvRequest$ByValue
	[WARNING]   - org.broadinstitute.gatk.utils.codecs.refseq.RefSeqFeature
	[WARNING]   - org.broadinstitute.gatk.utils.jna.lsf.v7_0_6.LibBat$hostPartInfoEnt
	[WARNING]   - 1198 more...
	[WARNING] gatk-queue-package-distribution-3.5.jar, picard-1.141.jar define 574 overlappping classes: 
	[WARNING]   - picard.illumina.parser.BarcodeParser$BarcodeDataIterator$1
	[WARNING]   - picard.illumina.parser.readers.BclQualityEvaluationStrategy$1
	[WARNING]   - picard.illumina.parser.PerTileCycleParser
	[WARNING]   - picard.sam.SamToFastq$FastqWriters$1
	[WARNING]   - picard.illumina.IlluminaBasecallsConverter
	[WARNING]   - picard.analysis.CountingFilter
	[WARNING]   - picard.analysis.InsertSizeMetrics
	[WARNING]   - picard.illumina.quality.CollectHiSeqXPfFailMetrics$ReadClassifier
	[WARNING]   - picard.analysis.AlignmentSummaryMetrics$Category
	[WARNING]   - picard.illumina.parser.PosParser$2
	[WARNING]   - 564 more...
	[WARNING] commons-logging-1.1.1.jar, gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 28 overlappping classes: 
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$2
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl
	[WARNING]   - org.apache.commons.logging.impl.WeakHashtable$1
	[WARNING]   - org.apache.commons.logging.LogFactory$3
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$3
	[WARNING]   - org.apache.commons.logging.impl.LogFactoryImpl$1
	[WARNING]   - org.apache.commons.logging.LogFactory$6
	[WARNING]   - org.apache.commons.logging.impl.WeakHashtable
	[WARNING]   - org.apache.commons.logging.LogConfigurationException
	[WARNING]   - org.apache.commons.logging.impl.AvalonLogger
	[WARNING]   - 18 more...
	[WARNING] snpeff-2.0.5.jar, gatk-queue-package-distribution-3.5.jar define 1319 overlappping classes: 
	[WARNING]   - flanagan.physprop.IonicRadii
	[WARNING]   - junit.awtui.TestRunner$2
	[WARNING]   - gnu.trove.THashMap$EqProcedure
	[WARNING]   - gnu.trove.TFloatStack
	[WARNING]   - gnu.trove.decorator.TDoubleByteHashMapDecorator$1
	[WARNING]   - gnu.trove.decorator.TDoubleShortHashMapDecorator$1$1
	[WARNING]   - gnu.trove.decorator.TLongDoubleHashMapDecorator$1
	[WARNING]   - flanagan.analysis.RegressionFunction2
	[WARNING]   - gnu.trove.TShortHashSet$1
	[WARNING]   - ca.mcgill.mcb.pcingola.interval.codonChange.CodonChangeSnp
	[WARNING]   - 1309 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, jets3t-0.8.1.jar define 157 overlappping classes: 
	[WARNING]   - org.jets3t.service.multi.event.ServiceEvent
	[WARNING]   - org.jets3t.service.impl.rest.XmlResponsesSaxParser$ListBucketHandler
	[WARNING]   - org.jets3t.service.io.OutputStreamWrapper
	[WARNING]   - org.jets3t.service.multi.ThreadedStorageService$3
	[WARNING]   - org.jets3t.service.io.RepeatableFileInputStream
	[WARNING]   - org.jets3t.service.model.BaseVersionOrDeleteMarker
	[WARNING]   - org.jets3t.service.impl.rest.XmlResponsesSaxParser$ListMultipartUploadsResultHandler
	[WARNING]   - org.jets3t.service.utils.MultipartUtils
	[WARNING]   - org.jets3t.service.multi.ThreadedStorageService$AbstractRunnable
	[WARNING]   - org.jets3t.service.utils.RestUtils$1
	[WARNING]   - 147 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, jsr305-1.3.9.jar define 11 overlappping classes: 
	[WARNING]   - javax.annotation.meta.When
	[WARNING]   - javax.annotation.concurrent.Immutable
	[WARNING]   - javax.annotation.CheckForNull
	[WARNING]   - javax.annotation.meta.TypeQualifierValidator
	[WARNING]   - javax.annotation.Nonnull
	[WARNING]   - javax.annotation.Nullable
	[WARNING]   - javax.annotation.meta.TypeQualifier
	[WARNING]   - javax.annotation.concurrent.GuardedBy
	[WARNING]   - javax.annotation.Nonnull$Checker
	[WARNING]   - javax.annotation.CheckReturnValue
	[WARNING]   - 1 more...
	[WARNING] gatk-package-distribution-3.5.jar, commons-collections-3.2.1.jar, gatk-queue-package-distribution-3.5.jar define 37 overlappping classes: 
	[WARNING]   - org.apache.commons.collections.list.TransformedList$TransformedListIterator
	[WARNING]   - org.apache.commons.collections.collection.TypedCollection
	[WARNING]   - org.apache.commons.collections.collection.UnmodifiableCollection
	[WARNING]   - org.apache.commons.collections.collection.UnmodifiableBoundedCollection
	[WARNING]   - org.apache.commons.collections.list.UnmodifiableList
	[WARNING]   - org.apache.commons.collections.BoundedCollection
	[WARNING]   - org.apache.commons.collections.iterators.AbstractEmptyIterator
	[WARNING]   - org.apache.commons.collections.iterators.UnmodifiableListIterator
	[WARNING]   - org.apache.commons.collections.collection.SynchronizedCollection
	[WARNING]   - org.apache.commons.collections.Factory
	[WARNING]   - 27 more...
	[WARNING] jna-3.2.7.jar, gatk-queue-package-distribution-3.5.jar define 16 overlappping classes: 
	[WARNING]   - com.sun.jna.win32.StdCallLibrary$StdCallCallback
	[WARNING]   - com.sun.jna.win32.W32APIOptions$1
	[WARNING]   - com.sun.jna.win32.W32APIFunctionMapper
	[WARNING]   - com.sun.jna.win32.StdCall
	[WARNING]   - com.sun.jna.DefaultTypeMapper
	[WARNING]   - com.sun.jna.win32.W32APITypeMapper
	[WARNING]   - com.sun.jna.DefaultTypeMapper$Entry
	[WARNING]   - com.sun.jna.win32.StdCallLibrary
	[WARNING]   - com.sun.jna.ptr.ShortByReference
	[WARNING]   - com.sun.jna.win32.W32APITypeMapper$2
	[WARNING]   - 6 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, drmaa-common-1.0.jar define 33 overlappping classes: 
	[WARNING]   - org.ggf.drmaa.DrmsInitException
	[WARNING]   - org.ggf.drmaa.InvalidAttributeFormatException
	[WARNING]   - org.ggf.drmaa.ReleaseInconsistentStateException
	[WARNING]   - org.ggf.drmaa.TryLaterException
	[WARNING]   - org.ggf.drmaa.SessionFactory$NewFactoryAction
	[WARNING]   - org.ggf.drmaa.AlreadyActiveSessionException
	[WARNING]   - org.ggf.drmaa.JobInfo
	[WARNING]   - org.ggf.drmaa.FileTransferMode
	[WARNING]   - org.ggf.drmaa.ResumeInconsistentStateException
	[WARNING]   - org.ggf.drmaa.InvalidContactStringException
	[WARNING]   - 23 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, gatk-tools-protected-3.5.jar define 524 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.variantutils.CombineGVCFs$OverallState
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.diagnostics.diagnosetargets.CallableStatus
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.haplotypecaller.PairHMMLikelihoodCalculationEngine$PCR_ERROR_MODEL
	[WARNING]   - org.broadinstitute.gatk.utils.collections.CountSet
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.haplotypecaller.LDMerger$LDMergeData
	[WARNING]   - org.broadinstitute.gatk.utils.variant.TandemRepeatFinder$Result
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.annotator.DepthPerAlleleBySample
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.bqsr.ReadRecalibrationInfo
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.haplotypecaller.graphs.TestGraph
	[WARNING]   - org.broadinstitute.gatk.tools.walkers.validation.validationsiteselector.KeepAFSpectrumFrequencySelector
	[WARNING]   - 514 more...
	[WARNING] gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar, commons-lang-2.5.jar define 45 overlappping classes: 
	[WARNING]   - org.apache.commons.lang.ObjectUtils
	[WARNING]   - org.apache.commons.lang.builder.IDKey
	[WARNING]   - org.apache.commons.lang.exception.NestableRuntimeException
	[WARNING]   - org.apache.commons.lang.builder.ToStringStyle$MultiLineToStringStyle
	[WARNING]   - org.apache.commons.lang.StringEscapeUtils
	[WARNING]   - org.apache.commons.lang.CharRange
	[WARNING]   - org.apache.commons.lang.IntHashMap
	[WARNING]   - org.apache.commons.lang.builder.EqualsBuilder
	[WARNING]   - org.apache.commons.lang.Entities$ArrayEntityMap
	[WARNING]   - org.apache.commons.lang.Entities$BinaryEntityMap
	[WARNING]   - 35 more...
	[WARNING] gatk-queue-extensions-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 405 overlappping classes: 
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.DocumentationTest$$anonfun$2
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.RealignerTargetCreator$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.GATKScatterFunction$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.VariantEval
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.Sample$class
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.ASEReadCounter$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.MergeVCFs
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.UnifiedGenotyper$$anonfun$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.RodSystemValidation$$anonfun$freezeFieldValues$1
	[WARNING]   - org.broadinstitute.gatk.queue.extensions.gatk.PrepareTargets
	[WARNING]   - 395 more...
	[WARNING] fastutil-6.5.3.jar, gatk-package-distribution-3.5.jar, gatk-queue-package-distribution-3.5.jar define 124 overlappping classes: 
	[WARNING]   - it.unimi.dsi.fastutil.ints.AbstractIntList$1
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectIterators$UnmodifiableIterator
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2IntMap
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectArrayList$1
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap$KeyIterator
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap$MapEntry
	[WARNING]   - it.unimi.dsi.fastutil.Arrays
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectIterators
	[WARNING]   - it.unimi.dsi.fastutil.objects.Object2ObjectMap$FastEntrySet
	[WARNING]   - it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
	[WARNING]   - 114 more...
	[WARNING] gatk-package-distribution-3.5.jar, httpcore-4.1.jar, gatk-queue-package-distribution-3.5.jar define 121 overlappping classes: 
	[WARNING]   - org.apache.http.ConnectionReuseStrategy
	[WARNING]   - org.apache.http.params.AbstractHttpParams
	[WARNING]   - org.apache.http.util.VersionInfo
	[WARNING]   - org.apache.http.MalformedChunkCodingException
	[WARNING]   - org.apache.http.HttpClientConnection
	[WARNING]   - org.apache.http.params.BasicHttpParams
	[WARNING]   - org.apache.http.impl.io.AbstractSessionOutputBuffer
	[WARNING]   - org.apache.http.impl.io.ContentLengthInputStream
	[WARNING]   - org.apache.http.impl.AbstractHttpClientConnection
	[WARNING]   - org.apache.http.protocol.HttpResponseInterceptorList
	[WARNING]   - 111 more...
	[WARNING] gatk-package-distribution-3.5.jar, log4j-1.2.15.jar, gatk-queue-package-distribution-3.5.jar define 72 overlappping classes: 
	[WARNING]   - org.apache.log4j.or.ObjectRenderer
	[WARNING]   - org.apache.log4j.helpers.AbsoluteTimeDateFormat
	[WARNING]   - org.apache.log4j.helpers.FileWatchdog
	[WARNING]   - org.apache.log4j.Priority
	[WARNING]   - org.apache.log4j.WriterAppender
	[WARNING]   - org.apache.log4j.helpers.PatternParser$NamedPatternConverter
	[WARNING]   - org.apache.log4j.spi.NOPLogger
	[WARNING]   - org.apache.log4j.NDC$DiagnosticContext
	[WARNING]   - org.apache.log4j.spi.ErrorHandler
	[WARNING]   - org.apache.log4j.spi.AppenderAttachable
	[WARNING]   - 62 more...
	[WARNING] gatk-package-distribution-3.5.jar, jna-3.2.7.jar, gatk-queue-package-distribution-3.5.jar define 79 overlappping classes: 
	[WARNING]   - com.sun.jna.NativeLong
	[WARNING]   - com.sun.jna.Structure$FFIType$size_t
	[WARNING]   - com.sun.jna.Structure$StructField
	[WARNING]   - com.sun.jna.InvocationMapper
	[WARNING]   - com.sun.jna.StructureWriteContext
	[WARNING]   - com.sun.jna.Callback$UncaughtExceptionHandler
	[WARNING]   - com.sun.jna.StringArray
	[WARNING]   - com.sun.jna.ptr.LongByReference
	[WARNING]   - com.sun.jna.Callback
	[WARNING]   - com.sun.jna.TypeMapper
	[WARNING]   - 69 more...
	[WARNING] gatk-package-distribution-3.5.jar, snpeff-2.0.5.jar, gatk-queue-package-distribution-3.5.jar, freemarker-2.3.18.jar define 457 overlappping classes: 
	[WARNING]   - freemarker.ext.jython.JythonWrapper
	[WARNING]   - freemarker.ext.dom.CharacterDataNodeModel
	[WARNING]   - freemarker.template.SimpleCollection$SimpleTemplateModelIterator
	[WARNING]   - freemarker.debug.impl.DebuggerService
	[WARNING]   - freemarker.core.CollectionAndSequence$SequenceIterator
	[WARNING]   - freemarker.template.EmptyMap
	[WARNING]   - freemarker.ext.beans.CollectionAdapter$1
	[WARNING]   - freemarker.debug.impl.DebuggerService$NoOpDebuggerService
	[WARNING]   - freemarker.core.FMParserTokenManager
	[WARNING]   - freemarker.core.NumericalBuiltins$longBI
	[WARNING]   - 447 more...
	[WARNING] maven-shade-plugin has detected that some .class files
	[WARNING] are present in two or more JARs. When this happens, only
	[WARNING] one single version of the class is copied in the uberjar.
	[WARNING] Usually this is not harmful and you can skeep these
	[WARNING] warnings, otherwise try to manually exclude artifacts
	[WARNING] based on mvn dependency:tree -Ddetail=true and the above
	[WARNING] output
	[WARNING] See http://docs.codehaus.org/display/MAVENUSER/Shade+Plugin
	[INFO] Minimized 75612 -> 59076 (78%)
	[INFO] Replacing original artifact with shaded artifact.
	[INFO] Replacing /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5.jar with /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5-shaded.jar
	[INFO] 
	[INFO] --- maven-assembly-plugin:2.4:single (binary-dist) @ gatk-queue-package-distribution ---
	[INFO] Reading assembly descriptor: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/../../public/src/main/assembly/binary-dist.xml
	[INFO] Building tar: /home/xubo/xubo/tools/gatk-protected/protected/gatk-queue-package-distribution/target/gatk-queue-package-distribution-3.5-binary-dist.tar.bz2
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-executable-jar) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-package-jar) @ gatk-queue-package-distribution ---
	[INFO] 
	[INFO] --- maven-junction-plugin:1.0.3:link (link-git-release) @ gatk-queue-package-distribution ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building GATK Aggregator Protected 3.5
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ gatk-aggregator-protected ---
	[INFO] 
	[INFO] --- gitdescribe-maven-plugin:2.0:gitdescribe (gitdescribe-initialize) @ gatk-aggregator-protected ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.8:regex-property (fix-version-initialize) @ gatk-aggregator-protected ---
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO] 
	[INFO] GATK Root .......................................... SUCCESS [  8.396 s]
	[INFO] GATK Aggregator .................................... SUCCESS [  8.826 s]
	[INFO] GATK GSALib ........................................ SUCCESS [  2.574 s]
	[INFO] GATK Utils ......................................... SUCCESS [ 50.349 s]
	[INFO] GATK Engine ........................................ SUCCESS [ 23.595 s]
	[INFO] GATK Tools Public .................................. SUCCESS [ 23.399 s]
	[INFO] External Example ................................... SUCCESS [ 26.813 s]
	[INFO] GATK Queue ......................................... SUCCESS [03:48 min]
	[INFO] GATK Queue Extensions Generator .................... SUCCESS [  0.373 s]
	[INFO] GATK Queue Extensions Public ....................... SUCCESS [01:41 min]
	[INFO] GATK Aggregator Public ............................. SUCCESS [  0.005 s]
	[INFO] GATK Tools Protected ............................... SUCCESS [ 24.463 s]
	[INFO] GATK Package Distribution .......................... SUCCESS [01:46 min]
	[INFO] GATK Queue Extensions Distribution ................. SUCCESS [02:16 min]
	[INFO] GATK Queue Package Distribution .................... SUCCESS [04:04 min]
	[INFO] GATK Aggregator Protected .......................... SUCCESS [  0.004 s]
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 16:27 min
	[INFO] Finished at: 2016-06-07T21:05:06+08:00
	[INFO] Final Memory: 70M/715M
	[INFO] ------------------------------------------------------------------------
	xubo@xubo:~/xubo/tools/gatk-protected$ 
