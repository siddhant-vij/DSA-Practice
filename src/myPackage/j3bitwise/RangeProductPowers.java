// Leetcode: 2438. Range Product Queries of Powers

package myPackage.j3bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RangeProductPowers {

  static int[] powers(int n) {
    String str = Integer.toBinaryString(n);
    int x = str.length();
    int pow = 1;
    List<Integer> list = new ArrayList<>();
    for (int i = x - 1; i >= 0; i--) {
      if (str.charAt(i) == '1')
        list.add(pow);
      pow = 2 * pow;
    }
    int size = list.size();
    int[] powers = new int[size];
    for (int i = 0; i < size; i++)
      powers[i] = list.get(i);
    return powers;
  }

  static int[] productQueries(int n, int[][] queries) {
    int[] powers = powers(n);
    int mod = 1000_000_007;
    n = queries.length;
    int[] result = new int[n];
    Arrays.fill(result, 1);
    for (int i = 0; i < n; i++) {
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        result[i] = (int) ((1L * result[i] * powers[j]) % mod);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int k = sc.nextInt();
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < 2; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      System.out.println(productQueries(k, arr));
    }
  }
}
