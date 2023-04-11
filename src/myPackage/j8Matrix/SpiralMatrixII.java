// Leetcode: 885 - Spiral Matrix III

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrixII {

  static boolean isValid(int i, int j, int rows, int cols) {
    return (i >= 0 && i < rows && j >= 0 && j < cols);
  }

  static int[][] spiralOrder(int rows, int cols, int rStart, int cStart) {
    int left = cStart;
    int right = cStart;
    int top = rStart;
    int bottom = rStart;
    int num = 0;
    int[][] mat = new int[rows * cols][2];
    while (num < rows * cols) {
      for (int col = left; num < rows * cols && col <= right; col++) {
        if (isValid(top, col, rows, cols)) {
          mat[num][0] = top;
          mat[num++][1] = col;
        }
      }
      right++;
      for (int row = top; num < rows * cols && row <= bottom; row++) {
        if (isValid(row, right, rows, cols)) {
          mat[num][0] = row;
          mat[num++][1] = right;
        }
      }
      bottom++;
      for (int col = right; num < rows * cols && col >= left; col--) {
        if (isValid(bottom, col, rows, cols)) {
          mat[num][0] = bottom;
          mat[num++][1] = col;
        }
      }
      left--;
      for (int row = bottom; num < rows * cols && row >= top; row--) {
        if (isValid(row, left, rows, cols)) {
          mat[num][0] = row;
          mat[num++][1] = left;
        }
      }
      top--;
    }
    return mat;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int rows = sc.nextInt();
      int cols = sc.nextInt();
      int rStart = sc.nextInt();
      int cStart = sc.nextInt();
      System.out.println(Arrays.deepToString(spiralOrder(rows, cols, rStart, cStart)));
    }
  }
}
