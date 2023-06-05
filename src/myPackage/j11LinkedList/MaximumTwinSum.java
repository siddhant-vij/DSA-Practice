// Leetcode: 2130. Maximum Twin Sum of a Linked List

package myPackage.j11LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumTwinSum {

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

  int pairSumI(ListNode head) {
    int n = getSize(head);
    Map<Integer, Integer> map = new HashMap<>();
    ListNode cur = head;
    int idx = 0;
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    while (cur != null) {
      if (map.containsKey(n - 1 - idx)) {
        sum = cur.val + map.get(n - 1 - idx);
      } else {
        map.put(idx, cur.val);
      }
      maxSum = Math.max(maxSum, sum);
      idx++;
      cur = cur.next;
    }
    return maxSum;
  }

  ListNode getMiddleElement(ListNode head) {
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

  void reverseListFromMiddle(ListNode head) {
    ListNode oneBefore = head;
    ListNode middle = getMiddleElement(head);
    while(oneBefore.next != middle)
      oneBefore = oneBefore.next;
    ListNode prev = null;
    ListNode cur = middle;
    ListNode temp = middle;
    while(cur != null) {
      temp = temp.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }
    oneBefore.next = prev;
  }

  int pairSumII(ListNode head) {
    int maxSum = Integer.MIN_VALUE;
    reverseListFromMiddle(head);
    ListNode middle = getMiddleElement(head);
    ListNode ptr1 = head;
    ListNode ptr2 = middle;
    while(ptr2 != null) {
      maxSum = Math.max(maxSum, ptr1.val + ptr2.val);
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return maxSum;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      MaximumTwinSum obj1 = new MaximumTwinSum();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(obj1.pairSumI(obj1.head));
      System.out.println(obj1.pairSumII(obj1.head));
    }
  }
}
