package org.bdgenomics.adamLocal.algorithms.test

import org.bdgenomics.adam.algorithms.smithwaterman.SmithWatermanConstantGapScoring

object smithwatermanTest {

 
  def main(args: Array[String]): Unit = {
    //    assert(false)
    val startTime=System.currentTimeMillis()
    val s1 = new SmithWatermanConstantGapScoring("ATCCG", "ATACG", 4.0, -3.0, -4.0, -4)
//    AAAATTCGGGGG
     println("s1:" + s1);
    println("s1.cigarX:" + s1.cigarX);
    println("s1.cigarY:" + s1.cigarY);
    println("s1.xStart:" + s1.xStart);
    println("s1.yStart:" + s1.yStart);
    val sm=s1.scoringMatrix
    
    for (i <- s1.scoringMatrix) {
      for (j <- i) {
        print(j + " ");
      }
      println();
    }
    for (i <- s1.moveMatrix) {
      for (j <- i) {
        print(j + " ");
      }
      println();
    }
    val endTime=System.currentTimeMillis()
    println("Time: "+(endTime-startTime)+" ms")
  }

}