// Leetcode: 939. Minimum Area Rectangle

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinAreaRectangle {

  static int minAreaRect(int[][] points) {
    int n = points.length;
    Map<Integer, Set<Integer>> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(points[i][0])) {
        Set<Integer> set = new TreeSet<>();
        set.add(points[i][1]);
        map.put(points[i][0], set);
      } else {
        Set<Integer> set = map.get(points[i][0]);
        set.add(points[i][1]);
        map.put(points[i][0], set);
      }
    }
    if (map.size() < 2)
      return 0;

    int minArea = Integer.MAX_VALUE;
    for (Map.Entry<Integer, Set<Integer>> i : map.entrySet()) {
      for (Map.Entry<Integer, Set<Integer>> j : map.entrySet()) {
        Set<Integer> intersection = new TreeSet<>(i.getValue());
        intersection.retainAll(j.getValue());
        if (!i.equals(j) && intersection.size() >= 2) {
          List<Integer> aList = new ArrayList<>(intersection);
          int diff = Integer.MAX_VALUE;
          for (int cur = 1; cur < aList.size(); cur++)
            diff = Math.min(diff, aList.get(cur) - aList.get(cur - 1));
          minArea = Math.min(minArea, Math.abs(i.getKey() - j.getKey()) * diff);
        }
      }
    }
    return minArea == Integer.MAX_VALUE ? 0 : minArea;
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
      System.out.println(minAreaRect(mat));
    }
  }
}
