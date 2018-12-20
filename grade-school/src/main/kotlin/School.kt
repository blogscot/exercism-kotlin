class School {

  private val db = mutableMapOf<Int, List<String>>()

  fun db() = db

  fun add(student: String, grade: Int) {
    val students = db.getOrDefault(grade, emptyList())
    db[grade] = students + student
  }

  fun grade(year: Int) = db.getOrDefault(year, emptyList())

  fun sort() =
      db.map { (key, students) ->
        Pair(key, students.sorted())
      }.toMap().toSortedMap()
}