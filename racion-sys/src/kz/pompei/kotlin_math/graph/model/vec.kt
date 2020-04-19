package kz.pompei.kotlin_math.graph.model

import kotlin.math.roundToInt
import kotlin.math.sqrt

data class vec(val x: Double, val y: Double) {
  constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

  val intX: Int get() = x.roundToInt()
  val intY: Int get() = y.roundToInt()
  operator fun times(t: Double): vec = vec(x * t, y * t)
  operator fun times(t: Int): vec = vec(x * t, y * t)
  operator fun times(a: vec): Double = x * a.x + y * a.y
  operator fun plus(a: vec): vec = vec(x + a.x, y + a.y)
  operator fun minus(a: vec): vec = vec(x - a.x, y - a.y)
  operator fun div(a: Double): vec = vec(x / a, y / a)
  val norm: vec get() = this / sqrt(x * x + y * y)
  val toLeft: vec get() = vec(-y, x)
  val toRight: vec get() = vec(y, -x)

}

operator fun Int.times(a: vec): vec = a * this
operator fun Double.times(a: vec): vec = a * this
