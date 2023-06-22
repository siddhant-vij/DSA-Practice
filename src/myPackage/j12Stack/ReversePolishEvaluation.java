// Leetcode: 150. Evaluate Reverse Polish Notation

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReversePolishEvaluation {

  static int evalRPN(String[] str) {
    int n = str.length;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (str[i].equals("+")) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        stack.push(op2 + op1);
      } else if (str[i].equals("-")) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        stack.push(op2 - op1);
      } else if (str[i].equals("*")) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        stack.push(op2 * op1);
      } else if (str[i].equals("/")) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        stack.push(op2 / op1);
      } else {
        stack.push(Integer.parseInt(str[i]));
      }
    }
    return stack.pop();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] str = new String[n];
      for (int i = 0; i < n; i++) {
        str[i] = sc.next();
      }
      System.out.println(evalRPN(str));
    }
  }
}
