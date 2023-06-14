// Leetcode: 2300. Successful Pairs of Spells and Potions

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SpellPotionPairs {

  static int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int s = 0;
    int e = n - 1;
    int result = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == target) {
        result = m;
        e = m - 1;
      } else if (arr[m] < target) {
        s = m + 1;
      } else {
        e = m - 1;
      }
    }
    if (result != -1)
      return result;
    else
      return s;
  }

  static int[] successfulPairs(int[] spells, int[] potions, long success) {
    int n = spells.length;
    int[] pairs = new int[n];
    Arrays.sort(potions);
    for (int i = 0; i < n; i++) {
      if (Math.ceil(success * 1.0 / (1L * spells[i])) > 100000L)
        continue;
      pairs[i] = potions.length - binarySearch(potions, (int) Math.ceil(success * 1.0 / (1L * spells[i])));
    }
    return pairs;
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
      int success = sc.nextInt();
      System.out.println(Arrays.toString(successfulPairs(arr1, arr2, success)));
    }
  }
}
