import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond {

  constructor(startDate: LocalDateTime) {
    date = startDate
  }

  constructor(startDate: LocalDate) {
    date = startDate.atTime(0, 0, 0, 0)
  }

  var date: LocalDateTime
    get() {
      return field.plusSeconds(1_000_000_000)
    }
}
