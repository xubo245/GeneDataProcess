	
	
	1.安装时需要修改maven到较高版本，并且需要就内存per mem设置较大
	
	2.记录：
	
	D:\1win7\java\jdk\bin\java -Dmaven.multiModuleProjectDirectory=D:\all\idea\adam-adam-parent-0.14.0 -Xmx2g -XX:MaxPermSize=2024M -Dmaven.home=D:\1win7\java\apache-maven-3.3.9-bin\apache-maven-3.3.9 -Dclassworlds.conf=D:\1win7\java\apache-maven-3.3.9-bin\apache-maven-3.3.9\bin\m2.conf -Didea.launcher.port=7537 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\1win7\java\apache-maven-3.3.9-bin\apache-maven-3.3.9\boot\plexus-classworlds-2.5.2.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.classworlds.Launcher -Didea.version=15.0.4 clean package -DskipTests
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective settings
	[WARNING] Unrecognised tag: 'profile' (position: START_TAG seen ...    variables for plugins in the POM.\n   |\n   |-->\n   \t\t\t<profile>... @184:16)  @ D:\1win7\java\apache-maven-3.3.9-bin\apache-maven-3.3.9\conf\settings.xml, line 184, column 16
	[WARNING] 
	[INFO] Scanning for projects...
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Build Order:
	[INFO] 
	[INFO] ADAM
	[INFO] ADAM: Core
	[INFO] ADAM: APIs for Java
	[INFO] ADAM: CLI
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building ADAM 0.14.0
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ adam-parent ---
	[INFO] Deleting D:\all\idea\adam-adam-parent-0.14.0\target
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-parent ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-parent ---
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-parent ---
	[INFO] Modified 0 of 280 .scala files
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-parent ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-parent ---
	[INFO] No sources to compile
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building ADAM: Core 0.14.0
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ adam-core ---
	[INFO] Deleting D:\all\idea\adam-adam-parent-0.14.0\adam-core\target
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-core ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-core ---
	[INFO] 
	[INFO] --- git-commit-id-plugin:2.1.9:revision (default) @ adam-core ---
	[info] dotGitDirectory is null, aborting execution!
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-source (add-source) @ adam-core ---
	[INFO] Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-core\src\main\scala added.
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-core ---
	[INFO] Modified 0 of 240 .scala files
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adam-core ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-core ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] Compiling 161 Scala sources and 1 Java source to D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\scala-2.10.3\classes...
	[WARNING] there were 3 deprecation warning(s); re-run with -deprecation for details
	[WARNING] there were 40 feature warning(s); re-run with -feature for details
	[WARNING] two warnings found
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ adam-core ---
	[INFO] Changes detected - recompiling the module!
	[INFO] Compiling 1 source file to D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\scala-2.10.3\classes
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-test-source (add-test-source) @ adam-core ---
	[INFO] Test Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-core\src\test\scala added.
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adam-core ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 39 resources
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-core ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] Compiling 79 Scala sources to D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\scala-2.10.3\test-classes...
	[WARNING] D:\all\idea\adam-adam-parent-0.14.0\adam-core\src\test\scala\org\bdgenomics\adam\rich\RichAlignmentRecordSuite.scala:66: method assert in trait Assertions is deprecated: This method has been deprecated in favor of macro assertion and will be removed in a future version of ScalaTest. If you need this, please copy the source code into your own trait instead.
	[WARNING]       case None => assert(Some("Failed to parse valid Illumina read name"))
	[WARNING]                    ^
	[WARNING] there were 1 inliner warning(s); re-run with -Yinline-warnings for details
	[WARNING] two warnings found
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ adam-core ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ adam-core ---
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.17/maven-surefire-common-2.17.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.17/maven-surefire-common-2.17.pom (6 KB at 1.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.2/maven-plugin-annotations-3.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.2/maven-plugin-annotations-3.2.pom (2 KB at 3.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-tools/3.2/maven-plugin-tools-3.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-tools/3.2/maven-plugin-tools-3.2.pom (17 KB at 14.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.17/surefire-api-2.17.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.17/surefire-api-2.17.pom (3 KB at 4.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.17/surefire-booter-2.17.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.17/surefire-booter-2.17.pom (3 KB at 5.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.17/maven-surefire-common-2.17.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.17/surefire-booter-2.17.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.17/surefire-api-2.17.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.2/maven-plugin-annotations-3.2.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-booter/2.17/surefire-booter-2.17.jar (39 KB at 29.4 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugin-tools/maven-plugin-annotations/3.2/maven-plugin-annotations-3.2.jar (15 KB at 9.3 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-api/2.17/surefire-api-2.17.jar (144 KB at 50.2 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/maven-surefire-common/2.17/maven-surefire-common-2.17.jar (260 KB at 41.0 KB/sec)
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- scalatest-maven-plugin:1.0-RC2:test (test) @ adam-core ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ adam-core ---
	[INFO] Building jar: D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\adam-core-0.14.0.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (default) @ adam-core ---
	[INFO] Building jar: D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\adam-core-0.14.0-tests.jar
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building ADAM: APIs for Java 0.14.0
	[INFO] ------------------------------------------------------------------------
	Downloading: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.3.1/jackson-databind-2.3.1.jar
	Downloading: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-core/2.3.1/jackson-core-2.3.1.jar
	Downloading: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.3.0/jackson-annotations-2.3.0.jar
	Downloaded: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.3.0/jackson-annotations-2.3.0.jar (35 KB at 24.1 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-core/2.3.1/jackson-core-2.3.1.jar (194 KB at 59.9 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.3.1/jackson-databind-2.3.1.jar (893 KB at 78.6 KB/sec)
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ adam-apis ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-apis ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-apis ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-source (add-source) @ adam-apis ---
	[INFO] Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-apis\src\main\scala added.
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-apis ---
	[INFO] Modified 0 of 4 .scala files
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adam-apis ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory D:\all\idea\adam-adam-parent-0.14.0\adam-apis\src\main\resources
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-apis ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] Compiling 3 Scala sources to D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\scala-2.10.3\classes...
	[WARNING] there were 2 feature warning(s); re-run with -feature for details
	[WARNING] one warning found
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ adam-apis ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-test-source (add-test-source) @ adam-apis ---
	[INFO] Test Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-apis\src\test\scala added.
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adam-apis ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-apis ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] Compiling 1 Scala source and 2 Java sources to D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\scala-2.10.3\test-classes...
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ adam-apis ---
	[INFO] Changes detected - recompiling the module!
	[INFO] Compiling 2 source files to D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\scala-2.10.3\test-classes
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ adam-apis ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- scalatest-maven-plugin:1.0-RC2:test (test) @ adam-apis ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ adam-apis ---
	[INFO] Building jar: D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\adam-apis-0.14.0.jar
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (default) @ adam-apis ---
	[INFO] Building jar: D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\adam-apis-0.14.0-tests.jar
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building ADAM: CLI 0.14.0
	[INFO] ------------------------------------------------------------------------
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/2.4.1/maven-assembly-plugin-2.4.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/2.4.1/maven-assembly-plugin-2.4.1.jar (212 KB at 66.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-core_2.10/1.6.1/scalate-core_2.10-1.6.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-core_2.10/1.6.1/scalate-core_2.10-1.6.1.pom (7 KB at 12.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-project_2.10/1.6.1/scalate-project_2.10-1.6.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-project_2.10/1.6.1/scalate-project_2.10-1.6.1.pom (34 KB at 27.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-util_2.10/1.6.1/scalate-util_2.10-1.6.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-util_2.10/1.6.1/scalate-util_2.10-1.6.1.pom (3 KB at 4.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-json_2.10/2.3.0/scalatra-json_2.10-2.3.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-json_2.10/2.3.0/scalatra-json_2.10-2.3.0.pom (5 KB at 10.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/scalatra_2.10/2.3.0/scalatra_2.10-2.3.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/scalatra_2.10/2.3.0/scalatra_2.10-2.3.0.pom (8 KB at 14.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-common_2.10/2.3.0/scalatra-common_2.10-2.3.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-common_2.10/2.3.0/scalatra-common_2.10-2.3.0.pom (5 KB at 9.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/clapper/grizzled-slf4j_2.10/1.0.2/grizzled-slf4j_2.10-1.0.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/clapper/grizzled-slf4j_2.10/1.0.2/grizzled-slf4j_2.10-1.0.2.pom (2 KB at 3.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/rl/rl_2.10/0.4.10/rl_2.10-0.4.10.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/rl/rl_2.10/0.4.10/rl_2.10-0.4.10.pom (3 KB at 4.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/googlecode/juniversalchardet/juniversalchardet/1.0.3/juniversalchardet-1.0.3.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/googlecode/juniversalchardet/juniversalchardet/1.0.3/juniversalchardet-1.0.3.pom (2 KB at 2.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/eu/medsea/mimeutil/mime-util/2.1.3/mime-util-2.1.3.pom
	Downloaded: https://repo.maven.apache.org/maven2/eu/medsea/mimeutil/mime-util/2.1.3/mime-util-2.1.3.pom (8 KB at 16.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/joda/joda-convert/1.6/joda-convert-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/joda/joda-convert/1.6/joda-convert-1.6.pom (20 KB at 11.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-core_2.10/1.6.1/scalate-core_2.10-1.6.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-util_2.10/1.6.1/scalate-util_2.10-1.6.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-common_2.10/2.3.0/scalatra-common_2.10-2.3.0.jar
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-json_2.10/2.3.0/scalatra-json_2.10-2.3.0.jar
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/scalatra_2.10/2.3.0/scalatra_2.10-2.3.0.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-common_2.10/2.3.0/scalatra-common_2.10-2.3.0.jar (23 KB at 10.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/clapper/grizzled-slf4j_2.10/1.0.2/grizzled-slf4j_2.10-1.0.2.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/clapper/grizzled-slf4j_2.10/1.0.2/grizzled-slf4j_2.10-1.0.2.jar (7 KB at 2.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/scalatra/rl/rl_2.10/0.4.10/rl_2.10-0.4.10.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/scalatra-json_2.10/2.3.0/scalatra-json_2.10-2.3.0.jar (85 KB at 22.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/googlecode/juniversalchardet/juniversalchardet/1.0.3/juniversalchardet-1.0.3.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-util_2.10/1.6.1/scalate-util_2.10-1.6.1.jar (289 KB at 65.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/eu/medsea/mimeutil/mime-util/2.1.3/mime-util-2.1.3.jar
	Downloaded: https://repo.maven.apache.org/maven2/eu/medsea/mimeutil/mime-util/2.1.3/mime-util-2.1.3.jar (117 KB at 17.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/joda-time/joda-time/2.3/joda-time-2.3.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/rl/rl_2.10/0.4.10/rl_2.10-0.4.10.jar (222 KB at 25.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/joda/joda-convert/1.6/joda-convert-1.6.jar
	Downloaded: https://repo.maven.apache.org/maven2/com/googlecode/juniversalchardet/juniversalchardet/1.0.3/juniversalchardet-1.0.3.jar (216 KB at 22.5 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/joda/joda-convert/1.6/joda-convert-1.6.jar (97 KB at 8.1 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/joda-time/joda-time/2.3/joda-time-2.3.jar (568 KB at 38.6 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/scalatra/scalatra_2.10/2.3.0/scalatra_2.10-2.3.0.jar (1211 KB at 58.7 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/fusesource/scalate/scalate-core_2.10/1.6.1/scalate-core_2.10-1.6.1.jar (1934 KB at 63.8 KB/sec)
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ adam-cli ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-cli ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-cli ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-source (add-source) @ adam-cli ---
	[INFO] Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\src\main\scala added.
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-cli ---
	[INFO] Modified 0 of 35 .scala files
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adam-cli ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-cli ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-cli:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-util_2.10:1.6.1 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-core_2.10:1.6.1 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] Compiling 33 Scala sources to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\scala-2.10.3\classes...
	[WARNING] there were 2 deprecation warning(s); re-run with -deprecation for details
	[WARNING] one warning found
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ adam-cli ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-test-source (add-test-source) @ adam-cli ---
	[INFO] Test Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\src\test\scala added.
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adam-cli ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-cli ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-cli:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-util_2.10:1.6.1 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-core_2.10:1.6.1 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] Compiling 2 Scala sources to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\scala-2.10.3\test-classes...
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ adam-cli ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ adam-cli ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- scalatest-maven-plugin:1.0-RC2:test (test) @ adam-cli ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ adam-cli ---
	[INFO] Building jar: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\adam-cli-0.14.0.jar
	[INFO] 
	[INFO] --- appassembler-maven-plugin:1.8:assemble (default) @ adam-cli ---
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scoverage\scalac-scoverage-plugin_2.10\0.99.2\scalac-scoverage-plugin_2.10-0.99.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scoverage\scalac-scoverage-plugin_2.10\0.99.2\scalac-scoverage-plugin_2.10-0.99.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\bdgenomics\bdg-formats\bdg-formats\0.2.0\bdg-formats-0.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\bdg-formats\bdg-formats\0.2.0\bdg-formats-0.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\avro\avro\1.7.6\avro-1.7.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\avro\avro\1.7.6\avro-1.7.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\thoughtworks\paranamer\paranamer\2.3\paranamer-2.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\thoughtworks\paranamer\paranamer\2.3\paranamer-2.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\xerial\snappy\snappy-java\1.0.5\snappy-java-1.0.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\xerial\snappy\snappy-java\1.0.5\snappy-java-1.0.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-compress\1.4.1\commons-compress-1.4.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-compress\1.4.1\commons-compress-1.4.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\tukaani\xz\1.0\xz-1.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\tukaani\xz\1.0\xz-1.0.jar
	[INFO] Installing artifact D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\adam-core-0.14.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\adam\adam-core\0.14.0\adam-core-0.14.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\esotericsoftware\kryo\kryo\2.21\kryo-2.21.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\esotericsoftware\kryo\kryo\2.21\kryo-2.21.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\esotericsoftware\reflectasm\reflectasm\1.07\reflectasm-1.07-shaded.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\esotericsoftware\reflectasm\reflectasm\1.07\reflectasm-1.07-shaded.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\ow2\asm\asm\4.0\asm-4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\ow2\asm\asm\4.0\asm-4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\esotericsoftware\minlog\minlog\1.2\minlog-1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\esotericsoftware\minlog\minlog\1.2\minlog-1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\objenesis\objenesis\1.2\objenesis-1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\objenesis\objenesis\1.2\objenesis-1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-client\2.2.0\hadoop-client-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-client\2.2.0\hadoop-client-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-common\2.2.0\hadoop-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-common\2.2.0\hadoop-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-math\2.1\commons-math-2.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-math\2.1\commons-math-2.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\xmlenc\xmlenc\0.52\xmlenc-0.52.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\xmlenc\xmlenc\0.52\xmlenc-0.52.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-lang\commons-lang\2.5\commons-lang-2.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-lang\commons-lang\2.5\commons-lang-2.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-configuration\commons-configuration\1.6\commons-configuration-1.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-configuration\commons-configuration\1.6\commons-configuration-1.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-digester\commons-digester\1.8\commons-digester-1.8.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-digester\commons-digester\1.8\commons-digester-1.8.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-beanutils\commons-beanutils\1.7.0\commons-beanutils-1.7.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-beanutils\commons-beanutils\1.7.0\commons-beanutils-1.7.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-beanutils\commons-beanutils-core\1.8.0\commons-beanutils-core-1.8.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-beanutils\commons-beanutils-core\1.8.0\commons-beanutils-core-1.8.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\protobuf\protobuf-java\2.5.0\protobuf-java-2.5.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\protobuf\protobuf-java\2.5.0\protobuf-java-2.5.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-auth\2.2.0\hadoop-auth-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-auth\2.2.0\hadoop-auth-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\zookeeper\zookeeper\3.4.5\zookeeper-3.4.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\zookeeper\zookeeper\3.4.5\zookeeper-3.4.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-hdfs\2.2.0\hadoop-hdfs-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-hdfs\2.2.0\hadoop-hdfs-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\mortbay\jetty\jetty-util\6.1.26\jetty-util-6.1.26.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\mortbay\jetty\jetty-util\6.1.26\jetty-util-6.1.26.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-app\2.2.0\hadoop-mapreduce-client-app-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-app\2.2.0\hadoop-mapreduce-client-app-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-common\2.2.0\hadoop-mapreduce-client-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-common\2.2.0\hadoop-mapreduce-client-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-client\2.2.0\hadoop-yarn-client-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-client\2.2.0\hadoop-yarn-client-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\inject\guice\3.0\guice-3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\inject\guice\3.0\guice-3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\inject\javax.inject\1\javax.inject-1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\inject\javax.inject\1\javax.inject-1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\aopalliance\aopalliance\1.0\aopalliance-1.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\aopalliance\aopalliance\1.0\aopalliance-1.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-test-framework\jersey-test-framework-grizzly2\1.9\jersey-test-framework-grizzly2-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-test-framework\jersey-test-framework-grizzly2\1.9\jersey-test-framework-grizzly2-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-test-framework\jersey-test-framework-core\1.9\jersey-test-framework-core-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-test-framework\jersey-test-framework-core\1.9\jersey-test-framework-core-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\servlet\javax.servlet-api\3.0.1\javax.servlet-api-3.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\servlet\javax.servlet-api\3.0.1\javax.servlet-api-3.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-client\1.9\jersey-client-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-client\1.9\jersey-client-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-grizzly2\1.9\jersey-grizzly2-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-grizzly2\1.9\jersey-grizzly2-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-http\2.1.2\grizzly-http-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-http\2.1.2\grizzly-http-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-framework\2.1.2\grizzly-framework-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-framework\2.1.2\grizzly-framework-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\gmbal\gmbal-api-only\3.0.0-b023\gmbal-api-only-3.0.0-b023.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\gmbal\gmbal-api-only\3.0.0-b023\gmbal-api-only-3.0.0-b023.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\external\management-api\3.0.0-b012\management-api-3.0.0-b012.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\external\management-api\3.0.0-b012\management-api-3.0.0-b012.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-http-server\2.1.2\grizzly-http-server-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-http-server\2.1.2\grizzly-http-server-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-rcm\2.1.2\grizzly-rcm-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-rcm\2.1.2\grizzly-rcm-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-http-servlet\2.1.2\grizzly-http-servlet-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-http-servlet\2.1.2\grizzly-http-servlet-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\javax.servlet\3.1\javax.servlet-3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\javax.servlet\3.1\javax.servlet-3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-server\1.9\jersey-server-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-server\1.9\jersey-server-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-core\1.9\jersey-core-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-core\1.9\jersey-core-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-json\1.9\jersey-json-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-json\1.9\jersey-json-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\codehaus\jettison\jettison\1.1\jettison-1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\codehaus\jettison\jettison\1.1\jettison-1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\stax\stax-api\1.0.1\stax-api-1.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\stax\stax-api\1.0.1\stax-api-1.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\xml\bind\jaxb-impl\2.2.3-1\jaxb-impl-2.2.3-1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\xml\bind\jaxb-impl\2.2.3-1\jaxb-impl-2.2.3-1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\xml\bind\jaxb-api\2.2.2\jaxb-api-2.2.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\xml\bind\jaxb-api\2.2.2\jaxb-api-2.2.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\activation\activation\1.1\activation-1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\activation\activation\1.1\activation-1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\contribs\jersey-guice\1.9\jersey-guice-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\contribs\jersey-guice\1.9\jersey-guice-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-server-common\2.2.0\hadoop-yarn-server-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-server-common\2.2.0\hadoop-yarn-server-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-shuffle\2.2.0\hadoop-mapreduce-client-shuffle-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-shuffle\2.2.0\hadoop-mapreduce-client-shuffle-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-api\2.2.0\hadoop-yarn-api-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-api\2.2.0\hadoop-yarn-api-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-core\2.2.0\hadoop-mapreduce-client-core-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-core\2.2.0\hadoop-mapreduce-client-core-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-common\2.2.0\hadoop-yarn-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-common\2.2.0\hadoop-yarn-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-jobclient\2.2.0\hadoop-mapreduce-client-jobclient-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-jobclient\2.2.0\hadoop-mapreduce-client-jobclient-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-annotations\2.2.0\hadoop-annotations-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-annotations\2.2.0\hadoop-annotations-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\spark\spark-core_2.10\1.1.0\spark-core_2.10-1.1.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\spark\spark-core_2.10\1.1.0\spark-core_2.10-1.1.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\net\java\dev\jets3t\jets3t\0.7.1\jets3t-0.7.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\net\java\dev\jets3t\jets3t\0.7.1\jets3t-0.7.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\curator\curator-recipes\2.4.0\curator-recipes-2.4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\curator\curator-recipes\2.4.0\curator-recipes-2.4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\curator\curator-framework\2.4.0\curator-framework-2.4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\curator\curator-framework\2.4.0\curator-framework-2.4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\curator\curator-client\2.4.0\curator-client-2.4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\curator\curator-client\2.4.0\curator-client-2.4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-plus\8.1.14.v20131031\jetty-plus-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-plus\8.1.14.v20131031\jetty-plus-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.transaction\1.1.1.v201105210645\javax.transaction-1.1.1.v201105210645.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.transaction\1.1.1.v201105210645\javax.transaction-1.1.1.v201105210645.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-webapp\8.1.14.v20131031\jetty-webapp-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-webapp\8.1.14.v20131031\jetty-webapp-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-xml\8.1.14.v20131031\jetty-xml-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-xml\8.1.14.v20131031\jetty-xml-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-servlet\8.1.14.v20131031\jetty-servlet-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-servlet\8.1.14.v20131031\jetty-servlet-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-jndi\8.1.14.v20131031\jetty-jndi-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-jndi\8.1.14.v20131031\jetty-jndi-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.mail.glassfish\1.4.1.v201005082020\javax.mail.glassfish-1.4.1.v201005082020.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.mail.glassfish\1.4.1.v201005082020\javax.mail.glassfish-1.4.1.v201005082020.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.activation\1.1.0.v201105071233\javax.activation-1.1.0.v201105071233.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.activation\1.1.0.v201105071233\javax.activation-1.1.0.v201105071233.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-security\8.1.14.v20131031\jetty-security-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-security\8.1.14.v20131031\jetty-security-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-util\8.1.14.v20131031\jetty-util-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-util\8.1.14.v20131031\jetty-util-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-server\8.1.14.v20131031\jetty-server-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-server\8.1.14.v20131031\jetty-server-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-continuation\8.1.14.v20131031\jetty-continuation-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-continuation\8.1.14.v20131031\jetty-continuation-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-http\8.1.14.v20131031\jetty-http-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-http\8.1.14.v20131031\jetty-http-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-io\8.1.14.v20131031\jetty-io-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-io\8.1.14.v20131031\jetty-io-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\guava\guava\14.0.1\guava-14.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\guava\guava\14.0.1\guava-14.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-lang3\3.3.2\commons-lang3-3.3.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-lang3\3.3.2\commons-lang3-3.3.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\jul-to-slf4j\1.7.5\jul-to-slf4j-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\jul-to-slf4j\1.7.5\jul-to-slf4j-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\jcl-over-slf4j\1.7.5\jcl-over-slf4j-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\jcl-over-slf4j\1.7.5\jcl-over-slf4j-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\ning\compress-lzf\1.0.0\compress-lzf-1.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\ning\compress-lzf\1.0.0\compress-lzf-1.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\net\jpountz\lz4\lz4\1.2.0\lz4-1.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\net\jpountz\lz4\lz4\1.2.0\lz4-1.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\chill_2.10\0.3.6\chill_2.10-0.3.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\chill_2.10\0.3.6\chill_2.10-0.3.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\chill-java\0.3.6\chill-java-0.3.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\chill-java\0.3.6\chill-java-0.3.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-net\commons-net\2.2\commons-net-2.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-net\commons-net\2.2\commons-net-2.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\akka\akka-remote_2.10\2.2.3-shaded-protobuf\akka-remote_2.10-2.2.3-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\akka\akka-remote_2.10\2.2.3-shaded-protobuf\akka-remote_2.10-2.2.3-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\akka\akka-actor_2.10\2.2.3-shaded-protobuf\akka-actor_2.10-2.2.3-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\akka\akka-actor_2.10\2.2.3-shaded-protobuf\akka-actor_2.10-2.2.3-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\typesafe\config\1.0.2\config-1.0.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\typesafe\config\1.0.2\config-1.0.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\io\netty\netty\3.6.6.Final\netty-3.6.6.Final.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\io\netty\netty\3.6.6.Final\netty-3.6.6.Final.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\protobuf\protobuf-java\2.4.1-shaded\protobuf-java-2.4.1-shaded.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\protobuf\protobuf-java\2.4.1-shaded\protobuf-java-2.4.1-shaded.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\uncommons\maths\uncommons-maths\1.2.2a\uncommons-maths-1.2.2a.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\uncommons\maths\uncommons-maths\1.2.2a\uncommons-maths-1.2.2a.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\akka\akka-slf4j_2.10\2.2.3-shaded-protobuf\akka-slf4j_2.10-2.2.3-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\akka\akka-slf4j_2.10\2.2.3-shaded-protobuf\akka-slf4j_2.10-2.2.3-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\json4s\json4s-jackson_2.10\3.2.10\json4s-jackson_2.10-3.2.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\json4s\json4s-jackson_2.10\3.2.10\json4s-jackson_2.10-3.2.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\fasterxml\jackson\core\jackson-databind\2.3.1\jackson-databind-2.3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\fasterxml\jackson\core\jackson-databind\2.3.1\jackson-databind-2.3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\fasterxml\jackson\core\jackson-annotations\2.3.0\jackson-annotations-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\fasterxml\jackson\core\jackson-annotations\2.3.0\jackson-annotations-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\fasterxml\jackson\core\jackson-core\2.3.1\jackson-core-2.3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\fasterxml\jackson\core\jackson-core\2.3.1\jackson-core-2.3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\colt\colt\1.2.0\colt-1.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\colt\colt\1.2.0\colt-1.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\concurrent\concurrent\1.3.4\concurrent-1.3.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\concurrent\concurrent\1.3.4\concurrent-1.3.4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\mesos\mesos\0.18.1\mesos-0.18.1-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\mesos\mesos\0.18.1\mesos-0.18.1-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\io\netty\netty-all\4.0.23.Final\netty-all-4.0.23.Final.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\io\netty\netty-all\4.0.23.Final\netty-all-4.0.23.Final.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\clearspring\analytics\stream\2.7.0\stream-2.7.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\clearspring\analytics\stream\2.7.0\stream-2.7.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-core\3.0.0\metrics-core-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-core\3.0.0\metrics-core-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-jvm\3.0.0\metrics-jvm-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-jvm\3.0.0\metrics-jvm-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-json\3.0.0\metrics-json-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-json\3.0.0\metrics-json-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-graphite\3.0.0\metrics-graphite-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-graphite\3.0.0\metrics-graphite-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\tachyonproject\tachyon-client\0.5.0\tachyon-client-0.5.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\tachyonproject\tachyon-client\0.5.0\tachyon-client-0.5.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\tachyonproject\tachyon\0.5.0\tachyon-0.5.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\tachyonproject\tachyon\0.5.0\tachyon-0.5.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\pyrolite\2.0.1\pyrolite-2.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\pyrolite\2.0.1\pyrolite-2.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\net\sf\py4j\py4j\0.8.2.1\py4j-0.8.2.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\net\sf\py4j\py4j\0.8.2.1\py4j-0.8.2.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\it\unimi\dsi\fastutil\6.4.4\fastutil-6.4.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\it\unimi\dsi\fastutil\6.4.4\fastutil-6.4.4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-avro\1.4.3\parquet-avro-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-avro\1.4.3\parquet-avro-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-column\1.4.3\parquet-column-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-column\1.4.3\parquet-column-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-common\1.4.3\parquet-common-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-common\1.4.3\parquet-common-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-encoding\1.4.3\parquet-encoding-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-encoding\1.4.3\parquet-encoding-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-generator\1.4.3\parquet-generator-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-generator\1.4.3\parquet-generator-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-hadoop\1.4.3\parquet-hadoop-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-hadoop\1.4.3\parquet-hadoop-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-jackson\1.4.3\parquet-jackson-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-jackson\1.4.3\parquet-jackson-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-format\2.0.0\parquet-format-2.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-format\2.0.0\parquet-format-2.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\seqdoop\hadoop-bam\7.0.0\hadoop-bam-7.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\seqdoop\hadoop-bam\7.0.0\hadoop-bam-7.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-cli\commons-cli\1.2\commons-cli-1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-cli\commons-cli\1.2\commons-cli-1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\seqdoop\cofoja\1.1-r150\cofoja-1.1-r150.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\seqdoop\cofoja\1.1-r150\cofoja-1.1-r150.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\seqdoop\htsjdk\1.118\htsjdk-1.118.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\seqdoop\htsjdk\1.118\htsjdk-1.118.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\ant\ant\1.8.2\ant-1.8.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\ant\ant\1.8.2\ant-1.8.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\ant\ant-launcher\1.8.2\ant-launcher-1.8.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\ant\ant-launcher\1.8.2\ant-launcher-1.8.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\bcel\bcel\5.2\bcel-5.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\bcel\bcel\5.2\bcel-5.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\jakarta-regexp\jakarta-regexp\1.4\jakarta-regexp-1.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\jakarta-regexp\jakarta-regexp\1.4\jakarta-regexp-1.4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-jexl\2.1.1\commons-jexl-2.1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-jexl\2.1.1\commons-jexl-2.1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\testng\testng\6.8.8\testng-6.8.8.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\testng\testng\6.8.8\testng-6.8.8.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\beanshell\bsh\2.0b4\bsh-2.0b4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\beanshell\bsh\2.0b4\bsh-2.0b4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\beust\jcommander\1.27\jcommander-1.27.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\beust\jcommander\1.27\jcommander-1.27.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\httpcomponents\httpclient\4.3.2\httpclient-4.3.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\httpcomponents\httpclient\4.3.2\httpclient-4.3.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\httpcomponents\httpcore\4.3.1\httpcore-4.3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\httpcomponents\httpcore\4.3.1\httpcore-4.3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-codec\commons-codec\1.6\commons-codec-1.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-codec\commons-codec\1.6\commons-codec-1.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\netflix\servo\servo-core\0.5.5\servo-core-0.5.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\netflix\servo\servo-core\0.5.5\servo-core-0.5.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\code\findbugs\annotations\2.0.0\annotations-2.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\code\findbugs\annotations\2.0.0\annotations-2.0.0.jar
	[INFO] Installing artifact D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\adam-apis-0.14.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\adam\adam-apis\0.14.0\adam-apis-0.14.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\slf4j-log4j12\1.7.5\slf4j-log4j12-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\slf4j-log4j12\1.7.5\slf4j-log4j12-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\slf4j-api\1.7.5\slf4j-api-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\slf4j-api\1.7.5\slf4j-api-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\log4j\log4j\1.2.17\log4j-1.2.17.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\log4j\log4j\1.2.17\log4j-1.2.17.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\args4j\args4j\2.0.23\args4j-2.0.23.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\args4j\args4j\2.0.23\args4j-2.0.23.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\fusesource\scalate\scalate-core_2.10\1.6.1\scalate-core_2.10-1.6.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\fusesource\scalate\scalate-core_2.10\1.6.1\scalate-core_2.10-1.6.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\fusesource\scalate\scalate-util_2.10\1.6.1\scalate-util_2.10-1.6.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\fusesource\scalate\scalate-util_2.10\1.6.1\scalate-util_2.10-1.6.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scala-compiler\2.10.0\scala-compiler-2.10.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scala-compiler\2.10.0\scala-compiler-2.10.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\scalatra-json_2.10\2.3.0\scalatra-json_2.10-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\scalatra-json_2.10\2.3.0\scalatra-json_2.10-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\json4s\json4s-core_2.10\3.2.10\json4s-core_2.10-3.2.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\json4s\json4s-core_2.10\3.2.10\json4s-core_2.10-3.2.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\json4s\json4s-ast_2.10\3.2.10\json4s-ast_2.10-3.2.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\json4s\json4s-ast_2.10\3.2.10\json4s-ast_2.10-3.2.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scalap\2.10.0\scalap-2.10.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scalap\2.10.0\scalap-2.10.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\scalatra_2.10\2.3.0\scalatra_2.10-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\scalatra_2.10\2.3.0\scalatra_2.10-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\scalatra-common_2.10\2.3.0\scalatra-common_2.10-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\scalatra-common_2.10\2.3.0\scalatra-common_2.10-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\clapper\grizzled-slf4j_2.10\1.0.2\grizzled-slf4j_2.10-1.0.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\clapper\grizzled-slf4j_2.10\1.0.2\grizzled-slf4j_2.10-1.0.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\rl\rl_2.10\0.4.10\rl_2.10-0.4.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\rl\rl_2.10\0.4.10\rl_2.10-0.4.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\googlecode\juniversalchardet\juniversalchardet\1.0.3\juniversalchardet-1.0.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\googlecode\juniversalchardet\juniversalchardet\1.0.3\juniversalchardet-1.0.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\eu\medsea\mimeutil\mime-util\2.1.3\mime-util-2.1.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\eu\medsea\mimeutil\mime-util\2.1.3\mime-util-2.1.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\joda-time\joda-time\2.3\joda-time-2.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\joda-time\joda-time\2.3\joda-time-2.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\joda\joda-convert\1.6\joda-convert-1.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\joda\joda-convert\1.6\joda-convert-1.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scala-reflect\2.10.4\scala-reflect-2.10.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scala-reflect\2.10.4\scala-reflect-2.10.4.jar
	[INFO] Installing artifact D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\adam-cli-0.14.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\adam\adam-cli\0.14.0\adam-cli-0.14.0.jar
	[INFO] 
	[INFO] >>> maven-assembly-plugin:2.4.1:assembly (default) > package @ adam-cli >>>
	[INFO]                                                                         
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] Forking ADAM 0.14.0
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-parent ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-parent ---
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-parent ---
	[INFO] Modified 0 of 280 .scala files
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-parent ---
	[INFO] No sources to compile
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-parent ---
	[INFO] No sources to compile
	[INFO]                                                                         
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] Forking ADAM: Core 0.14.0
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-core ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-core ---
	[INFO] 
	[INFO] --- git-commit-id-plugin:2.1.9:revision (default) @ adam-core ---
	[info] dotGitDirectory is null, aborting execution!
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-source (add-source) @ adam-core ---
	[INFO] Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-core\src\main\scala added.
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-core ---
	[INFO] Modified 0 of 240 .scala files
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adam-core ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-core ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ adam-core ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-test-source (add-test-source) @ adam-core ---
	[INFO] Test Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-core\src\test\scala added.
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adam-core ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 39 resources
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-core ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ adam-core ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ adam-core ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- scalatest-maven-plugin:1.0-RC2:test (test) @ adam-core ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ adam-core ---
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (default) @ adam-core ---
	[INFO]                                                                         
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] Forking ADAM: APIs for Java 0.14.0
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-apis ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-apis ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-source (add-source) @ adam-apis ---
	[INFO] Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-apis\src\main\scala added.
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-apis ---
	[INFO] Modified 0 of 4 .scala files
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adam-apis ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] skip non existing resourceDirectory D:\all\idea\adam-adam-parent-0.14.0\adam-apis\src\main\resources
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-apis ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ adam-apis ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-test-source (add-test-source) @ adam-apis ---
	[INFO] Test Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-apis\src\test\scala added.
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adam-apis ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-apis ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-ast_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-core_2.10:3.2.10 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ adam-apis ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ adam-apis ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- scalatest-maven-plugin:1.0-RC2:test (test) @ adam-apis ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ adam-apis ---
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:test-jar (default) @ adam-apis ---
	[INFO]                                                                         
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] Forking ADAM: CLI 0.14.0
	[INFO] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-versions) @ adam-cli ---
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ adam-cli ---
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-source (add-source) @ adam-cli ---
	[INFO] Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\src\main\scala added.
	[INFO] 
	[INFO] --- scalariform-maven-plugin:0.1.4:format (default-cli) @ adam-cli ---
	[INFO] Modified 0 of 35 .scala files
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adam-cli ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:compile (scala-compile-first) @ adam-cli ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-cli:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-util_2.10:1.6.1 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-core_2.10:1.6.1 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ adam-cli ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- build-helper-maven-plugin:1.7:add-test-source (add-test-source) @ adam-cli ---
	[INFO] Test Source directory: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\src\test\scala added.
	[INFO] 
	[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adam-cli ---
	[INFO] Using 'UTF-8' encoding to copy filtered resources.
	[INFO] Copying 1 resource
	[INFO] 
	[INFO] --- scala-maven-plugin:3.1.5:testCompile (scala-test-compile-first) @ adam-cli ---
	[WARNING]  Expected all dependencies to require Scala version: 2.10.3
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  com.twitter:chill_2.10:0.3.6 requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-actor_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-remote_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.spark-project.akka:akka-slf4j_2.10:2.2.3-shaded-protobuf requires scala version: 2.10.3
	[WARNING]  org.apache.spark:spark-core_2.10:1.1.0 requires scala version: 2.10.3
	[WARNING]  org.json4s:json4s-jackson_2.10:3.2.10 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-apis:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.bdgenomics.adam:adam-cli:0.14.0 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-util_2.10:1.6.1 requires scala version: 2.10.3
	[WARNING]  org.fusesource.scalate:scalate-core_2.10:1.6.1 requires scala version: 2.10.0
	[WARNING] Multiple versions of scala libraries detected!
	[WARNING] Zinc server is not available at port 3030 - reverting to normal incremental compile
	[INFO] Using incremental compilation
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ adam-cli ---
	[INFO] Nothing to compile - all classes are up to date
	[INFO] 
	[INFO] --- maven-surefire-plugin:2.17:test (default-test) @ adam-cli ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- scalatest-maven-plugin:1.0-RC2:test (test) @ adam-cli ---
	[INFO] Tests are skipped.
	[INFO] 
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ adam-cli ---
	[INFO] 
	[INFO] --- appassembler-maven-plugin:1.8:assemble (default) @ adam-cli ---
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scoverage\scalac-scoverage-plugin_2.10\0.99.2\scalac-scoverage-plugin_2.10-0.99.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scoverage\scalac-scoverage-plugin_2.10\0.99.2\scalac-scoverage-plugin_2.10-0.99.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-io\commons-io\1.3.2\commons-io-1.3.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\bdgenomics\bdg-formats\bdg-formats\0.2.0\bdg-formats-0.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\bdg-formats\bdg-formats\0.2.0\bdg-formats-0.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\avro\avro\1.7.6\avro-1.7.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\avro\avro\1.7.6\avro-1.7.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\thoughtworks\paranamer\paranamer\2.3\paranamer-2.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\thoughtworks\paranamer\paranamer\2.3\paranamer-2.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\xerial\snappy\snappy-java\1.0.5\snappy-java-1.0.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\xerial\snappy\snappy-java\1.0.5\snappy-java-1.0.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-compress\1.4.1\commons-compress-1.4.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-compress\1.4.1\commons-compress-1.4.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\tukaani\xz\1.0\xz-1.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\tukaani\xz\1.0\xz-1.0.jar
	[INFO] Installing artifact D:\all\idea\adam-adam-parent-0.14.0\adam-core\target\adam-core-0.14.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\adam\adam-core\0.14.0\adam-core-0.14.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\esotericsoftware\kryo\kryo\2.21\kryo-2.21.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\esotericsoftware\kryo\kryo\2.21\kryo-2.21.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\esotericsoftware\reflectasm\reflectasm\1.07\reflectasm-1.07-shaded.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\esotericsoftware\reflectasm\reflectasm\1.07\reflectasm-1.07-shaded.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\ow2\asm\asm\4.0\asm-4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\ow2\asm\asm\4.0\asm-4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\esotericsoftware\minlog\minlog\1.2\minlog-1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\esotericsoftware\minlog\minlog\1.2\minlog-1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\objenesis\objenesis\1.2\objenesis-1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\objenesis\objenesis\1.2\objenesis-1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-client\2.2.0\hadoop-client-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-client\2.2.0\hadoop-client-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-common\2.2.0\hadoop-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-common\2.2.0\hadoop-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-math\2.1\commons-math-2.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-math\2.1\commons-math-2.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\xmlenc\xmlenc\0.52\xmlenc-0.52.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\xmlenc\xmlenc\0.52\xmlenc-0.52.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-lang\commons-lang\2.5\commons-lang-2.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-lang\commons-lang\2.5\commons-lang-2.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-configuration\commons-configuration\1.6\commons-configuration-1.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-configuration\commons-configuration\1.6\commons-configuration-1.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-collections\commons-collections\3.2.1\commons-collections-3.2.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-digester\commons-digester\1.8\commons-digester-1.8.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-digester\commons-digester\1.8\commons-digester-1.8.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-beanutils\commons-beanutils\1.7.0\commons-beanutils-1.7.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-beanutils\commons-beanutils\1.7.0\commons-beanutils-1.7.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-beanutils\commons-beanutils-core\1.8.0\commons-beanutils-core-1.8.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-beanutils\commons-beanutils-core\1.8.0\commons-beanutils-core-1.8.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\protobuf\protobuf-java\2.5.0\protobuf-java-2.5.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\protobuf\protobuf-java\2.5.0\protobuf-java-2.5.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-auth\2.2.0\hadoop-auth-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-auth\2.2.0\hadoop-auth-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\zookeeper\zookeeper\3.4.5\zookeeper-3.4.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\zookeeper\zookeeper\3.4.5\zookeeper-3.4.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-hdfs\2.2.0\hadoop-hdfs-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-hdfs\2.2.0\hadoop-hdfs-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\mortbay\jetty\jetty-util\6.1.26\jetty-util-6.1.26.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\mortbay\jetty\jetty-util\6.1.26\jetty-util-6.1.26.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-app\2.2.0\hadoop-mapreduce-client-app-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-app\2.2.0\hadoop-mapreduce-client-app-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-common\2.2.0\hadoop-mapreduce-client-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-common\2.2.0\hadoop-mapreduce-client-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-client\2.2.0\hadoop-yarn-client-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-client\2.2.0\hadoop-yarn-client-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\inject\guice\3.0\guice-3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\inject\guice\3.0\guice-3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\inject\javax.inject\1\javax.inject-1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\inject\javax.inject\1\javax.inject-1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\aopalliance\aopalliance\1.0\aopalliance-1.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\aopalliance\aopalliance\1.0\aopalliance-1.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-test-framework\jersey-test-framework-grizzly2\1.9\jersey-test-framework-grizzly2-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-test-framework\jersey-test-framework-grizzly2\1.9\jersey-test-framework-grizzly2-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-test-framework\jersey-test-framework-core\1.9\jersey-test-framework-core-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-test-framework\jersey-test-framework-core\1.9\jersey-test-framework-core-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\servlet\javax.servlet-api\3.0.1\javax.servlet-api-3.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\servlet\javax.servlet-api\3.0.1\javax.servlet-api-3.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-client\1.9\jersey-client-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-client\1.9\jersey-client-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-grizzly2\1.9\jersey-grizzly2-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-grizzly2\1.9\jersey-grizzly2-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-http\2.1.2\grizzly-http-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-http\2.1.2\grizzly-http-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-framework\2.1.2\grizzly-framework-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-framework\2.1.2\grizzly-framework-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\gmbal\gmbal-api-only\3.0.0-b023\gmbal-api-only-3.0.0-b023.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\gmbal\gmbal-api-only\3.0.0-b023\gmbal-api-only-3.0.0-b023.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\external\management-api\3.0.0-b012\management-api-3.0.0-b012.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\external\management-api\3.0.0-b012\management-api-3.0.0-b012.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-http-server\2.1.2\grizzly-http-server-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-http-server\2.1.2\grizzly-http-server-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-rcm\2.1.2\grizzly-rcm-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-rcm\2.1.2\grizzly-rcm-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\grizzly\grizzly-http-servlet\2.1.2\grizzly-http-servlet-2.1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\grizzly\grizzly-http-servlet\2.1.2\grizzly-http-servlet-2.1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\glassfish\javax.servlet\3.1\javax.servlet-3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\glassfish\javax.servlet\3.1\javax.servlet-3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-server\1.9\jersey-server-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-server\1.9\jersey-server-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-core\1.9\jersey-core-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-core\1.9\jersey-core-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\jersey-json\1.9\jersey-json-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\jersey-json\1.9\jersey-json-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\codehaus\jettison\jettison\1.1\jettison-1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\codehaus\jettison\jettison\1.1\jettison-1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\stax\stax-api\1.0.1\stax-api-1.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\stax\stax-api\1.0.1\stax-api-1.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\xml\bind\jaxb-impl\2.2.3-1\jaxb-impl-2.2.3-1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\xml\bind\jaxb-impl\2.2.3-1\jaxb-impl-2.2.3-1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\xml\bind\jaxb-api\2.2.2\jaxb-api-2.2.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\xml\bind\jaxb-api\2.2.2\jaxb-api-2.2.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\javax\activation\activation\1.1\activation-1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\javax\activation\activation\1.1\activation-1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\sun\jersey\contribs\jersey-guice\1.9\jersey-guice-1.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\sun\jersey\contribs\jersey-guice\1.9\jersey-guice-1.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-server-common\2.2.0\hadoop-yarn-server-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-server-common\2.2.0\hadoop-yarn-server-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-shuffle\2.2.0\hadoop-mapreduce-client-shuffle-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-shuffle\2.2.0\hadoop-mapreduce-client-shuffle-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-api\2.2.0\hadoop-yarn-api-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-api\2.2.0\hadoop-yarn-api-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-core\2.2.0\hadoop-mapreduce-client-core-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-core\2.2.0\hadoop-mapreduce-client-core-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-yarn-common\2.2.0\hadoop-yarn-common-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-yarn-common\2.2.0\hadoop-yarn-common-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-mapreduce-client-jobclient\2.2.0\hadoop-mapreduce-client-jobclient-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-mapreduce-client-jobclient\2.2.0\hadoop-mapreduce-client-jobclient-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\hadoop\hadoop-annotations\2.2.0\hadoop-annotations-2.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\hadoop\hadoop-annotations\2.2.0\hadoop-annotations-2.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\spark\spark-core_2.10\1.1.0\spark-core_2.10-1.1.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\spark\spark-core_2.10\1.1.0\spark-core_2.10-1.1.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\net\java\dev\jets3t\jets3t\0.7.1\jets3t-0.7.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\net\java\dev\jets3t\jets3t\0.7.1\jets3t-0.7.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\curator\curator-recipes\2.4.0\curator-recipes-2.4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\curator\curator-recipes\2.4.0\curator-recipes-2.4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\curator\curator-framework\2.4.0\curator-framework-2.4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\curator\curator-framework\2.4.0\curator-framework-2.4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\curator\curator-client\2.4.0\curator-client-2.4.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\curator\curator-client\2.4.0\curator-client-2.4.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-plus\8.1.14.v20131031\jetty-plus-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-plus\8.1.14.v20131031\jetty-plus-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.transaction\1.1.1.v201105210645\javax.transaction-1.1.1.v201105210645.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.transaction\1.1.1.v201105210645\javax.transaction-1.1.1.v201105210645.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-webapp\8.1.14.v20131031\jetty-webapp-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-webapp\8.1.14.v20131031\jetty-webapp-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-xml\8.1.14.v20131031\jetty-xml-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-xml\8.1.14.v20131031\jetty-xml-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-servlet\8.1.14.v20131031\jetty-servlet-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-servlet\8.1.14.v20131031\jetty-servlet-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-jndi\8.1.14.v20131031\jetty-jndi-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-jndi\8.1.14.v20131031\jetty-jndi-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.mail.glassfish\1.4.1.v201005082020\javax.mail.glassfish-1.4.1.v201005082020.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.mail.glassfish\1.4.1.v201005082020\javax.mail.glassfish-1.4.1.v201005082020.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.activation\1.1.0.v201105071233\javax.activation-1.1.0.v201105071233.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.activation\1.1.0.v201105071233\javax.activation-1.1.0.v201105071233.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-security\8.1.14.v20131031\jetty-security-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-security\8.1.14.v20131031\jetty-security-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-util\8.1.14.v20131031\jetty-util-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-util\8.1.14.v20131031\jetty-util-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-server\8.1.14.v20131031\jetty-server-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-server\8.1.14.v20131031\jetty-server-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-continuation\8.1.14.v20131031\jetty-continuation-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-continuation\8.1.14.v20131031\jetty-continuation-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-http\8.1.14.v20131031\jetty-http-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-http\8.1.14.v20131031\jetty-http-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\eclipse\jetty\jetty-io\8.1.14.v20131031\jetty-io-8.1.14.v20131031.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\eclipse\jetty\jetty-io\8.1.14.v20131031\jetty-io-8.1.14.v20131031.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\guava\guava\14.0.1\guava-14.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\guava\guava\14.0.1\guava-14.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-lang3\3.3.2\commons-lang3-3.3.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-lang3\3.3.2\commons-lang3-3.3.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\jul-to-slf4j\1.7.5\jul-to-slf4j-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\jul-to-slf4j\1.7.5\jul-to-slf4j-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\jcl-over-slf4j\1.7.5\jcl-over-slf4j-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\jcl-over-slf4j\1.7.5\jcl-over-slf4j-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\ning\compress-lzf\1.0.0\compress-lzf-1.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\ning\compress-lzf\1.0.0\compress-lzf-1.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\net\jpountz\lz4\lz4\1.2.0\lz4-1.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\net\jpountz\lz4\lz4\1.2.0\lz4-1.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\chill_2.10\0.3.6\chill_2.10-0.3.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\chill_2.10\0.3.6\chill_2.10-0.3.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\chill-java\0.3.6\chill-java-0.3.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\chill-java\0.3.6\chill-java-0.3.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-net\commons-net\2.2\commons-net-2.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-net\commons-net\2.2\commons-net-2.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\akka\akka-remote_2.10\2.2.3-shaded-protobuf\akka-remote_2.10-2.2.3-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\akka\akka-remote_2.10\2.2.3-shaded-protobuf\akka-remote_2.10-2.2.3-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\akka\akka-actor_2.10\2.2.3-shaded-protobuf\akka-actor_2.10-2.2.3-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\akka\akka-actor_2.10\2.2.3-shaded-protobuf\akka-actor_2.10-2.2.3-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\typesafe\config\1.0.2\config-1.0.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\typesafe\config\1.0.2\config-1.0.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\io\netty\netty\3.6.6.Final\netty-3.6.6.Final.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\io\netty\netty\3.6.6.Final\netty-3.6.6.Final.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\protobuf\protobuf-java\2.4.1-shaded\protobuf-java-2.4.1-shaded.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\protobuf\protobuf-java\2.4.1-shaded\protobuf-java-2.4.1-shaded.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\uncommons\maths\uncommons-maths\1.2.2a\uncommons-maths-1.2.2a.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\uncommons\maths\uncommons-maths\1.2.2a\uncommons-maths-1.2.2a.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\akka\akka-slf4j_2.10\2.2.3-shaded-protobuf\akka-slf4j_2.10-2.2.3-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\akka\akka-slf4j_2.10\2.2.3-shaded-protobuf\akka-slf4j_2.10-2.2.3-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\json4s\json4s-jackson_2.10\3.2.10\json4s-jackson_2.10-3.2.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\json4s\json4s-jackson_2.10\3.2.10\json4s-jackson_2.10-3.2.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\fasterxml\jackson\core\jackson-databind\2.3.1\jackson-databind-2.3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\fasterxml\jackson\core\jackson-databind\2.3.1\jackson-databind-2.3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\fasterxml\jackson\core\jackson-annotations\2.3.0\jackson-annotations-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\fasterxml\jackson\core\jackson-annotations\2.3.0\jackson-annotations-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\fasterxml\jackson\core\jackson-core\2.3.1\jackson-core-2.3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\fasterxml\jackson\core\jackson-core\2.3.1\jackson-core-2.3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\colt\colt\1.2.0\colt-1.2.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\colt\colt\1.2.0\colt-1.2.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\concurrent\concurrent\1.3.4\concurrent-1.3.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\concurrent\concurrent\1.3.4\concurrent-1.3.4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\mesos\mesos\0.18.1\mesos-0.18.1-shaded-protobuf.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\mesos\mesos\0.18.1\mesos-0.18.1-shaded-protobuf.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\io\netty\netty-all\4.0.23.Final\netty-all-4.0.23.Final.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\io\netty\netty-all\4.0.23.Final\netty-all-4.0.23.Final.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\clearspring\analytics\stream\2.7.0\stream-2.7.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\clearspring\analytics\stream\2.7.0\stream-2.7.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-core\3.0.0\metrics-core-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-core\3.0.0\metrics-core-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-jvm\3.0.0\metrics-jvm-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-jvm\3.0.0\metrics-jvm-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-json\3.0.0\metrics-json-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-json\3.0.0\metrics-json-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\codahale\metrics\metrics-graphite\3.0.0\metrics-graphite-3.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\codahale\metrics\metrics-graphite\3.0.0\metrics-graphite-3.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\tachyonproject\tachyon-client\0.5.0\tachyon-client-0.5.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\tachyonproject\tachyon-client\0.5.0\tachyon-client-0.5.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\tachyonproject\tachyon\0.5.0\tachyon-0.5.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\tachyonproject\tachyon\0.5.0\tachyon-0.5.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\spark-project\pyrolite\2.0.1\pyrolite-2.0.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\spark-project\pyrolite\2.0.1\pyrolite-2.0.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\net\sf\py4j\py4j\0.8.2.1\py4j-0.8.2.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\net\sf\py4j\py4j\0.8.2.1\py4j-0.8.2.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\it\unimi\dsi\fastutil\6.4.4\fastutil-6.4.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\it\unimi\dsi\fastutil\6.4.4\fastutil-6.4.4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-avro\1.4.3\parquet-avro-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-avro\1.4.3\parquet-avro-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-column\1.4.3\parquet-column-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-column\1.4.3\parquet-column-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-common\1.4.3\parquet-common-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-common\1.4.3\parquet-common-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-encoding\1.4.3\parquet-encoding-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-encoding\1.4.3\parquet-encoding-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-generator\1.4.3\parquet-generator-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-generator\1.4.3\parquet-generator-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-hadoop\1.4.3\parquet-hadoop-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-hadoop\1.4.3\parquet-hadoop-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-jackson\1.4.3\parquet-jackson-1.4.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-jackson\1.4.3\parquet-jackson-1.4.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\twitter\parquet-format\2.0.0\parquet-format-2.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\twitter\parquet-format\2.0.0\parquet-format-2.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\seqdoop\hadoop-bam\7.0.0\hadoop-bam-7.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\seqdoop\hadoop-bam\7.0.0\hadoop-bam-7.0.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-cli\commons-cli\1.2\commons-cli-1.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-cli\commons-cli\1.2\commons-cli-1.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\seqdoop\cofoja\1.1-r150\cofoja-1.1-r150.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\seqdoop\cofoja\1.1-r150\cofoja-1.1-r150.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\seqdoop\htsjdk\1.118\htsjdk-1.118.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\seqdoop\htsjdk\1.118\htsjdk-1.118.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\ant\ant\1.8.2\ant-1.8.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\ant\ant\1.8.2\ant-1.8.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\ant\ant-launcher\1.8.2\ant-launcher-1.8.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\ant\ant-launcher\1.8.2\ant-launcher-1.8.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\bcel\bcel\5.2\bcel-5.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\bcel\bcel\5.2\bcel-5.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\jakarta-regexp\jakarta-regexp\1.4\jakarta-regexp-1.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\jakarta-regexp\jakarta-regexp\1.4\jakarta-regexp-1.4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\commons\commons-jexl\2.1.1\commons-jexl-2.1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\commons\commons-jexl\2.1.1\commons-jexl-2.1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\testng\testng\6.8.8\testng-6.8.8.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\testng\testng\6.8.8\testng-6.8.8.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\beanshell\bsh\2.0b4\bsh-2.0b4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\beanshell\bsh\2.0b4\bsh-2.0b4.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\beust\jcommander\1.27\jcommander-1.27.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\beust\jcommander\1.27\jcommander-1.27.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\httpcomponents\httpclient\4.3.2\httpclient-4.3.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\httpcomponents\httpclient\4.3.2\httpclient-4.3.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\apache\httpcomponents\httpcore\4.3.1\httpcore-4.3.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\apache\httpcomponents\httpcore\4.3.1\httpcore-4.3.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\commons-codec\commons-codec\1.6\commons-codec-1.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\commons-codec\commons-codec\1.6\commons-codec-1.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\netflix\servo\servo-core\0.5.5\servo-core-0.5.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\netflix\servo\servo-core\0.5.5\servo-core-0.5.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\google\code\findbugs\annotations\2.0.0\annotations-2.0.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\google\code\findbugs\annotations\2.0.0\annotations-2.0.0.jar
	[INFO] Installing artifact D:\all\idea\adam-adam-parent-0.14.0\adam-apis\target\adam-apis-0.14.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\adam\adam-apis\0.14.0\adam-apis-0.14.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\slf4j-log4j12\1.7.5\slf4j-log4j12-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\slf4j-log4j12\1.7.5\slf4j-log4j12-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\slf4j\slf4j-api\1.7.5\slf4j-api-1.7.5.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\slf4j\slf4j-api\1.7.5\slf4j-api-1.7.5.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\log4j\log4j\1.2.17\log4j-1.2.17.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\log4j\log4j\1.2.17\log4j-1.2.17.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\args4j\args4j\2.0.23\args4j-2.0.23.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\args4j\args4j\2.0.23\args4j-2.0.23.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\fusesource\scalate\scalate-core_2.10\1.6.1\scalate-core_2.10-1.6.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\fusesource\scalate\scalate-core_2.10\1.6.1\scalate-core_2.10-1.6.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\fusesource\scalate\scalate-util_2.10\1.6.1\scalate-util_2.10-1.6.1.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\fusesource\scalate\scalate-util_2.10\1.6.1\scalate-util_2.10-1.6.1.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scala-compiler\2.10.0\scala-compiler-2.10.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scala-compiler\2.10.0\scala-compiler-2.10.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\scalatra-json_2.10\2.3.0\scalatra-json_2.10-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\scalatra-json_2.10\2.3.0\scalatra-json_2.10-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\json4s\json4s-core_2.10\3.2.10\json4s-core_2.10-3.2.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\json4s\json4s-core_2.10\3.2.10\json4s-core_2.10-3.2.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\json4s\json4s-ast_2.10\3.2.10\json4s-ast_2.10-3.2.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\json4s\json4s-ast_2.10\3.2.10\json4s-ast_2.10-3.2.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scalap\2.10.0\scalap-2.10.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scalap\2.10.0\scalap-2.10.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\scalatra_2.10\2.3.0\scalatra_2.10-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\scalatra_2.10\2.3.0\scalatra_2.10-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\scalatra-common_2.10\2.3.0\scalatra-common_2.10-2.3.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\scalatra-common_2.10\2.3.0\scalatra-common_2.10-2.3.0.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\clapper\grizzled-slf4j_2.10\1.0.2\grizzled-slf4j_2.10-1.0.2.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\clapper\grizzled-slf4j_2.10\1.0.2\grizzled-slf4j_2.10-1.0.2.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scalatra\rl\rl_2.10\0.4.10\rl_2.10-0.4.10.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scalatra\rl\rl_2.10\0.4.10\rl_2.10-0.4.10.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\com\googlecode\juniversalchardet\juniversalchardet\1.0.3\juniversalchardet-1.0.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\com\googlecode\juniversalchardet\juniversalchardet\1.0.3\juniversalchardet-1.0.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\eu\medsea\mimeutil\mime-util\2.1.3\mime-util-2.1.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\eu\medsea\mimeutil\mime-util\2.1.3\mime-util-2.1.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\joda-time\joda-time\2.3\joda-time-2.3.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\joda-time\joda-time\2.3\joda-time-2.3.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\joda\joda-convert\1.6\joda-convert-1.6.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\joda\joda-convert\1.6\joda-convert-1.6.jar
	[INFO] Installing artifact D:\1win7\java\apache-maven-3.3.9-bin\Repository\org\scala-lang\scala-reflect\2.10.4\scala-reflect-2.10.4.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\scala-lang\scala-reflect\2.10.4\scala-reflect-2.10.4.jar
	[INFO] Installing artifact D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\adam-cli-0.14.0.jar to D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\appassembler\repo\org\bdgenomics\adam\adam-cli\0.14.0\adam-cli-0.14.0.jar
	[INFO] 
	[INFO] <<< maven-assembly-plugin:2.4.1:assembly (default) < package @ adam-cli <<<
	[INFO] 
	[INFO] --- maven-assembly-plugin:2.4.1:assembly (default) @ adam-cli ---
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/2.4.4/plexus-archiver-2.4.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/2.4.4/plexus-archiver-2.4.4.pom (4 KB at 6.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.0.10/plexus-io-2.0.10.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.0.10/plexus-io-2.0.10.pom (3 KB at 4.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.5/commons-compress-1.5.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.5/commons-compress-1.5.pom (11 KB at 5.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.2/xz-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.2/xz-1.2.pom (2 KB at 3.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.0.9/plexus-io-2.0.9.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.0.9/plexus-io-2.0.9.pom (3 KB at 4.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-repository-builder/1.0-alpha-2/maven-repository-builder-1.0-alpha-2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-repository-builder/1.0-alpha-2/maven-repository-builder-1.0-alpha-2.pom (4 KB at 6.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/1.0-alpha-1/maven-common-artifact-filters-1.0-alpha-1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-common-artifact-filters/1.0-alpha-1/maven-common-artifact-filters-1.0-alpha-1.pom (2 KB at 3.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-components/6/maven-shared-components-6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-components/6/maven-shared-components-6.pom (4 KB at 6.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/2.4.4/plexus-archiver-2.4.4.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.5/commons-compress-1.5.jar
	Downloading: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.2/xz-1.2.jar
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.0.9/plexus-io-2.0.9.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-repository-builder/1.0-alpha-2/maven-repository-builder-1.0-alpha-2.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-repository-builder/1.0-alpha-2/maven-repository-builder-1.0-alpha-2.jar (23 KB at 4.6 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-io/2.0.9/plexus-io-2.0.9.jar (58 KB at 11.7 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/tukaani/xz/1.2/xz-1.2.jar (93 KB at 18.1 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-archiver/2.4.4/plexus-archiver-2.4.4.jar (161 KB at 31.2 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/commons/commons-compress/1.5/commons-compress-1.5.jar (251 KB at 33.6 KB/sec)
	[INFO] Reading assembly descriptor: src/main/assembly/assembly.xml
	[INFO] Building tar: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\adam-cli-0.14.0-bin.tar.gz
	[WARNING] Entry: adam-cli-0.14.0/repo/com/fasterxml/jackson/core/jackson-annotations/2.3.0/jackson-annotations-2.3.0.jar longer than 100 characters.
	[WARNING] Resulting tar file can only be processed successfully by GNU compatible tar commands
	[WARNING] Entry: adam-cli-0.14.0/repo/com/googlecode/juniversalchardet/juniversalchardet/1.0.3/juniversalchardet-1.0.3.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/com/sun/jersey/jersey-test-framework/jersey-test-framework-core/1.9/jersey-test-framework-core-1.9.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/com/sun/jersey/jersey-test-framework/jersey-test-framework-grizzly2/1.9/jersey-test-framework-grizzly2-1.9.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-app/2.2.0/hadoop-mapreduce-client-app-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-common/2.2.0/hadoop-mapreduce-client-common-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-core/2.2.0/hadoop-mapreduce-client-core-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.2.0/hadoop-mapreduce-client-jobclient-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.2.0/hadoop-mapreduce-client-shuffle-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-yarn-server-common/2.2.0/hadoop-yarn-server-common-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-continuation/8.1.14.v20131031/jetty-continuation-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-security/8.1.14.v20131031/jetty-security-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-server/8.1.14.v20131031/jetty-server-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-servlet/8.1.14.v20131031/jetty-servlet-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-webapp/8.1.14.v20131031/jetty-webapp-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.activation/1.1.0.v201105071233/javax.activation-1.1.0.v201105071233.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.mail.glassfish/1.4.1.v201005082020/javax.mail.glassfish-1.4.1.v201005082020.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.servlet/3.0.0.v201112011016/javax.servlet-3.0.0.v201112011016.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.transaction/1.1.1.v201105210645/javax.transaction-1.1.1.v201105210645.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/glassfish/grizzly/grizzly-http-servlet/2.1.2/grizzly-http-servlet-2.1.2.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/akka/akka-actor_2.10/2.2.3-shaded-protobuf/akka-actor_2.10-2.2.3-shaded-protobuf.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/akka/akka-remote_2.10/2.2.3-shaded-protobuf/akka-remote_2.10-2.2.3-shaded-protobuf.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/akka/akka-slf4j_2.10/2.2.3-shaded-protobuf/akka-slf4j_2.10-2.2.3-shaded-protobuf.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/protobuf/protobuf-java/2.4.1-shaded/protobuf-java-2.4.1-shaded.jar longer than 100 characters.
	[INFO] Building tar: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\adam-cli-0.14.0-bin.tar.bz2
	[WARNING] Entry: adam-cli-0.14.0/repo/com/fasterxml/jackson/core/jackson-annotations/2.3.0/jackson-annotations-2.3.0.jar longer than 100 characters.
	[WARNING] Resulting tar file can only be processed successfully by GNU compatible tar commands
	[WARNING] Entry: adam-cli-0.14.0/repo/com/googlecode/juniversalchardet/juniversalchardet/1.0.3/juniversalchardet-1.0.3.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/com/sun/jersey/jersey-test-framework/jersey-test-framework-core/1.9/jersey-test-framework-core-1.9.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/com/sun/jersey/jersey-test-framework/jersey-test-framework-grizzly2/1.9/jersey-test-framework-grizzly2-1.9.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-app/2.2.0/hadoop-mapreduce-client-app-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-common/2.2.0/hadoop-mapreduce-client-common-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-core/2.2.0/hadoop-mapreduce-client-core-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.2.0/hadoop-mapreduce-client-jobclient-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.2.0/hadoop-mapreduce-client-shuffle-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/apache/hadoop/hadoop-yarn-server-common/2.2.0/hadoop-yarn-server-common-2.2.0.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-continuation/8.1.14.v20131031/jetty-continuation-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-security/8.1.14.v20131031/jetty-security-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-server/8.1.14.v20131031/jetty-server-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-servlet/8.1.14.v20131031/jetty-servlet-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/jetty-webapp/8.1.14.v20131031/jetty-webapp-8.1.14.v20131031.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.activation/1.1.0.v201105071233/javax.activation-1.1.0.v201105071233.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.mail.glassfish/1.4.1.v201005082020/javax.mail.glassfish-1.4.1.v201005082020.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.servlet/3.0.0.v201112011016/javax.servlet-3.0.0.v201112011016.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/eclipse/jetty/orbit/javax.transaction/1.1.1.v201105210645/javax.transaction-1.1.1.v201105210645.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/glassfish/grizzly/grizzly-http-servlet/2.1.2/grizzly-http-servlet-2.1.2.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/akka/akka-actor_2.10/2.2.3-shaded-protobuf/akka-actor_2.10-2.2.3-shaded-protobuf.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/akka/akka-remote_2.10/2.2.3-shaded-protobuf/akka-remote_2.10-2.2.3-shaded-protobuf.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/akka/akka-slf4j_2.10/2.2.3-shaded-protobuf/akka-slf4j_2.10-2.2.3-shaded-protobuf.jar longer than 100 characters.
	[WARNING] Entry: adam-cli-0.14.0/repo/org/spark-project/protobuf/protobuf-java/2.4.1-shaded/protobuf-java-2.4.1-shaded.jar longer than 100 characters.
	[INFO] Building zip: D:\all\idea\adam-adam-parent-0.14.0\adam-cli\target\adam-cli-0.14.0-bin.zip
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO] 
	[INFO] ADAM ............................................... SUCCESS [  9.609 s]
	[INFO] ADAM: Core ......................................... SUCCESS [03:13 min]
	[INFO] ADAM: APIs for Java ................................ SUCCESS [ 37.400 s]
	[INFO] ADAM: CLI .......................................... SUCCESS [14:31 min]
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 18:32 min
	[INFO] Finished at: 2016-06-09T19:49:42+08:00
	[INFO] Final Memory: 63M/594M
	[INFO] ------------------------------------------------------------------------
	
	Process finished with exit code 0
