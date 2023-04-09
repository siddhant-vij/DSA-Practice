// Given an array A of N non-negative numbers and a non-negative number B,
// you need to find the number of subarrays in A with a sum less than B.
// We may assume that there is no overflow.

// Problem Constraints
// 1 <= N <= 10^3
// 1 <= A[i] <= 1000
// 1 <= B <= 10^7

package myPackage.j5Arrays;

import java.util.Scanner;

public class CountSubArraysLessSum {

  static int countSubArraysFast(int[] arr, int k) {
    int start = 0, end = 0;
    int count = 0, sum = arr[0];
    int n = arr.length;
    while (start < n && end < n) {
      System.out.println(start + " " + end + " " + sum + " " + count);
      if (sum < k) {
        end++;
        if (end >= start)
          count += end - start;
        if (end < n)
          sum += arr[end];
      } else {
        sum -= arr[start];
        start++;
      }
    }
    return count;
  }

  static int countSubArraysSlow(int[] A, int B) {
    int n = A.length;
    int count = 0;
    for (int s = 0; s < n; s++) {
      int sum = 0;
      for (int e = s; e < n; e++) {
        sum += A[e];
        if (sum < B)
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
      int B = sc.nextInt();
      System.out.println(countSubArraysSlow(arr, B));
      System.out.println(countSubArraysFast(arr, B));
    }
  }
}
