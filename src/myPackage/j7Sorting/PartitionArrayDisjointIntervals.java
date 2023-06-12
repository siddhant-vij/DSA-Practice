// Leetcode: 915. Partition Array into Disjoint Intervals

package myPackage.j7Sorting;

import java.util.Scanner;

public class PartitionArrayDisjointIntervals {

  static int partitionDisjoint(int[] nums) {
    int n = nums.length;
    int[] max = new int[n];
    max[0] = nums[0];
    for (int i = 1; i < n; i++)
      max[i] = Math.max(max[i - 1], nums[i]);
    int[] min = new int[n];
    min[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--)
      min[i] = Math.min(min[i + 1], nums[i]);
    for (int i = 0; i < n - 1; i++) {
      if (max[i] <= min[i + 1])
        return i + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      System.out.println(partitionDisjoint(arr1));
    }
  }  
}
