package org.bdgenomics.adamLocal.algorithms.test

import org.bdgenomics.adamLocal.algorithms.smithwaterman.SmithWatermanConstantGapScoring

object testPrint2 extends PrintMatrix {

  def main(args: Array[String]): Unit = {
    val xSequence = "TTCGAGT"
    val ySequence = "ATTCCAAGAAAA"
    val s1 = new SmithWatermanConstantGapScoring(xSequence, ySequence, 4.0, -3.0, -4.0, -4)
    printMatrixWithName(s1.scoringMatrix, xSequence, ySequence)
    println();
    printMatrixWithName(s1.moveMatrix, xSequence, ySequence)
    println();
    println("s1.maxScore:" + s1.maxScore);
    //    println("s1:" + s1);
    println("s1.cigarX:" + s1.cigarX);
    println("s1.cigarY:" + s1.cigarY);
    println("s1.xStart:" + s1.xStart);
    println("s1.yStart:" + s1.yStart);
    println("xSequence:" + xSequence);
    println("ySequence:" + ySequence);
  }

}