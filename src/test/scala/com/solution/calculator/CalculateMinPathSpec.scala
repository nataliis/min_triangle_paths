package com.solution.calculator

import org.scalatest.FunSuite

class CalculateMinPathSpec extends FunSuite {

  val calculator: CalculateMinPath = new CalculateMinPathRecursively()

  test("return the path with the min sum in the triangle") {
    val triangle = List(
      List(7),
      List(6, 3),
      List(3, 8, 5),
      List(11, 2, 10, 9)
    )
    val result = calculator.calculateMinPath(triangle)

    val expectedPath = List(7, 6, 3, 2)
    assert(result.path == expectedPath)
    assert(result.total == 18)

    val expectedOutput = "7 + 6 + 3 + 2 = 18"
    assert(expectedOutput == result.toString)
  }

  test("return the only element in triangle") {
    val triangle = List(8)
    val testTriangle = List(triangle)
    val result = calculator.calculateMinPath(testTriangle)

    val expectedPath = List(7, 6, 3, 2)
    assert(result.path == triangle)
    assert(result.total == 8)

    val expectedOutput = "8 = 8"
    assert(expectedOutput == result.toString)
  }

  test("returns min path in the triangle with negative numbers") {
    val triangle = List(
      List(5),
      List(-6, 11),
      List(2, 8, 4, 0),
      List(13, -5, 10, 4)
    )
    val result = calculator.calculateMinPath(triangle)

    val expectedPath = List(5, -6, 2, -5)
    assert(result.path == expectedPath)
    assert(result.total == -4)

    val expectedOutput = "5 + -6 + 2 + -5 = -4"
    assert(expectedOutput == result.toString)
  }

  test("shouldn't fail on empty input") {
    val result = calculator.calculateMinPath(List.empty)
    assert(result.path == List.empty)
    assert(result.total == 0)
    val expectedOutput = "empty"
    assert(expectedOutput == result.toString)
  }
}
