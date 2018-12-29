import kotlin.random.Random

class Cipher() {
  var key = generateRandomKey()
    private set

  constructor(cipherKey: String) : this() {
    require(cipherKey.all { it.isLowerCase() } && cipherKey.none { it.isDigit() } && cipherKey.isNotEmpty())
    key = cipherKey
  }

  fun encode(text: String): String {
    return encode(text, using = key)
  }

  fun decode(text: String): String {
    return decode(text, using = key)
  }

  private fun encode(text: String, using: String) =
      text.zip(using).map { (a, b) -> encode(a, b) }.joinToString("")

  private fun encode(letter: Char, using: Char): Char {
    val distance = using - 'a'
    val newLetter = letter + distance
    return when {
      newLetter > 'z' -> (newLetter - 'z' + 'a'.toInt() - 1).toChar()
      else -> newLetter
    }
  }

  fun decode(text: String, using: String) =
      text.zip(using).map { (a, b) -> decode(a, b) }.joinToString("")

  fun decode(letter: Char, using: Char): Char {
    val distance = using - 'a'
    val newLetter = letter - distance
    return when {
      newLetter < 'a' -> newLetter + 'z'.toInt() - 'a'.toInt() + 1
      else -> newLetter
    }
  }

  private fun generateRandomKey(): String =
      generateSequence { getRandomLetter() }.take(100).joinToString("")

  private fun getRandomLetter() =
      ('a'..'z').toList()[Random.nextInt(0, 26)]
}