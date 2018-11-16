package Raindrops

fun convert(num: Int): String {
  val (modBy3, modBy5, modBy7) = listOf(3, 5, 7).map { num % it == 0 };
  var sb = StringBuilder()

  if (modBy3) sb.append("Pling")
  if (modBy5) sb.append("Plang")
  if (modBy7) sb.append("Plong")
  if (!modBy3 && !modBy5 && !modBy7) sb.append(num)

  return sb.toString()
}
