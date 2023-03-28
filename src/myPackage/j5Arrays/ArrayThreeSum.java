// Leetcode 15
// Coding Ninjas 155

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayThreeSum {

  static List<List<Integer>> threeSum(int[] nums, int K) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1, k = nums.length - 1; j < k;) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == K) {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1])
            j++;
          while (j < k && nums[k] == nums[k + 1])
            k--;
        } else if (sum > K)
          k--;
        else
          j++;
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
      System.out.println(threeSum(arr,k));
    }
  }
}
