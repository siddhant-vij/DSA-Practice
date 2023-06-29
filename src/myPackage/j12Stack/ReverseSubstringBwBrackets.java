// Leetcode: 1190. Reverse Substrings Between Each Pair of Parentheses

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseSubstringBwBrackets {

  static String reverseParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        if (!stack.isEmpty()) {
          stack.pop();
        }
        for (int l = 0; l < sb.length(); l++) {
          stack.push(sb.charAt(l));
        }
      } else {
        stack.push(s.charAt(i));
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(reverseParentheses(str));
    }
  }  
}
