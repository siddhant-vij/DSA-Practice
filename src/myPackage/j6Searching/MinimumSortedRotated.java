// Leetcode: 153 - Find Minimum in Rotated Sorted Array
// Leetcode: 154 - Find Minimum in Rotated Sorted Array II

package myPackage.j6Searching;

import java.util.Scanner;

public class MinimumSortedRotated {

  static int findMinDuplicate(int[] nums) {
    int n = nums.length;
    int s = 0;
    int e = n - 1;
    while (s <= n) {
      int m = s + (e - s) / 2;
      if (s == e)
        return nums[s];
      else if (m != n - 1 && nums[m] > nums[m + 1])
        return nums[m + 1];
      else if (nums[m] > nums[e])
        s = m + 1;
      else if (nums[m] < nums[e])
        e = m;
      else
        e--;
    }
    return -1;
  }

  static int findMin(int[] nums) {
    int n = nums.length;
    int s = 0;
    int e = n - 1;
    while (s <= n) {
      int m = s + (e - s) / 2;
      if (s == e)
        return nums[s];
      else if (m != n - 1 && nums[m] > nums[m + 1])
        return nums[m + 1];
      else if (nums[m] > nums[e])
        s = m + 1;
      else
        e = m;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findMin(arr));
      System.out.println(findMinDuplicate(arr));
    }
  }
}
