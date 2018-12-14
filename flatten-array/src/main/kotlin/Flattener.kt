object Flattener {

  fun flatten(input: Collection<Any?>): List<Any> =
      input.filterNotNull().flatMap { element ->
        when (element) {
          is Collection<*> ->
            flatten(element)
          else -> {
            listOf(element)
          }
        }
      }
}