// Leetcode: 1910 - Remove All Occurrences of a Substring

package myPackage.j10Strings;

import java.util.Scanner;

public class RemoveAllOccurences {

  static String removeOccurrencesII(String s, String part) {
    while (s.contains(part)) {
      s = s.replaceFirst(part, "");
    }
    return s;
  }

  static String removeOccurrencesI(String s, String part) {
    int k = part.length();
    int index = s.indexOf(part);
    StringBuilder strB = new StringBuilder();
    while (index != -1) {
      for (int i = 0; i < index; i++)
        strB.append(s.charAt(i));
      for (int i = index + k; i < s.length(); i++)
        strB.append(s.charAt(i));
      s = strB.toString();
      index = s.indexOf(part);
      strB.setLength(0);
    }
    return s;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      String part = sc.next();
      System.out.println(removeOccurrencesI(str, part));
      System.out.println(removeOccurrencesII(str, part));
    }
  }
}
