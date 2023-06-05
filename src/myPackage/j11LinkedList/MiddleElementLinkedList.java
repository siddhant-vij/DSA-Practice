// Leetcode: 876. Middle of the Linked List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class MiddleElementLinkedList {

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

  int getSize(ListNode head) {
    ListNode cur = head;
    int size = 0;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    return size;
  }

  int getMiddleElementEfficient(ListNode head) {
    if (head == null)
      return -1;
    if (head.next == null)
      return head.val;
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.val;
  }

  int getMiddleElementNaive(ListNode head) {
    if(head == null)
      return -1;
    if(head.next == null)
      return head.val;
    int size = getSize(head);
    int index = size/2;
    ListNode cur = head;
    while(index-- > 0)
      cur = cur.next;
    return cur.val;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      MiddleElementLinkedList obj1 = new MiddleElementLinkedList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(obj1.getMiddleElementNaive(obj1.head));
      System.out.println(obj1.getMiddleElementEfficient(obj1.head));
    }
  } 
}
