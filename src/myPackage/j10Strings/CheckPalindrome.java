// CodingNinjas: Check If The String Is A Palindrome

package myPackage.j10Strings;

import java.util.Scanner;

public class CheckPalindrome {

  static boolean checkPalindrome(String str) {
    int n = str.length();
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
        if ((ch >= 'A' && ch <= 'Z'))
          ch = (char) (ch + 'a' - 'A');
        strB.append(ch);
      }
    }
    char[] chArr = strB.toString().toCharArray();
    int s = 0;
    int e = chArr.length - 1;
    while (s < e) {
      if (chArr[s] != chArr[e])
        return false;
      s++;
      e--;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(checkPalindrome(str));
    }
  }
}
