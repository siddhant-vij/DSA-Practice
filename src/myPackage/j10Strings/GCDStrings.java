// Leetcode: 1071. Greatest Common Divisor of Strings

package myPackage.j10Strings;

import java.util.Scanner;

public class GCDStrings {

  static String gcdOfStrings(String str1, String str2) {
    int len1 = str1.length();
    int len2 = str2.length();
    if (len1 < len2 && str2.substring(0, len1).equals(str1))
      return gcdOfStrings(str2.substring(len1, len2), str1);
    if (len1 > len2 && str1.substring(0, len2).equals(str2))
      return gcdOfStrings(str1.substring(len2, len1), str2);
    if (str1.equals(str2))
      return str1;
    return "";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(gcdOfStrings(str1, str2));
    }
  }  
}
