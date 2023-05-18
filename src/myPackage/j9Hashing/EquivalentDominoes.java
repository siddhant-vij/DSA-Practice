// Leetcode: 1128. Number of Equivalent Domino Pairs

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EquivalentDominoes {

  static int numEquivDominoPairs(int[][] dominoes) {
    int n = dominoes.length;
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      String test = dominoes[i][0] + "#" + dominoes[i][1];
      String test2 = dominoes[i][1] + "#" + dominoes[i][0];
      if (map.containsKey(test))
        count += map.get(test);
      if (!test2.equals(test) && map.containsKey(test2))
        count += map.get(test2);
      map.put(test, map.getOrDefault(test, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[][] mat = new int[N][2];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < 2; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(numEquivDominoPairs(mat));
    }
  }
}
