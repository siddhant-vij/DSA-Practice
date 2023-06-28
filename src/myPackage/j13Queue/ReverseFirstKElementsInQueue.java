// Practice: Reverse First K Elements In A Queue

package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class ReverseFirstKElementsInQueue {

  static void reverseQueueFirstKElements(Queue<Integer> queue, int k) {
    if (queue.isEmpty() || k > queue.size() || k < 0)
      return;
    Deque<Integer> stack = new ArrayDeque<>();
    int count = 0;
    while (count < k) {
      stack.push(queue.poll());
      count++;
    }
    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
    }
    count = 0;
    int n = queue.size();
    while (count < n - k) {
      queue.offer(queue.poll());
      count++;
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      Queue<Integer> queue = new ArrayDeque<>();
      for (int i = 0; i < n; i++) {
        queue.add(sc.nextInt());
      }
      int k = sc.nextInt();
      reverseQueueFirstKElements(queue, k);
      System.out.println(queue);
    }
  }
}
