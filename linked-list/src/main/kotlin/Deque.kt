class Deque<T> {
  private val deque = mutableListOf<T>()

  fun push(element: T) = deque.add(element)
  fun pop(): T = deque.removeAt(deque.size - 1)
  fun shift(): T = deque.removeAt(0)
  fun unshift(element: T) = deque.add(0, element)
}