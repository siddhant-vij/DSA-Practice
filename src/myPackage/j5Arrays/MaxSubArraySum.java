// You are given an integer array C of size A.
// Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
// But the sum must not exceed B.

// Problem Constraints
// 1 <= A <= 10^3
// 1 <= B <= 10^9
// 1 <= C[i] <= 10^6

package myPackage.j5Arrays;

import java.util.Scanner;

public class MaxSubArraySum {

  static int maxSubArrayFast(int A, int B, int[] C) {
    int start = 0;
    int end = 0;
    int sum = 0;
    int max = 0;
    while (end < A) {
      if (sum + C[end] <= B) {
        sum += C[end];
        max = Math.max(max, sum);
      } else {
        if (sum == 0) {
          end++;
          continue;
        } else {
          sum -= C[start];
          start++;
          continue;
        }
      }
      end++;
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
    }
  }
}
