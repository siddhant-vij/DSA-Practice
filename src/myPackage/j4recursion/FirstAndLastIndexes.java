package myPackage.j4recursion;

import java.util.Scanner;

public class FirstAndLastIndexes {

  static int lastIndex(int[] nums, int idx, int target) {
    if (idx == 0) {
      return -1;
    }
    if (nums[idx] == target) {
      return idx;
    }
    return lastIndex(nums, idx - 1, target);
  }

  static int firstIndex(int[] nums, int idx, int target) {
    if (idx == nums.length) {
      return -1;
    }
    if (nums[idx] == target) {
      return idx;
    }
    return firstIndex(nums, idx + 1, target);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(firstIndex(arr, 0, k));
        System.out.println(lastIndex(arr, n - 1, k));
      }
    }
  }
}
