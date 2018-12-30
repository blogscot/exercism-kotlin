class BaseConverter(private val base: Int, private val digits: IntArray) {

  init {
    require(base > 1) { "Bases must be at least 2." }
    require(digits.isNotEmpty()) { "You must supply at least one digit." }
    require(digits.all { it >= 0 }) { "Digits may not be negative." }
    require(digits.all { it < base }) { "All digits must be strictly less than the base." }
    require(digits.takeWhile { it == 0 }.count() <= 1 &&
        !(digits.first() == 0 && digits.size > 1)
    ) { "Digits may not contain leading zeros." }
  }

  fun convertToBase(newBase: Int): IntArray {
    require(newBase > 1) { "Bases must be at least 2." }

    var total = digits.fold(0) { acc, value -> acc * base + value }
    val output = mutableListOf<Int>()

    while (total > 0) {
      output.add(0, total % newBase)
      total /= newBase
    }

    return if (output.isEmpty()) intArrayOf(0) else output.toIntArray()
  }
}