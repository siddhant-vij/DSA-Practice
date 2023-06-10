// Leetcode: 725. Split Linked List in Parts

package myPackage.j11LinkedList;

import java.util.Scanner;

public class SplitListInEqualParts {

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

  void printListArray(ListNode[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == null)
        System.out.println("null");
      else {
        ListNode cur = arr[i];
        while(cur != null) {
          System.out.print(cur.val + " ");
          cur = cur.next;
        }
        System.out.println();
      }
    }
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

  ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] result = new ListNode[k];
    int n = getSize(head);
    if (n == 0) {
      for (int i = 0; i < k; i++) {
        result[i] = null;
      }
      return result;
    }
    ListNode cur = head;
    ListNode next = head.next;
    if (k == n) {
      for (int i = 0; i < k; i++) {
        cur.next = null;
        result[i] = cur;
        cur = next;
        if (next != null)
          next = next.next;
      }
      return result;
    } else if (k > n) {
      for (int i = 0; i < n; i++) {
        cur.next = null;
        result[i] = cur;
        cur = next;
        if (next != null)
          next = next.next;
      }
      for (int i = 0; i < k - n; i++) {
        result[n + i] = null;
      }
      return result;
    } else {
      int x = n % k;
      for (int i = 0; i < x; i++) {
        int num = n / k;
        result[i] = cur;
        while (num-- > 0) {
          cur = cur.next;
          if (next != null)
            next = next.next;
        }
        cur.next = null;
        cur = next;
        if (next != null)
          next = next.next;
      }
      for (int i = 0; i < k - x; i++) {
        int num = n / k;
        result[x + i] = cur;
        while (num-- > 1) {
          cur = cur.next;
          if (next != null)
            next = next.next;
        }
        cur.next = null;
        cur = next;
        if (next != null)
          next = next.next;
      }
      return result;
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      SplitListInEqualParts obj1 = new SplitListInEqualParts();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int k = sc.nextInt();
      obj1.printListArray(obj1.splitListToParts(obj1.head, k));
    }
  }
}
