// Leetcode: 1856. Maximum Subarray Min-Product

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaxSubarrayMinProduct {

  static int[] rightClosestSmallest(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(n - 1);
    int[] result = new int[n];
    result[n - 1] = n;
    int idx = n - 2;
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[idx--] = n;
      } else {
        result[idx--] = stack.peek();
      }
      stack.push(i);
    }
    return result;
  }

  static int[] leftClosestSmallest(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    int[] result = new int[n];
    result[0] = -1;
    int idx = 1;
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[idx++] = -1;
      } else {
        result[idx++] = stack.peek();
      }
      stack.push(i);
    }
    return result;
  }

  static int maxSumMinProduct(int[] nums) {
    int[] left = leftClosestSmallest(nums);
    int[] right = rightClosestSmallest(nums);
    int n = nums.length;
    long[] pf = new long[n];
    pf[0] = nums[0];
    for (int i = 1; i < n; i++)
      pf[i] = pf[i - 1] + 1L * nums[i];
    int mod = 1000_000_007;
    long result = 0L;
    for (int i = 0; i < n; i++) {
      long sum = 0L;
      if (left[i] == -1) {
        sum = pf[right[i] - 1];
      } else {
        sum = pf[right[i] - 1] - pf[left[i]];
      }
      result = Math.max(result, nums[i] * sum);
    }
    return (int) (result % mod);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxSumMinProduct(arr));
    }
  }
}