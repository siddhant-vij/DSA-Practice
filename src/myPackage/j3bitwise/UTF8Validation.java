// Leetcode: 393. UTF-8 Validation

package myPackage.j3bitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UTF8Validation {

  static boolean helperValidUTF8(int flag, String test, int start) {
    int n = test.length();
    if (flag == 1 && (n - start) >= 8) {
      String str = test.substring(start, start + 8);
      return str.charAt(0) == '0';
    } else if (flag == 2 && (n - start) >= 16) {
      String str = test.substring(start, start + 16);
      return (str.charAt(0) == '1' && str.charAt(1) == '1' && str.charAt(2) == '0'
          && str.charAt(8) == '1' && str.charAt(9) == '0');
    } else if (flag == 3 && (n - start) >= 24) {
      String str = test.substring(start, start + 24);
      return (str.charAt(0) == '1' && str.charAt(1) == '1' && str.charAt(2) == '1' && str.charAt(3) == '0'
          && str.charAt(8) == '1' && str.charAt(9) == '0'
          && str.charAt(16) == '1' && str.charAt(17) == '0');
    } else if (flag == 4 && (n - start) >= 32) {
      String str = test.substring(start, start + 32);
      return (str.charAt(0) == '1' && str.charAt(1) == '1' && str.charAt(2) == '1'
          && str.charAt(3) == '1' && str.charAt(4) == '0'
          && str.charAt(8) == '1' && str.charAt(9) == '0'
          && str.charAt(16) == '1' && str.charAt(17) == '0'
          && str.charAt(24) == '1' && str.charAt(25) == '0');
    } else {
      return false;
    }
  }

  static String convertDataToString(int[] arr) {
    int len = arr.length;
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < len; i++) {
      String test = Integer.toBinaryString(arr[i]);
      int n = test.length();
      if (n >= 8)
        strB.append(test.substring(n - 8, n));
      else {
        for (int j = 0; j < 8 - n; j++)
          strB.append('0');
        strB.append(test.substring(0, n));
      }
    }
    return strB.toString();
  }

  static boolean validUtf8(int[] data) {
    String test = convertDataToString(data);
    List<Boolean> bool = new ArrayList<>();
    int n = test.length();
    int count = 0;
    boolean isFirst = true;
    for (int i = 0; i < n;) {
      if (test.charAt(i) == '0') {
        bool.add(helperValidUTF8(1, test, i));
        i += 8;
        count = 0;
        isFirst = false;
      } else {
        count++;
        if (isFirst && count == 1 && test.charAt(i + 1) == '0') {
          return false;
        } else if (count == 2 && test.charAt(i + 1) == '0') {
          bool.add(helperValidUTF8(2, test, i - 1));
          i = i - 1;
          i += 16;
          count = 0;
          isFirst = false;
        } else if (count == 3 && test.charAt(i + 1) == '0') {
          bool.add(helperValidUTF8(3, test, i - 2));
          i = i - 2;
          i += 24;
          count = 0;
          isFirst = false;
        } else if (count == 4 && test.charAt(i + 1) == '0') {
          bool.add(helperValidUTF8(4, test, i - 3));
          i = i - 3;
          i += 32;
          count = 0;
          isFirst = false;
        } else if (count > 4) {
          return false;
        } else {
          i++;
        }
      }
    }
    n = bool.size();
    for (int i = 0; i < n; i++)
      if (bool.get(i) == false)
        return false;
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(validUtf8(arr));
    }
  }
}
