// Leetcode: 363. Max Sum of Rectangle No Larger Than K

package myPackage.j8Matrix;

import java.util.Scanner;

public class MaxSumSmallerThanK {

  static int maxSumSubmatrix(int[][] matrix, int k) {
    int m = matrix.length;
    int n = matrix[0].length;
    if (m < 1 || n < 1) {
      return -1;
    }
    int[][] pfSum = new int[m + 1][n + 1];
    for (int r = m - 1; r >= 0; r--) {
      for (int c = n - 1; c >= 0; c--) {
        if (matrix[r][c] == k) {
          return matrix[r][c];
        }
        pfSum[r][c] = matrix[r][c] + pfSum[r][c + 1] + pfSum[r + 1][c] - pfSum[r + 1][c + 1];
      }
    }
    int maxSum = Integer.MIN_VALUE;
    for (int rS = 0; rS < m; rS++) {
      for (int rE = rS; rE < m; rE++) {
        for (int cS = 0; cS < n; cS++) {
          for (int cE = cS; cE < n; cE++) {
            int sum = pfSum[rS][cS] + pfSum[rE + 1][cE + 1] - pfSum[rS][cE + 1] - pfSum[rE + 1][cS];
            if (sum == k) {
              return sum;
            } else if (sum < k && sum > maxSum) {
              maxSum = sum;
            }
          }
        }
      }
    }
    return maxSum;
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
      System.out.println(maxSumSubmatrix(mat, k));
    }
  }  
}
