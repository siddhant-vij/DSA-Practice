// Gfg Practice: Sort by Absolute Difference

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class ValueAbsDiffPair implements Comparable<ValueAbsDiffPair> {
  int val;
  int diff;

  ValueAbsDiffPair(int val, int diff) {
    this.val = val;
    this.diff = diff;
  }

  @Override
  public int compareTo(ValueAbsDiffPair other) {
    return this.diff - other.diff;
  }
}

public class SortByAbsDiff {

  static int[] sortABS(int arr[], int n, int k) {
    ValueAbsDiffPair[] pairs = new ValueAbsDiffPair[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new ValueAbsDiffPair(arr[i], Math.abs(arr[i] - k));
    Arrays.sort(pairs);
    for (int i = 0; i < n; i++)
      arr[i] = pairs[i].val;
    return arr;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(Arrays.toString(sortABS(arr, N, k)));
    }
  }
}
