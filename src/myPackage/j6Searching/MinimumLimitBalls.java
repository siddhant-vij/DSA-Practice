// Leetcode: 1760 - Minimum Limit of Balls in a Bag

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumLimitBalls {

  static boolean isPossibleSolution(int[] nums, int maxOps, int mid) {
    int n = nums.length;
    int[] arr = Arrays.copyOf(nums, n);
    int count = 0;
    for (int i = 0; i < n; i++) {
      int x = arr[i] / mid;
      if (arr[i] % mid == 0)
        x--;
      count += x;
    }
    return count <= maxOps;
  }

  static int binarySearchSolution(int[] arr, int maxOps, int s, int e) {
    int result = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (isPossibleSolution(arr, maxOps, m)) {
        result = m;
        e = m - 1;
      } else
        s = m + 1;
    }
    return result;
  }

  static int minimumSize(int[] nums, int maxOperations) {
    int n = nums.length;
    int max = nums[0];
    for (int i = 1; i < n; i++)
      max = Math.max(max, nums[i]);
    return binarySearchSolution(nums, maxOperations, 1, max);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int maxOps = sc.nextInt();
      System.out.println(minimumSize(arr, maxOps));
    }
  }
}
