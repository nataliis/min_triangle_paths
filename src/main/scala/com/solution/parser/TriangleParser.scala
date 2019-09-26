package com.solution.parser

import com.solution.api.Types.ErrorOr
import scala.util.Try

class TriangleParser {

  def parseLine(line: String, index: Int): ErrorOr[List[Int]] = {
    Try {
      line
        .split("\\s+")
        .filter(_.nonEmpty)
        .map(_.trim.toInt)
    }.toOption
      .fold[ErrorOr[List[Int]]](Left("Triangle must contain only digits")) {
        case digits if digits.length != index =>
          Left(s"Line $index of triangle must contain $index digits")
        case digits =>
          Right(digits.toList)
      }
  }
}
