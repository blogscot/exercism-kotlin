object BinarySearch {

  fun search(elements: List<Int>, num: Int): Int {
    var start = 0
    var end = elements.size - 1
    var middle: Int
    var current: Int

    while (start <= end) {
      middle = (start + end) / 2
      current = elements[middle]

      when {
        num == current -> return middle
        num > current -> start = middle + 1
        else -> end = middle - 1
      }
    }
    return -1
  }
}