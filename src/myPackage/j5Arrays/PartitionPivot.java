// Leetcode: 2161 - Partition Array According to Given Pivot

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionPivot {

  static int[] pivotArray(int[] nums, int pivot) {
    int n = nums.length;
    int[] result = new int[n];
    int ks = 0;
    int ke = n - 1;
    for (int i = 0; i < n; i++) {
      if (nums[i] < pivot)
        result[ks++] = nums[i];
    }
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] > pivot)
        result[ke--] = nums[i];
    }
    for (int i = ks; i <= ke; i++) {
      result[i] = pivot;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int pivot = sc.nextInt();
      System.out.println(Arrays.toString(pivotArray(arr, pivot)));
    }
  }
}
