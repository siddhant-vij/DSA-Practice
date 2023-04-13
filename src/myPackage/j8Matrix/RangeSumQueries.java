// Leetcode: 304 - Range Sum Query 2D - Immutable

package myPackage.j8Matrix;

import java.util.Scanner;

class NumMatrix {
  private int[][] matrix;

  public NumMatrix(int[][] matrix) {
    this.matrix = new int[matrix.length][matrix[0].length];
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        if (row == 0) {
          if (col == 0)
            this.matrix[row][col] = matrix[row][col];
          else
            this.matrix[row][col] = this.matrix[row][col - 1] + matrix[row][col];
        } else {
          if (col == 0)
            this.matrix[row][col] = matrix[row][col] + this.matrix[row - 1][col];
          else
            this.matrix[row][col] = matrix[row][col] + this.matrix[row][col - 1] + this.matrix[row - 1][col]
                - this.matrix[row - 1][col - 1];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row1 == 0 || col1 == 0) {
      if (row1 == 0 && col1 == 0)
        return this.matrix[row2][col2];
      else if (row1 == 0 && col1 != 0)
        return this.matrix[row2][col2] - this.matrix[row2][col1 - 1];
      else if (row1 != 0 && col1 == 0)
        return this.matrix[row2][col2] - this.matrix[row1 - 1][col2];
    } else
      return this.matrix[row2][col2] - this.matrix[row1 - 1][col2] - this.matrix[row2][col1 - 1]
          + this.matrix[row1 - 1][col1 - 1];
    return -1;
  }
}

public class RangeSumQueries {

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
      NumMatrix obj = new NumMatrix(mat);
      int row1 = sc.nextInt();
      int col1 = sc.nextInt();
      int row2 = sc.nextInt();
      int col2 = sc.nextInt();
      System.out.println(obj.sumRegion(row1, col1, row2, col2));
    }
  }

}
