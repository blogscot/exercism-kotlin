package pigLatin

fun translate(text: String): String =
    text.split(" ").joinToString(" ") { translateWord(it) }

private fun translateWord(word: String) =
    when {
      word.matches("(yt|xr|[aeiou]|[aeiou]qu).*".toRegex()) -> word + "ay"
      word.matches("(thr|sch|[^aeiou]qu).*".toRegex()) -> word.drop(3) + word.take(3) + "ay"
      word.matches("(ch|qu|th|rh).*".toRegex()) -> word.drop(2) + word.take(2) + "ay"
      else -> word.substring(1) + word.first() + "ay"
    }

