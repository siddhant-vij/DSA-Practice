package myPackage.j11LinkedList;

import java.util.Scanner;

public class Ref_TraversalPrintSCLL {

  static Node tail;

  static class Node {
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

  void functionPrinting(Node x) {
    if (x == tail.next)
      return;
    functionPrinting(x.next);
    System.out.print(x.val + " <-- ");
  }

  void printListReverse() {
    System.out.print("HEAD <-- ");
    functionPrinting(tail.next.next);
    System.out.print(tail.next.val);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      tail = null;
      Node head = null;
      if (n != 0) {
        tail = new Node(sc.nextInt());
        head = tail;
      }
      for (int i = 0; i < n - 1; i++) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
        if (i == n - 2)
          tail.next = head;
      }
      if (n == 1)
        tail.next = head;
      Ref_TraversalPrintSCLL obj = new Ref_TraversalPrintSCLL();
      obj.printList();
      obj.printListReverse();
    }
  }
}
