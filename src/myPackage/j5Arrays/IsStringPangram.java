// Leetcode 1832

package myPackage.j5Arrays;

import java.util.Scanner;

public class IsStringPangram {

  static boolean checkIfPangram(String sentence) {
    int[] count = new int[26];
    for (int i = 0; i < sentence.length(); i++) {
      count[Character.getNumericValue(sentence.charAt(i)) - Character.getNumericValue('a')]++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] < 1)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(checkIfPangram(str));
    }
  }
}
