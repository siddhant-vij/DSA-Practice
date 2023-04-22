// Leetcode: 611 - Valid Triangle Number

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ValidTriangleNumber {

  static int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int count = 0;
    for (int k = 2; k < n; k++) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          count += j - i;
          j--;
        } else {
          i++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      System.out.println(triangleNumber(nums));
    }
  }
}
