class PhoneNumber(text: String) {
  val number = sanitiseInput(text)

  private fun sanitiseInput(text: String): String? {
    val number = text.filter { it.isDigit() }

    val areaCodeDigit = number[0]
    val exchangeCodeDigit = number[3]

    return when {
      number.length == 11 && areaCodeDigit == '1' -> number.drop(1)
      number.length != 10 ||
          areaCodeDigit in "01" ||
          exchangeCodeDigit in "01" -> null
      else -> number
    }
  }
}