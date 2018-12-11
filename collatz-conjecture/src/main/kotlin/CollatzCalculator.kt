object CollatzCalculator {

  fun computeStepCount(natural: Int): Int {
    require(natural > 0) { "Only natural numbers are allowed" }

    var num = natural
    var count = 0

    while (num > 1) {

      num = when {
        isEven(num) -> num / 2
        else -> num * 3 + 1
      }
      count++
    }

    return count
  }

  private val isEven = { num: Int -> num and 1 == 0 }
}