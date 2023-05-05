// Leetcode: 215 - Kth Largest Element in an Array

package myPackage.j7Sorting;

import java.util.Scanner;

public class KthLargestElement {

  static void countSort(int[] arr) {
    int n = arr.length;
    int min = arr[0];
    int max = arr[0];
    for (int i = 0; i < n; i++) {
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }
    int range = max - min + 1;
    int[] count = new int[range];
    for (int i = 0; i < n; i++)
      count[arr[i] - min]++;

    for (int i = 1; i < range; i++)
      count[i] += count[i - 1];

    int[] output = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    for (int i = 0; i < n; i++)
      arr[i] = output[i];
  }

  static int findKthLargest(int[] nums, int k) {
    countSort(nums);
    return nums[nums.length - k];
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(findKthLargest(arr, k));
    }
  }

}
