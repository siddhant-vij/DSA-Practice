// Leetcode: 2461. Maximum Sum of Distinct Subarrays With Length K

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxSumDistinctKSubarray {

  static long maximumSubarraySum(int[] nums, int k) {
    long maxSum = 0L;
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    long sum = 0L;
    for (int i = 0; i < k; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      sum += 1L * nums[i];
    }
    if (map.size() == k)
      maxSum = 1L * sum;
    for (int i = k; i < n; i++) {
      if (map.get(nums[i - k]) == 1)
        map.remove(nums[i - k]);
      else
        map.put(nums[i - k], map.get(nums[i - k]) - 1);
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      sum += 1L * nums[i] - 1L * nums[i - k];
      if (map.size() == k) {
        maxSum = Math.max(maxSum, 1L * sum);
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(maximumSubarraySum(arr, k));
    }
  }  
}
