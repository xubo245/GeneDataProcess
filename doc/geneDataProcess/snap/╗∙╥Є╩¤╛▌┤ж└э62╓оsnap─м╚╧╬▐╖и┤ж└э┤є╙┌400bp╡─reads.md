
在处理500bp和1000bp的时候，snap都无法处理：

	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l500N10000.fq -o g38l500N10000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 30s.  248957422 bases, seed size 20
	Aligning.
	BaseAligner:: got too big read (500 > 400)
	Increase MAX_READ_LENGTH at the beginning of Read.h and recompile
	SNAP exited with exit code 1 from line 302 of file SNAPLib/BaseAligner.cpp
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ snap-aligner single snapindex/ g38l1000N10000.fq -o g38l1000N10000.snap1.sam
	Welcome to SNAP version 1.0beta.23.
	
	Loading index from directory... 31s.  248957422 bases, seed size 20
	Aligning.
	BaseAligner:: got too big read (1000 > 400)
	Increase MAX_READ_LENGTH at the beginning of Read.h and recompile
	SNAP exited with exit code 1 from line 302 of file SNAPLib/BaseAligner.cpp
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ 
