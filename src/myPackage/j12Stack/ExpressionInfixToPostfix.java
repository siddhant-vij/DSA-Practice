package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExpressionInfixToPostfix {

  static boolean checkIfOperand(char ch) {
    return Character.isLetterOrDigit(ch);
  }

  static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    return -1;
  }

  static String infixToPostfix(String expr) {
    Deque<Character> stack = new ArrayDeque<>();
    StringBuilder result = new StringBuilder(new String(""));
    for (int i = 0; i < expr.length(); ++i) {
      if (checkIfOperand(expr.charAt(i)))
        result.append(expr.charAt(i));
      else if (expr.charAt(i) == '(' || expr.charAt(i) == '[' || expr.charAt(i) == '{')
        stack.push(expr.charAt(i));
      else if (expr.charAt(i) == ')' || expr.charAt(i) == ']' || expr.charAt(i) == '}') {
        if (expr.charAt(i) == ')') {
          while (!stack.isEmpty() && stack.peek() != '(') {
            result.append(stack.pop());
          }
          stack.pop();
        }
        if (expr.charAt(i) == ']') {
          while (!stack.isEmpty() && stack.peek() != '[') {
            result.append(stack.pop());
          }
          stack.pop();
        }
        if (expr.charAt(i) == '}') {
          while (!stack.isEmpty() && stack.peek() != '{') {
            result.append(stack.pop());
          }
          stack.pop();
        }
      } else {
        while (!stack.isEmpty() && precedence(expr.charAt(i)) <= precedence(stack.peek())) {
          result.append(stack.pop());
        }
        stack.push(expr.charAt(i));
      }
    }
    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }
    return result.toString();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(infixToPostfix(str));
    }
  }
}
