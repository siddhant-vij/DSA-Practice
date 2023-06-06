// Leetcode: 234. Palindrome Linked List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class PalindromeLinkedList {

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

  void reverseFromMiddle(ListNode head) {
    if (head == null)
      return;
    if (head.next == null)
      return;
    ListNode temp = middleNode(head);
    ListNode oneBefore = head;
    while (oneBefore.next != temp)
      oneBefore = oneBefore.next;
    ListNode cur = temp;
    ListNode prev = null;
    while (cur != null) {
      temp = temp.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }
    oneBefore.next = prev;
  }

  ListNode middleNode(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  boolean isPalindrome(ListNode head) {
    reverseFromMiddle(head);
    ListNode middle = middleNode(head);
    ListNode temp = middleNode(head);
    ListNode cur = head;
    while (cur != temp && middle != null) {
      if (cur.val != middle.val)
        return false;
      cur = cur.next;
      middle = middle.next;
    }
    return true;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      PalindromeLinkedList obj1 = new PalindromeLinkedList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(obj1.isPalindrome(obj1.head));
    }
  }
}
