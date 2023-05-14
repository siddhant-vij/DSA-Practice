// Leetcode: 3. Longest Substring Without Repeating Characters

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWoReps {

  static int lengthOfLongestSubstring(String str) {
    Map<Character, Integer> map = new HashMap<>();
    int s = 0;
    int e = 0;
    int n = str.length();
    int maxLength = 0;
    while (e < n) {
      if (map.containsKey(str.charAt(e)))
        s = Math.max(map.get(str.charAt(e)) + 1, s);
      map.put(str.charAt(e), e);
      e++;
      maxLength = Math.max(maxLength, e - s);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(lengthOfLongestSubstring(str));
    }
  }  
}
