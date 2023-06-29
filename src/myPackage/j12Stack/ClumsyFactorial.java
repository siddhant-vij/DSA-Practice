// Leetcode: 1006. Clumsy Factorial

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClumsyFactorial {

  static String[] nToInfix(int n) {
    String ops = "*/+-";
    int idx = 0;
    String[] result = new String[2 * n - 1];
    int index = 0;
    for (int i = n; i >= 1; i--) {
      result[index++] = String.valueOf(i);
      if (i != 1)
        result[index++] = String.valueOf(ops.charAt(idx));
      idx = (idx + 1) % ops.length();
    }
    return result;
  }

  static boolean checkIfOperator(String str) {
    return str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-");
  }

  static int precedence(String str) {
    switch (str) {
      case "+":
      case "-":
        return 1;
      case "*":
      case "/":
        return 2;
    }
    return -1;
  }

  static String[] infixToPostfix(String[] str) {
    int n = str.length;
    String[] result = new String[n];
    Deque<String> stack = new ArrayDeque<>();
    int idx = 0;
    for (int i = 0; i < n; i++) {
      if (!checkIfOperator(str[i])) {
        result[idx++] = str[i];
      } else {
        while (!stack.isEmpty() && precedence(str[i]) <= precedence(stack.peek())) {
          result[idx++] = stack.pop();
        }
        stack.push(str[i]);
      }
    }
    while (!stack.isEmpty()) {
      result[idx++] = stack.pop();
    }
    return result;
  }

  static int evaluatePostfix(String[] str) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < str.length; i++) {
      if (!checkIfOperator(str[i])) {
        stack.push(Integer.parseInt(str[i]));
      } else {
        int val1 = stack.pop();
        int val2 = stack.pop();
        switch (str[i]) {
          case "+":
            stack.push(val2 + val1);
            break;
          case "-":
            stack.push(val2 - val1);
            break;
          case "/":
            stack.push(val2 / val1);
            break;
          case "*":
            stack.push(val2 * val1);
            break;
        }
      }
    }
    return stack.pop();
  }

  static int clumsy(int n) {
    return evaluatePostfix(infixToPostfix(nToInfix(n)));
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(clumsy(n));
    }
  }  
}
