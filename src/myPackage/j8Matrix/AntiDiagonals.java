// Scaler Practice - Anti Diagonals
// Give a N * N square matrix A, return an array of its anti-diagonals.

// Problem Constraints
// 1<=N<=1000
// 1<=A[i][j]<=1e9

// Input:
// 3 3
// 1 2 3
// 4 5 6
// 7 8 9

// Output:
// 1 0 0
// 2 4 0
// 3 5 7
// 6 8 0
// 9 0 0

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class AntiDiagonals {

  static int[][] diagonal(int[][] A) {
    int n = A.length;
    int[][] mat = new int[2 * n - 1][n];
    for (int gap = 0; gap < n; gap++) {
      int i = 0;
      int j = gap;
      int row = gap;
      int col = 0;
      int count = 0;
      while (j >= 0) {
        mat[row][col] = A[i][j];
        i++;
        j--;
        col++;
        count++;
      }
      for (int k = n - 1 - count; k >= 0; k--) {
        mat[row][col] = 0;
        col++;
      }
    }
    for (int gap = n - 2; gap >= 0; gap--) {
      int i = n - 1 - gap;
      int j = n - 1;
      int row = 2 * n - 2 - gap;
      int col = 0;
      int count = 0;
      while (i < n) {
        mat[row][col] = A[i][j];
        i++;
        j--;
        col++;
        count++;
      }
      for (int k = n - 1 - count; k >= 0; k--) {
        mat[row][col] = 0;
        col++;
      }
    }
    return mat;
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
      System.out.println(Arrays.deepToString(diagonal(mat)));
    }
  }
  
}
