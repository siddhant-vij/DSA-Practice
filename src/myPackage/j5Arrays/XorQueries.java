// Leetcode: 1310 - XOR Queries of a Subarray

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class XorQueries {

  static int[] xorQueries(int[] arr, int[][] queries) {
    int[] pfXor = new int[arr.length];
    pfXor[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      pfXor[i] = pfXor[i - 1] ^ arr[i];
    }
    int[] result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int left = queries[i][0];
      int right = queries[i][1];
      if (left == 0)
        result[i] = pfXor[right];
      else
        result[i] = pfXor[right] ^ pfXor[left - 1];
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
      int x = sc.nextInt();
      int[][] queries = new int[x][2];
      for (int i = 0; i < x; i++) {
        for (int j = 0; j < 2; j++) {
          queries[i][j] = sc.nextInt();
        }
      }
      System.out.println(Arrays.toString(xorQueries(arr, queries)));
    }
  }
}
