package kz.pompei.kotlin_math.racion_sys

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class RatTest {

  @Test
  fun testEquals() {

    val r1 = Rat.of(3, 4)
    val r2 = Rat.of(6, 8)

    assertEquals(r1 == r2, true)
    assertEquals(r1 != Rat.zero(), true)

  }
}
