object HandshakeCalculator {

  fun calculateHandshake(num: Int): List<Signal> {
    val signals = mutableListOf<Signal>()

    if (num and 1 > 0) signals.add(Signal.WINK)
    if (num and 2 > 0) signals.add(Signal.DOUBLE_BLINK)
    if (num and 4 > 0) signals.add(Signal.CLOSE_YOUR_EYES)
    if (num and 8 > 0) signals.add(Signal.JUMP)
    if (num and 16 > 0) signals.reverse()

    return signals
  }
}

