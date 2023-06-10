// Leetcode: 61. Rotate List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class RotateList {

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

  int getSize(ListNode head) {
    int size = 0;
    ListNode cur = head;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    return size;
  }

  ListNode rotateRight(ListNode head, int k) {
    int n = getSize(head);
    if (n == 0)
      return null;
    if (k % n == 0)
      return head;
    int x = n - k % n;
    ListNode cur = head;
    while (x-- > 1)
      cur = cur.next;
    ListNode newHead = cur.next;
    cur.next = null;
    cur = newHead;
    while (cur.next != null)
      cur = cur.next;
    cur.next = head;
    return newHead;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      RotateList obj1 = new RotateList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int k = sc.nextInt();
      obj1.printList(obj1.head);
      obj1.printList(obj1.rotateRight(obj1.head, k));
    }
  }  
}
