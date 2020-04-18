package kz.pompei.kotlin_math.graph.model

/**
 * Результаты пересечения эллипса и прямой
 *
 *
 */
data class EllipseRayIntersection(
  /**
   * Локальная координата на луче первой точки
   */
  val t: Double,

  /**
   * Локальная координата на эллипсе первой точки
   */
  val fi: Double
)
