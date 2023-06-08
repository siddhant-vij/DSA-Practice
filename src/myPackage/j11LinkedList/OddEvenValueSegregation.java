// GfG Practice: Segregate even and odd nodes in a Link List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class OddEvenValueSegregation {

  Node head;
  Node tail;

  public class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
      this.data = data;
    }

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  void insertAtEmpty(int data) {
    Node newNode = new Node(data);
    head = newNode;
    tail = head;
  }

  void insertAtEnd(int data) {
    if (tail == null) {
      insertAtEmpty(data);
      return;
    }
    Node newNode = new Node(data);
    tail.next = newNode;
    tail = newNode;
  }

  void printList(Node head) {
    Node currNode = head;
    while (currNode != null) {
      System.out.print(currNode.data + " -> ");
      currNode = currNode.next;
    }
    System.out.println("null");
  }

  Node oddEvenListDivide(Node head) {
    if(head == null)
      return null;
    if(head.next == null)
      return head;
    Node cur = head;
    Node headEven = null, headOdd = null;
    Node curEven = null, curOdd = null;
    while (cur != null) {
      if (headEven == null && (cur.data % 2) == 0) {
        headEven = cur;
        curEven = cur;
      } else if (headOdd == null && (cur.data % 2) != 0) {
        headOdd = cur;
        curOdd = cur;
      } else if ((cur.data % 2) == 0) {
        curEven.next = cur;
        curEven = cur;
      } else if ((cur.data % 2) != 0) {
        curOdd.next = cur;
        curOdd = cur;
      }
      cur = cur.next;
    }
    if(headEven == null || headOdd == null)
      return head;
    head = headEven;
    curEven.next = headOdd;
    curOdd.next = null;
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      OddEvenValueSegregation obj1 = new OddEvenValueSegregation();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.printList(obj1.oddEvenListDivide(obj1.head));
    }
  }
  
}
