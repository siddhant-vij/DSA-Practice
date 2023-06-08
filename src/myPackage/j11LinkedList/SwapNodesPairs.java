// Leetcode: 24. Swap Nodes in Pairs

package myPackage.j11LinkedList;

import java.util.Scanner;

public class SwapNodesPairs {

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

  ListNode swapPairs(ListNode head) {
    if (head == null)
      return null;
    if (head.next == null)
      return head;
    ListNode dummy = null;
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = cur.next;
    while (next != null) {
      dummy = next.next;
      if (prev == null)
        head = head.next;
      else
        prev.next = next;
      next.next = cur;
      cur.next = dummy;
      prev = cur;
      cur = cur.next;
      if (cur == null)
        break;
      else
        next = cur.next;
    }
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      SwapNodesPairs obj1 = new SwapNodesPairs();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.printList(obj1.swapPairs(obj1.head));
    }
  }
}
