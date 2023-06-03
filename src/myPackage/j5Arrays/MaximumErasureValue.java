// Leetcode: 1695. Maximum Erasure Value

package myPackage.j5Arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumErasureValue {

  static int maximumUniqueSubarray(int[] nums) {
    int n = nums.length;
    int s = 0;
    int e = 0;
    int sum = 0;
    int maxSum = Integer.MIN_VALUE;
    Set<Integer> set = new HashSet<>();
    while (e < n) {
      if (!set.contains(nums[e])) {
        sum += nums[e];
        set.add(nums[e]);
        e++;
      } else {
        maxSum = Math.max(maxSum, sum);
        while (s < n && nums[s] != nums[e]) {
          set.remove(nums[s]);
          sum -= nums[s];
          s++;
        }
        if (nums[s] == nums[e]) {
          set.remove(nums[s]);
          sum -= nums[s];
        }
        s++;
      }
    }
    maxSum = Math.max(maxSum, sum);
    return maxSum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maximumUniqueSubarray(arr));
    }
  }  
}
