// Leetcode: 1679 - Max Number of K-Sum Pairs

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KSumPairs {

  static int maxOperations(int[] nums, int k) {
    int count = 0;
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(k - nums[i])) {
        count++;
        if (map.get(k - nums[i]) == 1)
          map.remove(k - nums[i]);
        else
          map.put(k - nums[i], map.get(k - nums[i]) - 1);
      } else
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
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
      int sum = sc.nextInt();
      System.out.println(maxOperations(arr, sum));
    }
  }
}
