data class Position(val x: Int, val y: Int)


class MinesweeperBoard(private val board: List<String>) {
  private val neighbours = listOf(
      -1 to -1, 0 to -1, 1 to -1,
      -1 to 0, 1 to 0,
      -1 to 1, 0 to 1, 1 to 1
  )

  fun withNumbers(): List<String> =
      board.mapIndexed { rowIndex, x ->
        x.withIndex().joinToString("") { (colIndex, square) ->
          if (square != '*') {
            val neighbours = calculateNeighbours(Position(rowIndex, colIndex))
            if (neighbours > 0) neighbours.toString() else " "
          } else "*"
        }
      }

  private fun calculateNeighbours(pos: Position): Int =
      neighbours
          .map { (x, y) -> Pair(pos.x + x, pos.y + y) }
          .filter { (x, y) -> x in 0 until board.size && y in 0 until board[0].length }
          .fold(0) { acc, (x, y) ->
            if (board[x][y] == '*') acc + 1 else acc
          }
}





