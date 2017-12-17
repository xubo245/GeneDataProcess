	
1.下载：

	https://github.com/broadinstitute/picard.git
	
2.安装：

	hadoop@Master:~/xubo/tools/picard$ ant clone-htsjdk
	Buildfile: /home/hadoop/xubo/tools/picard/build.xml
	
	clone-htsjdk:
	     [exec] Cloning into 'htsjdk'...
	     [echo] Checking out HTSJDK tagged version [2.4.1]
	     [exec] Note: checking out '2.4.1'.
	     [exec] 
	     [exec] You are in 'detached HEAD' state. You can look around, make experimental
	     [exec] changes and commit them, and you can discard any commits you make in this
	     [exec] state without impacting any branches by performing another checkout.
	     [exec] 
	     [exec] If you want to create a new branch to retain commits you create, you may
	     [exec] do so (now or later) by using -b with the checkout command again. Example:
	     [exec] 
	     [exec]   git checkout -b new_branch_name
	     [exec] 
	     [exec] HEAD is now at 52df499... Merge pull request #615 from samtools/dr_disable_intel_gkl
	
	BUILD SUCCESSFUL
	Total time: 34 minutes 17 seconds
	hadoop@Master:~/xubo/tools/picard$ ant
	Buildfile: /home/hadoop/xubo/tools/picard/build.xml
	
	write-version-property:
	[propertyfile] Creating new property file: /home/hadoop/xubo/tools/picard/htsjdk/htsjdk.version.properties
	
	set-htsjdk-version:
	
	compile-htsjdk:
	     [exec] :compileJava FAILED
	     [exec] 
	     [exec] FAILURE: Build failed with an exception.
	     [exec] 
	     [exec] * What went wrong:
	     [exec] Execution failed for task ':compileJava'.
	     [exec] > invalid source release: 1.8
	     [exec] 
	     [exec] * Try:
	     [exec] Run with --stacktrace option to get the stack trace. Run with --info or --debug
	     [exec] BUILD FAILED
	     [exec] 
	     [exec] Total time: 26.918 secs
	     [exec]  option to get more log output.
	     [exec] Result: 1
	
	BUILD FAILED
	/home/hadoop/xubo/tools/picard/build.xml:174: /home/hadoop/xubo/tools/picard/htsjdk/build/libs does not exist.
	
	Total time: 47 seconds
	hadoop@Master:~/xubo/tools/picard$ 
