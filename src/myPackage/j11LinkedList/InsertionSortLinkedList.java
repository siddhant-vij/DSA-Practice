// Leetcode: 147. Insertion Sort List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class InsertionSortLinkedList {

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

  ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode dummy = new ListNode(-1, head);
    ListNode cur = head.next;
    ListNode prev = head;
    ListNode next = head.next.next;
    while (cur != null) {
      if (cur.val < prev.val) {
        ListNode ptr = dummy.next;
        if (ptr.val >= cur.val) {
          prev.next = next;
          cur.next = ptr;
          dummy.next = cur;
        } else {
          while (ptr.next.val < cur.val)
            ptr = ptr.next;
          cur.next = ptr.next;
          ptr.next = cur;
          prev.next = next;
        }
      } else {
        prev = prev.next;
      }
      cur = next;
      if (next != null)
        next = next.next;
    }
    return dummy.next;
  }
  
  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      InsertionSortLinkedList obj1 = new InsertionSortLinkedList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.insertionSortList(obj1.head));
    }
  }
}
