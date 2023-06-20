// GFG Practice: Stock Span Problem

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class StockSpanProblem {

  static int[] calculateSpan(int price[]) {
    int n = price.length;
    Deque<Integer> val = new ArrayDeque<>();
    Deque<Integer> idx = new ArrayDeque<>();
    int[] result = new int[n];
    val.push(price[0]);
    idx.push(0);
    int index = 0;
    result[index++] = 1;
    for (int i = 1; i < n; i++) {
      while (!val.isEmpty() && price[i] >= val.peek()) {
        val.pop();
        idx.pop();
      }
      if (val.isEmpty()) {
        result[index++] = i + 1;
      } else {
        result[index++] = i - idx.peek();
      }
      val.push(price[i]);
      idx.push(i);
    }
    return result;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(calculateSpan(arr)));
    }
  }
}
