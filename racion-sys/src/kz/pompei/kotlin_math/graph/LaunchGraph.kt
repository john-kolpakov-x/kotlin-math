package kz.pompei.kotlin_math.graph

import kz.pompei.kotlin_math.graph.model.CenterEllipse
import kz.pompei.kotlin_math.graph.model.Ray
import kz.pompei.kotlin_math.graph.model.times
import kz.pompei.kotlin_math.graph.model.vec
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

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

    val ellipse = CenterEllipse(400, 300)

    val startRay = Ray(vec(0, 100), vec(10.0, -3.78))
    var ray = startRay

    for (u in (1..10000)) {


      val intersections = ellipse.intersections(ray)

      val point2 = ray.at(intersections.maxT.t)

      d.color(Color.GREEN)

      //d.circle(point2, 5)
      d.line(ray.at(1), point2)

      val tangent = ellipse.tangentAt(intersections.maxT.fi)
      val norm = tangent.toLeft

      val mirror = ray.dir.norm - 2 * norm * (ray.dir.norm * norm)

      ray = Ray(point2, mirror)
    }

    d.color(Color.BLUE)
    d.circle(startRay.O, 5)
    d.line(startRay.O, startRay.O + 100 * startRay.dir.norm)

    for (i in 1..N) {

      val fi1 = 2 * Math.PI / N * (i - 1)
      val fi2 = 2 * Math.PI / N * i

      val A = ellipse.at(fi1)
      val B = ellipse.at(fi2)

      d.line(A, B)

    }
  }

}


