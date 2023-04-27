// Leetcode: 2215 - Find the Difference of Two Arrays

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DifferenceArrays {

  static ArrayList<ArrayList<Integer>> findDifference(int[] nums1, int[] nums2) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> uniq1 = new ArrayList<>();
    ArrayList<Integer> uniq2 = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int n1 = nums1.length;
    int n2 = nums2.length;
    int p1 = 0;
    int p2 = 0;
    while (p1 < n1 || p2 < n2) {
      if (p1 < n1 && p2 < n2) {
        if (nums1[p1] == nums2[p2]) {
          p1++;
          p2++;
          while (p1 < n1 && nums1[p1] == nums1[p1 - 1])
            p1++;
          while (p2 < n2 && nums2[p2] == nums2[p2 - 1])
            p2++;
        } else if (nums1[p1] < nums2[p2]) {
          uniq1.add(nums1[p1]);
          p1++;
          while (p1 < n1 && nums1[p1] == nums1[p1 - 1])
            p1++;
        } else if (nums1[p1] > nums2[p2]) {
          uniq2.add(nums2[p2]);
          p2++;
          while (p2 < n2 && nums2[p2] == nums2[p2 - 1])
            p2++;
        }
      } else if (p1 < n1 && p2 >= n2) {
        uniq1.add(nums1[p1]);
        p1++;
        while (p1 < n1 && nums1[p1] == nums1[p1 - 1])
          p1++;
      } else if (p1 >= n1 && p2 < n2) {
        uniq2.add(nums2[p2]);
        p2++;
        while (p2 < n2 && nums2[p2] == nums2[p2 - 1])
          p2++;
      }
    }
    result.add(uniq1);
    result.add(uniq2);
    return result;
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
      System.out.println(findDifference(arr1, arr2));
    }
  }
}
