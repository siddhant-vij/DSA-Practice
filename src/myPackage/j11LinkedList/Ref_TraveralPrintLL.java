// Practice: LL Printing - Iterative & Recursive

package myPackage.j11LinkedList;

import java.util.Scanner;

public class Ref_TraveralPrintLL {

  static class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
    }
  }

  void printListRecursive(Node head) {
    if (head == null) {
      System.out.println("null");
      return;
    }
    System.out.print(head.val + " --> ");
    printListRecursive(head.next);
  }

  void printListIterative(Node head) {
    Node cur = head;
    while (cur != null) {
      System.out.print(cur.val + " --> ");
      cur = cur.next;
    }
    System.out.println("null");
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Node head = null, tail = null;
      if (n != 0) {
        head = new Node(sc.nextInt());
        tail = head;
      }
      for (int i = 0; i < n - 1; i++) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
      }
      Ref_TraveralPrintLL obj = new Ref_TraveralPrintLL();
      obj.printListIterative(head);
      obj.printListRecursive(head);
    }
  }
}
