// Leetcode: 1630. Arithmetic Subarrays

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArithmeticSubArrays {

  static boolean isPossible(int[] arr) {
    Arrays.sort(arr);
    Set<Integer> set = new HashSet<>();
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      set.add(arr[i + 1] - arr[i]);
      if (set.size() > 1)
        return false;
    }
    return true;
  }

  static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    int m = l.length;
    List<Boolean> result = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int[] arr = new int[r[i] - l[i] + 1];
      for (int j = l[i]; j <= r[i]; j++)
        arr[j - l[i]] = nums[j];
      result.add(isPossible(arr));
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      int M = sc.nextInt();
      int[] arr2 = new int[M];
      for (int i = 0; i < M; i++) {
        arr2[i] = sc.nextInt();
      }
      int[] arr3 = new int[M];
      for (int i = 0; i < M; i++) {
        arr3[i] = sc.nextInt();
      }
      System.out.println(checkArithmeticSubarrays(arr1, arr2, arr3));
    }
  }

}
