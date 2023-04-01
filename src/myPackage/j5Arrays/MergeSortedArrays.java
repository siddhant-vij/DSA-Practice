// Leetcode 88

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {

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
      arr1 = Arrays.copyOf(arr1, m + n);
      merge(arr1, m, arr2, n);
      System.out.println(Arrays.toString(arr1));
    }
  }
}
