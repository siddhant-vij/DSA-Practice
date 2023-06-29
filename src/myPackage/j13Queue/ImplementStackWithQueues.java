// Practice: Implement Stack With 2 Queues

package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class MyStack {
  Queue<Integer> q1 = new ArrayDeque<>();
  Queue<Integer> q2 = new ArrayDeque<>();
  int size;

  MyStack() {
    size = 0;
  }

  void push1(int x) {
    size++;
    q2.add(x);
    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  void push2(int x) {
    q1.add(x);
    size++;
  }

  void pop1() {
    if (q1.isEmpty())
      return;
    q1.remove();
    size--;
  }

  void pop2() {
    if (q1.isEmpty())
      return;
    while (q1.size() != 1) {
      q2.add(q1.remove());
    }
    q1.remove();
    size--;
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  int top1() {
    if (q1.isEmpty())
      return -1;
    return q1.peek();
  }

  int top2() {
    if (q1.isEmpty())
      return -1;
    while (q1.size() != 1) {
      q2.add(q1.remove());
    }
    int temp = q1.remove();
    q2.add(temp);
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
    return temp;
  }

  int getSize() {
    return size;
  }
}

public class ImplementStackWithQueues {

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      MyStack stack1 = new MyStack();
      // Method 1 (By making push operation costly)
      stack1.push1(1);
      stack1.push1(2);
      stack1.push1(3);
      System.out.println("current size: " + stack1.getSize());
      System.out.println(stack1.top1());
      stack1.pop1();
      System.out.println(stack1.top1());
      stack1.pop1();
      System.out.println(stack1.top1());
      System.out.println("current size: " + stack1.getSize());

      // Method 2 (By making pop operation costly)
      MyStack stack2 = new MyStack();
      stack2.push2(1);
      stack2.push2(2);
      stack2.push2(3);
      System.out.println("current size: " + stack2.getSize());
      System.out.println(stack2.top2());
      stack2.pop2();
      System.out.println(stack2.top2());
      stack2.pop2();
      System.out.println(stack2.top2());
      System.out.println("current size: " + stack2.getSize());
    }
  }
}
