// Leetcode: 907. Sum of Subarray Minimums

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SumOfSubarrayMinimums {

  static int[] rightClosestSmallest(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(n - 1);
    int[] result = new int[n];
    result[n - 1] = 1;
    int idx = n - 2;
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[idx--] = n - i;
      } else {
        result[idx--] = stack.peek() - i;
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
    result[0] = 1;
    int idx = 1;
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[idx++] = i + 1;
      } else {
        result[idx++] = i - stack.peek();
      }
      stack.push(i);
    }
    return result;
  }

  static int sumSubarrayMins(int[] nums) {
    int[] left = leftClosestSmallest(nums);
    int[] right = rightClosestSmallest(nums);
    int n = nums.length;
    int sum = 0;
    int mod = 1000_000_007;
    for (int i = 0; i < n; i++) {
      sum = (sum + (int) ((1L * nums[i] * left[i] * right[i]) % mod)) % mod;
    }
    return sum % mod;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(sumSubarrayMins(arr));
    }
  }  
}
