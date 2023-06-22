// Leetcode: 1544. Make The String Great

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MakeGreatString {

  static String makeGood(String s) {
    int n = s.length();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (stack.isEmpty()) {
        stack.push(ch);
      } else {
        if (stack.peek() - 'a' + 'A' == ch || stack.peek() - 'A' + 'a' == ch)
          stack.pop();
        else
          stack.push(ch);
      }
    }
    StringBuilder strB = new StringBuilder();
    while (!stack.isEmpty())
      strB.append(stack.pop());
    return strB.reverse().toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(makeGood(str));
    }
  }  
}
