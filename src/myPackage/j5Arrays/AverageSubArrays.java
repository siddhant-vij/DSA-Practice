// Leetcode: 1343 - Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

package myPackage.j5Arrays;

import java.util.Scanner;

public class AverageSubArrays {

  static int numOfSubarrays(int[] arr, int k, int threshold) {
    int count = 0;
    int sum = 0;
    double average = 0.0;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }
    average = sum * 1.0 / k;
    if (average >= threshold)
      count++;

    for (int i = k; i < arr.length; i++) {
      sum += arr[i] - arr[i - k];
      average = sum * 1.0 / k;
      if (average >= threshold)
        count++;
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
      int threshold = sc.nextInt();
      System.out.println(numOfSubarrays(arr, k, threshold));
    }
  }
}
