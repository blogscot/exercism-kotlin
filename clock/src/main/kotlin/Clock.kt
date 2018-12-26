data class Clock(private var hours: Int, private var minutes: Int) {

  init {
    normalize()
  }

  fun add(minutes: Int) =
      normalize(minutes)

  private fun normalize(extraMinutes: Int = 0) {
    minutes += extraMinutes

    while (minutes < 0) {
      hours--
      minutes += 60
    }

    val extraHours = minutes / 60
    minutes %= 60

    if (hours < 0) {
      hours = (hours % 24) + 24
    }
    hours = (hours + extraHours) % 24
  }

  override fun toString(): String {
    val padHours = hours.toString().padStart(2, '0')
    val padMinutes = minutes.toString().padStart(2, '0')
    return "$padHours:$padMinutes"
  }

}