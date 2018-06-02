
project下的pom

```

	D:\1win7\java\jdk\bin\java "-Dmaven.home=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\plugins\maven\lib\maven3" "-Dclassworlds.conf=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\plugins\maven\lib\maven3\bin\m2.conf" -Didea.launcher.port=7535 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\plugins\maven\lib\maven3\boot\plexus-classworlds-2.4.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.codehaus.classworlds.Launcher -Didea.version=15.0.4 compile
	[INFO] Scanning for projects...
	[WARNING] 
	[WARNING] Some problems were encountered while building the effective model for cs.ucla.edu:cloud-scale-bwamem:jar:0.2.0
	[WARNING] 'dependencies.dependency.systemPath' for org.apache.spark:spark-core_${scala.artifact.suffix}:jar should use a variable instead of a hard-coded path D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar @ line 246, column 25
	[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-shade-plugin is missing. @ line 145, column 21
	[WARNING] 'build.plugins.plugin.version' for org.scala-tools:maven-scala-plugin is missing. @ line 89, column 21
	[WARNING] 'dependencies.dependency.exclusions.exclusion.artifactId' for org.apache.hadoop:hadoop-client:jar with value '*' does not match a valid id pattern. @ line 227, column 29
	[WARNING] 'dependencies.dependency.exclusions.exclusion.artifactId' for org.apache.hadoop:hadoop-client:jar with value '*' does not match a valid id pattern. @ line 231, column 29
	[WARNING] 
	[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
	[WARNING] 
	[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
	[WARNING] 
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Cloud-Scale-BWAMEM 0.2.0
	[INFO] ------------------------------------------------------------------------
	Downloading: http://scala-tools.org/repo-releases/org/scala-tools/maven-scala-plugin/maven-metadata.xml
	Downloading: http://scala-tools.org/repo-releases/org/apache/maven/plugins/maven-shade-plugin/maven-metadata.xml
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-column/1.4.3/parquet-column-1.4.3.pom
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-column/1.4.3/parquet-column-1.4.3.pom
	[WARNING] The POM for com.twitter:parquet-column:jar:1.4.3 is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.pom
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.pom
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.pom
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.pom (4 KB at 4.5 KB/sec)
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.pom (6 KB at 11.6 KB/sec)
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.pom
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.pom
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.pom
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.pom (3 KB at 5.7 KB/sec)
	Downloading: http://repo.akka.io/releases/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.pom
	Downloading: http://repo1.maven.org/maven2/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.pom (5 KB at 7.9 KB/sec)
	Downloading: http://repo.akka.io/releases/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.pom
	Downloading: http://repo1.maven.org/maven2/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.pom (8 KB at 11.6 KB/sec)
	Downloading: http://repo.akka.io/releases/org/bdgenomics/adam/adam-parent/0.14.0/adam-parent-0.14.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/bdgenomics/adam/adam-parent/0.14.0/adam-parent-0.14.0.pom
	Downloading: http://repo1.maven.org/maven2/org/bdgenomics/adam/adam-parent/0.14.0/adam-parent-0.14.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/bdgenomics/adam/adam-parent/0.14.0/adam-parent-0.14.0.pom (20 KB at 9.9 KB/sec)
	Downloading: http://repo.akka.io/releases/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.pom
	Downloading: http://scala-tools.org/repo-releases/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.pom
	[WARNING] The POM for org.scoverage:scalac-scoverage-plugin_2.10:jar:0.99.2 is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/org/apache/spark/spark-core_2.10/1.1.0/spark-core_2.10-1.1.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/apache/spark/spark-core_2.10/1.1.0/spark-core_2.10-1.1.0.pom
	Downloading: http://repo1.maven.org/maven2/org/apache/spark/spark-core_2.10/1.1.0/spark-core_2.10-1.1.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/apache/spark/spark-core_2.10/1.1.0/spark-core_2.10-1.1.0.pom (11 KB at 4.9 KB/sec)
	Downloading: http://repo.akka.io/releases/org/apache/spark/spark-parent/1.1.0/spark-parent-1.1.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/apache/spark/spark-parent/1.1.0/spark-parent-1.1.0.pom
	Downloading: http://repo1.maven.org/maven2/org/apache/spark/spark-parent/1.1.0/spark-parent-1.1.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/apache/spark/spark-parent/1.1.0/spark-parent-1.1.0.pom (40 KB at 26.4 KB/sec)
	Downloading: http://repo.akka.io/releases/org/slf4j/jul-to-slf4j/1.7.5/jul-to-slf4j-1.7.5.pom
	Downloading: http://scala-tools.org/repo-releases/org/slf4j/jul-to-slf4j/1.7.5/jul-to-slf4j-1.7.5.pom
	[WARNING] The POM for org.slf4j:jul-to-slf4j:jar:1.7.5 is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/org/slf4j/jcl-over-slf4j/1.7.5/jcl-over-slf4j-1.7.5.pom
	Downloading: http://scala-tools.org/repo-releases/org/slf4j/jcl-over-slf4j/1.7.5/jcl-over-slf4j-1.7.5.pom
	[WARNING] The POM for org.slf4j:jcl-over-slf4j:jar:1.7.5 is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/com/ning/compress-lzf/1.0.0/compress-lzf-1.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/ning/compress-lzf/1.0.0/compress-lzf-1.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/ning/compress-lzf/1.0.0/compress-lzf-1.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/ning/compress-lzf/1.0.0/compress-lzf-1.0.0.pom (8 KB at 14.1 KB/sec)
	Downloading: http://repo.akka.io/releases/org/xerial/snappy/snappy-java/1.0.5.3/snappy-java-1.0.5.3.pom
	Downloading: http://scala-tools.org/repo-releases/org/xerial/snappy/snappy-java/1.0.5.3/snappy-java-1.0.5.3.pom
	Downloading: http://repo1.maven.org/maven2/org/xerial/snappy/snappy-java/1.0.5.3/snappy-java-1.0.5.3.pom
	Downloaded: http://repo1.maven.org/maven2/org/xerial/snappy/snappy-java/1.0.5.3/snappy-java-1.0.5.3.pom (13 KB at 11.7 KB/sec)
	Downloading: http://repo.akka.io/releases/com/twitter/chill_2.10/0.3.6/chill_2.10-0.3.6.pom
	Downloading: http://scala-tools.org/repo-releases/com/twitter/chill_2.10/0.3.6/chill_2.10-0.3.6.pom
	Downloading: http://repo1.maven.org/maven2/com/twitter/chill_2.10/0.3.6/chill_2.10-0.3.6.pom
	Downloaded: http://repo1.maven.org/maven2/com/twitter/chill_2.10/0.3.6/chill_2.10-0.3.6.pom (3 KB at 4.8 KB/sec)
	Downloading: http://repo.akka.io/releases/com/twitter/chill-java/0.3.6/chill-java-0.3.6.pom
	Downloading: http://scala-tools.org/repo-releases/com/twitter/chill-java/0.3.6/chill-java-0.3.6.pom
	Downloading: http://repo1.maven.org/maven2/com/twitter/chill-java/0.3.6/chill-java-0.3.6.pom
	Downloaded: http://repo1.maven.org/maven2/com/twitter/chill-java/0.3.6/chill-java-0.3.6.pom (2 KB at 3.8 KB/sec)
	Downloading: http://repo.akka.io/releases/org/spark-project/akka/akka-remote_2.10/2.2.3-shaded-protobuf/akka-remote_2.10-2.2.3-shaded-protobuf.pom
	Downloading: http://scala-tools.org/repo-releases/org/spark-project/akka/akka-remote_2.10/2.2.3-shaded-protobuf/akka-remote_2.10-2.2.3-shaded-protobuf.pom
	Downloading: http://repo1.maven.org/maven2/org/spark-project/akka/akka-remote_2.10/2.2.3-shaded-protobuf/akka-remote_2.10-2.2.3-shaded-protobuf.pom
	Downloaded: http://repo1.maven.org/maven2/org/spark-project/akka/akka-remote_2.10/2.2.3-shaded-protobuf/akka-remote_2.10-2.2.3-shaded-protobuf.pom (4 KB at 7.1 KB/sec)
	Downloading: http://repo.akka.io/releases/org/spark-project/akka/akka-actor_2.10/2.2.3-shaded-protobuf/akka-actor_2.10-2.2.3-shaded-protobuf.pom
	Downloading: http://scala-tools.org/repo-releases/org/spark-project/akka/akka-actor_2.10/2.2.3-shaded-protobuf/akka-actor_2.10-2.2.3-shaded-protobuf.pom
	Downloading: http://repo1.maven.org/maven2/org/spark-project/akka/akka-actor_2.10/2.2.3-shaded-protobuf/akka-actor_2.10-2.2.3-shaded-protobuf.pom
	Downloaded: http://repo1.maven.org/maven2/org/spark-project/akka/akka-actor_2.10/2.2.3-shaded-protobuf/akka-actor_2.10-2.2.3-shaded-protobuf.pom (2 KB at 3.7 KB/sec)
	Downloading: http://repo.akka.io/releases/com/typesafe/config/1.0.2/config-1.0.2.pom
	[WARNING] The POM for com.typesafe:config:jar:1.0.2 is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/org/spark-project/protobuf/protobuf-java/2.4.1-shaded/protobuf-java-2.4.1-shaded.pom
	[WARNING] The POM for org.spark-project.protobuf:protobuf-java:jar:2.4.1-shaded is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/org/spark-project/akka/akka-slf4j_2.10/2.2.3-shaded-protobuf/akka-slf4j_2.10-2.2.3-shaded-protobuf.pom
	Downloading: http://scala-tools.org/repo-releases/org/spark-project/akka/akka-slf4j_2.10/2.2.3-shaded-protobuf/akka-slf4j_2.10-2.2.3-shaded-protobuf.pom
	Downloading: http://repo1.maven.org/maven2/org/spark-project/akka/akka-slf4j_2.10/2.2.3-shaded-protobuf/akka-slf4j_2.10-2.2.3-shaded-protobuf.pom
	Downloaded: http://repo1.maven.org/maven2/org/spark-project/akka/akka-slf4j_2.10/2.2.3-shaded-protobuf/akka-slf4j_2.10-2.2.3-shaded-protobuf.pom (3 KB at 4.7 KB/sec)
	Downloading: http://repo.akka.io/releases/colt/colt/1.2.0/colt-1.2.0.pom
	Downloading: http://scala-tools.org/repo-releases/colt/colt/1.2.0/colt-1.2.0.pom
	[WARNING] The POM for colt:colt:jar:1.2.0 is missing, no dependency information available
	Downloading: http://repo.akka.io/releases/org/apache/mesos/mesos/0.18.1/mesos-0.18.1.pom
	Downloading: http://scala-tools.org/repo-releases/org/apache/mesos/mesos/0.18.1/mesos-0.18.1.pom
	Downloading: http://repo1.maven.org/maven2/org/apache/mesos/mesos/0.18.1/mesos-0.18.1.pom
	Downloaded: http://repo1.maven.org/maven2/org/apache/mesos/mesos/0.18.1/mesos-0.18.1.pom (8 KB at 9.8 KB/sec)
	Downloading: http://repo.akka.io/releases/com/codahale/metrics/metrics-core/3.0.0/metrics-core-3.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/codahale/metrics/metrics-core/3.0.0/metrics-core-3.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-core/3.0.0/metrics-core-3.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-core/3.0.0/metrics-core-3.0.0.pom (845 B at 1.6 KB/sec)
	Downloading: http://repo.akka.io/releases/com/codahale/metrics/metrics-parent/3.0.0/metrics-parent-3.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/codahale/metrics/metrics-parent/3.0.0/metrics-parent-3.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-parent/3.0.0/metrics-parent-3.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-parent/3.0.0/metrics-parent-3.0.0.pom (10 KB at 4.8 KB/sec)
	Downloading: http://repo.akka.io/releases/com/codahale/metrics/metrics-jvm/3.0.0/metrics-jvm-3.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/codahale/metrics/metrics-jvm/3.0.0/metrics-jvm-3.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-jvm/3.0.0/metrics-jvm-3.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-jvm/3.0.0/metrics-jvm-3.0.0.pom (965 B at 1.8 KB/sec)
	Downloading: http://repo.akka.io/releases/com/codahale/metrics/metrics-json/3.0.0/metrics-json-3.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/codahale/metrics/metrics-json/3.0.0/metrics-json-3.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-json/3.0.0/metrics-json-3.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-json/3.0.0/metrics-json-3.0.0.pom (2 KB at 2.6 KB/sec)
	Downloading: http://repo.akka.io/releases/com/fasterxml/jackson/core/jackson-databind/2.2.2/jackson-databind-2.2.2.pom
	Downloading: http://scala-tools.org/repo-releases/com/fasterxml/jackson/core/jackson-databind/2.2.2/jackson-databind-2.2.2.pom
	Downloading: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.2.2/jackson-databind-2.2.2.pom
	Downloaded: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.2.2/jackson-databind-2.2.2.pom (6 KB at 10.0 KB/sec)
	Downloading: http://repo.akka.io/releases/com/fasterxml/jackson/core/jackson-annotations/2.2.2/jackson-annotations-2.2.2.pom
	Downloading: http://scala-tools.org/repo-releases/com/fasterxml/jackson/core/jackson-annotations/2.2.2/jackson-annotations-2.2.2.pom
	Downloading: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.2.2/jackson-annotations-2.2.2.pom
	Downloaded: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.2.2/jackson-annotations-2.2.2.pom (2 KB at 2.4 KB/sec)
	Downloading: http://repo.akka.io/releases/com/fasterxml/jackson/core/jackson-core/2.2.2/jackson-core-2.2.2.pom
	Downloading: http://scala-tools.org/repo-releases/com/fasterxml/jackson/core/jackson-core/2.2.2/jackson-core-2.2.2.pom
	Downloading: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.2.2/jackson-core-2.2.2.pom
	Downloaded: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.2.2/jackson-core-2.2.2.pom (6 KB at 11.2 KB/sec)
	Downloading: http://repo.akka.io/releases/com/codahale/metrics/metrics-graphite/3.0.0/metrics-graphite-3.0.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/codahale/metrics/metrics-graphite/3.0.0/metrics-graphite-3.0.0.pom
	Downloading: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-graphite/3.0.0/metrics-graphite-3.0.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/codahale/metrics/metrics-graphite/3.0.0/metrics-graphite-3.0.0.pom (936 B at 1.8 KB/sec)
	Downloading: http://repo.akka.io/releases/org/tachyonproject/tachyon-client/0.5.0/tachyon-client-0.5.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/tachyonproject/tachyon-client/0.5.0/tachyon-client-0.5.0.pom
	Downloading: http://repo1.maven.org/maven2/org/tachyonproject/tachyon-client/0.5.0/tachyon-client-0.5.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/tachyonproject/tachyon-client/0.5.0/tachyon-client-0.5.0.pom (4 KB at 6.5 KB/sec)
	Downloading: http://repo.akka.io/releases/org/tachyonproject/tachyon-parent/0.5.0/tachyon-parent-0.5.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/tachyonproject/tachyon-parent/0.5.0/tachyon-parent-0.5.0.pom
	Downloading: http://repo1.maven.org/maven2/org/tachyonproject/tachyon-parent/0.5.0/tachyon-parent-0.5.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/tachyonproject/tachyon-parent/0.5.0/tachyon-parent-0.5.0.pom (5 KB at 9.6 KB/sec)
	Downloading: http://repo.akka.io/releases/org/tachyonproject/tachyon/0.5.0/tachyon-0.5.0.pom
	Downloading: http://scala-tools.org/repo-releases/org/tachyonproject/tachyon/0.5.0/tachyon-0.5.0.pom
	Downloading: http://repo1.maven.org/maven2/org/tachyonproject/tachyon/0.5.0/tachyon-0.5.0.pom
	Downloaded: http://repo1.maven.org/maven2/org/tachyonproject/tachyon/0.5.0/tachyon-0.5.0.pom (14 KB at 17.5 KB/sec)
	Downloading: http://repo.akka.io/releases/org/slf4j/slf4j-log4j12/1.7.2/slf4j-log4j12-1.7.2.pom
	Downloading: http://scala-tools.org/repo-releases/org/slf4j/slf4j-log4j12/1.7.2/slf4j-log4j12-1.7.2.pom
	Downloading: http://repo1.maven.org/maven2/org/slf4j/slf4j-log4j12/1.7.2/slf4j-log4j12-1.7.2.pom
	Downloaded: http://repo1.maven.org/maven2/org/slf4j/slf4j-log4j12/1.7.2/slf4j-log4j12-1.7.2.pom (2 KB at 3.1 KB/sec)
	Downloading: http://repo.akka.io/releases/com/fasterxml/jackson/core/jackson-databind/2.3.0/jackson-databind-2.3.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/fasterxml/jackson/core/jackson-databind/2.3.0/jackson-databind-2.3.0.pom
	Downloading: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.3.0/jackson-databind-2.3.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.3.0/jackson-databind-2.3.0.pom (6 KB at 10.0 KB/sec)
	Downloading: http://repo.akka.io/releases/com/fasterxml/jackson/core/jackson-core/2.3.0/jackson-core-2.3.0.pom
	Downloading: http://scala-tools.org/repo-releases/com/fasterxml/jackson/core/jackson-core/2.3.0/jackson-core-2.3.0.pom
	Downloading: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.3.0/jackson-core-2.3.0.pom
	Downloaded: http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.3.0/jackson-core-2.3.0.pom (6 KB at 8.3 KB/sec)
	Downloading: http://repo.akka.io/releases/org/spark-project/pyrolite/2.0.1/pyrolite-2.0.1.pom
	Downloading: http://scala-tools.org/repo-releases/org/spark-project/pyrolite/2.0.1/pyrolite-2.0.1.pom
	Downloading: http://repo1.maven.org/maven2/org/spark-project/pyrolite/2.0.1/pyrolite-2.0.1.pom
	Downloaded: http://repo1.maven.org/maven2/org/spark-project/pyrolite/2.0.1/pyrolite-2.0.1.pom (2 KB at 1.8 KB/sec)
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-avro/1.4.3/parquet-avro-1.4.3.jar
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-column/1.4.3/parquet-column-1.4.3.jar
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.jar
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.jar
	Downloading: http://repo.akka.io/releases/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.jar
	Downloading: http://repo.akka.io/releases/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.jar
	Downloading: http://repo.akka.io/releases/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.jar
	Downloading: http://repo.akka.io/releases/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.jar
	Downloading: http://repo.akka.io/releases/org/slf4j/slf4j-log4j12/1.7.5/slf4j-log4j12-1.7.5.jar
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-avro/1.4.3/parquet-avro-1.4.3.jar
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-column/1.4.3/parquet-column-1.4.3.jar
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.jar
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.jar
	Downloading: http://scala-tools.org/repo-releases/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.jar
	Downloading: http://scala-tools.org/repo-releases/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.jar
	Downloading: http://scala-tools.org/repo-releases/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.jar
	Downloading: http://scala-tools.org/repo-releases/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.jar
	Downloading: http://scala-tools.org/repo-releases/org/slf4j/slf4j-log4j12/1.7.5/slf4j-log4j12-1.7.5.jar
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-avro/1.4.3/parquet-avro-1.4.3.jar
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-column/1.4.3/parquet-column-1.4.3.jar
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.jar
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.jar
	Downloading: http://repo1.maven.org/maven2/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.jar
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-avro/1.4.3/parquet-avro-1.4.3.jar (41 KB at 27.5 KB/sec)
	Downloading: http://repo1.maven.org/maven2/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.jar
	Downloaded: http://repo1.maven.org/maven2/org/bdgenomics/bdg-formats/bdg-formats/0.2.0/bdg-formats-0.2.0.jar (102 KB at 34.0 KB/sec)
	Downloading: http://repo1.maven.org/maven2/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.jar
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-hadoop/1.4.3/parquet-hadoop-1.4.3.jar (154 KB at 10.7 KB/sec)
	Downloading: http://repo1.maven.org/maven2/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.jar
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-format/2.0.0/parquet-format-2.0.0.jar (461 KB at 30.9 KB/sec)
	Downloading: http://repo1.maven.org/maven2/org/slf4j/slf4j-log4j12/1.7.5/slf4j-log4j12-1.7.5.jar
	Downloaded: http://repo1.maven.org/maven2/org/slf4j/slf4j-log4j12/1.7.5/slf4j-log4j12-1.7.5.jar (9 KB at 5.5 KB/sec)
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-column/1.4.3/parquet-column-1.4.3.jar (708 KB at 36.0 KB/sec)
	Downloaded: http://repo1.maven.org/maven2/org/scoverage/scalac-scoverage-plugin_2.10/0.99.2/scalac-scoverage-plugin_2.10-0.99.2.jar (210 KB at 31.8 KB/sec)
	Downloaded: http://repo1.maven.org/maven2/com/twitter/parquet-jackson/1.4.3/parquet-jackson-1.4.3.jar (1005 KB at 26.5 KB/sec)
	Downloaded: http://repo1.maven.org/maven2/org/bdgenomics/adam/adam-core/0.14.0/adam-core-0.14.0.jar (2074 KB at 45.0 KB/sec)
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:schema (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:protocol (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- avro-maven-plugin:1.7.6:idl-protocol (default) @ cloud-scale-bwamem ---
	[INFO] 
	[INFO] --- maven-resources-plugin:2.5:resources (default-resources) @ cloud-scale-bwamem ---
	[debug] execute contextualize
	[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
	[INFO] skip non existing resourceDirectory D:\all\idea\cloud-scale-bwamem-0.2.1\src\main\resources
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (default) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.0 requires scala version: 2.10.4
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.4
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] D:\all\idea\cloud-scale-bwamem-0.2.1\src\main\java:-1: info: compiling
	[INFO] D:\all\idea\cloud-scale-bwamem-0.2.1\src\main\scala:-1: info: compiling
	[INFO] Compiling 77 source files to D:\all\idea\cloud-scale-bwamem-0.2.1\target\classes at 1464961627035
	[WARNING] warning: there were 22 deprecation warning(s); re-run with -deprecation for details
	[WARNING] warning: there were 1 feature warning(s); re-run with -feature for details
	[WARNING] two warnings found
	[INFO] prepare-compile in 0 s
	[INFO] compile in 88 s
	[INFO] 
	[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ cloud-scale-bwamem ---
	[INFO] Changes detected - recompiling the module!
	[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
	[INFO] Compiling 8 source files to D:\all\idea\cloud-scale-bwamem-0.2.1\target\classes
	[INFO] 
	[INFO] --- maven-scala-plugin:2.15.2:compile (compile) @ cloud-scale-bwamem ---
	[INFO] Checking for multiple versions of scala
	[WARNING]  Expected all dependencies to require Scala version: 2.10.4
	[WARNING]  cs.ucla.edu:cloud-scale-bwamem:0.2.0 requires scala version: 2.10.4
	[WARNING]  org.scoverage:scalac-scoverage-plugin_2.10:0.99.2 requires scala version: 2.10.4
	[WARNING]  org.bdgenomics.adam:adam-core:0.14.0 requires scala version: 2.10.3
	[WARNING] Multiple versions of scala libraries detected!
	[INFO] includes = [**/*.scala,**/*.java,]
	[INFO] excludes = []
	[INFO] Nothing to compile - all classes are up to date
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 4:36.543s
	[INFO] Finished at: Fri Jun 03 21:48:51 CST 2016
	[INFO] Final Memory: 34M/380M
	[INFO] ------------------------------------------------------------------------
	
	Process finished with exit code 0

```