// Leetcode 16

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayThreeSumClosest {

  static int threeSumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    int sumF = 0;
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      if (i != 0 && arr[i] == arr[i - 1])
        continue;
      for (int j = i + 1, k = arr.length - 1; j < k;) {
        int sum = arr[i] + arr[j] + arr[k];
        if (Math.abs(sum - target) < Math.abs(diff)) {
          diff = Math.abs(sum - target);
          sumF = sum;
        }
        if (sum > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return sumF;
  }

  static int threeSumClosestTLE(int[] arr, int target) {
    Arrays.sort(arr);
    int sumF = 0;
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = i + 1; j < arr.length - 1; j++) {
        for (int k = i + 2; k < arr.length; k++) {
          int sum = arr[i] + arr[j] + arr[k];
          if (Math.abs(sum - target) < diff) {
            diff = Math.abs(sum - target);
            sumF = sum;
          }
        }
      }
    }
    return sumF;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(threeSumClosestTLE(arr, target));
      System.out.println(threeSumClosest(arr, target));
    }
  }
}
