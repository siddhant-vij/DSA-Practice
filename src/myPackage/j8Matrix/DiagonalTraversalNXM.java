// Diagonal Traversal for Non-Square Matrices
// 1. Right To Left
// 2. Left To Right
// 3. Alternate (Right - Left)

package myPackage.j8Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DiagonalTraversalNXM {

  static boolean isValid(int i, int j, int rows, int cols) {
    return (i >= 0 && i < rows && j >= 0 && j < cols);
  }

  static int[] diagonalAlternate_NxM(int[][] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int n = A.length;
    int m = A[0].length;
    int[] arr = new int[n * m];
    int k = 0;
    boolean isGoingDown = false;
    ArrayList<Integer> arrL = new ArrayList<>();
    for (int gap = 0; gap < m; gap++) {
      arrL.clear();
      int i = 0;
      int j = gap;
      int count = 0;
      while (isValid(i, j, n, m)) {
        arrL.add(A[i][j]);
        count++;
        i++;
        j--;
      }
      if (isGoingDown == true) {
        for (int l = 0; l < count; l++) {
          arr[k++] = arrL.get(l);
        }
        isGoingDown = false;
      } else {
        Collections.reverse(arrL);
        for (int l = 0; l < count; l++) {
          arr[k++] = arrL.get(l);
        }
        isGoingDown = true;
      }
    }
    for (int gap = n - 2; gap >= 0; gap--) {
      arrL.clear();
      int i = n - 1 - gap;
      int j = m - 1;
      int count = 0;
      while (isValid(i, j, n, m)) {
        arrL.add(A[i][j]);
        count++;
        i++;
        j--;
      }
      if (isGoingDown == true) {
        for (int l = 0; l < count; l++) {
          arr[k++] = arrL.get(l);
        }
        isGoingDown = false;
      } else {
        Collections.reverse(arrL);
        for (int l = 0; l < count; l++) {
          arr[k++] = arrL.get(l);
        }
        isGoingDown = true;
      }
    }
    return arr;
  }

  static int[] diagonalLeftToRight_NxM(int[][] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int n = A.length;
    int m = A[0].length;
    int[] arr = new int[n * m];
    int k = 0;
    for (int gap = 0; gap < n; gap++) {
      int i = gap;
      int j = 0;
      while (isValid(i, j, n, m)) {
        arr[k++] = A[i][j];
        i--;
        j++;
      }
    }
    for (int gap = m - 2; gap >= 0; gap--) {
      int i = n - 1;
      int j = m - 1 - gap;
      while (isValid(i, j, n, m)) {
        arr[k++] = A[i][j];
        i--;
        j++;
      }
    }
    return arr;
  }

  static int[] diagonalRightToLeft_NxM(int[][] A) {
    if (A == null || A.length == 0) {
      return new int[0];
    }
    int n = A.length;
    int m = A[0].length;
    int[] arr = new int[n * m];
    int k = 0;
    for (int gap = 0; gap < m; gap++) {
      int i = 0;
      int j = gap;
      while (isValid(i, j, n, m)) {
        arr[k++] = A[i][j];
        i++;
        j--;
      }
    }
    for (int gap = n - 2; gap >= 0; gap--) {
      int i = n - 1 - gap;
      int j = m - 1;
      while (isValid(i, j, n, m)) {
        arr[k++] = A[i][j];
        i++;
        j--;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] mat = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(Arrays.toString(diagonalRightToLeft_NxM(mat)));
      System.out.println(Arrays.toString(diagonalLeftToRight_NxM(mat)));
      System.out.println(Arrays.toString(diagonalAlternate_NxM(mat)));
    }
  }
}
