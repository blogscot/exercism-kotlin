fun <T> List<T>.relationshipTo(other: List<T>): Relationship
    where T : Comparable<T> {

  val aContainsAllB = this.containsAll(other)
  val bContainsAllA = other.containsAll(this)

  return when {
    aContainsAllB && bContainsAllA ->
      if (this == other) Relationship.EQUAL else Relationship.UNEQUAL
    this.isEmpty() -> Relationship.SUBLIST
    other.isEmpty() -> Relationship.SUPERLIST
    aContainsAllB && this.containsInOrder(other) -> Relationship.SUPERLIST
    bContainsAllA && other.containsInOrder(this) -> Relationship.SUBLIST
    else -> Relationship.UNEQUAL
  }
}

private fun <T> List<T>.containsInOrder(other: List<T>): Boolean {
  var section: List<T> = this
  val firstElement = other.first()

  while (section.contains(firstElement)) {
    section = section.dropWhile { it != firstElement }
    if (section.take(other.size) == other) return true
    section = section.drop(1)
  }
  return false
}