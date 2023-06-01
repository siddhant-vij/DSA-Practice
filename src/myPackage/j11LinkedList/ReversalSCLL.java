// Practice: Reverse SCLL

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReversalSCLL {

  Node tail;

  class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
    }
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

  void reverseSCLL() {
    if (tail == null)
      return;
    Node head = tail.next;
    Node cur = head;
    Node temp = tail;
    do {
      tail = cur.next;
      cur.next = temp;
      temp = cur;
      cur = tail;
    } while (cur != head);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReversalSCLL obj = new ReversalSCLL();
      for (int i = 0; i < n; i++) {
        obj.addAtLast(sc.nextInt());
      }
      obj.printList();
      obj.reverseSCLL();
      obj.printList();
    }
  }
}
