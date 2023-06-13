// Practice: Reverse String using Stack

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStringUsingStack {

  static String reverse(String S) {
    Stack<Character> str = new Stack<>();
    int n = S.length();
    for (int i = 0; i < n; i++)
      str.push(S.charAt(i));
    StringBuilder strB = new StringBuilder();
    while (!str.isEmpty())
      strB.append(str.pop());
    return strB.toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(reverse(str));
    }
  }
}
