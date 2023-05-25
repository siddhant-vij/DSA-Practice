// Leetcode: 1657. Determine if Two Strings Are Close

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AreStringsClose {

  static boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    Map<Character, Integer> word1Map = new HashMap<>();
    Map<Character, Integer> word2Map = new HashMap<>();
    for (char c : word1.toCharArray())
      word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
    for (char c : word2.toCharArray())
      word2Map.put(c, word2Map.getOrDefault(c, 0) + 1);
    if (!word1Map.keySet().equals(word2Map.keySet()))
      return false;
    List<Integer> word1FrequencyList = new ArrayList<>(word1Map.values());
    List<Integer> word2FrequencyList = new ArrayList<>(word2Map.values());
    Collections.sort(word1FrequencyList);
    Collections.sort(word2FrequencyList);
    return word1FrequencyList.equals(word2FrequencyList);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(closeStrings(str1, str2));
    }
  }
}
