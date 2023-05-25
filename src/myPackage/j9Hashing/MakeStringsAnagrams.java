// Leetcode: 1347. Minimum Number of Steps to Make Two Strings Anagram
// Leetcode: 2186. Minimum Number of Steps to Make Two Strings Anagram II

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeStringsAnagrams {

  static int minStepsII(String s, String t) {
    if (s.equals(t))
      return 0;
    int count = 0;
    String larger, smaller;
    int nl, ns;
    if (s.length() >= t.length()) {
      larger = s;
      smaller = t;
      nl = s.length();
      ns = t.length();
    } else {
      larger = t;
      smaller = s;
      nl = t.length();
      ns = s.length();
    }
    Map<Character, Integer> mapL = new HashMap<>();
    for (int i = 0; i < nl; i++)
      mapL.put(larger.charAt(i), mapL.getOrDefault(larger.charAt(i), 0) + 1);
    Map<Character, Integer> mapS = new HashMap<>();
    for (int i = 0; i < ns; i++)
      mapS.put(smaller.charAt(i), mapS.getOrDefault(smaller.charAt(i), 0) + 1);
    for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
      char test = entry.getKey();
      int freq = entry.getValue();
      count += freq;
      if (mapL.containsKey(test)) {
        if (freq < mapL.get(test)) {
          count -= freq;
        } else if (freq == mapL.get(test)) {
          count -= freq;
        } else {
          count -= mapL.get(test);
        }
      } else {
        continue;
      }
    }
    for (Map.Entry<Character, Integer> entry : mapL.entrySet()) {
      char test = entry.getKey();
      int freq = entry.getValue();
      count += freq;
      if (mapS.containsKey(test)) {
        if (freq < mapS.get(test)) {
          count -= freq;
        } else if (freq == mapS.get(test)) {
          count -= freq;
        } else {
          count -= mapS.get(test);
        }
      } else {
        continue;
      }
    }
    return count;
  }

  static int minStepsI(String s, String t) {
    int count = 0;
    int n = s.length();
    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapT = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
      mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
    }
    for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
      char test = entry.getKey();
      int freq = entry.getValue();
      if (mapS.containsKey(test)) {
        if (freq > mapS.get(test))
          count += (freq - mapS.get(test));
      } else {
        count += freq;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(minStepsI(str1, str2));
      System.out.println(minStepsII(str1, str2));
    }
  }
}
