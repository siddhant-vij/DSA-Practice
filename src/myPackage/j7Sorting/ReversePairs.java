// Leetcode: 493 - Reverse Pairs

package myPackage.j7Sorting;

import java.util.Scanner;

public class ReversePairs {

  static int mergeAndCount(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int i = 0; i < n1; i++)
      L[i] = arr[l + i];
    for (int i = 0; i < n2; i++)
      R[i] = arr[m + 1 + i];

    int count = 0;
    int i = 0;
    int j = 0;
    while (i < L.length && j < R.length) {
      if (1L * L[i] > 2L * R[j]) {
        count += L.length - i;
        j++;
      } else {
        i++;
      }
    }

    int p1 = n1 - 1;
    int p2 = n2 - 1;
    int p3 = r;
    while (p3 >= l) {
      if (p1 < 0) {
        arr[p3] = R[p2];
        p2--;
      } else if (p2 < 0) {
        arr[p3] = L[p1];
        p1--;
      } else {
        if (L[p1] > R[p2]) {
          arr[p3] = L[p1];
          p1--;
        } else {
          arr[p3] = R[p2];
          p2--;
        }
      }
      p3--;
    }
    return count;
  }

  static int reversePairs(int[] arr, int l, int r) {
    int count = 0;
    if (l < r) {
      int m = l + (r - l) / 2;
      count += reversePairs(arr, l, m);
      count += reversePairs(arr, m + 1, r);
      count += mergeAndCount(arr, l, m, r);
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(reversePairs(arr, 0, N - 1)); // O(NLogN)/O(N)
    }
  }
}
