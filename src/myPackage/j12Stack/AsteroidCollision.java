// Leetcode: 735. Asteroid Collision

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class AsteroidCollision {

  static int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int ast : asteroids) {
      collision: {
        while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
          if (stack.peek() < -ast) {
            stack.pop();
            continue;
          } else if (stack.peek() == -ast) {
            stack.pop();
          }
          break collision;
        }
        stack.push(ast);
      }
    }
    int[] ans = new int[stack.size()];
    for (int t = ans.length - 1; t >= 0; --t) {
      ans[t] = stack.pop();
    }
    return ans;
  }
  
  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(asteroidCollision(arr));
    }
  }
}
