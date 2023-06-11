// Leetcode: 143. Reorder List

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReorderList {

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

  int getSize(ListNode head) {
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
    cur.next = prev;
    return head;
  }

  ListNode middleNode(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  void reorderList(ListNode head) {
    int n = getSize(head);
    if (n == 0 || n == 1 || n == 2)
      return;
    ListNode middle = middleNode(head);
    if (n % 2 == 0) {
      ListNode lastNode = reverseList(middle);
      ListNode curF = head;
      ListNode nextF = head.next;
      ListNode curB = lastNode;
      ListNode nextB = lastNode.next;
      while (nextF != middle) {
        curF.next = curB;
        curB.next = nextF;
        curF = nextF;
        curB = nextB;
        nextF = nextF.next;
        nextB = nextB.next;
      }
      curF.next = curB;
      middle.next = null;
    } else {
      ListNode lastNode = reverseList(middle.next);
      ListNode curF = head;
      ListNode nextF = head.next;
      ListNode curB = lastNode;
      ListNode nextB = lastNode.next;
      while (nextF != middle) {
        curF.next = curB;
        curB.next = nextF;
        curF = nextF;
        curB = nextB;
        nextF = nextF.next;
        nextB = nextB.next;
      }
      curF.next = curB;
      curB.next = nextF;
      middle.next = null;
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReorderList obj1 = new ReorderList();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.reorderList(obj1.head);
      obj1.printList(obj1.head);
    }
  }  
}
