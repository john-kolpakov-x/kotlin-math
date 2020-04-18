package kz.pompei.kotlin_math.graph.model

import kotlin.math.roundToInt

data class vec(val x: Double, val y: Double) {

  constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

  val intX: Int get() = x.roundToInt()
  val intY: Int get() = y.roundToInt()

}
