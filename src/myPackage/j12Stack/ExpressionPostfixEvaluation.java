package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExpressionPostfixEvaluation {

  static double evaluatePostfix(String Str) {
    Deque<Double> stack = new ArrayDeque<>();
    for (int i = 0; i < Str.length(); i++) {
      char c = Str.charAt(i);
      if (c == ' ')
        continue;
      else if (Character.isDigit(c)) {
        int n = 0;
        while (Character.isDigit(c)) {
          n = n * 10 + (int) (c - '0');
          i++;
          c = Str.charAt(i);
        }
        i--;
        stack.push(n * 1.0);
      } else {
        double val1 = stack.pop();
        double val2 = stack.pop();
        switch (c) {
          case '+':
            stack.push(val2 + val1);
            break;
          case '-':
            stack.push(val2 - val1);
            break;
          case '/':
            stack.push(val2 / val1);
            break;
          case '*':
            stack.push(val2 * val1);
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      System.out.println(evaluatePostfix(str));
    }
  }
}
