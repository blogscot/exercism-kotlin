class Year(private val year: Int) {

  private val isDivisibleBy: (Int) -> Boolean = { year % it == 0 }

  val isLeap = isDivisibleBy(4) and !isDivisibleBy(100) or isDivisibleBy(400)
}
