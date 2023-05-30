package myPackage.j11LinkedList;

import java.util.Scanner;

public class Ref_TraversalPrintDCLL {

  static Node head;
  static Node tail;

  static class Node {
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

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      tail = null;
      head = null;
      if (n != 0) {
        tail = new Node(sc.nextInt());
        head = tail;
        tail.next = tail;
        head.prev = head;
      }
      for (int i = 0; i < n - 1; i++) {
        tail.next = new Node(sc.nextInt());
        tail.next.prev = tail;
        tail = tail.next;
        if (i == n - 2)
          tail.next = head;
      }
      if (n == 1)
        tail.next = head;
      Ref_TraversalPrintDCLL obj = new Ref_TraversalPrintDCLL();
      obj.printList();
      obj.printListReverse();
    }
  }

}
