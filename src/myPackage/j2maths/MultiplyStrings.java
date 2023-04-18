// Leetcode: 43 - Multiply Strings

package myPackage.j2maths;

import java.util.Scanner;

public class MultiplyStrings {

  static String removeLeadingZeroes(String str) {
    int index = -1;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != '0') {
        index = i;
        break;
      }
    }
    if (index == -1)
      return "0";
    return str.substring(index);
  }

  static String multiplyStrings(String num1, String num2) {
    StringBuilder n1 = new StringBuilder(num1);
    n1.reverse();
    StringBuilder n2 = new StringBuilder(num2);
    n2.reverse();
    StringBuilder n3 = new StringBuilder();
    int p3 = 0;
    int carry = 0;

    while (p3 < n1.length() + n2.length()) {
      int product = 0;
      for (int p1 = 0; p1 < n1.length(); p1++) {
        for (int p2 = 0; p2 < n2.length(); p2++) {
          if (p1 + p2 == p3) {
            product += (n1.charAt(p1) - '0') * (n2.charAt(p2) - '0');
          }
        }
      }
      product += carry;
      if (product <= 9) {
        carry = product / 10;
        n3.append(product);
        p3++;
      } else {
        carry = product / 10;
        product %= 10;
        n3.append(product);
        p3++;
      }
    }
    String result = removeLeadingZeroes(n3.reverse().toString());
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String a = sc.next();
      String b = sc.next();
      System.out.println(multiplyStrings(a, b));
    }
  }
}
