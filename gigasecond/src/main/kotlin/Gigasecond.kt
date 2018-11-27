import java.time.LocalDateTime
import java.time.LocalDate

class Gigasecond(startDate: LocalDateTime) {

  val date: LocalDateTime = startDate.plusSeconds(1_000_000_000)

  constructor(startDate: LocalDate) : this(startDate.atStartOfDay())
}
