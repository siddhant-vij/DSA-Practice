// Leetcode: 523 - Continuous Subarray Sum

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContinuousSubArraySum {

  static boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> hashMap = new HashMap<>();
    int curSum = 0;
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (i != 0 && curSum % k == 0)
        return true;
      if (hashMap.containsKey(curSum % k) && (i - hashMap.get(curSum % k) >= 2))
        return true;
      if (!hashMap.containsKey(curSum % k))
        hashMap.put(curSum % k, i);
    }
    return false;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(checkSubarraySum(arr, k));
    }
  }  
}
