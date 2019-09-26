package com.solution.api

case class Path(total: Int, path: List[Int]) {

  override def toString: String = {
    val numbersSum = path.foldLeft("")((acc, e) => acc + s" $e +").dropRight(1).trim
    s"$numbersSum = $total"
  }
}
