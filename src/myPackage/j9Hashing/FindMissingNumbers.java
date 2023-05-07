// Leetcode: 448 - Find All Numbers Disappeared in an Array

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindMissingNumbers {

  static List<Integer> findDisappearedNumbersII(int[] nums) {
    int n = nums.length;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0)
        nums[index] = -1 * nums[index];
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0)
        result.add(i + 1);
    }
    return result;
  }

  static List<Integer> findDisappearedNumbersI(int[] nums) {
    int n = nums.length;
    Set<Integer> set = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++)
      set.add(nums[i]);
    for (int i = 1; i <= n; i++) {
      if (!set.contains(i))
        result.add(i);
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
      System.out.println(findDisappearedNumbersI(arr));
      System.out.println(findDisappearedNumbersII(arr));
    }
  }

}
