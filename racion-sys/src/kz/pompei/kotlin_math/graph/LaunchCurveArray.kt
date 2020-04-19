package kz.pompei.kotlin_math.graph

import kz.pompei.kotlin_math.graph.model.CurveArray
import kz.pompei.kotlin_math.graph.model.Ray
import kz.pompei.kotlin_math.graph.model.times
import kz.pompei.kotlin_math.graph.model.vec
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class LaunchCurveArray {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      LaunchCurveArray().exec()
    }
  }

  private fun exec() {
    val image = BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB)
    val graphics = image.createGraphics()
    graphics.color = Color.WHITE
    graphics.fillRect(0, 0, image.width, image.height)
    DrawGraphics2D(graphics, image.width.toDouble(), image.height.toDouble())
      .offset(vec(500, 350)).use { d ->
        d.color(Color.GRAY.brighter()).line(vec(-500, 0), vec(500, 0)).line(vec(0, -350), vec(0, 350))
        draw(d)
      }
    val file = File("build/out-image-" + javaClass.simpleName + ".png")
    ImageIO.write(image, "png", file)
    println("Finished " + javaClass.simpleName)
  }

  private fun draw(d: Draw) {

    val P1 = vec(300, 0)
    val P2 = vec(300, 100)
    val P3 = vec(50, 300)
    val P4 = vec(-350, 100)
    val P5 = vec(-350, -300)
    val P6 = vec(0, -50)
    val P7 = vec(50, -300)
    val P8 = vec(170, -180)
    val P9 = vec(170 + 100, -180 - 100)
    val P10 = vec(170 + 100 + 50, -180 - 100 + 50)
    val P11 = vec(170 + 50, -180 + 50)

    val curve = CurveArray.brokenLine(P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11)

    val curveSize = curve.endT - curve.beginT

    val startRay = Ray(vec(-200, -100), vec(50, -15))
    var ray = startRay

    for (i in 1..27) {

      val intersections = curve.intersection(ray)

      val nearIntersection = intersections.minRayT { it.rayT > 1e-10 } ?: return

      d.color(Color.GREEN)

      val P = ray.at(nearIntersection.rayT)

      //d.circle(P, 4)

      val tangent = curve.tangentAt(nearIntersection.curveT)

      val norm = tangent.toLeft

      val mirror = ray.dir.norm - 2 * norm * (ray.dir.norm * norm)

      d.line(ray.O, P)

      println("line " + ray.O.intStr + " --- " + P.intStr + "   mirror " + (mirror * 100).intStr)

      ray = Ray(P, mirror)
    }

    d.color(Color.BLACK)

    val N = curve.curves.size

    for (i in 1..N) {

      val t1 = curveSize / N * (i - 1)
      val t2 = curveSize / N * i

      val A = curve.at(t1)
      val B = curve.at(t2)

      d.line(A, B)
      d.circle(A, 3)
    }

  }

}


