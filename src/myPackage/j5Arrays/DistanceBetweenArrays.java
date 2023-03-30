// Leetcode 1385

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DistanceBetweenArrays {

  static boolean notInRange(int[] arr, int from, int to) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] >= from && arr[mid] <= to) {
        return false;
      } else if (arr[mid] < from) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return true;
  }

  static int findTheDistanceValueFast(int[] arr1, int[] arr2, int d) {
    Arrays.sort(arr2);
    int distance = 0;
    for (int val : arr1) {
      if (notInRange(arr2, val - d, val + d)) {
        distance++;
      }
    }
    return distance;
  }

  static boolean isPresent(int[] arr, int n, int start, int end) {
    if (start > end)
      return false;
    else {
      int mid = start + (end - start) / 2;
      if (arr[mid] == n)
        return true;
      else if (arr[mid] > n)
        return isPresent(arr, n, start, mid - 1);
      else
        return isPresent(arr, n, mid + 1, end);
    }
  }

  static int findTheDistanceValueSlow(int[] arr1, int[] arr2, int d) {
    int countF = 0;
    Arrays.sort(arr2);
    for (int i = 0; i < arr1.length; i++) {
      int count = 0;
      int prevD = d;
      int pos = 0;
      int[] arr = new int[2 * prevD + 1];
      while (prevD >= 0) {
        arr[pos] = arr1[i] - prevD;
        arr[arr.length - 1 - pos] = arr1[i] + prevD;
        pos++;
        prevD--;
      }
      for (int j = 0; j < 2 * d + 1; j++) {
        if (!isPresent(arr2, arr[j], 0, arr2.length - 1))
          count++;
      }
      if (count == 2 * d + 1)
        countF++;
    }
    return countF;
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
      System.out.println(findTheDistanceValueSlow(arr1, arr2, d));
      System.out.println(findTheDistanceValueFast(arr1, arr2, d));
    }
  }

}
