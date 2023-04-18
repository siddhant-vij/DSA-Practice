// Leetcode: 67 - Add Binary

package myPackage.j2maths;

import java.util.Scanner;

public class AddingBinary {

  static String addBinary(String a, String b) {
    int p1 = a.length() - 1;
    int p2 = b.length() - 1;
    int carry = 0;
    StringBuilder strB = new StringBuilder();
    while (p1 >= 0 || p2 >= 0) {
      if (p1 >= 0 && p2 >= 0) {
        int sum = carry + (a.charAt(p1) - '0') + (b.charAt(p2) - '0');
        carry = sum / 2;
        sum %= 2;
        strB.append(sum);
        p1--;
        p2--;
      } else if (p1 >= 0 && p2 < 0) {
        int sum = carry + (a.charAt(p1) - '0');
        carry = sum / 2;
        sum %= 2;
        strB.append(sum);
        p1--;
      } else if (p2 >= 0 && p1 < 0) {
        int sum = carry + (b.charAt(p2) - '0');
        carry = sum / 2;
        sum %= 2;
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
      System.out.println(addBinary(a, b));
    }
  }
}
