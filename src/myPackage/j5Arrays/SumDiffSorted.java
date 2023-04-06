// Leetcode: 1685 - Sum of Absolute Differences in a Sorted Array

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumDiffSorted {

  static int[] getSumAbsoluteDifferencesFast(int[] nums) {
    int[] result = new int[nums.length];
    int[] leftSum = new int[nums.length];
    int[] rightSum = new int[nums.length];
    leftSum[0] = 0;
    rightSum[nums.length - 1] = 0;
    for (int i = 1; i < nums.length; i++) {
      leftSum[i] = leftSum[i - 1] + nums[i - 1];
    }
    for (int i = nums.length - 2; i >= 0; i--) {
      rightSum[i] = rightSum[i + 1] + nums[i + 1];
    }
    for (int i = 0; i < result.length; i++) {
      result[i] = i * nums[i] - (result.length - 1 - i) * nums[i] + rightSum[i] - leftSum[i];
    }
    return result;
  }

  static int[] getSumAbsoluteDifferencesSlow(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i != j)
          result[i] += Math.abs(nums[i] - nums[j]);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(getSumAbsoluteDifferencesSlow(nums)));
      System.out.println(Arrays.toString(getSumAbsoluteDifferencesFast(nums)));
    }
  }
}
