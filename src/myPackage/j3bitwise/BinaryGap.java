// Leetcode: 868 - Binary Gap

package myPackage.j3bitwise;

import java.util.Scanner;

public class BinaryGap {

  static int binaryGap(int n) {
    int maxDiff = 0;
    int s = -1;
    int e = -1;
    int idx = 0;
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1 && count == 0) {
        s = idx;
        count = 1;
      } else if ((n & 1) == 1 && count == 1) {
        e = idx;
        maxDiff = Math.max(maxDiff, e - s);
        s = e;
      }
      n >>= 1;
      idx++;
    }
    return maxDiff;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(binaryGap(N));
    }
  }
}
