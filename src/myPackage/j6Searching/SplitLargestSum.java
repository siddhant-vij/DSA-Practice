// Leetcode 410 - Split Array Largest Sum

package myPackage.j6Searching;

import java.util.Scanner;

public class SplitLargestSum {

  static boolean isPossibleSolution(int[] arr, int mid, int k) {
    int n = arr.length;
    int wall = 1;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      if (sum > mid) {
        wall++;
        sum = arr[i];
      }
    }
    return (wall <= k);
  }

  static int findSolution(int[] nums, int k, int s, int e) {
    int result = 0;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (isPossibleSolution(nums, m, k)) {
        result = m;
        e = m - 1;
      } else {
        s = m + 1;
      }
    }
    return result;
  }

  static int splitArray(int[] nums, int k) {
    int n = nums.length;
    int total = 0;
    int max = nums[0];
    for (int i = 0; i < n; i++) {
      max = Math.max(max, nums[i]);
      total += nums[i];
    }
    return findSolution(nums, k, max, total);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(splitArray(arr, target));
    }
  }
}
