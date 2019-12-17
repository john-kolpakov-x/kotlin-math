package kz.pompei.kotlin_math.racion_sys

import java.math.BigInteger

@Suppress("MemberVisibilityCanBePrivate", "NAME_SHADOWING")
class Rat(up: BigInteger, dn: BigInteger) : Comparable<Rat> {
  val up: BigInteger
  val dn: BigInteger

  init {
    var up = up
    var dn = dn

    require(dn != BigInteger.ZERO) { "up = $up, dn = $dn" }

    if (dn < BigInteger.ZERO) {
      up = -up
      dn = -dn
    }

    val gcd = up.gcd(dn)

    up /= gcd
    dn /= gcd

    this.up = up
    this.dn = dn
  }

  override fun toString(): String {
    if (dn.compareTo(BigInteger.ONE) == 0) {
      return "$up"
    }

    if (up.abs() < dn) {
      return "$up/$dn"
    }

    val sign = if (up < BigInteger.ZERO) "-" else ""

    val a = up.abs() / dn
    val r = up.abs() % dn

    return "$sign$a|$r/$dn"
  }

  companion object {
    fun of(up: Long, dn: Long): Rat = Rat(BigInteger.valueOf(up), BigInteger.valueOf(dn))
    fun of(value: Long): Rat = of(value, 1L)
    private val ZERO = of(0)
    private val ONE = of(1)
    fun zero(): Rat = ZERO
    fun one(): Rat = ONE
  }

  override fun compareTo(other: Rat): Int = (up * other.dn - other.up * dn).compareTo(BigInteger.ZERO)

  operator fun plus(other: Rat): Rat = Rat(up * other.dn + other.up * dn, dn * other.dn)
  operator fun minus(other: Rat): Rat = Rat(up * other.dn - other.up * dn, dn * other.dn)
  operator fun unaryMinus(): Rat = Rat(-up, dn)
  operator fun unaryPlus(): Rat = this
  operator fun times(other: Rat): Rat = Rat(up * other.up, dn * other.dn)
  operator fun div(other: Rat): Rat = Rat(up * other.dn, dn * other.up)

  fun abs(): Rat = Rat(up.abs(), dn)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Rat

    if (up != other.up) return false
    if (dn != other.dn) return false

    return true
  }

  override fun hashCode(): Int {
    var result = up.hashCode()
    result = 31 * result + dn.hashCode()
    return result
  }


}
