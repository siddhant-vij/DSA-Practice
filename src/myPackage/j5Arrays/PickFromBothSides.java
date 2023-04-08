// You are given an integer array A of size N.
// You have to pick B elements in total. Some (possibly 0) elements from left end of array A
// and some (possibly 0) from the right end of array A to get the maximum sum.

// Find and return this maximum possible sum.

// NOTE: Suppose B = 4, and array A contains 10 elements, then
// You can pick the first four elements or can pick the last four elements,
// or can pick 1 from front and 3 from the back, etc.
// You need to return the maximum possible sum of elements you can pick.

// Problem Constraints
// 1 <= N <= 10^5
// 1 <= B <= N
// -10^3 <= A[i] <= 10^3

package myPackage.j5Arrays;

import java.util.Scanner;

public class PickFromBothSides {

  static int maxPossibleSum(int[] A, int B) {
    int n = A.length;
    int curSum = 0;
    int maxSum = 0;
    for (int i = 0; i < B; i++) {
      curSum += A[i];
    }

    maxSum = curSum;
    int j = n - 1;
    for (int i = B - 1; i >= 0; i--) {
      curSum = curSum + A[j] - A[i];
      maxSum = Math.max(curSum, maxSum);
      j--;
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
      System.out.println(maxPossibleSum(arr, B));
    }
  }
}
