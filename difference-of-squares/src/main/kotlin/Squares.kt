class Squares(private val num: Int) {
  fun squareOfSum() = (1..num).sum().let { it * it }
  fun sumOfSquares() = (1..num).map { it * it }.sum()
  fun difference() = squareOfSum() - sumOfSquares()
}