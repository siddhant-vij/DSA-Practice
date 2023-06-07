// Leetcode: 2485. Find the Pivot Integer

package myPackage.j2maths;

import java.util.Scanner;

public class PivotInteger {

  static int pivotInteger(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = i + 1;
    int[] pf = new int[n];
    pf[0] = arr[0];
    int[] sf = new int[n];
    sf[n - 1] = arr[n - 1];
    for (int i = 1; i < n; i++)
      pf[i] = pf[i - 1] + arr[i];
    for (int i = n - 2; i >= 0; i--)
      sf[i] = sf[i + 1] + arr[i];
    for (int i = 0; i < n; i++) {
      if (pf[i] == sf[i])
        return i + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(pivotInteger(n));
    }
  }  
}
