// Leetcode: 2134. Minimum Swaps to Group All 1's Together II

package myPackage.j5Arrays;

import java.util.Scanner;

public class MinSwapsToGroupAllOnes {

  static int minSwaps(int[] nums) {
    int n = nums.length;
    int k = 0;
    for (int i = 0; i < n; i++)
      k += (nums[i] == 1) ? 1 : 0;
    int count = 0;
    for (int i = 0; i < k; i++)
      count += (nums[i] == 0) ? 1 : 0;
    int minCount = count;
    for (int i = k; i < n + k; i++) {
      int addIdx = i % n;
      int remIdx = (i - k) % n;
      count += (nums[addIdx] == 0) ? 1 : 0;
      count -= (nums[remIdx] == 0) ? 1 : 0;
      minCount = Math.min(minCount, count);
    }
    return minCount;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(minSwaps(arr));
    }
  }  
}
