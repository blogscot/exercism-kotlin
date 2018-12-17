object SpiralMatrix {

  fun ofSize(size: Int): Array<IntArray> {

    val arr = Array(size) { IntArray(size) { 0 } }

    var row = 0
    var col = -1
    var num = 1
    var count: Int
    var moves = size

    while (moves > 0 && num <= (size * size)) {

      // move right
      count = moves
      while (count-- > 0) {
        col++
        arr[row][col] = num++
      }

      // move down
      moves -= 1
      count = moves

      while (count-- > 0) {
        row++
        arr[row][col] = num++
      }

      // move left
      count = moves
      while (count-- > 0) {
        col--
        arr[row][col] = num++
      }

      // move up
      moves -= 1
      count = moves
      while (count-- > 0) {
        row--
        arr[row][col] = num++
      }
    }

    return arr
  }
}