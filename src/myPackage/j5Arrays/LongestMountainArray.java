// Leetcode: 845 - Longest Mountain in Array

package myPackage.j5Arrays;

import java.util.Scanner;

public class LongestMountainArray {

  static int longestMountain(int[] A) {
    int N = A.length;
    int ans = 0, base = 0;
    while (base < N) {
      int end = base;
      if (end + 1 < N && A[end] < A[end + 1]) {
        while (end + 1 < N && A[end] < A[end + 1])
          end++;
        if (end + 1 < N && A[end] > A[end + 1]) {
          while (end + 1 < N && A[end] > A[end + 1])
            end++;
          ans = Math.max(ans, end - base + 1);
        }
      }
      base = Math.max(end, base + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(longestMountain(arr));
    }
  }
}
