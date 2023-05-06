// Leetcode: 290 - Word Pattern

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WordPattern {

  static boolean wordPattern(String pattern, String s) {
    String[] str = s.split(" ");
    int n = str.length;
    if (n != pattern.length())
      return false;

    HashMap<Character, String> map = new HashMap<>();
    HashSet<String> setValues = new HashSet<>();
    for (int i = 0; i < n; i++) {
      char ch = pattern.charAt(i);
      if (!map.containsKey(ch) && !setValues.contains(str[i])) {
        map.put(ch, str[i]);
        setValues.add(str[i]);
      } else if (map.containsKey(ch) && !setValues.contains(str[i]))
        return false;
      else if (!map.containsKey(ch) && setValues.contains(str[i]))
        return false;
      else if (map.containsKey(ch) && setValues.contains(str[i]) && !(map.get(ch).equals(str[i])))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      String t = sc.next();
      System.out.println(wordPattern(s, t));
    }
  }
}
