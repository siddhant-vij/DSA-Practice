// Leetcode: 349 - Intersection of Two Arrays
// Leetcode: 350 - Intersection of Two Arrays II

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IntersectionArrays {

  static int[] intersectionDups(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int p1 = 0;
    int p2 = 0;
    ArrayList<Integer> resultL = new ArrayList<>();
    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1] > nums2[p2])
        p2++;
      else if (nums1[p1] < nums2[p2])
        p1++;
      else {
        resultL.add(nums1[p1]);
        p1++;
        p2++;
      }
    }
    int[] result = new int[resultL.size()];
    for (int i = 0; i < resultL.size(); i++)
      result[i] = resultL.get(i);

    return result;
  }

  static int[] intersectionUnique(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int p1 = 0;
    int p2 = 0;
    ArrayList<Integer> resultL = new ArrayList<>();
    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1] > nums2[p2])
        p2++;
      else if (nums1[p1] < nums2[p2])
        p1++;
      else {
        resultL.add(nums1[p1]);
        p1++;
        p2++;
        while (p1 < nums1.length && nums1[p1] == nums1[p1 - 1])
          p1++;
        while (p2 < nums2.length && nums2[p2] == nums2[p2 - 1])
          p2++;
      }
    }
    int[] result = new int[resultL.size()];
    for (int i = 0; i < resultL.size(); i++)
      result[i] = resultL.get(i);

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
      System.out.println(Arrays.toString(intersectionUnique(arr1, arr2)));
      System.out.println(Arrays.toString(intersectionDups(arr1, arr2)));
    }
  }
}
