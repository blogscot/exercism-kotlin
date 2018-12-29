object ETL {

  fun transform(old: Map<Int, List<Char>>): Map<Char, Int> =
    old.flatMap {
      it.value.map { letter -> letter.toLowerCase() to it.key }
    }.toMap()

}