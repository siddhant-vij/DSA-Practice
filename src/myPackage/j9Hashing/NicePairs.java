// Leetcode: 1814 - Count Nice Pairs in an Array

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NicePairs {

  static int reverseNum(int n) {
    int num = 0;
    while (n != 0) {
      num = num * 10 + n % 10;
      n /= 10;
    }
    return num;
  }

  static void reverseAndDiff(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++)
      nums[i] = nums[i] - reverseNum(nums[i]);
  }

  static int countNicePairs(int[] nums) {
    reverseAndDiff(nums);
    int n = nums.length;
    int count = 0;
    int mod = 1000_000_007;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i]))
        count = (count + map.get(nums[i])) % mod;
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    return count % mod;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(countNicePairs(arr));
    }
  }
}
