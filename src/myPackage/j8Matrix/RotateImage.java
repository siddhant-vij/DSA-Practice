// Rotate: 48 - Rotate Image

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class RotateImage {

  static int[][] rowReversal(int[][] mat, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[i][n - 1 - j];
        mat[i][n - 1 - j] = temp;
      }
    }
    return mat;
  }

  static int[][] diagonalReversal(int[][] mat, int n) {
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }
    return mat;
  }

  static void rotate(int[][] matrix) {
    matrix = rowReversal(diagonalReversal(matrix, matrix.length), matrix.length);
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
      rotate(mat);
      System.out.println(Arrays.deepToString(mat));
    }
  }
}
