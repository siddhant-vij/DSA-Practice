// Leetcode: 1545. Find Kth Bit in Nth Binary String

package myPackage.j4recursion;

import java.util.Scanner;

public class KthBitInNthBinaryString {

  static String invert(String str) {
    char[] ch = str.toCharArray();
    int n = ch.length;
    for (int i = 0; i < n; i++) {
      if (ch[i] == '1')
        ch[i] = '0';
      else
        ch[i] = '1';
    }
    return new String(ch);
  }

  static String reverse(String str) {
    char[] ch = str.toCharArray();
    int s = 0;
    int e = ch.length - 1;
    while (s < e) {
      char temp = ch[s];
      ch[s] = ch[e];
      ch[e] = temp;
      s++;
      e--;
    }
    return new String(ch);
  }

  static String helper(int n) {
    if (n == 1) {
      return "0";
    }
    StringBuilder strB = new StringBuilder();
    String test = helper(n - 1);
    strB.append(test);
    strB.append("1");
    strB.append(reverse(invert(test)));
    return strB.toString();
  }

  static char findKthBit(int n, int k) {
    return helper(n).charAt(k - 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      System.out.println(findKthBit(n, k));
    }
  }
}
