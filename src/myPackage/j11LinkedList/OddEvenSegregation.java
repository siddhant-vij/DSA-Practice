// Leetcode: 328. Odd Even Linked List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class OddEvenSegregation {

  ListNode head;
  ListNode tail;

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  void insertAtEmpty(int val) {
    ListNode newNode = new ListNode(val);
    head = newNode;
    tail = head;
  }

  void insertAtEnd(int val) {
    if (tail == null) {
      insertAtEmpty(val);
      return;
    }
    ListNode newNode = new ListNode(val);
    tail.next = newNode;
    tail = newNode;
  }

  void printList(ListNode head) {
    ListNode currNode = head;
    while (currNode != null) {
      System.out.print(currNode.val + " -> ");
      currNode = currNode.next;
    }
    System.out.println("null");
  }

  ListNode oddEvenList(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    if (head.next.next == null)
      return head;
    ListNode headOdd = head.next;
    ListNode curEven = head;
    ListNode curOdd = headOdd;
    while (curEven != null && curOdd != null) {
      curEven.next = curOdd.next;
      curEven = curEven.next;
      curOdd.next = curEven.next;
      curOdd = curOdd.next;
      if (curEven == null || curOdd == null || curOdd.next == null) {
        curEven.next = headOdd;
        break;
      }
    }
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      OddEvenSegregation obj1 = new OddEvenSegregation();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.printList(obj1.oddEvenList(obj1.head));
    }
  }
}
