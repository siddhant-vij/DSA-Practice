// Leetcode: 76. Minimum Window Substring

package myPackage.j10Strings;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumWindowSubstring {

  static String minWindow(String s, String t) {
    if (s == null || s.length() < t.length() || s.length() == 0)
      return "";
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : t.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);
    int start = 0;
    int minStart = 0;
    int minLen = s.length() + 1;
    int count = 0;
    for (int end = 0; end < s.length(); end++) {
      if (map.containsKey(s.charAt(end))) {
        map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
        if (map.get(s.charAt(end)) >= 0) {
          count++;
        }
        while (count == t.length()) {
          if (end - start + 1 < minLen) {
            minStart = start;
            minLen = end - start + 1;
          }
          if (map.containsKey(s.charAt(start))) {
            map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
            if (map.get(s.charAt(start)) > 0) {
              count--;
            }
          }
          start++;
        }
      }
    }
    if (minLen > s.length()) {
      return "";
    }
    return s.substring(minStart, minStart + minLen);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(minWindow(str1, str2));
    }
  }  
}
