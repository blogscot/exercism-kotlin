object WordCount {
  private val regex = """\b[\w']+\b""".toRegex()

  fun phrase(text: String) =

      regex.findAll(text)
          .map { it.value.toLowerCase() }
          .groupBy { it }
          .mapValues { it.value.size }
}