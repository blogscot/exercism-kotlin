import java.lang.Exception

fun transcribeToRna(dna: String): String =
  dna.map { transcribe(it) }.joinToString("")

fun transcribe(letter: Char) : Char =
  when (letter) {
    'C' -> 'G'
    'G' -> 'C'
    'T' -> 'A'
    'A' -> 'U'
    else -> throw Exception("Unable to transcribe $letter")
  }
