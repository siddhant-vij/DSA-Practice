// Leetcode: 1337 - The K Weakest Rows in a Matrix

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
  int a1;
  int a2;

  Pair(int a1, int a2) {
    this.a1 = a1;
    this.a2 = a2;
  }

  @Override
  public int compareTo(Pair other) {
    return this.a1 - other.a1;
  }
}

public class KWeakestRows {

  static int count(int[] arr) {
    int n = arr.length;
    int s = 0;
    int e = n - 1;
    int result = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == 0) {
        result = m;
        e = m - 1;
      } else {
        s = m + 1;
      }
    }
    if (result == -1)
      return n;
    return result;
  }

  static int[] countOnes(int[][] mat) {
    int n = mat.length;
    int[] count = new int[n];
    for (int i = 0; i < n; i++) {
      count[i] = count(mat[i]);
    }
    return count;
  }

  static int[] kWeakestRows(int[][] mat, int k) {
    int[] count = countOnes(mat);
    int[] index = new int[count.length];
    for (int i = 0; i < count.length; i++)
      index[i] = i;

    Pair[] pairs = new Pair[count.length];
    for (int i = 0; i < pairs.length; i++) {
      pairs[i] = new Pair(count[i], index[i]);
    }
    Arrays.sort(pairs);

    for (int i = 0; i < count.length; i++) {
      count[i] = pairs[i].a1;
    }
    for (int i = 0; i < index.length; i++) {
      index[i] = pairs[i].a2;
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++)
      result[i] = index[i];

    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int[][] mat = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      int k = sc.nextInt();
      System.out.println(kWeakestRows(mat, k));
    }
  }
}
