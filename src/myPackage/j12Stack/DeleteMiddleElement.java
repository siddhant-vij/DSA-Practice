// Practice: Delete middle element of a stack

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElement {

  static void deleteMid(Stack<Integer> s, int sizeOfStack) {
    int middle = (int) Math.ceil((sizeOfStack + 1) / 2);
    Stack<Integer> temp = new Stack<>();
    while (sizeOfStack-- != middle) {
      temp.push(s.pop());
    }
    s.pop();
    while (!temp.isEmpty()) {
      s.push(temp.pop());
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < n; i++) {
        stack.push(sc.nextInt());
      }
      deleteMid(stack, n);
      for (int element : stack) {
        System.out.print(element + " ");
      }
    }
  }
}
