// Letcode: 220. Contains Duplicate III

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class IndexValuePairs implements Comparable<IndexValuePairs> {
  int index;
  int value;

  IndexValuePairs(int index, int value) {
    this.index = index;
    this.value = value;
  }

  @Override
  public int compareTo(IndexValuePairs other) {
    return this.value - other.value;
  }
}

public class ContainsNearbyDuplicates {

  static boolean containsNearbyAlmostDuplicate(int[] nums, int idx, int val) {
    int n = nums.length;
    if (nums == null || n < 2 || idx < 1 || val < 0) {
      return false;
    }
    IndexValuePairs[] pairs = new IndexValuePairs[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new IndexValuePairs(i, nums[i]);
    Arrays.sort(pairs);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n && Math.abs(1L * pairs[j].value - 1L * pairs[i].value) <= 1L * val; j++) {
        if (Math.abs(pairs[i].index - pairs[j].index) <= idx) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int idx = sc.nextInt();
      int val = sc.nextInt();
      System.out.println(containsNearbyAlmostDuplicate(arr, idx, val));
    }
  }
}
