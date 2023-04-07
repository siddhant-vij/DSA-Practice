// Given an array A, find the size of the smallest subarray such that
// it contains at least one occurrence of the maximum value of the array
// and at least one occurrence of the minimum value of the array.

package myPackage.j5Arrays;

import java.util.Scanner;

public class ClosestMinMaxSubArray {

  static int findMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max)
        max = arr[i];
    }
    return max;
  }

  static int findMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min)
        min = arr[i];
    }
    return min;
  }

  static int minMaxSubArray(int[] arr) {
    int min = findMin(arr);
    int max = findMax(arr);
    int minIndex = -1;
    int maxIndex = -1;
    int minLength = arr.length;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == max) {
        maxIndex = i;
        if (minIndex != -1)
          minLength = Math.min(minLength, Math.abs(maxIndex - minIndex));

      }
      if (arr[i] == min) {
        minIndex = i;
        if (maxIndex != -1)
          minLength = Math.min(minLength, Math.abs(maxIndex - minIndex));
      }
    }
    return minLength + 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(minMaxSubArray(arr));
    }
  }
}
