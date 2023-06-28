// Leetcode: 1818. Minimum Absolute Sum Difference

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TwoNumsPair implements Comparable<TwoNumsPair> {
  int num1;
  int num2;

  TwoNumsPair(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  @Override
  public int compareTo(TwoNumsPair other) {
    return this.num1 - other.num1;
  }
}

public class MinAbsoluteSumDifference {

  static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
    int n = nums1.length;
    TwoNumsPair[] pairs = new TwoNumsPair[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new TwoNumsPair(nums1[i], nums2[i]);
    Arrays.sort(pairs);
    for (int i = 0; i < n; i++) {
      nums1[i] = pairs[i].num1;
      nums2[i] = pairs[i].num2;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (nums1[i] == nums2[i]) {
        map.put(i, 0);
      } else {
        int index = Arrays.binarySearch(nums1, nums2[i]);
        if (index >= 0) {
          map.put(i, 0);
        } else {
          index = -1 * (index + 1);
          if (index != 0 && index != n)
            map.put(i, Math.min(Math.abs(nums2[i] - nums1[index]), Math.abs(nums2[i] - nums1[index - 1])));
          else if (index == 0)
            map.put(i, Math.abs(nums2[i] - nums1[index]));
          else
            map.put(i, Math.abs(nums2[i] - nums1[index - 1]));
        }
      }
    }
    int maxDiff = 0;
    int index = -1;
    for (int i = 0; i < n; i++) {
      if (Math.abs(Math.abs(nums1[i] - nums2[i]) - map.get(i)) > maxDiff) {
        maxDiff = Math.abs(Math.abs(nums1[i] - nums2[i]) - map.get(i));
        index = i;
      }
    }
    int sum = 0;
    int mod = 1000_000_007;
    for (int i = 0; i < n; i++) {
      if (index != -1 && i == index)
        sum = (sum + map.get(i)) % mod;
      else
        sum = (sum + Math.abs(nums1[i] - nums2[i])) % mod;
    }
    return sum % mod;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      int[] arr2 = new int[n];
      for (int i = 0; i < n; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(minAbsoluteSumDiff(arr1, arr2));
    }
  }
}
