// Leetcode: 2289. Steps to Make Array Non-decreasing

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StepsForArrayNonDecreasing {

  static int totalSteps(int[] nums) {
    Deque<Integer> stack = new ArrayDeque<>();
    int ans = 0;
    int n = nums.length;
    int[] arr = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      int cur = 0;
      while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
        cur = Math.max(cur + 1, arr[stack.pop()]);
      }
      stack.push(i);
      arr[i] = cur;
      ans = Math.max(cur, ans);
    }
    return ans;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(totalSteps(arr));
    }
  }  
}
