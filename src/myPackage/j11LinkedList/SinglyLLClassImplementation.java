package myPackage.j11LinkedList;

class SinglyLLClassImplementation {
  Node head;
  private int size;

  SinglyLLClassImplementation() {
    size = 0;
  }

  public class Node {
    String data;
    Node next;

    Node(String data) {
      this.data = data;
      this.next = null;
      size++;
    }
  }

  public void addFirst(String data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public void addLast(String data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      return;
    }

    Node lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }

    lastNode.next = newNode;
  }

  public void addAtIndex(int idx, String data) {
    Node newNode = new Node(data);

    if (head == null) {
      System.out.println("Inserting at first index as LL is empty");
      head = newNode;
      return;
    }

    if (idx <= 0)
      addFirst(data);
    else if (idx >= size - 1)
      addLast(data);
    else {
      Node curNode = head;
      while (idx-- > 1)
        curNode = curNode.next;

      newNode.next = curNode.next;
      curNode.next = newNode;
    }
  }

  public void removeFirst() {
    if (head == null) {
      System.out.println("Empty List, nothing to delete");
      return;
    }

    head = this.head.next;
    size--;
  }

  public void removeLast() {
    if (head == null) {
      System.out.println("Empty List, nothing to delete");
      return;
    }

    size--;
    if (head.next == null) {
      head = null;
      return;
    }

    Node curNode = head;
    while (curNode.next.next != null) {
      curNode = curNode.next;
    }

    curNode.next = null;
  }

  public void removeFromIndex(int idx) {
    if (head == null) {
      System.out.println("Empty List, nothing to delete");
      return;
    }

    size--;
    if (head.next == null) {
      System.out.println("Only one element in the list - so removing that.");
      head = null;
      return;
    }

    if (idx <= 0)
      removeFirst();
    else if (idx >= size - 1)
      removeLast();
    else {
      Node curNode = head;
      while (idx-- > 1 && curNode.next.next != null) {
        curNode = curNode.next;
      }

      curNode.next = curNode.next.next;
    }
  }

  public int getElement(String data) {
    if(head == null)
    {
      System.out.println("Empty list - Element can't be present");
      return -1;
    }
    Node curNode = head;
    int index = 0;
    while(curNode != null)
    {
      if(curNode.data.equals(data))
        return index;
      index++;
      curNode = curNode.next;
    }
    return -1;
  }

  public int getSize() {
    return size;
  }

  public void printList() {
    Node currNode = head;

    while (currNode != null) {
      System.out.print(currNode.data + " -> ");
      currNode = currNode.next;
    }

    System.out.println("null");
  }

  public static void main(String args[]) {
    SinglyLLClassImplementation list = new SinglyLLClassImplementation();
    list.addLast("is");
    list.addLast("a");
    list.addLast("list");
    list.printList();

    list.addFirst("this");
    list.printList();
    System.out.println(list.getSize());

    list.addAtIndex(3, "linked");
    list.printList();
    System.out.println(list.getSize());

    System.out.println(list.getElement("linked"));

    list.removeFirst();
    list.printList();

    list.removeLast();
    list.printList();

    list.removeFromIndex(2);
    list.printList();
  }
}
