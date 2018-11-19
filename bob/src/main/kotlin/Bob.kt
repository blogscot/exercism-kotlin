package Bob

fun isShouting(comment: String): Boolean {
  return comment.any { it.isLetter() } && comment.toUpperCase() == comment
}

fun hey(text: String): String {
  val letters = text.filter { it.isLetterOrDigit() || it == '?'}
  return when {
    isShouting(letters) -> "Whoa, chill out!"
    letters.endsWith('?') -> "Sure."
    letters.isBlank() -> "Fine. Be that way!"
    else -> "Whatever."
  }
}