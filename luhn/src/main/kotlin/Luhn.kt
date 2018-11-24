object Luhn {

  fun isValid(input: String): Boolean {
    val sanitised = input.filter { !it.isWhitespace() }

    return when {
      sanitised.length <= 1 -> false
      sanitised.any { !it.isDigit() } -> false
      else -> calculateSum(sanitised) % 10 == 0
    }
  }

  private fun calculateSum(numbers: String) =
      numbers.reversed().mapIndexed { index, digit ->
        var num: Int = digit.toString().toInt()

        if (isOdd(index)) {
          num *= 2
          if (num > 9) {
            num -= 9
          }
        }
        num
      }.sum()

  private fun isOdd(index: Int) = index % 2 == 1
}