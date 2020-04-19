package kz.pompei.kotlin_math.graph.model

class CurveRayIntersections(val list: List<CurveRayIntersection>) {
  companion object {
    fun union(list: List<CurveRayIntersections>) = CurveRayIntersections(list.flatMap { it.list })
  }
}
