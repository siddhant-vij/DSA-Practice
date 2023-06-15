// Leetcode: 1508. Range Sum of Sorted Subarray Sums

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class RangeSumSortedSubarraySums {

  static int rangeSum(int[] nums, int n, int left, int right) {
    int mod = 1000_000_007;
    int len = n * (n + 1) / 2;
    int[] sum = new int[len];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      int curSum = nums[i];
      sum[idx++] = curSum;
      for (int j = i + 1; j < n; j++) {
        curSum += nums[j];
        sum[idx++] = curSum;
      }
    }
    Arrays.sort(sum);
    long result = 0L;
    for (int i = left - 1; i < right; i++)
      result = (int) (result + 1L * sum[i]) % mod;
    return (int) result % mod;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int left = sc.nextInt();
      int right = sc.nextInt();
      System.out.println(rangeSum(arr, N, left, right));
    }
  }
}
