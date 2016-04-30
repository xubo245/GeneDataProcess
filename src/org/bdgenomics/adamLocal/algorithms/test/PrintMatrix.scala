package org.bdgenomics.adamLocal.algorithms.test

import org.apache.tools.ant.taskdefs.Length

trait PrintMatrix {
  def printMatrixWithName[T](arr: Array[Array[T]],xSequence:String,ySequence:String): Unit = {
    //print number of col
    print("     ");
    for (i <- 0 until arr(0).length) {
      print(i + " ");
       for(l<-0 until arr(0)(0).toString.length()-1){
          print(" ");
        }
    }
    println();

    //print ySequence
    print("     ");
    for (i <- 0 until arr(0).length) {
      if (i == 0) { print("- ");
       for(l<-0 until arr(0)(0).toString.length()-1){
          print(" ");
        }
      } else {
        print(ySequence(i - 1) + " ");
        
        for(l<-0 until arr(0)(0).toString.length()-1){
          print(" ");
        }
      }
    }
    println();

    //print scoringMatrix
    for (i <- 0 until arr.length) {
      if (i == 0) { print(i + "=-: "); } else {
        print(i + "=" + xSequence(i - 1) + ": ");
      }
      for (j <- 0 until arr(i).length) {
        print(arr(i)(j) + " ");
      }
      println();
    }

  }
}