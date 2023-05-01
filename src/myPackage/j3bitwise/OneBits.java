// Leetcode: 191 - Number of 1 Bits

package myPackage.j3bitwise;

import java.util.Scanner;

public class OneBits {
  static int hammingWeight(int n) {
    int num = n;
    if (n < 0)
      n = -1 * (n + 1);
    int count = 0;
    while (n != 0) {
      count++;
      n = n & (n - 1);
    }
    if (num < 0)
      return 32 - count;
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(hammingWeight(N));
    }
  }
}
