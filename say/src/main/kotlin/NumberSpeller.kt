class NumberSpeller {

  private val oneTrillion = 1_000_000_000_000L
  private val oneBillion = 1_000_000_000L
  private val oneMillion = 1_000_000L

  private val numbers = arrayListOf(
      1L to "one",
      2L to "two",
      3L to "three",
      4L to "four",
      5L to "five",
      6L to "six",
      7L to "seven",
      8L to "eight",
      9L to "nine",
      10L to "ten",
      11L to "eleven",
      12L to "twelve",
      13L to "thirteen",
      14L to "fourteen",
      15L to "fifteen",
      16L to "sixteen",
      17L to "seventeen",
      18L to "eighteen",
      19L to "nineteen",
      20L to "twenty",
      30L to "thirty",
      40L to "forty",
      50L to "fifty",
      60L to "sixty",
      70L to "seventy",
      80L to "eighty",
      90L to "ninety",
      100L to "hundred",
      1000L to "thousand",
      oneMillion to "million",
      oneBillion to "billion"
  ).reversed()

  fun say(number: Int): String {
    require(number >= 0) { "Input must be non-negative" }
    return say(number.toLong())
  }

  fun say(number: Long): String {
    require(number >= 0) { "Input must be non-negative" }
    require(number < oneTrillion) { "Input must be less than 1000000000000" }
    if (number == 0L) return "zero"
    return sayHelper(number)
  }

  private fun sayHelper(number: Long): String {
    val sb = StringBuffer()
    var num = number

    fun update(amount: Long, units: String): Long {
      var num1 = num
      sb.append("${sayHelper(num1 / amount)} $units ")
      num1 %= amount
      return num1
    }

    for ((decimal, word) in numbers) {

      if (num >= decimal) {
        num = when {
          num >= oneBillion -> update(oneBillion, "billion")
          num >= oneMillion -> update(oneMillion, "million")
          num >= 1000 -> update(1000, "thousand")
          num >= 100 -> update(100, "hundred")
          else -> {
            sb.append(word)
            if (num > 20 && num % 10 > 0) sb.append('-')
            num -= decimal
            num
          }
        }
      }
    }
    return sb.toString().trimEnd()
  }
}