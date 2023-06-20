// Leetcode: 844. Backspace String Compare

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class BackspaceStringEquality {

  static boolean backspaceCompare(String s, String t) {
    Stack<Character> stackS = new Stack<>();
    Stack<Character> stackT = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (stackS.isEmpty() && s.charAt(i) == '#') {
        continue;
      } else if (s.charAt(i) == '#') {
        stackS.pop();
      } else {
        stackS.push(s.charAt(i));
      }
    }
    for (int i = 0; i < t.length(); i++) {
      if (stackT.isEmpty() && t.charAt(i) == '#') {
        continue;
      } else if (t.charAt(i) == '#') {
        stackT.pop();
      } else {
        stackT.push(t.charAt(i));
      }
    }
    return stackS.equals(stackT);
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      String t = sc.next();
      System.out.println(backspaceCompare(s, t));
    }
  }
}
