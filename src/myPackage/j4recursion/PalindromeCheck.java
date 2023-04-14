package myPackage.j4recursion;

import java.util.Scanner;

public class PalindromeCheck {

  static boolean isPalindrome(String str) {
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      strB.append(str.charAt(str.length() - 1 - i));
    }
    return (strB.toString().equals(str));
  }

  static boolean isPalindromeSpaceEfficient(String str) {
    int left = 0, right = str.length() - 1;
    while (left <= right) {
      if (str.charAt(left) != str.charAt(right))
        return false;
      left++;
      right--;
    }
    return true;
  }

  static boolean isPalindromeRecursive(String str) {
    int left = 0;
    int right = str.length() - 1;
    if ((right - left) == 0 || (right - left) == 1) {
      if (str.charAt(left) != str.charAt(right))
        return false;
      else
        return true;
    } else {
      if (str.charAt(left) != str.charAt(right))
        return false;
      else
        return isPalindromeRecursive(str.substring(left + 1, right));
    }
  }

  static boolean isPalindromeRecursive2(String str, int left, int right) {
    if (left >= right)
      return true;

    return ((str.charAt(left) == str.charAt(right)) && isPalindromeRecursive2(str, left + 1, right - 1));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String test = sc.next();
      System.out.println(isPalindrome(test));
      System.out.println(isPalindromeSpaceEfficient(test));
      System.out.println(isPalindromeRecursive(test));
      System.out.println(isPalindromeRecursive2(test, 0, test.length() - 1));
    }
  }
}