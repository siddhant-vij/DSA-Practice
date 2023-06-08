// Leetcode: 1945. Sum of Digits of String After Convert

package myPackage.j10Strings;

import java.util.Scanner;

public class StringSumConversion {

  static int getLucky(String s, int k) {
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      strB.append(s.charAt(i) - 'a' + 1);
    }
    s = strB.toString();
    while (k-- > 0) {
      StringBuilder strX = new StringBuilder();
      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
        sum += (s.charAt(i) - '0');
      }
      s = strX.append(sum).toString();
    }
    return Integer.parseInt(s);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int n = sc.nextInt();
      System.out.println(getLucky(str, n));
    }
  }  
}
