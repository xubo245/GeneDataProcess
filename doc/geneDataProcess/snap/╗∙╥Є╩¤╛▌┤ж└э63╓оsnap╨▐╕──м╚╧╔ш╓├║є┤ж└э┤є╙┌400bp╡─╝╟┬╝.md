
通过修改Read.h中的400=》4000，之后可以运行，但是匹配的命中率好低。但是bwamen很不错，下一篇有记录。
	
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l500N10000.fq -o g38l500N10000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 32s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	10,000         8,933 (89.33%)         98 (0.98%)             969 (9.69%)            0 (0.00%)                 4,068     2
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l1000N10000.fq -o g38l1000N10000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 33s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	10,000         796 (7.96%)            8 (0.08%)              9,196 (91.96%)         0 (0.00%)                 2,608     4
	
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner snapindex/ g38l500N100000.fq -o g38l500N100000.snap.sam
	Welcome to SNAP version 1.0beta.23.
	
	Invalid command: snapindex/
	
	Usage: snap-aligner <command> [<options>]
	Commands:
	   index    build a genome index
	   single   align single-end reads
	   paired   align paired-end reads
	   daemon   run in daemon mode--accept commands remotely
	Type a command without arguments to see its help.
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single  snapindex/ g38l500N100000.fq -o g38l500N100000.snap.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 34s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	100,000        88,891 (88.89%)        1,083 (1.08%)          10,026 (10.03%)        0 (0.00%)                 4,200     24

	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l1000N100000.fq -o g38l1000N100000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 33s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	100,000        7,786 (7.79%)          67 (0.07%)             92,145 (92.14%)        2 (0.00%)                 2,390     42
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l1000N1000000.fq -o g38l1000N1000000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 32s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	1,000,000      78,762 (7.88%)         602 (0.06%)            920,610 (92.06%)       26 (0.00%)                2,420     413


统计信息：

	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l500N10000.snap1.sam 
	10000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	9031 + 0 mapped (90.31% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l500N100000.snap1.sam 
	[E::hts_open_format] fail to open file 'g38l500N100000.snap1.sam'
	samtools flagstat: Cannot open input file "g38l500N100000.snap1.sam": No such file or directory
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l500N100000.snap.sam 
	100000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	89974 + 0 mapped (89.97% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l1000N10000.snap1.sam 
	10000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	804 + 0 mapped (8.04% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l1000N100000.snap1.sam 
	100000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	7853 + 0 mapped (7.85% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l1000N1000000.snap1.sam 
	1000000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	79364 + 0 mapped (7.94% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ 
