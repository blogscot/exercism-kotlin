package Isogram

fun isIsogram(text: String): Boolean =
  text.toLowerCase()
    .filter(Char::isLetter)
    .let { it.toSet().size == it.length }
