// Leetcode: 890. Find and Replace Pattern

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindReplacePattern {

  static String normalize(String str) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      map.putIfAbsent(c, i);
      ans.append(map.get(c));
    }
    return ans.toString();
  }

  static List<String> findAndReplacePattern(String[] words, String pattern) {
    String p = normalize(pattern);
    List<String> ans = new ArrayList<String>();
    for (String s : words) {
      if (p.equals(normalize(s))) {
        ans.add(s);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] arr = new String[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.next();
      }
      String str = sc.next();
      System.out.println(findAndReplacePattern(arr, str));
    }
  }
}
