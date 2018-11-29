object Series {
  fun slices(len: Int, text: String): List<List<Int>> {
    require(text.all { it.isDigit() })

    return text.windowed(len).map { str ->
      str.windowed(1).map {
        it.toInt()
      }
    }
  }
}
