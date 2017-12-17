
记录：

```

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner single snap/snapindex g38L100c10000000Nhs20.fq -o snap/g38L100c10000000Nhs20.snap.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 0s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	9,257,464      8,838,906 (95.48%)     411,004 (4.44%)        7,554 (0.08%)          0 (0.00%)                 40,252    230
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner single snap/snapindex g38L100c10000000Nhs20.fq -o snap/g38L100c10000000Nhs20.snap2.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 12s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns     Reads/s   Time in Aligner (s)
	9,257,464      8,838,906 (95.48%)     411,004 (4.44%)        7,554 (0.08%)          0 (0.00%)                 40,171    230
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ 

```