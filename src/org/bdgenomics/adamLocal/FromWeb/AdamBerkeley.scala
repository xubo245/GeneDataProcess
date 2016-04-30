package org.bdgenomics.adamLocal.FromWeb; //package com.adam.code.FromWeb
//import org.bdgenomics.adam.rdd.ADAMContext._
//import org.bdgenomics.adam.rdd.read.AlignmentRecordContext._
//object AdamBerkeley {
//
////val reads = sc.loadAlignments("/xubo/adam/output/artificial.adam").cache()
//val reads =sc.loadAlignments("/xubo/adam/NA12878/NA12878.adam").cache()
//reads.count
//println(reads.first)
//
//val kmers = reads.adamCountKmers(20).cache()
//kmers.count()
//val counts = kmers.map(kv => kv._2).countByValue()
// println(counts.toList.sortBy(kv => kv._1))
//
// val bases = kmers.filter(kv => kv._2 == 1).flatMap(kv => kv._1).countByValue()
//
//}