package kz.pompei.kotlin_math.graph

import kz.pompei.kotlin_math.graph.model.vec
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.cos
import kotlin.math.sin

class LaunchGraph {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      LaunchGraph().exec()
    }
  }

  private fun exec() {
    val image = BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB)
    val graphics = image.createGraphics()
    graphics.color = Color.WHITE
    graphics.fillRect(0, 0, image.width, image.height)
    DrawGraphics2D(graphics, image.width.toDouble(), image.height.toDouble())
      .offset(vec(500, 350)).use { d ->
        d
          .color(Color.GRAY)
          .line(
            vec(-500, 0),
            vec(500, 0)
          )
          .line(
            vec(0, -350),
            vec(0, 350)
          )

        drawEllipse(d)

      }
    val file = File("build/out-image.png")
    ImageIO.write(image, "png", file)
    println("asd")
  }

  private fun drawEllipse(d: Draw) {

    d.color(Color.BLACK)

    val N = 100
    val Rx = 400.0
    val Ry = 300.0

    for (i in 1..N) {

      val fi1 = 2 * Math.PI / N * (i - 1)
      val fi2 = 2 * Math.PI / N * i

      val A = vec(Rx * cos(fi1), Ry * sin(fi1))
      val B = vec(Rx * cos(fi2), Ry * sin(fi2))

      d.line(A, B)

    }

    d.line(vec(100, 100), vec(300, 150))

  }

}
