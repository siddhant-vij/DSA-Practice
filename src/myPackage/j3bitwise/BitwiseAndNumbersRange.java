// Leetcode: 201. Bitwise AND of Numbers Range

package myPackage.j3bitwise;

import java.util.Scanner;

public class BitwiseAndNumbersRange {

  static int rangeBitwiseAnd(int m, int n) {
    int shift = 0;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      shift++;
    }
    n <<= shift;
    return n;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(rangeBitwiseAnd(a, b));
    }
  }  
}
