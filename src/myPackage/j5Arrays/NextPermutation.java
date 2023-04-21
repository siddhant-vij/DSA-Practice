// Leetcode: 31 - Next Permutation

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {

  static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  static void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  static void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      nextPermutation(arr);
      System.out.println(Arrays.toString(arr));
    }
  }
}
