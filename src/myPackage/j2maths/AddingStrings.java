// Leetcode: 415. Add Strings

package myPackage.j2maths;

import java.util.Scanner;

public class AddingStrings {

  static String addStrings(String num1, String num2) {
    StringBuilder strB = new StringBuilder();
    int p1 = num1.length() - 1;
    int p2 = num2.length() - 1;
    int carry = 0;
    while (p1 >= 0 || p2 >= 0) {
      if (p1 >= 0 && p2 >= 0) {
        int sum = carry + (num1.charAt(p1) - '0') + (num2.charAt(p2) - '0');
        if (sum <= 9) {
          carry = sum / 10;
          strB.append(sum);
          p1--;
          p2--;
        } else {
          carry = sum / 10;
          sum %= 10;
          strB.append(sum);
          p1--;
          p2--;
        }
      } else if (p1 >= 0 && p2 < 0) {
        int sum = carry + (num1.charAt(p1) - '0');
        carry = sum / 10;
        sum %= 10;
        strB.append(sum);
        p1--;
      } else if (p1 < 0 && p2 >= 0) {
        int sum = carry + (num2.charAt(p2) - '0');
        carry = sum / 10;
        sum %= 10;
        strB.append(sum);
        p2--;
      }
    }
    if (carry == 0)
      return strB.reverse().toString();
    strB.append(carry);
    return strB.reverse().toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String a = sc.next();
      String b = sc.next();
      System.out.println(addStrings(a, b));
    }
  }
}
