package kz.pompei.kotlin_math.graph.model

/**
 * Результаты пересечения кривой и луча
 */
data class CurveRayIntersection(
  /**
   * Локальная координата на луче
   *
   * Этот параметр лежит на всей координатной прямой
   */
  val rayT: Double,

  /**
   * Локальная координата на кривой
   *
   * Этот параметр лежит внутри области определения параметра кривой
   */
  val curveT: Double
)
