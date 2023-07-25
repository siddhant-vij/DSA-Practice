// Leetcode: 2007. Find Original Array From Doubled Array

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OriinalFromDoubled {

  static int[] findOriginalArray(int[] nums) {
    int n = nums.length;
    if (n % 2 != 0)
      return new int[] {};
    Arrays.sort(nums);
    Map<Double, Integer> map = new HashMap<>();
    map.put(nums[0] * 1.0, 1);
    int[] res = new int[n / 2];
    int idx = 0;
    for (int i = 1; i < n; i++) {
      if (map.containsKey(nums[i] / 2.0)) {
        res[idx++] = (int) (nums[i] / 2.0);
        if (map.get(nums[i] / 2.0) == 1)
          map.remove(nums[i] / 2.0);
        else
          map.put(nums[i] / 2.0, map.get(nums[i] / 2.0) - 1);
      } else {
        map.put(nums[i] * 1.0, map.getOrDefault(nums[i] * 1.0, 0) + 1);
      }
    }
    if (map.size() != 0)
      return new int[] {};
    else
      return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(findOriginalArray(arr)));
    }
  }  
}
