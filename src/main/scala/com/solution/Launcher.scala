package com.solution

import com.solution.api.Path
import com.solution.calculator.{CalculateMinPath, CalculateMinPathRecursively}
import com.solution.parser.TriangleParser
import com.solution.reader.ConsoleTriangleReader

object Launcher {

  def main(args: Array[String]): Unit = {
    val parser = new TriangleParser
    val reader = new ConsoleTriangleReader(parser)
    val calculator: CalculateMinPath = new CalculateMinPathRecursively()

    reader.read() match {
      case Right(triangle) =>
        val result: Path = calculator.calculateMinPath(triangle)
        println(s"Minimal path is: $result")
      case Left(err) =>
        println(s"Error: $err")
    }
  }
}
