// Leetcode: 1588. Sum of All Odd Length Subarrays

package myPackage.j5Arrays;

import java.util.Scanner;

public class OddLengthSubarraySum {

  static int prefixWindowSum(int[] pf, int left, int right) {
    if (left == 0)
      return pf[right];
    else
      return pf[right] - pf[left - 1];
  }

  static int sumOddLengthSubarraysPS(int[] arr) {
    int sum = 0;
    int[] pf = new int[arr.length];
    pf[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      pf[i] = pf[i - 1] + arr[i];
    }

    for (int i = 0; i < arr.length; i++)
      for (int j = 0; j + i < arr.length; j += 2)
        sum += prefixWindowSum(pf, i, j + i);
    return sum;
  }

  static int windowSum(int[] arr, int k) {
    int maxSum = 0;
    for (int i = 0; i < k; i++)
      maxSum += arr[i];

    int windowSum = maxSum;
    for (int i = k; i < arr.length; i++) {
      windowSum += (arr[i] - arr[i - k]);
      maxSum += windowSum;
    }
    return maxSum;
  }

  static int sumOddLengthSubarraysSW(int[] arr) {
    int sum = 0;
    for (int i = 1; i <= arr.length; i++) {
      if ((i & 1) != 0)
        sum += windowSum(arr, i);
    }
    return sum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(sumOddLengthSubarraysSW(arr));
      System.out.println(sumOddLengthSubarraysPS(arr));
    }
  }
}
