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
    return "$up／$dn"
  }

  companion object {

    fun of(up: Long, dn: Long): Rat {
      return Rat(BigInteger.valueOf(up), BigInteger.valueOf(dn))
    }

    fun of(value: Long): Rat {
      return of(value, 0L)
    }
  }

  override fun compareTo(other: Rat): Int = (up * other.dn - other.up).compareTo(BigInteger.ZERO)

  operator fun plus(other: Rat): Rat = Rat(up * other.dn + other.up * dn, dn * other.dn)
  operator fun minus(other: Rat): Rat = Rat(up * other.dn - other.up * dn, dn * other.dn)
  operator fun unaryMinus(): Rat = Rat(-up, dn)
  operator fun unaryPlus(): Rat = this
  operator fun times(other: Rat): Rat = Rat(up * other.up, dn * other.dn)
  operator fun div(other: Rat): Rat = Rat(up * other.dn, dn * other.up)
}
