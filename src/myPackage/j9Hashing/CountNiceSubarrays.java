// Leetcode: 1248. Count Number of Nice Subarrays

package myPackage.j9Hashing;

import java.util.Scanner;
import java.util.TreeMap;

public class CountNiceSubarrays {

  static int numberOfSubarrays(int[] nums, int k) {
    int n = nums.length;
    int s = 0;
    int e = 0;
    int count = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int result = 0;
    while (e < n) {
      if (nums[e] % 2 != 0) {
        count++;
        if (count <= k)
          map.put(e, nums[e]);
      }
      if (nums[e] % 2 == 0 || nums[e] % 2 != 0 && count <= k)
        e++;
      else {
        result += (map.firstKey() + 1 - s) * (e - map.lastKey());
        while (s != map.firstKey())
          s++;
        map.remove(map.firstEntry().getKey());
        s++;
        count -= 2;
      }
    }
    if (count == k) {
      result += (map.firstKey() + 1 - s) * (e - map.lastKey());
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(numberOfSubarrays(arr, k));
    }
  }
}
