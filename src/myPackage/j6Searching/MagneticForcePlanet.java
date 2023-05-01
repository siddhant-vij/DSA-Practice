// Leetcode: 1552 - Magnetic Force Between Two Balls

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class MagneticForcePlanet {

  static boolean isPossibleSolution(int[] arr, int k, int mid) {
    int n = arr.length;
    int count = 1;
    int s = 0;
    int e = 0;
    while (e < n) {
      if (arr[e] - arr[s] < mid)
        e++;
      else {
        count++;
        s = e;
        e++;
      }
    }
    return count >= k;
  }

  static int binarySearchSolution(int[] arr, int k, int s, int e) {
    int result = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (isPossibleSolution(arr, k, m)) {
        result = m;
        s = m + 1;
      } else
        e = m - 1;
    }
    return result;
  }

  static int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int n = position.length;
    return binarySearchSolution(position, m, 1, position[n - 1]);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] bloomDay = new int[N];
      for (int i = 0; i < N; i++) {
        bloomDay[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      System.out.println(maxDistance(bloomDay, m));
    }
  }
}
