object Flattener {

  fun flatten(input: Collection<Any?>): List<Int> {
    val output = mutableListOf<Int>()

    for (element in input.filterNotNull()) {
      when (element) {
        is Collection<*> ->
          for (item in flatten(element.filterIsInstance<Any>())) output.add(item)
        else -> {
          output.add(element as Int)
        }
      }
    }
    return output
  }
}