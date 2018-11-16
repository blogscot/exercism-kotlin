package Pangram

fun isPangram(text: String): Boolean =
  ('a'..'z').all { it in text.toLowerCase() }

