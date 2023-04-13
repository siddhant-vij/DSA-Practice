// Diagonal Traversal for Square Matrices
// 1. Right To Left
// 2. Left To Right
// 3. Alternate (Right - Left)

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalTraversalNXN {

  static int[] diagonalAlternate_NxN(int[][] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int n = A.length;
    int[] arr = new int[n * n];
    int k = 0;
    boolean isGoingDown = false;
    for (int gap = 0; gap < n; gap++) {
      if (isGoingDown == true) {
        int i = 0;
        int j = gap;
        while (j >= 0) {
          arr[k++] = A[i][j];
          i++;
          j--;
        }
        isGoingDown = false;
      } else {
        int i = gap;
        int j = 0;
        while (i >= 0) {
          arr[k++] = A[i][j];
          i--;
          j++;
        }
        isGoingDown = true;
      }
    }
    for (int gap = n - 2; gap >= 0; gap--) {
      if (isGoingDown == true) {
        int i = n - 1 - gap;
        int j = n - 1;
        while (i < n) {
          arr[k++] = A[i][j];
          i++;
          j--;
        }
        isGoingDown = false;
      } else {
        int i = n - 1;
        int j = n - 1 - gap;
        while (j < n) {
          arr[k++] = A[i][j];
          i--;
          j++;
        }
        isGoingDown = true;
      }
    }
    return arr;
  }

  static int[] diagonalLeftToRight_NxN(int[][] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int n = A.length;
    int[] arr = new int[n * n];
    int k = 0;
    for (int gap = 0; gap < n; gap++) {
      int i = gap;
      int j = 0;
      while (i >= 0) {
        arr[k++] = A[i][j];
        i--;
        j++;
      }
    }
    for (int gap = n - 2; gap >= 0; gap--) {
      int i = n - 1;
      int j = n - 1 - gap;
      while (j < n) {
        arr[k++] = A[i][j];
        i--;
        j++;
      }
    }
    return arr;
  }

  static int[] diagonalRightToLeft_NxN(int[][] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int n = A.length;
    int[] arr = new int[n * n];
    int k = 0;
    for (int gap = 0; gap < n; gap++) {
      int i = 0;
      int j = gap;
      while (j >= 0) {
        arr[k++] = A[i][j];
        i++;
        j--;
      }
    }
    for (int gap = n - 2; gap >= 0; gap--) {
      int i = n - 1 - gap;
      int j = n - 1;
      while (i < n) {
        arr[k++] = A[i][j];
        i++;
        j--;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int[][] mat = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(Arrays.toString(diagonalRightToLeft_NxN(mat)));
      System.out.println(Arrays.toString(diagonalLeftToRight_NxN(mat)));
      System.out.println(Arrays.toString(diagonalAlternate_NxN(mat)));
    }
  }
}
