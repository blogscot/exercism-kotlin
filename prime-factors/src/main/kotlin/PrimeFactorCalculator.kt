object PrimeFactorCalculator {

  private fun isPrime(n: Long) =
      (2..n).takeWhile { it * it <= n }.all { n % it != 0L }

  private fun getPrimeFactor(n: Long): Long? =
      (2..n).find { n % it == 0L && isPrime(it) }

  private fun isPrime(n: Int) =
      (2..n).takeWhile { it * it <= n }.all { n % it != 0 }

  private fun getPrimeFactor(n: Int): Int? =
      (2..n).find { n % it == 0 && isPrime(it) }

  fun primeFactors(number: Int): List<Int> {
    var num = number

    val factors = mutableListOf<Int>()

    while (num > 1) {
      val primeFactor = getPrimeFactor(num)!!
      num /= primeFactor
      factors.add(primeFactor)
    }
    return factors
  }

  fun primeFactors(number: Long): List<Long> {
    var num = number
    val factors = mutableListOf<Long>()

    while (num > 1) {
      val primeFactor = getPrimeFactor(num)!!
      num /= primeFactor
      factors.add(primeFactor)
    }
    return factors
  }
}