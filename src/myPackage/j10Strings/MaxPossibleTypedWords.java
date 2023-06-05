// Leetcode: 1935. Maximum Number of Words You Can Type

package myPackage.j10Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxPossibleTypedWords {

  static int canBeTypedWords(String text, String brokenLetters) {
    String[] words = text.split(" ");
    if (brokenLetters.length() == 0)
      return words.length;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < brokenLetters.length(); i++)
      map.put(brokenLetters.charAt(i), map.getOrDefault(brokenLetters.charAt(i), 0) + 1);
    int result = 0;
    for (int i = 0; i < words.length; i++) {
      int count = 0;
      for (int j = 0; j < words[i].length(); j++) {
        if (!map.containsKey(words[i].charAt(j)))
          count++;
      }
      if (count == words[i].length())
        result++;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(canBeTypedWords(str1, str2));
    }
  }  
}
