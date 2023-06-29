package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class MyStackTest {
  Queue<Integer> q1 = new ArrayDeque<>();

  void push(int x) { // O(N)
    int s = q1.size();
    q1.add(x);
    for (int i = 0; i < s; i++) {
      q1.add(q1.remove());
    }
  }

  void pop() { // O(1)
    if (q1.isEmpty())
      return;
    q1.remove();
  }

  int top() {
    if (q1.isEmpty())
      return -1;
    return q1.peek();
  }

  int getSize() {
    return q1.size();
  }
}

public class ImplementStackWithQueue {

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      MyStackTest stack = new MyStackTest();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      System.out.println("current size: " + stack.getSize());
      System.out.println(stack.top());
      stack.pop();
      System.out.println(stack.top());
      stack.pop();
      System.out.println(stack.top());
      System.out.println("current size: " + stack.getSize());
    }
  }
}
