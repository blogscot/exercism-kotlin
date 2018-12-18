object PrimeFactorCalculator {

  private fun isPrime(n: Long) =
      (2..n).takeWhile { it * it <= n }.all { n % it != 0L }

  private fun getPrimeFactor(n: Long) =
      (2..n).find { n % it == 0L && isPrime(it) }

  fun primeFactors(number: Int) =
      primeFactors(number.toLong()).map(Long::toInt)

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