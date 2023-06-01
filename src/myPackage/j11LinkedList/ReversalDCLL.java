// Practice: Reverse DCLL

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReversalDCLL {

  Node head;
  Node tail;

  class Node {
    int val;
    Node next;
    Node prev;

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

  void reverseDCLL() {
    if(tail == null)
      return;
    Node cur = head;
    Node temp = tail;
    do {
      temp = cur.prev;
      cur.prev = cur.next;
      cur.next = temp;
      cur = cur.prev;
    } while (cur != head);
    tail = tail.prev;
    head = head.next;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReversalDCLL obj = new ReversalDCLL();
      for (int i = 0; i < n; i++) {
        obj.addToEnd(sc.nextInt());
      }
      obj.printList();
      obj.reverseDCLL();
      obj.printList();
    }
  }
  
}
