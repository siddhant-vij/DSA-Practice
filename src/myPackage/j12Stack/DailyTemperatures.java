// Leetcode: 739. Daily Temperatures

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DailyTemperatures {

  static int[] dailyTemperatures(int[] temp) {
    int n = temp.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] result = new int[n];
    result[n - 1] = 0;
    stack.push(n - 1);
    int idx = n - 2;
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && temp[i] >= temp[stack.peek()])
        stack.pop();
      if (stack.isEmpty())
        result[idx--] = 0;
      else
        result[idx--] = stack.peek() - i;
      stack.push(i);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(dailyTemperatures(arr));
    }
  }
}
