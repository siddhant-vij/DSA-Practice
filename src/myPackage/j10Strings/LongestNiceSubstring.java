// Leetcode: 1763. Longest Nice Substring

package myPackage.j10Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestNiceSubstring {

  static String helper(String str, int s, int e) {
    if (str == "" || e - s == 0)
      return "";
    Set<Character> set = new HashSet<>();
    for (int i = s; i <= e; i++)
      set.add(str.charAt(i));
    int index = -1;
    for (int i = s; i <= e; i++) {
      char ch = str.charAt(i);
      if (ch >= 'a' && ch <= 'z' && !set.contains((char) (ch - 'a' + 'A'))) {
        index = i;
        break;
      }
      if (ch >= 'A' && ch <= 'Z' && !set.contains((char) (ch - 'A' + 'a'))) {
        index = i;
        break;
      }
    }
    if (index == -1)
      return str.substring(s, e + 1);
    else {
      String test1 = helper(str, s, index - 1);
      String test2 = helper(str, index + 1, e);
      if (test1.length() >= test2.length())
        return test1;
      else
        return test2;
    }
  }

  static String longestNiceSubstring(String s) {
    return helper(s, 0, s.length() - 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(longestNiceSubstring(str));
    }
  }  
}
