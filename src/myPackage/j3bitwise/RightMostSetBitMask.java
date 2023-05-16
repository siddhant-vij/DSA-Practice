// Print Value Of RSB Mask

package myPackage.j3bitwise;

import java.util.Scanner;

public class RightMostSetBitMask {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(Integer.toBinaryString(N & (-N)));
      System.out.println(Integer.toBinaryString(N & (~N + 1)));
    }
  }
}
