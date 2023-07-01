// Leetcode: 84. Largest Rectangle in Histogram

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LargestRectangleByArea {

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

  static int largestRectangleArea(int[] nums) {
    int n = nums.length;
    int[] left = leftClosestSmallest(nums);
    int[] right = rightClosestSmallest(nums);
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxArea = Math.max(maxArea, nums[i] * (right[i] - 1 - left[i]));
    }
    return maxArea;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(largestRectangleArea(arr));
    }
  }
}
