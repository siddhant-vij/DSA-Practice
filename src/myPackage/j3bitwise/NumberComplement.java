// Leetcode: 476 - Number Complement

package myPackage.j3bitwise;

import java.util.Scanner;

public class NumberComplement {

  static int findComplement(int num) {
    int result = 0;
    int pow = 1;
    while (num != 0) {
      int dig = (num & 1) == 1 ? 0 : 1;
      result += dig * pow;
      pow = pow * 2;
      num >>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(findComplement(N));
    }
  }
}
