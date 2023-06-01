// Practice: Reverse SLL

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReversalSLL {

  Node head;

  class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
    }
  }

  void addLast(int val) {
    Node newNode = new Node(val);

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

  void printList() {
    Node currNode = head;

    while (currNode != null) {
      System.out.print(currNode.val + " -> ");
      currNode = currNode.next;
    }

    System.out.println("null");
  }

  void reverseSLL() {
    if(head == null)
      return;
    Node cur = head;
    Node temp = null;
    while(cur.next != null) {
      head = head.next;
      cur.next = temp;
      temp = cur;
      cur = head;
    }
    cur.next = temp;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReversalSLL obj = new ReversalSLL();
      for (int i = 0; i < n; i++) {
        obj.addLast(sc.nextInt());
      }
      obj.printList();
      obj.reverseSLL();
      obj.printList();
    }
  }
}
