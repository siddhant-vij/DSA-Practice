// Leetcode: 152 - Maximum Product Subarray

package myPackage.j5Arrays;

import java.util.Scanner;

public class MaxProductSubArray {

  static int maxProduct(int[] nums) {
    int n = nums.length;
    int l = 1, r = 1;
    int ans = nums[0];

    for (int i = 0; i < n; i++) {
      l = l == 0 ? 1 : l;
      r = r == 0 ? 1 : r;

      l *= nums[i];
      r *= nums[n - 1 - i];

      ans = Math.max(ans, Math.max(l, r));

    }

    return ans;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxProduct(arr));
    }
  }  
}
