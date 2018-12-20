typealias Grades = MutableMap<Int, List<String>>

class School {
  private val grades: Grades = mutableMapOf()

  fun db(): Grades = grades

  fun add(student: String, grade: Int) {
    val students = grades[grade]?.toMutableList() ?: mutableListOf()
    students.add(student)
    grades[grade] = students
  }

  fun grade(num: Int) = grades[num] ?: emptyList()

  fun sort(): Grades =
      grades.map { (key, students) ->
        Pair(key, students.sorted())
      }.toMap().toSortedMap().toMutableMap()
}