// Leetcode: 1914 - Cyclically Rotating a Grid

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class CyclicRotation {

  static int[][] rotateGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = m - 1;
    while (left < right && top < bottom) {
      int total_layer_elements = 2 * (bottom - top) + 2 * (right - left);
      int num_of_rotations = k % total_layer_elements;
      while (num_of_rotations-- > 0) {
        int temp = grid[top][left];
        for (int j = left; j < right; j++) {
          grid[top][j] = grid[top][j + 1];
        }
        for (int i = top; i < bottom; i++) {
          grid[i][right] = grid[i + 1][right];
        }
        for (int j = right; j > left; j--) {
          grid[bottom][j] = grid[bottom][j - 1];
        }
        for (int i = bottom; i > top; i--) {
          grid[i][left] = grid[i - 1][left];
        }
        grid[top + 1][left] = temp;
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return grid;
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
      System.out.println(Arrays.deepToString(rotateGrid(mat, k)));
    }
  }

}
