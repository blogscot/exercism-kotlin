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

  private fun String.processDigits(endsWithX: Boolean): Boolean =
      map { Character.getNumericValue(it) }
          .zip(10 downTo 0)
          .map { (x, y) -> x * y }
          .sum()
          .let {
            val total = if (endsWithX) it + 10 else it
            total % 11 == 0
          }
}
