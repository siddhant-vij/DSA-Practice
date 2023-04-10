// Leetcode: 53 - Maximum Subarray

package myPackage.j5Arrays;

import java.util.Scanner;

public class MaxSumKadane {

  static void maxSubArraySum(int a[]) {
    int temp = 0;
    int max = Integer.MIN_VALUE;
    int start = 0, end = 0, s = 0;

    for (int i = 0; i < a.length; i++) {
      if (temp + a[i] > a[i]) {
        temp = temp + a[i];
      } else {
        temp = a[i];
        s = i;
      }
      if (temp > max) {
        max = temp;
        start = s;
        end = i;
      }
    }
    System.out.println("Maximum contiguous sum is " + max);
    System.out.println("Starting index " + start);
    System.out.println("Ending index " + end);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      maxSubArraySum(arr);
    }
  }
}
