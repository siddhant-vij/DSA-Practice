// Leetcode: 525. Contiguous Array

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContiguousArray {

  static int findMaxLength(int[] nums) {
    int n = nums.length;
    if (n == 1)
      return 0;
    for (int i = 0; i < n; i++)
      nums[i] = nums[i] == 0 ? -1 : nums[i];
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int maxLength = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (sum == 0) {
        maxLength = Math.max(maxLength, i + 1);
      } else if (map.containsKey(sum)) {
        maxLength = Math.max(maxLength, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
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
      System.out.println(findMaxLength(arr));
    }
  }
}
