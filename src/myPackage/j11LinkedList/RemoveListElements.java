// Leetcode: 203. Remove Linked List Elements

package myPackage.j11LinkedList;

import java.util.Scanner;

public class RemoveListElements {

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

  ListNode removeElements(ListNode head, int val) {
    if (head == null)
      return null;
    ListNode cur = head;
    while (head != null && head.val == val)
      head = head.next;
    while (cur.next != null) {
      if (cur.next.val == val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

  void printList(ListNode head) {
    ListNode currNode = head;
    while (currNode != null) {
      System.out.print(currNode.val + " -> ");
      currNode = currNode.next;
    }
    System.out.println("null");
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      RemoveListElements obj1 = new RemoveListElements();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int val = sc.nextInt();
      obj1.printList(obj1.removeElements(obj1.head, val));
    }
  }
}
