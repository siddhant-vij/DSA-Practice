// GFG Practice: Previous & Next Closest Greater Element

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class NextAndPreviousGreater {

  static void reverseArray(int[] arr) {
    int s = 0;
    int n = arr.length;
    int e = n - 1;
    while (s < e) {
      int temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }

  static int[] nextGreater(int[] arr) {
    Deque<Integer> stack = new ArrayDeque<>();
    int n = arr.length;
    int[] nextGreater = new int[n];
    stack.push(arr[n - 1]);
    int idx = 0;
    nextGreater[idx++] = -1;
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] > stack.peek()) {
        stack.pop();
      }
      if (stack.isEmpty())
        nextGreater[idx++] = -1;
      else
        nextGreater[idx++] = stack.peek();
      stack.push(arr[i]);
    }
    reverseArray(nextGreater);
    return nextGreater;
  }

  static int[] prevGreater(int[] arr) {
    Deque<Integer> stack = new ArrayDeque<>();
    int n = arr.length;
    int[] prevGreater = new int[n];
    stack.push(arr[0]);
    int idx = 0;
    prevGreater[idx++] = -1;
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && arr[i] > stack.peek()) {
        stack.pop();
      }
      if (stack.isEmpty())
        prevGreater[idx++] = -1;
      else
        prevGreater[idx++] = stack.peek();
      stack.push(arr[i]);
    }
    return prevGreater;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(prevGreater(arr)));
      System.out.println(Arrays.toString(nextGreater(arr)));
    }
  }
}
