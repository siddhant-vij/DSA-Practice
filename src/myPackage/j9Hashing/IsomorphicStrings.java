// Leetcode: 205 - Isomorphic Strings

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class IsomorphicStrings {

  static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length())
      return false;

    int n = s.length();

    HashMap<Character, Character> map = new HashMap<>();
    HashSet<Character> setValues = new HashSet<>();

    for (int i = 0; i < n; i++) {
      char chS = s.charAt(i);
      char chT = t.charAt(i);
      if (!map.containsKey(chS) && !setValues.contains(chT)) {
        map.put(chS, chT);
        setValues.add(chT);
      } else if (map.containsKey(chS) && !setValues.contains(chT))
        return false;
      else if (!map.containsKey(chS) && setValues.contains(chT))
        return false;
      else if (map.containsKey(chS) && setValues.contains(chT) && map.get(chS) != chT)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      String t = sc.next();
      System.out.println(isIsomorphic(s, t));
    }
  }
}
