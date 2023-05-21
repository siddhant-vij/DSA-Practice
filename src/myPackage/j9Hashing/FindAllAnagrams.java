// Leetcode: 438. Find All Anagrams in a String

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindAllAnagrams {

  static List<Integer> findAnagrams(String s, String p) {
    int k = p.length();
    int n = s.length();
    if (k > n)
      return new ArrayList<Integer>();
    Map<Character, Integer> ref = new HashMap<>();
    for (int i = 0; i < k; i++)
      ref.put(p.charAt(i), ref.getOrDefault(p.charAt(i), 0) + 1);
    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> test = new HashMap<>();
    for (int i = 0; i < k; i++)
      test.put(s.charAt(i), test.getOrDefault(s.charAt(i), 0) + 1);
    if (ref.equals(test))
      result.add(0);
    for (int i = k; i < n; i++) {
      if (test.get(s.charAt(i - k)) == 1)
        test.remove(s.charAt(i - k));
      else
        test.put(s.charAt(i - k), test.get(s.charAt(i - k)) - 1);
      test.put(s.charAt(i), test.getOrDefault(s.charAt(i), 0) + 1);
      if (ref.equals(test))
        result.add(i - k + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      String p = sc.next();
      System.out.println(findAnagrams(s, p));
    }
  }
}
