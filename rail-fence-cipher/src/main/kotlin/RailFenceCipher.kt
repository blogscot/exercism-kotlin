class RailFenceCipher(private val num: Int) {
  private val numbers = generateSequence(0) { it + 1 }

  fun getEncryptedData(message: String) =

      getEncoding(message)
          .fold(StringBuffer()) { acc, index -> acc.append(message[index]) }
          .toString()

  fun getDecryptedData(text: String): String {

    val decoding = numbers.zip(getEncoding(text)
        .asSequence())
        .sortedBy { it.second }
        .map { it.first }

    return decoding
        .fold(StringBuffer()) { acc, index -> acc.append(text[index]) }
        .toString()
  }

  private fun getEncoding(message: String): List<Int> =
      cycle(num - 1)
          .zip(numbers)
          .take(message.length)
          .groupBy({ it.first }, { it.second })
          .values.flatten()

}

private fun cycle(max: Int): Sequence<Int> =
    sequence {
      var step = 1
      var output = 0

      while (true) {

        if ((output == max) and (step == 1) ||
            (output == 0) and (step == -1)
        ) {
          step *= -1
        }

        yield(output)
        output += step
      }
    }