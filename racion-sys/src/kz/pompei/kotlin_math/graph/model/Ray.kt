package kz.pompei.kotlin_math.graph.model

/**
 * Луч из точки О в направлении вектора dir
 *
 * На луче есть локальная ось координат. Ноль - это точка O. А единица - (O + dir)
 */
class Ray(val O: vec, val dir: vec) : Curve {

  /**
   * Получение точки на луче с локальной координатой t
   */
  override fun at(t: Double): vec = O + dir * t
  fun at(t: Int): vec = at(t.toDouble())

  override val beginT: Double get() = 0.0
  override val endT: Double get() = 1.0

  companion object {
    fun segment(from: vec, to: vec) = Ray(from, to - from)
  }

  override fun intersection(ray: Ray): CurveRayIntersections {

    val curveT_top = ray.dir.x * O.y + ray.dir.y * ray.O.x - ray.dir.x * ray.O.y - ray.dir.y * O.x
    val curveT_bot = dir.x * ray.dir.y - ray.dir.x * dir.y

    val rayT_top = dir.x * ray.O.y + dir.y * O.x - dir.x * O.y - dir.y * ray.O.x
    val rayT_bot = ray.dir.x * dir.y - dir.x * ray.dir.y

    if (curveT_bot == 0.0 || rayT_bot == 0.0) {
      return CurveRayIntersections(emptyList())
    }

    val curveT = curveT_top / curveT_bot
    val rayT = rayT_top / rayT_bot

    if (curveT < beginT || curveT > endT) {
      return CurveRayIntersections(emptyList())
    }

    return CurveRayIntersections(listOf(CurveRayIntersection(rayT, curveT)))
  }

  override fun tangentAt(t: Double): vec = dir.norm
}
