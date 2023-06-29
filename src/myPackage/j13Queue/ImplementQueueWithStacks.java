// Practice: Implement Queue With 2 Stacks

package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class MyQueue {
  Deque<Integer> s1 = new ArrayDeque<>();
  Deque<Integer> s2 = new ArrayDeque<>();

  void enQueue1(int x) {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    s1.push(x);
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  void enQueue2(int x) {
    s1.push(x);
  }

  int deQueue1() {
    if (s1.isEmpty()) {
      System.out.println("Q is Empty");
      System.exit(0);
    }
    int x = s1.peek();
    s1.pop();
    return x;
  }

  int deQueue2() {
    int x;
    if (s1.isEmpty() && s2.isEmpty()) {
      System.out.println("Q is empty");
      System.exit(0);
    }
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        x = s1.pop();
        s2.push(x);
      }
    }
    x = s2.pop();
    return x;
  }

  int getSize() {
    return s1.size();
  }
}

public class ImplementQueueWithStacks {
  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      MyQueue queue1 = new MyQueue();
      // Method 1 (By making enqueue operation costly)
      queue1.enQueue1(1);
      queue1.enQueue1(2);
      queue1.enQueue1(3);
      System.out.println("current size: " + queue1.getSize());
      System.out.println(queue1.deQueue1());
      System.out.println(queue1.deQueue1());
      System.out.println(queue1.deQueue1());
      System.out.println("current size: " + queue1.getSize());

      // Method 2 (By making dequeue operation costly)
      MyQueue queue2 = new MyQueue();
      queue2.enQueue2(1);
      queue2.enQueue2(2);
      queue2.enQueue2(3);
      System.out.println("current size: " + queue2.getSize());
      System.out.println(queue2.deQueue2());
      System.out.println(queue2.deQueue2());
      System.out.println(queue2.deQueue2());
      System.out.println("current size: " + queue2.getSize());
    }
  }
}
