// Leetcode: 520. Detect Capital

package myPackage.j10Strings;

import java.util.Scanner;

public class DetectCapital {

  static boolean detectCapitalUse(String str) {
    return str.matches("[A-Z]*|.[a-z]*");
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(detectCapitalUse(str));
    }
  }
}
