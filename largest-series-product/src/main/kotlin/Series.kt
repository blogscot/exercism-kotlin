class Series(private val input: String) {

  init {
    require(input.all { it.isDigit() })
  }

  fun getLargestProduct(num: Int): Int {
    require(input.length >= num)

    if (num == 0) return 1

    return input.windowed(num, 1) {
      it.fold(1) {acc, chr -> acc * chr.toString().toInt()}
    }.max() ?: 0
  }
}
