// Leetcode: 2090. K Radius Subarray Averages

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KRadiusSubArrayAverages {

  static boolean isValid(int[] nums, int cur, int k) {
    return ((cur - k) >= 0 && (cur + k) < nums.length);
  }

  static int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    if (n < (2 * k + 1)) {
      int[] result = new int[n];
      Arrays.fill(result, -1);
      return result;
    }
    if (k == 0)
      return nums;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      if (!isValid(nums, i, k))
        result[i] = -1;
    }
    long sum = 0L;
    for (int i = 0; i < 2 * k + 1; i++)
      sum += 1L * nums[i];
    result[k] = (int) (sum / ((2 * k) + 1));

    for (int i = k + 1; i < n - k; i++) {
      sum = sum - 1L * nums[i - k - 1] + 1L * nums[i + k];
      result[i] = (int) (sum / ((2 * k) + 1));
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(Arrays.toString(getAverages(nums, k)));
    }
  }
}
