enum class Orientation {

  NORTH, EAST, SOUTH, WEST;


  fun turnRight() =
      when (this) {
        NORTH -> EAST
        EAST -> SOUTH
        SOUTH -> WEST
        WEST -> NORTH
      }

  fun turnLeft() =
      when (this) {
        NORTH -> WEST
        WEST -> SOUTH
        SOUTH -> EAST
        EAST -> NORTH
      }

}
