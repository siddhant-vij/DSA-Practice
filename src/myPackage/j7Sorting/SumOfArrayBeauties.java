// Leetcode: 2012. Sum of Beauty in the Array

package myPackage.j7Sorting;

import java.util.Scanner;

public class SumOfArrayBeauties {

  static int sumOfBeauties(int[] nums) {
    int n = nums.length;
    int[] max = new int[n];
    max[0] = Integer.MAX_VALUE;
    max[1] = nums[0];
    for (int i = 2; i < n; i++)
      max[i] = Math.max(max[i - 1], nums[i - 1]);
    int[] min = new int[n];
    min[n - 1] = Integer.MIN_VALUE;
    min[n - 2] = nums[n - 1];
    for (int i = n - 3; i >= 0; i--)
      min[i] = Math.min(min[i + 1], nums[i + 1]);
    int sum = 0;
    for (int i = 1; i < n - 1; i++) {
      if (max[i] < nums[i] && nums[i] < min[i])
        sum += 2;
      else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1])
        sum += 1;
      else
        continue;
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
      System.out.println(sumOfBeauties(arr));
    }
  }  
}
