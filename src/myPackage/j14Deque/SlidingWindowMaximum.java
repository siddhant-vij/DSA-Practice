// Leetcode: 239. Sliding Window Maximum

package myPackage.j14Deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMaximum {

  static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length < 1)
      return new int[0];
    int result[] = new int[nums.length - k + 1];
    Deque<Integer> q = new ArrayDeque<Integer>();
    for (int i = 0; i < k; i++) {
      while (!q.isEmpty() && nums[i] > nums[q.peekLast()])
        q.pollLast();
      q.offerLast(i);
    }
    result[0] = nums[q.peekFirst()];
    for (int i = k; i < nums.length; i++) {
      if (q.peekFirst() <= i - k)
        q.pollFirst();
      while (!q.isEmpty() && nums[i] > nums[q.peekLast()])
        q.pollLast();
      q.offerLast(i);
      result[i - k + 1] = nums[q.peekFirst()];
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
      System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }
  }
}
