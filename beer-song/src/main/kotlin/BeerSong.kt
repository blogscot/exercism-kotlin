object BeerSong {

  data class Msgs(
      var how_many: String = "",
      var how_many_second: String = "",
      var instruction: String = "",
      var how_many_final: String = ""
  )

  fun getMsgs(num_bottles: Int): Msgs =
      when (num_bottles) {
        0 -> Msgs(
            "No more bottles",
            "no more bottles",
            "Go to the store and buy some more",
            "99 bottles"
        )
        1 -> Msgs(
            "1 bottle",
            "1 bottle",
            "Take it down and pass it around",
            "no more bottles"
        )
        2 -> Msgs(
            "2 bottles",
            "2 bottles",
            "Take one down and pass it around",
            "1 bottle"
        )
        else -> Msgs(
            "$num_bottles bottles",
            "$num_bottles bottles",
            "Take one down and pass it around",
            "${num_bottles - 1} bottles"
        )
      }

  fun verses(start: Int, end: Int): String {
    val lines = mutableListOf<String>()

    for (index in start downTo end) {
      val msgs = getMsgs(index)
      lines.add(
          "${msgs.how_many} of beer on the wall, ${msgs.how_many_second} of beer.\n" +
              "${msgs.instruction}, ${msgs.how_many_final} of beer on the wall.\n"
      )
    }
    return lines.joinToString("\n")
  }
}