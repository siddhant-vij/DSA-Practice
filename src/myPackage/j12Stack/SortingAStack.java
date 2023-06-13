// Practice: Sorting a Stack

package myPackage.j12Stack;

import java.util.Scanner;
import java.util.Stack;

public class SortingAStack {

  static Stack<Integer> sort(Stack<Integer> s) {
    if (s.size() == 1)
      return s;
    Stack<Integer> temp1 = new Stack<>();
    Stack<Integer> temp2 = new Stack<>();
    while (!s.isEmpty()) {
      if (temp1.isEmpty() || s.peek() <= temp1.peek())
        temp1.push(s.pop());
      else {
        while (!temp1.isEmpty() && s.peek() > temp1.peek())
          temp2.push(temp1.pop());
        temp1.push(s.pop());
        while (!temp2.isEmpty())
          temp1.push(temp2.pop());
      }
    }
    while (!temp1.isEmpty())
      s.push(temp1.pop());
    return s;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < n; i++) {
        stack.push(sc.nextInt());
      }
      stack = sort(stack);
      for (int element : stack) {
        System.out.print(element + " ");
      }
    }
  }
}
