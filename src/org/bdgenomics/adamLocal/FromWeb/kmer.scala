package org.bdgenomics.adamLocal.FromWeb; /**
 * @author xubo
 * From https://github.com/bigdatagenomics/adam
 * no package
 * run:adam-shell -i kmer.scala
 */ //import org.bdgenomics.adam.rdd.ADAMContext
 //import org.bdgenomics.adam.projections.{AlignmentRecordField, Projection}
 //
 //val ac = new ADAMContext(sc)
 //// Load alignments from disk
 //val reads = ac.loadAlignments("/xubo/adam/output/small.adam",
 //  projection = Some(
 //    Projection(
 //      AlignmentRecordField.sequence,
 //      AlignmentRecordField.readMapped,
 //      AlignmentRecordField.mapq
 //    )
 //  )
 //)
 //
 //// Generate, count and sort 21-mers
 //  val kmers =reads.flatMap(_.getSequence.sliding(21).map(k => (k, 1L))).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false)
 // 
 //
 //// Print the top 10 most common 21-mers
 //kmers.take(10).foreach(println)
 