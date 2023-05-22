// Practice: Search for an element in LL

package myPackage.j11LinkedList;

import java.util.Scanner;

public class SearchElementInLL {

  static class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
    }
  }

  int positionOfElementRecursive(Node head, int element, int index) {
    if (head == null)
      return -1;
    if (head.val == element)
      return index;
    return positionOfElementRecursive(head.next, element, index + 1);
  }

  int positionOfElementIterative(Node head, int element) {
    if (head == null)
      return -1;
    Node cur = head;
    int index = 0;
    while (cur != null) {
      if (cur.val == element)
        return index;
      index++;
      cur = cur.next;
    }
    return -1;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Node head = null, tail = null;
      if (n != 0) {
        head = new Node(sc.nextInt());
        tail = head;
      }
      for (int i = 0; i < n - 1; i++) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
      }
      int element = sc.nextInt();
      SearchElementInLL obj = new SearchElementInLL();
      System.out.println(obj.positionOfElementIterative(head, element));
      System.out.println(obj.positionOfElementRecursive(head, element, 0));
    }
  }
}
