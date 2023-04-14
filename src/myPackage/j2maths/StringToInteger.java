// Leetcode: 8 - String to Integer (atoi)

package myPackage.j2maths;

import java.util.Scanner;

public class StringToInteger {

  static int myAtoi(String s) {
    s = s.trim();
    if (s.length() == 0)
      return 0;

    int num = 0;
    int i = -1;
    String sign = "pos";
    if (s.charAt(0) == '-') {
      sign = "neg";
      ++i;
    }
    if (s.charAt(0) == '+') {
      ++i;
    }

    while (++i < s.length()) {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        int dig = Character.getNumericValue(s.charAt(i));
        if (sign.equals("pos") && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && dig > 7)))
          return Integer.MAX_VALUE;
        if (sign.equals("neg")
            && (num * -1 < Integer.MIN_VALUE / 10 || (num * -1 == Integer.MIN_VALUE / 10 && dig * -1 < -8)))
          return Integer.MIN_VALUE;
        num = num * 10 + dig;
      } else
        break;
    }

    if (sign.equals("pos"))
      return num;
    else
      return num * -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(myAtoi(str));
    }
  }
}