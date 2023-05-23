// Leetcode: 2139. Minimum Moves to Reach Target Score

package myPackage.j3bitwise;

import java.util.Scanner;

public class MinMovesForTarget {

  static int minMoves(int target, int maxDoubles) {
    int count = 0;
    while (target > 1 && maxDoubles > 0) {
      count += (target & 1) + 1;
      target >>= 1;
      maxDoubles--;
    }
    return count + target - 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      System.out.println(minMoves(N, M));
    }
  }
}
