// Leetcode: 85. Maximal Rectangle

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LargestRectangleSubmatrix {

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

  static int getMaxArea(int[] nums) {
    int n = nums.length;
    int[] left = leftClosestSmallest(nums);
    int[] right = rightClosestSmallest(nums);
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxArea = Math.max(maxArea, nums[i] * (right[i] - 1 - left[i]));
    }
    return maxArea;
  }

  static int maximalRectangle(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    if (matrix == null || rows == 0)
      return 0;
    int maxArea = Integer.MIN_VALUE;
    int[] temp = new int[cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (matrix[row][col] == '1') {
          temp[col] = temp[col] + 1;
        } else {
          temp[col] = 0;
        }
      }
      int currArea = getMaxArea(temp);
      maxArea = Math.max(maxArea, currArea);
    }
    return maxArea;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int rows = sc.nextInt();
      int cols = sc.nextInt();
      char[][] matrix = new char[rows][cols];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          matrix[i][j] = sc.next().charAt(0);
        }
      }
      System.out.println(maximalRectangle(matrix));
    }
  }
}
