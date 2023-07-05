// Leetcode: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

package myPackage.j14Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LongestSubarrayDiffLimit {

  static int longestSubarray(int[] nums, int limit) {
    int n = nums.length;
    Deque<Integer> max = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();
    int s = 0;
    int e = 0;
    int maxLength = Integer.MIN_VALUE;
    while (e < n) {
      int val = nums[e];
      while (!min.isEmpty() && nums[min.peekLast()] >= val)
        min.pollLast();
      min.addLast(e);
      while (!max.isEmpty() && nums[max.peekLast()] <= val)
        max.pollLast();
      max.add(e);
      int minVal = nums[min.peekFirst()];
      int maxVal = nums[max.peekFirst()];
      if (maxVal - minVal <= limit) {
        maxLength = Math.max(maxLength, e - s + 1);
        e++;
      } else {
        s++;
        while (s > min.peekFirst())
          min.pollFirst();
        while (s > max.peekFirst())
          max.pollFirst();
      }
    }
    return maxLength;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(longestSubarray(arr, k));
    }
  }
}
