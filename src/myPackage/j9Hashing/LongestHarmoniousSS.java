// Leetcode: 594. Longest Harmonious Subsequence

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestHarmoniousSS {

  static int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    for (int i = 0; i < n; i++)
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

    int maxLength = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i] - 1))
        maxLength = Math.max(maxLength, map.get(nums[i]) + map.get(nums[i] - 1));
      if (map.containsKey(nums[i] + 1))
        maxLength = Math.max(maxLength, map.get(nums[i]) + map.get(nums[i] + 1));
    }
    return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findLHS(arr));
    }
  }  
}
