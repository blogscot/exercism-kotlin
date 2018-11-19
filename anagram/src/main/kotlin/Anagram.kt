class Anagram(private val word: String) {
  val current = word.toLowerCase()

  fun match(candidates: List<String>): Set<String> {
    return candidates.filter {
      val input = it.toLowerCase()
      input != current &&
      input.toList().sorted() == current.toList().sorted() 
    }.toSet()
  }
}