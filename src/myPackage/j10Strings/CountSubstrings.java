// Leetcode: 1967. Number of Strings That Appear as Substrings in Word

package myPackage.j10Strings;

import java.util.Scanner;

public class CountSubstrings {

  static int numOfStrings(String[] patterns, String word) {
    int n = patterns.length;
    int count = 0;
    for (int i = 0; i < n; i++)
      if (word.indexOf(patterns[i]) != -1)
        count++;
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] patterns = new String[n];
      for (int i = 0; i < n; i++) {
        patterns[i] = sc.next();
      }
      String word = sc.next();
      System.out.println(numOfStrings(patterns, word));
    }
  }
}
