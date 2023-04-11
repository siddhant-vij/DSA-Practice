// Leetcode: 918 - Maximum Sum Circular Subarray

package myPackage.j5Arrays;

import java.util.Scanner;

public class MaxCircularSubArraySum {

  static int normalMax(int[] arr) {
    int temp = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (temp + arr[i] > arr[i])
        temp = temp + arr[i];
      else
        temp = arr[i];

      if (temp > max)
        max = temp;
    }
    return max;
  }

  static int normalMin(int[] arr) {
    int temp = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (temp + arr[i] < arr[i])
        temp = temp + arr[i];
      else
        temp = arr[i];

      if (temp < min)
        min = temp;
    }
    return min;
  }

  static int maxSubarraySumCircularFastII(int[] nums) {
    int normalMax = normalMax(nums);
    if (normalMax < 0)
      return normalMax;
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++) {
      totalSum += nums[i];
      nums[i] = -nums[i];
    }

    int circularMax = totalSum + normalMax(nums);
    return Math.max(normalMax, circularMax);
  }

  static int maxSubarraySumCircularFast1(int[] nums) {
    int normalMax = normalMax(nums);
    if (normalMax < 0)
      return normalMax;
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++)
      totalSum += nums[i];
    int circularMax = totalSum - normalMin(nums);
    return Math.max(normalMax, circularMax);
  }

  static int maxSubarraySumCircularSlowII(int[] nums) {
    int maxSum = nums[0];
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int sum = nums[i];
      int curMax = nums[i];
      for (int j = 1; j < n; j++) {
        int index = (i + j) % n;
        sum += nums[index];
        curMax = Math.max(curMax, sum);
      }
      maxSum = Math.max(maxSum, curMax);
    }
    return maxSum;
  }

  static int maxSubarraySumCircularSlowI(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += nums[j];
        maxSum = Math.max(maxSum, sum);
      }
    }
    for (int i = 1; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++)
        sum += nums[j];

      for (int j = 0; j < i; j++) {
        sum += nums[j];
        maxSum = Math.max(maxSum, sum);
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxSubarraySumCircularSlowI(arr)); // O(N^2)
      System.out.println(maxSubarraySumCircularSlowII(arr)); // O(N^2)
      System.out.println(maxSubarraySumCircularFast1(arr)); // O(N) - Kadane's Algo for Min & Max
      System.out.println(maxSubarraySumCircularFastII(arr)); // O(N) - Kadane's Algo for Max of Normal & Inverted
                                                             // Subarrays
    }
  }
}
