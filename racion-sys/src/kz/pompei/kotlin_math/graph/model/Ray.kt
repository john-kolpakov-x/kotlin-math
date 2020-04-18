package kz.pompei.kotlin_math.graph.model

/**
 * Луч из точки О в направлении вектора dir
 *
 * На луче есть локальная ось координат. Ноль - это точка O. А единица - (O + dir)
 */
class Ray(val O: vec, val dir: vec) {

  /**
   * Получение точки на луче с локальной координатой t
   */
  fun at(t: Double): vec = O + dir * t
  fun at(t: Int): vec = at(t.toDouble())

}
