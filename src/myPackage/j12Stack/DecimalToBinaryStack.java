// Practice: Decimal To Binary using Stack

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryStack {

  static String decimalToBinary(int n) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    while (n != 0) {
      stack.push(n % 2);
      n /= 2;
    }
    StringBuilder strB = new StringBuilder();
    while (stack.peek() != null) {
      strB.append(stack.pop());
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(decimalToBinary(n));
    }
  }
}
