// Leetcode: 1

package myPackage.j5Arrays;

import java.util.*;

public class TwoSum {

  static int[] twoSumFast(int[] nums, int target) {
    int n = nums.length;
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; ++i) {
      arr[i][0] = nums[i];
      arr[i][1] = i;
    }
    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
    int left = 0, right = n - 1;
    while (left < right) {
      int sum2 = arr[left][0] + arr[right][0];
      if (sum2 == target)
        return new int[] { arr[left][1], arr[right][1] };
      if (sum2 > target)
        right -= 1;
      else
        left += 1;
    }
    return new int[] {};
  }

  static int[] twoSumSlow(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (i != j) {
          if (nums[i] + nums[j] == target) {
            result[0] = i;
            result[1] = j;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(Arrays.toString(twoSumSlow(arr, target)));
      System.out.println(Arrays.toString(twoSumFast(arr, target)));
    }
  }
}
