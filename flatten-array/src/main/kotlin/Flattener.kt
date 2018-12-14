object Flattener {

  fun flatten(input: Collection<Any?>): List<Int> {
    return input.filterNotNull().flatMap {element ->
      when (element) {
        is Collection<*> ->
          flatten(element.filterIsInstance<Any>())
        else -> {
          listOf(element as Int)
        }
      }
    }
  }
}