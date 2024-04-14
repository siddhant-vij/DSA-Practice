// Leetcode 7: Reverse Integer

package myPackage.j2Maths;

import java.util.Scanner;

public class ReverseIntegerProblem {

  static int reverse(int n) {
    int origN = n;
    if (n < 0)
      n = n * -1;

    int rev = 0;
    while (n != 0) {
      int rem = n % 10;
      n /= 10;
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && n % 10 > 7))
        return 0;
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && n % 10 < -8))
        return 0;
      rev = rev * 10 + rem;
    }

    if (origN < 0)
      return rev * -1;
    else
      return rev;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(reverse(N));
    }
  }
}
