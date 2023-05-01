// Leetcode: 190 - Reverse Bits

package myPackage.j3bitwise;

import java.util.Scanner;

public class ReverseBits {

  static int reverseBits(int n) {
    int answer = 0;
    for (int i = 0; i < 32; i++) {
      answer <<= 1;
      answer |= ((n >> i) & 1);
    }
    return answer;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(reverseBits(n));
    }
  }

}
