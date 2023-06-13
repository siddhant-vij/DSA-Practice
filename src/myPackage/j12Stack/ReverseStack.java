// Practice: Reverse Stack using 2 Stacks

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

  static void reverse(Stack<Integer> s) {
    Stack<Integer> temp1 = new Stack<>();
    Stack<Integer> temp2 = new Stack<>();
    while (!s.isEmpty()) {
      temp1.push(s.pop());
    }
    while (!temp1.isEmpty()) {
      temp2.push(temp1.pop());
    }
    while (!temp2.isEmpty()) {
      s.push(temp2.pop());
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Stack<Integer> stack = new Stack<>();
      for (int j = 0; j < n; j++) {
        stack.push(sc.nextInt());
      }
      reverse(stack);
      for (int j : stack) {
        System.out.print(j + " ");
      }
    }
  }
}
