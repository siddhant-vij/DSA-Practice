// Leetcode: 4. Median of Two Sorted Arrays

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MedianSortedArrays {

  static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (k > -1) {
      if (i < 0) {
        nums1[k] = nums2[j];
        j--;
      } else if (j < 0) {
        nums1[k] = nums1[i];
        i--;
      } else if (nums1[i] < nums2[j]) {
        nums1[k] = nums2[j];
        j--;
      } else {
        nums1[k] = nums1[i];
        i--;
      }
      k--;
    }
  }

  static double findMedianSortedArrays(int[] arr1, int[] arr2) {
    arr1 = Arrays.copyOf(arr1, arr1.length + arr2.length);
    merge(arr1, arr1.length - arr2.length, arr2, arr2.length);
    int length = arr1.length;
    double median;
    if ((length & 1) == 0) {
      double leftVal = 1.0 * arr1[(length / 2) - 1];
      double rightVal = 1.0 * arr1[(length / 2)];
      median = (leftVal + rightVal) / 2.0;
    } else {
      median = 1.0 * arr1[length / 2];
    }
    return median;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int[] arr1 = new int[m];
      for (int i = 0; i < m; i++) {
        arr1[i] = sc.nextInt();
      }
      int n = sc.nextInt();
      int[] arr2 = new int[n];
      for (int i = 0; i < n; i++) {
        arr2[i] = sc.nextInt();
      }
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      System.out.println(findMedianSortedArrays(arr1, arr2));
    }
  }
}
