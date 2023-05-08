// Leetcode: 2099 - Find Subsequence of Length K With the Largest Sum

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SubsequenceLargestSum {

  static int[] maxSubsequence(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[k];
    int[][] mat = new int[n][2];
    for (int i = 0; i < n; i++) {
      mat[i][0] = i;
      mat[i][1] = nums[i];
    }
    Arrays.sort(mat, Comparator.comparingInt(a -> a[1]));
    int[][] matSrtd = new int[k][2];
    for (int i = n - k; i < n; i++) {
      matSrtd[i - (n - k)][0] = mat[i][0];
      matSrtd[i - (n - k)][1] = mat[i][1];
    }
    Arrays.sort(matSrtd, Comparator.comparingInt(a -> a[0]));
    for (int i = 0; i < k; i++)
      result[i] = matSrtd[i][1];
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(Arrays.toString(maxSubsequence(arr, k)));
    }
  }
}
