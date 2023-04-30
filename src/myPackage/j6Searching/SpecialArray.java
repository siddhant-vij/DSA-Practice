// Leetcode: 1608 - Special Array With X Elements Greater Than or Equal X

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class SpecialArray {

  static int insertPos(int[] arr, int k) {
    int s = 0;
    int e = arr.length - 1;
    int result = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == k) {
        result = m;
        e = m - 1;
      } else if (arr[m] < k)
        s = m + 1;
      else
        e = m - 1;
    }
    return result == -1 ? s : result;
  }

  static int specialArray(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int max = nums[0];
    for (int i = 1; i < n; i++)
      max = Math.max(max, nums[i]);

    int s = 0;
    int e = max;
    while (s <= e) {
      int m = s + (e - s) / 2;
      int insPos = insertPos(nums, m);
      if (n - insPos == m)
        return m;
      else if (n - insPos > m)
        s = m + 1;
      else
        e = m - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(specialArray(arr));
    }
  }
}
