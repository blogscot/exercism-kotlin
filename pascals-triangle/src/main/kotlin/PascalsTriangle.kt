object PascalsTriangle {

  fun computeTriangle(num: Int): List<List<Int>> {
    require(num >= 0) { "Rows can't be negative!" }

    if (num == 0) return emptyList()

    var line = listOf(1)
    val output = mutableListOf(line)

    repeat(num - 1) {
      line = listOf(1) + line.zipWithNext().map { (a, b) -> a + b } + listOf(1)
      output.add(line)
    }
    return output
  }
}