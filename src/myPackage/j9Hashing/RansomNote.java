// Leetcode: 383 - Ransom Note

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

  static boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++)
      map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);

    for (int i = 0; i < ransomNote.length(); i++) {
      char ch = ransomNote.charAt(i);
      if (map.containsKey(ch)) {
        if (map.get(ch) == 1)
          map.remove(ch);
        else
          map.put(ch, map.get(ch) - 1);
      } else
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(canConstruct(str1, str2));
    }
  }
}
