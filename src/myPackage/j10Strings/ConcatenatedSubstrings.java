// Leetcode: 30. Substring with Concatenation of All Words

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConcatenatedSubstrings {

  static List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    List<Integer> indexes = new ArrayList<>();
    int n = s.length(), num = words.length, len = words[0].length();
    for (int i = 0; i < n - num * len + 1; i++) {
      Map<String, Integer> seen = new HashMap<>();
      int j = 0;
      while (j < num) {
        String word = s.substring(i + j * len, i + (j + 1) * len);
        if (map.containsKey(word)) {
          seen.put(word, seen.getOrDefault(word, 0) + 1);
          if (seen.get(word) > map.getOrDefault(word, 0)) {
            break;
          }
        } else {
          break;
        }
        j++;
      }
      if (j == num) {
        indexes.add(i);
      }
    }
    return indexes;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < words.length; i++) {
        words[i] = sc.next();
      }
      System.out.println(findSubstring(str, words));
    }
  }
}
