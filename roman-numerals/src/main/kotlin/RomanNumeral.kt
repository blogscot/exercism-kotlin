import java.lang.StringBuilder

val numerals = arrayListOf(
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

  fun value(arabic: Int): String {
    var current = arabic
    val sb = StringBuilder()

    for (pair in numerals) {
      while (current >= pair.first) {
        sb.append(pair.second)
        current -= pair.first
      }
    }
    return sb.toString()
  }
}