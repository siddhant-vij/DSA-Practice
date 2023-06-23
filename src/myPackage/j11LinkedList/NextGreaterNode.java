// Leetcode: 1019. Next Greater Node In Linked List

package myPackage.j11LinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class NextGreaterNode {

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

  void reverseArray(int[] arr) {
    int s = 0;
    int n = arr.length;
    int e = n - 1;
    while (s < e) {
      int temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }

  int size(ListNode head) {
    int size = 0;
    ListNode cur = head;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    return size;
  }

  ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode cur = head;
    ListNode prev = null;
    while (head.next != null) {
      head = head.next;
      cur.next = prev;
      prev = cur;
      cur = head;
    }
    head.next = prev;
    return head;
  }

  int[] nextLargerNodes(ListNode head) {
    Deque<Integer> stack = new ArrayDeque<>();
    head = reverseList(head);
    int n = size(head);
    int[] result = new int[n];
    result[0] = 0;
    stack.push(head.val);
    ListNode cur = head.next;
    int idx = 1;
    while (cur != null) {
      while (!stack.isEmpty() && stack.peek() <= cur.val) {
        stack.pop();
      }
      if (stack.isEmpty())
        result[idx++] = 0;
      else
        result[idx++] = stack.peek();
      stack.push(cur.val);
      cur = cur.next;
    }
    reverseArray(result);
    return result;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      NextGreaterNode obj1 = new NextGreaterNode();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(Arrays.toString((obj1.nextLargerNodes(obj1.head))));
    }
  }
}
