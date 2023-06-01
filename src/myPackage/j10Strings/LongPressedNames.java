// Leetcode: 925. Long Pressed Name

package myPackage.j10Strings;

import java.util.Scanner;

public class LongPressedNames {

  static boolean isLongPressedName(String name, String typed) {
    int p1 = 0;
    int n1 = name.length();
    int p2 = 0;
    int n2 = typed.length();
    while (p1 < n1 && p2 < n2) {
      if (name.charAt(p1) == typed.charAt(p2)) {
        p1++;
        p2++;
      } else if (p2 != 0 && typed.charAt(p2) == typed.charAt(p2 - 1)) {
        p2++;
      } else {
        return false;
      }
    }
    if (p1 == n1 && p2 == n2)
      return true;
    else if (p1 != n1 && p2 == n2)
      return false;
    else {
      while (p2 != n2) {
        if (typed.charAt(p2) == typed.charAt(p2 - 1))
          p2++;
        else
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(isLongPressedName(str1, str2));
    }
  }
}
