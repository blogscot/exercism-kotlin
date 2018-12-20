class Robot(
    var gridPosition: GridPosition = GridPosition(0, 0),
    var orientation: Orientation = Orientation.NORTH) {

  fun turnRight() {
    orientation = orientation.turnRight()
  }

  fun turnLeft() {
    orientation = orientation.turnLeft()
  }

  fun advance() {
    gridPosition = when (orientation) {
      Orientation.NORTH -> GridPosition(gridPosition.x, gridPosition.y + 1)
      Orientation.WEST -> GridPosition(gridPosition.x - 1, gridPosition.y)
      Orientation.SOUTH -> GridPosition(gridPosition.x, gridPosition.y - 1)
      Orientation.EAST -> GridPosition(gridPosition.x + 1, gridPosition.y)
    }
  }

  fun simulate(commands: String) {
    commands.forEach { command ->
      when (command) {
        'R' -> turnRight()
        'L' -> turnLeft()
        'A' -> advance()
        else -> {
        }
      }
    }
  }
}
