// Leetcode: 2364 - Count Number of Bad Pairs

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BadPairsCount {

  static long countBadPairs(int[] nums) {
    long count = 0L;
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int test = nums[i] - i;
      if (map.containsKey(test))
        count += (i - map.get(test));
      else
        count += i;
      map.put(test, map.getOrDefault(test, 0) + 1);
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
      System.out.println(countBadPairs(arr));
    }
  }  
}
