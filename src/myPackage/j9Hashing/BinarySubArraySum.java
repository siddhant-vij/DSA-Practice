// Leetcode: 930. Binary Subarrays With Sum

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySubArraySum {

  static int numSubarraysWithSum(int[] nums, int goal) {
    int n = nums.length;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (sum == goal)
        count++;
      if (map.containsKey(sum - goal))
        count += map.get(sum - goal);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(numSubarraysWithSum(arr, k));
    }
  }  
}
