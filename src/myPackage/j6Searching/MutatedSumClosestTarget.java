// Leetcode: 1300. Sum of Mutated Array Closest to Target

package myPackage.j6Searching;

import java.util.Scanner;

public class MutatedSumClosestTarget {

  static int findSum(int[] arr, int k) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > k)
        sum += k;
      else
        sum += arr[i];
    }
    return sum;
  }

  static int findClosestSum(int[] arr, int target, int s, int e) {
    int result = Integer.MAX_VALUE;
    int minDiff = Integer.MAX_VALUE;
    while (s <= e) {
      int m = s + (e - s) / 2;
      int sum = findSum(arr, m);
      int diff = Math.abs(target - sum);
      if (sum == target) {
        return m;
      } else if (sum > target) {
        if (diff <= minDiff) {
          if (diff == minDiff)
            result = Math.min(result, m);
          else
            result = m;
          minDiff = diff;
        }
        e = m - 1;
      } else {
        if (diff <= minDiff) {
          if (diff == minDiff)
            result = Math.min(result, m);
          else
            result = m;
          minDiff = diff;
        }
        s = m + 1;
      }
    }
    return result;
  }

  static int findBestValue(int[] arr, int target) {
    int n = arr.length;
    int min = 0;
    int max = arr[0];
    for (int i = 1; i < n; i++)
      max = Math.max(max, arr[i]);

    return findClosestSum(arr, target, min, max);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(findBestValue(arr, target));
    }
  }
}
