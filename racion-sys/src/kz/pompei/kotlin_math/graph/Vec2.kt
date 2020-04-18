package kz.pompei.kotlin_math.graph

import kotlin.math.roundToInt

data class Vec2(val x: Double, val y: Double) {

  val intX: Int get() = x.roundToInt()
  val intY: Int get() = y.roundToInt()

}
