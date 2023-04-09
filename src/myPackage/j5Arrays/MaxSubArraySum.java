// You are given an integer array C of size A.
// Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
// But the sum must not exceed B.

// Problem Constraints
// 1 <= A <= 10^3
// 1 <= B <= 10^9
// 1 <= C[i] <= 10^6

// Code Update: Subarray Sum Equals Target - Return First Indices
// Given a non-empty array nums contains positive integers and a positive integer target.
// Find the first subarray in nums that sums up to target and return the begin and end index of this subarray.
// If there is no such subarray, return [-1, -1].

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubArraySum {

  static int[] maxSubArrayIndex(int A, int B, int[] C) {
    int start = 0;
    int end = 0;
    int sum = 0;
    int[] index = new int[2];
    index[0] = -1;
    index[1] = -1;
    while (end < A) {
      if (sum + C[end] < B) {
        sum += C[end];
        end++;
      } else if (sum + C[end] > B) {
        if (sum == 0) {
          end++;
        } else {
          sum -= C[start];
          start++;
        }
      } else {
        index[0] = start;
        index[1] = end;
        break;
      }
    }
    return index;
  }

  static int maxSubArrayFast(int A, int B, int[] C) {
    int start = 0;
    int end = 0;
    int sum = 0;
    int max = 0;
    while (end < A) {
      if (sum + C[end] <= B) {
        sum += C[end];
        max = Math.max(max, sum);
        end++;
      } else {
        if (sum == 0) {
          end++;
        } else {
          sum -= C[start];
          start++;
        }
      }
    }
    return max;
  }

  static int maxSubArraySlow(int A, int B, int[] C) {
    int maxSum = 0;
    for (int i = 0; i < A; i++) {
      int sum = 0;
      for (int j = i; j < A; j++) {
        sum += C[j];
        if (sum <= B)
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
      int B = sc.nextInt();
      System.out.println(maxSubArraySlow(arr.length, B, arr));
      System.out.println(maxSubArrayFast(arr.length, B, arr));
      System.out.println(Arrays.toString(maxSubArrayIndex(arr.length, B, arr)));
    }
  }
}
