// Practice: Reverse each word in a given string

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInString {

  static String reverseWords(String str) {
    Stack<Character> stack = new Stack<>();
    int n = str.length();
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if (ch != '.')
        stack.push(ch);
      else {
        while (!stack.isEmpty())
          strB.append(stack.pop());
        strB.append('.');
      }
    }
    while (!stack.isEmpty())
      strB.append(stack.pop());
    return strB.toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(reverseWords(str));
    }
  }  
}
