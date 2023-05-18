// Leetcode: 455. Assign Cookies

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class AssignCookies {

  static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int p1 = 0;
    int p2 = 0;
    int n1 = g.length;
    int n2 = s.length;
    while (p1 < n1 && p2 < n2) {
      if (s[p2] >= g[p1]) {
        p1++;
        p2++;
      } else
        p2++;
    }
    return p1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      int M = sc.nextInt();
      int[] arr2 = new int[M];
      for (int i = 0; i < M; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(findContentChildren(arr1, arr2));
    }
  }
}
