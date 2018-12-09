import java.lang.IllegalArgumentException

class Triangle<T>(side1: T, side2: T, side3: T)
    where T : Number,
          T : Comparable<T> {
  private val results = listOf(side1, side2, side3).sorted()
  private val a = results[0]
  private val b = results[1]
  private val c = results[2]

  init {
    val (x, y, z) = listOf(a.toFloat(), b.toFloat(), c.toFloat())
    if ((x <= 0) or (y <= 0) or (z <= 0) or (x + y < z)) {
      throw IllegalArgumentException()
    }
  }

  val isEquilateral
    get() = (a == b) and (a == c)

  val isIsosceles: Boolean
    get() = (a == b) or (b == c)

  val isScalene
    get() = (a != b) and (b != c)

}

