// Leetcode: 36 - Valid Sudoku

package myPackage.j9Hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidSudoku {

  static boolean isValidSudoku(char[][] board) {
    Set<Character> set = new HashSet<>();
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] != '.') {
          if (set.contains(board[row][col]))
            return false;
          set.add(board[row][col]);
        }
      }
      set.clear();
    }

    for (int col = 0; col < 9; col++) {
      for (int row = 0; row < 9; row++) {
        if (board[row][col] != '.') {
          if (set.contains(board[row][col]))
            return false;
          set.add(board[row][col]);
        }
      }
      set.clear();
    }

    for (int groupX = 0; groupX < 9; groupX += 3) {
      for (int groupY = 0; groupY < 9; groupY += 3) {
        for (int row = groupX; row < groupX + 3; row++) {
          for (int col = groupY; col < groupY + 3; col++) {
            if (board[row][col] != '.') {
              if (set.contains(board[row][col]))
                return false;
              set.add(board[row][col]);
            }
          }
        }
        set.clear();
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      char[][] mat = new char[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.next().charAt(0);
        }
      }
      System.out.println(isValidSudoku(mat));
    }
  }
}
