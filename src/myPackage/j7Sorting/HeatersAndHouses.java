// Leetcode: 475. Heaters

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class HeatersAndHouses {

  static int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int res = 0;
    int ht = 0;
    int nh = heaters.length;
    for (int i = 0; i < houses.length; i++) {
      int d = Math.abs(heaters[ht] - houses[i]);
      while (ht + 1 < nh && Math.abs(heaters[ht + 1] - houses[i]) <= d) {
        ht++;
        d = Math.abs(heaters[ht] - houses[i]);
      }
      res = Math.max(res, d);
    }
    return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      int M = sc.nextInt();
      int[] arr2 = new int[M];
      for (int i = 0; i < M; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(findRadius(arr1, arr2));
    }
  }
}
