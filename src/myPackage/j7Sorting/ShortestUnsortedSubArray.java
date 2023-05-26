// Leetcode: 581. Shortest Unsorted Continuous Subarray

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestUnsortedSubArray {

  static int findUnsortedSubarray(int[] nums) {
    int n = nums.length;
    int[] temp = new int[n];
    for (int i = 0; i < n; i++)
      temp[i] = nums[i];
    Arrays.sort(temp);
    int s = -1;
    int e = -1;
    for (int i = 0; i < n; i++) {
      if (nums[i] != temp[i]) {
        s = i;
        break;
      }
    }
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] != temp[i]) {
        e = i;
        break;
      }
    }
    return (s == -1 && e == -1) ? 0 : e - s + 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findUnsortedSubarray(arr));
    }
  }  
}
