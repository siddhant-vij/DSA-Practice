// Leetcode: 21. Merge Two Sorted Lists

package myPackage.j11LinkedList;

import java.util.Scanner;

public class MergeSortedLists {

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

  ListNode mergeTwoListsExtraSpace(ListNode list1, ListNode list2) {
    ListNode ptr1 = list1;
    ListNode ptr2 = list2;
    while (ptr1 != null || ptr2 != null) {
      if (ptr1 == null && ptr2 != null) {
        insertAtEnd(ptr2.val);
        ptr2 = ptr2.next;
      } else if (ptr1 != null && ptr2 == null) {
        insertAtEnd(ptr1.val);
        ptr1 = ptr1.next;
      } else {
        if (ptr1.val < ptr2.val) {
          insertAtEnd(ptr1.val);
          ptr1 = ptr1.next;
        } else if (ptr1.val > ptr2.val) {
          insertAtEnd(ptr2.val);
          ptr2 = ptr2.next;
        } else {
          insertAtEnd(ptr2.val);
          ptr2 = ptr2.next;
          insertAtEnd(ptr1.val);
          ptr1 = ptr1.next;
        }
      }
    }
    return head;
  }

  ListNode mergeTwoListsNoExtraSpace(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;
    ListNode head = null, tail = null;
    ListNode ptr1 = list1, ptr2 = list2;
    if (ptr1.val <= ptr2.val) {
      head = tail = ptr1;
      ptr1 = ptr1.next;
    } else {
      head = tail = ptr2;
      ptr2 = ptr2.next;
    }
    while (ptr1 != null && ptr2 != null) {
      if (ptr1.val <= ptr2.val) {
        tail.next = ptr1;
        tail = tail.next;
        ptr1 = ptr1.next;
      } else {
        tail.next = ptr2;
        tail = tail.next;
        ptr2 = ptr2.next;
      }
    }
    if (ptr1 == null)
      tail.next = ptr2;
    else
      tail.next = ptr1;
    return head;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      MergeSortedLists obj1 = new MergeSortedLists();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int m = sc.nextInt();
      MergeSortedLists obj2 = new MergeSortedLists();
      for (int i = 0; i < m; i++) {
        obj2.insertAtEnd(sc.nextInt());
      }
      MergeSortedLists obj3 = new MergeSortedLists();
      obj3.printList(obj3.mergeTwoListsExtraSpace(obj1.head, obj2.head));
      obj3.printList(obj3.mergeTwoListsNoExtraSpace(obj1.head, obj2.head));
    }
  }
}
