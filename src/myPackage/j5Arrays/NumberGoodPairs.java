// Given an array of integers nums, return the number of good pairs.
// A pair (i, j) is called good if nums[i] == nums[j] and i < j.

// Input: nums = [1,2,3,1,1,3]
// Output: 4
// Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

package myPackage.j5Arrays;

import java.util.Scanner;

public class NumberGoodPairs {

  static int numIdenticalPairsFast (int[] nums){
    int countPairs = 0;
    int[] count = new int[101];
    for (int n : nums)
      count[n]++;
    for (int n : count) {
      countPairs += n * (n - 1) / 2;
    }
    return countPairs;
  }
  
  static int numIdenticalPairsSlow(int[] nums){
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] == nums[j])
          count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(numIdenticalPairsSlow(arr));
      System.out.println(numIdenticalPairsFast(arr));
    }
  }
  
}
