import kotlin.random.Random

class Robot {

  private fun getRandomNumber() =
      Random.nextInt(0, 10)

  private fun getRandomLetter() =
      ('A'..'Z').toList()[Random.nextInt(0, 26)]

  private fun getRobotName(): String {
    var robotName: String

    do {
      robotName = (1..2).map { getRandomLetter() }.joinToString("") +
          (1..3).map { getRandomNumber() }.joinToString("")
    } while (robotName == name)

    return robotName
  }

  var name = getRobotName()
    private set

  fun reset() {
    name = getRobotName()
  }
}