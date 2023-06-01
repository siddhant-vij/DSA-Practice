// Leetcode: 1324. Print Words Vertically

package myPackage.j8Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintWordsVertically {

  static String removeTrailingSpaces(String str) {
    char[] ch = str.toCharArray();
    int n = ch.length;
    int lastCharIndex = -1;
    for (int i = 0; i < n; i++) {
      if (ch[i] != '\u0000')
        lastCharIndex = i;
    }
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i <= lastCharIndex; i++) {
      if (ch[i] == '\u0000')
        ch[i] = ' ';
      strB.append(ch[i]);
    }
    return strB.toString();
  }

  static List<String> printVertically(String s) {
    String[] str = s.split(" ");
    int m = str.length;
    int n = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++)
      n = Math.max(n, str[i].length());
    char[][] mat = new char[n][m];
    for (int col = 0; col < m; col++) {
      String test = str[col];
      for (int row = 0; row < n; row++) {
        if (row < test.length())
          mat[row][col] = test.charAt(row);
      }
    }
    List<String> result = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      StringBuilder strB = new StringBuilder();
      for (int col = 0; col < m; col++) {
        strB.append(mat[row][col]);
      }
      result.add(removeTrailingSpaces(strB.toString()));
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(printVertically(str));
    }
  }  
}
