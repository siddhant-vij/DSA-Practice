// Leetcode: 442

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllDuplicatesArray {

  static List<Integer> findDuplicatesPosition(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0)
        res.add(Math.abs(index + 1));
      nums[index] = -nums[index];
    }
    return res;
  }

  static List<Integer> findDuplicatesCount(int[] nums) {
    int[] count = new int[100001];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }
    List<Integer> arrL = new ArrayList<>();
    for (int i = 0; i < count.length; i++) {
      if (count[i] == 2)
        arrL.add(i);
    }
    return arrL;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findDuplicatesCount(arr));
      System.out.println(findDuplicatesPosition(arr));
    }
  }
}
