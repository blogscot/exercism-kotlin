class NumberSpeller {

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
      1_000_000L to "million",
      1_000_000_000L to "billion"
  ).reversed()

  fun say(number: Int): String {
    require(number >= 0) { "Input must be non-negative" }
    return say(number.toLong())
  }

  fun say(number: Long): String {
    require(number < 1_000_000_000_000) { "Input must be less than 1000000000000" }

    if (number == 0L) return "zero"

    val sb = StringBuffer()
    var num = number

    for ((decimal, word) in numbers) {

      if (num >= decimal) {
        when (num) {
          in 1_000_000_000..999_999_999_999 -> {
            sb.append("${say(num / 1_000_000_000)} billion ")
            num %= 1_000_000_000
          }
          in 1_000_000..999_999_999 -> {
            sb.append("${say(num / 1_000_000)} million ")
            num %= 1_000_000
          }
          in 1000..999_999 -> {
            sb.append("${say(num / 1000)} thousand ")
            num %= 1000
          }
          in 100..999 -> {
            sb.append("${say(num / 100)} hundred ")
            num %= 100
          }
          else -> {
            sb.append(word)
            if (num in 20..99 && num % 10 > 0) sb.append('-')
            num -= decimal
          }
        }

      }
    }
    return sb.toString().trimEnd()

  }
}