// Leetcode: 748. Shortest Completing Word

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShortestCompletion {

  static String shortestCompletingWord(String licensePlate, String[] words) {
    int minLength = Integer.MAX_VALUE;
    String result = "";
    for (int i = 0; i < words.length; i++) {
      String str = licensePlate.toLowerCase();
      Map<Character, Integer> map = new HashMap<>();
      int size = 0;
      for (int j = 0; j < str.length(); j++) {
        if (str.charAt(j) != ' ' && !(str.charAt(j) >= '0' && str.charAt(j) <= '9')) {
          map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
          size++;
        }
      }

      int count = 0;
      for (int j = 0; j < words[i].length(); j++) {
        char ch = words[i].charAt(j);
        if (map.containsKey(ch)) {
          count++;
          if (map.get(ch) == 1)
            map.remove(ch);
          else
            map.put(ch, map.get(ch) - 1);
        }
      }
      if (count == size && words[i].length() < minLength) {
        minLength = words[i].length();
        result = words[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String licensePlate = sc.next();
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < n; i++) {
        words[i] = sc.next();
      }
      System.out.println(shortestCompletingWord(licensePlate, words));
    }
  }
}
