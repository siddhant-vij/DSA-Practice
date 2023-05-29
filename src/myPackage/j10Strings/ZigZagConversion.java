// Leetcode: 6. Zigzag Conversion

package myPackage.j10Strings;

import java.util.Scanner;

public class ZigZagConversion {

  static String convert(String s, int numRows) {
    int n = s.length();
    int numCols = 0;
    while (n > 0) {
      numCols++;
      n -= numRows;
      int temp = numRows - 2;
      while (n > 0 && temp >= 1) {
        numCols++;
        n--;
        temp--;
      }
    }
    n = s.length() - 1;
    char[][] mat = new char[numRows][numCols];
    int col = 0;
    int row = 0;
    int index = 0;
    while (n >= 0) {
      for (row = 0; row <= numRows - 1 && n >= 0; row++) {
        n--;
        mat[row][col] = s.charAt(index++);
      }
      int temp = numRows - 2;
      row--;
      while (n >= 0 && temp >= 1) {
        row--;
        col++;
        mat[row][col] = s.charAt(index++);
        n--;
        temp--;
      }
      col++;
    }
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (mat[i][j] != '\u0000')
          strB.append(mat[i][j]);
      }
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int rows = sc.nextInt();
      System.out.println(convert(str, rows));
    }
  }
}
