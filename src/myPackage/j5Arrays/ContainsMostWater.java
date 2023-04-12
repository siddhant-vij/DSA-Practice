// Leetcode: 11 - Container With Most Water

package myPackage.j5Arrays;

import java.util.Scanner;

public class ContainsMostWater {

  static int maxWaterFast(int[] arr) {
    int area = 0;
    int maxArea = Integer.MIN_VALUE;
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      area = (j - i) * (Math.min(arr[j], arr[i]));
      maxArea = Math.max(maxArea, area);
      if (arr[i] <= arr[j])
        i++;
      else
        j--;
    }
    return maxArea;
  }

  static int maxWaterSlow(int[] arr) {
    int area = 0;
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        area = (j - i) * (Math.min(arr[j], arr[i]));
        maxArea = Math.max(maxArea, area);
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      // System.out.println(maxWaterSlow(arr)); // O(N^2)
      System.out.println(maxWaterFast(arr)); // O(N)
    }
  }
}
