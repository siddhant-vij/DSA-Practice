// Leetcode: 973 - K Closest Points to Origin

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
  int ptX;
  int ptY;
  int dist;

  Pair(int ptX, int ptY, int dist) {
    this.ptX = ptX;
    this.ptY = ptY;
    this.dist = dist;
  }

  @Override
  public int compareTo(Pair other) {
    return this.dist - other.dist;
  }
}

public class KClosestPtsToOrigin {

  static int[][] kClosest(int[][] points, int k) {
    int n = points.length;
    int[] dist = new int[n];
    for (int i = 0; i < n; i++)
      dist[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];

    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new Pair(points[i][0], points[i][1], dist[i]);

    Arrays.sort(pairs);
    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
      result[i][0] = pairs[i].ptX;
      result[i][1] = pairs[i].ptY;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[][] points = new int[N][2];
      for (int i = 0; i < N; i++) {
        points[i][0] = sc.nextInt();
        points[i][1] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(Arrays.deepToString(kClosest(points, k)));
    }
  }
}
