// Leetcode: 1541. Minimum Insertions to Balance a Parentheses String

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class MinInsertionsForBalance {

  static int minInsertions(String s) {
    Stack<Character> stack = new Stack<>();
    int count = 0, n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
      } else {
        if (stack.isEmpty()) {
          count += 1;
        }
        if (i == n - 1) {
          count += 1;
        } else {
          if (s.charAt(i + 1) == ')') {
            i += 1;
          } else {
            count += 1;
          }
        }
        if (!stack.isEmpty())
          stack.pop();
      }
    }
    return count + (stack.size() * 2);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(minInsertions(str));
    }
  }
}
