package kz.pompei.kotlin_math.graph.model

interface Curve {

  fun at(t: Double): vec

  val beginT: Double

  val endT: Double

  fun intersection(ray: Ray): CurveRayIntersections

}
