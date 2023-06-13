// Leetcode: 916. Word Subsets

package myPackage.j10Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSubsets {

  static int[] count(String str) {
    int[] res = new int[26];
    int n = str.length();
    for (int i = 0; i < n; i++)
      res[str.charAt(i) - 'a']++;
    return res;
  }

  static String reduceToSingleWord(String[] str) {
    int n = str.length;
    int[] charFreq = new int[26];
    for (int i = 0; i < n; i++) {
      String test = str[i];
      int[] freqCount = count(test);
      for (int j = 0; j < 26; j++)
        charFreq[j] = Math.max(charFreq[j], freqCount[j]);
    }
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (charFreq[i] > 0) {
        while (charFreq[i]-- != 0)
          strB.append((char) ('a' + i));
      }
    }
    return strB.toString();
  }

  static boolean isSubsequence(String str, String test) {
    int n1 = str.length();
    int n2 = test.length();
    if (n1 < n2)
      return false;
    if (str.equals(test))
      return true;
    int p1 = 0;
    int p2 = 0;
    while (p1 < n1 && p2 < n2) {
      if (str.charAt(p1) == test.charAt(p2)) {
        p1++;
        p2++;
      } else {
        p1++;
      }
    }
    return (p2 == n2);
  }

  static List<String> wordSubsets(String[] words1, String[] words2) {
    String test = reduceToSingleWord(words2);
    List<String> result = new ArrayList<>();
    int n = words1.length;
    for (int i = 0; i < n; i++) {
      char[] chTest = words1[i].toCharArray();
      Arrays.sort(chTest);
      String str = new String(chTest);
      if (isSubsequence(str, test))
        result.add(words1[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] str1 = new String[n];
      for (int i = 0; i < str1.length; i++) {
        str1[i] = sc.next();
      }
      int m = sc.nextInt();
      String[] str2 = new String[m];
      for (int i = 0; i < str2.length; i++) {
        str2[i] = sc.next();
      }
      System.out.println(wordSubsets(str1, str2));
    }
  }  
}
