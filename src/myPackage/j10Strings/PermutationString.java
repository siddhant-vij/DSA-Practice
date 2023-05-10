// Leetcode: 567 - Permutation in String

package myPackage.j10Strings;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationString {

  static boolean checkInclusionWindow(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    if (n > m)
      return false;
    HashMap<Character, Integer> s1map = new HashMap<>();

    for (int i = 0; i < n; i++)
      s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

    HashMap<Character, Integer> s2map = new HashMap<>();
    for (int i = 0; i < n; i++)
      s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);

    if (matches(s1map, s2map))
      return true;

    for (int i = n; i < m; i++) {
      if (s2map.get(s2.charAt(i - n)) == 1)
        s2map.remove(s2.charAt(i - n));
      else
        s2map.put(s2.charAt(i - n), s2map.get(s2.charAt(i - n)) - 1);

      s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);

      if (matches(s1map, s2map))
        return true;
    }
    return false;
  }

  static boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
    for (char key : s1map.keySet()) {
      if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
        return false;
    }
    return true;
  }

  static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length())
      return false;
    HashMap<Character, Integer> s1map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++)
      s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      HashMap<Character, Integer> s2map = new HashMap<>();
      for (int j = 0; j < s1.length(); j++) {
        s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
      }
      if (matches(s1map, s2map))
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(checkInclusion(str1, str2));
      System.out.println(checkInclusionWindow(str1, str2));
    }
  }
}
