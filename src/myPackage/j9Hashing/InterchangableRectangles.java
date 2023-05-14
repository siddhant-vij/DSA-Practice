// Leetcode: 2001. Number of Pairs of Interchangeable Rectangles

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterchangableRectangles {

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  static long interchangeableRectangles(int[][] rectangles) {
    long count = 0L;
    int n = rectangles.length;
    Map<String, Long> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int gcd = gcd(rectangles[i][0], rectangles[i][1]);
      String key = rectangles[i][0] / gcd + "&" + rectangles[i][1] / gcd;
      if (map.containsKey(key))
        count += map.get(key);
      map.put(key, map.getOrDefault(key, 0L) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[][] mat = new int[n][2];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(interchangeableRectangles(mat));
    }
  }
}
