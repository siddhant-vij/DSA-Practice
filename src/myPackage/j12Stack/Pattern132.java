// Leetcode: 456. 132 Pattern

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Pattern132 {

  static boolean find132pattern(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int second = Integer.MIN_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] < second)
        return true;
      while (!stack.isEmpty() && nums[i] > stack.peek())
        second = stack.pop();
      stack.push(nums[i]);
    }
    return false;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(find132pattern(arr));
    }
  }  
}
