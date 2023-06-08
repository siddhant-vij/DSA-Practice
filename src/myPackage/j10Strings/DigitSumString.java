// Leetcode: 2243. Calculate Digit Sum of a String

package myPackage.j10Strings;

import java.util.Scanner;

public class DigitSumString {

  static String digitSum(String s, int k) {
    int n = s.length();
    if (n <= k)
      return s;
    while (true) {
      StringBuilder strB = new StringBuilder();
      for (int i = 0; i < s.length(); i += k) {
        int sum = 0;
        for (int j = i; j < s.length() && j < i + k; j++) {
          sum += (s.charAt(j) - '0');
        }
        strB.append(sum);
      }
      if (strB.length() <= k)
        return strB.toString();
      else
        s = strB.toString();
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int k = sc.nextInt();
      System.out.println(digitSum(str, k));
    }
  }  
}
