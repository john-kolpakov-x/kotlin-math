package kz.pompei.kotlin_math.graph.model

class CurveRayIntersections(val list: List<CurveRayIntersection>) {

  fun minRayT(filterX: (c: CurveRayIntersection) -> Boolean): CurveRayIntersection? {
    return list.filter(filterX).minBy { it.rayT }
  }

  companion object {
    fun union(list: List<CurveRayIntersections>) = CurveRayIntersections(list.flatMap { it.list })
  }
}
