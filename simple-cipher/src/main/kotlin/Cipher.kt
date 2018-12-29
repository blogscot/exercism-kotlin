import kotlin.random.Random

class Cipher(val key: String = generateRandomKey()) {

  init {
    require(key.all { it.isLowerCase() } && key.none { it.isDigit() } && key.isNotEmpty())
  }

  fun encode(text: String): String = encode(text, key)
  fun decode(text: String): String = decode(text, key)

  private fun encode(text: String, key: String) =
      text.zip(key).map { (a, b) -> encode(a, b) }.joinToString("")

  private fun encode(letter: Char, keyLetter: Char): Char {
    val distance = keyLetter - 'a'
    val newLetter = letter + distance
    return when {
      newLetter > 'z' -> newLetter - 'z'.toInt() + 'a'.toInt() - 1
      else -> newLetter
    }
  }

  private fun decode(text: String, key: String) =
      text.zip(key).map { (a, b) -> decode(a, b) }.joinToString("")

  private fun decode(letter: Char, keyLetter: Char): Char {
    val distance = keyLetter - 'a'
    val newLetter = letter - distance
    return when {
      newLetter < 'a' -> newLetter + 'z'.toInt() - 'a'.toInt() + 1
      else -> newLetter
    }
  }
}

private fun generateRandomKey(): String =
    generateSequence { getRandomLetter() }.take(100).joinToString("")

private fun getRandomLetter() =
    ('a'..'z').toList()[Random.nextInt(0, 26)]