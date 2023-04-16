// Leetcode: 162 - Find Peak Element

package myPackage.j6Searching;

import java.util.Scanner;

public class PeakIndexMultiplePeaks {

  static int peakIndex(int[] arr) {
    int n = arr.length;
    int s = 0;
    int e = n - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (m > 0 && m < n - 1) {
        if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1])
          return m;
        else if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1])
          s = m + 1;
        else
          e = m - 1;
      } else if (m == 0) {
        if (arr[m] > arr[m + 1])
          return 0;
        else
          s = m + 1;
      } else {
        if (arr[m] > arr[m - 1])
          return n - 1;
        else
          e = m - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(peakIndex(arr));
    }
  }
}
