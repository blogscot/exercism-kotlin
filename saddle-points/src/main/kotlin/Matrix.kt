class Matrix(private val matrix: List<List<Int>>) {

  val saddlePoints: Set<MatrixCoordinate>
    get() {
      val saddlePoints = mutableSetOf<MatrixCoordinate>()

      for ((rowIndex, row) in matrix.withIndex()) {
        for ((colIndex, _) in row.withIndex()) {
          if (rowMax(rowIndex) == colMin(colIndex)) {
            saddlePoints.add(MatrixCoordinate(rowIndex, colIndex))
          }
        }
      }

      return saddlePoints
    }

  private fun rowMax(row: Int) =
      matrix[row].max()

  private fun colMin(col: Int) =
      (0 until matrix[0].size).map { matrix[it][col] }.min()
}