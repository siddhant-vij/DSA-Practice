// Leetcode: 2220 - Minimum Bit Flips to Convert Number
// Leetcode: 1318 - Minimum Flips to Make a OR b Equal to c

package myPackage.j3bitwise;

import java.util.Scanner;

public class BitFlipsI {

  static int minBitFlipsII(int a, int b, int c) {
    int max = Math.max(Math.max(a, b), c);
    int totalBits = 1 + (int) Math.floor(Math.log(max) / Math.log(2));
    int count = 0;
    for (int i = 0; i < totalBits; i++) {
      int curA = (a >> i) & 1;
      int curB = (b >> i) & 1;
      int curC = (c >> i) & 1;
      if (curC == 0) {
        if ((curA == 1 && curB == 0) || (curA == 0 && curB == 1))
          count += 1;
        if (curA == 1 && curB == 1)
          count += 2;
      } else {
        if (curA == 0 && curB == 0)
          count += 1;
      }
    }
    return count;
  }

  static int minBitFlipsI(int start, int goal) {
    int max = Math.max(start, goal);
    int totalBits = 1 + (int) Math.floor(Math.log(max) / Math.log(2));
    int count = 0;
    for (int i = 0; i < totalBits; i++) {
      if (((start >> i) & 1) == 1 && ((goal >> i) & 1) == 0)
        count++;
      if (((start >> i) & 1) == 0 && ((goal >> i) & 1) == 1)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // int start = sc.nextInt();
      // int goal = sc.nextInt();
      // System.out.println(minBitFlipsI(start, goal));
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      System.out.println(minBitFlipsII(a, b, c));
    }
  }
}