package myPackage.j11LinkedList;

import java.util.Scanner;

public class Ref_TraversalPrintDLL {

  static class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
      this.val = val;
    }
  }

  private void printListBackward(Node head) {
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

  private void printListForward(Node head) {
    Node curNode = head;
    while (curNode != null) {
      System.out.print(curNode.val + " <--> ");
      curNode = curNode.next;
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
        tail.next.prev = tail;
        tail = tail.next;
      }
      Ref_TraversalPrintDLL obj = new Ref_TraversalPrintDLL();
      obj.printListForward(head);
      obj.printListBackward(head);
    }
  }
}
