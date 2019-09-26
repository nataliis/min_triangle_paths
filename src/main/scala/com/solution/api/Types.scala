package com.solution.api

object Types {
  type ErrorOr[A] = Either[String, A]
  type Triangle = List[List[Int]]
}
