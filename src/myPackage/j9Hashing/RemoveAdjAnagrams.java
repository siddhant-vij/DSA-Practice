// Leetcode: 2273. Find Resultant Array After Removing Anagrams

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RemoveAdjAnagrams {

  static List<String> removeAnagrams(String[] words) {
    Map<Character, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    for (int i = 0; i < words[0].length(); i++)
      map.put(words[0].charAt(i), map.getOrDefault(words[0].charAt(i), 0) + 1);
    result.add(words[0]);
    for (int i = 1; i < words.length; i++) {
      Map<Character, Integer> curMap = new HashMap<>();
      for (int j = 0; j < words[i].length(); j++)
        curMap.put(words[i].charAt(j), curMap.getOrDefault(words[i].charAt(j), 0) + 1);
      if (!map.equals(curMap))
        result.add(words[i]);
      map = curMap;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] str = new String[n];
      for (int i = 0; i < n; i++) {
        str[i] = sc.next();
      }
      System.out.println(removeAnagrams(str));
    }
  }
}
