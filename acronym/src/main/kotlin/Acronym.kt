object Acronym {
  fun generate(phrase: String): String {
    val regex = """\b\w|[A-Z][a-z]""".toRegex()
    return regex.findAll(phrase).map {
      it.value.toUpperCase()
    }.joinToString("")
  }
}
