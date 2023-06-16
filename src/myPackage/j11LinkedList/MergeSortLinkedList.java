// Leetcode: 148. Sort List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class MergeSortLinkedList {

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

  ListNode getMiddleNode(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode cur = slow.next;
    slow.next = null;
    return cur;
  }

  ListNode merge(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;
    ListNode ptr1 = list1;
    ListNode ptr2 = list2;
    ListNode head = null;
    ListNode tail = null;
    if (ptr1.val <= ptr2.val) {
      head = tail = ptr1;
      ptr1 = ptr1.next;
    } else {
      head = tail = ptr2;
      ptr2 = ptr2.next;
    }
    while (ptr1 != null && ptr2 != null) {
      if (ptr1.val <= ptr2.val) {
        tail.next = ptr1;
        tail = tail.next;
        ptr1 = ptr1.next;
      } else {
        tail.next = ptr2;
        tail = tail.next;
        ptr2 = ptr2.next;
      }
    }
    if (ptr1 == null)
      tail.next = ptr2;
    else
      tail.next = ptr1;
    return head;
  }

  ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode mid = getMiddleNode(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge(left, right);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      MergeSortLinkedList obj1 = new MergeSortLinkedList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.sortList(obj1.head));
    }
  }  
}
