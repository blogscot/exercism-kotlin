object Series {
  fun slices(len: Int, text: String): List<List<Int>> {
    require(text.all { it.isDigit() })

    return text.map { it.toString().toInt() }.windowed(len)
  }
}
