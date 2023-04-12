// Leetcode: 42 - Trapping Rain Water

package myPackage.j5Arrays;

import java.util.Scanner;

public class TrappingRainWater {

  static int getWaterSpace(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int lmax = 0;
    int rmax = 0;

    int res = 0;
    while (left < right) {
      lmax = Math.max(lmax, arr[left]);
      rmax = Math.max(rmax, arr[right]);

      if (lmax < rmax) {
        res += lmax - arr[left];
        left++;
      } else {
        res += rmax - arr[right];
        right--;
      }
    }
    return res;
  }

  static int getWaterFast(int[] arr) {
    int result = 0;
    int[] lmax = new int[arr.length];
    lmax[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      lmax[i] = Math.max(lmax[i - 1], arr[i]);
    }
    int[] rmax = new int[arr.length];
    rmax[arr.length - 1] = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      rmax[i] = Math.max(rmax[i + 1], arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      result += (Math.min(lmax[i], rmax[i]) - arr[i]);
    }
    return result;
  }

  static int getWaterSlow(int[] arr) {
    int result = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      int lmax = arr[i];
      for (int j = 0; j < i; j++) {
        lmax = Math.max(lmax, arr[j]);
      }
      int rmax = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        rmax = Math.max(rmax, arr[j]);
      }
      result += (Math.min(lmax, rmax) - arr[i]);
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
      System.out.println(getWaterSlow(arr)); // Naive - O(N^2)
      System.out.println(getWaterFast(arr)); // Prefix & Suffix Max - O(N) [Space - O(N)]
      System.out.println(getWaterSpace(arr)); // Two Pointers - O(N) [Space - O(1)]
    }
  }
}
