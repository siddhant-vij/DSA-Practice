// Leetcode: 1738. Find Kth Largest XOR Coordinate Value

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class KthLargestXorValue {

  static int[] convertMatrixToPrefixXorArray(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] pf = new int[m][n];
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (row == 0 && col == 0) {
          pf[row][col] = mat[row][col];
        } else if (row == 0) {
          pf[row][col] = pf[row][col - 1] ^ mat[row][col];
        } else if (col == 0) {
          pf[row][col] = pf[row - 1][col] ^ mat[row][col];
        } else {
          pf[row][col] = pf[row - 1][col] ^ pf[row][col - 1] ^ pf[row - 1][col - 1] ^ mat[row][col];
        }
      }
    }
    int index = 0;
    int[] result = new int[m * n];
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        result[index++] = pf[row][col];
      }
    }
    return result;
  }

  static int kthLargestValue(int[][] matrix, int k) {
    int[] nums = convertMatrixToPrefixXorArray(matrix);
    Arrays.sort(nums);
    return nums[nums.length - k];
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
      System.out.println(kthLargestValue(mat, k));
    }
  }  
}
