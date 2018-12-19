object PascalsTriangle {

  fun computeTriangle(num: Int): List<List<Int>> {
    require(num >= 0) { "Rows can't be negative!" }

    return generateSequence(listOf(1)) { listOf(1) + it.zipWithNext().map { (a, b) -> a + b } + listOf(1) }
        .take(num).toList()
  }
}