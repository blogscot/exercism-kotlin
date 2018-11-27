import java.math.BigDecimal

private const val EARTH_PERIOD = 31557600.0

class SpaceAge(seconds: Long) {

  private val earthRotations = seconds / EARTH_PERIOD

  constructor(seconds: Int): this(seconds.toLong())

  fun onEarth() = earthRotations.round()
  fun onMercury() = (earthRotations / 0.2408467).round()
  fun onVenus() = (earthRotations / 0.61519726).round()
  fun onMars() = (earthRotations / 1.8808158).round()
  fun onJupiter() = (earthRotations / 11.862615).round()
  fun onSaturn() = (earthRotations / 29.447498).round()
  fun onUranus() = (earthRotations / 84.016846).round()
  fun onNeptune() = (earthRotations / 164.79132).round()

  private fun Double.round(places: Int = 2) =
    BigDecimal(toString())
        .setScale(places, BigDecimal.ROUND_HALF_UP)
        .toDouble()
}