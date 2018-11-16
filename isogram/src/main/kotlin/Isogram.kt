package Isogram

fun isIsogram(text: String): Boolean {
  var letters = text.toLowerCase().filter { it in 'a'..'z' }.toList()
  return letters.distinct().size == letters.size
}
