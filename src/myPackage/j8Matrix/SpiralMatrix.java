// Leetcode: 54 Spiral Matrix

package myPackage.j8Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

  static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int top = 0;
    int left = 0;
    int bottom = matrix.length - 1;
    int right = matrix[0].length - 1;
    int num = matrix.length * matrix[0].length;
    while (num > 0) {
      for (int col = left; num > 0 && col <= right; col++) {
        result.add(matrix[top][col]);
        num--;
      }
      top++;
      for (int row = top; num > 0 && row <= bottom; row++) {
        result.add(matrix[row][right]);
        num--;
      }
      right--;
      for (int col = right; num > 0 && col >= left; col--) {
        result.add(matrix[bottom][col]);
        num--;
      }
      bottom--;
      for (int row = bottom; num > 0 && row >= top; row--) {
        result.add(matrix[row][left]);
        num--;
      }
      left++;
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
      System.out.println(spiralOrder(mat));
    }
  }
}
