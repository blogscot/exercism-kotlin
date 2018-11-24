object Luhn {

  fun isValid(input: String): Boolean {
    val sanitised = input.filter { !it.isWhitespace() }
    if (sanitised.length <= 1 || sanitised.any { !it.isDigit()}) return false
    return calculateSum(sanitised) % 10 == 0
  }

  private fun calculateSum(numbers: String): Int {
    return numbers.reversed().withIndex().map { (index, number) ->
      var num: Int = number.toInt() - '0'.toInt()

      if (isOdd(index)) {
        num *= 2
        if (num > 9) {
          num -= 9
        }
      }
      num
    }.sum()
  }

  private fun isOdd(index: Int) = index % 2 == 1
}