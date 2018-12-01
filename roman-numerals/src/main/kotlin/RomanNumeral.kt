import java.lang.StringBuilder

val ENCODINGS = arrayListOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I")


object RomanNumeral {

  fun value(value: Int): String {
    var current = value
    val sb = StringBuilder()

    for ((arabic, roman) in ENCODINGS) {
      while (current >= arabic) {
        sb.append(roman)
        current -= arabic
      }
    }
    return sb.toString()
  }
}