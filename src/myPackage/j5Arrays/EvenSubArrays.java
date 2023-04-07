// You are given an integer array A.
// Decide whether it is possible to divide the array into one or more subarrays
// of even length such that the first and last element of all subarrays will be even.
// Return "YES" if it is possible; otherwise, return "NO" (without quotes).

// Problem Constraints
// 1 <= |A|, A[i] <= 10^6

package myPackage.j5Arrays;

import java.util.Scanner;

public class EvenSubArrays {

  static String isEvenSubArrays(int[] A) {
    int n = A.length;
    if (A[0] % 2 == 0 && A[n - 1] % 2 == 0 && n % 2 == 0)
      return "YES";
    else
      return "NO";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(isEvenSubArrays(arr));
    }
  }
}
