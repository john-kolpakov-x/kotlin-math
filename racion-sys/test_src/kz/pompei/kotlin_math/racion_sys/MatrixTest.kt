package kz.pompei.kotlin_math.racion_sys

import org.testng.annotations.Test
import java.security.SecureRandom
import kotlin.math.absoluteValue

class MatrixTest {

  @Test
  fun mul() {
    println("m1")
    val m1 = Matrix(10, 10).makeIdentity()
    m1[3, 3] = Rat.of(-236, 11)
    m1[1, 3] = Rat.of(-236, 111)
    m1[3, 7] = Rat.of(11, -111)
    println("" + m1)

    println("m2")
    val m2 = Matrix(10, 10).makeIdentity()
    m2[3, 7] = Rat.of(-17, 31)
    m2[1, 7] = Rat.of(-56, 311)
    m2[1, 5] = Rat.of(-1, 11)
    println("" + m2)

    println("m3")
    val m3 = m1 * m2
    println("" + m3)
  }

  @Test
  fun mul2() {
    println("m1")
    val m1 = Matrix(3, 3).makeIdentity()
    m1[0, 0] = Rat.of(2)
    m1[1, 0] = Rat.of(3)
    m1[2, 1] = Rat.of(4)
    println("" + m1)

    println("m2")
    val m2 = Matrix(3, 3).makeIdentity()
    m2[0, 0] = Rat.of(5)
    m2[1, 2] = Rat.of(6)
    m2[1, 0] = Rat.of(7)
    println("" + m2)

    println("m3")
    val m3 = m1 * m2
    println("" + m3)
    println("det = " + m3.det())
  }

  private fun matrix5(): Matrix {
    val m = Matrix(5, 5).makeIdentity()
    m[0, 0] = Rat.of(-3)
    m[0, 1] = Rat.of(7)
    m[0, 2] = Rat.of(0)
    m[0, 3] = Rat.of(8)
    m[0, 4] = Rat.of(1)

    m[1, 0] = Rat.of(-1)
    m[1, 1] = Rat.of(-11)
    m[1, 2] = Rat.of(-9)
    m[1, 3] = Rat.of(-12)
    m[1, 4] = Rat.of(2)

    m[2, 0] = Rat.of(4)
    m[2, 1] = Rat.of(14)
    m[2, 2] = Rat.of(3)
    m[2, 3] = Rat.of(2)
    m[2, 4] = Rat.of(-13)

    m[3, 0] = Rat.of(-8)
    m[3, 1] = Rat.of(-1)
    m[3, 2] = Rat.of(9)
    m[3, 3] = Rat.of(-7)
    m[3, 4] = Rat.of(-13)

    m[4, 0] = Rat.of(6)
    m[4, 1] = Rat.of(6)
    m[4, 2] = Rat.of(2)
    m[4, 3] = Rat.of(-7)
    m[4, 4] = Rat.of(-3)

    return m
  }

  @Test
  fun det() {
    val m = matrix5()
    println("" + m)
    println("det = " + m.det())
  }

  @Test
  fun power() {
    val m1 = matrix5()
    println("" + m1)
    val m2 = m1.power(2)
    println("" + m2)
    val m3 = m1.power(-1)
    println("" + m3)
    val m4 = m1 * m3
    println("" + m4)
  }

  @Test
  fun det2() {

    val m = Matrix(3, 3)

    m[0, 0] = Rat.of(1)
    m[0, 1] = Rat.of(3)
    m[0, 2] = Rat.of(5)

    m[1, 0] = Rat.of(2)
    m[1, 1] = Rat.of(3)
    m[1, 2] = Rat.of(0)

    m[2, 0] = Rat.of(1)
    m[2, 1] = Rat.of(7)
    m[2, 2] = Rat.of(2)

    println("" + m)
    println("det = " + m.det())
  }

  private fun matrix10(): Matrix {
    val m = Matrix(10, 10).makeIdentity()

    m[0, 0] = Rat.of(1)
    m[0, 1] = Rat.of(3)
    m[0, 2] = Rat.of(5)
    m[0, 3] = Rat.of(-5)
    m[0, 4] = Rat.of(15)
    m[0, 5] = Rat.of(13, 2)
    m[0, 6] = Rat.of(-1, 5)
    m[0, 7] = Rat.of(15)
    m[0, 8] = Rat.of(-3)
    m[0, 9] = Rat.of(9)

    m[1, 0] = Rat.of(2)
    m[1, 1] = Rat.of(3)
    m[1, 2] = Rat.of(0)
    m[1, 3] = Rat.of(1)
    m[1, 4] = Rat.of(-1)
    m[1, 5] = Rat.of(-2)
    m[1, 6] = Rat.of(-3)
    m[1, 7] = Rat.of(9)
    m[1, 8] = Rat.of(-7)

    m[2, 0] = Rat.of(1, 9)
    m[2, 1] = Rat.of(7, 8)
    m[2, 2] = Rat.of(2, 7)
    m[2, 3] = Rat.of(2, 3)
    m[2, 4] = Rat.of(12, 13)
    m[2, 5] = Rat.of(2, 17)
    m[2, 6] = Rat.of(2, 11)
    m[2, 7] = Rat.of(2, 21)
    m[2, 8] = Rat.of(2, 11)
    m[2, 9] = Rat.of(11)

    m[3, 0] = Rat.of(1)
    m[3, 1] = Rat.of(7)
    m[3, 2] = Rat.of(-2, 7)
    m[3, 3] = Rat.of(-2, 3)
    m[3, 4] = Rat.of(12)
    m[3, 5] = Rat.of(2)
    m[3, 6] = Rat.of(-3)
    m[3, 7] = Rat.of(2)
    m[3, 8] = Rat.of(-2, 11)
    m[3, 9] = Rat.of(1)

    m[4, 0] = Rat.of(-1)
    m[4, 1] = Rat.of(-7)
    m[4, 2] = Rat.of(-2, 7)
    m[4, 3] = Rat.of(-2, 3)
    m[4, 4] = Rat.of(1, 2)
    m[4, 5] = Rat.of(1, 2)
    m[4, 6] = Rat.of(-3, 5)
    m[4, 7] = Rat.of(2, 5)
    m[4, 8] = Rat.of(2, 3)
    m[4, 9] = Rat.of(-1)

    m[5, 0] = Rat.of(1)
    m[5, 1] = Rat.of(7)
    m[5, 2] = Rat.of(2, 7)
    m[5, 3] = Rat.of(2, 3)
    m[5, 4] = Rat.of(-1, 2)
    m[5, 5] = Rat.of(1, 2)
    m[5, 6] = Rat.of(-1, 7)
    m[5, 7] = Rat.of(-1, 5)
    m[5, 8] = Rat.of(-2, 3)
    m[5, 9] = Rat.of(-1, 3)

    m[6, 0] = Rat.of(-1)
    m[6, 1] = Rat.of(-1, 7)
    m[6, 2] = Rat.of(2, 7)
    m[6, 3] = Rat.of(2)
    m[6, 4] = Rat.of(1)
    m[6, 5] = Rat.of(1)
    m[6, 6] = Rat.of(-1)
    m[6, 7] = Rat.of(-1)
    m[6, 8] = Rat.of(-2)
    m[6, 9] = Rat.of(-1)

    m[7, 0] = Rat.of(-8)
    m[7, 1] = Rat.of(-7)
    m[7, 2] = Rat.of(7)
    m[7, 3] = Rat.of(-2)
    m[7, 4] = Rat.of(1)
    m[7, 5] = Rat.of(1)
    m[7, 6] = Rat.of(1)
    m[7, 7] = Rat.of(1)
    m[7, 8] = Rat.of(-1)
    m[7, 9] = Rat.of(-9)

    m[8, 0] = Rat.of(8)
    m[8, 1] = Rat.of(7)
    m[8, 2] = Rat.of(-7)
    m[8, 3] = Rat.of(2)
    m[8, 4] = Rat.of(1)
    m[8, 5] = Rat.of(1)
    m[8, 6] = Rat.of(6)
    m[8, 7] = Rat.of(6)
    m[8, 8] = Rat.of(-7)
    m[8, 9] = Rat.of(-3)

    m[9, 0] = Rat.of(8)
    m[9, 1] = Rat.of(-7, 4)
    m[9, 2] = Rat.of(7)
    m[9, 3] = Rat.of(-2)
    m[9, 4] = Rat.of(-1)
    m[9, 5] = Rat.of(-1)
    m[9, 6] = Rat.of(6)
    m[9, 7] = Rat.of(7)
    m[9, 8] = Rat.of(-4)
    m[9, 9] = Rat.of(-4)

    return m
  }

  @Test
  fun det3() {

    val m = matrix10()

    println("" + m)
    println("det = " + m.det())
  }

  @Test
  fun invert() {

    val m1 = matrix10()
    println("" + m1)

    val m2 = m1.power(-1)
    println("" + m2)

    val m3 = m1 * m2
    println("" + m3)

  }

  @Test
  fun invert2() {

    val m = Matrix(3, 3)

    m[0, 0] = Rat.of(1)
    m[0, 1] = Rat.of(3)
    m[0, 2] = Rat.of(5)

    m[1, 0] = Rat.of(2)
    m[1, 1] = Rat.of(3)
    m[1, 2] = Rat.of(0)

    m[2, 0] = Rat.of(1)
    m[2, 1] = Rat.of(7)
    m[2, 2] = Rat.of(2)

    println("" + m)
    val mm1 = m.power(-1)
    println("" + mm1)

    val m2 = m * mm1
    println("" + m2)
  }

  @Test
  fun det_power() {

    val m = Matrix(30, 30)
    m[0, 0] = Rat.of(1)
    m[0, 1] = Rat.of(2)
    m[0, 2] = Rat.of(3)

    m[1, 0] = Rat.of(3)
    m[1, 1] = Rat.of(-2)
    m[1, 2] = Rat.of(1)

    m[2, 1] = Rat.of(7)
    m[2, 2] = Rat.of(8)
    m[2, 3] = Rat.of(9)

    m[3, 2] = Rat.of(-1)
    m[3, 3] = Rat.of(11)
    m[3, 4] = Rat.of(12)

    m[4, 3] = Rat.of(12)
    m[4, 4] = Rat.of(13)
    m[4, 5] = Rat.of(14)

    m[5, 4] = Rat.of(14)
    m[5, 5] = Rat.of(15)
    m[5, 6] = Rat.of(16)

    m[6, 5] = Rat.of(16)
    m[6, 6] = Rat.of(17)
    m[6, 7] = Rat.of(18)

    m[7, 6] = Rat.of(-11)
    m[7, 7] = Rat.of(-7)
    m[7, 8] = Rat.of(9)

    m[8, 7] = Rat.of(-9)
    m[8, 8] = Rat.of(1)
    m[8, 9] = Rat.of(-9)

    m[9, 8] = Rat.of(1)
    m[9, 9] = Rat.of(2)
    m[9, 10] = Rat.of(-6)

    m[10, 9] = Rat.of(-1)
    m[10, 10] = Rat.of(1)
    m[10, 11] = Rat.of(5)

    m[11, 10] = Rat.of(11)
    m[11, 11] = Rat.of(12)
    m[11, 12] = Rat.of(13)

    m[12, 11] = Rat.of(13)
    m[12, 12] = Rat.of(12)
    m[12, 13] = Rat.of(11)

    m[13, 12] = Rat.of(1)
    m[13, 13] = Rat.of(17)
    m[13, 14] = Rat.of(18)

    m[14, 13] = Rat.of(8)
    m[14, 14] = Rat.of(9)
    m[14, 15] = Rat.of(1)

    m[15, 14] = Rat.of(1)
    m[15, 15] = Rat.of(5)
    m[15, 16] = Rat.of(6)

    m[16, 15] = Rat.of(1)
    m[16, 16] = Rat.of(3)
    m[16, 17] = Rat.of(-1)

    m[17, 16] = Rat.of(11)
    m[17, 17] = Rat.of(14)
    m[17, 18] = Rat.of(41)

    m[18, 17] = Rat.of(18)
    m[18, 18] = Rat.of(19)
    m[18, 19] = Rat.of(10)

    m[19, 18] = Rat.of(31)
    m[19, 19] = Rat.of(13)
    m[19, 20] = Rat.of(17)

    m[20, 19] = Rat.of(13)
    m[20, 20] = Rat.of(31)
    m[20, 21] = Rat.of(13)

    m[21, 20] = Rat.of(1)
    m[21, 21] = Rat.of(1)
    m[21, 22] = Rat.of(1)

    m[22, 21] = Rat.of(1)
    m[22, 22] = Rat.of(1)
    m[22, 23] = Rat.of(1)

    m[23, 22] = Rat.of(1)
    m[23, 23] = Rat.of(1)
    m[23, 24] = Rat.of(1)

    m[24, 23] = Rat.of(1)
    m[24, 24] = Rat.of(1)
    m[24, 25] = Rat.of(1)

    m[25, 24] = Rat.of(1)
    m[25, 25] = Rat.of(-3)
    m[25, 26] = Rat.of(1)

    m[26, 25] = Rat.of(1)
    m[26, 26] = Rat.of(-18)
    m[26, 27] = Rat.of(1)

    m[27, 26] = Rat.of(-1)
    m[27, 27] = Rat.of(13)
    m[27, 28] = Rat.of(-1)

    m[28, 27] = Rat.of(12)
    m[28, 28] = Rat.of(1)
    m[28, 29] = Rat.of(11)

    m[29, 27] = Rat.of(1)
    m[29, 28] = Rat.of(-1)
    m[29, 29] = Rat.of(1)

    m[10, 20] = Rat.of(-111, 11)
    m[20, 10] = Rat.of(-171, 7)
    m[25, 3] = Rat.of(-37, 134)

    println("" + m)
    println("" + m.power(-1))
    println("" + m.power(-1) * m)

  }


  @Test
  fun det_power2() {

    val rnd = SecureRandom()

    val S = 7

    val m = Matrix(10, 10)
    for (i in (0 until m.size1)) {
      for (j in (0 until m.size2)) {
        m[i, j] = Rat.of(rnd.nextLong() % S, rnd.nextLong().absoluteValue % S + 1)
      }
    }

    println("" + m)
    val m1 = m.power(-1)
    println("" + m1)
    println("" + m1 * m)

  }
}
