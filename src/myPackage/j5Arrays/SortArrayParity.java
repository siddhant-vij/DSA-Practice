// Leetcode 922

package myPackage.j5Arrays;

import java.util.Scanner;

public class SortArrayParity {

  static int[] sortArrayByParity(int[] nums) {
    int e = 1;
    int cur = 0;
    while (cur < nums.length - 1) {
      while (e < nums.length && nums[e] % 2 != 0)
        e += 2;

      if (nums[cur] % 2 != 0) {
        nums[e] ^= nums[cur];
        nums[cur] ^= nums[e];
        nums[e] ^= nums[cur];
      }
      cur += 2;
    }
    return nums;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(sortArrayByParity(arr));
    }
  }
}
