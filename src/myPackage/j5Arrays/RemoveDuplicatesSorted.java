// Leetcode - 26: Remove Duplicates from Sorted Array
// Leetcode - 80: Remove Duplicates from Sorted Array II

package myPackage.j5Arrays;

import java.util.Scanner;

public class RemoveDuplicatesSorted {

  static int removeDuplicatesII(int[] nums) {
    int cur = 2;
    int count = 2;
    while (cur < nums.length) {
      if (nums[cur] > nums[count - 2]) {
        nums[count] = nums[cur];
        count++;
      }
      cur++;
    }
    return count;
  }

  static int removeDuplicatesI(int[] arr) {
    int unique = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[unique]) {
        unique++;
        arr[unique] = arr[i];
      }
    }
    return unique + 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(removeDuplicatesI(arr));
      System.out.println(removeDuplicatesII(arr));
    }
  }
}
