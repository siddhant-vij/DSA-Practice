// Leetcode: 1292 - Maximum Side Length of a Square with Sum Less than or Equal to Threshold

package myPackage.j8Matrix;

import java.util.Scanner;

public class MaxSideLengthSum {

  static boolean isValid(int row1, int col1, int row2, int col2, int rows, int cols) {
    return (row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows
        && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols);
  }

  static void pfMatrix(int[][] pfMat, int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (row == 0) {
          if (col == 0)
            pfMat[row][col] = matrix[row][col];
          else
            pfMat[row][col] = pfMat[row][col - 1] + matrix[row][col];
        } else {
          if (col == 0)
            pfMat[row][col] = matrix[row][col] + pfMat[row - 1][col];
          else
            pfMat[row][col] = matrix[row][col] + pfMat[row][col - 1] + pfMat[row - 1][col]
                - pfMat[row - 1][col - 1];
        }
      }
    }
  }

  static int sumRegion(int[][] pfMat, int row1, int col1, int row2, int col2) {
    if (row1 == 0 || col1 == 0) {
      if (row1 == 0 && col1 == 0)
        return pfMat[row2][col2];
      else if (row1 == 0 && col1 != 0)
        return pfMat[row2][col2] - pfMat[row2][col1 - 1];
      else if (row1 != 0 && col1 == 0)
        return pfMat[row2][col2] - pfMat[row1 - 1][col2];
    } else
      return pfMat[row2][col2] - pfMat[row1 - 1][col2] - pfMat[row2][col1 - 1]
          + pfMat[row1 - 1][col1 - 1];
    return -1;
  }

  static int maxSideLength(int[][] mat, int threshold) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] pfMat = new int[m][n];
    pfMatrix(pfMat, mat);
    int sqLength = 0;
    int maxLength = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < Math.min(m, n); k++) {
          int row1 = i;
          int col1 = j;
          int row2 = i + k;
          int col2 = j + k;
          if (isValid(row1, col1, row2, col2, m, n)) {
            if (sumRegion(pfMat, row1, col1, row2, col2) <= threshold) {
              sqLength = col2 - col1 + 1;
              maxLength = Math.max(maxLength, sqLength);
            }
          }
        }
      }
    }
    return maxLength;
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
      int threshold = sc.nextInt();
      System.out.println(maxSideLength(mat, threshold));
    }
  }
}
