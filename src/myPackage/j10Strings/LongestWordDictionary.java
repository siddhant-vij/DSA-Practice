// String Practice: Leetcode
// 720. Longest Word in Dictionary
// 524. Longest Word in Dictionary through Deleting

package myPackage.j10Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestWordDictionary {

  static boolean isSubsequence(String x, String y) {
    int j = 0;
    for (int i = 0; i < y.length() && j < x.length(); i++)
      if (x.charAt(j) == y.charAt(i))
        j++;
    return j == x.length();
  }

  static String longestWordII(String s, String[] d) {
    String max_str = "";
    for (String str : d) {
      if (isSubsequence(str, s)) {
        if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
          max_str = str;
      }
    }
    return max_str;
  }

  static String longestWordI(String[] words) {
    Arrays.sort(words);
    Set<String> built = new HashSet<String>();
    String res = "";
    for (String w : words) {
      if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
        res = w.length() > res.length() ? w : res;
        built.add(w);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < n; i++) {
        words[i] = sc.next();
      }
      String test = sc.next();
      System.out.println(longestWordI(words));
      System.out.println(longestWordII(test, words));
    }
  }
}
