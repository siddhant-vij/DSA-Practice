// Leetcode: 324 - Wiggle Sort II

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class WiggleSort {

  static void countSort(int[] arr) {
    int n = arr.length;
    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < n; i++) {
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
    for (int i = 0; i < n; i++) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    for (int i = 0; i < n; i++)
      arr[i] = output[i];
  }

  static void wiggleSort(int[] nums) {
    countSort(nums);
    int n = nums.length;
    int[] output = new int[n];
    int cur = n - 1;
    for (int i = 1; i < n; i += 2)
      output[i] = nums[cur--];

    for (int i = 0; i < n; i += 2)
      output[i] = nums[cur--];

    for (int i = 0; i < n; i++)
      nums[i] = output[i];
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(arr));
      wiggleSort(arr);
      System.out.println(Arrays.toString(arr));
    }
  }

}
