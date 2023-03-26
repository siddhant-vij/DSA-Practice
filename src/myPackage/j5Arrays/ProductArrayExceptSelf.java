// Given an integer array nums, return an array answer such that
// answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// Must write an algorithm that runs in O(n)time and without using the division operation.

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Constraints:
// 2<=nums.length<=10^5
// -30<=nums[i]<=30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// Can you solve the problem in O(1) extra space complexity?
// (The output array does not count as extra space for space complexity analysis.)


package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ProductArrayExceptSelf {

  static int[] productExceptSelfSpace(int[] arr) {
    int[] result = new int[arr.length];
    Arrays.fill(result, 1);
    int cur = 1;
    for (int i = 0; i < arr.length; i++) {
      result[i] *= cur;
      cur *= arr[i];
    }
    cur = 1;
    for (int i = arr.length-1; i >= 0; i--) {
      result[i] *= cur;
      cur *= arr[i];
    }
    return result;
  }

  static int[] productExceptSelfFast(int[] arr) {
    int[] result = new int[arr.length];
    int[] prefix = new int[arr.length];
    int[] suffix = new int[arr.length];
    prefix[0] = 1;
    suffix[arr.length-1] = 1;
    for (int i = 1; i < prefix.length; i++) {
      prefix[i] = prefix[i-1]*arr[i-1];
    }
    for (int i = suffix.length-2; i >= 0; i--) {
      suffix[i] = suffix[i+1]*arr[i+1];
    }
    for (int i = 0; i < result.length; i++) {
      result[i] = prefix[i]*suffix[i];
    }
    return result;
  }

  static int[] productExceptSelfSlow(int[] arr){
    int result[] = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      result[i] = 1;
      for (int j = 0; j < arr.length; j++) {
        if(i!=j)
          result[i] *= arr[j];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(productExceptSelfSlow(arr)));
      System.out.println(Arrays.toString(productExceptSelfFast(arr)));
      System.out.println(Arrays.toString(productExceptSelfSpace(arr)));
    }
  }
  
}
