

1.下载：

	hadoop@Master:~/xubo/tools$  git clone  https://github.com/BenLangmead/bowtie2.git
	Cloning into 'bowtie2'...
	remote: Counting objects: 7503, done.
	remote: Total 7503 (delta 0), reused 0 (delta 0), pack-reused 7503
	Receiving objects: 100% (7503/7503), 143.80 MiB | 403.00 KiB/s, done.
	Resolving deltas: 100% (4949/4949), done.
	Checking connectivity... done.


2.安装：

	hadoop@Master:~/xubo/tools/bowtie2$ make
	g++ -O3 -m64 -msse2  -funroll-loops -g3 -DCOMPILER_OPTIONS="\"-O3 -m64 -msse2  -funroll-loops -g3 -DPOPCNT_CAPABILITY\"" -DPOPCNT_CAPABILITY \
			-fno-strict-aliasing -DBOWTIE2_VERSION="\"`cat VERSION`\"" -DBUILD_HOST="\"`hostname`\"" -DBUILD_TIME="\"`date`\"" -DCOMPILER_VERSION="\"`g++ -v 2>&1 | tail -1`\"" -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_GNU_SOURCE  -DBOWTIE_MM  -DBOWTIE2 -DNDEBUG -Wall \
			 -I third_party \
			-o bowtie2-build-s bt2_build.cpp \
			ccnt_lut.cpp ref_read.cpp alphabet.cpp shmem.cpp edit.cpp bt2_idx.cpp bt2_io.cpp bt2_util.cpp reference.cpp ds.cpp multikey_qsort.cpp limit.cpp random_source.cpp tinythread.cpp diff_sample.cpp bowtie_build_main.cpp \
			-lpthread 
	g++ -O3 -m64 -msse2  -funroll-loops -g3 -DCOMPILER_OPTIONS="\"-O3 -m64 -msse2  -funroll-loops -g3 -DPOPCNT_CAPABILITY\"" -DPOPCNT_CAPABILITY \
			-fno-strict-aliasing -DBOWTIE2_VERSION="\"`cat VERSION`\"" -DBUILD_HOST="\"`hostname`\"" -DBUILD_TIME="\"`date`\"" -DCOMPILER_VERSION="\"`g++ -v 2>&1 | tail -1`\"" -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_GNU_SOURCE  -DBOWTIE_MM  -DBOWTIE2 -DBOWTIE_64BIT_INDEX -DNDEBUG -Wall \
			 -I third_party \
			-o bowtie2-build-l bt2_build.cpp \
			ccnt_lut.cpp ref_read.cpp alphabet.cpp shmem.cpp edit.cpp bt2_idx.cpp bt2_io.cpp bt2_util.cpp reference.cpp ds.cpp multikey_qsort.cpp limit.cpp random_source.cpp tinythread.cpp diff_sample.cpp bowtie_build_main.cpp \
			-lpthread 
	g++ -O3 -m64 -msse2  -funroll-loops -g3 -DCOMPILER_OPTIONS="\"-O3 -m64 -msse2  -funroll-loops -g3 -DPOPCNT_CAPABILITY\"" -DPOPCNT_CAPABILITY \
			-fno-strict-aliasing -DBOWTIE2_VERSION="\"`cat VERSION`\"" -DBUILD_HOST="\"`hostname`\"" -DBUILD_TIME="\"`date`\"" -DCOMPILER_VERSION="\"`g++ -v 2>&1 | tail -1`\"" -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_GNU_SOURCE  -DBOWTIE_MM  -DBOWTIE2 -DNDEBUG -Wall \
			 -I third_party \
			-o bowtie2-align-s bt2_search.cpp \
			ccnt_lut.cpp ref_read.cpp alphabet.cpp shmem.cpp edit.cpp bt2_idx.cpp bt2_io.cpp bt2_util.cpp reference.cpp ds.cpp multikey_qsort.cpp limit.cpp random_source.cpp tinythread.cpp qual.cpp pat.cpp sam.cpp read_qseq.cpp aligner_seed_policy.cpp aligner_seed.cpp aligner_seed2.cpp aligner_sw.cpp aligner_sw_driver.cpp aligner_cache.cpp aligner_result.cpp ref_coord.cpp mask.cpp pe.cpp aln_sink.cpp dp_framer.cpp scoring.cpp presets.cpp unique.cpp simple_func.cpp random_util.cpp aligner_bt.cpp sse_util.cpp aligner_swsse.cpp outq.cpp aligner_swsse_loc_i16.cpp aligner_swsse_ee_i16.cpp aligner_swsse_loc_u8.cpp aligner_swsse_ee_u8.cpp aligner_driver.cpp bowtie_main.cpp \
			-lpthread 
	g++ -O3 -m64 -msse2  -funroll-loops -g3 -DCOMPILER_OPTIONS="\"-O3 -m64 -msse2  -funroll-loops -g3 -DPOPCNT_CAPABILITY\"" -DPOPCNT_CAPABILITY \
			-fno-strict-aliasing -DBOWTIE2_VERSION="\"`cat VERSION`\"" -DBUILD_HOST="\"`hostname`\"" -DBUILD_TIME="\"`date`\"" -DCOMPILER_VERSION="\"`g++ -v 2>&1 | tail -1`\"" -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_GNU_SOURCE  -DBOWTIE_MM  -DBOWTIE2 -DBOWTIE_64BIT_INDEX -DNDEBUG -Wall \
			 -I third_party \
			-o bowtie2-align-l bt2_search.cpp \
			ccnt_lut.cpp ref_read.cpp alphabet.cpp shmem.cpp edit.cpp bt2_idx.cpp bt2_io.cpp bt2_util.cpp reference.cpp ds.cpp multikey_qsort.cpp limit.cpp random_source.cpp tinythread.cpp qual.cpp pat.cpp sam.cpp read_qseq.cpp aligner_seed_policy.cpp aligner_seed.cpp aligner_seed2.cpp aligner_sw.cpp aligner_sw_driver.cpp aligner_cache.cpp aligner_result.cpp ref_coord.cpp mask.cpp pe.cpp aln_sink.cpp dp_framer.cpp scoring.cpp presets.cpp unique.cpp simple_func.cpp random_util.cpp aligner_bt.cpp sse_util.cpp aligner_swsse.cpp outq.cpp aligner_swsse_loc_i16.cpp aligner_swsse_ee_i16.cpp aligner_swsse_loc_u8.cpp aligner_swsse_ee_u8.cpp aligner_driver.cpp bowtie_main.cpp \
			-lpthread 
	g++ -O3 -m64 -msse2  -funroll-loops -g3 \
			-DCOMPILER_OPTIONS="\"-O3 -m64 -msse2  -funroll-loops -g3 -DPOPCNT_CAPABILITY\"" -DPOPCNT_CAPABILITY \
			-fno-strict-aliasing -DBOWTIE2_VERSION="\"`cat VERSION`\"" -DBUILD_HOST="\"`hostname`\"" -DBUILD_TIME="\"`date`\"" -DCOMPILER_VERSION="\"`g++ -v 2>&1 | tail -1`\"" -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_GNU_SOURCE  -DBOWTIE_MM  -DBOWTIE2 -DBOWTIE_INSPECT_MAIN -Wall \
			 -I third_party -I . \
			-o bowtie2-inspect-s bt2_inspect.cpp \
			ccnt_lut.cpp ref_read.cpp alphabet.cpp shmem.cpp edit.cpp bt2_idx.cpp bt2_io.cpp bt2_util.cpp reference.cpp ds.cpp multikey_qsort.cpp limit.cpp random_source.cpp tinythread.cpp \
			-lpthread 
	g++ -O3 -m64 -msse2  -funroll-loops -g3 \
			-DCOMPILER_OPTIONS="\"-O3 -m64 -msse2  -funroll-loops -g3 -DPOPCNT_CAPABILITY\"" -DPOPCNT_CAPABILITY \
			-fno-strict-aliasing -DBOWTIE2_VERSION="\"`cat VERSION`\"" -DBUILD_HOST="\"`hostname`\"" -DBUILD_TIME="\"`date`\"" -DCOMPILER_VERSION="\"`g++ -v 2>&1 | tail -1`\"" -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_GNU_SOURCE  -DBOWTIE_MM  -DBOWTIE2 -DBOWTIE_INSPECT_MAIN  -DBOWTIE_64BIT_INDEX -Wall \
			 -I third_party -I . \
			-o bowtie2-inspect-l bt2_inspect.cpp \
			ccnt_lut.cpp ref_read.cpp alphabet.cpp shmem.cpp edit.cpp bt2_idx.cpp bt2_io.cpp bt2_util.cpp reference.cpp ds.cpp multikey_qsort.cpp limit.cpp random_source.cpp tinythread.cpp \
			-lpthread 
	hadoop@Master:~/xubo/tools/bowtie2$ make install
	mkdir -p /usr/local/bin
	for file in bowtie2-build-s bowtie2-build-l bowtie2-align-s bowtie2-align-l bowtie2-inspect-s bowtie2-inspect-l bowtie2-inspect bowtie2-build bowtie2 ; do \
			cp -f $file /usr/local/bin ; \
		done
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-build-s’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-build-l’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-align-s’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-align-l’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-inspect-s’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-inspect-l’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-inspect’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2-build’: Permission denied
	cp: cannot create regular file ‘/usr/local/bin/bowtie2’: Permission denied
	make: *** [install] Error 1
	hadoop@Master:~/xubo/tools/bowtie2$ sudo make install
	[sudo] password for hadoop: 
	mkdir -p /usr/local/bin
	for file in bowtie2-build-s bowtie2-build-l bowtie2-align-s bowtie2-align-l bowtie2-inspect-s bowtie2-inspect-l bowtie2-inspect bowtie2-build bowtie2 ; do \
			cp -f $file /usr/local/bin ; \
		done



3.使用：   
（1）建立索引：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ bowtie2-build GRCH38BWAindex/GRCH38chr1L3556522.fasta bowtie2/index
	Settings:
	  Output files: "bowtie2/index.*.bt2"
	  Line rate: 6 (line is 64 bytes)
	  Lines per side: 1 (side is 64 bytes)
	  Offset rate: 4 (one in 16)
	  FTable chars: 10
	  Strings: unpacked
	  Max bucket size: default
	  Max bucket size, sqrt multiplier: default
	  Max bucket size, len divisor: 4
	  Difference-cover sample period: 1024
	  Endianness: little
	  Actual local endianness: little
	  Sanity checking: disabled
	  Assertions: disabled
	  Random seed: 0
	  Sizeofs: void*:8, int:4, long:8, size_t:8
	Input files DNA, FASTA:
	  GRCH38BWAindex/GRCH38chr1L3556522.fasta
	Building a SMALL index
	Reading reference sizes
	  Time reading reference sizes: 00:00:03
	Calculating joined length
	Writing header
	Reserving space for joined string
	Joining reference sequences
	  Time to join reference sequences: 00:00:03
	bmax according to bmaxDivN setting: 57620253
	Using parameters --bmax 43215190 --dcv 1024
	  Doing ahead-of-time memory usage test
	  Passed!  Constructing with these parameters: --bmax 43215190 --dcv 1024
	Constructing suffix-array element generator
	Building DifferenceCoverSample
	  Building sPrime
	  Building sPrimeOrder
	  V-Sorting samples
	  V-Sorting samples time: 00:00:05
	  Allocating rank array
	  Ranking v-sort output
	  Ranking v-sort output time: 00:00:01
	  Invoking Larsson-Sadakane on ranks
	  Invoking Larsson-Sadakane on ranks time: 00:00:02
	  Sanity-checking and returning
	Building samples
	Reserving space for 12 sample suffixes
	Generating random suffixes
	QSorting 12 sample offsets, eliminating duplicates
	QSorting sample offsets, eliminating duplicates time: 00:00:00
	Multikey QSorting 12 samples
	  (Using difference cover)
	  Multikey QSorting samples time: 00:00:00
	Calculating bucket sizes
	Splitting and merging
	  Splitting and merging time: 00:00:00
	Avg bucket size: 3.29259e+07 (target: 43215189)
	Converting suffix-array elements to index image
	Allocating ftab, absorbFtab
	Entering Ebwt loop
	Getting block 1 of 7
	  Reserving size (43215190) for bucket 1
	  Calculating Z arrays for bucket 1
	  Entering block accumulator loop for bucket 1:
	  bucket 1: 10%
	  bucket 1: 20%
	  bucket 1: 30%
	  bucket 1: 40%
	  bucket 1: 50%
	  bucket 1: 60%
	  bucket 1: 70%
	  bucket 1: 80%
	  bucket 1: 90%
	  bucket 1: 100%
	  Sorting block of length 41559493 for bucket 1
	  (Using difference cover)
	  Sorting block time: 00:00:16
	Returning block of 41559494 for bucket 1
	Getting block 2 of 7
	  Reserving size (43215190) for bucket 2
	  Calculating Z arrays for bucket 2
	  Entering block accumulator loop for bucket 2:
	  bucket 2: 10%
	  bucket 2: 20%
	  bucket 2: 30%
	  bucket 2: 40%
	  bucket 2: 50%
	  bucket 2: 60%
	  bucket 2: 70%
	  bucket 2: 80%
	  bucket 2: 90%
	  bucket 2: 100%
	  Sorting block of length 36821901 for bucket 2
	  (Using difference cover)
	  Sorting block time: 00:00:13
	Returning block of 36821902 for bucket 2
	Getting block 3 of 7
	  Reserving size (43215190) for bucket 3
	  Calculating Z arrays for bucket 3
	  Entering block accumulator loop for bucket 3:
	  bucket 3: 10%
	  bucket 3: 20%
	  bucket 3: 30%
	  bucket 3: 40%
	  bucket 3: 50%
	  bucket 3: 60%
	  bucket 3: 70%
	  bucket 3: 80%
	  bucket 3: 90%
	  bucket 3: 100%
	  Sorting block of length 41919124 for bucket 3
	  (Using difference cover)
	  Sorting block time: 00:00:16
	Returning block of 41919125 for bucket 3
	Getting block 4 of 7
	  Reserving size (43215190) for bucket 4
	  Calculating Z arrays for bucket 4
	  Entering block accumulator loop for bucket 4:
	  bucket 4: 10%
	  bucket 4: 20%
	  bucket 4: 30%
	  bucket 4: 40%
	  bucket 4: 50%
	  bucket 4: 60%
	  bucket 4: 70%
	  bucket 4: 80%
	  bucket 4: 90%
	  bucket 4: 100%
	  Sorting block of length 24681605 for bucket 4
	  (Using difference cover)
	  Sorting block time: 00:00:09
	Returning block of 24681606 for bucket 4
	Getting block 5 of 7
	  Reserving size (43215190) for bucket 5
	  Calculating Z arrays for bucket 5
	  Entering block accumulator loop for bucket 5:
	  bucket 5: 10%
	  bucket 5: 20%
	  bucket 5: 30%
	  bucket 5: 40%
	  bucket 5: 50%
	  bucket 5: 60%
	  bucket 5: 70%
	  bucket 5: 80%
	  bucket 5: 90%
	  bucket 5: 100%
	  Sorting block of length 41918922 for bucket 5
	  (Using difference cover)
	  Sorting block time: 00:00:15
	Returning block of 41918923 for bucket 5
	Getting block 6 of 7
	  Reserving size (43215190) for bucket 6
	  Calculating Z arrays for bucket 6
	  Entering block accumulator loop for bucket 6:
	  bucket 6: 10%
	  bucket 6: 20%
	  bucket 6: 30%
	  bucket 6: 40%
	  bucket 6: 50%
	  bucket 6: 60%
	  bucket 6: 70%
	  bucket 6: 80%
	  bucket 6: 90%
	  bucket 6: 100%
	  Sorting block of length 8244387 for bucket 6
	  (Using difference cover)
	  Sorting block time: 00:00:03
	Returning block of 8244388 for bucket 6
	Getting block 7 of 7
	  Reserving size (43215190) for bucket 7
	  Calculating Z arrays for bucket 7
	  Entering block accumulator loop for bucket 7:
	  bucket 7: 10%
	  bucket 7: 20%
	  bucket 7: 30%
	  bucket 7: 40%
	  bucket 7: 50%
	  bucket 7: 60%
	  bucket 7: 70%
	  bucket 7: 80%
	  bucket 7: 90%
	  bucket 7: 100%
	  Sorting block of length 35335574 for bucket 7
	  (Using difference cover)
	  Sorting block time: 00:00:13
	Returning block of 35335575 for bucket 7
	Exited Ebwt loop
	fchr[A]: 0
	fchr[C]: 67070277
	fchr[G]: 115125320
	fchr[T]: 163236848
	fchr[$]: 230481012
	Exiting Ebwt::buildToDisk()
	Returning from initFromVector
	Wrote 81023576 bytes to primary EBWT file: bowtie2/index.1.bt2
	Wrote 57620260 bytes to secondary EBWT file: bowtie2/index.2.bt2
	Re-opening _in1 and _in2 as input streams
	Returning from Ebwt constructor
	Headers:
	    len: 230481012
	    bwtLen: 230481013
	    sz: 57620253
	    bwtSz: 57620254
	    lineRate: 6
	    offRate: 4
	    offMask: 0xfffffff0
	    ftabChars: 10
	    eftabLen: 20
	    eftabSz: 80
	    ftabLen: 1048577
	    ftabSz: 4194308
	    offsLen: 14405064
	    offsSz: 57620256
	    lineSz: 64
	    sideSz: 64
	    sideBwtSz: 48
	    sideBwtLen: 192
	    numSides: 1200422
	    numLines: 1200422
	    ebwtTotLen: 76827008
	    ebwtTotSz: 76827008
	    color: 0
	    reverse: 0
	Total time for call to driver() for forward index: 00:02:50
	Reading reference sizes
	  Time reading reference sizes: 00:00:02
	Calculating joined length
	Writing header
	Reserving space for joined string
	Joining reference sequences
	  Time to join reference sequences: 00:00:02
	  Time to reverse reference sequence: 00:00:01
	bmax according to bmaxDivN setting: 57620253
	Using parameters --bmax 43215190 --dcv 1024
	  Doing ahead-of-time memory usage test
	  Passed!  Constructing with these parameters: --bmax 43215190 --dcv 1024
	Constructing suffix-array element generator
	Building DifferenceCoverSample
	  Building sPrime
	  Building sPrimeOrder
	  V-Sorting samples
	  V-Sorting samples time: 00:00:05
	  Allocating rank array
	  Ranking v-sort output
	  Ranking v-sort output time: 00:00:01
	  Invoking Larsson-Sadakane on ranks
	  Invoking Larsson-Sadakane on ranks time: 00:00:02
	  Sanity-checking and returning
	Building samples
	Reserving space for 12 sample suffixes
	Generating random suffixes
	QSorting 12 sample offsets, eliminating duplicates
	QSorting sample offsets, eliminating duplicates time: 00:00:00
	Multikey QSorting 12 samples
	  (Using difference cover)
	  Multikey QSorting samples time: 00:00:00
	Calculating bucket sizes
	Splitting and merging
	  Splitting and merging time: 00:00:00
	Split 2, merged 6; iterating...
	Splitting and merging
	  Splitting and merging time: 00:00:00
	Split 1, merged 1; iterating...
	Splitting and merging
	  Splitting and merging time: 00:00:00
	Split 1, merged 1; iterating...
	Splitting and merging
	  Splitting and merging time: 00:00:00
	Split 1, merged 1; iterating...
	Splitting and merging
	  Splitting and merging time: 00:00:00
	Avg bucket size: 2.88101e+07 (target: 43215189)
	Converting suffix-array elements to index image
	Allocating ftab, absorbFtab
	Entering Ebwt loop
	Getting block 1 of 8
	  Reserving size (43215190) for bucket 1
	  Calculating Z arrays for bucket 1
	  Entering block accumulator loop for bucket 1:
	  bucket 1: 10%
	  bucket 1: 20%
	  bucket 1: 30%
	  bucket 1: 40%
	  bucket 1: 50%
	  bucket 1: 60%
	  bucket 1: 70%
	  bucket 1: 80%
	  bucket 1: 90%
	  bucket 1: 100%
	  Sorting block of length 28292839 for bucket 1
	  (Using difference cover)
	  Sorting block time: 00:00:10
	Returning block of 28292840 for bucket 1
	Getting block 2 of 8
	  Reserving size (43215190) for bucket 2
	  Calculating Z arrays for bucket 2
	  Entering block accumulator loop for bucket 2:
	  bucket 2: 10%
	  bucket 2: 20%
	  bucket 2: 30%
	  bucket 2: 40%
	  bucket 2: 50%
	  bucket 2: 60%
	  bucket 2: 70%
	  bucket 2: 80%
	  bucket 2: 90%
	  bucket 2: 100%
	  Sorting block of length 39729933 for bucket 2
	  (Using difference cover)
	  Sorting block time: 00:00:15
	Returning block of 39729934 for bucket 2
	Getting block 3 of 8
	  Reserving size (43215190) for bucket 3
	  Calculating Z arrays for bucket 3
	  Entering block accumulator loop for bucket 3:
	  bucket 3: 10%
	  bucket 3: 20%
	  bucket 3: 30%
	  bucket 3: 40%
	  bucket 3: 50%
	  bucket 3: 60%
	  bucket 3: 70%
	  bucket 3: 80%
	  bucket 3: 90%
	  bucket 3: 100%
	  Sorting block of length 14119472 for bucket 3
	  (Using difference cover)
	  Sorting block time: 00:00:05
	Returning block of 14119473 for bucket 3
	Getting block 4 of 8
	  Reserving size (43215190) for bucket 4
	  Calculating Z arrays for bucket 4
	  Entering block accumulator loop for bucket 4:
	  bucket 4: 10%
	  bucket 4: 20%
	  bucket 4: 30%
	  bucket 4: 40%
	  bucket 4: 50%
	  bucket 4: 60%
	  bucket 4: 70%
	  bucket 4: 80%
	  bucket 4: 90%
	  bucket 4: 100%
	  Sorting block of length 41568163 for bucket 4
	  (Using difference cover)
	  Sorting block time: 00:00:15
	Returning block of 41568164 for bucket 4
	Getting block 5 of 8
	  Reserving size (43215190) for bucket 5
	  Calculating Z arrays for bucket 5
	  Entering block accumulator loop for bucket 5:
	  bucket 5: 10%
	  bucket 5: 20%
	  bucket 5: 30%
	  bucket 5: 40%
	  bucket 5: 50%
	  bucket 5: 60%
	  bucket 5: 70%
	  bucket 5: 80%
	  bucket 5: 90%
	  bucket 5: 100%
	  Sorting block of length 37733383 for bucket 5
	  (Using difference cover)
	  Sorting block time: 00:00:14
	Returning block of 37733384 for bucket 5
	Getting block 6 of 8
	  Reserving size (43215190) for bucket 6
	  Calculating Z arrays for bucket 6
	  Entering block accumulator loop for bucket 6:
	  bucket 6: 10%
	  bucket 6: 20%
	  bucket 6: 30%
	  bucket 6: 40%
	  bucket 6: 50%
	  bucket 6: 60%
	  bucket 6: 70%
	  bucket 6: 80%
	  bucket 6: 90%
	  bucket 6: 100%
	  Sorting block of length 23633964 for bucket 6
	  (Using difference cover)
	  Sorting block time: 00:00:09
	Returning block of 23633965 for bucket 6
	Getting block 7 of 8
	  Reserving size (43215190) for bucket 7
	  Calculating Z arrays for bucket 7
	  Entering block accumulator loop for bucket 7:
	  bucket 7: 10%
	  bucket 7: 20%
	  bucket 7: 30%
	  bucket 7: 40%
	  bucket 7: 50%
	  bucket 7: 60%
	  bucket 7: 70%
	  bucket 7: 80%
	  bucket 7: 90%
	  bucket 7: 100%
	  Sorting block of length 34621654 for bucket 7
	  (Using difference cover)
	  Sorting block time: 00:00:13
	Returning block of 34621655 for bucket 7
	Getting block 8 of 8
	  Reserving size (43215190) for bucket 8
	  Calculating Z arrays for bucket 8
	  Entering block accumulator loop for bucket 8:
	  bucket 8: 10%
	  bucket 8: 20%
	  bucket 8: 30%
	  bucket 8: 40%
	  bucket 8: 50%
	  bucket 8: 60%
	  bucket 8: 70%
	  bucket 8: 80%
	  bucket 8: 90%
	  bucket 8: 100%
	  Sorting block of length 10781597 for bucket 8
	  (Using difference cover)
	  Sorting block time: 00:00:03
	Returning block of 10781598 for bucket 8
	Exited Ebwt loop
	fchr[A]: 0
	fchr[C]: 67070277
	fchr[G]: 115125320
	fchr[T]: 163236848
	fchr[$]: 230481012
	Exiting Ebwt::buildToDisk()
	Returning from initFromVector
	Wrote 81023576 bytes to primary EBWT file: bowtie2/index.rev.1.bt2
	Wrote 57620260 bytes to secondary EBWT file: bowtie2/index.rev.2.bt2
	Re-opening _in1 and _in2 as input streams
	Returning from Ebwt constructor
	Headers:
	    len: 230481012
	    bwtLen: 230481013
	    sz: 57620253
	    bwtSz: 57620254
	    lineRate: 6
	    offRate: 4
	    offMask: 0xfffffff0
	    ftabChars: 10
	    eftabLen: 20
	    eftabSz: 80
	    ftabLen: 1048577
	    ftabSz: 4194308
	    offsLen: 14405064
	    offsSz: 57620256
	    lineSz: 64
	    sideSz: 64
	    sideBwtSz: 48
	    sideBwtLen: 192
	    numSides: 1200422
	    numLines: 1200422
	    ebwtTotLen: 76827008
	    ebwtTotSz: 76827008
	    color: 0
	    reverse: 1
	Total time for backward call to driver() for mirror index: 00:03:36


（2）匹配：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ bowtie2 -x bowtie2/index -U g38L100c10000000Nhs20.fq -S bowtie2/g38L100c10000000Nhs20.bowtie2.sam
	9257464 reads; of these:
	  9257464 (100.00%) were unpaired; of these:
	    4401 (0.05%) aligned 0 times
	    7741394 (83.62%) aligned exactly 1 time
	    1511669 (16.33%) aligned >1 times
	99.95% overall alignment rate
居然没有统计时间。。。。
统计结果：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem$ samtools flagstat bowtie2/g38L100c10000000Nhs20.bowtie2.sam 
	9257464 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	9253063 + 0 mapped (99.95% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)



参考：
【1】http://bowtie-bio.sourceforge.net/bowtie2/manual.shtml#getting-started-with-bowtie-2-lambda-phage-example
【2】http://blog.sciencenet.cn/blog-830496-750216.html

参考片段in 【1】：

	Getting started with Bowtie 2: Lambda phage example
	
	Bowtie 2 comes with some example files to get you started. The example files are not scientifically significant; we use the Lambda phage reference genome simply because it's short, and the reads were generated by a computer program, not a sequencer. However, these files will let you start running Bowtie 2 and downstream tools right away.
	
	First follow the manual instructions to obtain Bowtie 2. Set the BT2_HOME environment variable to point to the new Bowtie 2 directory containing the bowtie2, bowtie2-build and bowtie2-inspect binaries. This is important, as the BT2_HOME variable is used in the commands below to refer to that directory.
	Indexing a reference genome
	
	To create an index for the Lambda phage reference genome included with Bowtie 2, create a new temporary directory (it doesn't matter where), change into that directory, and run:
	
	$BT2_HOME/bowtie2-build $BT2_HOME/example/reference/lambda_virus.fa lambda_virus
	
	The command should print many lines of output then quit. When the command completes, the current directory will contain four new files that all start with lambda_virus and end with .1.bt2, .2.bt2, .3.bt2, .4.bt2, .rev.1.bt2, and .rev.2.bt2. These files constitute the index - you're done!
	
	You can use bowtie2-build to create an index for a set of FASTA files obtained from any source, including sites such as UCSC, NCBI, and Ensembl. When indexing multiple FASTA files, specify all the files using commas to separate file names. For more details on how to create an index with bowtie2-build, see the manual section on index building. You may also want to bypass this process by obtaining a pre-built index. See using a pre-built index below for an example.
	Aligning example reads

	Stay in the directory created in the previous step, which now contains the lambda_virus index files. Next, run:
	
	$BT2_HOME/bowtie2 -x lambda_virus -U $BT2_HOME/example/reads/reads_1.fq -S eg1.sam
	
	This runs the Bowtie 2 aligner, which aligns a set of unpaired reads to the Lambda phage reference genome using the index generated in the previous step. The alignment results in SAM format are written to the file eg1.sam, and a short alignment summary is written to the console. (Actually, the summary is written to the "standard error" or "stderr" filehandle, which is typically printed to the console.)
	
	To see the first few lines of the SAM output, run:
	
	head eg1.sam


时间比较：

	hadoop@Master:~/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/bowtie2$ ./run.sh 
	9257464 reads; of these:
	  9257464 (100.00%) were unpaired; of these:
	    4401 (0.05%) aligned 0 times
	    7741394 (83.62%) aligned exactly 1 time
	    1511669 (16.33%) aligned >1 times
	99.95% overall alignment rate
	1=> RunTime:2480.267404 s
	********************************************
	9257464 reads; of these:
	  9257464 (100.00%) were unpaired; of these:
	    4401 (0.05%) aligned 0 times
	    7741394 (83.62%) aligned exactly 1 time
	    1511669 (16.33%) aligned >1 times
	99.95% overall alignment rate
	2=> RunTime:2405.534448 s
	********************************************
	9257464 reads; of these:
	  9257464 (100.00%) were unpaired; of these:
	    4401 (0.05%) aligned 0 times
	    7741394 (83.62%) aligned exactly 1 time
	    1511669 (16.33%) aligned >1 times
	99.95% overall alignment rate
	3=> RunTime:2396.183261 s
	********************************************


# 参考

	【1】https://github.com/xubo245/AdamLearning
	【2】https://github.com/bigdatagenomics/adam/ 
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org
	【5】http://stackoverflow.com/questions/28166667/how-to-pass-d-parameter-or-environment-variable-to-spark-job  
	【6】http://stackoverflow.com/questions/28840438/how-to-override-sparks-log4j-properties-per-driver

		
# 研究成果：

	【1】 [BIBM] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Chao Wang, and Xuehai Zhou, "Distributed Gene Clinical Decision Support System Based on Cloud Computing", in IEEE International Conference on Bioinformatics and Biomedicine. (BIBM 2017, CCF B)
	【2】 [IEEE CLOUD] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Xuehai Zhou. Efficient Distributed Smith-Waterman Algorithm Based on Apache Spark (CLOUD 2017, CCF-C).
	【3】 [CCGrid] Bo Xu, Changlong Li, Hang Zhuang, Jiali Wang, Qingfeng Wang, Jinhong Zhou, Xuehai Zhou. DSA: Scalable Distributed Sequence Alignment System Using SIMD Instructions. (CCGrid 2017, CCF-C).
	【4】more: https://github.com/xubo245/Publications
	
# Help

	If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn
	Wechat: xu601450868
	QQ: 601450868
	