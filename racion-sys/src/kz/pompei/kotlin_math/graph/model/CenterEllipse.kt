package kz.pompei.kotlin_math.graph.model

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class CenterEllipse(val Rx: Double, val Ry: Double) {

  constructor(Rx: Int, Ry: Int) : this(Rx.toDouble(), Ry.toDouble())

  fun at(fi: Double): vec = vec(Rx * cos(fi), Ry * sin(fi))

  /**
   * Вычисляет точки пересечения луча с эллипсом
   *
   * Возвращает внутренние координаты
   */
  fun intersections(ray: Ray): EllipseRayIntersections {
    val a = ray.dir.x * ray.dir.x * Ry * Ry + ray.dir.y * ray.dir.y * Rx * Rx
    val b = 2 * (ray.dir.x * Ry * Ry * ray.O.x + ray.dir.y * Rx * Rx * ray.O.y)
    val c = ray.O.x * ray.O.x * Ry * Ry + ray.O.y * ray.O.y * Rx * Rx - Rx * Rx * Ry * Ry

    val D = b * b - 4 * a * c

    if (D < 0) {
      return EllipseRayIntersections(
        exists = false,
        i1 = EllipseRayIntersection(0.0, 0.0),
        i2 = EllipseRayIntersection(0.0, 0.0)
      )
    }

    val t1 = (-b + sqrt(D)) / (2 * a)
    val t2 = (-b - sqrt(D)) / (2 * a)

    val fi1 = calcFi(t1, ray);
    val fi2 = calcFi(t2, ray);

    return EllipseRayIntersections(
      exists = true,
      i1 = EllipseRayIntersection(t1, fi1),
      i2 = EllipseRayIntersection(t2, fi2)
    )
  }

  private fun calcFi(t: Double, ray: Ray): Double {
    val p = ray.at(t)
    return atan2(p.y / Ry, p.x / Rx)
  }

  /**
   * Получает единичный вектор направленный по касательной эллипса в точке fi в сторону возрастания fi
   */
  fun tangentAt(fi: Double): vec = vec(-Rx * sin(fi), Ry * cos(fi)).norm

}
