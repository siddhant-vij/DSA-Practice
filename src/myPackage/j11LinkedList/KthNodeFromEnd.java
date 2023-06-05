// Practice: Get Kth Node From End

package myPackage.j11LinkedList;

import java.util.Scanner;

public class KthNodeFromEnd {

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

  int getKthFromEndI(ListNode head, int k) {
    if (head == null)
      return -1;
    int n = getSize(head);
    if (n < k)
      return -1;
    int idx = n - k;
    ListNode cur = head;
    while (idx-- > 0)
      cur = cur.next;
    return cur.val;
  }

  int getKthFromEndII(ListNode head, int k) {
    if (head == null)
      return -1;
    ListNode cur = head;
    while (k-- > 0) {
      if (cur == null)
        return -1;
      cur = cur.next;
    }
    ListNode res = head;
    while (cur != null) {
      res = res.next;
      cur = cur.next;
    }
    return res.val;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      KthNodeFromEnd obj1 = new KthNodeFromEnd();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int k = sc.nextInt();
      System.out.println(obj1.getKthFromEndI(obj1.head, k));
      System.out.println(obj1.getKthFromEndII(obj1.head, k));
    }
  }
}
