data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

  operator fun plus(other: ComplexNumber) =
      ComplexNumber(real + other.real, imag + other.imag)

  operator fun minus(other: ComplexNumber) =
      ComplexNumber(real - other.real, imag - other.imag)

  operator fun times(other: ComplexNumber) =
      ComplexNumber(real * other.real - imag * other.imag, real * other.imag + other.real * imag)

  operator fun div(other: ComplexNumber): ComplexNumber {
    val divisor = other.real * other.real + other.imag * other.imag
    return ComplexNumber(
        (real * other.real + imag * other.imag) / divisor,
        (imag * other.real - real * other.imag) / divisor
    )
  }

  val abs: Double = Math.sqrt((real * real) + (imag * imag))

  fun conjugate() = ComplexNumber(real, -imag)
}

fun exponential(number: ComplexNumber) = ComplexNumber(Math.exp(number.real)) * exponential(number.imag)

private fun exponential(b: Double) = ComplexNumber(Math.cos(b), Math.sin(b))
