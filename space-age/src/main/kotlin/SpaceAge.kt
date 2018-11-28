import java.math.BigDecimal

private const val EARTH_PERIOD = 31557600.0

class SpaceAge(private val seconds: Long, private val decimalPlaces: Int = 2) {

  private fun calculateAge(ratio: Double): Double =
      round(seconds / EARTH_PERIOD / ratio)

  fun onEarth() = calculateAge(1.0)
  fun onMercury() = calculateAge(0.2408467)
  fun onVenus() = calculateAge(0.61519726)
  fun onMars() = calculateAge(1.8808158)
  fun onJupiter() = calculateAge(11.862615)
  fun onSaturn() = calculateAge(29.447498)
  fun onUranus() = calculateAge(84.016846)
  fun onNeptune() = calculateAge(164.79132)

  private fun round(value: Double, places: Int = decimalPlaces) =
    BigDecimal(value.toString())
        .setScale(places, BigDecimal.ROUND_HALF_UP)
        .toDouble()
}