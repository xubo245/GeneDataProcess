```
	
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner index GRCH38BWAindex/GRCH38chr1L3556522.fasta snapindex
	Welcome to SNAP version 1.0beta.23.
	
	Hash table slack 0.300000
	Loading FASTA file 'GRCH38BWAindex/GRCH38chr1L3556522.fasta' into memory...
	FASTA file contained a character that's not a valid base (or N): 'M', full line 'TCACCCCCCACACACACCAAACAMCCCACACAACACACACACACCACACCACACAAACACAAACACACCA'; 
	converting to 'N'.  This may happen again, but there will be no more warnings.
	5s
	Saving genome...0s
	Computing bias table.
	Bias computation: 100000000 / 248957422
	Bias computation: 200000000 / 248957422
	Computed bias table in 10s
	Allocating memory for hash tables...3s
	Building hash tables.
	Indexing 100000000 / 248957422
	Indexing 200000000 / 248957422
	7173030(2%) seeds occur more than once, total of 45140283(18%) genome locations are not unique, 18478659(7%) bad seeds, 0 both complements used 500 no string
	Hash table build took 38s
	Building overflow table.
	Overflow table build and hash table save took 19s
	Saving overflow table...0s
	Index build and save took 76s (3275755 bases/s)
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner paired snapindex g38L100c10000000Nhs20Paired1.
	g38L100c10000000Nhs20Paired1.aln  g38L100c10000000Nhs20Paired1.fq   g38L100c10000000Nhs20Paired1.sai  
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner paired snapindex g38L100c10000000Nhs20Paired1.fq  g38L100c10000000Nhs20Paired2.fq -o g38L100c10000000Nhs20Paired12.snap.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 0s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns  %Pairs    Reads/s   Time in Aligner (s)
	18,512,662     18,007,468 (97.27%)    502,480 (2.71%)        2,714 (0.01%)          0 (0.00%)              99.95%    47,683    388
	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ cat g38L100c10000000Nhs20Paired12.snap.sam |wc -l
	18512666

```

第二次
```

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ snap-aligner paired snap/snapindex g38L100c10000000Nhs20Paired1.fq  g38L100c10000000Nhs20Paired2.fq -o snap/g38L100c10000000Nhs20Paired12.snap2.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 12s.  248957422 bases, seed size 20
	Aligning.
	Total Reads    Aligned, MAPQ >= 10    Aligned, MAPQ < 10     Unaligned              Too Short/Too Many Ns  %Pairs    Reads/s   Time in Aligner (s)
	18,512,662     18,007,468 (97.27%)    502,480 (2.71%)        2,714 (0.01%)          0 (0.00%)              99.95%    47,020    394

```


