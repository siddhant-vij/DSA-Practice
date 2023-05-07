// Leetcode: 409 - Longest Palindrome

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindrome {

  static int longestPalindrome(String s) {
    int sum = 0;
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      if ((entry.getValue() & 1) == 0)
        sum += entry.getValue();
      else
        sum += entry.getValue() - 1;
    }
    return sum < n ? sum + 1 : sum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(longestPalindrome(str));
    }
  }
}
