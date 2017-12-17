	
第一次：
	
	```
	hadoop@Master:~/cloud/adam/xubo/data/cs-bwamem$ bwa aln  GRCH38BWAindex/GRCH38chr1L3556522.fasta g38L100c10000000Nhs20.fq >  bwa/g38L100c10000000Nhs20.bwase1.sai 
	[bwa_aln] 17bp reads: max_diff = 2
	[bwa_aln] 38bp reads: max_diff = 3
	[bwa_aln] 64bp reads: max_diff = 4
	[bwa_aln] 93bp reads: max_diff = 5
	[bwa_aln] 124bp reads: max_diff = 6
	[bwa_aln] 157bp reads: max_diff = 7
	[bwa_aln] 190bp reads: max_diff = 8
	[bwa_aln] 225bp reads: max_diff = 9
	[bwa_aln_core] calculate SA coordinate... 39.15 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 262144 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.52 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 524288 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.20 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 786432 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.62 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1048576 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.48 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1310720 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.74 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1572864 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.29 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1835008 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.62 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2097152 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.44 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2359296 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.59 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2621440 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.47 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2883584 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.36 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3145728 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.36 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3407872 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.47 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3670016 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.44 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3932160 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.23 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4194304 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.29 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4456448 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.70 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4718592 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.05 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4980736 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.64 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 5242880 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.29 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 5505024 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.66 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 5767168 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.26 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6029312 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.63 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6291456 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.30 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6553600 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.61 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6815744 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.38 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7077888 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.46 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7340032 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.29 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7602176 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.77 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7864320 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.17 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8126464 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.61 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8388608 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.18 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8650752 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.63 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8912896 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 39.56 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 9175040 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 12.48 sec
	[bwa_aln_core] write to the disk... 0.01 sec
	[bwa_aln_core] 9257464 sequences have been processed.
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa aln GRCH38BWAindex/GRCH38chr1L3556522.fasta g38L100c10000000Nhs20.fq
	[main] Real time: 1418.534 sec; CPU: 1405.712 sec
	hadoop@Master:~/cloud/adam/xubo/data/cs-bwamem$ ls
	bwa        g38L1000c10000000Nhs20.aln  g38L100c10000000Nhs20Paired1.aln  g38L100c10000000Nhs20Paired2.fq   G38L100c1Nhs20.sai   G38L100c50Nhs20.sam
	bwamem     g38L1000c10000000Nhs20.fq   g38L100c10000000Nhs20Paired1.fq   g38L100c10000000Nhs20Paired2.sai  G38L100c1Nhs20.sam   GRCH38BWAindex
	eventLogs  g38L100c10000000Nhs20.aln   g38L100c10000000Nhs20Paired1.sai  G38L100c1Nhs20.aln                G38L100c50Nhs20.aln  index
	fastq      g38L100c10000000Nhs20.fq    g38L100c10000000Nhs20Paired2.aln  G38L100c1Nhs20.fq                 G38L100c50Nhs20.sai  snap
	hadoop@Master:~/cloud/adam/xubo/data/cs-bwamem$ cd ../
	hadoop@Master:~/cloud/adam/xubo/data$ mv cs-bwamem GRCH38Sub/
	hadoop@Master:~/cloud/adam/xubo/data$ cd GRCH38Sub/cs-bwamem/
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ ls
	bwa        g38L1000c10000000Nhs20.aln  g38L100c10000000Nhs20Paired1.aln  g38L100c10000000Nhs20Paired2.fq   G38L100c1Nhs20.sai   G38L100c50Nhs20.sam
	bwamem     g38L1000c10000000Nhs20.fq   g38L100c10000000Nhs20Paired1.fq   g38L100c10000000Nhs20Paired2.sai  G38L100c1Nhs20.sam   GRCH38BWAindex
	eventLogs  g38L100c10000000Nhs20.aln   g38L100c10000000Nhs20Paired1.sai  G38L100c1Nhs20.aln                G38L100c50Nhs20.aln  index
	fastq      g38L100c10000000Nhs20.fq    g38L100c10000000Nhs20Paired2.aln  G38L100c1Nhs20.fq                 G38L100c50Nhs20.sai  snap
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ bwa samse GRCH38BWAindex/GRCH38chr1L3556522.fasta bwa/g38L100c10000000Nhs20.bwase1.sai g38L100c10000000Nhs20.fq >bwa/g38L100c10000000Nhs20.bwase1.sam
	[bwa_aln_core] convert to sequence coordinate... 1.52 sec
	[bwa_aln_core] refine gapped alignments... 0.25 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 262144 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 524288 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 786432 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 1048576 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 1310720 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 1572864 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 1835008 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 2097152 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 2359296 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 2621440 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 2883584 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 3145728 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 3407872 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 3670016 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 3932160 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 4194304 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 4456448 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 4718592 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 4980736 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.47 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 5242880 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 5505024 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 5767168 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6029312 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 6291456 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6553600 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6815744 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.50 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 7077888 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 7340032 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 7602176 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.50 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 7864320 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.50 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 8126464 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 8388608 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 8650752 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.48 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 8912896 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.49 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 9175040 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 0.56 sec
	[bwa_aln_core] refine gapped alignments... 0.09 sec
	[bwa_aln_core] print alignments... 0.21 sec
	[bwa_aln_core] 9257464 sequences have been processed.
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa samse GRCH38BWAindex/GRCH38chr1L3556522.fasta bwa/g38L100c10000000Nhs20.bwase1.sai g38L100c10000000Nhs20.fq
	[main] Real time: 122.849 sec; CPU: 96.027 sec
	
	```
	
	
	第二次：
	
	```
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ bwa aln  GRCH38BWAindex/GRCH38chr1L3556522.fasta g38L100c10000000Nhs20.fq >  bwa/g38L100c10000000Nhs20.bwase2.sai 
	[bwa_aln] 17bp reads: max_diff = 2
	[bwa_aln] 38bp reads: max_diff = 3
	[bwa_aln] 64bp reads: max_diff = 4
	[bwa_aln] 93bp reads: max_diff = 5
	[bwa_aln] 124bp reads: max_diff = 6
	[bwa_aln] 157bp reads: max_diff = 7
	[bwa_aln] 190bp reads: max_diff = 8
	[bwa_aln] 225bp reads: max_diff = 9
	[bwa_aln_core] calculate SA coordinate... 46.98 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 262144 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.47 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 524288 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.28 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 786432 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.53 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1048576 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.76 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1310720 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.81 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1572864 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.55 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 1835008 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.62 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2097152 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.71 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2359296 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 47.36 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2621440 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.89 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 2883584 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.02 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3145728 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.19 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3407872 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.11 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3670016 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.39 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 3932160 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 43.88 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4194304 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.34 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4456448 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.41 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4718592 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 43.98 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 4980736 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.24 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 5242880 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 45.00 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 5505024 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 45.12 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 5767168 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.18 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6029312 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.27 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6291456 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.19 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6553600 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.29 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 6815744 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.29 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7077888 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.10 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7340032 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.21 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7602176 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.52 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 7864320 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.06 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8126464 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.21 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8388608 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.11 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8650752 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 44.39 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 8912896 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 45.15 sec
	[bwa_aln_core] write to the disk... 0.03 sec
	[bwa_aln_core] 9175040 sequences have been processed.
	[bwa_aln_core] calculate SA coordinate... 14.24 sec
	[bwa_aln_core] write to the disk... 0.01 sec
	[bwa_aln_core] 9257464 sequences have been processed.
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa aln GRCH38BWAindex/GRCH38chr1L3556522.fasta g38L100c10000000Nhs20.fq
	[main] Real time: 1625.659 sec; CPU: 1611.033 sec
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ bwa samse GRCH38BWAindex/GRCH38chr1L3556522.fasta bwa/g38L100c10000000Nhs20.bwase2.sai g38L100c10000000Nhs20.fq >bwa/g38L100c10000000Nhs20.bwase2.sam
	[bwa_aln_core] convert to sequence coordinate... 1.87 sec
	[bwa_aln_core] refine gapped alignments... 0.28 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 262144 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.88 sec
	[bwa_aln_core] refine gapped alignments... 0.27 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 524288 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.89 sec
	[bwa_aln_core] refine gapped alignments... 0.27 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 786432 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.88 sec
	[bwa_aln_core] refine gapped alignments... 0.27 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 1048576 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.87 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 1310720 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.88 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 1572864 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.83 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 1835008 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.83 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 2097152 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.93 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 2359296 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.86 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 2621440 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.87 sec
	[bwa_aln_core] refine gapped alignments... 0.27 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 2883584 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.83 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 3145728 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.82 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.67 sec
	[bwa_aln_core] 3407872 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.84 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 3670016 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.84 sec
	[bwa_aln_core] refine gapped alignments... 0.26 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 3932160 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.82 sec
	[bwa_aln_core] refine gapped alignments... 0.25 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 4194304 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.98 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 4456448 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.83 sec
	[bwa_aln_core] refine gapped alignments... 0.25 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 4718592 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.81 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 4980736 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.80 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 5242880 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.81 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 5505024 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.80 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 5767168 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.80 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6029312 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.77 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6291456 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.81 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6553600 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.78 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 6815744 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.80 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 7077888 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.82 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 7340032 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.81 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 7602176 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.80 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 7864320 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.81 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 8126464 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.84 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 8388608 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.81 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 8650752 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.80 sec
	[bwa_aln_core] refine gapped alignments... 0.24 sec
	[bwa_aln_core] print alignments... 0.69 sec
	[bwa_aln_core] 8912896 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 1.78 sec
	[bwa_aln_core] refine gapped alignments... 0.23 sec
	[bwa_aln_core] print alignments... 0.68 sec
	[bwa_aln_core] 9175040 sequences have been processed.
	[bwa_aln_core] convert to sequence coordinate... 0.74 sec
	[bwa_aln_core] refine gapped alignments... 0.09 sec
	[bwa_aln_core] print alignments... 0.22 sec
	[bwa_aln_core] 9257464 sequences have been processed.
	[main] Version: 0.7.13-r1126
	[main] CMD: bwa samse GRCH38BWAindex/GRCH38chr1L3556522.fasta bwa/g38L100c10000000Nhs20.bwase2.sai g38L100c10000000Nhs20.fq
	[main] Real time: 151.425 sec; CPU: 110.431 sec
	
	```
	
结果：
	```

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ samtools flagstat bwa/g38L100c10000000Nhs20.bwase2.sam
	9257464 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	9253208 + 0 mapped (99.95% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	
	```