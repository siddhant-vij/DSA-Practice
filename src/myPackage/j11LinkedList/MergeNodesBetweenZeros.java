// Leetcode: 2181. Merge Nodes in Between Zeros

package myPackage.j11LinkedList;

import java.util.Scanner;

public class MergeNodesBetweenZeros {

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

  ListNode mergeNodes(ListNode head) {
    head = head.next;
    ListNode cur = head;
    ListNode temp = head;
    while (cur != null) {
      int sum = 0;
      while (cur.val != 0) {
        sum += cur.val;
        cur = cur.next;
      }
      temp.val = sum;
      temp.next = cur.next;
      temp = temp.next;
      cur = temp;
    }
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      MergeNodesBetweenZeros obj1 = new MergeNodesBetweenZeros();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.printList(obj1.mergeNodes(obj1.head));
    }
  }  
}
