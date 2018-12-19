object BracketPush {

  fun isValid(text: String): Boolean {
    val stack = mutableListOf<Char>()

    for (letter in text) {
      when (letter) {
        '[' -> stack.add(']')
        '(' -> stack.add(')')
        '{' -> stack.add('}')
        ']', ')', '}' -> {
          if (!stack.isEmpty() && stack.last() == letter)
            stack.removeAt(stack.size - 1) else return false
        }
        else -> {}
      }
    }
    return stack.isEmpty()
  }
}