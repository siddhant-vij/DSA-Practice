// Leetcode: 1356 - Sort Integers by The Number of 1 Bits

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortByBits {

  static int[] sortByBits(int[] A) {
    int n = A.length;
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++)
      arr[i] = A[i];
    Arrays.sort(arr, new Comparator<Integer>() {
      int countBits(int n) {
        int count = 0;
        while (n != 0) {
          count++;
          n = n & (n - 1);
        }
        return count;
      }

      @Override
      public int compare(Integer a, Integer b) {
        int cntA = countBits(a);
        int cntB = countBits(b);
        if (cntA > cntB)
          return 1;
        else if (cntA < cntB)
          return -1;
        else {
          if (a > b)
            return 1;
          else if (a < b)
            return -1;
          else
            return 0;
        }
      }
    });
    for (int i = 0; i < n; i++)
      A[i] = arr[i];
    return A;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(sortByBits(arr)));
    }
  }

}
