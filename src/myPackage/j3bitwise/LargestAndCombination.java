// Leetcode: 2275. Largest Combination With Bitwise AND Greater Than Zero

package myPackage.j3bitwise;

import java.util.Scanner;

public class LargestAndCombination {

  static int largestCombination(int[] nums) {
    int n = nums.length;
    int maxLength = 0;
    for (int i = 0; i <= 31; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (((nums[j] >> i) & 1) == 1)
          count++;
      }
      maxLength = Math.max(maxLength, count);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(largestCombination(arr));
    }
  }  
}
