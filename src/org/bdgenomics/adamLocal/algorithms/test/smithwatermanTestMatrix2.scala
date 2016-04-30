package org.bdgenomics.adamLocal.algorithms.test

import org.bdgenomics.adamLocal.algorithms.smithwaterman.SmithWatermanConstantGapScoring

object smithwatermanTestMatrix2 {

  def main(args: Array[String]): Unit = {
    //    assert(false)
    //     SmithWatermanConstantGapScoring(
    //  xSequence: String,
    //  ySequence: String,
    //  wMatch: Double,
    //  wMismatch: Double,
    //  wInsert: Double,
    //  wDelete: Double)
    val startTime = System.currentTimeMillis()
    val xSequence = "ATCCGGGG"
    val ySequence = "ATACG"
    val s1 = new SmithWatermanConstantGapScoring(xSequence, ySequence, 4.0, -3.0, -4.0, -4)
    //    AAAATTCGGGGG
    println("s1:" + s1);
    println("s1.cigarX:" + s1.cigarX);
    println("s1.cigarY:" + s1.cigarY);
    println("s1.xStart:" + s1.xStart);
    println("s1.yStart:" + s1.yStart);
    
    
    
    val sm = s1.scoringMatrix
    println();
    println("scoringMatrix.length:"+sm.length);
    println("xSequence:" + xSequence);
    println("ySequence:" + ySequence);

    //print number of col
    print("     ");
    for (i <- 0 until sm(0).length) {
      print(i + "   ");
    }
    println();

    //print ySequence
    print("     ");
    for (i <- 0 until sm(0).length) {
      if (i == 0) { print("-   "); } else {
        print(ySequence(i - 1) + "   ");
      }
    }
    println();

    //print scoringMatrix
    for (i <- 0 until sm.length) {
      if (i == 0) { print(i + "=-: "); } else {
        print(i + "=" + xSequence(i - 1) + ": ");
      }
      for (j <- 0 until sm(i).length) {
        print(sm(i)(j) + " ");
      }
      println();
    }

    //print moveMatrix
    println();
    val mm = s1.moveMatrix
    println("moveMatrix.length:"+mm.length);
    print("     ");
    for (i <- 0 until mm(0).length) {
      print(i + " ");
      //      print(i+"=>"+xSequence(i)+" ");
    }
    println();
    
    print("     ");
     for (i <- 0 until sm(0).length) {
      if (i == 0) { print("- "); } else {
        print(ySequence(i - 1) + " ");
      }
    }
    println();
    
    for (i <- 0 until mm.length) {
       if (i == 0) { print(i + "=-: "); } else {
        print(i + "=" + xSequence(i - 1) + ": ");
      }
//      print(i + ": ");
      for (j <- 0 until mm(i).length) {
        print(mm(i)(j) + " ");
      }
      println();
    }
    //    for (i <- s1.scoringMatrix) {
    //      for (j <- i) {
    //        print(j + " ");
    //      }
    //      println();
    //    }
    //    for (i <- s1.moveMatrix) {
    //      for (j <- i) {
    //        print(j + " ");
    //      }
    //      println();
    //    }
    val endTime = System.currentTimeMillis()
    println("Time: " + (endTime - startTime) + " ms")
    
//    PrintMatrix.
  }

}