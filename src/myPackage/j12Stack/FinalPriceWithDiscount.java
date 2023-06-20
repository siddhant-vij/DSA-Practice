// Leetcode: 1475. Final Prices With a Special Discount in a Shop

package myPackage.j12Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FinalPriceWithDiscount {

  static int[] finalPrices(int[] prices) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] res = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
        res[stack.pop()] -= prices[i];
      }
      res[i] = prices[i];
      stack.push(i);
    }
    return res;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(finalPrices(arr)));
    }
  }  
}
