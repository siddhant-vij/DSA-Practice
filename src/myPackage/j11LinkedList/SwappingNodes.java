// Leetcode: 1721. Swapping Nodes in a Linked List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class SwappingNodes {

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

  ListNode swapNodes(ListNode head, int k) {
    ListNode kStart = head;
    while (k-- > 1) {
      kStart = kStart.next;
    }
    int temp = kStart.val;
    ListNode cur = kStart;
    kStart = kStart.next;
    ListNode kEnd = head;
    while (kStart != null) {
      kStart = kStart.next;
      kEnd = kEnd.next;
    }
    cur.val = kEnd.val;
    kEnd.val = temp;
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      SwappingNodes obj1 = new SwappingNodes();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int k = sc.nextInt();
      obj1.printList(obj1.swapNodes(obj1.head, k));
    }
  }  
}
