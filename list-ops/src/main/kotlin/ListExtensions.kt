fun <T> List<T>.customAppend(other: List<T>): List<T> =
    other.customFoldLeft(this) { acc, elem -> acc + elem }

fun <T> List<List<T>>.customConcat(): List<T> =
    this.customFoldLeft(mutableListOf()) { acc, list ->
      list.forEach { acc.add(it) }
      acc
    }

fun <T> List<T>.customFilter(block: (T) -> Boolean): List<T> =
    this.customFoldLeft(mutableListOf()) { acc, elem ->
      if (block(elem)) acc.add(elem)
      acc
    }

val <T> List<T>.customSize
  get() = this.customFoldLeft(0) { acc, _ -> acc + 1 }

fun <T, U> List<T>.customMap(block: (T) -> U): List<U> =
    this.customFoldLeft(mutableListOf()) { acc, elem ->
      acc.add(block(elem))
      acc
    }

fun <T, U> List<U>.customFoldLeft(initial: T, block: (T, U) -> T): T {
  var result = initial
  this.forEach { elem ->
    result = block(result, elem)
  }
  return result
}

fun <T, U> List<U>.customFoldRight(initial: T, block: (U, T) -> T): T =
    this.customReverse().customFoldLeft(initial) { acc, elem -> block(elem, acc) }


fun <T> List<T>.customReverse(): List<T> =
    this.customFoldLeft(listOf()) { acc, elem -> listOf(elem) + acc }
