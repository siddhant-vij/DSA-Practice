// Given an array nums. We define a running sum of an array as 
// runningSum[i] = sum(nums[0]…nums[i]).
// Return the running sum of nums.

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RunningSum {

  static int[] runingSum(int[] arr){
    int[] sum = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if(i == 0)
        sum[i] = arr[i];
      else
        sum[i] = sum[i-1] + arr[i];
    }
    return sum;
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(runingSum(arr)));
    }
  }  
}
