package myPackage.j11LinkedList;

public class DCircularLLClassImplementation {

  int size;
  Node head;
  Node tail;

  DCircularLLClassImplementation() {
    this.size = 0;
  }

  class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
      this.val = val;
      size++;
    }
  }

  int getSize() {
    return size;
  }

  void printList() {
    if (tail == null) {
      System.out.println("null");
      return;
    }
    if (tail.next == tail) {
      System.out.println("[" + tail.val + "]");
      return;
    }
    Node cur = head;
    System.out.print("[");
    do {
      System.out.print(cur.val + ", ");
      cur = cur.next;
    } while (cur != tail);
    System.out.println(tail.val + "]");
  }

  void printListReverse() {
    if (tail == null) {
      System.out.println("null");
      return;
    }
    if (tail.next == tail) {
      System.out.println("[" + tail.val + "]");
      return;
    }
    Node cur = tail;
    System.out.print("[");
    do {
      System.out.print(cur.val + ", ");
      cur = cur.prev;
    } while (cur != head);
    System.out.println(head.val + "]");
  }

  void addToEmpty(int val) {
    Node newNode = new Node(val);
    head = newNode;
    newNode.next = newNode;
    tail = newNode;
    newNode.prev = newNode;
  }

  void addToStart(int val) {
    if (tail == null) {
      addToEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    newNode.next = head;
    newNode.prev = tail;
    head.prev = newNode;
    tail.next = newNode;
    head = newNode;
  }

  void addToEnd(int val) {
    if (tail == null) {
      addToEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    newNode.next = head;
    newNode.prev = tail;
    head.prev = newNode;
    tail.next = newNode;
    tail = newNode;
  }

  void addAtIndex(int index, int val) {
    if (index == 0) {
      addToStart(val);
    } else if (index == size || index == -1) {
      addToEnd(val);
    } else if (index >= 0 && index < size / 2) {
      Node newNode = new Node(val);
      Node cur = head;
      while (index-- > 1)
        cur = cur.next;
      newNode.next = cur.next;
      newNode.prev = cur;
      newNode.next.prev = newNode;
      cur.next = newNode;
    } else if (index >= size / 2 && index < size) {
      Node newNode = new Node(val);
      Node cur = tail;
      index = size - 1 - index;
      while (index-- > 1)
        cur = cur.prev;
      newNode.next = cur;
      newNode.prev = cur.prev;
      cur.prev = newNode;
      newNode.prev.next = newNode;
    } else if (index < 0) {
      addAtIndex(size - (Math.abs(index)) % size, val);
    } else if (index > size) {
      addAtIndex((index) % size, val);
    }
  }

  void removeBaseCases() {
    if (tail == null)
      return;
    if (tail.next == tail) {
      head = null;
      tail = null;
      size--;
      return;
    }
  }

  void removeAtStart() {
    if (tail == null || tail.next == tail) {
      removeBaseCases();
      return;
    }
    size--;
    head = head.next;
    head.prev = tail;
    tail.next = head;
  }

  void removeAtEnd() {
    if (tail == null || tail.next == tail) {
      removeBaseCases();
      return;
    }
    size--;
    tail = tail.prev;
    head.prev = tail;
    tail.next = head;
  }

  void removeAtIndex(int index) {
    if (index == 0) {
      removeAtStart();
    } else if (index == size - 1 || index == -1) {
      removeAtEnd();
    } else if (index >= 0 && index < size / 2) {
      size--;
      Node cur = head;
      while (index-- > 1)
        cur = cur.next;
      cur.next = cur.next.next;
      cur.next.prev = cur;
    } else if (index >= size / 2 && index < size) {
      size--;
      Node cur = tail;
      index = size - 1 - index;
      while (index-- > 1)
        cur = cur.prev;
      cur.prev = cur.prev.prev;
      cur.prev.next = cur;
    } else if (index < 0) {
      removeAtIndex(size - (Math.abs(index)) % size);
    } else if (index > size) {
      removeAtIndex(index % size);
    }
  }

  int getIndex(int val) {
    if (tail == null)
      return -1;
    if (tail.next == tail)
      return (tail.val == val) ? 0 : -1;
    Node cur = head;
    int index = 0;
    do {
      if (cur.val == val)
        return index;
      index++;
      cur = cur.next;
    } while (cur != head);
    return -1;
  }

  int getValue(int index) {
    if (index < 0) {
      index = size - (Math.abs(index)) % size;
    } else if (index > size) {
      index = index % size;
    }
    Node cur = head;
    while (index-- > 0)
      cur = cur.next;
    return cur.val;
  }

  public static void main(String args[]) {
    DCircularLLClassImplementation ll = new DCircularLLClassImplementation();
    ll.addToStart(5);
    ll.addToStart(3);
    ll.addToEnd(6);
    ll.addToEnd(8);
    ll.addAtIndex(3, 7);
    ll.addAtIndex(1, 4);
    ll.addAtIndex(0, 2);
    ll.addAtIndex(7, 9);
    ll.addAtIndex(-1, 10);
    ll.addAtIndex(9, 11);
    ll.addAtIndex(-10, 25);
    ll.addAtIndex(15, 35);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.removeAtStart();
    ll.removeAtStart();
    ll.removeAtEnd();
    ll.removeAtEnd();
    ll.removeAtIndex(2);
    ll.removeAtIndex(6);
    ll.removeAtIndex(-1);
    ll.removeAtIndex(9);
    ll.removeAtIndex(-10);
    ll.removeAtIndex(15);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.addToStart(5);
    ll.addToStart(3);
    ll.addToEnd(6);
    ll.addToEnd(8);
    ll.addAtIndex(3, 7);
    ll.addAtIndex(1, 4);
    ll.addAtIndex(0, 2);
    ll.addAtIndex(7, 9);
    ll.addAtIndex(-1, 10);
    ll.addAtIndex(9, 11);
    ll.addAtIndex(-10, 25);
    ll.addAtIndex(15, 35);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    System.out.println(ll.getIndex(6));
    System.out.println(ll.getIndex(10));
    System.out.println(ll.getIndex(234));
    System.out.println(ll.getValue(6));
    System.out.println(ll.getValue(10));
    System.out.println(ll.getValue(-5));
    System.out.println(ll.getValue(15));
  }
}
