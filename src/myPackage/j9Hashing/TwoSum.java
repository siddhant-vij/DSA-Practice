// Leetcode: 1 - Two Sum

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

  static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(nums[i], i);

    for (int i = 0; i < n; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff) && map.get(diff) != i)
        return new int[] { i, map.get(diff) };
    }
    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(Arrays.toString(twoSum(arr, target)));
    }
  }
}
