object Prime {

  fun nth(num: Int): Int {
    require(num != 0) { "There is no zeroth prime." }

    return generateSequence(1) { it + 1 }
        .filter(Prime::isPrime)
        .drop(num)
        .first()
  }

  private fun isPrime(num: Int): Boolean =
      (2..num).takeWhile { it * it <= num }.all { num % it != 0 }

}