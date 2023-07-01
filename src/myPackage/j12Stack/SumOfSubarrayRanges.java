// Leetcode: 2104. Sum of Subarray Ranges

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SumOfSubarrayRanges {

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

  static int[] rightClosestLargest(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(n - 1);
    int[] result = new int[n];
    result[n - 1] = 1;
    int idx = n - 2;
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
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

  static int[] leftClosestLargest(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    int[] result = new int[n];
    result[0] = 1;
    int idx = 1;
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
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

  static long subArrayRanges(int[] nums) {
    int[] leftS = leftClosestSmallest(nums);
    int[] rightS = rightClosestSmallest(nums);
    int[] leftL = leftClosestLargest(nums);
    int[] rightL = rightClosestLargest(nums);
    long sum = 0L;
    for (int i = 0; i < nums.length; i++) {
      sum += 1L * nums[i] * (1L * leftL[i] * rightL[i] - 1L * leftS[i] * rightS[i]);
    }
    return sum;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(subArrayRanges(arr));
    }
  }
}
