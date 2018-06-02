	
更多代码请见：https://github.com/xubo245
	
基因数据处理系列
	
# 1.解释
	
SSW的评分矩阵是128*128的，是按char的int值来进行计算的。而blosum50是蛋白质的，而且不是按ABC顺序来的，所以需要转换。

java中无法运行128*128的String矩阵，所以需要提供blosum的转换
	
# 2.代码：
	
	    public static int[][] blosum50() {
	        int[][] a = {
	
	        };
	        return a;
	    }
	
	    public static int[][] blosum50(String[][] strArr) {
	        int[][] result = new int[128][128];
	
	        int m = strArr.length;
	        int n = strArr[0].length;
	
	        for (int i = 0;i< result.length;i++) {
	            for (int j = 0;j<  result[i].length;j++) {
	                result[i][j] = Integer.valueOf(strArr[m - 1][n - 1]);
	            }
	        }
	        for (int i = 0 ;i< m;i++) {
	             char c = strArr[i][0].charAt(0);
	            for (int j = 0 ;j<  result.length;j++) {
	                result[Integer.valueOf(c)][j] = Integer.valueOf(strArr[i][strArr[i].length - 1]);
	                result[j][Integer.valueOf(c)] = Integer.valueOf(strArr[i][strArr[i].length - 1]);
	            }
	        }
	
	        //    println(result(0)(0))
	        for (int i = 0 ;i< m;i++) {
	            char strI = strArr[i][0].charAt(0);
	            //       strArr(i)(0).toCharArray
	
	            int valueI = Integer.valueOf(strArr[i][0].charAt(0));
	            //      println(strI + "=" + valueI + "=" + strArr(i)(0).charAt(0).toInt)
	
	            for (int j = 1 ;j< n;j++) {
	
	                int valueJ =Integer.valueOf(strArr[j - 1][0].charAt(0));
	                int tmp = Integer.valueOf(strArr[i][j]);
	                result[valueI][valueJ] = tmp;
	                //        arr(value)(j)
	
	            }
	        }
	
	        //println(result(0)(0))
	        return result;
	    }
	    public static String[][] blosum50Base() {
	        String[][] a = {
	                {"A","5","-2","-1","-2","-1","-1","-1","0","-2","-1","-2","-1","-1","-3","-1","1","0","-3","-2","0","-2","-2","-1","-1","-5"},
	                {"R","-2","7","-1","-2","-4","1","0","-3","0","-4","-3","3","-2","-3","-3","-1","-1","-3","-1","-3","-1","-3","0","-1","-5"},
	                {"N","-1","-1","7","2","-2","0","0","0","1","-3","-4","0","-2","-4","-2","1","0","-4","-2","-3","5","-4","0","-1","-5"},
	                {"D","-2","-2","2","8","-4","0","2","-1","-1","-4","-4","-1","-4","-5","-1","0","-1","-5","-3","-4","6","-4","1","-1","-5"},
	                {"C","-1","-4","-2","-4","13","-3","-3","-3","-3","-2","-2","-3","-2","-2","-4","-1","-1","-5","-3","-1","-3","-2","-3","-1","-5"},
	                {"Q","-1","1","0","0","-3","7","2","-2","1","-3","-2","2","0","-4","-1","0","-1","-1","-1","-3","0","-3","4","-1","-5"},
	                {"E","-1","0","0","2","-3","2","6","-3","0","-4","-3","1","-2","-3","-1","-1","-1","-3","-2","-3","1","-3","5","-1","-5"},
	                {"G","0","-3","0","-1","-3","-2","-3","8","-2","-4","-4","-2","-3","-4","-2","0","-2","-3","-3","-4","-1","-4","-2","-1","-5"},
	                {"H","-2","0","1","-1","-3","1","0","-2","10","-4","-3","0","-1","-1","-2","-1","-2","-3","2","-4","0","-3","0","-1","-5"},
	                {"I","-1","-4","-3","-4","-2","-3","-4","-4","-4","5","2","-3","2","0","-3","-3","-1","-3","-1","4","-4","4","-3","-1","-5"},
	                {"L","-2","-3","-4","-4","-2","-2","-3","-4","-3","2","5","-3","3","1","-4","-3","-1","-2","-1","1","-4","4","-3","-1","-5"},
	                {"K","-1","3","0","-1","-3","2","1","-2","0","-3","-3","6","-2","-4","-1","0","-1","-3","-2","-3","0","-3","1","-1","-5"},
	                {"M","-1","-2","-2","-4","-2","0","-2","-3","-1","2","3","-2","7","0","-3","-2","-1","-1","0","1","-3","2","-1","-1","-5"},
	                {"F","-3","-3","-4","-5","-2","-4","-3","-4","-1","0","1","-4","0","8","-4","-3","-2","1","4","-1","-4","1","-4","-1","-5"},
	                {"P","-1","-3","-2","-1","-4","-1","-1","-2","-2","-3","-4","-1","-3","-4","10","-1","-1","-4","-3","-3","-2","-3","-1","-1","-5"},
	                {"S","1","-1","1","0","-1","0","-1","0","-1","-3","-3","0","-2","-3","-1","5","2","-4","-2","-2","0","-3","0","-1","-5"},
	                {"T","0","-1","0","-1","-1","-1","-1","-2","-2","-1","-1","-1","-1","-2","-1","2","5","-3","-2","0","0","-1","-1","-1","-5"},
	                {"W","-3","-3","-4","-5","-5","-1","-3","-3","-3","-3","-2","-3","-1","1","-4","-4","-3","15","2","-3","-5","-2","-2","-1","-5"},
	                {"Y","-2","-1","-2","-3","-3","-1","-2","-3","2","-1","-1","-2","0","4","-3","-2","-2","2","8","-1","-3","-1","-2","-1","-5"},
	                {"V","0","-3","-3","-4","-1","-3","-3","-4","-4","4","1","-3","1","-1","-3","-2","0","-3","-1","5","-3","2","-3","-1","-5"},
	                {"B","-2","-1","5","6","-3","0","1","-1","0","-4","-4","0","-3","-4","-2","0","0","-5","-3","-3","6","-4","1","-1","-5"},
	                {"J","-2","-3","-4","-4","-2","-3","-3","-4","-3","4","4","-3","2","1","-3","-3","-1","-2","-1","2","-4","4","-3","-1","-5"},
	                {"Z","-1","0","0","1","-3","4","5","-2","0","-3","-3","1","-1","-4","-1","0","-1","-2","-2","-3","1","-3","5","-1","-5"},
	                {"X","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-1","-5"},
	                {"*","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","-5","1"}
	        };
	        return a;
	    }
	
blosum50来源于https://www.ncbi.nlm.nih.gov/IEB/ToolBox/C_DOC/lxr/source/data/BLOSUM50

# 3.结果：
调整后与SparkSW运行基本一致，但是ref Data比较大时会不同，比如：待分析原因解决

	SparkSSW
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)

## 记录
	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f sparkSWSSWtime201611270135.txt 
	SparkSW:
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 01:49:22 WARN QueuedThreadPool: 1 threads could not be stopped
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 01:51:26 WARN QueuedThreadPool: 4 threads could not be stopped
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	SparkSW:
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 02:19:43 WARN QueuedThreadPool: 2 threads could not be stopped
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 02:25:02 WARN QueuedThreadPool: 2 threads could not be stopped
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 02:25:48 WARN QueuedThreadPool: 5 threads could not be stopped
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	SparkSW:
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 03:12:40 WARN QueuedThreadPool: 2 threads could not be stopped
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 03:15:08 WARN QueuedThreadPool: 4 threads could not be stopped
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 03:16:24 WARN QueuedThreadPool: 1 threads could not be stopped
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 03:20:13 WARN QueuedThreadPool: 2 threads could not be stopped
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	16/11/27 03:22:45 WARN QueuedThreadPool: 4 threads could not be stopped
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	SparkSW:
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	SparkSW:
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	SparkSW:
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(295,UniRef100_Q91FP2)
	SSW
	time:1
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:2
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:3
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:4
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:5
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:6
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:7
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:8
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	time:9
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	16/11/27 12:57:11 WARN QueuedThreadPool: 1 threads could not be stopped
	time:10
	(1734,UniRef100_Q6GZX4)                                                         
	(335,UniRef100_Q91FP2)
	(291,UniRef100_Q196Y1)
	SparkSW:
	time:1
	[Stage 1:====================================>                  (86 + 16) / 128]Exception in thread "main" org.apache.spark.SparkException: Job cancelled because SparkContext was shut down
	
参考
	
		【1】https://github.com/xubo245
		【2】http://blog.csdn.net/xubo245/
