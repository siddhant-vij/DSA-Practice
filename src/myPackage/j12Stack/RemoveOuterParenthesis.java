// Leetcode: 1021. Remove Outermost Parentheses

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RemoveOuterParenthesis {

  static String removeOuterParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder strB = new StringBuilder();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (stack.isEmpty())
        stack.push(ch);
      else {
        if (stack.peek() == '(' && ch == ')') {
          stack.pop();
          if (!stack.isEmpty())
            strB.append(ch);
        } else if (ch == '(') {
          stack.push(ch);
          strB.append(ch);
        }
      }
    }
    return strB.toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(removeOuterParentheses(str));
    }
  }  
}
