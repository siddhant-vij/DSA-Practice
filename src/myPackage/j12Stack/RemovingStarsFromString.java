// Leetcode: 2390. Removing Stars From a String

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RemovingStarsFromString {

  static String removeStars(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch != '*') {
        stack.push(ch);
      } else {
        stack.pop();
      }
    }
    StringBuilder strB = new StringBuilder();
    while (!stack.isEmpty()) {
      strB.append(stack.pop());
    }
    return strB.reverse().toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(removeStars(str));
    }
  }  
}
