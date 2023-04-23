// Leetcode: 540 - Single Element in a Sorted Array

package myPackage.j6Searching;

import java.util.Scanner;

public class SingleElementSorted {

  static int singleNonDuplicateFast(int[] nums) {
    // Optimized: O(log n)
    int n = nums.length;
    if (n == 1)
      return nums[0];
    int s = 0;
    int e = n - 1;
    while (s <= n) {
      int m = s + (e - s) / 2;
      if (m != 0 && m != n - 1) {
        if (m % 2 == 0 && nums[m] == nums[m - 1] && nums[m] != nums[m + 1])
          e = m;
        else if (m % 2 == 0 && nums[m] != nums[m - 1] && nums[m] == nums[m + 1])
          s = m;
        else if (m % 2 != 0 && nums[m] == nums[m - 1] && nums[m] != nums[m + 1])
          s = m + 1;
        else if (m % 2 != 0 && nums[m] != nums[m - 1] && nums[m] == nums[m + 1])
          e = m - 1;
        else if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1])
          return nums[m];
      } else if (m == 0 && nums[m] != nums[m + 1])
        return nums[0];
      else if (m == n - 1 && nums[m] != nums[m - 1])
        return nums[n - 1];
    }
    return -1;
  }

  static int singleNonDuplicateSlowOptimized(int[] nums) {
    // Optimized: O(n) solution
    int x1 = 0;
    for (int i = 0; i < nums.length; i++) {
      x1 = x1 ^ nums[i];
    }
    return x1;
  }

  static int singleNonDuplicateSlow(int[] nums) {
    // Brute Force: O(n) solution
    int x1 = 0;
    int x2 = 0;
    int mask = 0;
    for (int i = 0; i < nums.length; i++) {
      x2 = x2 ^ (x1 & nums[i]);
      x1 = x1 ^ nums[i];
      mask = ~(~x1 & x2);
      x2 &= mask;
      x1 &= mask;
    }
    return x1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(singleNonDuplicateSlow(arr));
      System.out.println(singleNonDuplicateSlowOptimized(arr));
      System.out.println(singleNonDuplicateFast(arr));
    }
  }
}
