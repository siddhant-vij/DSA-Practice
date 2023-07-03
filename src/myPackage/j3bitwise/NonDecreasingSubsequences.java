// Leetcode: 491. Non-decreasing Subsequences

package myPackage.j3bitwise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NonDecreasingSubsequences {

  static List<List<Integer>> findSubsequences(int[] nums) {
    int n = nums.length;
    Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < 1 << n; i++) {
      List<Integer> test = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (((i >> j) & 1) == 1) {
          test.add(nums[j]);
        }
      }
      if (test.size() >= 2) {
        boolean flag = true;
        for (int k = 1; k < test.size(); k++) {
          if (test.get(k) < test.get(k - 1))
            flag = false;
        }
        if (flag) {
          result.add(test);
        }
      }
    }
    return new ArrayList<>(result);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findSubsequences(arr));
    }
  }
}
