// Leetcode: 2074. Reverse Nodes in Even Length Groups

package myPackage.j11LinkedList;

import java.util.Scanner;

public class ReverseEvenLengthGroups {

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
    ListNode currNode = head;
    int size = 0;
    while (currNode != null) {
      size++;
      currNode = currNode.next;
    }
    return size;
  }

  ListNode reverseEvenLengthGroups(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
      return head;
    ListNode cur = head.next;
    ListNode temp1 = cur;
    ListNode prev = head;
    ListNode temp2 = head;
    ListNode next = cur.next;
    int n = getSize(head);
    int k = 2, rem = n - (k - 1);
    while (rem - k >= 0) {
      if (k % 2 != 0) {
        int index = k;
        while (index-- > 0) {
          cur = cur.next;
          temp1 = temp1.next;
          prev = prev.next;
          temp2 = temp2.next;
          if (next != null)
            next = next.next;
          else
            break;
        }
        rem = rem - k;
        k++;
      } else {
        int index = k - 1;
        while (index-- > 0) {
          if (next != null)
            next = next.next;
          else
            break;
        }
        temp1 = temp1.next;
        cur.next = next;
        temp2 = cur;
        cur = temp1;
        while (cur != next) {
          if (temp1.next == next)
            prev.next = temp1;
          temp1 = temp1.next;
          cur.next = temp2;
          temp2 = cur;
          cur = temp1;
        }
        int loop = k;
        while (loop-- > 0)
          prev = prev.next;
        rem = rem - k;
        k++;
        if (next != null)
          next = next.next;
        else
          break;
      }
    }
    if (rem != 0 && rem % 2 == 0) {
      cur = head.next;
      temp1 = cur;
      prev = head;
      temp2 = head;
      next = cur.next;
      k = 2;
      rem = n - (k - 1);
      while (rem - k >= 0) {
        rem = rem - k;
        k++;
        int index = k - 1;
        while (index-- > 0) {
          cur = cur.next;
          temp1 = temp1.next;
          prev = prev.next;
          temp2 = temp2.next;
          if (next != null)
            next = next.next;
          else
            break;
        }
      }
      while (next != null) {
        next = next.next;
      }
      temp1 = temp1.next;
      cur.next = next;
      temp2 = cur;
      cur = temp1;
      while (cur != next) {
        if (temp1.next == next)
          prev.next = temp1;
        temp1 = temp1.next;
        cur.next = temp2;
        temp2 = cur;
        cur = temp1;
      }
    }
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ReverseEvenLengthGroups obj1 = new ReverseEvenLengthGroups();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      obj1.printList(obj1.head);
      obj1.printList(obj1.reverseEvenLengthGroups(obj1.head));
    }
  }
}
