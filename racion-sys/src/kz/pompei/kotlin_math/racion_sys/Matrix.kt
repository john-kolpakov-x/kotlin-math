package kz.pompei.kotlin_math.racion_sys

@Suppress("MemberVisibilityCanBePrivate")
class Matrix(val size1: Int, val size2: Int) {

  init {
    require(size1 > 1) { "size1 must be > 1 : size1 = $size1" }
    require(size2 > 1) { "size2 must be > 1 : size2 = $size2" }
  }

  private val data: Array<Rat> = Array(size1 * size2) { Rat.zero() }

  operator fun get(i1: Int, i2: Int): Rat = data[i1 * size1 + i2]

  operator fun set(i1: Int, i2: Int, value: Rat) {
    data[i1 * size1 + i2] = value
  }

  fun makeNegate(): Matrix {
    for (i1 in (0 until size1)) {
      for (i2 in (0 until size2)) {
        this[i1, i2] = -this[i1, i2]
      }
    }
    return this
  }

  companion object {
    fun from(mat: Array<Array<Rat>>): Matrix {
      val size1 = mat.size
      val size2 = mat[0].size
      val ret = Matrix(size1, size2)
      for (i1 in (0 until size1)) {
        for (i2 in (0 until size2)) {
          ret[i1, i2] = mat[i1][i2]
        }
      }
      return ret
    }
  }

  fun copy(): Matrix = copyTo(Matrix(size1, size2))

  operator fun unaryMinus(): Matrix = copy().makeNegate()

  fun copyTo(destination: Matrix): Matrix {
    require(destination.size1 == size1 && destination.size2 == size2) { "illegal destination size" }
    for (i in data.indices) {
      destination.data[i] = data[i]
    }
    return destination
  }

  fun makeIdentity(): Matrix {
    for (i1 in (0 until size1)) {
      for (i2 in (0 until size2)) {
        this[i1, i2] = if (i1 == i2) Rat.one() else Rat.zero()
      }
    }
    return this
  }

  override fun toString(): String {

    val str: List<String> = data.map { it.toString() }

    val sizes: Array<Int> = Array(size2) { 0 }

    for (i1 in (0 until size1)) {
      for (i2 in (0 until size2)) {
        val length = str[i1 * size1 + i2].length
        if (sizes[i2] < length) {
          sizes[i2] = length
        }
      }
    }

    val sb = StringBuilder()

    for (i1 in (0 until size1)) {
      for (i2 in (0 until size2)) {
        if (i2 > 0) sb.append(' ')
        sb.append(str[i1 * size1 + i2].toLenRight(sizes[i2]))
      }
      sb.append('\n')
    }

    return sb.toString()
  }

  operator fun times(m: Matrix): Matrix {
    require(size2 == m.size1) { "illegal times sizes" }

    val ret = Matrix(size1, m.size2)

    for (i in (0 until size1)) {

      for (j in (0 until m.size2)) {

        var s = Rat.zero()

        for (k in (0 until size2)) {
          s += this[i, k] * m[k, j]
        }

        ret[i, j] = s
      }

    }

    return ret
  }

  fun det(): Rat {

    require(size1 == size2) { "Sizes must be equal" }

    val mat: Array<Array<Rat>> = Array(size1) { i -> Array(size2) { j -> this[i, j] } }

    var swapCount = 0

    for (k in (0 until size1 - 1)) {

      var n = k
      var max = mat[k][k].abs()

      for (i in (k + 1 until size1)) {
        val x = mat[i][k].abs()
        if (x > max) {
          max = x
          n = i
        }
      }

      println("" + from(mat))

      if (k < n) {
        val line: Array<Rat> = mat[n]
        for (i in (n downTo k + 1)) {
          mat[i] = mat[i - 1]
        }
        mat[k] = line
        swapCount += n - k
      }

      if (Rat.zero().compareTo(max) == 0) return Rat.zero()

      println("" + from(mat))

      for (i in (k + 1 until size1)) {

        val q = mat[i][k]

        if (q.compareTo(Rat.zero()) == 0) {
          continue
        }

        val w = q / mat[k][k]

        for (j in (k until size1)) {
          mat[i][j] -= w * mat[k][j]
        }

        println("" + from(mat))

      }

      println("" + from(mat))

    }

    var ret = Rat.one()

    for (k in (0 until size1)) {
      ret *= mat[k][k]
    }

    return if (swapCount % 2 == 0) ret else -ret
  }

}
