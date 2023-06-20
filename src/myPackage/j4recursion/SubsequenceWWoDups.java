// Practice: String Subsequences With/Without Duplicates

package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubsequenceWWoDups {

  static List<String> result = new ArrayList<>();

  static void subsequenceDups(String up, int index, String p, boolean visited) {
    if (index == up.length()) {
      result.add(p);
      return;
    }
    subsequenceDups(up, index + 1, p, true);
    if (index != 0 && up.charAt(index) == up.charAt(index - 1) && visited == true) {
      return;
    }
    p = p + up.charAt(index);
    subsequenceDups(up, index + 1, p, false);
  }

  static void subsequences(String up, int index, String p) {
    if (index == up.length()) {
      result.add(p);
      return;
    }
    subsequences(up, index + 1, p);
    p = p + up.charAt(index);
    subsequences(up, index + 1, p);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // int x = sc.nextInt();
      // System.out.println("Hello World " + x);
      // String str = "abcde";
      // subsequences(str, 0, "");
      // System.out.println(result);
      String str = "abaac";
      char[] ch = str.toCharArray();
      Arrays.sort(ch);
      str = new String(ch);
      subsequenceDups(str, 0, "", false);
      System.out.println(result);
    }
  }
}
