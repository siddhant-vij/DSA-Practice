// Leetcode: 1539 - Kth Missing Positive Number

package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class KthMissingPositiveNumber {

  static int findKthPositive(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] - mid <= k)
        left = mid + 1;
      else
        right = mid - 1;
    }
    return left + k;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      Arrays.sort(arr);
      System.out.println(findKthPositive(arr, k));
    }
  }  
}
