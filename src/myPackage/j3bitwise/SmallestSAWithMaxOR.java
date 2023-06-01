// Leetcode: 2411. Smallest Subarrays With Maximum Bitwise OR

package myPackage.j3bitwise;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestSAWithMaxOR {

  static int[] smallestSubarrays(int[] A) {
    int n = A.length;
    int last[] = new int[30];
    int res[] = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      res[i] = 1;
      for (int j = 0; j < 30; j++) {
        if ((A[i] & (1 << j)) > 0)
          last[j] = i;
        res[i] = Math.max(res[i], last[j] - i + 1);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(smallestSubarrays(arr)));
    }
  }
}
