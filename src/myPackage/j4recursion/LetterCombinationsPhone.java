// Leetcode: 17. Letter Combinations of a Phone Number

package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsPhone {

  static String[] codes = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

  static List<String> func(String digits) {
    if (digits.length() == 0) {
      List<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    char ch = digits.charAt(0);
    String remStr = digits.substring(1);

    List<String> recResult = func(remStr);
    List<String> thisResult = new ArrayList<>();

    String code = codes[ch - '2'];
    for (int i = 0; i < code.length(); i++) {
      for (String str : recResult) {
        thisResult.add(code.charAt(i) + str);
      }
    }
    return thisResult;
  }

  static List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    return func(digits);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(letterCombinations(str));
    }
  }
}
