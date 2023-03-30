// Leetcode 680: Valid Palindrome II

package myPackage.j5Arrays;

import java.util.Scanner;

public class ValidPalindromeDelete {

  static boolean validSubPalindrome(String s, int lo, int hi, boolean used) {
    if (lo >= hi) {
      return true;
    }
    if (s.charAt(lo) != s.charAt(hi)) {
      if (used == false) {
        if (validSubPalindrome(s, lo + 1, hi, true))
          return true;
        return validSubPalindrome(s, lo, hi - 1, true);
      } else {
        return false;
      }
    }
    return validSubPalindrome(s, lo + 1, hi - 1, used);
  }

  static boolean validPalindrome(String s) {
    return validSubPalindrome(s, 0, s.length() - 1, false);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(validPalindrome(str));
    }
  }
}
