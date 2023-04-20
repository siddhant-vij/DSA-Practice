// Leetcode: 875 - Koko Eating Bananas

package myPackage.j6Searching;

import java.util.Scanner;

public class KokoBananas {

  static boolean isPossibleSolution(int[] arr, int mid, int h) {
    int walls = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] <= mid)
        walls++;
      else {
        int diff = arr[i];
        while (diff > mid) {
          diff -= mid;
          walls++;
        }
        walls++;
      }
    }
    return walls <= h;
  }

  static int binarySearchSolution(int[] arr, int h, int s, int e) {
    int result = 0;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (isPossibleSolution(arr, m, h)) {
        result = m;
        e = m - 1;
      } else
        s = m + 1;
    }
    return result;
  }

  static int minEatingSpeedII(int[] piles, int h) {
    int l = 1, r = 1000000000;
    while (l < r) {
      int m = (l + r) / 2, total = 0;
      for (int p : piles)
        total += (p + m - 1) / m;
      if (total > h)
        l = m + 1;
      else
        r = m;
    }
    return l;
  }

  static int minEatingSpeedI(int[] piles, int h) {
    int n = piles.length;
    int max = piles[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, piles[i]);
    }
    return binarySearchSolution(piles, h, 1, max);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(minEatingSpeedI(arr, target)); // Correct logic but gives TLE for large inputs
      System.out.println(minEatingSpeedII(arr, target)); // Same TC O(NLogN) - passes for large inputs
    }
  }
}
