data class Node<T>(val data: T, var next: Node<T>? = null, var previous: Node<T>? = null)

class Deque<T> {

  var head: Node<T>? = null
  var tail: Node<T>? = null

  fun push(entry: T) {
    if (head == null) {
      val newNode = Node(entry)
      head = newNode
      tail = newNode
    } else {
      // push entry onto end
      val newNode = Node(entry, previous = tail)
      tail?.next = newNode
      tail = newNode
    }
  }

  fun pop(): T? {
    val data = tail?.data
    tail = tail?.previous
    return data
  }

  fun shift(): T? {
    val data = head?.data
    head = head?.next
    return data
  }

  fun unshift(entry: T) {
    if (head == null) {
      val newNode = Node(entry)
      head = newNode
      tail = newNode
    } else {
      // push entry onto start
      val newNode = Node(entry, next = head)
      head?.previous = newNode
      head = newNode
    }
  }
}
