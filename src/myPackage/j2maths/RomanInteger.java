// Leetcode 13: Roman to Integer
// Leetcode 12: Integer to Roman

package myPackage.j2maths;

import java.util.Scanner;

public class RomanInteger {

  static String intToRoman(int num) {
    String[] symbol = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
    int[] value = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
    String str = "";
    int pv = value.length - 1;
    int ps = symbol.length - 1;
    while (num > 0) {
      while (num - value[pv] > 0) {
        str += symbol[ps];
        num -= value[pv];
      }
      if (num == value[pv]) {
        str += symbol[ps];
        break;
      }
      pv--;
      ps--;
    }
    return str;
  }

  static int search(char[] ch, char c) {
    for (int i = 0; i < ch.length; i++) {
      if (ch[i] == c)
        return i;
    }
    return -1;
  }

  static int romanToInt(String str) {
    char[] symbol = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
    int[] value = { 1, 5, 10, 50, 100, 500, 1000 };
    int num = 0;
    int p = 0;
    while (p < str.length() - 1) {
      int index1 = search(symbol, str.charAt(p));
      int index2 = search(symbol, str.charAt(p + 1));
      if (index1 >= index2) {
        num += value[index1];
        p++;
      } else {
        num -= value[index1];
        num += value[index2];
        p += 2;
      }
    }
    if (p == str.length() - 1) {
      int index = search(symbol, str.charAt(p));
      num += value[index];
    }
    return num;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(romanToInt(str));
      int num = sc.nextInt();
      System.out.println(intToRoman(num));
    }
  }
}
