// Practice: Inserting a new node in SLL (Sorted)

package myPackage.j11LinkedList;

import java.util.Scanner;

public class InsertionSortedSLL {

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

  void addToEmpty(int val) {
    Node newNode = new Node(val);
    head = newNode;
  }

  void addAtFirst(int val) {
    Node newNode = new Node(val);
    newNode.next = head;
    head = newNode;
  }

  void addAtLast(int val, Node cur) {
    Node newNode = new Node(val);
    cur.next = newNode;
  }

  void insertNode(int val) {
    if (head == null) {
      addToEmpty(val);
      return;
    }
    if (head.val >= val) {
      addAtFirst(val);
      return;
    }
    Node newNode = new Node(val);
    Node cur = head;
    while (cur.next != null && !(cur.val < val && cur.next.val >= val)) {
      cur = cur.next;
    }
    if (cur.next == null && cur.val < val) {
      addAtLast(val, cur);
      return;
    }
    newNode.next = cur.next;
    cur.next = newNode;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      InsertionSortedSLL obj = new InsertionSortedSLL();
      for (int i = 0; i < n; i++) {
        obj.addLast(sc.nextInt());
      }
      int x = sc.nextInt();
      obj.printList();
      obj.insertNode(x);
      obj.printList();
    }
  }
}
