// Leetcode 1752: Check if Array Is Sorted and Rotated

package myPackage.j7Sorting;

import java.util.Scanner;

public class CheckIfSortedRotated {

  static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1])
        return false;
    }
    return true;
  }

  static void reverseArray(int[] arr, int left, int right) {
    while (left < right) {
      int temp = arr[right];
      arr[right] = arr[left];
      arr[left] = temp;
      left++;
      right--;
    }
  }

  static boolean checkIfSortedAndRotated(int[] nums) {
    int maxPos = -1;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (max < nums[i]) {
        max = nums[i];
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
          i++;
        }
        maxPos = i;
      }
    }
    reverseArray(nums, maxPos + 1, nums.length - 1);
    reverseArray(nums, 0, maxPos);
    reverseArray(nums, 0, nums.length - 1);
    return isSorted(nums);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(checkIfSortedAndRotated(arr));
    }
  }
}