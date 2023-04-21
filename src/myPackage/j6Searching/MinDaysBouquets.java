// Leetcode: 1482 - Minimum Number of Days to Make m Bouquets

package myPackage.j6Searching;

import java.util.Scanner;

public class MinDaysBouquets {

  static boolean isPossibleSolution(int[] arr, int m, int k, int mid) {
    int days = 0;
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] > mid)
        count = 0;
      else if (++count >= k) {
        days++;
        count = 0;
      }
    }
    return days >= m;
  }

  static int binarySearchSolution(int[] arr, int m, int k, int s, int e) {
    int result = -1;
    while (s <= e) {
      int mid = s + (e - s) / 2;
      if (isPossibleSolution(arr, m, k, mid)) {
        result = mid;
        e = mid - 1;
      } else
        s = mid + 1;
    }
    return result;
  }

  static int minDays(int[] bloomDay, int m, int k) {
    int min = bloomDay[0];
    int max = bloomDay[0];
    int n = bloomDay.length;
    for (int i = 1; i < n; i++) {
      min = Math.min(min, bloomDay[i]);
      max = Math.max(max, bloomDay[i]);
    }
    return binarySearchSolution(bloomDay, m, k, min, max);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] bloomDay = new int[N];
      for (int i = 0; i < N; i++) {
        bloomDay[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int k = sc.nextInt();
      System.out.println(minDays(bloomDay, m, k));
    }
  }
}
