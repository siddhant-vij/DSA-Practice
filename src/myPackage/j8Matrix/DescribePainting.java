// Leetcode: 1943. Describe the Painting

package myPackage.j8Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DescribePainting {
  
  static List<List<Long>> splitPainting(int[][] segments) {
    int n = segments.length;
    int max = Integer.MIN_VALUE;
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < n; i++)
      set.add(segments[i][0]);
    for (int i = 0; i < n; i++)
      max = Math.max(max, segments[i][1]);
    long[] pf = new long[max];
    for (int i = 0; i < n; i++) {
      int left = segments[i][0] - 1;
      int right = segments[i][1] - 1;
      int color = segments[i][2];
      pf[left] += color;
      pf[right] -= color;
    }
    for (int i = 1; i < max; i++)
      pf[i] += pf[i - 1];
    List<List<Long>> result = new ArrayList<>();
    List<Long> list = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < max; i++) {
      if (set.contains(i + 1)) {
        list.add((i + 1) * 1L);
        count++;
        if (count == 2) {
          list.add(pf[i - 1]);
        }
      } else {
        if (i != 0 && pf[i] == pf[i - 1]) {
          continue;
        } else if (i != 0) {
          count++;
          if (count == 2) {
            list.add((i + 1) * 1L);
            list.add(pf[i - 1]);
          }
        }
      }
      if (count == 2) {
        if (list.get(list.size() - 1) != 0)
          result.add(list);
        count = 1;
        list = new ArrayList<>();
        list.add((i + 1) * 1L);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[][] mat = new int[n][3];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(splitPainting(mat));
    }
  }
}
