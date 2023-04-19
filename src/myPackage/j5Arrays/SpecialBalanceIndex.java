// Leetcode: 1664 - Ways to Make a Fair Array

package myPackage.j5Arrays;

import java.util.Scanner;

public class SpecialBalanceIndex {

  static int countSpecialIndexII(int[] A) {
    int count = 0;
    int n = A.length;
    int left[] = new int[2];
    int right[] = new int[2];
    for (int i = 0; i < n; i++)
      right[i % 2] += A[i];
    for (int i = 0; i < n; i++) {
      right[i % 2] -= A[i];
      if (left[0] + right[1] == left[1] + right[0])
        count++;
      left[i % 2] += A[i];
    }
    return count;
  }

  static int[] prefixEvenSum(int[] arr) {
    int n = arr.length;
    int[] pf = new int[n];
    pf[0] = arr[0];
    for (int i = 1; i < n; i++) {
      if ((i & 1) == 0)
        pf[i] = pf[i - 1] + arr[i];
      else
        pf[i] = pf[i - 1];
    }
    return pf;
  }

  static int[] prefixOddSum(int[] arr) {
    int n = arr.length;
    int[] pf = new int[n];
    pf[0] = 0;
    for (int i = 1; i < n; i++) {
      if ((i & 1) != 0)
        pf[i] = pf[i - 1] + arr[i];
      else
        pf[i] = pf[i - 1];
    }
    return pf;
  }

  static int countSpecialIndexI(int[] A) {
    int[] pfEven = prefixEvenSum(A);
    int[] pfOdd = prefixOddSum(A);
    int count = 0;
    int n = A.length;
    for (int i = 0; i < n; i++) {
      int sumEven = 0;
      int sumOdd = 0;
      if (i == 0) {
        sumEven = pfOdd[n - 1] - pfOdd[0];
        sumOdd = pfEven[n - 1] - pfEven[0];
        if (sumEven == sumOdd)
          count++;
      } else {
        sumEven = pfEven[i - 1] + pfOdd[n - 1] - pfOdd[i];
        sumOdd = pfOdd[i - 1] + pfEven[n - 1] - pfEven[i];
        if (sumEven == sumOdd)
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
      System.out.println(countSpecialIndexI(arr));
      System.out.println(countSpecialIndexII(arr));
    }
  }
}
