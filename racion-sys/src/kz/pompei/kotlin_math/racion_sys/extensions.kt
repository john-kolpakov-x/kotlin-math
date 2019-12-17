package kz.pompei.kotlin_math.racion_sys

fun String.toLenLeft(len: Int): String {
  val sb = StringBuilder()
  sb.append(this)
  while (sb.length < len) {
    sb.append(' ')
  }
  return sb.toString()
}

fun String.toLenRight(len: Int): String {
  val sb = StringBuilder()
  sb.append(this)
  while (sb.length < len) {
    sb.insert(0, ' ')
  }
  return sb.toString()
}
