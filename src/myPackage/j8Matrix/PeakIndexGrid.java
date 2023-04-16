// Leetcode:1901-Find a Peak Element II

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class PeakIndexGrid {

  static int[] findPeakGrid(int[][] mat) {
    int startCol = 0;
    int endCol = mat[0].length - 1;

    while (startCol <= endCol) {
      int maxRow = 0;
      int midCol = startCol + (endCol - startCol) / 2;

      for (int row = 0; row < mat.length; row++) {
        maxRow = mat[row][midCol] >= mat[maxRow][midCol] ? row : maxRow;
      }

      boolean leftIsBig = midCol - 1 >= startCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
      boolean rightIsBig = midCol + 1 <= endCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

      if (!leftIsBig && !rightIsBig)
        return new int[] { maxRow, midCol };

      else if (rightIsBig)
        startCol = midCol + 1;

      else
        endCol = midCol - 1;
    }
    return null;
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
      System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
  }
}
