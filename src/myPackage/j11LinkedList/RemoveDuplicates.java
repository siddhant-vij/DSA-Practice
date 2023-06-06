// Practice: Remove duplicates from a sorted Singly Linked List
// Leetcode: 83. Remove Duplicates from Sorted List
// Leetcode: 82. Remove Duplicates from Sorted List II

package myPackage.j11LinkedList;

import java.util.Scanner;

public class RemoveDuplicates {

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

  ListNode deleteDuplicatesI(ListNode head) {
    if (head == null)
      return null;
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val)
        cur.next = cur.next.next;
      else
        cur = cur.next;
    }
    return head;
  }

  ListNode deleteDuplicatesII(ListNode head) {
    ListNode temp = new ListNode(0, head);
    ListNode pred = temp;
    while (head != null) {
      if (head.next != null && head.val == head.next.val) {
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        pred.next = head.next;
      } else {
        pred = pred.next;
      }
      head = head.next;
    }
    return temp.next;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      RemoveDuplicates obj1 = new RemoveDuplicates();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.deleteDuplicatesI(obj1.head));

      n = sc.nextInt();
      RemoveDuplicates obj2 = new RemoveDuplicates();
      for (int i = 0; i < n; i++) {
        obj2.insertAtEnd(sc.nextInt());
      }
      obj2.printList(obj2.deleteDuplicatesII(obj2.head));
    }
  }
}
