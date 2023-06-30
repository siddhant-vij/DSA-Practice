// Leetcode: 1574. Shortest Subarray to be Removed to Make Array Sorted

package myPackage.j7Sorting;

import java.util.Scanner;

public class RemoveShortestArraySorting {

  static int findLengthOfShortestSubarray(int[] arr) {
    int n = arr.length;
    int left = 0;
    while (left < n - 1 && arr[left] <= arr[left + 1])
      left++;
    if (left == n - 1)
      return 0;

    int right = n - 1;
    while (right > left && arr[right - 1] <= arr[right])
      right--;

    int minLength = Math.min(n - left - 1, right);
    int i = 0;
    int j = right;
    while (i <= left && j < n) {
      if (arr[j] >= arr[i]) {
        minLength = Math.min(minLength, j - i - 1);
        i++;
      } else {
        j++;
      }
    }
    return minLength;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findLengthOfShortestSubarray(arr));
    }
  }
}
