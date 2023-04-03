// Leetcode: 1829 - Maximum XOR for Each Query

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxXorQueries {

  static int[] getMaximumXor(int[] nums, int maximumBit) {
    int[] pfXor = new int[nums.length];
    pfXor[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      pfXor[i] = pfXor[i - 1] ^ nums[i];
    }
    int[] result = new int[nums.length];
    int point = pfXor.length - 1;
    while (point > -1) {
      result[pfXor.length - 1 - point] = (int) Math.pow(2, maximumBit) - 1 - pfXor[point];
      point--;
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
      int bits = sc.nextInt();
      System.out.println(Arrays.toString(getMaximumXor(arr, bits)));
    }
  }
}
