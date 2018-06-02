
更多代码请见：https://github.com/xubo245

基因数据处理系列

# 1.解释

测试自带Example：

	xubo@xubo:~/xubo/tools/Complete-Striped-Smith-Waterman-Library/src$ scala  -Djava.library.path=. -cp SparkSW.jar ssw.Example
	Aligning nucleotides
	score1=21 score2=8 ref_begin1=8 ref_end1=21 read_begin1=0 read_end1=14 ref_end2=4 cigar=9M1I5M 

但是有时候需要自己写或者调用

# 2.代码：

自己写java调用

	package ssw;
	
	/**
	 * Created by xubo on 2016/11/24.
	 */
	public class SSWRun {
	    public static void main(String[] args) {
	        try {
	            System.loadLibrary("sswjni");
	        } catch (UnsatisfiedLinkError e) {
	            System.out.println(String.format("Cannot find libsswjni.so. Has the library been built and LD_LIBRARY_PATH or -Djava.library.path set appropriately?\n%s", e));
	            throw e;
	        }
	
	        int[][] score = new int[128][128];
	        for (int i = 0; i < 128; i++) {
	            for (int j = 0; j < 128; j++) {
	                if (i == j) score[i][j] = 2;
	                else score[i][j] = -2;
	            }
	        }
	        System.out.println("Aligning nucleotides");
	        Alignment aln = Aligner.align(args[0].getBytes(), args[1].getBytes(), score, 3, 1, true);
	//        Alignment aln = Aligner.align("CTGAGCCGGTAAATC".getBytes(), "CAGCCTTTCTGACCCGGAAATCAAAATAGGCACAACAAA".getBytes(), score, 3, 1, true);
	        if (aln == null) {
	            throw new RuntimeException();
	        }
	        System.out.print(String.format("score1=%d ", aln.score1));
	        System.out.print(String.format("score2=%d ", aln.score2));
	        System.out.print(String.format("ref_begin1=%d ", aln.ref_begin1));
	        System.out.print(String.format("ref_end1=%d ", aln.ref_end1));
	        System.out.print(String.format("read_begin1=%d ", aln.read_begin1));
	        System.out.print(String.format("read_end1=%d ", aln.read_end1));
	        System.out.print(String.format("ref_end2=%d ", aln.ref_end2));
	        System.out.print(String.format("cigar=%s ", aln.cigar));
	        System.out.println();
	
	    }
	}
	


# 3.结果：

	xubo@xubo:~/xubo/tools/Complete-Striped-Smith-Waterman-Library/src$ scala  -Djava.library.path=. -cp SparkSW.jar ssw.SSWRun A A
	Aligning nucleotides
	score1=2 score2=0 ref_begin1=0 ref_end1=0 read_begin1=0 read_end1=0 ref_end2=0 cigar=1M 
	xubo@xubo:~/xubo/tools/Complete-Striped-Smith-Waterman-Library/src$ scala  -Djava.library.path=. -cp SparkSW.jar ssw.SSWRun AB A
	Aligning nucleotides
	score1=2 score2=0 ref_begin1=0 ref_end1=0 read_begin1=0 read_end1=0 ref_end2=0 cigar=1M 
	xubo@xubo:~/xubo/tools/Complete-Striped-Smith-Waterman-Library/src$ scala  -Djava.library.path=. -cp SparkSW.jar ssw.SSWRun AB AB
	Aligning nucleotides
	score1=4 score2=0 ref_begin1=0 ref_end1=1 read_begin1=0 read_end1=1 ref_end2=0 cigar=2M 
	xubo@xubo:~/xubo/tools/Complete-Striped-Smith-Waterman-Library/src$ scala  -Djava.library.path=. -cp SparkSW.jar ssw.SSWRun AGCT ACT
	Aligning nucleotides
	score1=4 score2=0 ref_begin1=1 ref_end1=2 read_begin1=2 read_end1=3 ref_end2=0 cigar=2M 



参考

	【1】https://github.com/xubo245
	【2】http://blog.csdn.net/xubo245/
