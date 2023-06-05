// Leetcode: 2309. Greatest English Letter in Upper and Lower Case

package myPackage.j10Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GreatestCharUpperLowerCase {

  static String greatestLetter(String s) {
    Set<Character> set = new HashSet<>();
    int[] arr = new int[26];
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z' && set.contains((char) (ch - 'a' + 'A')))
        arr[ch - 'a']++;
      if (ch >= 'A' && ch <= 'Z' && set.contains((char) (ch - 'A' + 'a')))
        arr[ch - 'A']++;
      set.add(ch);
    }
    int index = -1;
    for (int i = 25; i >= 0; i--) {
      if (arr[i] > 0) {
        index = i;
        break;
      }
    }
    return index != -1 ? "" + (char) ('A' + index) : "";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(greatestLetter(str));
    }
  }  
}
