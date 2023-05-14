// Leetcode: 859. Buddy Strings

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BuddyStrings {

  static boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length())
      return false;
    int n = s.length();
    if (s.equals(goal)) {
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if (set.contains(s.charAt(i)))
          return true;
        set.add(s.charAt(i));
      }
      return false;
    } else {
      List<Integer> diff = new ArrayList<>();
      for (int i = 0; i < s.length(); ++i)
        if (s.charAt(i) != goal.charAt(i))
          diff.add(i);
      return diff.size() == 2
          && s.charAt(diff.get(0)) == goal.charAt(diff.get(1))
          && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      String t = sc.next();
      System.out.println(buddyStrings(s, t));
    }
  }  
}
