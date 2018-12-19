class RotationalCipher(key: Int) {

  private val alphabetLowercase = 'a'..'z'
  private val alphabetUppercase = 'A'..'Z'
  private val rotLower = rotate(key, alphabetLowercase)
  private val rotUpper = rotate(key, alphabetUppercase)

  fun encode(text: String) =

      text.map { letter ->
        when (letter) {
          in alphabetLowercase ->rotLower[alphabetLowercase.toList().indexOf(letter)]
          in alphabetUppercase ->rotUpper[alphabetUppercase.toList().indexOf(letter)]
          else -> letter
        }
      }.joinToString("")

  private fun rotate(num: Int, text: CharRange) =
      (text.drop(num) + text.take(num)).joinToString("")
}