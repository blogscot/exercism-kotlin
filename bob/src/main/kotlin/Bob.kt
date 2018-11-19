package Bob

private fun String.isShouting(): Boolean =
  this.any { it.isLetter() } && this.toUpperCase() == this

fun hey(text: String): String {
  val letters = text.filter { it.isLetterOrDigit() || it == '?'}
  return when {
    letters.isShouting() -> "Whoa, chill out!"
    letters.endsWith('?') -> "Sure."
    letters.isBlank() -> "Fine. Be that way!"
    else -> "Whatever."
  }
}