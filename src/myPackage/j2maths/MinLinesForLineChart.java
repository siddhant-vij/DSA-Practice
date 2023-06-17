// Leetcode: 2280. Minimum Lines to Represent a Line Chart

package myPackage.j2maths;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinLinesForLineChart {

  static int minimumLines(int[][] stockPrices) {
    final int n = stockPrices.length;
    if (n < 2) {
      return 0;
    }
    Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
    int count = 1;
    for (int i = 2; i < n; i++) {
      int[] a = stockPrices[i - 2];
      int[] b = stockPrices[i - 1];
      int[] c = stockPrices[i];
      if ((long) (b[1] - a[1]) * (c[0] - b[0]) != (long) (b[0] - a[0]) * (c[1] - b[1])) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[][] mat = new int[n][2];
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < 2; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(minimumLines(mat));
    }
  }
}
