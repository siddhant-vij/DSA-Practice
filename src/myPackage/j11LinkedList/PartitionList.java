// Leetcode: 86. Partition List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class PartitionList {

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

  ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;
    ListNode cur = head;
    ListNode lx = null;
    ListNode gex = null;
    ListNode hgex = null;
    while (cur != null) {
      if (lx == null && cur.val < x) {
        lx = cur;
        head = cur;
      } else if (gex == null && cur.val >= x) {
        gex = cur;
        hgex = cur;
      } else if (cur.val < x) {
        lx.next = cur;
        lx = cur;
      } else {
        gex.next = cur;
        gex = cur;
      }
      cur = cur.next;
    }
    if (lx != null)
      lx.next = hgex;
    if (gex != null)
      gex.next = null;
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      PartitionList obj1 = new PartitionList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int x = sc.nextInt();
      obj1.printList(obj1.head);
      obj1.printList(obj1.partition(obj1.head, x));
    }
  }
}
