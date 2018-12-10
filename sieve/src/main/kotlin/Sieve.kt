object Sieve {
  fun primesUpTo(num: Int): List<Int> =
      (2..num).filter(::isPrime)

  private fun isPrime(num: Int): Boolean =
      (2 until num).takeWhile { it * it <= num }.all { num % it != 0 }
}
