class LinkedList() {
  var head: Node = null

  def addToStart(s: String): Unit = {
    head = new Node(s, head)
  }

  def getSize(): Int = {
    var size = 0

    if (head == null) return 0

    var current: Node = head
    while (current.next != null) {
      size += 1
      current = current.next
    }

    size + 1
  }

  override def toString(): String = {
    var s = "List content (size " + getSize() + ") : "

    if (head == null) return s + "null"

    var current: Node = head
    while (current.next != null) {
      s += current.item
      s += " -> "
      current = current.next
    }

    s += current.item
    s += " -> null"
    s
  }

  def removeFirstElement(): Unit = {
    if (head == null) return
    head = head.next
  }

  def getLastElement(): Node = {
    if (head == null) return null
    if (getSize() == 1) return head

    var last: Node = head
    while (last.next != null) {
      last = last.next
    }

    last
  }

  def addToEnd(element: String): Unit = {
    if (head == null) {
      head = new Node(element, null)
      return
    }

    getLastElement().next = new Node(element, null)
  }

  def isPresent(e: String): Boolean = {
    if (head == null) return false
    if (getSize() == 1) return head.item == e

    var current: Node = head
    while (current.next != null) {
      if (current.item == e) return true
      current = current.next
    }

    if (current.item == e) return true
    false
  }

  def findElement(s: String): Node = {
    if (head == null) return null

    var current: Node = head
    while (current.next != null) {
      if (current.item == s) {
        return current
      }

      current = current.next
    }

    if (current.item == s) return current

    null
  }

  def swapElements(e1: String, e2: String): Unit = {
    val t1: Node = findElement(e1)
    val t2: Node = findElement(e2)

    if (t1 == null || t2 == null) return

    t1.item = e2
    t2.item = e1
  }

  def removeLastElement(): Unit = {
    if (head == null) return
    if (head.next == null) {
      head = null
      return
    }

    var current: Node = head
    var preceding: Node = null
    while (current.next != null) {
      preceding = current
      current = current.next
    }

    preceding.next = null
  }

  def removeElement(e: String): Unit = {
    val toDelete: Node = findElement(e)
    if (toDelete == null) return
    if (toDelete.item == head.item) {
      if (head.next == null) {
        head = null
        return
      }
      head.item = head.next.item
      head.next = head.next.next
      return
    }

    var current: Node = head
    var preceding: Node = head
    while (current.item != toDelete.item) {
      preceding = current
      current = current.next
    }

    preceding.next = toDelete.next
  }

  def insertAfter(before: String, after: String): Unit = {
    if (!isPresent(before)) return

    val b: Node = findElement(before)
    val a: Node = new Node(after, b.next)
    b.next = a
  }
}

object LinkedList extends App {
  var flightList: LinkedList = new LinkedList()
  println(flightList)
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)
}
