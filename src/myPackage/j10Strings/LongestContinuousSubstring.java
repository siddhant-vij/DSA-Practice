// Leetcode: 2414. Length of the Longest Alphabetical Continuous Substring

package myPackage.j10Strings;

import java.util.Scanner;

public class LongestContinuousSubstring {

  static int longestContinuousSubstring(String str) {
    int n = str.length();
    int s = 0;
    int e = 1;
    int maxLength = 1;
    while (e < n) {
      if (str.charAt(e) - str.charAt(e - 1) == 1)
        e++;
      else {
        maxLength = Math.max(maxLength, e - s);
        s = e;
        e++;
      }
    }
    maxLength = Math.max(maxLength, e - s);
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(longestContinuousSubstring(str));
    }
  }  
}
