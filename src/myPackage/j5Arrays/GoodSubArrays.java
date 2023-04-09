// Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
// 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
// 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
// Your task is to find the count of good subarrays in A.

// Problem Constraints
// 1 <= len(A) <= 10^3
// 1 <= A[i] <= 10^3
// 1 <= B <= 10^7

package myPackage.j5Arrays;

import java.util.Scanner;

public class GoodSubArrays {

  static int countGoodSubArrays(int[] A, int B) {
    int n = A.length;
    int sum = 0;
    int count = 0;
    for (int i = 1; i < n; i++)
      A[i] += A[i - 1];
    for (int s = 0; s < n; s++) {
      for (int e = s; e < n; e++) {
        int length = e - s + 1;
        if (s == 0)
          sum = A[e];
        else
          sum = A[e] - A[s - 1];

        if (length % 2 == 0 && sum < B)
          count++;
        else if (length % 2 != 0 && sum > B)
          count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(countGoodSubArrays(arr, k));
    }
  }
}
