// Leetcode: (768, 769) Max Chunks To Make Sorted

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MaxChunksToSortArray {

  static int maxChunksToSorted(int[] arr) {
    int n = arr.length;
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    int result = 0, sum1 = 0, sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += arr[i];
      sum2 += sorted[i];
      if (sum1 == sum2)
        result++;
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
      System.out.println(maxChunksToSorted(arr));
    }
  }  
}
