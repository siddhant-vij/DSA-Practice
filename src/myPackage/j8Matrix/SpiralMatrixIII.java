// Leetcode: 2326. Spiral Matrix IV

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrixIII {

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

  public int[][] spiralMatrix(int m, int n, ListNode head) {
    int[][] mat = new int[m][n];
    int left = 0;
    int top = 0;
    int right = n - 1;
    int bottom = m - 1;
    ListNode cur = head;
    int num = 1;
    while (num <= n * m) {
      for (int col = left; num <= n * m && col <= right; col++) {
        if (cur != null) {
          mat[top][col] = cur.val;
          cur = cur.next;
        } else {
          mat[top][col] = -1;
        }
        num++;
      }
      top++;
      for (int row = top; num <= n * m && row <= bottom; row++) {
        if (cur != null) {
          mat[row][right] = cur.val;
          cur = cur.next;
        } else {
          mat[row][right] = -1;
        }
        num++;
      }
      right--;
      for (int col = right; num <= n * m && col >= left; col--) {
        if (cur != null) {
          mat[bottom][col] = cur.val;
          cur = cur.next;
        } else {
          mat[bottom][col] = -1;
        }
        num++;
      }
      bottom--;
      for (int row = bottom; num <= n * m && row >= top; row--) {
        if (cur != null) {
          mat[row][left] = cur.val;
          cur = cur.next;
        } else {
          mat[row][left] = -1;
        }
        num++;
      }
      left++;
    }
    return mat;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int len = sc.nextInt();
      SpiralMatrixIII obj1 = new SpiralMatrixIII();
      for (int i = 0; i < len; i++) {
        obj1.insertAtEnd(sc.nextInt());
      }
      System.out.println(Arrays.deepToString(obj1.spiralMatrix(m, n, obj1.head)));
    }
  }
}
