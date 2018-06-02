
更多代码请见：https://github.com/xubo245

基因数据处理系列

# 1.解释

由于要生成新的score matrix：blosum50，第一次使用静态方法，直接传给align，到时每次运行都需要进行一次score matrix的计算，而这个是将blosum50的矩阵转换成128*128的矩阵，当计算Q0,即8个字符串的query时，显然时间占比大，本来序列比对时间就不长，所以比sparkSW慢


# 2.代码：

优化：将静态方法传给静态矩阵，然后再给align方法，这样在类加载的时候静态矩阵就计算好的，多次调用的时候也就只计算了一次，而不需要每次都计算。

DSW:  ssw.SSW

# 3.结果：

	2.01611E+16	SparkSW	D1Line.fasta	0P18691.file	128	1	5	18.679		/xubo/project/SparkSW/output/time/20161127200906643SparkSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D1Line.fasta	0P18691.file	128	1	5	18.594		/xubo/project/SparkSW/output/time/20161127200931088SparkSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D1Line.fasta	0P18691.file	128	1	5	17.815		/xubo/project/SparkSW/output/time/20161127200955742SparkSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D1Line.fasta	0P18691.file	128	1	5	22.759		/xubo/project/SparkSW/output/time/20161127201019619SparkSWSSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D1Line.fasta	0P18691.file	128	1	5	22.801		/xubo/project/SparkSW/output/time/20161127201048357SparkSWSSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D1Line.fasta	0P18691.file	128	1	5	21.942		/xubo/project/SparkSW/output/time/20161127201117262SparkSWSSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D2Line.fasta	0P18691.file	128	1	5	25.162		/xubo/project/SparkSW/output/time/20161127201145181SparkSW_queryFile_0P18691.file_dbFile_D2Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D2Line.fasta	0P18691.file	128	1	5	24.905		/xubo/project/SparkSW/output/time/20161127201216281SparkSW_queryFile_0P18691.file_dbFile_D2Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D2Line.fasta	0P18691.file	128	1	5	24.998		/xubo/project/SparkSW/output/time/20161127201246764SparkSW_queryFile_0P18691.file_dbFile_D2Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D2Line.fasta	0P18691.file	128	1	5	33.404		/xubo/project/SparkSW/output/time/20161127201317724SparkSWSSW_queryFile_0P18691.file_dbFile_D2Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D2Line.fasta	0P18691.file	128	1	5	33.419		/xubo/project/SparkSW/output/time/20161127201357058SparkSWSSW_queryFile_0P18691.file_dbFile_D2Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D2Line.fasta	0P18691.file	128	1	5	33.071		/xubo/project/SparkSW/output/time/20161127201436498SparkSWSSW_queryFile_0P18691.file_dbFile_D2Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D3Line.fasta	0P18691.file	128	1	5	35.385		/xubo/project/SparkSW/output/time/20161127201515580SparkSW_queryFile_0P18691.file_dbFile_D3Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D3Line.fasta	0P18691.file	128	1	5	35.632		/xubo/project/SparkSW/output/time/20161127201557039SparkSW_queryFile_0P18691.file_dbFile_D3Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D3Line.fasta	0P18691.file	128	1	5	36.336		/xubo/project/SparkSW/output/time/20161127201638723SparkSW_queryFile_0P18691.file_dbFile_D3Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D3Line.fasta	0P18691.file	128	1	5	54.668		/xubo/project/SparkSW/output/time/20161127201720962SparkSWSSW_queryFile_0P18691.file_dbFile_D3Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D3Line.fasta	0P18691.file	128	1	5	54.857		/xubo/project/SparkSW/output/time/20161127201821633SparkSWSSW_queryFile_0P18691.file_dbFile_D3Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D3Line.fasta	0P18691.file	128	1	5	53.338		/xubo/project/SparkSW/output/time/20161127201922460SparkSWSSW_queryFile_0P18691.file_dbFile_D3Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D4Line.fasta	0P18691.file	128	1	5	45.174		/xubo/project/SparkSW/output/time/20161127202021797SparkSW_queryFile_0P18691.file_dbFile_D4Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D4Line.fasta	0P18691.file	128	1	5	42.346		/xubo/project/SparkSW/output/time/20161127202112921SparkSW_queryFile_0P18691.file_dbFile_D4Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D4Line.fasta	0P18691.file	128	1	5	44.676		/xubo/project/SparkSW/output/time/20161127202201329SparkSW_queryFile_0P18691.file_dbFile_D4Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D4Line.fasta	0P18691.file	128	1	5	66.426		/xubo/project/SparkSW/output/time/20161127202252059SparkSWSSW_queryFile_0P18691.file_dbFile_D4Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D4Line.fasta	0P18691.file	128	1	5	69.492		/xubo/project/SparkSW/output/time/20161127202405206SparkSWSSW_queryFile_0P18691.file_dbFile_D4Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D4Line.fasta	0P18691.file	128	1	5	67.195		/xubo/project/SparkSW/output/time/20161127202520291SparkSWSSW_queryFile_0P18691.file_dbFile_D4Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D5Line.fasta	0P18691.file	128	1	5	55.823		/xubo/project/SparkSW/output/time/20161127202633365SparkSW_queryFile_0P18691.file_dbFile_D5Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D5Line.fasta	0P18691.file	128	1	5	56.501		/xubo/project/SparkSW/output/time/20161127202735122SparkSW_queryFile_0P18691.file_dbFile_D5Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSW	D5Line.fasta	0P18691.file	128	1	5	55.71		/xubo/project/SparkSW/output/time/20161127202837220SparkSW_queryFile_0P18691.file_dbFile_D5Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D5Line.fasta	0P18691.file	128	1	5	102.413		/xubo/project/SparkSW/output/time/20161127202939014SparkSWSSW_queryFile_0P18691.file_dbFile_D5Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D5Line.fasta	0P18691.file	128	1	5	93.266		/xubo/project/SparkSW/output/time/20161127203127477SparkSWSSW_queryFile_0P18691.file_dbFile_D5Line.fasta_splitNum_128_taskNum_1_topK_5
	2.01611E+16	SparkSWSSW	D5Line.fasta	0P18691.file	128	1	5	104.084		/xubo/project/SparkSW/output/time/20161127203306305SparkSWSSW_queryFile_0P18691.file_dbFile_D5Line.fasta_splitNum_128_taskNum_1_topK_5


参考

	【1】https://github.com/xubo245
	【2】http://blog.csdn.net/xubo245/
