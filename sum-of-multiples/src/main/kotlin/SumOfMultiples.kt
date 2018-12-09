object SumOfMultiples {

  fun sum(multiples: Set<Int>, num: Int) =
    multiples.flatMap { multiple ->
      (multiple until num).filter {
        it % multiple == 0
      }
    }.distinct().sum()
  }
