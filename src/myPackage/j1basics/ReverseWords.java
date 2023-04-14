// Leetcode: 151 - Reverse Words in a String

package myPackage.j1basics;

import java.util.Scanner;

public class ReverseWords {

  static String reverseWords(String s) {
    s = s.trim();
    String[] strArr = s.split(" ");
    int start = 0;
    int end = strArr.length - 1;
    while (start < end) {
      String temp = strArr[end];
      strArr[end] = strArr[start];
      strArr[start] = temp;
      start++;
      end--;
    }
    String result = "";
    for (int i = 0; i < strArr.length - 1; i++) {
      if (!strArr[i].trim().isEmpty()) {
        result += strArr[i] + " ";
      }
    }
    return result + strArr[strArr.length - 1];
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(reverseWords(str));
    }
  }
}