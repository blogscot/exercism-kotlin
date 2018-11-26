class Series(private val input: String) {

  init {
    require(input.all { it.isDigit() }) { "Illegal argument: $input" }
  }

  fun getLargestProduct(num: Int): Int? {
    require(num >= 0 && input.length >= num) { "Illegal Argument: $num" }

    if (input.isBlank() && num == 0) return 1

    return input.withIndex()
        .map { (index, _) -> input.drop(index).take(num) }
        .filter { it.length == num }
        .map { it.toList().map { it.toString().toInt() } }
        .map { it.fold(1) { acc, i -> acc * i } }
        .max()
  }
}