// Coding Ninjas: Sort linked list of 0s 1s 2s

package myPackage.j11LinkedList;

import java.util.Scanner;

public class Sort012List {

  Node head;
  Node tail;

  public class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }

  void insertAtEmpty(int val) {
    Node newNode = new Node(val);
    head = newNode;
    tail = head;
  }

  void insertAtEnd(int val) {
    if (tail == null) {
      insertAtEmpty(val);
      return;
    }
    Node newNode = new Node(val);
    tail.next = newNode;
    tail = newNode;
  }

  void printList(Node head) {
    Node currNode = head;
    while (currNode != null) {
      System.out.print(currNode.val + " -> ");
      currNode = currNode.next;
    }
    System.out.println("null");
  }

  Node sortList(Node head) {
    Node zero = null;
    Node zeroHead = null;
    Node one = null;
    Node oneHead = null;
    Node two = null;
    Node twoHead = null;
    Node cur = head;
    while (cur != null) {
      if (zeroHead == null && cur.val == 0) {
        zeroHead = cur;
        zero = cur;
      } else if (oneHead == null && cur.val == 1) {
        oneHead = cur;
        one = cur;
      } else if (twoHead == null && cur.val == 2) {
        twoHead = cur;
        two = cur;
      } else if (cur.val == 0) {
        zero.next = cur;
        zero = cur;
      } else if (cur.val == 1) {
        one.next = cur;
        one = cur;
      } else if (cur.val == 2) {
        two.next = cur;
        two = cur;
      }
      cur = cur.next;
    }
    if (zero != null)
      zero.next = oneHead;
    if (one != null)
      one.next = twoHead;
    if (two != null)
      two.next = null;
    if (zeroHead != null)
      return zeroHead;
    else {
      if (oneHead != null)
        return oneHead;
      else {
        if (twoHead != null)
          return twoHead;
        else
          return null;
      }
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Sort012List obj1 = new Sort012List();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.printList(obj1.sortList(obj1.head));
    }
  }
}
