package com.solution.reader

import com.solution.api.Types.{ErrorOr, Triangle}
import com.solution.parser.TriangleParser

import scala.io.StdIn

trait TriangleReader {
  def read(): ErrorOr[Triangle]
}

class StdInTriangleReader(parser: TriangleParser) extends TriangleReader {
  override def read(): ErrorOr[Triangle] = {
    val triangle: List[ErrorOr[List[Int]]] =
      Iterator.continually(StdIn.readLine())
        .takeWhile(!_.equals("EOF"))
        .zipWithIndex.map { case (line, index) =>
        parser.parseLine(line, index + 1)
      }.toList

    triangle.partitionMap(identity) match {
      case (Nil, list) => Right(list)
      case (errors, _) => Left(errors.toSet.mkString(", "))
    }
  }
}
