
更多代码请见：https://github.com/xubo245

基因数据处理系列

# 1.解释

RT,但是顺序一致


# 2.代码：

	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ vi sparkSWSSWQ10.sh 
	
	dir=$(ls -l query/* |awk '!/^d/ {print $NF}' |grep -i '/[9-9]' )
	for i in 1 2 3 4 5 6 7 8 9 10
	do
	echo 'SparkSW:'
	#for j in 1 2 3 4 5 6 7 8 9 10
	for j in 1 2 3
	do
	        echo 'time:'$j
	        y='/xubo/project/SparkSW/input/D'$i'Line.fasta'
	        for file in $dir
	         do
	                sh test.sh 8G /xubo/project/SparkSW/hash50.csv $file $y 128 1 5
	        done
	done
	
	echo 'SSW'
	#for j in 1 2 3 4 5 6 7 8 9 10
	for j in 1 2 3
	do
	
	        echo 'time:'$j
	
	        y2='/xubo/project/SparkSW/input/D'$i'Line.fasta'
	        #y2='alluxio://Master:19998/xubo/project/SparkSW/input/D'$i'Line.fasta'
	         for file in $dir
	         do
	                sh testSSW.sh 8G /xubo/project/SparkSW/hash50.csv $file $y2 128 1 5
	        done
	done
	done


# 3.结果：

	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f sparkSWSSWQ10time201611271348.txt 
	SparkSW:
	time:1
	(9363,UniRef100_A1CLY8)                                                         
	time:2
	(9363,UniRef100_A1CLY8)                                                         
	time:3
	(268435464,UniRef100_Q5AWI5)                                                     
	(9363,UniRef100_A1CLY8)
	SSW
	time:1
	(9588,UniRef100_A1CLY8)                                                         
	time:2
	(9588,UniRef100_A1CLY8)                                                         
	time:3
	(9588,UniRef100_A1CLY8)                                                         
	16/11/27 14:45:28 WARN QueuedThreadPool: 3 threads could not be stopped
	SparkSW:
	time:1
	(9363,UniRef100_A1CLY8)                                                         
	(7756,UniRef100_S0EEY3)
	(7695,UniRef100_W7MLD7)
	time:2
	(9363,UniRef100_A1CLY8)                                                         
	(7756,UniRef100_S0EEY3)
	(7695,UniRef100_W7MLD7)
	time:3
	(9363,UniRef100_A1CLY8)                                                         
	(7756,UniRef100_S0EEY3)
	(7695,UniRef100_W7MLD7)
	SSW
	time:1
	(9588,UniRef100_A1CLY8)                                                         
	(8014,UniRef100_S0EEY3)
	(7958,UniRef100_W7MLD7)
	time:2
	(9588,UniRef100_A1CLY8)                                                         
	(8014,UniRef100_S0EEY3)
	(7958,UniRef100_W7MLD7)
	time:3
	(9588,UniRef100_A1CLY8)                                                         
	(8014,UniRef100_S0EEY3)
	(7958,UniRef100_W7MLD7)
	SparkSW:
	time:1
	(268435461,UniRef100_B1YQQ1)                                                    
	(9363,UniRef100_A1CLY8)
	(7756,UniRef100_S0EEY3)
	(7695,UniRef100_W7MLD7)
	(6660,UniRef100_Q4WAZ9)
	time:2
	(268435455,UniRef100_Q48ME3)                                                    
	(9363,UniRef100_A1CLY8)
	(7756,UniRef100_S0EEY3)
	(7695,UniRef100_W7MLD7)
	(6660,UniRef100_Q4WAZ9)
	time:3
	(9363,UniRef100_A1CLY8)                                                         
	(7756,UniRef100_S0EEY3)
	(7695,UniRef100_W7MLD7)
	(6660,UniRef100_Q4WAZ9)
	(5404,UniRef100_Q0C8M3)
	SSW
	time:1
	(9588,UniRef100_A1CLY8)                                                         
	(8014,UniRef100_S0EEY3)
	(7958,UniRef100_W7MLD7)
	(6905,UniRef100_Q4WAZ9)
	(5620,UniRef100_Q0C8M3)
	time:2
	(9588,UniRef100_A1CLY8)                                                         
	(8014,UniRef100_S0EEY3)
	(7958,UniRef100_W7MLD7)
	(6905,UniRef100_Q4WAZ9)
	(5620,UniRef100_Q0C8M3)
	time:3
	(9588,UniRef100_A1CLY8)                                                         
	(8014,UniRef100_S0EEY3)
	(7958,UniRef100_W7MLD7)
	(6905,UniRef100_Q4WAZ9)
	(5620,UniRef100_Q0C8M3)


参考

	【1】https://github.com/xubo245
	【2】http://blog.csdn.net/xubo245/
