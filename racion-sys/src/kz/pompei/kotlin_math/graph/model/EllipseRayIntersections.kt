package kz.pompei.kotlin_math.graph.model

/**
 * Результаты пересечения эллипса и прямой
 *
 *
 */
class EllipseRayIntersections(
  val i1: EllipseRayIntersection,
  val i2: EllipseRayIntersection,

  /**
   * Наличие точек пересечения
   */
  val exists: Boolean
) {

  val minT: EllipseRayIntersection get() = if (i1.t < i2.t) i1 else i2
  val maxT: EllipseRayIntersection get() = if (i1.t > i2.t) i1 else i2

}
