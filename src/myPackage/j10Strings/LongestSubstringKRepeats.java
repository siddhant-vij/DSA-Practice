// Leetcode: 395. Longest Substring with At Least K Repeating Characters

package myPackage.j10Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringKRepeats {

  static int helper(String str, int k, int s, int e) {
    if (str == "")
      return 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = s; i <= e; i++)
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    int index = -1;
    for (int i = s; i <= e; i++) {
      if (map.get(str.charAt(i)) < k) {
        index = i;
        break;
      }
    }
    if (index == -1)
      return e - s + 1;
    else {
      return Math.max(helper(str, k, s, index - 1), helper(str, k, index + 1, e));
    }
  }

  static int longestSubstring(String s, int k) {
    return helper(s, k, 0, s.length() - 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int k = sc.nextInt();
      System.out.println(longestSubstring(str, k));
    }
  }  
}
