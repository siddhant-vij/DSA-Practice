package myPackage.j11LinkedList;

public class DoublyLLClassImplementation {
  Node head;
  private int size;

  DoublyLLClassImplementation() {
    size = 0;
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
    return this.size;
  }

  void printList() {
    Node curNode = head;
    while (curNode != null) {
      System.out.print(curNode.val + " <--> ");
      curNode = curNode.next;
    }
    System.out.println("null");
  }

  void printListForward() {
    printList();
  }

  void printListBackwards() {
    Node curNode = head;
    if (head == null) {
      System.out.println("null");
      return;
    }
    while (curNode.next != null) {
      curNode = curNode.next;
    }
    System.out.print("null <--> ");
    while (curNode != head) {
      System.out.print(curNode.val + " <--> ");
      curNode = curNode.prev;
    }
    System.out.println(head.val);
  }

  void addFirst(int val) {
    Node newNode = new Node(val);
    newNode.next = head;
    if (head != null)
      head.prev = newNode;
    head = newNode;
  }

  void addLast(int val) {
    if (head == null) {
      addFirst(val);
      return;
    }

    Node newNode = new Node(val);
    Node curNode = head;
    while (curNode.next != null)
      curNode = curNode.next;
    newNode.prev = curNode;
    curNode.next = newNode;
  }

  void addAtIndex(int index, int val) {
    if (index <= 0 || head == null)
      addFirst(val);
    else if (index >= size - 1)
      addLast(val);
    else {
      Node newNode = new Node(val);
      Node curNode = head;
      while (index-- > 1)
        curNode = curNode.next;
      newNode.next = curNode.next;
      curNode.next.prev = newNode;
      curNode.next = newNode;
      newNode.prev = curNode;
    }
  }

  void removeFirst() {
    if (head == null)
      return;
    size--;
    if (head.next == null) {
      head = null;
      return;
    }
    head = head.next;
    head.prev = null;
  }

  void removeLast() {
    if (head == null)
      return;
    size--;
    if (head.next == null) {
      head = null;
      return;
    }
    Node curNode = head;
    while (curNode.next.next != null)
      curNode = curNode.next;
    curNode.next = null;
  }

  void removeAtIndex(int index) {
    if (index <= 0 || head == null)
      removeFirst();
    else if (index >= size - 1)
      removeLast();
    else {
      size--;
      Node curNode = head;
      while (index-- > 1)
        curNode = curNode.next;
      curNode.next = curNode.next.next;
      curNode.next.prev = curNode;
    }
  }

  int getIndex(int val) {
    if (head == null)
      return -1;
    Node curNode = head;
    int index = 0;
    while (curNode != null) {
      if (curNode.val == val)
        return index;
      index++;
      curNode = curNode.next;
    }
    return -1;
  }

  int getElement(int index) {
    if (head == null)
      return -1;
    if (index < 0 || index >= size)
      return -1;
    Node curNode = head;
    while (index-- > 0)
      curNode = curNode.next;
    return curNode.val;
  }

  public static void main(String args[]) {
    DoublyLLClassImplementation ll = new DoublyLLClassImplementation();
    System.out.println("Size: " + ll.getSize());
    ll.printList();
    ll.addFirst(5);
    ll.printList();
    ll.addFirst(4);
    ll.addFirst(3);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.addLast(6);
    ll.addLast(7);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.addAtIndex(3, 20);
    ll.printList();
    ll.addAtIndex(20, 25);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.addAtIndex(7, 40);
    ll.addAtIndex(7, 50);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.printListForward();
    ll.printListBackwards();
    ll.removeFirst();
    ll.printList();
    ll.removeFirst();
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.removeLast();
    ll.printList();
    ll.removeLast();
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    ll.removeAtIndex(3);
    ll.printList();
    ll.removeAtIndex(1);
    ll.printList();
    System.out.println("Size: " + ll.getSize());
    System.out.println(ll.getIndex(6));
    System.out.println(ll.getElement(1));
  }
}
