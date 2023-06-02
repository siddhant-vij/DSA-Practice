// Leetcode: 2. Add Two Numbers

package myPackage.j11LinkedList;

import java.util.Scanner;

public class AdditionTwoNumbers {

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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    int carry = 0;
    while (cur1 != null || cur2 != null) {
      if (cur1 == null && cur2 != null) {
        int sum = cur2.val + carry;
        if (sum >= 0 && sum <= 9) {
          insertAtEnd(sum);
          carry = 0;
        } else {
          carry = sum / 10;
          sum %= 10;
          insertAtEnd(sum);
        }
        cur2 = cur2.next;
      } else if (cur1 != null && cur2 == null) {
        int sum = cur1.val + carry;
        if (sum >= 0 && sum <= 9) {
          insertAtEnd(sum);
          carry = 0;
        } else {
          carry = sum / 10;
          sum %= 10;
          insertAtEnd(sum);
        }
        cur1 = cur1.next;
      } else {
        int sum = cur1.val + cur2.val + carry;
        if (sum >= 0 && sum <= 9) {
          insertAtEnd(sum);
          carry = 0;
        } else {
          carry = sum / 10;
          sum %= 10;
          insertAtEnd(sum);
        }
        cur1 = cur1.next;
        cur2 = cur2.next;
      }
    }
    if (carry != 0) {
      insertAtEnd(carry);
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
      AdditionTwoNumbers obj1 = new AdditionTwoNumbers();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int m = sc.nextInt();
      AdditionTwoNumbers obj2 = new AdditionTwoNumbers();
      for (int i = 0; i < m; i++) {
        obj2.insertAtEnd(sc.nextInt());
      }

      AdditionTwoNumbers obj3 = new AdditionTwoNumbers();
      obj3.head = obj3.addTwoNumbers(obj1.head, obj2.head);
      obj3.printList(obj3.head);
    }
  }
}
