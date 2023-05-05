// Leetcode: 826 - Most Profit Assigning Work

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class MostProfitWork {

  static class MaxProfit implements Comparable<MaxProfit> {
    int a1;
    int a2;

    MaxProfit(int a1, int a2) {
      this.a1 = a1;
      this.a2 = a2;
    }

    public int compareTo(MaxProfit other) {
      return this.a1 - other.a1;
    }
  }

  static int isPossibleSolution(int[] arr, int k) {
    int n = arr.length;
    int s = 0;
    int e = n - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;

      if (m == arr.length - 1 && arr[m] == k)
        return m;
      else if (m != arr.length - 1 && arr[m] == k && arr[m + 1] == k)
        s = m + 1;
      else if (m != arr.length - 1 && arr[m] == k && arr[m + 1] != k)
        return m;

      else if (arr[m] < k)
        s = m + 1;
      else
        e = m - 1;
    }
    if (e >= 0)
      return e;
    else
      return -1;
  }

  static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    MaxProfit[] maxprofit = new MaxProfit[difficulty.length];
    for (int i = 0; i < maxprofit.length; i++) {
      maxprofit[i] = new MaxProfit(difficulty[i], profit[i]);
    }
    Arrays.sort(maxprofit);
    for (int i = 0; i < difficulty.length; i++) {
      difficulty[i] = maxprofit[i].a1;
    }
    for (int i = 0; i < profit.length; i++) {
      profit[i] = maxprofit[i].a2;
    }

    Arrays.sort(worker);

    int maxProfit = 0;
    for (int i = 0; i < worker.length; i++) {
      int index = isPossibleSolution(difficulty, worker[i]);
      int profitF = 0;
      if (index != -1) {
        for (int j = 0; j <= index; j++) {
          profitF = Math.max(profitF, profit[j]);
        }
      }
      maxProfit += profitF;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] difficulty = new int[n];
      for (int i = 0; i < n; i++) {
        difficulty[i] = sc.nextInt();
      }
      int[] profit = new int[n];
      for (int i = 0; i < n; i++) {
        profit[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] worker = new int[m];
      for (int i = 0; i < m; i++) {
        worker[i] = sc.nextInt();
      }
      System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }
  }
}
