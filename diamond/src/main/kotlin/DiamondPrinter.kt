class DiamondPrinter {

  fun printToList(letter: Char): List<String> {
    var lines = mutableListOf<String>()
    val alphabet = 'A'..'Z'

    val lettersUpTo = alphabet.takeWhile { it <= letter }.joinToString("")

    for (letterIndex in 1..lettersUpTo.length) {
      val substr = lettersUpTo.substring(0, letterIndex)

      val rightSide = substr
        .map { if (it == substr.last()) substr.last() else ' ' }
        .joinToString("")
        .padEnd(lettersUpTo.length, ' ')

      val leftSide = rightSide.reversed()
      lines.add(leftSide + rightSide.drop(1))
    }

    for (line in lines.take(lines.size - 1).reversed()) {
      lines.add(line)
    }
    return lines
  }

}
