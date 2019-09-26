package com.solution.api

case class Path(total: Int, path: List[Int]) {

  override def toString: String = {
    path match {
      case Nil =>
        "empty"
      case list =>
        val numbersSum = list.foldLeft("")((acc, e) => acc + s" $e +").dropRight(1).trim
        s"$numbersSum = $total"
    }
  }
}
