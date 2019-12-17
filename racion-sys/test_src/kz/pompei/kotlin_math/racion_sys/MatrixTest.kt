package kz.pompei.kotlin_math.racion_sys

import org.testng.annotations.Test

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

  @Test
  fun det() {

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
    m[2, 4] = Rat.of(1)

    m[3, 0] = Rat.of(-8)
    m[3, 1] = Rat.of(-18)
    m[3, 2] = Rat.of(9)
    m[3, 3] = Rat.of(-7)
    m[3, 4] = Rat.of(-13)

    m[4, 0] = Rat.of(6)
    m[4, 1] = Rat.of(6)
    m[4, 2] = Rat.of(2)
    m[4, 3] = Rat.of(7)
    m[4, 4] = Rat.of(-3)

    println("" + m)
    println("det = " + m.det())
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

  @Test
  fun det3() {

    val m = Matrix(10, 10).makeIdentity()

    m[0, 0] = Rat.of(1)
    m[0, 1] = Rat.of(3)
    m[0, 2] = Rat.of(5)
    m[0, 3] = Rat.of(-5)
    m[0, 4] = Rat.of(15)

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
    m[2, 9] = Rat.of(1)

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
    m[9, 1] = Rat.of(7, 4)
    m[9, 2] = Rat.of(7)
    m[9, 3] = Rat.of(-2)
    m[9, 4] = Rat.of(-1)
    m[9, 5] = Rat.of(-1)
    m[9, 6] = Rat.of(6)
    m[9, 7] = Rat.of(7)
    m[9, 8] = Rat.of(-4)
    m[9, 9] = Rat.of(-4)

    println("" + m)
    println("det = " + m.det())
  }
}
