package PigLatin

private fun translateWord(word: String): String {
  val vowels = "aeiouy"
  val firstLetter = word[0]
  val secondLetter = word[1]
  val firstTwoLetters = word.substring(0,2)

  if (firstLetter == 'y' && secondLetter in vowels) {
    return word.substring(1) + "yay"
  }

  if (firstLetter in vowels || firstTwoLetters == "xr" || firstTwoLetters == "yt") {
    return word + "ay"
  } 

  val vowelPosition = word.indexOfFirst { it in vowels }
  val (prefix, suffix) = if (vowelPosition > 0 && word.substring(vowelPosition - 1, vowelPosition + 1) == "qu") {
    Pair(word.substring(0, vowelPosition + 1),  word.substring(vowelPosition + 1))
  } else {
    Pair(word.takeWhile { it !in vowels }, word.dropWhile { it !in vowels })
  }

  return suffix + prefix + "ay"
}

fun translate(text: String): String =
  text.split(" ").map { translateWord(it) }.joinToString(" ")