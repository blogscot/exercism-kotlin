object SumOfMultiples {

  fun sum(multiples: Set<Int>, num: Int) =
      multiples.flatMap { multiple ->
        (multiple until num).step(multiple)
      }.distinct().sum()
}
