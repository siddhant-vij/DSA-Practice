// Leetcode: 2165 - Smallest Value of the Rearranged Number

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestNumber {

  static long smallestNumber(long num) {
    if (num == 0) {
      return 0;
    }
    boolean isNegative = num < 0;
    num = num < 0 ? num * -1 : num;

    char[] c = String.valueOf(num).toCharArray();
    Arrays.sort(c);
    String str;
    if (!isNegative) {
      int non = 0;
      for (; non < c.length; non++) {
        if (c[non] != '0') {
          break;
        }
      }
      char temp = c[non];
      c[non] = c[0];
      c[0] = temp;
      str = new String(c);
    } else {
      str = new String(c);
      StringBuilder sb = new StringBuilder(str);
      str = "-".concat(sb.reverse().toString());
    }
    return Long.valueOf(str);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      long N = sc.nextInt();
      System.out.println(smallestNumber(N));
    }
  }
}
