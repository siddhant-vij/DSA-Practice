// Leetcode: 1047 - Remove All Adjacent Duplicates In String

package myPackage.j10Strings;

import java.util.Scanner;

public class RemoveAdjDups {

  static String removeDuplicates(String s) {
    StringBuilder strB = new StringBuilder();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      int k = strB.length();
      if (k != 0 && s.charAt(i) == strB.charAt(k - 1))
        strB.deleteCharAt(k - 1);
      else
        strB.append(s.charAt(i));
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      System.out.println(removeDuplicates(str1));
    }
  }
}
