	
	
	hadoop@Master:~/xubo/project/callDisease/DataProcessing$ ./allVcf.sh 
	start:
	vcfFile:/xubo/callVariant/vcf/All_20160407.vcf
	dbSnp2omimFile:/xubo/callDisease/input/omimFilter9Text.txt
	omimFile:/xubo/callDisease/input/genemap.txt
	output:/xubo/callDisease/output/AllVCF.output
	vcfRdd.count:152331373                                                          
	vcfFilterRDD.count:152331373                                                    
	dbSnp2omimRdd.count:11199
	dbSnp2omimFilterRDD.count:11199
	vcf2omimRDD.count:11189                                                         
	vcf2omimSimpleRDD.count:11189                                                   
	omimRdd.count:15705                                                             
	outputRDD.count:10884                                                           
	end
	load time:2107773 ms
	outputSaveRDD:/xubo/callDisease/output/AllVCF.output/20160610000857365          
	outputSaveRDD2:/xubo/callDisease/output/AllVCF.output/Simple20160610000857365
	save time:64535 ms
	run time:2172308 ms
	16/06/10 00:10:02 WARN QueuedThreadPool: 1 threads could not be stopped
