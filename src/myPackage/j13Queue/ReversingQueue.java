// Practice: Reverseing a Queue - Iterative & Recursive

package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class ReversingQueue {

  static void reverseRecursive(Queue<Integer> queue) {
    if (queue.isEmpty())
      return;
    int val = queue.poll();
    reverseRecursive(queue);
    queue.offer(val);
  }

  static void reverseIterative(Queue<Integer> queue) {
    Deque<Integer> stack = new ArrayDeque<>();
    while (!queue.isEmpty()) {
      stack.push(queue.poll());
    }
    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Queue<Integer> queue1 = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        queue1.add(sc.nextInt());
      }
      reverseIterative(queue1);
      for (int element : queue1) {
        System.out.print(element + " ");
      }
      System.out.println();

      Queue<Integer> queue2 = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        queue2.add(sc.nextInt());
      }
      reverseRecursive(queue2);
      for (int element : queue2) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }
}
