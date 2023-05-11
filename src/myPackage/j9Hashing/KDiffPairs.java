// Leetcode: 532 - K-diff Pairs in an Array

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KDiffPairs {

  static int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; i++)
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (k == 0 && entry.getValue() > 1)
        count++;
      else if (k != 0 && map.containsKey(entry.getKey() + k))
        count++;
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
      int diff = sc.nextInt();
      System.out.println(findPairs(arr, diff));
    }
  }
}
