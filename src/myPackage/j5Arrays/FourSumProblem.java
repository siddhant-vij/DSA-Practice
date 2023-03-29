// Leetcode 18

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FourSumProblem {

  static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i != 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < nums.length - 2; j++) {
        if ((j - i) != 1 && nums[j] == nums[j - 1])
          continue;
        for (int k = j + 1, l = nums.length - 1; k < l;) {
          long sum = 1L * nums[i] + 1L * nums[j] + 1L * nums[k] + 1L * nums[l];
          if (sum == target * 1L) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
            k++;
            l--;
            while (k < l && nums[k] == nums[k - 1])
              k++;
            while (k < l && nums[l] == nums[l + 1])
              l--;
          } else if (sum > target * 1L)
            l--;
          else
            k++;
        }
      }
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
      int k = sc.nextInt();
      System.out.println(fourSum(arr, k));
    }
  }
}
