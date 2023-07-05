// Leetcode: 1700. Number of Students Unable to Eat Lunch

package myPackage.j14Deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CountHungryStudents {

  static int countStudents(int[] students, int[] sandwiches) {
    Stack<Integer> stack = new Stack<>();
    Deque<Integer> queue = new LinkedList<>();
    int n = students.length;
    for (int i = n - 1; i >= 0; i--) {
      stack.push(sandwiches[i]);
    }
    for (int i = 0; i < n; i++) {
      queue.add(students[i]);
    }
    int eaten = 0;
    int count = 0;
    while (!stack.isEmpty()) {
      if (stack.peek() == queue.peek()) {
        count = 0;
        eaten++;
        stack.pop();
        queue.poll();
      } else {
        count++;
        int temp = queue.peekFirst();
        queue.pollFirst();
        queue.addLast(temp);
      }
      if (count == queue.size()) {
        break;
      }
    }
    return n - eaten;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      int[] arr2 = new int[n];
      for (int i = 0; i < n; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(countStudents(arr1, arr2));
    }
  }
}
