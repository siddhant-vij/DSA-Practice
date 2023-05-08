// Leetcode: 2419 - Longest Subarray With Maximum Bitwise AND

package myPackage.j3bitwise;

import java.util.Scanner;

public class LongestSubArrayMaxAnd {

  static int longestSubarrayFast(int[] nums) {
    int n = nums.length;
    int max = nums[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, nums[i]);
    }

    int s = 0;
    while (s < n && nums[s] != max)
      s++;
    int e = s;
    int maxLength = 1;
    e++;
    while (s < n && e < n) {
      if (nums[e] == max)
        e++;
      else {
        maxLength = Math.max(maxLength, e - s);
        s = e;
        while (s < n && nums[s] != max)
          s++;
        e = s;
      }
    }
    if (s != n && e == n)
      maxLength = Math.max(maxLength, e - s);
    return maxLength;
  }

  static int longestSubarraySlow(int[] nums) {
    int maxLength = -1;
    int maxAnd = -1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int and = nums[i];
        for (int k = i + 1; k <= j; k++) {
          and = and & nums[k];
        }
        maxAnd = Math.max(maxAnd, and);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        int and = nums[i];
        for (int k = i + 1; k <= j; k++) {
          and = and & nums[k];
        }
        if (and == maxAnd && j - i + 1 > maxLength)
          maxLength = j - i + 1;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(longestSubarraySlow(arr));
      System.out.println(longestSubarrayFast(arr));
    }
  }
}
