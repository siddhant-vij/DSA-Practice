// Leetcode: 962. Maximum Width Ramp

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaxWidthRamp {

  static int maxWidthRamp(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> temp = new ArrayDeque<>();
    int maxWidth = 0;
    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
      } else {
        if (nums[i] < nums[stack.peek()]) {
          stack.push(i);
        } else {
          while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
            temp.push(stack.pop());
          }
          maxWidth = Math.max(maxWidth, i - temp.peek());
          while (!temp.isEmpty()) {
            stack.push(temp.pop());
          }
        }
      }
    }
    return maxWidth;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxWidthRamp(arr));
    }
  }  
}
