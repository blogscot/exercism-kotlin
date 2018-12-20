class School {

  private val grades = mutableMapOf<Int, List<String>>()

  fun db() = grades

  fun add(student: String, grade: Int) {
    val students = grades[grade]?.toMutableList() ?: mutableListOf()
    students.add(student)
    grades[grade] = students
  }

  fun grade(num: Int) = grades[num] ?: emptyList()

  fun sort() =
      grades.map { (key, students) ->
        Pair(key, students.sorted())
      }.toMap().toSortedMap()
}