// Leetcode: 1673. Find the Most Competitive Subsequence

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MostCompetitiveSubsequence {
  
  static int[] mostCompetitive(int[] nums, int k) {
    Deque<Integer> stack = new ArrayDeque<>();
    int n = nums.length;
    int[] result = new int[k];
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
        if (n - i > k - stack.size())
          stack.pop();
        else
          break;
      }
      if (stack.size() < k) {
        stack.push(i);
      }
    }
    for (int i = k - 1; i >= 0; i--) {
      result[i] = nums[stack.pop()];
    }
    return result;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(Arrays.toString(mostCompetitive(arr, k)));
    }
  }
}
