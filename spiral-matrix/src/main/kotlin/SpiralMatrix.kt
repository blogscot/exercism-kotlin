object SpiralMatrix {

  fun ofSize(size: Int): Array<IntArray> {

    val matrix = Array(size) { IntArray(size) { 0 } }

    var row = 0
    var col = -1
    var num = 1
    var moves = size

    val right = { col++ }
    val left = { col-- }
    val up = { row-- }
    val down = { row++ }

    val move = { action: () -> Int, numMoves: Int ->

      repeat(numMoves) {
        action()
        matrix[row][col] = num++
      }
    }

    repeat(size * size) {
      move(right, moves)
      move(down, --moves)
      move(left, moves)
      move(up, --moves)
    }

    return matrix
  }
}