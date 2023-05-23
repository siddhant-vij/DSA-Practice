// Practice: Reversal DLL

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReversalDLL {

  Node head;

  class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
      this.val = val;
    }
  }

  private void addFirst(int val) {
    Node newNode = new Node(val);
    newNode.next = head;
    if (head != null)
      head.prev = newNode;
    head = newNode;
  }

  private void addLast(int val) {
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

  private void printListForward(Node head) {
    Node curNode = head;
    System.out.print("null <--> ");
    while (curNode != null) {
      System.out.print(curNode.val + " <--> ");
      curNode = curNode.next;
    }
    System.out.println("null");
  }

  private void reverseDLL() {
    if (head == null || head.next == null)
      return;
    Node curNode = head;
    Node temp = null;
    while (curNode != null) {
      temp = curNode.prev;
      curNode.prev = curNode.next;
      curNode.next = temp;
      curNode = curNode.prev;
    }
    head = temp.prev;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReversalDLL obj = new ReversalDLL();
      for (int i = 0; i < n; i++) {
        obj.addLast(sc.nextInt());
      }
      obj.printListForward(obj.head);
      obj.reverseDLL();
      obj.printListForward(obj.head);
    }
  }
}
