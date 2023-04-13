// Leetcode: 1314 - Matrix Block Sum

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixBlockSum {

  static void numMatrix(int[][] matrix, int[][] pfMatrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (row == 0) {
          if (col == 0)
            pfMatrix[row][col] = matrix[row][col];
          else
            pfMatrix[row][col] = pfMatrix[row][col - 1] + matrix[row][col];
        } else {
          if (col == 0)
            pfMatrix[row][col] = matrix[row][col] + pfMatrix[row - 1][col];
          else
            pfMatrix[row][col] = matrix[row][col] + pfMatrix[row][col - 1] + pfMatrix[row - 1][col]
                - pfMatrix[row - 1][col - 1];
        }
      }
    }
  }

  static int sumRegion(int[][] pfMatrix, int row1, int col1, int row2, int col2) {
    if (row1 == 0 || col1 == 0) {
      if (row1 == 0 && col1 == 0)
        return pfMatrix[row2][col2];
      else if (row1 == 0 && col1 != 0)
        return pfMatrix[row2][col2] - pfMatrix[row2][col1 - 1];
      else if (row1 != 0 && col1 == 0)
        return pfMatrix[row2][col2] - pfMatrix[row1 - 1][col2];
    } else
      return pfMatrix[row2][col2] - pfMatrix[row1 - 1][col2] - pfMatrix[row2][col1 - 1]
          + pfMatrix[row1 - 1][col1 - 1];
    return -1;
  }

  static int[][] matrixSum(int[][] mat, int k) {
    int[][] pfMatrix = new int[mat.length][mat[0].length];
    numMatrix(mat, pfMatrix);
    int[][] result = new int[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        int row1 = Math.max(0, i - k);
        int col1 = Math.max(0, j - k);
        int row2 = Math.min(mat.length - 1, i + k);
        int col2 = Math.min(mat[0].length - 1, j + k);
        result[i][j] = sumRegion(pfMatrix, row1, col1, row2, col2);
      }
    }
    return result;
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
      int k = sc.nextInt();
      System.out.println(Arrays.deepToString(matrixSum(mat, k)));
    }
  }
}
