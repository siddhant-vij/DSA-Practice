// Leetcode: 25. Reverse Nodes in k-Group

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReverseNodesKGroups {

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

  ListNode reverse(ListNode begin, ListNode end) {
    ListNode cur = begin.next;
    ListNode next, first;
    ListNode prev = begin;
    first = cur;
    while (cur != end) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    begin.next = prev;
    first.next = cur;
    return first;
  }

  ListNode reverseKGroup(ListNode head, int k) {
    ListNode begin;
    if (head == null || head.next == null || k == 1)
      return head;
    ListNode dummyhead = new ListNode(-1);
    dummyhead.next = head;
    begin = dummyhead;
    int i = 0;
    while (head != null) {
      i++;
      if (i % k == 0) {
        begin = reverse(begin, head.next);
        head = begin.next;
      } else {
        head = head.next;
      }
    }
    return dummyhead.next;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReverseNodesKGroups obj1 = new ReverseNodesKGroups();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int k = sc.nextInt();
      obj1.printList(obj1.reverseKGroup(obj1.head, k));
    }
  }  
}
