// Leetcode: 554. Brick Wall

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BrickWall {

  static int leastBricks(List<List<Integer>> wall) {
    int n = wall.size();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < wall.get(i).size() - 1; j++) {
        sum += wall.get(i).get(j);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int maxFreq = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxFreq)
        maxFreq = entry.getValue();
    }
    return n - maxFreq;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      List<List<Integer>> wall = new ArrayList<>();
      for(int i = 0; i < n; i++)
      {
        List<Integer> wallRow = new ArrayList<>();
        int m = sc.nextInt();
        for (int j = 0; j < m; j++) {
          wallRow.add(sc.nextInt());
        }
        wall.add(wallRow);
      }
      System.out.println(leastBricks(wall));
    }
  }  
}
