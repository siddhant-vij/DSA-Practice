// Leetcode: 20. Valid Parentheses

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParenthesis {

  static boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (stack.isEmpty())
        stack.push(s.charAt(i));
      else {
        if (stack.peek() == '{' && s.charAt(i) != '}')
          stack.push(s.charAt(i));
        else if (stack.peek() == '{' && s.charAt(i) == '}')
          stack.pop();
        else if (stack.peek() == '(' && s.charAt(i) != ')')
          stack.push(s.charAt(i));
        else if (stack.peek() == '(' && s.charAt(i) == ')')
          stack.pop();
        else if (stack.peek() == '[' && s.charAt(i) != ']')
          stack.push(s.charAt(i));
        else if (stack.peek() == '[' && s.charAt(i) == ']')
          stack.pop();
      }
    }
    return stack.size() == 0;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(isValid(str));
    }
  }  
}
