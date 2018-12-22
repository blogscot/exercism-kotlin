class MinesweeperBoard(private val board: List<String>) {
  private val neighbours = listOf(
      -1 to -1, 0 to -1, 1 to -1,
      -1 to 0, 1 to 0,
      -1 to 1, 0 to 1, 1 to 1
  )

  fun withNumbers(): List<String> =
      board.mapIndexed { rowIndex, row ->
        row.withIndex().joinToString("") { (colIndex, square) ->
          findNewSquare(square, Pair(rowIndex, colIndex))
        }
      }

  private fun findNewSquare(square: Char, pos: Pair<Int, Int>) =
    if (square != '*') {
      val numNeighbours = calculateNeighbours(pos)
      if (numNeighbours > 0) numNeighbours.toString() else " "
    } else "*"

  private fun calculateNeighbours(pos: Pair<Int, Int>): Int =
      neighbours
          .map { (x, y) -> Pair(pos.first + x, pos.second + y) }
          .filter { (x, y) -> x in 0 until board.size && y in 0 until board[0].length }
          .fold(0) { acc, (x, y) ->
            if (board[x][y] == '*') acc + 1 else acc
          }
}





