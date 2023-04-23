// Leetcode: 2226 - Maximum Candies Allocated to K Children

package myPackage.j6Searching;

import java.util.Scanner;

public class CandyAllocation {

  static boolean canSplit(int[] candies, long k, long mid) {
    long split = 0;
    for (int i = 0; i < candies.length; ++i) {
      split += candies[i] / mid;
    }
    return split >= k;
  }

  static int binarySearchSolution(int[] candies, long k, long start, long end) {
    long ans = 0;
    while (start <= end) {
      long mid = (start + end) / 2;
      if (canSplit(candies, k, mid)) {
        ans = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return (int) ans;
  }

  static int maximumCandies(int[] candies, long k) {
    long sum = 0;
    for (int i = 0; i < candies.length; ++i) {
      sum += candies[i];
    }
    return binarySearchSolution(candies, k, 1, sum);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] candies = new int[N];
      for (int i = 0; i < N; i++) {
        candies[i] = sc.nextInt();
      }
      long children = sc.nextInt();
      System.out.println(maximumCandies(candies, children));
    }
  }
}
