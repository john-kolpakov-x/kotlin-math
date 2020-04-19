package kz.pompei.kotlin_math.graph.model

class CurveArray(val curves: List<Curve>) : Curve {

  override val beginT: Double get() = 0.0
  override val endT: Double get() = curves.map { it.endT - it.beginT }.sum()

  override fun at(t: Double): vec {
    if (t < 0.0) {
      throw RuntimeException("uUi4i5HgBA :: t = $t BUT must be in 0 ... $endT")
    }

    var tt = t

    for (curve in curves) {

      val size = curve.endT - curve.beginT
      if (tt <= size) {
        return curve.at(curve.beginT + tt)
      }

      tt -= size
    }

    throw RuntimeException("50doWfKEX3 :: t = $t BUT must be in 0 ... $endT")
  }

  companion object {
    fun brokenLine(vararg points: vec): CurveArray {
      val list: MutableList<Curve> = mutableListOf()

      for (i in points.indices) {
        val p1 = points[i]
        val j = i + 1
        val p2 = points[if (j < points.size) j else 0]
        list.add(Ray.segment(p1, p2))
      }

      return CurveArray(list)
    }
  }

  override fun intersection(ray: Ray): CurveRayIntersections {
    return CurveRayIntersections.union(curves.map { it.intersection(ray) })
  }
}
