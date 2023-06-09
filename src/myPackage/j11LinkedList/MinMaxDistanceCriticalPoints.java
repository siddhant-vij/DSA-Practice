// Leetcode: 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

package myPackage.j11LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinMaxDistanceCriticalPoints {

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

  public int[] nodesBetweenCriticalPoints(ListNode head) {
    if (head == null || head.next == null || head.next.next == null || head.next.next.next == null)
      return new int[] { -1, -1 };
    ListNode cur = head;
    int index = 1;
    List<Integer> list = new ArrayList<>();
    while (cur.next.next != null) {
      if ((cur.val < cur.next.val && cur.next.val > cur.next.next.val)
          || (cur.val > cur.next.val && cur.next.val < cur.next.next.val)) {
        list.add(index);
      }
      index++;
      cur = cur.next;
    }
    if (list.size() < 2)
      return new int[] { -1, -1 };
    else {
      int min = Integer.MAX_VALUE;
      int max = list.get(list.size() - 1) - list.get(0);
      for (int i = 0; i < list.size() - 1; i++)
        min = Math.min(min, list.get(i + 1) - list.get(i));
      return new int[] { min, max };
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      MinMaxDistanceCriticalPoints obj1 = new MinMaxDistanceCriticalPoints();
      for (int i = 0; i < n; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(Arrays.toString(obj1.nodesBetweenCriticalPoints(obj1.head)));
    }
  }
}
