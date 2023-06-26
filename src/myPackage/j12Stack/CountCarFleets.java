// Leetcode: 853. Car Fleet

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CountCarFleets {

  static int carFleet(int target, int[] position, int[] speed) {
    double arr[][] = new double[position.length][2];
    Deque<Double> stack = new ArrayDeque<>();
    for (int i = 0; i < position.length; i++) {
      arr[i][0] = position[i];
      arr[i][1] = (double) (target - position[i]) / speed[i];
    }
    Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && stack.peek() <= arr[i][1])
        stack.pop();
      stack.push(arr[i][1]);
    }
    return stack.size();
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
      int target = sc.nextInt();
      System.out.println(carFleet(target, arr1, arr2));
    }
  }
}
