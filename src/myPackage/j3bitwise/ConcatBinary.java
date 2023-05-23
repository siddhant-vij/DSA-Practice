// Leetcode: 1680. Concatenation of Consecutive Binary Numbers

package myPackage.j3bitwise;

import java.util.Scanner;

public class ConcatBinary {

  static int concatenatedBinary(int n) {
    long result = 0L;
    int mod = 1000_000_007;
    for (int i = 1; i <= n; i++) {
      int bits = Integer.toBinaryString(i).length();
      result = ((result << bits) % mod + i) % mod;
    }
    return (int) result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(concatenatedBinary(n));
    }
  }  
}
