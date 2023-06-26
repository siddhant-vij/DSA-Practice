package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ExpressionPrefixEvaluation {

  static Boolean isOperand(char c) {
    return (c >= 48 && c <= 57);
  }

  static double evaluatePrefix(String str) {
    Deque<Double> stack = new ArrayDeque<Double>();
    for (int j = str.length() - 1; j >= 0; j--) {
      if (str.charAt(j) == ' ')
        continue;
      if (isOperand(str.charAt(j))) {
        double num = 0, i = j;
        while (j < str.length() && isOperand(str.charAt(j)))
          j--;
        j++;
        for (int k = j; k <= i; k++) {
          num = num * 10 + (double) (str.charAt(k) - '0');
        }

        stack.push(num);
      } else {
        double o1 = (double) stack.peek();
        stack.pop();
        double o2 = (double) stack.peek();
        stack.pop();
        switch (str.charAt(j)) {
          case '+':
            stack.push(o1 + o2);
            break;
          case '-':
            stack.push(o1 - o2);
            break;
          case '*':
            stack.push(o1 * o2);
            break;
          case '/':
            stack.push(o1 / o2);
            break;
        }
      }
    }
    return stack.pop();
  }
  
  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      System.out.println(evaluatePrefix(str));
    }
  }
}
