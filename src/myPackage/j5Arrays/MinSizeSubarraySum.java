// Leetcode 209: Minimum Size Subarray Sum

package myPackage.j5Arrays;

import java.util.Scanner;

public class MinSizeSubarraySum {

  static int minSubArrayLen(int[] nums, int target) {
    int n = nums.length;
    int left = 0;
    int sum = 0;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      while (sum >= target) {
        result = Math.min(result, i + 1 - left);
        sum -= nums[left++];
      }
    }
    return (result != Integer.MAX_VALUE) ? result : 0;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(minSubArrayLen(arr, target));
    }
  }
}
