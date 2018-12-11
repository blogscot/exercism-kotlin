object Atbash {

  private val mapping = ('a'..'z').zip('z' downTo 'a')

  fun encode(text: String) =
      text
          .filter(Char::isLetterOrDigit)
          .map(Char::toLowerCase)
          .map(::translate)
          .chunked(5)
          .joinToString(" ") { it.joinToString("") }

  fun decode(text: String) =
      text
          .filter(Char::isLetterOrDigit)
          .map(::translate)
          .joinToString("")

  private fun translate(chr: Char) =
      if (chr.isDigit()) chr
      else mapping.find { it.first == chr }?.second
}