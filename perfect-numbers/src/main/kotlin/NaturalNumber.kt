enum class Classification {
  DEFICIENT, PERFECT, ABUNDANT
}

private fun getFactors(num: Int): List<Int> =
  (1 until num).filter { num % it == 0 }

fun classify(naturalNumber: Int): Classification {
  require(naturalNumber > 0)

  val total = getFactors(naturalNumber).sum()
  return when {
    total == naturalNumber -> Classification.PERFECT
    total > naturalNumber -> Classification.ABUNDANT
    else -> Classification.DEFICIENT
  }
}
