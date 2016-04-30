package org.xubo.other.test1

object printx {

  def main(args: Array[String]): Unit = {
    var i = 10000L;
    while (i < 1000000000000L) {
      print(i + ",");
      i = i * 10;
    }
    //    for(i <- 10000L to 1000000000000L){
    //      
    //      print(i+",");
    //      i=i*10;
    //    }
  }

}