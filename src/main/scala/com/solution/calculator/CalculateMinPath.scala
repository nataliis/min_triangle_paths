package com.solution.calculator

import com.solution.api.Path
import com.solution.api.Types.Triangle

trait CalculateMinPath {
  def calculateMinPath(triangleList: Triangle): Path
}

class CalculateMinPathRecursively extends CalculateMinPath {

  override def calculateMinPath(triangleList: Triangle): Path = {

    def calculatePath(tree: Triangle): List[Path] = {
      tree match {
        case Nil => List.empty

        case x :: Nil =>
          x.sliding(2)
            .map(_.min)
            .map(node => Path(node, List(node)))
            .toList

        case x :: xs =>
          x.zip(calculatePath(xs)).map { case (t, p) =>
            Path(t + p.total, t :: p.path)
          }.sliding(2).map { pair =>
            if (pair.head.total <= pair.last.total) {
              pair.head
            } else {
              pair.last
            }
          }.toList
      }
    }
    calculatePath(triangleList) match {
      case Nil => Path(0, List.empty)
      case x :: _ => x
    }
  }
}
