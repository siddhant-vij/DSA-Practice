// GFG Practice: Count Inversions

package myPackage.j7Sorting;

import java.util.Scanner;

public class CountInversions {

  static int countAndMerge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    int p1 = n1 - 1;
    int p2 = n2 - 1;
    int p3 = r;
    int count = 0;
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
          count += (p2 + 1);
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

  static int inversionFast(int[] arr, int l, int r) {
    int count = 0;
    if (l < r) {
      int m = l + (r - l) / 2;
      count += inversionFast(arr, l, m);
      count += inversionFast(arr, m + 1, r);
      count += countAndMerge(arr, l, m, r);
    }
    return count;
  }

  static int inversionSlow(int[] arr) {
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++)
        if (arr[i] > arr[j])
          count++;

    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(inversionSlow(arr)); // O(N^2)/O(1)
      System.out.println(inversionFast(arr, 0, N - 1)); // O(NLogN)/O(N)
    }
  }
}
