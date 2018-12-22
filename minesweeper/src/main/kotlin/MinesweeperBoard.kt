typealias Board = List<String>

data class Position(val x: Int, val y: Int)


class MinesweeperBoard(private val board: Board) {

  fun withNumbers(): List<String> =
      board.withIndex().map { (rowIndex, x) ->
        x.withIndex().map { (colIndex, square) ->
          if (square != '*') {
            val neighbours = calculateNeighbours(Position(rowIndex, colIndex))
            if (neighbours > 0) neighbours.toString() else " "
          } else square.toString()
        }.joinToString("")
      }

  private fun calculateNeighbours(pos: Position): Int {
    val neighbours = listOf(
        -1 to -1, 0 to -1, 1 to -1,
        -1 to 0, 0 to 0, 1 to 0,
        -1 to 1, 0 to 1, 1 to 1
    )

    if (board[pos.x][pos.y] == '*') return 0

    return neighbours
        .map { (x, y) -> Pair(pos.x + x, pos.y + y) }
        .filter { (x, y) -> 0 <= x && x < board.size && 0 <= y && y < board[0].length && Position(x, y) != pos }
        .fold(0) { acc, (x, y) ->
          if (board[x][y] == '*') {
            acc + 1
          } else {
            acc
          }
        }
  }
}





