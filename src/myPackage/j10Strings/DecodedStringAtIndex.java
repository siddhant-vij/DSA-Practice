// Leetcode: 880. Decoded String at Index

package myPackage.j10Strings;

import java.util.Scanner;

public class DecodedStringAtIndex {

  static String decodeAtIndex(String str, int k) {
    long size = 0;
    int n = str.length();
    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      if (ch >= '0' && ch <= '9')
        size *= ch - '0';
      else
        size++;
    }
    for (int i = n - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      k %= size;
      if (k == 0 && ch >= 'a' && ch <= 'z')
        return String.valueOf(ch);
      if (ch >= '0' && ch <= '9')
        size /= ch - '0';
      else
        size--;
    }
    return "";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int k = sc.nextInt();
      System.out.println(decodeAtIndex(str, k));
    }
  }  
}
