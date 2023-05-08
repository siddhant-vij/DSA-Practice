// Leetcode: 2351 - First Letter to Appear Twice

package myPackage.j9Hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstLetterTwice {

  static char repeatedCharacter(String s) {
    Set<Character> set = new HashSet<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      set.add(s.charAt(i));
      if (set.size() != i + 1)
        return s.charAt(i);
    }
    return '0';
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      System.out.println(repeatedCharacter(s));
    }
  }
}
