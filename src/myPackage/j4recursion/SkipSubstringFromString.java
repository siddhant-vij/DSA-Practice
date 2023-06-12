// Practice: Skip Substring From String

package myPackage.j4recursion;

import java.util.Scanner;

public class SkipSubstringFromString {

  static String skipSubstringII(String str, int index, String skip, int k1, String notSkip, int k2, String res) {
    if (index == str.length()) {
      return res;
    }
    if (index + k1 > str.length()) {
      res += str.substring(index, str.length());
      return res;
    }
    if (index + k1 == str.length()) {
      if (!(str.substring(index, index + k1).equals(skip)))
        res += str.substring(index, str.length());
      return res;
    }
    if (!(str.substring(index, index + k1).equals(skip))) {
      res += str.charAt(index);
      return skipSubstringII(str, index + 1, skip, k1, notSkip, k2, res);
    } else if (!(str.substring(index, index + k2).equals(notSkip))) {
      return skipSubstringII(str, index + k1, skip, k1, notSkip, k2, res);
    } else {
      res += str.substring(index, index + k2);
      return skipSubstringII(str, index + k2, skip, k1, notSkip, k2, res);
    }
  }

  static String skipSubstringI(String str, int index, String skip, int k, String res) {
    if (index == str.length()) {
      return res;
    }
    if (index + k > str.length()) {
      res += str.substring(index, str.length());
      return res;
    }
    if (index + k == str.length()) {
      if (!(str.substring(index, index + k).equals(skip)))
        res += str.substring(index, str.length());
      return res;
    }
    if (!(str.substring(index, index + k).equals(skip))) {
      res += str.charAt(index);
      return skipSubstringI(str, index + 1, skip, k, res);
    } else {
      return skipSubstringI(str, index + k, skip, k, res);
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      String skip = sc.next();
      String notSkip = sc.next();
      System.out.println(skipSubstringI(str, 0, skip, skip.length(), ""));
      System.out.println(skipSubstringII(str, 0, skip, skip.length(), notSkip, notSkip.length(), ""));
    }
  }
}
