object ETL {

  fun transform(old: Map<Int, List<Char>>): Map<Char, Int> {

    val output = mutableMapOf<Char, Int>()

    old.forEach { key, values ->
      values.fold(output) { acc, letter ->
        acc[letter.toLowerCase()] = key
        acc
      }
    }

    return output
  }
}