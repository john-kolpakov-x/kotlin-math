package kz.pompei.kotlin_math.graph

import kz.pompei.kotlin_math.graph.model.vec
import java.awt.Color

interface Draw {

  fun color(color: Color): Draw

  fun line(a: vec, b: vec): Draw

  fun circle(point: vec, radius: Int)
  fun circle(point: vec, radius: Double)

}
