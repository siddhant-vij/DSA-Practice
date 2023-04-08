// Letcode: 122 - Best Time to Buy and Sell Stock II

package myPackage.j5Arrays;

import java.util.Scanner;

public class BuySellStockII {

  static int maxProfitSimple(int prices[]) {
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1])
        profit += prices[i] - prices[i - 1];
    }

    return profit;
  }

  static int maxProfit(int[] prices) {
    int cur = 0;
    int profit = 0;
    int maxSum = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    if (cur == 0 && prices.length != 1 && prices[cur] <= prices[cur + 1])
      min = prices[cur];

    cur++;

    while (cur < prices.length - 1) {
      if (prices[cur] < prices[cur - 1] && prices[cur] <= prices[cur + 1]) {
        min = prices[cur];
      }
      if (prices[cur] >= prices[cur - 1] && prices[cur] > prices[cur + 1]) {
        max = prices[cur];
        profit = max - min;
        maxSum += profit;
      }
      cur++;
    }

    if (cur == prices.length - 1 && prices[cur] >= prices[cur - 1]) {
      max = prices[cur];
      profit = max - min;
      maxSum += profit;
    }

    return maxSum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxProfit(arr));
      System.out.println(maxProfitSimple(arr));
    }
  }
}
