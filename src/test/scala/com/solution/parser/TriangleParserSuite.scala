package com.solution.parser

import org.scalatest.FunSuite

class TriangleParserSuite extends FunSuite {

  val parser: TriangleParser = new TriangleParser

  test("should parse input properly") {
    val res1 = parser.parseLine("5", 1)
    assert(res1 == Right(List(5)))

    val res2 = parser.parseLine("2 8 0", 3)
    assert(res2 == Right(List(2, 8, 0)))

    val res3 = parser.parseLine("1 2 4", 2)
    assert(res3 == Left("Line 2 of triangle must contain 2 digits"))

    val res4 = parser.parseLine("1 4 a", 3)
    assert(res4 == Left("Triangle must contain only digits"))

    val res5 = parser.parseLine("2   8  0 6", 4)
    assert(res5 == Right(List(2, 8, 0, 6)))
  }
}
