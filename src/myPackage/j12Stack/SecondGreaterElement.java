// Leetcode: 2454. Next Greater Element IV

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SecondGreaterElement {

  static int[] secondGreaterElement(int[] nums) {
    int n = nums.length;
    int res[] = new int[n];
    Arrays.fill(res, -1);
    Deque<Integer> s1 = new ArrayDeque<>();
    Deque<Integer> s2 = new ArrayDeque<>();
    Deque<Integer> tmp = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!s2.isEmpty() && nums[s2.peek()] < nums[i])
        res[s2.pop()] = nums[i];
      while (!s1.isEmpty() && nums[s1.peek()] < nums[i])
        tmp.push(s1.pop());
      while (!tmp.isEmpty())
        s2.push(tmp.pop());
      s1.push(i);
    }
    return res;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(secondGreaterElement(arr)));
    }
  }
}
