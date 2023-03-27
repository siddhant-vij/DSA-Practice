// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
// That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
// Return the answer in an array.

// Input: nums = [8,1,2,2,3]
// Output: [4,0,1,1,3]

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CountSmallerNumbers {

  static int[] smallerNumbersThanCurrent(int[] nums) {
    int[] count = new int[501];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    int[] prefix = new int[501];
    prefix[0] = 0;
    for (int i = 1; i < 501; i++) {
      prefix[i] = prefix[i - 1] + count[i - 1];
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = prefix[nums[i]];
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
  }
}
