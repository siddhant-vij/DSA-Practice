// Leetcode: 5. Longest Palindromic Substring

package myPackage.j10Strings;

import java.util.Scanner;

public class LongestPalindromicSubstring {

  static int[] expand(String str, int p1, int p2) {
    if (p1 >= 0 && p2 < str.length() && str.charAt(p1) != str.charAt(p2))
      return new int[] { p1 + 1, p2 - 1 };
    while (p1 >= 0 && p2 < str.length() && str.charAt(p1) == str.charAt(p2)) {
      p1--;
      p2++;
    }
    return new int[] { p1 + 1, p2 - 1 };
  }

  static String longestPalindrome(String A) {
    int n = A.length();
    String result = "";
    int maxLength = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int[] outputOdd = expand(A, i - 1, i + 1);
      if (outputOdd[1] - outputOdd[0] > maxLength) {
        maxLength = outputOdd[1] - outputOdd[0];
        result = A.substring(outputOdd[0], outputOdd[1] + 1);
      }
    }
    for (int i = 0; i < n; i++) {
      int[] outputEven = expand(A, i, i + 1);
      if (outputEven[1] - outputEven[0] > maxLength) {
        maxLength = outputEven[1] - outputEven[0];
        result = A.substring(outputEven[0], outputEven[1] + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(longestPalindrome(str));
    }
  }  
}
