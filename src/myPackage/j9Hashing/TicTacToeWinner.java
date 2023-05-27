// Leetcode: 1275. Find Winner on a Tic Tac Toe Game

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TicTacToeWinner {

  static String tictactoe(int[][] moves) {
    int n = moves.length;
    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if ((i & 1) == 0)
        map.put(moves[i][0] * 3 + (moves[i][1] + 1), "A");
      else
        map.put(moves[i][0] * 3 + (moves[i][1] + 1), "B");
    }
    if (map.containsKey(1) && map.containsKey(2) && map.containsKey(3) && map.get(1) == map.get(2)
        && map.get(2) == map.get(3))
      return map.get(1);
    else if (map.containsKey(4) && map.containsKey(5) && map.containsKey(6) && map.get(4) == map.get(5)
        && map.get(5) == map.get(6))
      return map.get(4);
    else if (map.containsKey(7) && map.containsKey(8) && map.containsKey(9) && map.get(7) == map.get(8)
        && map.get(8) == map.get(9))
      return map.get(7);
    else if (map.containsKey(1) && map.containsKey(4) && map.containsKey(7) && map.get(1) == map.get(4)
        && map.get(4) == map.get(7))
      return map.get(1);
    else if (map.containsKey(2) && map.containsKey(5) && map.containsKey(8) && map.get(2) == map.get(5)
        && map.get(5) == map.get(8))
      return map.get(2);
    else if (map.containsKey(3) && map.containsKey(6) && map.containsKey(9) && map.get(3) == map.get(6)
        && map.get(6) == map.get(9))
      return map.get(3);
    else if (map.containsKey(1) && map.containsKey(5) && map.containsKey(9) && map.get(1) == map.get(5)
        && map.get(5) == map.get(9))
      return map.get(1);
    else if (map.containsKey(3) && map.containsKey(5) && map.containsKey(7) && map.get(3) == map.get(5)
        && map.get(5) == map.get(7))
      return map.get(3);
    else if (n == 9)
      return "Draw";
    else
      return "Pending";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < 2; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      System.out.println(tictactoe(arr));
    }
  }  
}
