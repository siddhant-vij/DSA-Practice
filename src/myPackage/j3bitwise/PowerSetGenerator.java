// Power Set Generator
// Leetcode: 78 - Subsets
// Leetcode: 90 - Subsets II

package myPackage.j3bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PowerSetGenerator {

  static List<List<Integer>> subsetsWithDups(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> results = new ArrayList<>();
    int max = (int) Math.pow(2, n);
    for (int i = 0; i < max; i++) {
      List<Integer> result = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0)
          result.add(nums[j]);
      }
      if (results.size() == 0)
        results.add(result);
      else {
        int count = 0;
        for (int k = 0; k < results.size(); k++) {
          if (result.equals(results.get(k)))
            count++;
        }
        if (count == 0)
          results.add(result);
      }
    }
    return results;
  }

  static List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> results = new ArrayList<>();
    int max = (int) Math.pow(2, n);
    for (int i = 0; i < max; i++) {
      List<Integer> result = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0)
          result.add(nums[j]);
      }
      results.add(result);
    }
    return results;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(subsets(arr));
      System.out.println(subsetsWithDups(arr));
    }
  }
}