// Leetcode: 445. Add Two Numbers II

package myPackage.j11LinkedList;

import java.util.Scanner;

public class AdditionTwoNumbersReverse {

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

  ListNode reverseList(ListNode test) {
    if (test == null)
      return null;
    ListNode cur = test;
    ListNode temp = null;
    while (cur.next != null) {
      test = test.next;
      cur.next = temp;
      temp = cur;
      cur = test;
    }
    cur.next = temp;
    return test;
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

  void printList(ListNode test) {
    ListNode currNode = test;
    while (currNode != null) {
      System.out.print(currNode.val + " -> ");
      currNode = currNode.next;
    }
    System.out.println("null");
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    l1 = reverseList(l1);
    l2 = reverseList(l2);
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
    head = reverseList(head);
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      AdditionTwoNumbersReverse obj1 = new AdditionTwoNumbersReverse();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int m = sc.nextInt();
      AdditionTwoNumbersReverse obj2 = new AdditionTwoNumbersReverse();
      for (int i = 0; i < m; i++) {
        obj2.insertAtEnd(sc.nextInt());
      }

      AdditionTwoNumbersReverse obj3 = new AdditionTwoNumbersReverse();
      obj3.head = obj3.addTwoNumbers(obj1.head, obj2.head);
      obj3.printList(obj3.head);
    }
  }
  
}
