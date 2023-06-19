// Leetcode: 682. Baseball Game

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BaseballGame {

  static int sumOfAllElements(Deque<Integer> stack) {
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }

  static int calPoints(String[] str) {
    int n = str.length;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (str[i].equals("C")) {
        stack.pop();
      } else if (str[i].equals("D")) {
        stack.push(2 * stack.peek());
      } else if (str[i].equals("+")) {
        int sum = 0;
        int val = stack.pop();
        sum += val + stack.peek();
        stack.push(val);
        stack.push(sum);
      } else {
        stack.push(Integer.parseInt(str[i]));
      }
    }
    return sumOfAllElements(stack);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] str = new String[n];
      for (int i = 0; i < n; i++) {
        str[i] = sc.next();
      }
      System.out.println(calPoints(str));
    }
  }
}
