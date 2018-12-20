class RotationalCipher(key: Int) {

  private val aToZLower = ('a'..'z').toList()
  private val aToZUpper = ('A'..'Z').toList()
  private val rotLower = (aToZLower.drop(key) + aToZLower.take(key)).joinToString("")
  private val rotUpper = rotLower.map(Char::toUpperCase)

  fun encode(text: String) =
      text.map { letter ->
        when (letter) {
          in aToZLower -> rotLower[aToZLower.indexOf(letter)]
          in aToZUpper -> rotUpper[aToZUpper.indexOf(letter)]
          else -> letter
        }
      }.joinToString("")
}