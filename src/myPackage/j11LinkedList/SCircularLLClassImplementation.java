package myPackage.j11LinkedList;

public class SCircularLLClassImplementation {

  Node tail;
  private int size;

  class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
      size++;
    }
  }

  SCircularLLClassImplementation() {
    size = 0;
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
      System.out.println(tail.val + " --> HEAD");
      return;
    }
    Node curNode = tail.next;
    do {
      System.out.print(curNode.val + " --> ");
      curNode = curNode.next;
    } while (curNode != tail);
    System.out.println(curNode.val + " --> HEAD");
  }

  void addToEmpty(int val) {
    Node newNode = new Node(val);
    tail = newNode;
    tail.next = tail;
  }

  void addAtFirst(int val) {
    if (tail == null) {
      addToEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    newNode.next = tail.next;
    tail.next = newNode;
  }

  void addAtLast(int val) {
    if (tail == null) {
      addToEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    newNode.next = tail.next;
    tail.next = newNode;
    tail = newNode;
  }

  void addAtIndex(int index, int val) {
    if (index <= 0)
      addAtFirst(val);
    else if (index == size)
      addAtLast(val);
    else if (index < size) {
      Node newNode = new Node(val);
      Node cur = tail.next;
      while (index-- > 1)
        cur = cur.next;
      newNode.next = cur.next;
      cur.next = newNode;
    } else {
      addAtIndex(index % size, val);
    }
  }

  void removeBaseCases() {
    if (tail == null)
      return;
    if (tail.next == tail) {
      tail = null;
      size--;
      return;
    }
  }

  void removeFirst() {
    if (tail == null || tail.next == tail) {
      removeBaseCases();
      return;
    }
    size--;
    tail.next = tail.next.next;
  }

  void removeLast() {
    if (tail == null || tail.next == tail) {
      removeBaseCases();
      return;
    }
    size--;
    Node cur = tail.next;
    while (cur.next != tail)
      cur = cur.next;
    cur.next = tail.next;
    tail = cur;
  }

  void removeAtIndex(int index) {
    if (index <= 0)
      removeFirst();
    else if (index == size - 1)
      removeLast();
    else if (index < size - 1) {
      size--;
      Node cur = tail.next;
      while (index-- > 1)
        cur = cur.next;
      cur.next = cur.next.next;
    } else {
      removeAtIndex(index % size);
    }
  }

  int getIndex(int val) {
    if (tail == null)
      return -1;
    if (tail.next == tail)
      return (tail.val == val) ? 0 : -1;
    Node cur = tail.next;
    int index = 0;
    do {
      if (cur.val == val)
        return index;
      index++;
      cur = cur.next;
    } while (cur != tail.next);
    return -1;
  }

  int getValue(int index) {
    if (index < 0) {
      return -1;
    } else if (index > size - 1) {
      index = index % size;
    }
    Node cur = tail.next;
    while (index-- > 0)
      cur = cur.next;
    return cur.val;
  }

  public static void main(String args[]) {
    SCircularLLClassImplementation list = new SCircularLLClassImplementation();
    System.out.println("Size: " + list.getSize());
    list.printList();
    list.addAtFirst(5);
    list.printList();
    list.addAtFirst(4);
    list.printList();
    list.addAtFirst(3);
    list.printList();
    System.out.println("Size: " + list.getSize());
    list.addAtLast(6);
    list.printList();
    list.addAtLast(7);
    list.printList();
    list.addAtLast(8);
    list.printList();
    System.out.println("Size: " + list.getSize());
    list.addAtIndex(-5, 0);
    list.printList();
    list.addAtIndex(20, 12);
    list.printList();
    list.addAtIndex(3, 35);
    list.printList();
    System.out.println("Size: " + list.getSize());
    list.removeFirst();
    list.printList();
    list.removeFirst();
    list.printList();
    System.out.println("Size: " + list.getSize());
    list.removeLast();
    list.printList();
    list.removeLast();
    list.printList();
    System.out.println("Size: " + list.getSize());
    list.addAtLast(6);
    list.addAtLast(7);
    list.addAtLast(8);
    list.printList();
    list.removeAtIndex(-5);
    list.printList();
    list.removeAtIndex(20);
    list.printList();
    list.removeAtIndex(3);
    list.printList();
    System.out.println("Size: " + list.getSize());
    System.out.println(list.getIndex(20));
    System.out.println(list.getIndex(-5));
    System.out.println(list.getIndex(15));
    System.out.println(list.getValue(25));
    System.out.println(list.getValue(-5));
    System.out.println(list.getValue(1));
  }
}
