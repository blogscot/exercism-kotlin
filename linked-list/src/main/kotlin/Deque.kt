data class Node<T>(val data: T, var next: Node<T>? = null, var previous: Node<T>? = null)

class Deque<T> {

  var head: Node<T>? = null
  var tail: Node<T>? = null

  fun push(entry: T) = tail.let { old ->
    tail = Node(entry, previous = old)
    old?.next = tail

    if (head == null) head = tail
  }

  fun pop(): T? = tail?.let { old ->
    if (head == old) head = null
    tail = old.previous
    tail?.next = null
    return old.data
  }

  fun shift(): T? = head?.let { old ->
    if (tail == old) tail = null
    head = old.next
    head?.previous = null
    old.data
  }

  fun unshift(entry: T) = head.let { old ->
    head = Node(entry, next = old)
    old?.previous = head

    if (tail == null) tail = head
  }
}
