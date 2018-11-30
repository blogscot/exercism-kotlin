class IsbnVerifier {

  fun isValid(text: String): Boolean {
    val digits = text.filter { it.isDigit() }
    val endsWithX = text.endsWith('X')
    val containsSingleX = text.filter { it == 'X' }.count() == 1

    return when {
      digits.length == 10 || (digits.length == 9 && containsSingleX && endsWithX)
      -> digits.processDigits(endsWithX)
      else -> false
    }
  }

  private fun String.processDigits(endsWithX: Boolean): Boolean {
    var total = if (endsWithX) 10 else 0

    val zipped = map { it.toString().toInt() }.zip(10 downTo 0)
    total += zipped.map { (x, y) -> x * y }.sum()

    return total % 11 == 0
  }
}
