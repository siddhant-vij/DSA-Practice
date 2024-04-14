package myPackage.j1Basics;

import java.util.Scanner;

public class StrictlyPalindromic {
  static boolean isPalindrome(int n, int b) {
    StringBuilder strB = new StringBuilder();
    while (n != 0) {
      int rem = n % b;
      strB.append(rem);
      n /= b;
    }
    String strO = strB.toString();
    strB.reverse();
    String strN = strB.toString();
    return strO == strN;
  }
  
  static boolean isStrictlyPalindromic(int n) {
    for (int i = 2; i <= n - 2; i++) {
      if (!isPalindrome(n, i))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      System.out.println(isStrictlyPalindromic(x));
    }
  }
}
