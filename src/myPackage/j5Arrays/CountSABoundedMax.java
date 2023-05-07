// Leetcode: 795 - Number of Subarrays with Bounded Maximum

package myPackage.j5Arrays;

import java.util.Scanner;

public class CountSABoundedMax {

  static int numSubarrayBoundedMax(int[] nums, int left, int right) {
    int count = 0;
    int n = nums.length;
    int greater = -1;
    int lesser = -1;
    for (int i = 0; i < n; i++) {
      if (nums[i] <= right)
        count += (i - greater);
      else
        greater = i;

      if (nums[i] < left)
        count -= (i - lesser);
      else
        lesser = i;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int left = sc.nextInt();
      int right = sc.nextInt();
      System.out.println(numSubarrayBoundedMax(arr, left, right));
    }
  }
}
