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

    val P01 = vec(-50, 200)
    val P02 = vec(-150, 300)
    val P03 = vec(-350, 300)
    val P04 = vec(-400, 250)
    val P05 = vec(-400, 100)
    val P06 = vec(-350, 150)
    val P07 = vec(-350, -250)
    val P08 = vec(-200, -250)
    val P09 = vec(150, 100)
    val P10 = vec(250, 100)
    val P11 = vec(250, -50)
    val P12 = vec(50, -150)
    val P13 = vec(50, -300)
    val P14 = vec(450, -300)
    val P15 = vec(450, -150)
    val P16 = vec(350, -50)
    val P17 = vec(350, 150)
    val P18 = vec(150, 150)
    val P19 = vec(-200, -200)
    val P20 = vec(-300, -200)
    val P21 = vec(-300, 150)
    val P22 = vec(-250, 100)
    val P23 = vec(-150, 100)

    val curve = CurveArray.brokenLine(
      P01, P02, P03, P04, P05, P06, P07, P08, P09, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21,
      P22, P23
    )

    val curveSize = curve.endT - curve.beginT

    val startRay = Ray(vec(-250, 250), vec(1.0, 1.1))
    var ray = startRay

    for (i in 1..400) {

      val intersections = curve.intersection(ray)

      val nearIntersection = intersections.minRayT { it.rayT > 1e-7 } ?: break

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


