// Leetcode: 1385 - Find the Distance Value Between Two Arrays

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class DistanceArrays {

  static boolean notPresentBinarySearch(int[] arr, int low, int high) {
    int s = 0;
    int e = arr.length - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] >= low && arr[m] <= high)
        return false;
      else if (arr[m] < low)
        s = m + 1;
      else
        e = m - 1;
    }
    return true;
  }

  static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    int result = 0;
    Arrays.sort(arr2);
    for (int i = 0; i < arr1.length; i++) {
      if (notPresentBinarySearch(arr2, arr1[i] - d, arr1[i] + d))
        result++;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] arr2 = new int[m];
      for (int i = 0; i < m; i++) {
        arr2[i] = sc.nextInt();
      }
      int d = sc.nextInt();
      System.out.println(findTheDistanceValue(arr1, arr2, d));
    }
  }
}
