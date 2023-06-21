// Leetcode: 2197. Replace Non-Coprime Numbers in Array

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class ReplaceNonCoprimesWithLCM {

  static int lcm(int x, int y) {
    return x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }

  static List<Integer> replaceNonCoprimes(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) {
        stack.push(nums[i]);
      } else {
        while (!stack.isEmpty() && gcd(stack.peek(), nums[i]) > 1) {
          nums[i] = lcm(stack.pop(), nums[i]);
        }
        stack.push(nums[i]);
      }
    }
    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
    Collections.reverse(result);
    return result;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] str = new int[n];
      for (int i = 0; i < n; i++) {
        str[i] = sc.nextInt();
      }
      System.out.println(replaceNonCoprimes(str));
    }
  }
}
