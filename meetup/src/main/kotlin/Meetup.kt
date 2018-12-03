import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {
  private val lengthOfMonth: Int = LocalDate.of(year, month, 1).lengthOfMonth()

  fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate {

    val day = when (schedule) {
      MeetupSchedule.FIRST -> 1
      MeetupSchedule.SECOND -> 8
      MeetupSchedule.THIRD -> 15
      MeetupSchedule.FOURTH -> 22
      MeetupSchedule.TEENTH -> 13
      MeetupSchedule.LAST -> lengthOfMonth - 6
    }

    var calendar = LocalDate.of(year, month, day)

    while (calendar.dayOfWeek != dayOfWeek) {
      calendar = calendar.plusDays(1)
    }

    return calendar
  }
}