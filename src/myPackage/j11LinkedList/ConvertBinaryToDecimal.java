// Leetcode: 1290. Convert Binary Number in a Linked List to Integer

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ConvertBinaryToDecimal {

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

  static int getSize(ListNode head) {
    ListNode cur = head;
    int size = 0;
    while (cur != null) {
      size++;
      cur = cur.next;
    }
    return size;
  }

  public int getDecimalValue(ListNode head) {
    int n = getSize(head) - 1;
    ListNode cur = head;
    int result = 0;
    while (n >= 0) {
      result += (1 << n) * cur.val;
      cur = cur.next;
      n--;
    }
    return result;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ConvertBinaryToDecimal obj1 = new ConvertBinaryToDecimal();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(obj1.getDecimalValue(obj1.head));
    }
  }
}
