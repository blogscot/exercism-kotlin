import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(startDate: LocalDateTime) {

  val date: LocalDateTime
    get() = field.plusSeconds(1_000_000_000)

  init {
    date = startDate
  }

  constructor(startDate: LocalDate) : this(startDate.atStartOfDay())
}
