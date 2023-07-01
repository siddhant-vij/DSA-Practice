// Leetcode: 1944. Number of Visible People in a Queue

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CountVisiblePersons {

  static int[] canSeePersonsCountII(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] > stack.peek()) {
        stack.pop();
        result[i]++;
      }
      if (!stack.isEmpty())
        result[i]++;
      stack.push(nums[i]);
    }
    return result;
  }

  static int[] canSeePersonsCountI(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    for (int i = 0; i < n - 1; i++) {
      int count = 0;
      for (int j = i + 1; j < n; j++) {
        int max = Integer.MIN_VALUE;
        int min = Math.min(nums[i], nums[j]);
        for (int k = i + 1; k <= j - 1; k++) {
          max = Math.max(max, nums[k]);
        }
        if (max < min)
          count++;
      }
      result[i] = count;
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
      System.out.println(Arrays.toString(canSeePersonsCountI(arr)));
      System.out.println(Arrays.toString(canSeePersonsCountII(arr)));
    }
  }  
}
