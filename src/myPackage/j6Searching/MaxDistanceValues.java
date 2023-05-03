// Letcode: 1855 - Maximum Distance Between a Pair of Values

package myPackage.j6Searching;

import java.util.Scanner;

public class MaxDistanceValues {

  static int maxDistanceII(int[] nums1, int[] nums2) {
    int maxDist = 0, p1 = 0, p2 = 0;
    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1] > nums2[p2])
        p1++;
      else {
        maxDist = Math.max(maxDist, p2 - p1);
        p2++;
      }
    }
    return maxDist;
  }

  static int binarySearch(int[] arr, int target) {
    int n = arr.length;
    int s = 0;
    int e = n - 1;
    int result = -1;
    int isPresent = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == target) {
        result = m;
        s = m + 1;
        isPresent = 1;
      } else if (arr[m] < target)
        e = m - 1;
      else
        s = m + 1;
    }
    if (isPresent == 1)
      return result + 1;
    else
      return s;
  }

  static int maxDistanceI(int[] nums1, int[] nums2) {
    int maxLength = 0;
    for (int i = 0; i < nums1.length; i++) {
      int j = binarySearch(nums2, nums1[i]);
      int diff = (j - i - 1 >= 0) ? (j - i - 1) : -1;
      maxLength = Math.max(diff, maxLength);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] nums1 = new int[n];
      for (int i = 0; i < n; i++) {
        nums1[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] nums2 = new int[m];
      for (int i = 0; i < m; i++) {
        nums2[i] = sc.nextInt();
      }
      System.out.println(maxDistanceI(nums1, nums2));
      System.out.println(maxDistanceII(nums1, nums2));
    }
  }
}
