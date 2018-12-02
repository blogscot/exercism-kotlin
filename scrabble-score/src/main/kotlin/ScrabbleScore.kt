object ScrabbleScore {

  private val ENCODING = arrayListOf(
      "AEIOULNRST" to 1,
      "DG" to 2,
      "BCMP" to 3,
      "FHVWY" to 4,
      "K" to 5,
      "JX" to 8,
      "QZ" to 10
  )

  fun scoreWord(word: String): Int =
      word.map(::findScore).sum()

  private fun findScore(letter: Char): Int {
    for (entry in ENCODING) {
      if (letter.toUpperCase() in entry.first) return entry.second
    }
    return 0
  }

}