// Pepcoding: Reduce N To 1

package myPackage.j3bitwise;

import java.util.Scanner;

public class ReduceNTo1 {

  static int solveIterative(int n) {
    int count = 0;
    while (n != 1) {
      if ((n & 1) == 0) {
        n /= 2;
      } else if (n == 3) {
        count += 2;
        break;
      } else if ((n & 3) == 1) {
        n = n - 1;
      } else if ((n & 3) == 3) {
        n = n + 1;
      }
      count++;
    }
    return count;
  }

  static int helper(long n, int steps) {
    if (n == 1)
      return steps;
    if (n == 3)
      return steps + 2;
    if (n % 4 == 0)
      return helper(n / 2, steps + 1);
    else if (n % 4 == 1)
      return helper(n - 1, steps + 1);
    else if (n % 4 == 2)
      return helper(n / 2, steps + 1);
    else
      return helper(n + 1, steps + 1);
  }

  static int solveRecursive(int n) {
    return helper(n*1L, 0);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(solveRecursive(N));
      System.out.println(solveIterative(N));
    }
  }
}
