object HandshakeCalculator {

  fun calculateHandshake(num: Int): List<Signal> =
    mutableListOf<Signal>().apply {
      if (num and 1 > 0) add(Signal.WINK)
      if (num and 2 > 0) add(Signal.DOUBLE_BLINK)
      if (num and 4 > 0) add(Signal.CLOSE_YOUR_EYES)
      if (num and 8 > 0) add(Signal.JUMP)
      if (num and 16 > 0) reverse()
  }
}
