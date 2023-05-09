// Leetcode: 1446 - Consecutive Characters

package myPackage.j10Strings;

import java.util.Scanner;

public class ConsecutiveCharacters {

  static int maxPower(String str) {
    int maxLength = 0;
    char[] ch = str.toCharArray();
    int n = ch.length;
    int s = 0;
    int e = 0;
    while (e < n) {
      if (ch[s] == ch[e])
        e++;
      else {
        maxLength = Math.max(maxLength, e - s);
        s = e;
      }
    }
    if (e == n)
      maxLength = Math.max(maxLength, e - s);
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(maxPower(str));
    }
  }
}
