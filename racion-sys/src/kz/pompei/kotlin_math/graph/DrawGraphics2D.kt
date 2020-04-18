package kz.pompei.kotlin_math.graph

import kz.pompei.kotlin_math.graph.model.vec
import java.awt.Color
import java.awt.Graphics2D

class DrawGraphics2D(private val g: Graphics2D, private val width: Double, private val height: Double) : Draw,
  AutoCloseable {

  private var offset = vec(0.0, 0.0)

  override fun color(color: Color): DrawGraphics2D {
    g.color = color
    return this
  }

  fun offset(offset: vec): DrawGraphics2D {
    this.offset = offset
    return this
  }

  private fun toScreen(a: vec): vec {
    return vec(a.x + offset.x, height - a.y - offset.y)
  }

  override fun line(a: vec, b: vec): DrawGraphics2D {
    val a1 = toScreen(a)
    val b1 = toScreen(b)
    g.drawLine(a1.intX, a1.intY, b1.intX, b1.intY)
    return this
  }

  override fun close() {
    g.dispose()
  }

}
