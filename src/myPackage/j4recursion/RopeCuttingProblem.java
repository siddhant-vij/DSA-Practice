// Problem Statement:
// Given a rope of length n, you need to find the maximum number of pieces
// you can make from rope cutting such that the length of every piece is in set {a, b, c} for
// the given three values a, b, c where 0 < a,b,c <= n.

//Input: n=5, a=2, b=5, c=1
//Output: 5

//Better solution using DP.

package myPackage.j4Recursion;

import java.util.*;

public class RopeCuttingProblem {

  static int ropeCutMaxCount(int n, int a, int b, int c) {
    if (n == 0)
      return 0;
    if (n < 0)
      return -1;

    int result = Math.max(Math.max(ropeCutMaxCount(n - a, a, b, c), ropeCutMaxCount(n - b, a, b, c)),
        ropeCutMaxCount(n - c, a, b, c));
    if (result == -1)
      return -1;
    return result + 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      System.out.println(ropeCutMaxCount(n, a, b, c));
    }
  }
}
