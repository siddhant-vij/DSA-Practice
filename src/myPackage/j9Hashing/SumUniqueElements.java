// Leetcode: 1748. Sum of Unique Elements

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumUniqueElements {

  static int sumOfUnique(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (map.get(nums[i]) == 1)
        sum += nums[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(sumOfUnique(arr));
    }
  }
}
