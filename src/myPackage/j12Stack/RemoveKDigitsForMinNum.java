// Leetcode: 402. Remove K Digits

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RemoveKDigitsForMinNum {

  static String removeKdigits(String num, int k) {
    int n = num.length();
    if (k == 0)
      return num;
    if (k == n)
      return "0";

    Deque<Character> stack = new ArrayDeque<>();
    int index = 0;
    while (index < n) {
      while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
        stack.pop();
        k--;
      }
      stack.push(num.charAt(index++));
    }
    while (k-- > 0)
      stack.pop();

    String smallest = "";
    while (!stack.isEmpty())
      smallest = stack.pop() + smallest;

    while (smallest.length() > 1 && smallest.charAt(0) == '0')
      smallest = smallest.substring(1);

    return smallest;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int k = sc.nextInt();
      System.out.println(removeKdigits(str, k));
    }
  }  
}
