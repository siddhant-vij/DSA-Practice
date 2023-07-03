// Leetcode: 982. Triples with Bitwise AND Equal To Zero

package myPackage.j3bitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroAndTriplets {

  static int countTripletsII(int[] nums) {
    int n = nums.length;
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map.put((nums[i] & nums[j]), map.getOrDefault((nums[i] & nums[j]), 0) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      for (int i = 0; i < n; i++) {
        if ((entry.getKey() & nums[i]) == 0)
          res += entry.getValue();
      }
    }
    return res;
  }

  static int countTripletsI(int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if ((nums[i] & nums[j] & nums[k]) == 0)
            count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(countTripletsI(arr));
      System.out.println(countTripletsII(arr));
    }
  }
}
