// Leetcode: 1838. Frequency of the Most Frequent Element

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FreqOfMostFreqElement {

  static int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int result = 1, count = 1;
    for (int i = 1; i < nums.length; i++) {
      int sumK = 0;
      if (nums[i] == nums[i - 1])
        count++;
      else {
        count = 1;
        for (int j = i - 1; j >= 0; j--) {
          sumK += (nums[i] - nums[j]);
          if (sumK > k)
            break;
          count++;
        }
      }
      result = Math.max(result, count);
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
      int k = sc.nextInt();
      System.out.println(maxFrequency(arr, k));
    }
  }  
}
