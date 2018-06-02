	
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l500N10000.fq >g38l500N10000.bwamem.sam
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 10000 sequences (5000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 20.158 CPU sec, 20.183 real sec
	[main] Version: 0.7.12-r1039
	[main] CMD: /home/xubo/xubo/tools/bwa-0.7.12/bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l500N10000.fq
	[main] Real time: 26.217 sec; CPU: 20.800 sec
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools g38l500N10000.bwamem.sam 
	[main] unrecognized command 'g38l500N10000.bwamem.sam'
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstatg38l500N10000.bwamem.sam 
	[main] unrecognized command 'flagstatg38l500N10000.bwamem.sam'
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l500N10000.bwamem.sam 
	10000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	10000 + 0 mapped (100.00% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l5000N10000.fq >g38l500N100000.bwamem.sam
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[E::main_mem] fail to open file `g38l5000N10000.fq'.
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l500N100000.fq >g38l500N100000.bwamem.sam
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 20000 sequences (10000000 bp)...
	[M::process] read 20000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 20000 reads in 41.470 CPU sec, 41.454 real sec
	[M::process] read 20000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 20000 reads in 40.513 CPU sec, 40.457 real sec
	[M::process] read 20000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 20000 reads in 41.056 CPU sec, 40.989 real sec
	[M::process] read 20000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 20000 reads in 42.112 CPU sec, 42.049 real sec
	[M::mem_process_seqs] Processed 20000 reads in 41.096 CPU sec, 41.084 real sec
	[main] Version: 0.7.12-r1039
	[main] CMD: /home/xubo/xubo/tools/bwa-0.7.12/bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l500N100000.fq
	[main] Real time: 206.985 sec; CPU: 206.697 sec
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l500N100000.bwamem.sam 
	100000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	100000 + 0 mapped (100.00% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l1000N10000.fq >g38l1000N10000.bwamem.sam
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 57.290 CPU sec, 57.343 real sec
	[main] Version: 0.7.12-r1039
	[main] CMD: /home/xubo/xubo/tools/bwa-0.7.12/bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l1000N10000.fq
	[main] Real time: 58.228 sec; CPU: 57.736 sec
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l1000N10000.bwamem.sam 
	10000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	10000 + 0 mapped (100.00% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l1000N100000.fq >g38l1000N100000.bwamem.sam
	[M::bwa_idx_load_from_disk] read 0 ALT contigs
	[M::process] read 10000 sequences (10000000 bp)...
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 55.334 CPU sec, 55.333 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 57.380 CPU sec, 57.341 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 56.189 CPU sec, 56.150 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 59.506 CPU sec, 59.470 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 57.034 CPU sec, 56.994 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 58.887 CPU sec, 58.849 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 57.591 CPU sec, 57.553 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 55.443 CPU sec, 55.412 real sec
	[M::process] read 10000 sequences (10000000 bp)...
	[M::mem_process_seqs] Processed 10000 reads in 56.343 CPU sec, 56.304 real sec
	[M::mem_process_seqs] Processed 10000 reads in 58.834 CPU sec, 58.846 real sec
	[main] Version: 0.7.12-r1039
	[main] CMD: /home/xubo/xubo/tools/bwa-0.7.12/bwa mem bwaindex/GRCH38chr1L3556522.fasta g38l1000N100000.fq
	[main] Real time: 573.158 sec; CPU: 572.982 sec
	xubo@xubo:~/xubo/data/alignment/cs-bwamem$ samtools flagstat g38l1000N100000.bwamem.sam 
	100000 + 0 in total (QC-passed reads + QC-failed reads)
	0 + 0 secondary
	0 + 0 supplementary
	0 + 0 duplicates
	100000 + 0 mapped (100.00% : N/A)
	0 + 0 paired in sequencing
	0 + 0 read1
	0 + 0 read2
	0 + 0 properly paired (N/A : N/A)
	0 + 0 with itself and mate mapped
	0 + 0 singletons (N/A : N/A)
	0 + 0 with mate mapped to a different chr
	0 + 0 with mate mapped to a different chr (mapQ>=5)
