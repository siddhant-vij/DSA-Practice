// Problem Description
// You are given an array A of N elements.
// Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]

// Problem Constraints
// 1<=N<=10^3
// 1<=A[i]<=10^9

package myPackage.j5Arrays;

import java.util.Scanner;

public class CountIncreasingTriplets {

  static int[] suffixMoreCount(int[] arr) {
    int n = arr.length;
    int[] sfCount = new int[n];
    sfCount[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      int count = 0;
      for (int j = n - 1; j > i; j--) {
        if (arr[j] > arr[i])
          count++;
      }
      sfCount[i] = count;
    }
    return sfCount;
  }

  static int[] prefixLessCount(int[] arr) {
    int n = arr.length;
    int[] pfCount = new int[n];
    pfCount[0] = 0;
    for (int i = 1; i < n; i++) {
      int count = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i])
          count++;
      }
      pfCount[i] = count;
    }
    return pfCount;
  }

  static int countTriplets(int[] A) {
    int sum = 0;
    int[] pfCount = prefixLessCount(A);
    int[] sfCount = suffixMoreCount(A);
    for (int i = 0; i < A.length; i++) {
      sum += pfCount[i] * sfCount[i];
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
      System.out.println(countTriplets(arr));
    }
  }
}
