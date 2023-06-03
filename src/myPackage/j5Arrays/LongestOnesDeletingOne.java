// Leetcode: 1493. Longest Subarray of 1's After Deleting One Element

package myPackage.j5Arrays;

import java.util.Scanner;

public class LongestOnesDeletingOne {

  static int longestSubarray(int[] nums) {
    int n = nums.length;
    int s = 0;
    int e = 0;
    int count = 0;
    int maxLength = Integer.MIN_VALUE;
    while (e < n) {
      if (nums[e] == 0)
        count++;
      if ((nums[e] == 0 && count == 1) || nums[e] == 1)
        e++;
      else {
        maxLength = Math.max(maxLength, e - s);
        count = 0;
        while (s < n && nums[s] != 0)
          s++;
        s++;
      }
    }
    maxLength = Math.max(maxLength, e - s);
    return maxLength == Integer.MIN_VALUE ? 0 : maxLength - 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(longestSubarray(arr));
    }
  }  
}
