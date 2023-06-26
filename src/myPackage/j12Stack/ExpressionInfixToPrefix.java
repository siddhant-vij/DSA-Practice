package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExpressionInfixToPrefix {

  static boolean isOperator(char c) {
    return (!(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'Z'));
  }

  static int getPriority(char C) {
    if (C == '-' || C == '+')
      return 1;
    else if (C == '*' || C == '/')
      return 2;
    else if (C == '^')
      return 3;
    return 0;
  }

  static String infixToPrefix(String infix) {
    Deque<Character> operators = new ArrayDeque<Character>();
    Deque<String> operands = new ArrayDeque<String>();
    for (int i = 0; i < infix.length(); i++) {
      if (infix.charAt(i) == '(') {
        operators.push(infix.charAt(i));
      } else if (infix.charAt(i) == ')') {
        while (!operators.isEmpty() && operators.peek() != '(') {
          String op1 = operands.peek();
          operands.pop();
          String op2 = operands.peek();
          operands.pop();
          char op = operators.peek();
          operators.pop();
          String tmp = op + op2 + op1;
          operands.push(tmp);
        }
        operators.pop();
      } else if (!isOperator(infix.charAt(i))) {
        operands.push(infix.charAt(i) + "");
      } else {
        while (!operators.isEmpty() && getPriority(infix.charAt(i)) <= getPriority(operators.peek())) {
          String op1 = operands.peek();
          operands.pop();
          String op2 = operands.peek();
          operands.pop();
          char op = operators.peek();
          operators.pop();
          String tmp = op + op2 + op1;
          operands.push(tmp);
        }
        operators.push(infix.charAt(i));
      }
    }
    while (!operators.isEmpty()) {
      String op1 = operands.peek();
      operands.pop();
      String op2 = operands.peek();
      operands.pop();
      char op = operators.peek();
      operators.pop();
      String tmp = op + op2 + op1;
      operands.push(tmp);
    }
    return operands.peek();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(infixToPrefix(str));
    }
  }
}
