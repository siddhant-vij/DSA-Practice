// Leetcode 1389

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CreateTargetArray {

  static int[] targetArrayFaster(int[] nums, int[] index) {
    int[] result = new int[nums.length];
    for (int i = 0; i < index.length; i++) {
      System.arraycopy(result, index[i], result, index[i] + 1, nums.length - index[i] - 1);
      result[index[i]] = nums[i];
    }
    return result;
  }

  static int[] targetArrayFast(int[] nums, int[] index) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < index.length; i++) {
      list.add(index[i], nums[i]);
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < index.length; i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  static int[] targetArraySlow(int[] nums, int[] index) {
    int[] result = new int[nums.length];
    for (int i = 0; i < index.length; i++) {
      for (int j = nums.length - 2; j >= index[i]; j--) {
        result[j + 1] = result[j];
      }
      result[index[i]] = nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int[] arr2 = new int[m];
      for (int i = 0; i < m; i++) {
        arr2[i] = sc.nextInt();
      }
      // System.out.println(Arrays.toString(targetArraySlow(arr1,arr2)));
      // System.out.println(Arrays.toString(targetArrayFast(arr1, arr2)));
      System.out.println(Arrays.toString(targetArrayFaster(arr1, arr2)));
    }
  }
}
