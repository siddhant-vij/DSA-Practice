// Leetcode: 817. Linked List Components

package myPackage.j11LinkedList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListComponents {

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

  int numComponents(ListNode head, int[] arr) {
    Set<Integer> setG = new HashSet<>();
    for (int i : arr)
      setG.add(i);
    int res = 0;
    while (head != null) {
      if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val)))
        res++;
      head = head.next;
    }
    return res;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ListComponents obj1 = new ListComponents();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      int m = sc.nextInt();
      int[] arr = new int[m];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(obj1.numComponents(obj1.head, arr));
    }
  }  
}
