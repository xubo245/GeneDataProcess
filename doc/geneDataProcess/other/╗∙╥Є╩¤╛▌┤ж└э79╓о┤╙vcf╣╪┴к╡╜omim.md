

1.数据：

    //    var vcfFile = "file/callDisease/input/small.vcf"
    //    var dbSnp2omimFile = "file/callDisease/input/omimFilter9Text.txt"
    //    var omimFile = "file/callDisease/input/genemap.txt"

修改过small数据：部分如下：
	
	1	14397	.	CTGT	C	139.12	IndelQD	AC=2;AF=0.333;AN=6;BaseQRankSum=1.800;ClippingRankSum=0.138;DP=69;FS=7.786;MLEAC=2;MLEAF=0.333;MQ=26.84;MQ0=0;MQRankSum=-1.906;QD=1.55;ReadPosRankSum=0.384	GT:AD:DP:FT:GQ:PL	0/1:16,4:20:rd:99:120,0,827	0/1:8,2:10:dp;rd:60:60,0,414	0/0:39,0:39:PASS:99:0,116,2114
	1	14522	.	G	A	195.16	VQSRTrancheSNP99.95to100.00	AC=2;AF=0.333;AN=6;BaseQRankSum=2.044;ClippingRankSum=-2.196;DP=48;FS=13.179;MLEAC=2;MLEAF=0.333;MQ=25.89;MQ0=0;MQRankSum=-0.063;QD=8.87;ReadPosRankSum=0.952;VQSLOD=-3.333e+00;culprit=MQ	GT:AD:DP:FT:GQ:PL	0/1:10,5:15:dp:99:99,0,233	0/1:2,5:7:dp;rd:34:128,0,34	0/0:26,0:26:PASS:78:0,78,783
	1	19190	.	GC	G	1186.88	PASS	AC=3;AF=0.500;AN=6;BaseQRankSum=4.157;ClippingRankSum=3.666;DP=74;FS=37.037;MLEAC=3;MLEAF=0.500;MQ=22.26;MQ0=0;MQRankSum=0.195;QD=16.04;ReadPosRankSum=-4.072	GT:AD:DP:FT:GQ:PL	0/1:8,14:22:PASS:99:416,0,201	0/1:18,13:31:PASS:99:353,0,503	0/1:5,15:20:rd:99:457,0,107
	1	63735	rs2236225	CCTA	C	2994.09	PASS	AC=1;AF=0.167;AN=6;BaseQRankSum=1.138;ClippingRankSum=0.448;DB;DP=176;FS=13.597;MLEAC=1;MLEAF=0.167;MQ=31.06;MQ0=0;MQRankSum=0.636;QD=9.98;ReadPosRankSum=-1.180	GT:AD:DP:FT:GQ:PL	0/0:27,0:27:PASS:79:0,79,1425	0/0:40,0:40:PASS:99:0,117,2120	0/1:23,74:97:rd:99:3034,0,942
	1	752721	rs3131972	A	G	2486.90	PASS	AC=6;AF=1.00;AN=6;DB;DP=69;FS=0.000;MLEAC=6;MLEAF=1.00;MQ=60.00;MQ0=0;POSITIVE_TRAIN_SITE;QD=31.67;VQSLOD=18.94;culprit=QD	GT:AD:DP:FT:GQ:PL	1/1:0,27:27:PASS:81:1021,81,0	1/1:0,19:19:dp:57:661,57,0	1/1:0,22:22:PASS:66:831,66,0


2.代码：
	
	##fileformat=VCFv4.1
	##FILTER=<ID=IndelFS,Description="FS > 200.0">
	##FILTER=<ID=IndelQD,Description="QD < 2.0">
	##FILTER=<ID=IndelReadPosRankSum,Description="ReadPosRankSum < -20.0">
	##FILTER=<ID=LowQual,Description="Low quality">
	##FILTER=<ID=VQSRTrancheSNP99.50to99.60,Description="Truth sensitivity tranche level for SNP model at VQS Lod: -0.5377 <= x < -0.1787">
	##FILTER=<ID=VQSRTrancheSNP99.60to99.70,Description="Truth sensitivity tranche level for SNP model at VQS Lod: -1.0634 <= x < -0.5377">
	##FILTER=<ID=VQSRTrancheSNP99.70to99.80,Description="Truth sensitivity tranche level for SNP model at VQS Lod: -1.7119 <= x < -1.0634">
	##FILTER=<ID=VQSRTrancheSNP99.80to99.90,Description="Truth sensitivity tranche level for SNP model at VQS Lod: -2.3301 <= x < -1.7119">
	##FILTER=<ID=VQSRTrancheSNP99.90to99.95,Description="Truth sensitivity tranche level for SNP model at VQS Lod: -2.8169 <= x < -2.3301">
	##FILTER=<ID=VQSRTrancheSNP99.95to100.00+,Description="Truth sensitivity tranche level for SNP model at VQS Lod < -1918.1929">
	##FILTER=<ID=VQSRTrancheSNP99.95to100.00,Description="Truth sensitivity tranche level for SNP model at VQS Lod: -1918.1929 <= x < -2.8169">
	##FILTER=<ID=dp,Description="Insufficient read depth">
	##FILTER=<ID=gq,Description="Insufficient genotype quality">
	##FILTER=<ID=rd,Description="Insufficient supporting reads">
	##FILTER=<ID=sx,Description="Heterozygous sex chromosomes in male sample, or Y chromosome in female sample">
	##FORMAT=<ID=AD,Number=.,Type=Integer,Description="Allelic depths for the ref and alt alleles in the order listed">
	##FORMAT=<ID=DP,Number=1,Type=Integer,Description="Approximate read depth (reads with MQ=255 or with bad mates are filtered)">
	##FORMAT=<ID=FT,Number=1,Type=String,Description="Genotype-level filter">
	##FORMAT=<ID=GQ,Number=1,Type=Integer,Description="Genotype Quality">
	##FORMAT=<ID=GT,Number=1,Type=String,Description="Genotype">
	##FORMAT=<ID=PL,Number=G,Type=Integer,Description="Normalized, Phred-scaled likelihoods for genotypes as defined in the VCF specification">
	##GATKCommandLine=<ID=CombineVariants,Version=2.7-63-gc434461,Date="Mon Oct 14 15:08:05 EDT 2013",Epoch=1381777685067,CommandLineOptions="analysis_type=CombineVariants input_file=[] read_buffer_size=null phone_home=NO_ET gatk_key=/packages/gatk/1.5-21-g979a84a/src/eugene.fluder_mssm.edu.key tag=NA read_filter=[] intervals=[/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/.queueScatterGather/.qlog/r1-1-1.combined.rawGT.vcf.combine-sg/temp_01_of_20/scatter.intervals] excludeIntervals=null interval_set_rule=UNION interval_merging=ALL interval_padding=0 reference_sequence=/projects/ngs/resources/gatk/2.3/ucsc.hg19.fasta nonDeterministicRandomSeed=false disableDithering=false maxRuntime=-1 maxRuntimeUnits=MINUTES downsampling_type=BY_SAMPLE downsample_to_fraction=null downsample_to_coverage=1000 baq=OFF baqGapOpenPenalty=40.0 fix_misencoded_quality_scores=false allow_potentially_misencoded_quality_scores=false useOriginalQualities=false defaultBaseQualities=-1 performanceLog=null BQSR=null quantize_quals=0 disable_indel_quals=false emit_original_quals=false preserve_qscores_less_than=6 globalQScorePrior=-1.0 allow_bqsr_on_reduced_bams_despite_repeated_warnings=false validation_strictness=SILENT remove_program_records=false keep_program_records=false sample_rename_mapping_file=null unsafe=null disable_auto_index_creation_and_locking_when_reading_rods=false num_threads=1 num_cpu_threads_per_data_thread=1 num_io_threads=0 monitorThreadEfficiency=false num_bam_file_handles=null read_group_black_list=null pedigree=[] pedigreeString=[] pedigreeValidationType=STRICT allow_intervals_with_unindexed_bam=false generateShadowBCF=false logging_level=INFO log_to_file=null help=false version=false variant=[(RodBinding name=SNP source=/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/r1-1-1.recal.SNP.vcf), (RodBinding name=Indel source=/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/r1-1-1.filt.IND.vcf)] out=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub no_cmdline_in_header=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub sites_only=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub bcf=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub genotypemergeoption=UNSORTED filteredrecordsmergetype=KEEP_IF_ANY_UNFILTERED multipleallelesmergetype=BY_TYPE rod_priority_list=null printComplexMerges=false filteredAreUncalled=false minimalVCF=false setKey=null assumeIdenticalSamples=true minimumN=1 suppressCommandLineHeader=false mergeInfoWithMaxAC=false filter_reads_with_N_cigar=false filter_mismatching_base_and_quals=false filter_bases_not_stored=false">
	##GATKCommandLine=<ID=GenotypeFiltration,Version=2.7-63-gc434461,Date="Mon Oct 14 15:13:40 EDT 2013",Epoch=1381778020289,CommandLineOptions="analysis_type=GenotypeFiltration input_file=[] read_buffer_size=null phone_home=NO_ET gatk_key=/packages/gatk/1.5-21-g979a84a/src/eugene.fluder_mssm.edu.key tag=NA read_filter=[] intervals=[/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/.queueScatterGather/.qlog/r1-1-1.combined.vcf.gtfilter-sg/temp_01_of_20/scatter.intervals] excludeIntervals=null interval_set_rule=UNION interval_merging=ALL interval_padding=0 reference_sequence=/projects/ngs/resources/gatk/2.3/ucsc.hg19.fasta nonDeterministicRandomSeed=false disableDithering=false maxRuntime=-1 maxRuntimeUnits=MINUTES downsampling_type=BY_SAMPLE downsample_to_fraction=null downsample_to_coverage=1000 baq=OFF baqGapOpenPenalty=40.0 fix_misencoded_quality_scores=false allow_potentially_misencoded_quality_scores=false useOriginalQualities=false defaultBaseQualities=-1 performanceLog=null BQSR=null quantize_quals=0 disable_indel_quals=false emit_original_quals=false preserve_qscores_less_than=6 globalQScorePrior=-1.0 allow_bqsr_on_reduced_bams_despite_repeated_warnings=false validation_strictness=SILENT remove_program_records=false keep_program_records=false sample_rename_mapping_file=null unsafe=null disable_auto_index_creation_and_locking_when_reading_rods=false num_threads=1 num_cpu_threads_per_data_thread=1 num_io_threads=0 monitorThreadEfficiency=false num_bam_file_handles=null read_group_black_list=null pedigree=[/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/r1-1-1.ped] pedigreeString=[] pedigreeValidationType=SILENT allow_intervals_with_unindexed_bam=false generateShadowBCF=false logging_level=INFO log_to_file=null help=false version=false variant=(RodBinding name=variant source=/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/r1-1-1.combined.rawGT.vcf) out=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub no_cmdline_in_header=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub sites_only=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub bcf=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub min_GQ=30.0 min_DP=20 min_AF=0.3 max_AF=0.7 maleHaploidIntervals=null femaleNoVarIntervals=null filter_reads_with_N_cigar=false filter_mismatching_base_and_quals=false filter_bases_not_stored=false">
	##GATKCommandLine=<ID=HaplotypeCaller,Version=2.7-63-gc434461,Date="Mon Oct 14 12:24:16 EDT 2013",Epoch=1381767856130,CommandLineOptions="analysis_type=HaplotypeCaller input_file=[/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/r1-1-1.cohort.list] read_buffer_size=null phone_home=NO_ET gatk_key=/packages/gatk/1.5-21-g979a84a/src/eugene.fluder_mssm.edu.key tag=NA read_filter=[] intervals=[/gs01/projects/ngs/validation/exome/CEPHTrio/2.7/r1-1-1/.queueScatterGather/.qlog/r1-1-1.both.vcf.haplotypecall-sg/temp_01_of_20/scatter.intervals] excludeIntervals=null interval_set_rule=UNION interval_merging=ALL interval_padding=0 reference_sequence=/projects/ngs/resources/gatk/2.3/ucsc.hg19.fasta nonDeterministicRandomSeed=false disableDithering=false maxRuntime=-1 maxRuntimeUnits=MINUTES downsampling_type=BY_SAMPLE downsample_to_fraction=null downsample_to_coverage=250 baq=OFF baqGapOpenPenalty=40.0 fix_misencoded_quality_scores=false allow_potentially_misencoded_quality_scores=false useOriginalQualities=false defaultBaseQualities=-1 performanceLog=null BQSR=null quantize_quals=0 disable_indel_quals=false emit_original_quals=false preserve_qscores_less_than=6 globalQScorePrior=-1.0 allow_bqsr_on_reduced_bams_despite_repeated_warnings=false validation_strictness=SILENT remove_program_records=false keep_program_records=false sample_rename_mapping_file=null unsafe=null disable_auto_index_creation_and_locking_when_reading_rods=false num_threads=1 num_cpu_threads_per_data_thread=16 num_io_threads=0 monitorThreadEfficiency=false num_bam_file_handles=null read_group_black_list=null pedigree=[] pedigreeString=[] pedigreeValidationType=STRICT allow_intervals_with_unindexed_bam=false generateShadowBCF=false logging_level=INFO log_to_file=null help=false version=false out=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub no_cmdline_in_header=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub sites_only=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub bcf=org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub graphOutput=null bamOutput=null bam_compression=null disable_bam_indexing=null generate_md5=null simplifyBAM=null bamWriterType=CALLED_HAPLOTYPES dbsnp=(RodBinding name=dbsnp source=/projects/ngs/resources/gatk/2.3/dbsnp_137.hg19.vcf) comp=[] annotation=[ClippingRankSumTest, DepthPerSampleHC] excludeAnnotation=[SpanningDeletions, TandemRepeatAnnotator] heterozygosity=0.001 indel_heterozygosity=1.25E-4 genotyping_mode=DISCOVERY standard_min_confidence_threshold_for_calling=30.0 standard_min_confidence_threshold_for_emitting=20.0 alleles=(RodBinding name= source=UNBOUND) max_alternate_alleles=6 input_prior=[] contamination_fraction_to_filter=0.0 contamination_fraction_per_sample_file=null p_nonref_model=EXACT_INDEPENDENT exactcallslog=null kmerSize=[10, 25] dontIncreaseKmerSizesForCycles=false numPruningSamples=1 dontRecoverDanglingTails=false emitRefConfidence=NONE GVCFGQBands=[1, 10, 20, 30, 40, 50] indelSizeToEliminateInRefModel=10 minPruning=2 gcpHMM=10 includeUmappedReads=false useAllelesTrigger=false useFilteredReadsForAnnotations=false phredScaledGlobalReadMismappingRate=45 maxNumHaplotypesInPopulation=128 mergeVariantsViaLD=false pair_hmm_implementation=LOGLESS_CACHING keepRG=null justDetermineActiveRegions=false dontGenotype=false errorCorrectKmers=false debug=false debugGraphTransformations=false useLowQualityBasesForAssembly=false dontTrimActiveRegions=false dontUseSoftClippedBases=false captureAssemblyFailureBAM=false allowCyclesInKmerGraphToGeneratePaths=false noFpga=false errorCorrectReads=false kmerLengthForReadErrorCorrection=25 minObservationsForKmerToBeSolid=20 maxDiscARExtension=25 maxGGAARExtension=300 paddingAroundIndels=150 paddingAroundSNPs=20 pcr_indel_model=CONSERVATIVE activityProfileOut=null activeRegionOut=null activeRegionIn=null activeRegionExtension=null forceActive=false activeRegionMaxSize=null bandPassSigma=null min_mapping_quality_score=20 filter_reads_with_N_cigar=false filter_mismatching_base_and_quals=false filter_bases_not_stored=false">
	##INFO=<ID=AC,Number=A,Type=Integer,Description="Allele count in genotypes, for each ALT allele, in the same order as listed">
	##INFO=<ID=AF,Number=A,Type=Float,Description="Allele Frequency, for each ALT allele, in the same order as listed">
	##INFO=<ID=AN,Number=1,Type=Integer,Description="Total number of alleles in called genotypes">
	##INFO=<ID=BaseQRankSum,Number=1,Type=Float,Description="Z-score from Wilcoxon rank sum test of Alt Vs. Ref base qualities">
	##INFO=<ID=ClippingRankSum,Number=1,Type=Float,Description="Z-score From Wilcoxon rank sum test of Alt vs. Ref number of hard clipped bases">
	##INFO=<ID=DB,Number=0,Type=Flag,Description="dbSNP Membership">
	##INFO=<ID=DP,Number=1,Type=Integer,Description="Approximate read depth; some reads may have been filtered">
	##INFO=<ID=DS,Number=0,Type=Flag,Description="Were any of the samples downsampled?">
	##INFO=<ID=END,Number=1,Type=Integer,Description="Stop position of the interval">
	##INFO=<ID=FS,Number=1,Type=Float,Description="Phred-scaled p-value using Fisher's exact test to detect strand bias">
	##INFO=<ID=HaplotypeScore,Number=1,Type=Float,Description="Consistency of the site with at most two segregating haplotypes">
	##INFO=<ID=InbreedingCoeff,Number=1,Type=Float,Description="Inbreeding coefficient as estimated from the genotype likelihoods per-sample when compared against the Hardy-Weinberg expectation">
	##INFO=<ID=MLEAC,Number=A,Type=Integer,Description="Maximum likelihood expectation (MLE) for the allele counts (not necessarily the same as the AC), for each ALT allele, in the same order as listed">
	##INFO=<ID=MLEAF,Number=A,Type=Float,Description="Maximum likelihood expectation (MLE) for the allele frequency (not necessarily the same as the AF), for each ALT allele, in the same order as listed">
	##INFO=<ID=MQ,Number=1,Type=Float,Description="RMS Mapping Quality">
	##INFO=<ID=MQ0,Number=1,Type=Integer,Description="Total Mapping Quality Zero Reads">
	##INFO=<ID=MQRankSum,Number=1,Type=Float,Description="Z-score From Wilcoxon rank sum test of Alt vs. Ref read mapping qualities">
	##INFO=<ID=NEGATIVE_TRAIN_SITE,Number=0,Type=Flag,Description="This variant was used to build the negative training set of bad variants">
	##INFO=<ID=POSITIVE_TRAIN_SITE,Number=0,Type=Flag,Description="This variant was used to build the positive training set of good variants">
	##INFO=<ID=QD,Number=1,Type=Float,Description="Variant Confidence/Quality by Depth">
	##INFO=<ID=ReadPosRankSum,Number=1,Type=Float,Description="Z-score from Wilcoxon rank sum test of Alt vs. Ref read position bias">
	##INFO=<ID=VQSLOD,Number=1,Type=Float,Description="Log odds ratio of being a true variant versus being false under the trained gaussian mixture model">
	##INFO=<ID=culprit,Number=1,Type=String,Description="The annotation which was the worst performing in the Gaussian mixture model, likely the reason why the variant was filtered out">
	#CHROM	POS	ID	REF	ALT	QUAL	FILTER	INFO	FORMAT	NA12878	NA12891	NA12892
	1	14397	.	CTGT	C	139.12	IndelQD	AC=2;AF=0.333;AN=6;BaseQRankSum=1.800;ClippingRankSum=0.138;DP=69;FS=7.786;MLEAC=2;MLEAF=0.333;MQ=26.84;MQ0=0;MQRankSum=-1.906;QD=1.55;ReadPosRankSum=0.384	GT:AD:DP:FT:GQ:PL	0/1:16,4:20:rd:99:120,0,827	0/1:8,2:10:dp;rd:60:60,0,414	0/0:39,0:39:PASS:99:0,116,2114
	1	14522	.	G	A	195.16	VQSRTrancheSNP99.95to100.00	AC=2;AF=0.333;AN=6;BaseQRankSum=2.044;ClippingRankSum=-2.196;DP=48;FS=13.179;MLEAC=2;MLEAF=0.333;MQ=25.89;MQ0=0;MQRankSum=-0.063;QD=8.87;ReadPosRankSum=0.952;VQSLOD=-3.333e+00;culprit=MQ	GT:AD:DP:FT:GQ:PL	0/1:10,5:15:dp:99:99,0,233	0/1:2,5:7:dp;rd:34:128,0,34	0/0:26,0:26:PASS:78:0,78,783
	1	19190	.	GC	G	1186.88	PASS	AC=3;AF=0.500;AN=6;BaseQRankSum=4.157;ClippingRankSum=3.666;DP=74;FS=37.037;MLEAC=3;MLEAF=0.500;MQ=22.26;MQ0=0;MQRankSum=0.195;QD=16.04;ReadPosRankSum=-4.072	GT:AD:DP:FT:GQ:PL	0/1:8,14:22:PASS:99:416,0,201	0/1:18,13:31:PASS:99:353,0,503	0/1:5,15:20:rd:99:457,0,107
	1	63735	rs2236225	CCTA	C	2994.09	PASS	AC=1;AF=0.167;AN=6;BaseQRankSum=1.138;ClippingRankSum=0.448;DB;DP=176;FS=13.597;MLEAC=1;MLEAF=0.167;MQ=31.06;MQ0=0;MQRankSum=0.636;QD=9.98;ReadPosRankSum=-1.180	GT:AD:DP:FT:GQ:PL	0/0:27,0:27:PASS:79:0,79,1425	0/0:40,0:40:PASS:99:0,117,2120	0/1:23,74:97:rd:99:3034,0,942
	1	752721	rs3131972	A	G	2486.90	PASS	AC=6;AF=1.00;AN=6;DB;DP=69;FS=0.000;MLEAC=6;MLEAF=1.00;MQ=60.00;MQ0=0;POSITIVE_TRAIN_SITE;QD=31.67;VQSLOD=18.94;culprit=QD	GT:AD:DP:FT:GQ:PL	1/1:0,27:27:PASS:81:1021,81,0	1/1:0,19:19:dp:57:661,57,0	1/1:0,22:22:PASS:66:831,66,0


3.脚本：

（1）
	
	hadoop@Master:~/xubo/project/callDisease/dataConnectArgsWithOutputPath2$ cat load.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.disease.dataConnectArgsWithOutputPath2 \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/callDisease/input/small.vcf /xubo/callDisease/input/omimFilter9Text.txt /xubo/callDisease/input/genemap.txt /xubo/callDisease/output/small.output
	

（2）
	
	hadoop@Master:~/xubo/project/callDisease/dataConnectArgsWithOutputPath2$ cat allVcf.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.gcdss.cli.disease.dataConnectArgsWithOutputPath2 \
	--master spark://219.219.220.149:7077 \
	--conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
	--conf spark.kryo.registrator=org.bdgenomics.adam.serialization.ADAMKryoRegistrator \
	--jars /home/hadoop/cloud/adam/lib/adam-apis_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-cli_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/lib/adam-core_2.10-0.18.3-SNAPSHOT.jar,/home/hadoop/cloud/adam/xubo/data/GRCH38Sub/cs-bwamem/BWAMEMSparkAll/gcdss-cli-0.0.3-SNAPSHOT.jar \
	--executor-memory 4096M \
	--total-executor-cores 20 BWAMEMSparkAll.jar \
	/xubo/callVariant/vcf/All_20160407.vcf /xubo/callDisease/input/omimFilter9Text.txt /xubo/callDisease/input/genemap.txt /xubo/callDisease/output/small.output
	

4.运行结果：
本版本的：
	(172460,(rs2236225,1,63735,CCTA,C),(omim,14.277,8,25,06,14q23.3,MTHFD, MTHFC,C,5,10-methylenetetrahydrofolate dehydrogenase,,5,10-methylenetetrahydrofolate cyclohydrolase,S, REa, A))

simple:

	(172460,rs2236225,1,63735,CCTA,C)

时间：

	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	vcfRdd.count:5                                                                  
	vcfFilterRDD.count:2                                                            
	dbSnp2omimRdd.count:11199                                                       
	dbSnp2omimFilterRDD.count:11199                                                 
	vcf2omimRDD.count:1                                                             
	vcf2omimSimpleRDD.count:1                                                       
	omimRdd.count:15705
	outputRDD.count:1                                                               
	load time:50084 ms
	save time:4306 ms                                                               
	run time:54390 ms

	hadoop@Master:~/xubo/project/callDisease/dataConnectArgsWithOutputPath2$ ./allVcf.sh 
	start:
	vcfFile:/xubo/callVariant/vcf/All_20160407.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	vcfRdd.count:152331373                                                          
	vcfFilterRDD.count:152331373                                                    
	dbSnp2omimRdd.count:11199
	dbSnp2omimFilterRDD.count:11199
	vcf2omimRDD.count:11189                                                         
	vcf2omimSimpleRDD.count:11189                                                   
	omimRdd.count:15705                                                             
	outputRDD.count:10884                                                           
	load time:1497800 ms
	save time:40709 ms                                                              
	run time:1538509 ms
	16/06/09 10:07:06 WARN QueuedThreadPool: 1 threads could not be stopped


第二次：
	
	hadoop@Master:~/xubo/project/callDisease/dataConnectArgsWithOutputPath2$ ./load.sh 
	start:
	vcfFile:/xubo/callDisease/input/small.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	vcfRdd.count:5                                                                  
	vcfFilterRDD.count:2                                                            
	dbSnp2omimRdd.count:11199                                                       
	dbSnp2omimFilterRDD.count:11199                                                 
	vcf2omimRDD.count:1                                                             
	vcf2omimSimpleRDD.count:1                                                       
	omimRdd.count:15705                                                             
	outputRDD.count:1                                                               
	load time:51651 ms
	save time:3410 ms                                                               
	run time:55061 ms
	hadoop@Master:~/xubo/project/callDisease/dataConnectArgsWithOutputPath2$ ./allVcf.sh 
	start:
	vcfFile:/xubo/callVariant/vcf/All_20160407.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	vcfRdd.count:152331373                                                          
	vcfFilterRDD.count:152331373                                                    
	dbSnp2omimRdd.count:11199
	dbSnp2omimFilterRDD.count:11199
	vcf2omimRDD.count:11189                                                         
	vcf2omimSimpleRDD.count:11189                                                   
	omimRdd.count:15705                                                             
	outputRDD.count:10884                                                           
	load time:1289263 ms
	save time:94502 ms                                                              
	run time:1383765 ms
	16/06/09 09:39:33 WARN QueuedThreadPool: 1 threads could not be stopped


AllVCF与脚本不一致，脚本的今晚在跑，之前跑过没有输出路径的:
时间:

	hadoop@Master:~/xubo/project/callDisease/dataConnectArgs$ ./load.sh 
	start:
	vcfFile:/xubo/callDisease/input/small.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	vcfRdd.count:5                                                                  
	vcfFilterRDD.count:2                                                            
	dbSnp2omimRdd.count:11199                                                       
	dbSnp2omimFilterRDD.count:11199                                                 
	vcf2omimRDD.count:1                                                             
	vcf2omimSimpleRDD.count:1                                                       
	omimRdd.count:15705
	outputRDD.count:1                                                               
	load time:40376 ms
	save time:1987 ms                                                               
	run time:42363 ms

AllVCF:

	hadoop@Master:~/xubo/project/callDisease/dataConnectArgs$ ./AllVCF.sh 
	start:
	vcfFile:/xubo/callVariant/vcf/All_20160407.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	vcfRdd.count:152331373                                                          
	vcfFilterRDD.count:152331373                                                    
	dbSnp2omimRdd.count:11199
	dbSnp2omimFilterRDD.count:11199
	vcf2omimRDD.count:11189                                                         
	vcf2omimSimpleRDD.count:11189                                                   
	omimRdd.count:15705                                                             
	outputRDD.count:10884                                                           
	load time:1558976 ms
	save time:59851 ms                                                              
	run time:1618827 ms




