package Raindrops

fun convert(num: Int): String {
  val modBy = { n: Int -> num % n == 0 }
  val modBy3 = modBy(3);
  val modBy5 = modBy(5);
  val modBy7 = modBy(7);
  var output = ""

  if (modBy3) output += "Pling"
  if (modBy5) output += "Plang"
  if (modBy7) output += "Plong"
  if (!modBy3 && !modBy5 && !modBy7) output = num.toString()

  return output
}